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
                @change="handleChange"
              />
              <!--部门搜索-->
              <a-tree-select
                v-model="searchForm.deptCode"
                placeholder="选择题库所属部门"
                :data="deptTree"
                :field-names="{
                  key: 'deptCode',
                  title: 'deptName',
                  children: 'children',
                }"
                :style="{ width: '250px' }"
                :allow-clear="true"
                @change="handleChange"
              />
              <a-checkbox v-model="searchForm.isExam" @change="handleChange"
                >是否用于考试</a-checkbox
              >
              <a-checkbox v-model="searchForm.isTrain" @change="handleChange"
                >是否用于训练</a-checkbox
              >

              <!--标题搜索-->
              <a-input-search
                v-model="searchForm.titleFuzzy"
                placeholder="输入题库名称搜索"
                style="width: 240px; position: absolute; top: 60px; right: 20px"
                @input="handleChange"
              />
            </a-space>
          </a-row>
          <a-divider />
          <a-row>
            <BankList
              :repo-list="repoList"
              :loading="loading"
              style="margin-top: 20px"
              @reload-repo-list="reloadRepoList"
            />
          </a-row>
        </a-card>
      </a-col>
    </a-row>
  </div>
</template>

<script lang="ts" setup>
  import { RepoQuery } from '@/types/model/query/RepoQuery';
  import { onMounted, ref, toRaw } from 'vue';
  import BankList from '@/views/repo/repo-manager/components/bank-list.vue';
  import { getDeptTree } from '@/api/department';
  import { getRepoList } from '@/api/repo';
  import { Repo } from '@/types/model/po/Repo';
  import { SubjectTreeVO } from '@/types/model/vo/SubjectTreeVO';
  import { getSubjectTree } from '@/api/subject';

  const loading = ref<boolean>(false);
  // 部门树列表
  const deptTree = ref<[]>();
  const subjectTree = ref<SubjectTreeVO[]>([]);

  // 题库列表
  const repoList = ref<Repo[]>();
  // 查询表单
  const searchForm = ref<RepoQuery>({});
  const reloadRepoList = async () => {
    loading.value = true;
    searchForm.value = {};
    await getRepoList(searchForm.value).then((res: any) => {
      repoList.value = res.data;
    });
    loading.value = false;
  };

  onMounted(async () => {
    await getDeptTree().then((res: any) => {
      deptTree.value = res.data;
    });
    await reloadRepoList();
    await getSubjectTree().then((res: any) => {
      subjectTree.value = res.data;
    });
  });

  // 查询
  const handleChange = async () => {
    // 拷贝一份searchForm，防止Boolean和int转换，解决复选框出现的问题
    const copySearchFrom = {
      ...toRaw(searchForm.value),
      isExam: searchForm.value.isExam ? 1 : null,
      isTrain: searchForm.value.isTrain ? 1 : null,
    } as RepoQuery;
    await getRepoList(copySearchFrom).then((res: any) => {
      repoList.value = res.data;
    });
  };
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
