<template>
  <a-spin :loading="loading" style="width: 100%">
    <a-card
      class="general-card"
      :header-style="{ paddingBottom: '0' }"
      :body-style="{ padding: '17px 20px 21px 20px' }"
    >
      <template #title>
        {{ $t('workplace.reviewPaper') }}
      </template>
      <template #extra>
        <a-link href="/exam/correct-exam-list">{{
          $t('workplace.viewMore')
        }}</a-link>
      </template>
      <a-space direction="vertical" :size="10" fill>
        <a-table
          :data="renderList"
          :pagination="false"
          :bordered="false"
          :scroll="{ x: '100%', y: '264px' }"
        >
          <template #columns>
            <a-table-column title="考试名称" :ellipsis="true" :tooltip="true">
              <template #cell="{ record }">
                <a-link @click="goCorrect(record.exam.id)">{{
                  record.exam.title
                }}</a-link>
              </template>
            </a-table-column>
            <a-table-column
              title="考试人数"
              data-index="examTotal"
              :ellipsis="true"
              :tooltip="true"
            >
            </a-table-column>
            <a-table-column title="待批阅人数" data-index="correctTotal">
            </a-table-column>
          </template>
        </a-table>
      </a-space>
    </a-card>
  </a-spin>
</template>

<script lang="ts" setup>
  import { ref } from 'vue';
  import useLoading from '@/hooks/loading';
  import { getCorrectExam } from '@/api/exam';
  import { useUserStore } from '@/store';
  import { useRouter } from 'vue-router';

  const type = ref('text');
  const { loading, setLoading } = useLoading();
  const renderList = ref<[]>();
  const userStore = useUserStore();
  const router = useRouter();

  const fetchData = async (contentType: string) => {
    try {
      setLoading(true);
      await getCorrectExam(userStore.id as string).then((res: any) => {
        if (res.data) {
          renderList.value = res.data.filter((r: any) => r.correctTotal > 0);
        }
      });
    } catch (err) {
      // you can report use errorHandler or other
    } finally {
      setLoading(false);
    }
  };
  fetchData('text');

  const goCorrect = (examId: string) => {
    router.resolve({
      name: 'CorrectUserExam',
      params: {
        examId,
      },
    });
    window.open(`/exam/correct-user-list/${examId}`, '_black');
  };
</script>

<style scoped lang="less">
  .general-card {
    min-height: 395px;
  }
  :deep(.arco-table-tr) {
    height: 44px;
    .arco-typography {
      margin-bottom: 0;
    }
  }
  .increases-cell {
    display: flex;
    align-items: center;
    span {
      margin-right: 4px;
    }
  }
</style>
