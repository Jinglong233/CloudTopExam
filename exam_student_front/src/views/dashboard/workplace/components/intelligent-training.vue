<template>
  <a-card
    class="general-card"
    :title="$t('workplace.quickOperation.intelligentTraining')"
    :header-style="{ paddingBottom: '0' }"
    :body-style="{ padding: '24px 20px 0 20px' }"
  >
    <template #extra>
      <a-link @click="router.push({ name: 'RepoTrain' })">{{
        $t('workplace.quickOperation.otherTrain')
      }}</a-link>
    </template>
    <a-row :gutter="8">
      <a-button type="primary" @click="startIntelligentTrain"
        >开始智能训练</a-button
      >
    </a-row>
    <a-divider class="split-line" style="margin: 0" />
  </a-card>
</template>

<script lang="ts" setup>
  import { startTrain } from '@/api/train';
  import { Message } from '@arco-design/web-vue';
  import { ref } from 'vue';
  import { StartTrainDTO } from '@/types/model/dto/StartTrainDTO';
  import { useRouter } from 'vue-router';
  import { useUserStore } from '@/store';

  const links = [
    { text: 'workplace.contentManagement', icon: 'icon-file' },
    { text: 'workplace.contentStatistical', icon: 'icon-storage' },
    { text: 'workplace.advanced', icon: 'icon-settings' },
    { text: 'workplace.onlinePromotion', icon: 'icon-mobile' },
    { text: 'workplace.contentPutIn', icon: 'icon-fire' },
  ];

  const router = useRouter();
  const userStore = useUserStore();
  const startTrainDTO = ref<StartTrainDTO>({});
  const startIntelligentTrain = async () => {
    startTrainDTO.value.mode = 0;
    startTrainDTO.value.userId = userStore.id;
    await startTrain(startTrainDTO.value).then((res: any) => {
      if (res.data) {
        router.push({
          name: 'StartTrain',
          params: {
            trainId: res.data,
          },
        });
      } else {
        Message.warning({
          content: '创建训练记录失败',
          duration: 2000,
        });
      }
    });
  };
</script>

<style scoped lang="less"></style>
