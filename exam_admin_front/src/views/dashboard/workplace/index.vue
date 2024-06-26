<template>
  <div class="container">
    <div class="left-side">
      <div class="panel">
        <Banner />
        <DataPanel />
        <WaitCorrect />
      </div>
      <a-grid :cols="24" :col-gap="16" :row-gap="16" style="margin-top: 16px">
        <a-grid-item
          :span="{ xs: 24, sm: 24, md: 24, lg: 12, xl: 12, xxl: 12 }"
        >
          <PopularContent />
        </a-grid-item>
        <a-grid-item
          :span="{ xs: 24, sm: 24, md: 24, lg: 12, xl: 12, xxl: 12 }"
        >
          <CategoriesPercent />
        </a-grid-item>
      </a-grid>
    </div>
    <div class="right-side">
      <a-grid :cols="24" :row-gap="16">
        <a-grid-item class="panel" :span="24">
          <Announcement :announce-list="announceList" />
        </a-grid-item>
        <a-grid-item class="panel" :span="24">
          <Carousel />
        </a-grid-item>
        <a-grid-item class="panel" :span="24">
          <Docs />
        </a-grid-item>
      </a-grid>
    </div>
  </div>
</template>

<script lang="ts" setup>
  import { onMounted, ref } from 'vue';
  import { Msg } from '@/types/model/po/Msg';
  import { getAnnouncement } from '@/api/msg';
  import Banner from './components/banner.vue';
  import DataPanel from './components/data-panel.vue';
  import WaitCorrect from './components/exam-data-chart.vue';
  import PopularContent from './components/wait-correct.vue';
  import CategoriesPercent from './components/categories-percent.vue';
  import Announcement from './components/announcement.vue';
  import Carousel from './components/carousel.vue';
  import Docs from './components/docs.vue';

  const announceList = ref<Msg[]>([]);

  onMounted(async () => {
    await getAnnouncement().then((res: any) => {
      if (res.data && res.data.length > 3) {
        announceList.value = res.data.splice(0, 3);
      } else if (res.data) {
        announceList.value = res.data;
      }
    });
  });
</script>

<style lang="less" scoped>
  .container {
    display: flex;
    padding: 16px 20px;
    padding-bottom: 0;
    background-color: var(--color-fill-2);
  }

  .left-side {
    flex: 1;
    overflow: auto;
  }

  .right-side {
    width: 280px;
    margin-left: 16px;
  }

  .panel {
    overflow: auto;
    background-color: var(--color-bg-2);
    border-radius: 4px;
  }
  :deep(.panel-border) {
    margin-bottom: 0;
    border-bottom: 1px solid rgb(var(--gray-2));
  }
  .moduler-wrap {
    background-color: var(--color-bg-2);
    border-radius: 4px;
    :deep(.text) {
      color: rgb(var(--gray-8));
      font-size: 12px;
      text-align: center;
    }

    :deep(.wrapper) {
      margin-bottom: 8px;
      text-align: center;
      cursor: pointer;

      &:last-child {
        .text {
          margin-bottom: 0;
        }
      }
      &:hover {
        .icon {
          color: rgb(var(--arcoblue-6));
          background-color: #e8f3ff;
        }
        .text {
          color: rgb(var(--arcoblue-6));
        }
      }
    }

    :deep(.icon) {
      display: inline-block;
      width: 32px;
      height: 32px;
      margin-bottom: 4px;
      color: rgb(var(--dark-gray-1));
      font-size: 16px;
      line-height: 32px;
      text-align: center;
      background-color: rgb(var(--gray-1));
      border-radius: 4px;
    }
  }
</style>

<style lang="less" scoped>
  // responsive
  .mobile {
    .container {
      display: block;
    }
    .right-side {
      // display: none;
      width: 100%;
      margin-top: 16px;
      margin-left: 0;
    }
  }
</style>
