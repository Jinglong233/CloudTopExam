<template>
  <div class="container">
    <Breadcrumb :items="['menu.repo', 'menu.repo.quManager']" />
    <a-card
      style="height: 750px"
      class="general-card"
      :title="$t('menu.repo.quManager')"
    >
      <!--查询栏-->
      <div>
        <a-row :gutter="10">
          <!--题目内容-->
          <a-col :span="6">
            <a-input
              v-model="quSearch.contentFuzzy"
              :placeholder="$t('quManager.placeholder.content')"
              style="width: 250px"
              :allow-clear="true"
            />
          </a-col>
          <!--题型-->
          <a-col :span="6">
            <a-select
              v-model="quSearch.quType"
              :placeholder="$t('quManager.placeholder.quType')"
              allow-clear
              style="width: 250px"
            >
              <a-option value="1">单选题</a-option>
              <a-option value="2">多选题</a-option>
              <a-option value="3">判断题</a-option>
              <a-option value="4">填空题</a-option>
              <a-option value="5">简答题</a-option>
            </a-select>
          </a-col>
          <!--题库-->
          <a-col :span="6">
            <a-select
              v-model="quSearch.repoId"
              :placeholder="$t('quManager.placeholder.repo')"
              allow-clear
              style="width: 250px"
            >
              <a-option
                v-for="repo in repoList"
                :key="repo.id"
                :value="repo.id"
              >
                {{ repo.title }}
              </a-option>
            </a-select>
          </a-col>
        </a-row>
        <div style="margin: 10px 0" />
        <a-row :gutter="10">
          <!--知识点-->
          <a-col :span="6">
            <a-input
              v-model="quSearch.knowledgeFuzzy"
              :placeholder="$t('quManager.placeholder.knowledge')"
              style="width: 250px"
              :allow-clear="true"
            />
          </a-col>

          <!--搜索重置按钮-->
          <a-col :span="6">
            <a-button type="primary" style="margin: 0 5px" @click="search">
              <template #icon>
                <icon-search />
              </template>
              搜索
            </a-button>
            <a-button type="primary" style="margin: 0 5px" @click="reset">
              <template #icon>
                <icon-refresh />
              </template>
              重置
            </a-button>
          </a-col>
        </a-row>
      </div>
      <a-row style="margin-bottom: 16px; margin-top: 16px">
        <a-col :span="12">
          <a-space>
            <a-button type="primary" @click="goAdd">
              <template #icon>
                <icon-plus />
              </template>
              添加
            </a-button>
            <!--批量导入题目对话框-->
            <a-button type="primary" @click="handleClick()"> 导入 </a-button>
            <a-modal v-model:visible="importVisible" :footer="false">
              <template #title> 批量导入 </template>
              <div>
                <a-select
                  :style="{ width: '320px' }"
                  placeholder="请选择题库"
                  @change="uploadRepoChange"
                >
                  <a-option
                    v-for="repo in repoList"
                    :key="repo.id"
                    :value="repo.id"
                  >
                    {{ repo.title }}
                  </a-option>
                </a-select>
              </div>
              <div>
                <!--文件上传组件-->
                <a-upload
                  ref="uploadRef"
                  action="http://localhost:8088/api/qu/importQu"
                  :auto-upload="false"
                  accept="pdf"
                  :headers="{
                    Authorization: userStore.token,
                  }"
                  :data="{ repoId: uploadRepo }"
                  name="file"
                  @success="handleSuccess"
                  @error="handleError"
                >
                  <template #icon>
                    <icon-download />
                  </template>
                  <template #upload-button>
                    <a-space>
                      <a-button> 选择文件</a-button>
                    </a-space>
                  </template>
                  {{ $t('quManager.operation.import') }}
                </a-upload>
              </div>
            </a-modal>
            <!--<a-button type="primary">-->
            <!--  {{ $t('quManager.operation.derive') }}-->
            <!--</a-button>-->
          </a-space>
        </a-col>
      </a-row>
      <a-table
        row-key="id"
        :loading="loading"
        :columns="columns"
        :data="quList"
        :bordered="false"
        :scrollbar="true"
        :pagination="{
          showTotal: true,
          showPageSize: true,
          total: pagination.total,
          pageSize: pagination.pageSize,
          current: pagination.pageNo,
        }"
        :scroll="{ x: 100, y: 400 }"
        @page-change="pageChange"
        @page-size-change="pageSizeChange"
      >
        <template #quType="{ record }">
          {{ getQuestionTypeName(Number(record.quType)) }}
        </template>
        <template #level="{ record }">
          <template v-if="record.level === 1">困难</template>
          <template v-if="record.level === 0">简单</template>
        </template>
        <template #option="{ record }">
          <a-space>
            <a-button type="primary" @click="handleEdit(record)">
              {{ $t('quManager.columns.edit') }}
            </a-button>
            <a-button
              type="primary"
              status="danger"
              @click="handleDelete(record)"
            >
              {{ $t('quManager.columns.delete') }}
            </a-button>
          </a-space>
        </template>
      </a-table>
    </a-card>
  </div>
</template>

