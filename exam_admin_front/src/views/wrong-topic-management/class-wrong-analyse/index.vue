<template>
  <div class="container">
    <Breadcrumb
      :items="['menu.wrongManage', 'menu.wrongManage.classWrongAnalyse']"
    />
    <a-row :gutter="10">
      <!--左侧部门筛选-->
      <a-col :span="4">
        <a-card style="height: 650px">
          <a-space align="center">
            <a-input-search
              v-model="searchTree.deptNameFuzzy"
              style="margin-bottom: 8px; max-width: 240px"
              placeholder="筛选部门"
              @input="searchTreeChange"
            />
            <a-button type="primary" shape="round" status="danger">
              <template #icon>
                <icon-refresh />
              </template>
            </a-button>
          </a-space>
          <a-scrollbar style="height: 600px; width: 100%; overflow: auto">
            <a-tree
              v-model:selected-keys="deptCode"
              :field-names="{
                key: 'deptCode',
                title: 'deptName',
                children: 'children',
              }"
              :data="deptTree"
            />
          </a-scrollbar>
        </a-card>
      </a-col>
      <a-col :span="20">
        <a-card class="general-card">
          <a-scrollbar style="height: 650px; width: 100%; overflow: auto">
            <div style="height: 650px; width: 100%">
              <a-row :gutter="10">
                <a-col :span="12">
                  <KnowledgeAnalysis
                    :dept-code="tempCode"
                    title="错题关联知识点TOP5"
                    :card-style="{
                      background:
                        'linear-gradient(180deg, #F5FEF2 0%, #E6FEEE 100%)',
                      padding: '0',
                    }"
                  />
                </a-col>
                <a-col :span="12">
                  <SubjectAnalysis
                    title="错题关联学科TOP5"
                    :dept-code="tempCode"
                    :card-style="{
                      background:
                        'linear-gradient(180deg, #F7F7FF 0%, #ECECFF 100%)',
                      padding: '0',
                    }"
                  />
                </a-col>
              </a-row>
              <a-divider />
              <ClassErrorList :dept-code="tempCode" />
            </div>
          </a-scrollbar>
        </a-card>
      </a-col>
    </a-row>
  </div>
</template>

<script lang="ts" setup>
  import { computed, onMounted, ref, watch } from 'vue';
  import { useI18n } from 'vue-i18n';
  import useLoading from '@/hooks/loading';
  import { getDeptTree, loadDataList } from '@/api/department';
  import { DepartmentQuery } from '@/types/model/query/DepartmentQuery';
  import { Message } from '@arco-design/web-vue';
  import { useRouter } from 'vue-router';
  import usePagination from '@/hooks/pagination';
  import SimplePage from '@/types/model/po/SimplePage';
  import { errorCount } from '@/api/dataAnalysis';
  import KnowledgeAnalysis from '@/views/wrong-topic-management/class-wrong-analyse/components/knowledge-analysis.vue';
  import SubjectAnalysis from '@/views/wrong-topic-management/class-wrong-analyse/components/subject-analysis.vue';
  import ClassErrorList from '@/views/wrong-topic-management/class-wrong-analyse/components/class-error-list.vue';

  const { loading, setLoading } = useLoading(true);
  const { pagination, setPagination } = usePagination();

  const { t } = useI18n();

  const router = useRouter();

  // 部门树列表
  const deptTree = ref<[]>();

  // 搜索部门树
  const searchTree = ref<DepartmentQuery>({});

  // 查询表单
  const deptCode = ref<string>('');

  onMounted(async () => {
    await getDeptTree().then((res: any) => {
      deptTree.value = res.data;
    });
    await errorCount({
      deptCode: 'A01',
      pageNo: 1,
      pageSize: 1,
    });
  });

  // 搜索部门
  const searchTreeChange = async () => {
    if (searchTree.value.deptNameFuzzy === '') {
      await getDeptTree().then((res: any) => {
        deptTree.value = res.data;
      });
    } else {
      await loadDataList(searchTree.value).then((res: any) => {
        deptTree.value = res.data.list;
      });
    }
  };

  // 跳转题目详情
  const handleDetail = (record: any) => {
    // 判断考试是否结束
    if (record.statue !== 2) {
      Message.warning({
        content: '考试未结束',
        duration: 2000,
      });
      return;
    }

    router.push({
      name: 'ClassWrongDetail',
      params: {
        examId: record.id,
      },
    });
  };

  // 重置
  const reset = async () => {
    deptCode.value = '';
    pagination.value = new SimplePage();
  };

  const tempCode = computed(() => {
    return deptCode.value?.[0];
  });

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
