<template>
  <a-modal :visible="flag" :hide-title="true" @cancel="close">
    <!--查询栏-->
    <a-space align="center" style="margin-bottom: 10px">
      <!--消息状态类型-->
      <a-select
        v-model="messageUserSearch.state"
        placeholder="请选择状态类型"
        style="width: 250px"
        allow-clear
      >
        <a-option :value="-1">异常</a-option>
        <a-option :value="0">未读</a-option>
        <a-option :value="1">已读</a-option>
      </a-select>
    </a-space>

    <a-table
      row-key="id"
      :loading="loading"
      :columns="columns"
      :data="msgUserList"
      :bordered="false"
      :scrollbar="true"
      :pagination="{
        showTotal: true,
        showPageSize: true,
        total: pageInfo.total,
        pageSize: pageInfo.pageSize,
        current: pageInfo.pageNo,
      }"
      :scroll="{ x: 100, y: 440 }"
      @page-change="pageChange"
      @page-size-change="pageSizeChange"
    >
      <template #state="{ record }">
        <a-tag v-if="record.msgUser.state === -1" color="red">异常</a-tag>
        <a-tag v-if="record.msgUser.state === 0" color="blue">未读</a-tag>
        <a-tag v-if="record.msgUser.state === 1" color="green">已读</a-tag>
      </template>
    </a-table>
  </a-modal>
</template>

<script setup lang="ts">
  import { ref, watch } from 'vue';
  import { MsgVO } from '@/types/model/vo/MsgVO';
  import { getMessageUser } from '@/api/message';
  import { MsgUserQuery } from '@/types/model/query/MsgUserQuery';
  import { TableColumnData } from '@arco-design/web-vue/es/table/interface';
  import { useI18n } from 'vue-i18n';
  import { SimplePage } from '@/types/model/po/SimplePage';
  import useLoading from '@/hooks/loading';

  const { loading, setLoading } = useLoading(true);

  const { t } = useI18n();

  const pageInfo = ref<SimplePage>({
    pageNo: 1,
    pageSize: 10,
    pageTotal: 0,
    total: 0,
  });

  const messageUserSearch = ref<MsgUserQuery>({} as MsgUserQuery);

  const props = defineProps({
    flag: {
      type: Boolean,
      default() {
        return false;
      },
    },
    msgId: {
      type: String,
      default() {
        return '';
      },
    },
  });

  const emit = defineEmits(['closeDialog']);
  const msgUserList = ref<MsgVO[]>([]);

  const reloadMessageUserList = async (msgUserQuery: MsgUserQuery) => {
    setLoading(true);
    await getMessageUser({ msgId: props.msgId, ...msgUserQuery }).then(
      (res: any) => {
        msgUserList.value = res.data.list;
        pageInfo.value.total = res.data.totalCount;
        pageInfo.value.pageSize = res.data.pageSize;
        pageInfo.value.pageNo = res.data.pageNo;
        pageInfo.value.pageTotal = res.data.pageTotal;
      }
    );
    setLoading(false);
  };

  const close = () => {
    emit('closeDialog', false);
  };

  // 页码变化
  const pageChange = (pageNo: number) => {
    pageInfo.value.pageNo = pageNo;
  };
  // 每页数据量变化
  const pageSizeChange = (pageSize: number) => {
    pageInfo.value.pageSize = pageSize;
  };

  // 表头列名
  const columns = ref<TableColumnData[]>([
    {
      title: t('msgUser.columns.createUserText'),
      dataIndex: 'createUserText',
      slotName: 'createUserText',
      width: 100,
      ellipsis: true,
      tooltip: true,
    },
    {
      title: t('msgUser.columns.state'),
      dataIndex: 'msgUser.state',
      slotName: 'state',
      width: 100,
      tooltip: true,
      ellipsis: true,
    },
  ]);

  watch(
    () => props.msgId,
    async (newVal) => {
      await reloadMessageUserList({
        msgId: newVal,
        ...pageInfo.value,
        ...messageUserSearch.value,
      });
    },
    { deep: true, immediate: true }
  );

  // 监视查询数据及其页码变化
  watch(
    [pageInfo.value, messageUserSearch.value],
    async (
      [newPageInfo, oldPageInfo],
      [newMsgUserSearch, oldMsgUserSearch]
    ) => {
      await reloadMessageUserList({
        msgId: props.msgId,
        ...pageInfo.value,
        ...messageUserSearch.value,
      });
    },
    { deep: true }
  );
</script>

<style scoped></style>
