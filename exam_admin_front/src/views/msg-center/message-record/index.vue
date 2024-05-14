<template>
  <div class="container">
    <Breadcrumb :items="['msg.center', 'msg.center.msgRecord']" />
    <a-layout style="margin: 0 20px">
      <a-card
        class="general-card"
        :title="$t('msg.center.msgRecord')"
        style="height: 680px"
      >
        <a-alert>注意：公告默认所有人读取，没有关联具体用户</a-alert>
        <!--查询栏-->
        <div style="margin-top: 10px">
          <a-row style="margin-bottom: 16px" :gutter="5">
            <!--消息标题-->
            <a-col :span="6">
              <a-input
                v-model="messageSearch.titleFuzzy"
                placeholder="请输入消息标题"
                style="width: 250px"
              />
            </a-col>
            <!--消息标题-->
            <a-col :span="6">
              <a-input
                v-model="messageSearch.createUserTextFuzzy"
                placeholder="请输入创建人姓名"
                style="width: 250px"
              />
            </a-col>
            <!--消息类型-->
            <a-col :span="6">
              <a-select
                v-model="messageSearch.msgType"
                placeholder="请选择消息类型"
                style="width: 250px"
                allow-clear
              >
                <a-option :value="0">公告</a-option>
                <a-option :value="1">通知</a-option>
                <a-option :value="2">邮件</a-option>
              </a-select>
            </a-col>
          </a-row>
          <a-row style="margin-bottom: 16px" :gutter="5">
            <!--消息时间-->
            <a-col :span="6">
              <a-range-picker
                :placeholder="['开始时间', '结束时间']"
                style="width: 250px"
                @change="onDateChange"
              />
            </a-col>
            <!--搜索重置按钮-->
            <a-col :span="6">
              <a-button type="primary" style="margin: 0 5px" @click="search">
                <template #icon>
                  <icon-search />
                </template>
                搜索
              </a-button>
              <a-button type="primary" style="margin: 0 5px" @click="reset">
                <template #icon>
                  <icon-refresh />
                </template>
                重置
              </a-button>
            </a-col>
          </a-row>
        </div>

        <a-table
          row-key="id"
          :loading="loading"
          :columns="columns"
          :data="messageList"
          :bordered="false"
          :scrollbar="true"
          :pagination="{
            showTotal: true,
            showPageSize: true,
            total: pagination.total,
            pageSize: pagination.pageSize,
            current: pagination.pageNo,
          }"
          :scroll="{ x: 100, y: 350 }"
          @row-click="getMsgUser"
          @page-change="pageChange"
          @page-size-change="pageSizeChange"
        >
          <template #msgType="{ record }">
            <a-tag v-if="record.msgType === 0" color="blue">公告</a-tag>
            <a-tag v-if="record.msgType === 1" color="green">通知</a-tag>
            <a-tag v-if="record.msgType === 2" color="orange">邮件</a-tag>
          </template>

          <template #state="{ record }">
            <a-tag v-if="record.state === 0" color="red">失败</a-tag>
            <a-tag v-if="record.state === 1" color="blue">成功</a-tag>
          </template>
        </a-table>
        <MsgUserList
          :flag="visible"
          :msg-id="currentMsgId"
          @close-dialog="visible = false"
        />
      </a-card>
    </a-layout>
  </div>
</template>

