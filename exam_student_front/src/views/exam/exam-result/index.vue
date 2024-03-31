<template>
  <a-row class="grid-demo" style="backgroundcolor: var(--color-fill-2)">
    <a-col :span="16" :offset="4" style="margin-top: 20px; text-align: center">
      <a-card style="height: 600px; line-height: 600px">
        <a-typography-title
          v-if="result.isHandle === 1"
          :heading="1"
          type="primary"
          bold
        >
          {{ result.totalScore }}分
        </a-typography-title>
        <a-typography-title :heading="5"> 感谢您的作答 </a-typography-title>
      </a-card>
    </a-col>
  </a-row>
</template>

<script lang="ts" setup>
  import { onMounted, ref } from 'vue';
  import { getExamResult } from '@/api/examRecord';
  import { useRoute } from 'vue-router';
  import { Message } from '@arco-design/web-vue';
  import { ExamResultVO } from '@/types/model/vo/ExamResultVO';

  const route = useRoute();

  const result = ref<ExamResultVO>({});
  onMounted(async () => {
    const examRecordId = route.params.examRecordId as string;

    await getExamResult(examRecordId).then((res: any) => {
      if (res.data) {
        result.value = res.data;
      } else {
        Message.error({
          id: 'resultError',
          content: res.info,
          duration: 2000,
        });
      }
    });
  });
  const goStartExam = () => {};
</script>

<style scoped></style>
