<template>
  <div class="container">
    <Breadcrumb :items="['menu.exam', 'menu.exam.examManager']" />
    <a-scrollbar type="track" style="height: 600px; overflow: auto">
      <a-card class="general-card" :title="$t('menu.exam.examManager')">
        <!--查询栏-->
        <a-space align="center">
          <!--考试标题-->
          <a-input
            v-model="examSearch.titleFuzzy"
            :placeholder="$t('examManager.placeholder.title')"
            style="width: 320px"
            @input="handleChange"
          />

          <!--开放类型-->
          <a-select
            v-model="examSearch.openType"
            :placeholder="$t('examManager.placeholder.openType')"
            style="width: 250px"
            allow-clear
            @change="handleChange"
          >
            <a-option value="0">完全公开</a-option>
            <a-option value="1">指定学生</a-option>
            <a-option value="2">指定部门</a-option>
          </a-select>

          <!--考试时间-->
          <a-space>
            <a-date-picker
              v-model="examSearch.startTimeStart"
              style="width: 220px; margin: 0 24px 24px 0"
              show-time
              :time-picker-props="{ defaultValue: '09:09:06' }"
              :placeholder="t('examManager.placeholder.startTime')"
              format="YYYY-MM-DD HH:mm:ss"
              @ok="handleChange"
            />
            <a-date-picker
              v-model="examSearch.endTimeEnd"
              style="width: 220px; margin: 0 24px 24px 0"
              show-time
              :placeholder="t('examManager.placeholder.endTime')"
              format="YYYY-MM-DD hh:mm"
              @ok="handleChange"
            />
          </a-space>
        </a-space>
        <a-divider style="margin-top: 0" />
        <a-row style="margin-bottom: 16px">
          <a-col :span="12">
            <a-space>
              <a-button type="primary" @click="goAddExam">
                <template #icon>
                  <icon-plus />
                </template>
                {{ $t('examManager.operation.create') }}
              </a-button>
            </a-space>
          </a-col>
        </a-row>

        <a-table
          row-key="id"
          :loading="loading"
          :columns="columns"
          :data="ExamList"
          :bordered="false"
        >
          <template #openType="{ record }">
            <template v-if="record.openType === 0">完全公开</template>
            <template v-if="record.openType === 1">指定学生</template>
          </template>

          <template #examTime="{ record }">
            {{ record.startTime }} ~ {{ record.endTime }}
          </template>

          <template #option="{ record }">
            <a-space>
              <a-button type="primary" @click="handleModify(record)">
                {{ $t('examManager.columns.options.detail') }}
              </a-button>
              <a-button
                type="primary"
                status="danger"
                @click="handleDelete(record.id)"
              >
                {{ $t('examManager.columns.options.delete') }}
              </a-button>
            </a-space>
          </template>
        </a-table>
      </a-card>
    </a-scrollbar>
  </div>
</template>

<script lang="ts" setup>
  import { onMounted, ref, toRaw } from 'vue';
  import { useI18n } from 'vue-i18n';
  import useLoading from '@/hooks/loading';
  import { useRouter } from 'vue-router';
  import { TableColumnData } from '@arco-design/web-vue/es/table/interface';
  import { Message, Modal } from '@arco-design/web-vue';
  import { deleteExamById, getExamList } from '@/api/exam';
  import { ExamQuery } from '@/types/model/query/ExamQuery';
  import { ExamVO } from '@/types/model/vo/ExamVO';

  const { loading, setLoading } = useLoading(true);
  const { t } = useI18n();

  const router = useRouter();
  // 添加考试表单
  const form = ref({
    title: '',
    subjectId: '',
    joinType: '',
  });
  // 添加考试模态框开关
  const addExamVisible = ref<boolean>(false);

  // 考试列表
  const ExamList = ref<ExamVO[]>();

  // 查询表单
  const examSearch = ref<ExamQuery>({});

  // 获取考试列表
  const reloadExamList = async () => {
    setLoading(true);
    await getExamList({}).then((res: any) => {
      ExamList.value = res.data;
    });
    setLoading(false);
  };
  onMounted(async () => {
    await reloadExamList();
  });

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
      width: 80,
      ellipsis: true,
      tooltip: true,
    },
    {
      title: t('examManager.columns.options'),
      dataIndex: 'option',
      slotName: 'option',
      width: 200,
      ellipsis: true,
    },
  ]);

  // 查询考试
  const handleChange = async () => {
    examSearch.value.endTimeStart = '';
    examSearch.value.startTimeEnd = '';
    await getExamList(examSearch.value).then((res: any) => {
      ExamList.value = res.data;
    });
  };

  // 编辑
  const handleModify = (record: any) => {
    router.push({
      path: '/exam/modify-exam',
      query: {
        id: record.id,
      },
    });
  };

  // 删除
  const handleDelete = async (id: string) => {
    Modal.warning({
      title: '警告',
      content: '确认删除该考试？',
      hideCancel: false,
      onOk: async () => {
        await deleteExamById(id).then(async (res: any) => {
          if (res.data === true) {
            Message.success({
              content: '考试删除成功',
            });
          } else {
            Message.error({
              content: '考试删除失败',
            });
          }
          await reloadExamList();
        });
      },
    });
  };

  // 前往添加考试界面
  const goAddExam = () => {
    router.push({
      path: 'select-exam-paper',
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