<script setup lang="ts">
  import { onMounted, ref, watch } from 'vue';
  import { TableColumnData } from '@arco-design/web-vue/es/table/interface';
  import { useI18n } from 'vue-i18n';
  import { Msg } from '@/types/model/po/Msg';
  import MsgQuery from '@/types/model/query/MsgQuery';
  import { getMessageRecord } from '@/api/message';
  import useLoading from '@/hooks/loading';
  import { Message } from '@arco-design/web-vue';
  import MsgUserList from '@/views/msg-center/message-record/component/MsgUserList.vue';
  import usePagination from '@/hooks/pagination';
  import ExamQuery from '@/types/model/query/ExamQuery';
  import SimplePage from '@/types/model/po/SimplePage';

  const { loading, setLoading } = useLoading(true);
  const { pagination, setPagination } = usePagination();

  const { t } = useI18n();

  // 当前行记录
  const currentMsgId = ref();

  // 查询表单
  const messageSearch = ref<MsgQuery>(new MsgQuery());
  const messageList = ref<Msg[]>([]);
  // 消息详情对话框
  const visible = ref(false);
  // 获取消息列表
  const reloadMessageList = async (msgQuery: MsgQuery) => {
    setLoading(true);
    await getMessageRecord(msgQuery).then((res: any) => {
      messageList.value = res.data.list;
      setPagination({
        total: res.data.totalCount,
        pageSize: res.data.pageSize,
        pageNo: res.data.pageNo,
        pageTotal: res.data.pageTotal,
      });
    });
    setLoading(false);
  };
  onMounted(async () => {
    await reloadMessageList(messageSearch.value);
  });

  // 页码变化
  const pageChange = (pageNo: number) => {
    messageSearch.value.pageNo = pageNo;
  };
  // 每页数据量变化
  const pageSizeChange = (pageSize: number) => {
    messageSearch.value.pageSize = pageSize;
  };

  // 获取当前消息关联的用户
  const getMsgUser = (record: any) => {
    if (record.id === undefined || record.id.trim() === '') {
      Message.warning({
        content: '当前消息记录信息有误',
        duration: 2000,
      });
      return;
    }
    visible.value = true;
    currentMsgId.value = record.id;
  };

  // 表头列名
  const columns = ref<TableColumnData[]>([
    {
      title: t('msg.columns.title'),
      dataIndex: 'title',
      slotName: 'title',
      width: 100,
      ellipsis: true,
      tooltip: true,
    },
    {
      title: t('msg.columns.content'),
      dataIndex: 'content',
      slotName: 'content',
      width: 100,
      tooltip: true,
      ellipsis: true,
    },
    {
      title: t('msg.columns.msgType'),
      dataIndex: 'msgType',
      slotName: 'msgType',
      width: 80,
      ellipsis: true,
      tooltip: true,
    },
    {
      title: t('msg.columns.sendCount'),
      dataIndex: 'sendCount',
      slotName: 'sendCount',
      width: 80,
      ellipsis: true,
      tooltip: true,
    },
    {
      title: t('msg.columns.readCount'),
      dataIndex: 'readCount',
      slotName: 'readCount',
      width: 80,
      ellipsis: true,
      tooltip: true,
    },
    {
      title: t('msg.columns.sendTime'),
      dataIndex: 'sendTime',
      slotName: 'sendTime',
      width: 150,
      ellipsis: true,
      tooltip: true,
    },
    {
      title: t('msg.columns.state'),
      dataIndex: 'state',
      slotName: 'state',
      width: 80,
      ellipsis: true,
      tooltip: true,
    },
    {
      title: t('msg.columns.createUserText'),
      dataIndex: 'createUserText',
      slotName: 'createUserText',
      width: 200,
      ellipsis: true,
    },
  ]);

  // 日期变化，单独处理
  const onDateChange = (date: any[]) => {
    if (date) {
      messageSearch.value.sendTimeStart = date[0] as string;
      messageSearch.value.sendTimeEnd = date[1] as string;
    } else {
      messageSearch.value.sendTimeStart = '';
      messageSearch.value.sendTimeEnd = '';
    }
  };

  // 搜索
  const search = async () => {
    await reloadMessageList(messageSearch.value);
  };

  // 重置
  const reset = async () => {
    messageSearch.value = new MsgQuery();
    pagination.value = new SimplePage();
    await reloadMessageList(messageSearch.value);
  };

  // 监视页码变化
  watch(
    () => [messageSearch.value.pageNo, messageSearch.value.pageSize],
    async (newValue, oldValue) => {
      await reloadMessageList(messageSearch.value);
    }
  );
</script>

<style scoped></style>
