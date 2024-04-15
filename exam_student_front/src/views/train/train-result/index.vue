<template>
  <a-card style="margin: 20px; height: 600px">
    <a-typography-title style="text-align: center"> 结果页 </a-typography-title>
    <a-typography-title style="text-align: center" :heading="6">
      训练完成率{{ trainInfo.percent }}%
    </a-typography-title>
    <div style="text-align: center">
      <a-space size="large">
        <a-space>
          <icon-check-circle-fill style="color: green; font-size: 32px" />
          <a-typography-text
            >已答{{ trainInfo.answerCount }}题</a-typography-text
          >
        </a-space>
        <a-space>
          <icon-check-circle-fill style="color: green; font-size: 32px" />
          <a-typography-text
            >答对{{ trainInfo.rightCount }}题</a-typography-text
          >
        </a-space>
        <a-space>
          <icon-check-circle-fill style="color: green; font-size: 32px" />
          <a-typography-text
            >答错{{
              trainInfo.answerCount - trainInfo.rightCount
            }}题</a-typography-text
          >
        </a-space>
      </a-space>
    </div>
    <div style="text-align: center">
      <a-button
        type="primary"
        status="warning"
        @click="router.push({ name: 'RepoTrain' })"
        >返回</a-button
      >
    </div>
  </a-card>
</template>

<script lang="ts" setup>
  import { useI18n } from 'vue-i18n';
  import { useRoute, useRouter } from 'vue-router';
  import { onMounted, ref } from 'vue';
  import { getTrainById } from '@/api/train';
  import { Train } from '@/types/model/po/Train';
  import { Message } from '@arco-design/web-vue';

  const { t } = useI18n();

  const router = useRouter();
  const route = useRoute();
  const trainId = ref<string>('');
  const trainInfo = ref<Train>({});
  onMounted(async () => {
    // 获取路由参数
    trainId.value = route.params.trainId as string;

    if (trainId.value) {
      await getTrainById(trainId.value).then((res: any) => {
        if (res) {
          trainInfo.value = res.data;
        } else {
          Message.warning({
            content: res.info,
            duration: 2000,
          });
          router.push({
            name: 'RepoTrain',
          });
        }
      });
    }
  });
</script>

<style scoped></style>
