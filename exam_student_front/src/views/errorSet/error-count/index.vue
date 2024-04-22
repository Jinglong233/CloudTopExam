<template>
  <div>
    <ErrorQuList
      :all-question="errorQuList"
      :loading="loading"
      @reload="resetSort"
      @desc="descSort"
      @asce="asceSort"
    />
  </div>
</template>

<script setup lang="ts">
  import { onMounted, ref } from 'vue';
  import { ErrorVO } from '@/types/model/vo/ErrorVO';
  import { getErrorCount } from '@/api/exam';
  import { useUserStore } from '@/store';
  import ErrorQuList from '@/views/errorSet/component/errorQuList.vue';

  const userStore = useUserStore();
  const loading = ref(false);

  // 错题列表
  const errorQuList = ref<ErrorVO[]>([]);

  const reloadErrorList = async () => {
    loading.value = true;
    await getErrorCount(userStore.id as string).then((res: any) => {
      errorQuList.value = res.data;
      loading.value = false;
    });
  };
  onMounted(async () => {
    await reloadErrorList();
  });

  const resetSort = async () => {
    await reloadErrorList();
  };

  // 正确次数升序排列
  const asceSort = () => {
    errorQuList.value.sort((a: any, b: any) => {
      return a.rightCount - b.rightCount;
    });
  };

  // 正确次数降序排列
  const descSort = () => {
    errorQuList.value.sort((a: any, b: any) => {
      return b.rightCount - a.rightCount;
    });
  };
</script>

<style scoped></style>
