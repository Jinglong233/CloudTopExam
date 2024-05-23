<template>
  <a-layout style="height: 700px; margin-top: 20px">
    <a-layout-content style="margin: 20px">
      <a-card :title="t('menu.train.repoDetail')" style="height: 660px">
        <a-typography-title :heading="5" :bold="true"
          >自由训练</a-typography-title
        >
        <a-space>
          <a-card
            style="
              height: 100px;
              width: 120px;
              line-height: 70px;
              cursor: pointer;
            "
            hoverable
            @click="start(1)"
          >
            顺序训练
          </a-card>
          <a-card
            style="
              height: 100px;
              width: 120px;
              line-height: 70px;
              cursor: pointer;
            "
            hoverable
            @click="start(2)"
          >
            随机训练
          </a-card>
        </a-space>

        <a-divider />

        <a-typography-title :heading="5" :bold="true"
          >题型训练</a-typography-title
        >

        <a-space>
          <template v-for="(value, name, index) in quTypeClassify" :key="index">
            <a-card
              v-if="Number(name) !== 5 && Number(name) !== 4"
              style="
                height: 100px;
                width: 120px;
                line-height: 70px;
                cursor: pointer;
              "
              hoverable
              @click="start(3, Number(name))"
            >
              {{ getQuestionTypeName(Number(name)) }}{{ value }}
            </a-card>
          </template>
        </a-space>

        <a-divider />
      </a-card>
    </a-layout-content>
  </a-layout>
</template>

<script lang="ts" setup>
  import { useI18n } from 'vue-i18n';
  import { useRoute, useRouter } from 'vue-router';
  import { onMounted, ref } from 'vue';
  import { Repo } from '@/types/model/po/Repo';
  import { getQuTypeClassifyByRepoId, getRepoList } from '@/api/repo';
  import { StartTrainDTO } from '@/types/model/dto/StartTrainDTO';
  import { startTrain } from '@/api/train';
  import { useUserStore } from '@/store';
  import { getQuestionTypeName } from '../../../api/common';

  const { t } = useI18n();

  const router = useRouter();
  const route = useRoute();

  const userStore = useUserStore();

  const repoInfo = ref<Repo>({});

  const quTypeClassify = ref({});

  const startTrainDTO = ref<StartTrainDTO>({});

  onMounted(async () => {
    const { repoId } = route.params;
    if (repoId) {
      // 获取题库详情
      await getRepoList({ id: repoId as string }).then((res: any) => {
        if (res) {
          // eslint-disable-next-line prefer-destructuring
          repoInfo.value = res.data[0];
        }
      });

      // 获取关联该题库的所有题型及其数量
      await getQuTypeClassifyByRepoId(repoId as string).then((res: any) => {
        if (res) {
          quTypeClassify.value = res.data;
        }
      });
    } else {
      router.back();
    }
  });

  const start = async (mode: any, qyType?: any) => {
    startTrainDTO.value.mode = mode;
    startTrainDTO.value.quType = qyType;

    startTrainDTO.value.repoId = repoInfo.value.id;
    startTrainDTO.value.userId = userStore.id;
    await startTrain(startTrainDTO.value).then((res: any) => {
      if (res.data) {
        router.push({
          name: 'StartTrain',
          params: {
            trainId: res.data,
          },
        });
      }
    });
  };
</script>

<style scoped></style>
