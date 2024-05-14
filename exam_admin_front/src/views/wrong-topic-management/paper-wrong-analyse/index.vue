<template>
  <div class="container">
    <Breadcrumb
      :items="['menu.wrongManage', 'menu.wrongManage.paperWrongAnalyse']"
    />

    <a-card
      style="height: 650px"
      class="general-card"
      :title="$t('menu.wrongManage.paperList')"
    >
      <!--查询栏-->
      <a-space>
        <!--试卷标题-->
        <a-input
          v-model="paperSearch.titleFuzzy"
          :placeholder="$t('paperManager.placeholder.title')"
          style="width: 200px"
        />
        <!--学科-->
        <a-tree-select
          v-model="paperSearch.subjectId"
          :data="subjectTree"
          :field-names="{
            key: 'id',
            title: 'title',
            children: 'children',
          }"
          style="width: 200px"
          placeholder="请选择学科"
          allow-clear
        />
        <!--组卷方式-->
        <a-select
          v-model="paperSearch.joinType"
          :placeholder="$t('paperManager.placeholder.joinType')"
          style="width: 200px"
          allow-clear
        >
          <a-option value="0">随机抽取</a-option>
          <a-option value="1">指定选题</a-option>
        </a-select>

        <!--所属部门-->
        <a-tree-select
          v-model="paperSearch.deptCodeFuzzy"
          :placeholder="$t('paperManager.placeholder.deptCode')"
          :data="deptTree"
          allow-clear
          style="width: 200px"
          :field-names="{
            key: 'deptCode',
            title: 'deptName',
            children: 'children',
          }"
        />

        <!--搜索重置按钮-->
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
      </a-space>
      <a-table
        style="margin-top: 10px"
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
            <a-button type="primary" @click="handleDetail(record.id)">
              <template #icon>
                <icon-eye />
              </template>
              试卷错题分析
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
  import { Paper } from '@/types/model/po/Paper';
  import { getPaperList } from '@/api/paper';
  import PaperQuery from '@/types/model/query/PaperQuery';
  import { SubjectTreeVO } from '@/types/model/vo/SubjectTreeVO';
  import { getSubjectTree } from '@/api/subject';
  import { DepartmentTreeVO } from '@/types/model/vo/DepartmentTreeVO';
  import { getDeptTree } from '@/api/department';
  import usePagination from '@/hooks/pagination';
  import ExamQuery from '@/types/model/query/ExamQuery';
  import SimplePage from '@/types/model/po/SimplePage';

  const { loading, setLoading } = useLoading(true);
  const { pagination, setPagination } = usePagination();

  const { t } = useI18n();

  const router = useRouter();

  // 学科树
  const subjectTree = ref<SubjectTreeVO[]>([]);

  // 部门树
  const deptTree = ref<DepartmentTreeVO[]>([]);

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

  // 搜索
  const search = async () => {
    await reloadPaperList({ ...pagination.value, ...paperSearch.value });
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

  const handleDetail = (paperId: string) => {
    router.push({
      name: 'PaperWrongDetail',
      params: {
        paperId,
      },
    });
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
