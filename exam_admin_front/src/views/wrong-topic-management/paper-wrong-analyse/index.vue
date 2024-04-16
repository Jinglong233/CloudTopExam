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
          style="width: 320px"
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
          style="width: 250px"
          placeholder="请选择学科"
          allow-clear
        />
        <!--组卷方式-->
        <a-select
          v-model="paperSearch.joinType"
          :placeholder="$t('paperManager.placeholder.joinType')"
          style="width: 250px"
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
          style="width: 250px"
          :field-names="{
            key: 'deptCode',
            title: 'deptName',
            children: 'children',
          }"
        />
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
          total: pageInfo.total,
          pageSize: pageInfo.pageSize,
          current: pageInfo.pageNo,
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
  import { PaperQuery } from '@/types/model/query/PaperQuery';
  import { SubjectTreeVO } from '@/types/model/vo/SubjectTreeVO';
  import { getSubjectTree } from '@/api/subject';
  import { DepartmentTreeVO } from '@/types/model/vo/DepartmentTreeVO';
  import { getDeptTree } from '@/api/department';
  import { SimplePage } from '@/types/model/po/SimplePage';

  const { loading, setLoading } = useLoading(true);
  const { t } = useI18n();

  const router = useRouter();

  // 分页信息
  const pageInfo = ref<SimplePage>({
    pageNo: 1,
    pageSize: 10,
    pageTotal: 0,
    total: 0,
  });

  // 学科树
  const subjectTree = ref<SubjectTreeVO[]>([]);

  // 部门树
  const deptTree = ref<DepartmentTreeVO[]>([]);

  // 试卷列表
  const paperList = ref<Paper[]>([]);

  // 查询表单
  const paperSearch = ref<PaperQuery>({});

  // 获取试卷列表
  const reloadPaperList = async (paperQuery: PaperQuery) => {
    setLoading(true);
    await getPaperList(paperQuery).then((res: any) => {
      paperList.value = res.data.list;
      pageInfo.value.total = res.data.totalCount;
      pageInfo.value.pageSize = res.data.pageSize;
      pageInfo.value.pageNo = res.data.pageNo;
      pageInfo.value.pageTotal = res.data.pageTotal;
    });
    setLoading(false);
  };
  onMounted(async () => {
    await reloadPaperList({ ...pageInfo.value });
    await getSubjectTree().then((res: any) => {
      subjectTree.value = res.data;
    });
    await getDeptTree().then((res: any) => {
      deptTree.value = res.data;
    });
  });

  // 页码变化
  const pageChange = (pageNo: number) => {
    pageInfo.value.pageNo = pageNo;
  };
  // 每页数据量变化
  const pageSizeChange = (pageSize: number) => {
    pageInfo.value.pageSize = pageSize;
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

  // 监视查询数据及其页码变化
  watch(
    [pageInfo.value, paperSearch.value],
    async ([newPageInfo, oldPageInfo], [newPaperSearch, oldPaperSearch]) => {
      await reloadPaperList({ ...pageInfo.value, ...paperSearch.value });
    },
    { deep: true }
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
