<template>
  <a-card
    class="general-card"
    :title="$t('userSetting.label.paper')"
    :header-style="{ paddingBottom: '18px' }"
    :body-style="{ paddingBottom: '12px' }"
  >
    <template #extra>
      <a-link @click="goPaperManager">{{ $t('userInfo.showMore') }}</a-link>
    </template>
    <a-list :bordered="false" :scrollbar="true" :max-height="280">
      <a-list-item
        v-for="paper in myCreatePaper"
        :key="paper.id"
        action-layout="horizontal"
      >
        <a-skeleton v-if="loading" :loading="loading" :animation="true">
          <a-row :gutter="6">
            <a-col :span="6">
              <a-skeleton-shape shape="circle" />
            </a-col>
            <a-col :span="16">
              <a-skeleton-line :widths="['100%', '40%']" :rows="2" />
            </a-col>
          </a-row>
        </a-skeleton>
        <a-list-item-meta v-else :title="paper.title">
          <template #description>
            <a-space>总分： {{ paper.totalCount }}分 </a-space>
          </template>
        </a-list-item-meta>
        <template v-if="!loading" #actions>
          <icon-eye @click="goPaperPreview(paper.id)" />
        </template>
      </a-list-item>
    </a-list>
  </a-card>
</template>

<script lang="ts" setup>
  import { onMounted, ref } from 'vue';
  import { Paper } from '@/types/model/po/Paper';
  import { getPaperList } from '@/api/paper';
  import { useUserStore } from '@/store';
  import PaperQuery from '@/types/model/query/PaperQuery';
  import { useRouter } from 'vue-router';

  const router = useRouter();
  const myCreatePaper = ref<Paper[]>();
  const userStore = useUserStore();
  const loading = ref(true);

  onMounted(async () => {
    await getPaperList({
      createBy: userStore.id,
      pageSize: 5,
    } as PaperQuery).then((res: any) => {
      myCreatePaper.value = res.data.list;
      loading.value = false;
    });
  });

  // 预览试卷
  const goPaperPreview = (paperId: string) => {
    router.push({
      name: 'PreviewPaper',
      query: {
        id: paperId,
      },
    });
  };

  // 前往试卷管理界面
  const goPaperManager = () => {
    router.push({
      name: 'PaperManager',
    });
  };
</script>

<style scoped lang="less">
  .general-card {
    height: 356px;
    .arco-list-item {
      height: 72px;
      padding-bottom: 12px;
      padding-left: 0;
      border-bottom: 1px solid var(--color-neutral-3);
      &:last-child {
        border-bottom: none;
      }
      .arco-list-item-meta {
        padding: 0;
      }
    }
  }
</style>
