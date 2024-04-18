<template>
  <div class="container">
    <Breadcrumb :items="['menu.exam', 'menu.exam.examManager']" />
    <a-card
      class="general-card"
      :title="$t('menu.exam.examManager')"
      style="height: 680px"
    >
      <!--查询栏-->
      <a-space align="center" style="margin-bottom: 10px">
        <!--考试标题-->
        <a-input
          v-model="examSearch.titleFuzzy"
          :placeholder="$t('examManager.placeholder.title')"
          style="width: 320px"
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

        <a-checkbox @change="onlyMyCreate">只查看我创建的</a-checkbox>
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
        </template>

        <template #examTime="{ record }">
          {{ record.startTime }} ~ {{ record.endTime }}
        </template>

        <template #statue="{ record }">
          <a-tag v-if="record.statue === 0" color="red">未开始</a-tag>
          <a-tag v-if="record.statue === 1" color="blue">已开始</a-tag>
          <a-tag v-if="record.statue === 2" color="green">已结束</a-tag>
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
              <template #icon>
                <icon-delete />
              </template>
            </a-button>
            <a-button
              type="primary"
              status="success"
              @click="createCode(record)"
            >
              <template #icon>
                <icon-scan />
              </template>
            </a-button>
            <a-dropdown>
              <a-button>
                <template #icon>
                  <icon-more />
                </template>
              </a-button>
              <template #content>
                <a-button type="dashed" @click="goExamRecord(record)">
                  考试记录
                </a-button>
              </template>
            </a-dropdown>
          </a-space>
        </template>
      </a-table>
    </a-card>
    <div ref="imageRef">
      <a-modal
        v-model:visible="visible"
        :simple="true"
        :closable="true"
        :footer="false"
        :hide-title="true"
        :modal-style="{ padding: '0', margin: '0', borderRadius: '100px' }"
      >
        <a-card :bordered="false" style="height: 500px">
          <template #cover>
            <div
              :style="{
                height: '200px',
                overflow: 'hidden',
              }"
            >
              <img
                :style="{ width: '100%', transform: 'translateY(-20px)' }"
                alt="dessert"
                src="https://avatar-store.oss-cn-beijing.aliyuncs.com/other/examTagBackground.jpg"
              />
            </div>
          </template>
          <a-card-meta>
            <template #description>
              <a-row :gutter="0">
                <a-col :span="18">
                  <a-descriptions
                    :title="`考试名称：${currentExam.title}`"
                    :column="1"
                  >
                    <a-descriptions-item label="考试开始时间:">
                      {{ currentExam.startTime }}
                    </a-descriptions-item>
                    <a-descriptions-item label="考试结束时间:">
                      {{ currentExam.endTime }}
                    </a-descriptions-item>
                    <a-descriptions-item label="允许迟到时间:">
                      {{ currentExam.lateMax }}&emsp;分钟
                    </a-descriptions-item>
                    <a-descriptions-item label="最少答卷时间:">
                      {{ currentExam.handMin }}&emsp;分钟
                    </a-descriptions-item>
                    <a-descriptions-item label="考试时长:">
                      {{ currentExam.duration }}&emsp;分钟
                    </a-descriptions-item>
                  </a-descriptions>
                </a-col>
                <a-col :span="6"
                  ><a-image
                    style="margin-top: 85px"
                    width="100"
                    height="100"
                    :src="imageUrl"
                /></a-col>
              </a-row>
            </template>
            <template #avatar>
              <a-space style="position: absolute; bottom: 10px">
                <a-avatar
                  style="background-color: #ffffff; margin-right: 10px"
                  :size="50"
                  image-url="https://avatar-store.oss-cn-beijing.aliyuncs.com/other/signature.png"
                >
                </a-avatar>
                <a-typography-title style="margin-right: 20px" :heading="6">
                  CloudTopExam
                </a-typography-title>
                <a-space>
                  <a-typography-paragraph
                    :copyable="true"
                    :copy-text="`http://localhost:8088/api/exam/startExam/${currentExam.id}`"
                  >
                    <a-space style="margin-top: 20px">
                      <a-typography-text type="primary">
                        复制考试链接
                      </a-typography-text>
                      <template #copy-icon>
                        <icon-link />
                      </template>
                    </a-space>
                  </a-typography-paragraph>
                </a-space>
                <a-space>
                  <a-typography-text type="primary" @click="download">
                    <icon-download />
                    下载
                  </a-typography-text>
                </a-space>
              </a-space>
            </template>
          </a-card-meta>
        </a-card>
      </a-modal>
    </div>
  </div>
