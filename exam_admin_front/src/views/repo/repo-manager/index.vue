<template>
  <div class="container">
    <Breadcrumb :items="['menu.repo', 'menu.repo.repoManager']" />
    <a-row :gutter="20" align="stretch">
      <a-col :span="24">
        <a-card class="general-card" :title="$t('menu.repo.repoManager')">
          <div>
            <a-row :gutter="5" style="margin-bottom: 16px">
              <!--学科搜索-->
              <a-col :span="6">
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
              </a-col>
              <!--部门搜索-->
              <a-col :span="6">
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
              </a-col>
              <!--是否用于训练考试-->
              <a-col :span="6">
                <a-checkbox
                  :model-value="searchForm.isExam ? true : false"
                  @change="handleExamChange"
                >
                  是否用于考试
                </a-checkbox>
                <a-checkbox
                  :model-value="searchForm.isTrain ? true : false"
                  @change="handleTrainChange"
                >
                  是否用于训练
                </a-checkbox>
              </a-col>
            </a-row>
            <a-row :gutter="5" style="margin-bottom: 16px">
              <!--标题搜索-->
              <a-col :span="6">
                <a-input-search
                  v-model="searchForm.titleFuzzy"
                  placeholder="输入题库名称搜索"
                  style="width: 250px"
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
                :total="pagination.total"
                :page-size="pagination.pageSize"
                :current="pagination.pageNo"
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
  import RepoQuery from '@/types/model/query/RepoQuery';
  import { onMounted, ref, watch } from 'vue';
  import BankList from '@/views/repo/repo-manager/components/bank-list.vue';
  import { getDeptTree } from '@/api/department';
  import { getRepoList } from '@/api/repo';
  import { Repo } from '@/types/model/po/Repo';
  import { SubjectTreeVO } from '@/types/model/vo/SubjectTreeVO';
  import { getSubjectTree } from '@/api/subject';
  import usePagination from '@/hooks/pagination';
  import useLoading from '@/hooks/loading';
  import SimplePage from '@/types/model/po/SimplePage';

  const { loading, setLoading } = useLoading(true);
  const { pagination, setPagination } = usePagination();

  // 部门树列表
  const deptTree = ref<[]>();
  const subjectTree = ref<SubjectTreeVO[]>([]);

  // 题库列表
  const repoList = ref<Repo[]>([]);
  // 查询表单
  const searchForm = ref<RepoQuery>(new RepoQuery());
  const reloadRepoList = async (repoQuery: RepoQuery) => {
    setLoading(true);
    await getRepoList(repoQuery).then((res: any) => {
      repoList.value = res.data.list;
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
    await getDeptTree().then((res: any) => {
      deptTree.value = res.data;
    });
    await reloadRepoList(searchForm.value);
    await getSubjectTree().then((res: any) => {
      subjectTree.value = res.data;
    });
  });

  // 页码变化
  const pageChange = (pageNo: number) => {
    searchForm.value.pageNo = pageNo;
  };
  // 每页数据量变化
  const pageSizeChange = (pageSize: number) => {
    searchForm.value.pageSize = pageSize;
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

  // 搜索
  const search = async () => {
    await reloadRepoList(searchForm.value);
  };

  // 重置
  const reset = async () => {
    searchForm.value = new RepoQuery();
    delete searchForm.value.isTrain;
    delete searchForm.value.isExam;
    pagination.value = new SimplePage();
    await reloadRepoList(searchForm.value);
  };

  // 监视页码变化
  watch(
    () => [searchForm.value.pageNo, searchForm.value.pageSize],
    async (newValue, oldValue) => {
      await reloadRepoList(searchForm.value);
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
