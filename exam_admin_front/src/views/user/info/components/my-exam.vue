<template>
  <a-card class="general-card" :title="$t('userSetting.label.myExam')">
    <template #extra>
      <a-link>{{ $t('userInfo.showMore') }}</a-link>
    </template>
    <a-row :gutter="16">
      <a-col
        v-for="exam in examList"
        :key="exam.id"
        :xs="12"
        :sm="12"
        :md="12"
        :lg="12"
        :xl="8"
        :xxl="8"
        class="my-project-item"
      >
        <a-card>
          <a-skeleton v-if="loading" :loading="loading" :animation="true">
            <a-skeleton-line :rows="3" />
          </a-skeleton>
          <a-space v-else direction="vertical">
            <a-descriptions
              :title="exam.title"
              size="mini"
              layout="inline-horizontal"
              :column="1"
            >
              <a-descriptions-item label="状态">
                <a-typography-text type="Secondary">
                  <a-tag v-if="exam.statue === 0" color="blue">未开始</a-tag>
                  <a-tag v-if="exam.statue === 1" color="green">已开始</a-tag>
                  <a-tag v-if="exam.statue === 2" color="grey">已结束</a-tag>
                </a-typography-text>
              </a-descriptions-item>
              <a-descriptions-item>
                <a-typography-text
                  type="Secondary"
                  :ellipsis="{
                    rows: 1,
                    showTooltip: true,
                  }"
                >
                  {{ exam.startTime }} ~ {{ exam.endTime }}
                </a-typography-text>
              </a-descriptions-item>
              <a-descriptions-item label="创建时间">
                <a-typography-text type="Secondary">
                  {{ exam.createTime }}
                </a-typography-text>
              </a-descriptions-item>
              <a-descriptions-item label="开放类型">
                <a-typography-text type="Secondary">
                  <template v-if="exam.openType === 0">完全开放</template>
                  <template v-if="exam.openType === 1">指定学生</template>
                  <template v-if="exam.openType === 2">指定部门</template>
                </a-typography-text>
              </a-descriptions-item>
            </a-descriptions>
          </a-space>
        </a-card>
      </a-col>
    </a-row>
  </a-card>
</template>

<script lang="ts" setup>
  import { onMounted, ref } from 'vue';
  import { useUserStore } from '@/store';
  import { getExamList } from '@/api/exam';
  import { ExamVO } from '@/types/model/vo/ExamVO';

  const userInfo = useUserStore();

  const loading = ref<boolean>(true);

  const examList = ref<ExamVO[]>([]);

  onMounted(async () => {
    await getExamList({ createBy: userInfo.id }).then((res: any) => {
      examList.value = res.data;
      loading.value = false;
    });
  });
</script>

<style scoped lang="less">
  :deep(.arco-card-body) {
    min-height: 128px;
    padding-bottom: 0;
  }

  .my-project {
    &-header {
      display: flex;
      align-items: flex-start;
      justify-content: space-between;
    }

    &-title {
      margin-top: 0 !important;
      margin-bottom: 18px !important;
    }

    &-list {
      display: flex;
      justify-content: space-between;
    }

    &-item {
      // padding-right: 16px;
      margin-bottom: 16px;

      &:last-child {
        padding-right: 0;
      }
    }
  }
</style>