</template>

<script lang="ts" setup>
  import { onMounted, ref, watch } from 'vue';
  import { useI18n } from 'vue-i18n';
  import useLoading from '@/hooks/loading';
  import { useRouter } from 'vue-router';
  import { TableColumnData } from '@arco-design/web-vue/es/table/interface';
  import { Message, Modal } from '@arco-design/web-vue';
  import { deleteExamById, getExamList, getExamQrCode } from '@/api/exam';
  import { ExamQuery } from '@/types/model/query/ExamQuery';
  import { ExamVO } from '@/types/model/vo/ExamVO';
  import { SimplePage } from '@/types/model/po/SimplePage';
  import { useUserStore } from '@/store';

  const { loading, setLoading } = useLoading(true);
  const { t } = useI18n();

  const imageRef = ref<HTMLElement>();

  const userStore = useUserStore();

  // 考试扫码考试对话框
  const visible = ref(false);

  const imageUrl = ref();

  const currentExam = ref<ExamVO>({});

  // 分页信息
  const pageInfo = ref<SimplePage>({
    pageNo: 1,
    pageSize: 10,
    pageTotal: 0,
    total: 0,
  });

  const router = useRouter();
  // 添加考试表单
  const form = ref({
    title: '',
    subjectId: '',
    joinType: '',
  });

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
    await reloadExamList(pageInfo.value);
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
      width: 80,
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
          await reloadExamList(pageInfo.value);
        });
      },
    });
  };

  // 只查看我创建的考试
  const onlyMyCreate = (flag: any) => {
    if (flag) {
      examSearch.value.createBy = userStore.id;
    } else {
      examSearch.value.createBy = '';
    }
  };

  // 前往添加考试界面
  const goAddExam = () => {
    router.push({
      path: 'select-exam-paper',
    });
  };

  // 获取二维码
  const createCode = async (record: any) => {
    currentExam.value = record;
    await getExamQrCode(record.id).then((res: any) => {
      imageUrl.value = window.URL.createObjectURL(res.data); // 将 blob 对象转换为 URL
    });
    // 打开对话框
    visible.value = true;
  };

  // 获取考试记录
  const goExamRecord = (record: any) => {
    router.push({
      name: 'ExamRecord',
      params: {
        examId: record.id,
      },
    });
  };

  // 监视查询数据及其页码变化
  watch(
    [pageInfo.value, examSearch.value],
    async ([newPageInfo, oldPageInfo], [newExamSearch, oldExamSearch]) => {
      await reloadExamList({ ...pageInfo.value, ...examSearch.value });
    },
    { deep: true }
  );

  // 下载图片
  const download = () => {
    Message.info({
      content: '功能未完成',
      duration: 2000,
    });
  };
</script>

<style scoped lang="less">
  .arco-modal-simple .arco-modal-header {
    margin-bottom: 0;
  }
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

  .icon-hover {
    display: flex;
    align-items: center;
    justify-content: center;
    width: 24px;
    height: 24px;
    border-radius: 50%;
    transition: all 0.1s;
  }

  .icon-hover:hover {
    background-color: rgb(var(--gray-2));
  }

  .arco-image-img {
    margin-top: 85px;
  }
</style>