<script lang="ts" setup>
  import { onMounted, ref, watch } from 'vue';
  import { useI18n } from 'vue-i18n';
  import useLoading from '@/hooks/loading';
  import { useRouter } from 'vue-router';
  import { TableColumnData } from '@arco-design/web-vue/es/table/interface';
  import QuQuery from '@/types/model/query/QuQuery';
  import { getRepoList } from '@/api/repo';
  import { Repo } from '@/types/model/po/Repo';
  import { deleteQuById, getQuList } from '@/api/qu';
  import Qu from '@/types/model/po/Qu';
  import { Message, Modal } from '@arco-design/web-vue';
  import { FileItem } from '@arco-design/web-vue/es/upload/interfaces';
  import { useUserStore } from '@/store';
  import RepoQuery from '@/types/model/query/RepoQuery';
  import usePagination from '@/hooks/pagination';
  import SimplePage from '@/types/model/po/SimplePage';
  import { deleteBatchImage } from '@/api/ossUpload';
  import { getImgUrl, getQuestionTypeName } from '../../../utils/common';

  const { loading, setLoading } = useLoading(true);
  const { pagination, setPagination } = usePagination();

  const { t } = useI18n();

  // 批量导入题目对话框
  const importVisible = ref(false);

  const userStore = useUserStore();
  const token = ref();

  // 题目列表
  const quList = ref<Qu[]>([]);

  // 题库列表
  const repoList = ref<Repo[]>([]);

  // 查询表单
  const quSearch = ref<QuQuery>(new QuQuery());

  // 选择的上传题库
  const uploadRepo = ref<string>('');

  const uploadRef = ref();

  const router = useRouter();

  // 获取题库列表
  const reloadRepoList = async () => {
    setLoading(true);
    await getRepoList({} as RepoQuery).then((res: any) => {
      repoList.value = res.data.list;
      setLoading(false);
    });
  };
  // 获取题目列表
  const reloadQuList = async (arg: QuQuery) => {
    setLoading(true);
    // 获取题目列表
    await getQuList(arg).then((res: any) => {
      quList.value = res.data.list;
      setPagination({
        total: res.data.totalCount,
        pageSize: res.data.pageSize,
        pageNo: res.data.pageNo,
        pageTotal: res.data.pageTotal,
      });
    });
    setLoading(false);
  };
  onMounted(async () => {
    await reloadQuList(quSearch.value);
    await reloadRepoList();
    token.value = userStore.token;
    // 上传题目默认是第一个题库
    if (repoList.value && repoList.value.length !== 0) {
      uploadRepo.value = repoList.value[0] as string;
    }
  });

  // 页码变化
  const pageChange = (pageNo: number) => {
    quSearch.value.pageNo = pageNo;
  };
  // 每页数据量变化
  const pageSizeChange = (pageSize: number) => {
    quSearch.value.pageSize = pageSize;
  };

  const handleClick = () => {
    uploadRef.value = null;
    importVisible.value = true;
  };
  // 表头列名
  const columns = ref<TableColumnData[]>([
    {
      title: t('quManager.columns.content'),
      dataIndex: 'content',
      slotName: 'content',
      width: 200,
      ellipsis: true,
    },
    {
      title: t('quManager.columns.repoText'),
      dataIndex: 'repoText',
      slotName: 'repoText',
    },
    {
      title: t('quManager.columns.quType'),
      dataIndex: 'quType',
      slotName: 'quType',
    },
    {
      title: t('quManager.columns.level'),
      dataIndex: 'level',
      slotName: 'level',
    },
    {
      title: t('quManager.columns.createTime'),
      dataIndex: 'createTime',
    },
    {
      title: t('quManager.columns.options'),
      dataIndex: 'option',
      slotName: 'option',
      width: 180,
    },
  ]);

  // 添加题目
  const goAdd = () => {
    router.push({
      path: '/repo/add-qu',
    });
  };

  // 编辑
  const handleEdit = (record: any) => {
    router.push({
      path: '/repo/modify-qu',
      query: {
        id: record.id,
      },
    });
  };

  // 删除
  const handleDelete = async (record: any) => {
    Modal.warning({
      title: '警告',
      content: '确认删除该题目？',
      hideCancel: false,
      onOk: async () => {
        // 删除关联的图片资源（如果有）
        const deleteImgList = getImgUrl(record.content);
        if (deleteImgList.length > 0) {
          await deleteBatchImage(deleteImgList);
        }
        await deleteQuById(record.id).then(async (res: any) => {
          if (res.data === true) {
            Message.success({
              content: '删除成功',
            });
          } else {
            Message.error({
              content: '删除失败',
            });
          }
          await reloadQuList(quSearch.value);
        });
      },
    });
  };

  // 文件上传成功回调函数
  const handleSuccess = (item: FileItem) => {
    Message.success({
      content: '上传成功',
      duration: 2000,
    });
  };
  // 文件上传失败回调函数
  const handleError = (item: FileItem) => {
    Message.error({
      content: '上传失败',
      duration: 2000,
    });
  };

  // 题目批量导入选择的题库改变的时候触发
  const uploadRepoChange = (repo: any) => {
    uploadRepo.value = repo;
  };

  // 搜索
  const search = async () => {
    await reloadQuList(quSearch.value);
  };

  // 重置
  const reset = async () => {
    quSearch.value = new QuQuery();
    pagination.value = new SimplePage();
    await reloadQuList(quSearch.value);
  };

  // 监视页码变化
  watch(
    () => [quSearch.value.pageNo, quSearch.value.pageSize],
    async (newValue, oldValue) => {
      await reloadQuList(quSearch.value);
    }
  );
</script>

<style scoped lang="less">
  .container {
    padding: 0 20px 20px 20px;
  }

  :deep(.arco-table-th) {
    &:last-child {
      .arco-table-th-item-title {
        margin-left: 16px;
      }
    }
  }

  .action-icon {
    margin-left: 12px;
    cursor: pointer;
  }

  .active {
    color: #0960bd;
    background-color: #e3f4fc;
  }

  .setting {
    display: flex;
    align-items: center;
    width: 200px;

    .title {
      margin-left: 12px;
      cursor: pointer;
    }
  }
</style>
