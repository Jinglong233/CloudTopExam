<template>
  <div class="container">
    <Breadcrumb :items="['menu.repo', 'menu.repo.quManager']" />
    <a-card
      style="height: 650px"
      class="general-card"
      :title="$t('menu.repo.quManager')"
    >
      <!--查询栏-->
      <a-space>
        <!--题目内容-->
        <a-input
          v-model="quSearch.contentFuzzy"
          :placeholder="$t('quManager.placeholder.content')"
          style="width: 250px"
          @input="handleChange"
        />
        <!--题型-->
        <a-select
          v-model="quSearch.quType"
          :placeholder="$t('quManager.placeholder.quType')"
          allow-clear
          style="width: 250px"
          @change="handleChange"
        >
          <a-option value="1">单选题</a-option>
          <a-option value="2">多选题</a-option>
          <a-option value="3">判断题</a-option>
          <a-option value="4">填空题</a-option>
          <a-option value="5">简答题</a-option>
        </a-select>

        <!--题库-->
        <a-select
          v-model="quSearch.repoId"
          :placeholder="$t('quManager.placeholder.repo')"
          allow-clear
          style="width: 250px"
          @change="handleChange"
        >
          <a-option v-for="repo in repoList" :key="repo.id" :value="repo.id">
            {{ repo.title }}
          </a-option>
        </a-select>
      </a-space>
      <a-row style="margin-bottom: 16px; margin-top: 16px">
        <a-col :span="12">
          <a-space>
            <a-button type="primary" @click="goAdd">
              <template #icon>
                <icon-plus />
              </template>
              添加
            </a-button>
            <a-upload
              action="http://localhost:8088/api/qu/importQu"
              :headers="{
                Authorization: userStore.token,
              }"
              name="file"
              :show-file-list="false"
              @success="handleSuccess"
              @error="handleError"
            >
              <template #icon>
                <icon-download />
              </template>
              {{ $t('quManager.operation.import') }}
            </a-upload>
            <a-upload action="/">
              <template #upload-button>
                <a-button>
                  {{ $t('quManager.operation.derive') }}
                </a-button>
              </template>
            </a-upload>
          </a-space>
        </a-col>
      </a-row>
      <a-table
        row-key="id"
        :loading="loading"
        :columns="columns"
        :data="quList"
        :bordered="false"
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
              @click="handleDelete(record.id)"
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
  import { onMounted, ref, toRaw } from 'vue';
  import { useI18n } from 'vue-i18n';
  import useLoading from '@/hooks/loading';
  import { useRouter } from 'vue-router';
  import { TableColumnData } from '@arco-design/web-vue/es/table/interface';
  import { QuQuery } from '@/types/model/query/QuQuery';
  import { getRepoList } from '@/api/repo';
  import { Repo } from '@/types/model/po/Repo';
  import { deleteQuById, getQuList } from '@/api/qu';
  import { Qu } from '@/types/model/po/Qu';
  import { Message, Modal } from '@arco-design/web-vue';
  import { FileItem } from '@arco-design/web-vue/es/upload/interfaces';
  import { useUserStore } from '@/store';
  import { getQuestionTypeName } from '../../../api/common';

  const { loading, setLoading } = useLoading(true);
  const { t } = useI18n();

  const userStore = useUserStore();
  const token = ref();

  // 题目列表
  const quList = ref<Qu[]>([]);

  // 题库列表
  const repoList = ref<Repo[]>([]);

  // 查询表单
  const quSearch = ref<QuQuery>({});

  const router = useRouter();

  // 获取题库列表
  const reloadRepoList = async () => {
    setLoading(true);
    await getRepoList({}).then((res: any) => {
      repoList.value = res.data;
      setLoading(false);
    });
  };
  // 获取题目列表
  const reloadQuList = async () => {
    setLoading(true);
    // 获取题目列表
    await getQuList({}).then((res: any) => {
      quList.value = res.data.list;
      setLoading(false);
    });
  };
  onMounted(async () => {
    await reloadQuList();
    await reloadRepoList();
    token.value = userStore.token;
    console.log('userStore', toRaw(userStore.token));
  });

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

  // 查询题目
  const handleChange = async () => {
    await getQuList(quSearch.value).then((res: any) => {
      quList.value = res.data.list;
    });
  };

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
  const handleDelete = async (id: string) => {
    Modal.warning({
      title: '警告',
      content: '确认删除该题目？',
      hideCancel: false,
      onOk: async () => {
        await deleteQuById(id).then(async (res: any) => {
          if (res.data === true) {
            Message.success({
              content: '删除成功',
            });
          } else {
            Message.error({
              content: '删除失败',
            });
          }
          await reloadQuList();
        });
      },
    });
  };

  // 文件上传成功回调函数
  const handleSuccess = (item: FileItem) => {
    console.log('success', item);
  };
  // 文件上传失败回调函数
  const handleError = (item: FileItem) => {
    console.log('error', item);
  };
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
