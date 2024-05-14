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
          <div>
            <a-row style="margin-bottom: 10px" :gutter="5">
              <!--考试标题-->
              <a-col :span="8">
                <a-input
                  v-model="examSearch.titleFuzzy"
                  :placeholder="$t('examManager.placeholder.title')"
                  style="width: 250px"
                />
              </a-col>
              <!--开放类型-->
              <a-col :span="8">
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
              </a-col>
            </a-row>
            <a-row style="margin-bottom: 10px" :gutter="1">
              <!--考试时间-->
              <a-col :span="8">
                <a-date-picker
                  v-model="examSearch.startTimeStart"
                  style="width: 250px"
                  show-time
                  :time-picker-props="{ defaultValue: '09:09:06' }"
                  :placeholder="t('examManager.placeholder.startTime')"
                  format="YYYY-MM-DD"
                />
              </a-col>
              <a-col :span="8">
                <a-date-picker
                  v-model="examSearch.endTimeEnd"
                  style="width: 250px"
                  show-time
                  :placeholder="t('examManager.placeholder.endTime')"
                  format="YYYY-MM-DD hh:mm"
                />
              </a-col>
              <!--搜索重置按钮-->
              <a-col :span="8">
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
              total: pagination.total,
              pageSize: pagination.pageSize,
              current: pagination.pageNo,
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
  import { getExamList } from '@/api/exam';
  import { ExamVO } from '@/types/model/vo/ExamVO';
  import { Message } from '@arco-design/web-vue';
  import { useRouter } from 'vue-router';
  import usePagination from '@/hooks/pagination';
  import ExamQuery from '@/types/model/query/ExamQuery';
  import SimplePage from '@/types/model/po/SimplePage';

  const { loading, setLoading } = useLoading(true);
  const { pagination, setPagination } = usePagination();

  const { t } = useI18n();

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
  const examSearch = ref<ExamQuery>(new ExamQuery());
  // 获取考试列表
  const reloadExamList = async (examQuery: ExamQuery) => {
    setLoading(true);
    await getExamList(examQuery).then((res: any) => {
      ExamList.value = res.data.list;
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
    await reloadExamList(examSearch.value);
  });

  // 清空查询表单
  const clearUserSearch = () => {
    examSearch.value.deptCodeFuzzy = '';
  };

  // 页码变化
  const pageChange = (pageNo: number) => {
    examSearch.value.pageNo = pageNo;
  };
  // 每页数据量变化
  const pageSizeChange = (pageSize: number) => {
    examSearch.value.pageSize = pageSize;
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
      width: 100,
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
      width: 100,
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

  // 搜索
  const search = async () => {
    // 拷贝一个新的搜索对象（因为如何将deptCodeFuzzy转换为非数组后，控制台会报警告）
    const newSearchObj = { ...examSearch.value };
    // 将树状列表选择的数组转化为单个值
    if (Array.isArray(examSearch.value.deptCodeFuzzy)) {
      const code = examSearch.value.deptCodeFuzzy?.[0];
      newSearchObj.deptCodeFuzzy = code;
    }
    await reloadExamList(newSearchObj);
  };

  // 重置
  const reset = async () => {
    examSearch.value = new ExamQuery();
    pagination.value = new SimplePage();
    await reloadExamList(examSearch.value);
  };

  // 监视页码变化
  watch(
    () => [examSearch.value.pageNo, examSearch.value.pageSize],
    async (newValue, oldValue) => {
      // 拷贝一个新的搜索对象（因为如何将deptCodeFuzzy转换为非数组后，控制台会报警告）
      const newSearchObj = { ...examSearch.value };
      // 将树状列表选择的数组转化为单个值
      if (Array.isArray(examSearch.value.deptCodeFuzzy)) {
        const code = examSearch.value.deptCodeFuzzy?.[0];
        newSearchObj.deptCodeFuzzy = code;
      }
      await reloadExamList(newSearchObj);
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
