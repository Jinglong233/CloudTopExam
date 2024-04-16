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
            <a-button
              type="primary"
              shape="round"
              status="danger"
              @click="clearUserSearch"
            >
              <template #icon>
                <icon-refresh />
              </template>
            </a-button>
          </a-space>
          <a-tree
            v-model:selected-keys="examSearch.deptCodeFuzzy"
            :field-names="{
              key: 'deptCode',
              title: 'deptName',
              children: 'children',
            }"
            :data="deptTree"
          />
        </a-card>
      </a-col>
      <a-col :span="20">
        <a-card
          style="height: 650px"
          class="general-card"
          :title="$t('menu.wrongManage.examList')"
        >
          <!--查询栏-->
          <a-space align="center" style="margin-bottom: 10px">
            <!--考试标题-->
            <a-input
              v-model="examSearch.titleFuzzy"
              :placeholder="$t('examManager.placeholder.title')"
              style="width: 200px"
            />

            <!--开放类型-->
            <a-select
              v-model="examSearch.openType"
              :placeholder="$t('examManager.placeholder.openType')"
              style="width: 250px"
              allow-clear
            >
              <a-option value="0">完全公开</a-option>
              <a-option value="1">指定学生</a-option>
              <a-option value="2">指定部门</a-option>
            </a-select>

            <!--考试时间-->
            <a-date-picker
              v-model="examSearch.startTimeStart"
              style="width: 220px"
              show-time
              :time-picker-props="{ defaultValue: '09:09:06' }"
              :placeholder="t('examManager.placeholder.startTime')"
              format="YYYY-MM-DD HH:mm:ss"
            />
            <a-date-picker
              v-model="examSearch.endTimeEnd"
              style="width: 220px"
              show-time
              :placeholder="t('examManager.placeholder.endTime')"
              format="YYYY-MM-DD hh:mm"
            />
          </a-space>
          <a-divider style="margin-top: 0; margin-bottom: 16px" />
          <a-table
            row-key="id"
            :loading="loading"
            :columns="columns"
            :data="ExamList"
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
            <template #openType="{ record }">
              <template v-if="record.openType === 0">完全公开</template>
              <template v-if="record.openType === 1">指定学生</template>
              <template v-if="record.openType === 2">指定班级</template>
            </template>

            <template #examTime="{ record }">
              {{ record.startTime }} ~ {{ record.endTime }}
            </template>

            <template #statue="{ record }">
              <a-tag v-if="record.statue === 0" color="#165dff">未开始</a-tag>
              <a-tag v-if="record.statue === 1" color="#00b42a">已开始</a-tag>
              <a-tag v-if="record.statue === 2" color="#f53f3f">已结束</a-tag>
            </template>

            <template #option="{ record }">
              <a-space>
                <a-button type="primary" @click="handleDetail(record)">
                  {{ $t('examManager.columns.options.detail') }}
                </a-button>
              </a-space>
            </template>
          </a-table>
        </a-card>
      </a-col>
    </a-row>
  </div>
</template>

<script lang="ts" setup>
  import { onMounted, ref, watch } from 'vue';
  import { useI18n } from 'vue-i18n';
  import useLoading from '@/hooks/loading';
  import { UserDetailVO } from '@/types/model/vo/UserDetailVO';
  import { getDeptTree, loadDataList } from '@/api/department';
  import { TableColumnData } from '@arco-design/web-vue/es/table/interface';
  import { DepartmentQuery } from '@/types/model/query/DepartmentQuery';
  import usePermission from '@/hooks/permission';
  import { useUserStore } from '@/store';
  import { SimplePage } from '@/types/model/po/SimplePage';
  import { ExamQuery } from '@/types/model/query/ExamQuery';
  import { getExamList } from '@/api/exam';
  import { ExamVO } from '@/types/model/vo/ExamVO';
  import { Message } from '@arco-design/web-vue';
  import { useRouter } from 'vue-router';

  const { loading, setLoading } = useLoading(true);
  const { t } = useI18n();

  // 分页信息
  const pageInfo = ref<SimplePage>({
    pageNo: 1,
    pageSize: 10,
    pageTotal: 0,
    total: 0,
  });

  const router = useRouter();

  // 部门树列表
  const deptTree = ref<[]>();

  // 搜索部门树
  const searchTree = ref<DepartmentQuery>({});

  // 用户列表
  const userList = ref<UserDetailVO[]>([]);

  const permission = usePermission();
  const userStore = useUserStore();

  // 考试列表
  const ExamList = ref<ExamVO[]>();

  // 查询表单
  const examSearch = ref<ExamQuery>({});
  // 获取考试列表
  const reloadExamList = async (examQuery: ExamQuery) => {
    setLoading(true);
    await getExamList(examQuery).then((res: any) => {
      ExamList.value = res.data.list;
      pageInfo.value.total = res.data.totalCount;
      pageInfo.value.pageSize = res.data.pageSize;
      pageInfo.value.pageNo = res.data.pageNo;
      pageInfo.value.pageTotal = res.data.pageTotal;
    });
    setLoading(false);
  };

  onMounted(async () => {
    await getDeptTree().then((res: any) => {
      deptTree.value = res.data;
    });
    await reloadExamList(pageInfo.value);
  });

  // 清空查询表单
  const clearUserSearch = () => {
    examSearch.value.deptCodeFuzzy = '';
  };

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
      title: t('examManager.columns.title'),
      dataIndex: 'title',
      slotName: 'title',
      width: 100,
      ellipsis: true,
      tooltip: true,
    },
    {
      title: t('examManager.columns.openType'),
      dataIndex: 'openType',
      slotName: 'openType',
      width: 100,
      tooltip: true,
      ellipsis: true,
    },
    {
      title: t('examManager.columns.examTime'),
      dataIndex: 'examTime',
      slotName: 'examTime',
      width: 200,
      ellipsis: true,
      tooltip: true,
    },
    {
      title: t('examManager.columns.deptText'),
      dataIndex: 'deptText',
      slotName: 'deptText',
      width: 100,
      ellipsis: true,
      tooltip: true,
    },
    {
      title: t('examManager.columns.totalCount'),
      dataIndex: 'totalCount',
      slotName: 'totalCount',
      width: 80,
      ellipsis: true,
      tooltip: true,
    },
    {
      title: t('examManager.columns.qualifyScore'),
      dataIndex: 'qualifyScore',
      slotName: 'qualifyScore',
      width: 80,
      ellipsis: true,
      tooltip: true,
    },
    {
      title: t('examManager.columns.statue'),
      dataIndex: 'statue',
      slotName: 'statue',
      width: 100,
      ellipsis: true,
      tooltip: true,
    },
    {
      title: t('examManager.columns.options'),
      dataIndex: 'option',
      slotName: 'option',
      width: 150,
      ellipsis: true,
    },
  ]);

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

  watch(
    examSearch.value,
    async () => {
      if (Array.isArray(examSearch.value.deptCodeFuzzy)) {
        const code = examSearch.value.deptCodeFuzzy?.[0];
        examSearch.value.deptCodeFuzzy = code;
      }
    },
    { deep: true, immediate: true }
  );

  // 监视查询数据及其页码变化
  watch(
    [pageInfo.value, examSearch.value],
    async ([newPageInfo, oldPageInfo], [newUserSearch, oldUserSearch]) => {
      await reloadExamList({ ...pageInfo.value, ...examSearch.value });
    },
    { deep: true }
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
