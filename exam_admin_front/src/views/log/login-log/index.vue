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
        <div>
          <a-row style="margin: 10px 0" :gutter="2">
            <!--登录用户名-->
            <a-col :span="6">
              <a-input
                v-model="loginLogSearch.userNameFuzzy"
                placeholder="请输入登录用户名"
                style="width: 250px"
              />
            </a-col>
            <!--登录地址-->
            <a-col :span="6">
              <a-input
                v-model="loginLogSearch.loginAddressFuzzy"
                placeholder="请输入登录地址"
                style="width: 250px"
              />
            </a-col>
            <!--登录状态-->
            <a-col :span="6">
              <a-select
                v-model="loginLogSearch.loginState"
                placeholder="请选择登录状态"
                style="width: 250px"
                allow-clear
              >
                <a-option :value="0">失败</a-option>
                <a-option :value="1">成功</a-option>
              </a-select>
            </a-col>
          </a-row>
          <a-row style="margin: 10px 0" :gutter="2">
            <!--登录时间-->
            <a-col :span="8">
              <a-range-picker
                :placeholder="['请选择开始时间范围', '请选择结束时间范围']"
                style="width: 380px"
                @change="onDateChange"
              />
            </a-col>
            <!--搜索重置按钮-->
            <a-col :span="8" style="margin-left: 10px">
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
              <a-button
                type="outline"
                status="danger"
                :loading="deleteLoading"
                style="margin: 0 5px"
                @click="handleDelete"
              >
                <template #icon>
                  <icon-delete />
                </template>
                删除
              </a-button>
            </a-col>
          </a-row>
        </div>

        <!--:row-selection="{
        type: 'checkbox',
        showCheckedAll: true,
        onlyCurrent: false,
        }"-->
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
            total: pagination.total,
            pageSize: pagination.pageSize,
            current: pagination.pageNo,
          }"
          :scroll="{ x: 100, y: 440 }"
          @select="rowSelect"
          @select-all="rowSelectAll"
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
  // todo 行选择器未改善
  import { onMounted, ref, toRaw, watch } from 'vue';
  import { TableColumnData } from '@arco-design/web-vue/es/table/interface';
  import { useI18n } from 'vue-i18n';
  import useLoading from '@/hooks/loading';
  import MsgUserList from '@/views/msg-center/message-record/component/MsgUserList.vue';
  import { LoginLog } from '@/types/model/po/LoginLog';
  import { deleteBatchLoginLog, getLoginLogList } from '@/api/log';
  import usePagination from '@/hooks/pagination';
  import LoginLogQuery from '@/types/model/query/LoginLogQuery';
  import SimplePage from '@/types/model/po/SimplePage';
  import { Message } from '@arco-design/web-vue';

  const { loading, setLoading } = useLoading(true);
  const { loading: deleteLoading, setLoading: setDeleteLoading } = useLoading();
  const { pagination, setPagination } = usePagination();

  const { t } = useI18n();

  // 当前行记录
  const currentMsgId = ref();

  // 删除列表
  const logDeleteList = ref<number[]>([]);

  // 查询表单
  const loginLogSearch = ref<LoginLogQuery>(new LoginLogQuery());
  const loginLog = ref<LoginLog[]>([]);
  // 消息详情对话框
  const visible = ref(false);
  // 获取消息列表
  const reloadLoginLog = async (loginLogQuery: LoginLogQuery) => {
    setLoading(true);
    await getLoginLogList(loginLogQuery).then((res: any) => {
      loginLog.value = res.data.list;
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
    await reloadLoginLog(loginLogSearch.value);
  });

  // 页码变化
  const pageChange = (pageNo: number) => {
    loginLogSearch.value.pageNo = pageNo;
  };
  // 每页数据量变化
  const pageSizeChange = (pageSize: number) => {
    loginLogSearch.value.pageSize = pageSize;
  };

  // 表头列名
  const columns = ref<TableColumnData[]>([
    {
      title: t('log.loginLog.columns.userName'),
      dataIndex: 'userName',
      slotName: 'userName',
      width: 100,
      ellipsis: true,
      tooltip: true,
    },
    {
      title: t('log.loginLog.columns.ip'),
      dataIndex: 'ip',
      slotName: 'ip',
      width: 80,
      ellipsis: true,
      tooltip: true,
    },
    {
      title: t('log.loginLog.columns.loginAddress'),
      dataIndex: 'loginAddress',
      slotName: 'loginAddress',
      width: 150,
      ellipsis: true,
      tooltip: true,
    },
    {
      title: t('log.loginLog.columns.loginState'),
      dataIndex: 'loginState',
      slotName: 'loginState',
      width: 100,
      tooltip: true,
      ellipsis: true,
    },
    {
      title: t('log.loginLog.columns.operMsg'),
      dataIndex: 'operMsg',
      slotName: 'operMsg',
      width: 80,
      ellipsis: true,
      tooltip: true,
    },
    {
      title: t('log.loginLog.columns.loginTime'),
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

  // 搜索
  const search = async () => {
    await reloadLoginLog(loginLogSearch.value);
  };

  // 重置
  const reset = async () => {
    loginLogSearch.value = new LoginLogQuery();
    pagination.value = new SimplePage();
    await reloadLoginLog(loginLogSearch.value);
  };

  // 全选按钮触发
  const rowSelectAll = (isAll: boolean) => {
    if (isAll) {
      if (loginLog.value) {
        logDeleteList.value = loginLog.value.map((item: any) => item.id);
      }
    } else {
      logDeleteList.value = [];
    }
  };

  // 勾选一行触发添加到删除列表
  const rowSelect = (
    rowKeys: string | number[],
    rowKey: string | number,
    record: any
  ) => {
    logDeleteList.value = rowKeys as number[];
  };

  // 删除
  const handleDelete = async () => {
    setDeleteLoading(true);
    await deleteBatchLoginLog(logDeleteList.value).then((res: any) => {
      if (res.data === true) {
        Message.success({
          content: '删除成功',
          duration: 2000,
        });
      }
    });
    setDeleteLoading(false);
  };

  // 监视页码变化
  watch(
    () => [loginLogSearch.value.pageNo, loginLogSearch.value.pageSize],
    async (newValue, oldValue) => {
      await reloadLoginLog(loginLogSearch.value);
    }
  );
</script>

<style scoped></style>
