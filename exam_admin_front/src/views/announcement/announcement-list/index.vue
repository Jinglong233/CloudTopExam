<template>
  <div>
    <Breadcrumb :items="['menu.announcement', 'menu.announcement.announce']" />
    <a-layout style="margin: 0 20px">
      <a-card
        class="general-card"
        :title="$t('menu.announcement.announce')"
        style="height: 680px"
      >
        <a-scrollbar style="height: 500px; overflow: auto">
          <a-timeline mode="left" label-position="relative">
            <a-timeline-item
              v-for="announce in announceList"
              :key="announce.id"
              :label="announce.sendTime"
              dot-color="#52C419"
            >
              <div :style="{ marginBottom: '12px' }">
                {{ announce.title }}
                <div :style="{ fontSize: '12px', color: '#4E5969' }">
                  {{ announce.content }}
                </div>
              </div>
            </a-timeline-item>
          </a-timeline>
        </a-scrollbar>
      </a-card>
    </a-layout>
  </div>
</template>

<script setup lang="ts">
  import { onMounted, ref } from 'vue';
  import { Msg } from '@/types/model/po/Msg';
  import { getAnnouncement } from '@/api/msg';

  const announceList = ref<Msg[]>([]);

  onMounted(async () => {
    await getAnnouncement().then((res: any) => {
      announceList.value = res.data;
    });
  });
</script>

<style scoped></style>
