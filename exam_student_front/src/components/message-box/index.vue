<template>
  <a-spin style="display: block" :loading="loading">
    <a-tabs
      v-model:activeKey="activeKey"
      type="rounded"
      destroy-on-hide
      @change="tabChange"
    >
      <a-tab-pane v-for="item in tabList" :key="item.key">
        <template #title>
          <span> {{ item.title }}</span>
        </template>
        <a-result v-if="!MsgList || !MsgList.length" status="404">
          <template #subtitle> {{ $t('messageBox.noContent') }} </template>
        </a-result>
        <List :render-list="MsgList" @item-click="handleItemClick" />
      </a-tab-pane>
    </a-tabs>
  </a-spin>
</template>

<script lang="ts" setup>
  import { ref, toRaw } from 'vue';
  import { useI18n } from 'vue-i18n';
  import useLoading from '@/hooks/loading';
  import {
    addOrUpdateBatch,
    getNotification,
    getUnReadNotification,
  } from '@/api/msg';
  import { useUserStore } from '@/store';
  import { MsgVO } from '@/types/model/vo/MsgVO';
  import { MsgUser } from '@/types/model/po/MsgUser';
  import { SimplePage } from '@/types/model/po/SimplePage';
  import List from './list.vue';

  interface TabItem {
    key: string;
    title: string;
    avatar?: string;
  }

  const userStore = useUserStore();
  const { loading, setLoading } = useLoading(true);
  const { t } = useI18n();
  const MsgList = ref<MsgVO[]>([]);
  const activeKey = ref('notice');
  const loadMsgData = async () => {
    await getNotification({ pageNo: 1, pageSize: 3 } as SimplePage).then(
      (res: any) => {
        MsgList.value = res.data.list;
      }
    );
  };
  const emit = defineEmits(['refreshUnreadMsgCount']);

  const tabList: TabItem[] = [
    {
      key: 'notice',
      title: t('messageBox.tab.title.notice'),
    },
    {
      key: 'todo',
      title: t('messageBox.tab.title.todo'),
    },
  ];

  async function fetchSourceData() {
    setLoading(true);
    try {
      await loadMsgData();
    } catch (err) {
      // you can report use errorHandler or other
    } finally {
      setLoading(false);
    }
  }

  // 切换tab时触发
  const tabChange = async (index: string) => {
    emit('refreshUnreadMsgCount');
    if (index === 'todo') {
      activeKey.value = 'todo';
      await getUnReadNotification({
        pageNo: 1,
        pageSize: 3,
      } as SimplePage).then((res: any) => {
        MsgList.value = res.data.list;
      });
    } else if (index === 'notice') {
      activeKey.value = 'notice';
      await loadMsgData();
    }
  };

  // 全部已读（更新当前显示数据的读取状态->全部已读）
  const handleItemClick = async (allReadList: []) => {
    const msgUserList = allReadList.map(
      (msgVO: MsgVO) => msgVO.msgUser
    ) as MsgUser[];
    msgUserList.forEach((msgUser: MsgUser) => {
      msgUser.state = 1;
    });
    // 创建更新对象
    await addOrUpdateBatch(msgUserList).then(async (res: any) => {
      // 刷新消息列表
      await loadMsgData();
      emit('refreshUnreadMsgCount');
    });
  };

  fetchSourceData();
</script>

<style scoped lang="less">
  :deep(.arco-popover-popup-content) {
    padding: 0;
  }

  :deep(.arco-list-item-meta) {
    align-items: flex-start;
  }
  :deep(.arco-tabs-nav) {
    padding: 14px 0 12px 16px;
    border-bottom: 1px solid var(--color-neutral-3);
  }
  :deep(.arco-tabs-content) {
    padding-top: 0;
    .arco-result-subtitle {
      color: rgb(var(--gray-6));
    }
  }
</style>
