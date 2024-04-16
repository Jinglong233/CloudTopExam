<template>
  <div class="container">
    <Breadcrumb
      :items="[
        'menu.wrongManage.classWrongAnalyse',
        'menu.wrongManage.classWrongAnalyse.detail',
      ]"
    />
    <WrongDetail
      :all-question="allQuestion"
      :loading="loading"
      @reload="reloadDetail"
      @asce="asceSort"
      @desc="descSort"
    />
  </div>
</template>

<script lang="ts" setup>
  import { useRoute, useRouter } from 'vue-router';
  import { onMounted, ref } from 'vue';
  import { getExamQuAnalyse } from '@/api/exam';
  import { WrongQuVO } from '@/types/model/vo/WrongQuVO';
  import WrongDetail from '@/views/wrong-topic-management/component/WrongDetail.vue';

  const route = useRoute();

  const router = useRouter();
  const examId = ref();

  const allQuestion = ref<WrongQuVO[]>([]);

  const loading = ref(false);

  const reloadDetail = async () => {
    loading.value = true;
    await getExamQuAnalyse(examId.value as string).then((res: any) => {
      allQuestion.value = res.data;
    });
    loading.value = false;
  };
  onMounted(async () => {
    examId.value = route.params.examId;
    if (!examId.value) {
      router.back();
    } else {
      await reloadDetail();
    }
  });

  // 正确率升序排列
  const asceSort = () => {
    allQuestion.value.sort((a, b) => {
      return parseFloat(a.rightRate) - parseFloat(b.rightRate);
    });
  };

  // 正确率降序排列
  const descSort = () => {
    allQuestion.value.sort((a, b) => {
      return parseFloat(b.rightRate) - parseFloat(a.rightRate);
    });
  };
</script>

<style scoped></style>
