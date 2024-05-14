<template>
  <div class="container">
    <Breadcrumb :items="['menu.exam', 'menu.exam.paperManager']" />
    <a-card
      style="height: 650px"
      class="general-card"
      :title="$t('menu.exam.paperManager')"
    >
      <!--查询栏-->
      <div>
        <a-row :gutter="5" style="margin-bottom: 16px">
          <!--试卷标题-->
          <a-col :span="6">
            <a-input
              v-model="paperSearch.titleFuzzy"
              :placeholder="$t('paperManager.placeholder.title')"
              style="width: 250px"
            />
          </a-col>
          <!--学科-->
          <a-col :span="6">
            <a-tree-select
              v-model="paperSearch.subjectId"
              :data="subjectTree"
              :field-names="{
                key: 'id',
                title: 'title',
                children: 'children',
              }"
              style="width: 250px"
              placeholder="请选择学科"
              allow-clear
            />
          </a-col>
          <!--组卷方式-->
          <a-col :span="6">
            <a-select
              v-model="paperSearch.joinType"
              :placeholder="$t('paperManager.placeholder.joinType')"
              style="width: 250px"
              allow-clear
            >
              <a-option value="0">随机抽取</a-option>
              <a-option value="1">指定选题</a-option>
            </a-select>
          </a-col>
        </a-row>
        <a-row :gutter="5" style="margin-bottom: 16px">
          <!--所属部门-->
          <a-col :span="6">
            <a-tree-select
              v-model="paperSearch.deptCodeFuzzy"
              :placeholder="$t('paperManager.placeholder.deptCode')"
              :data="deptTree"
              allow-clear
              style="width: 250px"
              :field-names="{
                key: 'deptCode',
                title: 'deptName',
                children: 'children',
              }"
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
          <!--只差看自己的-->
          <a-col :span="6">
            <a-checkbox @change="onlyMyCreate">只查看我创建的</a-checkbox>
          </a-col>
        </a-row>
      </div>
      <a-row style="margin-bottom: 16px; margin-top: 20px">
        <a-col :span="12">
          <a-space>
            <a-button type="primary" @click="addPaperVisible = true">
              <template #icon>
                <icon-plus />
              </template>
              添加
            </a-button>
          </a-space>
        </a-col>
      </a-row>
      <a-table
        row-key="id"
        :loading="loading"
        :columns="columns"
        :data="paperList"
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
        <template #joinType="{ record }">
          <template v-if="record.joinType === 0">题库抽取</template>
          <template v-if="record.joinType === 1">指定选题</template>
        </template>
        <template #option="{ record }">
          <a-space>
            <a-button type="primary" @click="handlePreview(record)">
              <template #icon>
                <icon-eye />
              </template>
              {{ $t('paperManager.columns.options.preview') }}
            </a-button>
            <a-button type="primary" @click="handleEdit(record)">
              {{ $t('paperManager.columns.options.edit') }}
            </a-button>
            <a-button
              type="primary"
              status="danger"
              @click="handleDelete(record.id)"
            >
              {{ $t('paperManager.columns.options.delete') }}
            </a-button>
          </a-space>
        </template>
      </a-table>
    </a-card>
    <!--添加试卷模态框-->
    <a-modal
      v-model:visible="addPaperVisible"
      :footer="false"
      @cancel="addPaperVisible = false"
    >
      <a-form :model="form" @submit="goAdd">
        <a-form-item
          field="title"
          label="试卷名称"
          placeholder="请输入试卷名称"
          :rules="[{ required: true, message: '试卷名称不能为空' }]"
        >
          <a-input v-model="form.title"></a-input>
        </a-form-item>
        <a-form-item
          field="subjectId"
          label="学科分类"
          placeholder="请选择学科分类"
          :rules="[{ required: true, message: '学科分类不能为空' }]"
        >
          <a-tree-select
            v-model="form.subjectId"
            :data="subjectTree"
            :field-names="{
              key: 'id',
              title: 'title',
              children: 'children',
            }"
            placeholder="请选择学科"
          />
        </a-form-item>
        <a-form-item
          field="deptCode"
          label="所属部门"
          placeholder="请选择所属部门"
          :rules="[{ required: true, message: '所属部门不能为空' }]"
        >
          <a-tree-select
            v-model="form.deptCode"
            placeholder="选择题库所属部门"
            :data="deptTree"
            :field-names="{
              key: 'deptCode',
              title: 'deptName',
              children: 'children',
            }"
          />
        </a-form-item>
        <a-form-item
          field="joinType"
          label="组卷方式"
          placeholder="请选择组卷方式"
          :rules="[{ required: true, message: '组卷方式不能为空' }]"
        >
          <a-radio-group v-model="form.joinType">
            <a-radio :value="0">抽题组卷</a-radio>
            <a-radio :value="1">指定选题</a-radio>
          </a-radio-group>
        </a-form-item>
        <a-form-item>
          <a-space>
            <a-button type="primary" html-type="goAdd">确认</a-button>
            <a-button type="primary" @click="addPaperVisible = false"
              >取消</a-button
            >
          </a-space>
        </a-form-item>
      </a-form>
    </a-modal>
  </div>
</template>

