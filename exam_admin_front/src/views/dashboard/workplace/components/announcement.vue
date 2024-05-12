<template>
  <a-card
    class="general-card"
    :title="$t('workplace.announcement')"
    :header-style="{ paddingBottom: '0' }"
    :body-style="{ padding: '15px 20px 13px 20px' }"
  >
    <a-empty v-if="!announceList || announceList.length === 0" />
    <template #extra>
      <a-link @click="router.push({ name: 'AnnounceList' })">{{
        $t('workplace.viewMore')
      }}</a-link>
    </template>
    <div>
      <div v-for="(item, idx) in announceList" :key="idx" class="item">
        <a-tag color="orange" size="small">公告</a-tag>
        <span class="item-content">
          {{ item.title }}
        </span>
      </div>
    </div>
  </a-card>
</template>

<script lang="ts" setup>
  import { PropType } from 'vue/dist/vue';
  import { Msg } from '@/types/model/po/Msg';
  import { useRouter } from 'vue-router';

  const router = useRouter();

  defineProps({
    announceList: {
      type: Array as PropType<Msg[]>,
      default() {
        return [];
      },
    },
  });
</script>

<style scoped lang="less">
  .item {
    display: flex;
    align-items: center;
    width: 100%;
    height: 24px;
    margin-bottom: 4px;
    .item-content {
      flex: 1;
      margin-left: 4px;
      overflow: hidden;
      color: var(--color-text-2);
      font-size: 13px;
      white-space: nowrap;
      text-decoration: none;
      text-overflow: ellipsis;
      cursor: pointer;
    }
  }
</style>
