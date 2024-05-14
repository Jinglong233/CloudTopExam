<template>
  <div class="container">
    <Breadcrumb :items="['menu.log', 'menu.log.operationLog']" />
    <a-layout style="margin: 0 20px">
      <a-card
        class="general-card"
        :title="$t('menu.log.operationLog')"
        style="height: 680px"
      >
        <!--查询栏-->
        <div>
          <a-row :gutter="5" style="margin-bottom: 16px">
            <!--操作人员-->
            <a-col :span="6">
              <a-input
                v-model="operationLogSearch.userNameFuzzy"
                placeholder="请输入操作人员"
                style="width: 250px"
              />
            </a-col>

            <!--操作地址-->
            <a-col :span="6">
              <a-input
                v-model="operationLogSearch.operAddressFuzzy"
                placeholder="请输入操作地址"
                style="width: 250px"
              />
            </a-col>

            <!--操作状态-->
            <a-col :span="6">
              <a-select
                v-model="operationLogSearch.success"
                placeholder="请选择登录状态"
                style="width: 250px"
                allow-clear
              >
                <a-option :value="0">失败</a-option>
                <a-option :value="1">成功</a-option>
              </a-select>
            </a-col>
          </a-row>

          <a-row :gutter="5" style="margin-bottom: 16px">
            <!--操作类型-->
            <a-col :span="6">
              <a-select
                v-model="operationLogSearch.operType"
                placeholder="请选择操作类型"
                style="width: 250px"
                allow-clear
              >
                <a-option :value="0">新增</a-option>
                <a-option :value="1">删除</a-option>
                <a-option :value="2">更新</a-option>
              </a-select>
            </a-col>

            <!--操作时间-->
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
          :data="operationLog"
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
          @page-change="pageChange"
          @page-size-change="pageSizeChange"
        >
          <template #success="{ record }">
            <a-tag v-if="record.success === 0" color="red">失败</a-tag>
            <a-tag v-if="record.success === 1" color="green">成功</a-tag>
          </template>
        </a-table>
      </a-card>
    </a-layout>
  </div>
</template>

<script setup lang="ts">
  import { onMounted, ref, watch } from 'vue';
  import { TableColumnData } from '@arco-design/web-vue/es/table/interface';
  import { useI18n } from 'vue-i18n';
  import useLoading from '@/hooks/loading';

  import { OperLog } from '@/types/model/po/OperLog';
  import { getOperationLogList } from '@/api/log';
  import OperLogQuery from '@/types/model/query/OperLogQuery';
  import usePagination from '@/hooks/pagination';
  import LoginLogQuery from '@/types/model/query/LoginLogQuery';
  import SimplePage from '@/types/model/po/SimplePage';

  const { loading, setLoading } = useLoading(true);

  const { pagination, setPagination } = usePagination();
  const { t } = useI18n();

  // 当前行记录
  const currentMsgId = ref();

  // 查询表单
  const operationLogSearch = ref<OperLogQuery>(new OperLogQuery());
  const operationLog = ref<OperLog[]>([]);
  // 消息详情对话框
  const visible = ref(false);
  // 获取消息列表
  const reloadOperationLog = async (operLogQuery: OperLogQuery) => {
    setLoading(true);
    await getOperationLogList(operLogQuery).then((res: any) => {
      if (res.data) {
        operationLog.value = res.data.list;
        setPagination({
          total: res.data.totalCount,
          pageSize: res.data.pageSize,
          pageNo: res.data.pageNo,
          pageTotal: res.data.pageTotal,
        });
      }
    });
    setLoading(false);
  };
  onMounted(async () => {
    await reloadOperationLog(operationLogSearch.value);
  });

  // 页码变化
  const pageChange = (pageNo: number) => {
    operationLogSearch.value.pageNo = pageNo;
  };
  // 每页数据量变化
  const pageSizeChange = (pageSize: number) => {
    operationLogSearch.value.pageSize = pageSize;
  };

  // 表头列名
  const columns = ref<TableColumnData[]>([
    {
      title: t('log.operLog.columns.operType'),
      dataIndex: 'operType',
      slotName: 'operType',
      width: 100,
      ellipsis: true,
      tooltip: true,
    },
    {
      title: t('log.operLog.columns.userName'),
      dataIndex: 'userName',
      slotName: 'userName',
      width: 80,
      ellipsis: true,
      tooltip: true,
    },
    {
      title: t('log.operLog.columns.ip'),
      dataIndex: 'ip',
      slotName: 'ipinAddress',
      width: 150,
      ellipsis: true,
      tooltip: true,
    },
    {
      title: t('log.operLog.columns.operAddress'),
      dataIndex: 'operAddress',
      slotName: 'operAddress',
      width: 100,
      tooltip: true,
      ellipsis: true,
    },
    {
      title: t('log.operLog.columns.success'),
      dataIndex: 'success',
      slotName: 'success',
      width: 80,
      ellipsis: true,
      tooltip: true,
    },
    {
      title: t('log.operLog.columns.operTime'),
      dataIndex: 'operTime',
      slotName: 'operTime',
      width: 200,
      ellipsis: true,
      tooltip: true,
    },
  ]);

  // 日期变化，单独处理
  const onDateChange = (date: any[]) => {
    if (date) {
      operationLogSearch.value.operTimeStart = date[0] as string;
      operationLogSearch.value.operTimeEnd = date[1] as string;
    } else {
      operationLogSearch.value.operTimeStart = '';
      operationLogSearch.value.operTimeEnd = '';
    }
  };

  // 搜索
  const search = async () => {
    await reloadOperationLog(operationLogSearch.value);
  };

  // 重置
  const reset = async () => {
    operationLogSearch.value = new OperLogQuery();
    pagination.value = new SimplePage();
    await reloadOperationLog(operationLogSearch.value);
  };

  // 监视页码变化
  watch(
    () => [operationLogSearch.value.pageNo, operationLogSearch.value.pageSize],
    async (newValue, oldValue) => {
      await reloadOperationLog(operationLogSearch.value);
    }
  );
</script>

<style scoped></style>
