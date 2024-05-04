<template>
  <div class="container">
    <Breadcrumb :items="['menu.repo', 'menu.repo.repoManager']" />
    <a-row :gutter="20" align="stretch">
      <a-col :span="24">
        <a-card class="general-card" :title="$t('menu.repo.repoManager')">
          <a-row justify="space-between">
            <a-space>
              <!--学科搜索-->
              <a-tree-select
                v-model="searchForm.subjectId"
                :data="subjectTree"
                :field-names="{
                  key: 'id',
                  title: 'title',
                  children: 'children',
                }"
                :style="{ width: '250px' }"
                placeholder="请选择学科"
                allow-clear
              />
              <!--部门搜索-->
              <a-tree-select
                v-model="searchForm.deptCodeFuzzy"
                placeholder="选择题库所属部门"
                :data="deptTree"
                :field-names="{
                  key: 'deptCode',
                  title: 'deptName',
                  children: 'children',
                }"
                :style="{ width: '250px' }"
                :allow-clear="true"
                @change="handleSelectChange"
              />
              <a-checkbox @change="handleExamChange">是否用于考试</a-checkbox>
              <a-checkbox @change="handleTrainChange">是否用于训练</a-checkbox>
              <!--标题搜索-->
              <a-input-search
                v-model="searchForm.titleFuzzy"
                placeholder="输入题库名称搜索"
                style="width: 240px; position: absolute; top: 60px; right: 20px"
              />
            </a-space>
          </a-row>
          <a-divider />
          <a-row>
            <a-scrollbar style="height: 450px; overflow: auto">
              <BankList
                :repo-list="repoList"
                :loading="loading"
                style="margin-top: 20px"
                @reload-repo-list="reloadRepoList({})"
              />
            </a-scrollbar>
            <div style="margin-top: 10px; flex: auto">
              <a-pagination
                style="float: right"
                :show-total="true"
                :show-page-size="true"
                :total="pageInfo.total"
                :page-size="pageInfo.pageSize"
                :current="pageInfo.pageNo"
                @change="pageChange"
                @page-size-change="pageSizeChange"
              />
            </div>
          </a-row>
        </a-card>
      </a-col>
    </a-row>
  </div>
</template>

<script lang="ts" setup>
  import { RepoQuery } from '@/types/model/query/RepoQuery';
  import { onMounted, ref, watch } from 'vue';
  import BankList from '@/views/repo/repo-manager/components/bank-list.vue';
  import { getDeptTree } from '@/api/department';
  import { getRepoList } from '@/api/repo';
  import { Repo } from '@/types/model/po/Repo';
  import { SubjectTreeVO } from '@/types/model/vo/SubjectTreeVO';
  import { getSubjectTree } from '@/api/subject';
  import { SimplePage } from '@/types/model/po/SimplePage';

  const loading = ref<boolean>(false);

  // 分页信息
  const pageInfo = ref<SimplePage>({
    pageNo: 1,
    pageSize: 10,
    pageTotal: 0,
    total: 0,
  });

  // 部门树列表
  const deptTree = ref<[]>();
  const subjectTree = ref<SubjectTreeVO[]>([]);

  // 题库列表
  const repoList = ref<Repo[]>([]);
  // 查询表单
  const searchForm = ref<RepoQuery>({} as RepoQuery);
  const reloadRepoList = async (repoQuery: RepoQuery) => {
    loading.value = true;
    await getRepoList(repoQuery).then((res: any) => {
      repoList.value = res.data.list;
      pageInfo.value.total = res.data.totalCount;
      pageInfo.value.pageSize = res.data.pageSize;
      pageInfo.value.pageNo = res.data.pageNo;
      pageInfo.value.pageTotal = res.data.pageTotal;
    });
    loading.value = false;
  };

  onMounted(async () => {
    await getDeptTree().then((res: any) => {
      deptTree.value = res.data;
    });
    await reloadRepoList({ ...pageInfo.value } as RepoQuery);
    await getSubjectTree().then((res: any) => {
      subjectTree.value = res.data;
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

  // 处理下拉框变化
  const handleSelectChange = (deptCode: string) => {
    searchForm.value.deptCodeFuzzy = deptCode;
  };

  // 处理
  const handleTrainChange = async (isTrain: number) => {
    if (isTrain) {
      searchForm.value.isTrain = Number(isTrain);
    } else {
      delete searchForm.value.isTrain;
    }
  };
  const handleExamChange = async (isExam: number) => {
    if (isExam) {
      searchForm.value.isExam = Number(isExam);
    } else {
      delete searchForm.value.isExam;
    }
  };

  watch(
    [pageInfo.value, searchForm.value],
    async ([newPageInfo, oldPageInfo], [newSearchForm, oldSearchForm]) => {
      await reloadRepoList({ ...pageInfo.value, ...searchForm.value });
    },
    {
      deep: true,
    }
  );
</script>

<style scoped lang="less">
  .container {
    padding: 0 20px 20px 20px;

    :deep(.arco-list-content) {
      overflow-x: hidden;
    }

    :deep(.arco-card-meta-title) {
      font-size: 14px;
    }
  }

  :deep(.arco-list-col) {
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    justify-content: space-between;
  }

  :deep(.arco-list-item) {
    width: 33%;
  }

  :deep(.block-title) {
    margin: 0 0 12px 0;
    font-size: 14px;
  }

  :deep(.list-wrap) {
    // min-height: 140px;
    .list-row {
      align-items: stretch;

      .list-col {
        margin-bottom: 16px;
      }
    }

    :deep(.arco-space) {
      width: 100%;

      .arco-space-item {
        &:last-child {
          flex: 1;
        }
      }
    }
  }
</style>
