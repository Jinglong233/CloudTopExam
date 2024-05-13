<template>
  <div class="container">
    <Breadcrumb :items="['menu.log', 'menu.log.loginLog']" />
    <a-layout style="margin: 0 20px">
      <a-card
        class="general-card"
        :title="$t('menu.log.loginLog')"
        style="height: 680px"
      >
        <!--查询栏-->
        <a-space align="center" style="margin: 10px 0">
          <!--登录用户名-->
          <a-input
            v-model="loginLogSearch.userNameFuzzy"
            placeholder="请输入登录用户名"
            style="width: 200px"
          />

          <!--登录地址-->
          <a-input
            v-model="loginLogSearch.loginAddressFuzzy"
            placeholder="请输入登录地址"
            style="width: 200px"
          />

          <!--登录状态-->
          <a-select
            v-model="loginLogSearch.loginState"
            placeholder="请选择登录状态"
            style="width: 250px"
            allow-clear
          >
            <a-option :value="0">失败</a-option>
            <a-option :value="1">成功</a-option>
          </a-select>

          <!--登录时间-->
          <a-range-picker
            :placeholder="['请选择开始时间范围', '请选择结束时间范围']"
            style="width: 380px"
            @change="onDateChange"
          />
        </a-space>

        <a-table
          row-key="id"
          :loading="loading"
          :columns="columns"
          :data="loginLog"
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
          <template #loginState="{ record }">
            <a-tag v-if="record.loginState === 0" color="red">失败</a-tag>
            <a-tag v-if="record.loginState === 1" color="green">成功</a-tag>
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
  import { SimplePage } from '@/types/model/po/SimplePage';
  import { TableColumnData } from '@arco-design/web-vue/es/table/interface';
  import { useI18n } from 'vue-i18n';
  import useLoading from '@/hooks/loading';
  import MsgUserList from '@/views/msg-center/message-record/component/MsgUserList.vue';
  import { LoginLogQuery } from '@/types/model/query/LoginLogQuery';
  import { LoginLog } from '@/types/model/po/LoginLog';
  import { getLoginLogList } from '@/api/log';

  const { loading, setLoading } = useLoading(true);

  const { t } = useI18n();

  const pageInfo = ref<SimplePage>({
    pageNo: 1,
    pageSize: 10,
    pageTotal: 0,
    total: 0,
  });

  // 当前行记录
  const currentMsgId = ref();

  // 查询表单
  const loginLogSearch = ref<LoginLogQuery>({} as LoginLogQuery);
  const loginLog = ref<LoginLog[]>([]);
  // 消息详情对话框
  const visible = ref(false);
  // 获取消息列表
  const reloadLoginLog = async (loginLogQuery: LoginLogQuery) => {
    setLoading(true);
    await getLoginLogList(loginLogQuery).then((res: any) => {
      loginLog.value = res.data.list;
      pageInfo.value.total = res.data.totalCount;
      pageInfo.value.pageSize = res.data.pageSize;
      pageInfo.value.pageNo = res.data.pageNo;
      pageInfo.value.pageTotal = res.data.pageTotal;
    });
    setLoading(false);
  };
  onMounted(async () => {
    await reloadLoginLog(pageInfo.value);
  });

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
      title: t('log.columns.userName'),
      dataIndex: 'userName',
      slotName: 'userName',
      width: 100,
      ellipsis: true,
      tooltip: true,
    },
    {
      title: t('log.columns.ip'),
      dataIndex: 'ip',
      slotName: 'ip',
      width: 80,
      ellipsis: true,
      tooltip: true,
    },
    {
      title: t('log.columns.loginAddress'),
      dataIndex: 'loginAddress',
      slotName: 'loginAddress',
      width: 150,
      ellipsis: true,
      tooltip: true,
    },
    {
      title: t('log.columns.loginState'),
      dataIndex: 'loginState',
      slotName: 'loginState',
      width: 100,
      tooltip: true,
      ellipsis: true,
    },
    {
      title: t('log.columns.operMsg'),
      dataIndex: 'operMsg',
      slotName: 'operMsg',
      width: 80,
      ellipsis: true,
      tooltip: true,
    },
    {
      title: t('log.columns.loginTime'),
      dataIndex: 'loginTime',
      slotName: 'loginTime',
      width: 200,
      ellipsis: true,
      tooltip: true,
    },
  ]);

  // 日期变化，单独处理
  const onDateChange = (date: any[]) => {
    if (date) {
      loginLogSearch.value.loginTimeStart = date[0] as string;
      loginLogSearch.value.loginTimeEnd = date[1] as string;
    } else {
      loginLogSearch.value.loginTimeStart = '';
      loginLogSearch.value.loginTimeEnd = '';
    }
  };

  // 监视查询数据及其页码变化
  watch(
    [pageInfo.value, loginLogSearch.value],
    async (
      [newPageInfo, oldPageInfo],
      [newLoginLogSearch, oldLoginLogSearch]
    ) => {
      await reloadLoginLog({ ...pageInfo.value, ...loginLogSearch.value });
    },
    { deep: true, immediate: true }
  );
</script>

<style scoped></style>
