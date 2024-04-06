<template>
  <a-spin :loading="loading" style="width: 100%">
    <a-card
      title="未完成训练"
      class="general-card"
      :header-style="{ paddingBottom: '0' }"
      :body-style="{ padding: '17px 20px 21px 20px' }"
    >
      <a-empty v-if="trainList.length === 0 || trainList == null" />
      <a-list v-if="trainList.length !== 0">
        <template v-for="train in trainList" :key="train.id">
          <a-list-item>
            <template #actions>
              <a-space
                @click="
                  router.push({
                    name: 'TrainRecord',
                    params: {
                      trainId: train.id,
                    },
                  })
                "
              >
                <icon-play-circle
                  :stroke-width="2"
                  style="font-size: 25px; cursor: pointer"
                />
                继续训练
              </a-space>
            </template>
            {{ train.mode }}
          </a-list-item>
        </template>
      </a-list>
    </a-card>
  </a-spin>
</template>

<script lang="ts" setup>
  import { onMounted, ref } from 'vue';
  import { Train } from '@/types/model/po/Train';
  import { useUserStore } from '@/store';
  import { getTrain } from '@/api/train';
  import { Message } from '@arco-design/web-vue';
  import { useRouter } from 'vue-router';

  const router = useRouter();
  const userStore = useUserStore();
  const trainList = ref<Train[]>([]);
  const loading = ref(false);

  onMounted(async () => {
    loading.value = true;

    // 获取未完成的训练记录
    await getTrain({ userId: userStore.id, state: 0 }).then((res: any) => {
      loading.value = false;
      if (res) {
        trainList.value = res.data;
      } else {
        Message.warning({
          content: res.info,
          duration: 2000,
        });
      }
    });
  });
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