<script lang="ts" setup>
  import { onMounted, ref, watch } from 'vue';
  import { useI18n } from 'vue-i18n';
  import useLoading from '@/hooks/loading';
  import { useRouter } from 'vue-router';
  import { TableColumnData } from '@arco-design/web-vue/es/table/interface';
  import { Message, Modal } from '@arco-design/web-vue';
  import { Paper } from '@/types/model/po/Paper';
  import { deletePaperById, getPaperList } from '@/api/paper';
  import PaperQuery from '@/types/model/query/PaperQuery';
  import { SubjectTreeVO } from '@/types/model/vo/SubjectTreeVO';
  import { getSubjectTree } from '@/api/subject';
  import { DepartmentTreeVO } from '@/types/model/vo/DepartmentTreeVO';
  import { getDeptTree } from '@/api/department';
  import { useUserStore } from '@/store';
  import usePagination from '@/hooks/pagination';
  import OperLogQuery from '@/types/model/query/OperLogQuery';
  import SimplePage from '@/types/model/po/SimplePage';

  const { loading, setLoading } = useLoading(true);
  const { pagination, setPagination } = usePagination();

  const { t } = useI18n();

  const userStore = useUserStore();
  const router = useRouter();

  // 添加试卷表单
  const form = ref({
    title: '',
    subjectId: '',
    joinType: '',
    deptCode: '',
  });
  // 学科树
  const subjectTree = ref<SubjectTreeVO[]>([]);

  // 部门树
  const deptTree = ref<DepartmentTreeVO[]>([]);

  // 添加试卷模态框开关
  const addPaperVisible = ref<boolean>(false);

  // 试卷列表
  const paperList = ref<Paper[]>([]);

  // 查询表单
  const paperSearch = ref<PaperQuery>(new PaperQuery());

  // 获取试卷列表
  const reloadPaperList = async (paperQuery: PaperQuery) => {
    setLoading(true);
    await getPaperList(paperQuery).then((res: any) => {
      paperList.value = res.data.list;
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
    await reloadPaperList(paperSearch.value);
    await getSubjectTree().then((res: any) => {
      subjectTree.value = res.data;
    });
    await getDeptTree().then((res: any) => {
      deptTree.value = res.data;
    });
  });

  // 页码变化
  const pageChange = (pageNo: number) => {
    paperSearch.value.pageNo = pageNo;
  };
  // 每页数据量变化
  const pageSizeChange = (pageSize: number) => {
    paperSearch.value.pageSize = pageSize;
  };

  // 表头列名
  const columns = ref<TableColumnData[]>([
    {
      title: t('paperManager.columns.title'),
      dataIndex: 'title',
      slotName: 'title',
      width: 100,
      tooltip: true,
    },
    {
      title: t('paperManager.columns.joinType'),
      dataIndex: 'joinType',
      slotName: 'joinType',
      width: 100,
    },
    {
      title: t('paperManager.columns.quCount'),
      dataIndex: 'quCount',
      slotName: 'quCount',
      width: 100,
    },
    {
      title: t('paperManager.columns.totalCount'),
      dataIndex: 'totalCount',
      slotName: 'totalCount',
      width: 100,
    },
    {
      title: t('paperManager.columns.createTime'),
      dataIndex: 'createTime',
    },
    {
      title: t('paperManager.columns.options'),
      dataIndex: 'option',
      slotName: 'option',
      width: 300,
    },
  ]);

  // 只查看我创建的试卷
  const onlyMyCreate = (flag: any) => {
    if (flag) {
      paperSearch.value.createBy = userStore.id;
    } else {
      paperSearch.value.createBy = '';
    }
  };

  // 预览试卷
  const handlePreview = (record: any) => {
    router.push({
      path: '/exam/preview-paper',
      query: {
        id: record.id,
      },
    });
  };

  // 添加试卷
  const goAdd = (call: any) => {
    if (!call.errors) {
      router.push({
        name: 'AddPaper',
        params: {
          title: form.value.title,
          joinType: form.value.joinType,
          subjectId: form.value.subjectId,
          deptCode: form.value.deptCode,
        },
      });
    } else {
      console.log('失败', call.values);
    }
  };

  // 编辑
  const handleEdit = (record: any) => {
    router.push({
      path: '/exam/modify-paper',
      query: {
        id: record.id,
      },
    });
  };

  // 删除
  const handleDelete = async (id: string) => {
    Modal.warning({
      title: '警告',
      content: '确认删除该试卷？',
      hideCancel: false,
      onOk: async () => {
        await deletePaperById(id).then(async (res: any) => {
          if (res.data === true) {
            Message.success({
              content: '删除成功',
            });
          } else {
            Message.error({
              content: '删除失败',
            });
          }
          await reloadPaperList(pagination.value);
        });
      },
    });
  };

  // 搜索
  const search = async () => {
    await reloadPaperList(paperSearch.value);
  };

  // 重置
  const reset = async () => {
    paperSearch.value = new PaperQuery();
    pagination.value = new SimplePage();
    await reloadPaperList(paperSearch.value);
  };

  // 监视页码变化
  watch(
    () => [paperSearch.value.pageNo, paperSearch.value.pageSize],
    async (newValue, oldValue) => {
      await reloadPaperList(paperSearch.value);
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
