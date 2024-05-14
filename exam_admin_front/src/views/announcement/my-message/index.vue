<template>
  <div>
    <Breadcrumb :items="['menu.announcement', 'menu.announcement.myMsg']" />
    <a-layout style="margin: 0 20px">
      <a-card
        class="general-card"
        :title="$t('menu.announcement.myMsg')"
        style="height: 680px"
      >
        <a-space align="center" style="margin-bottom: 20px">
          <a-select
            v-model="state"
            style="width: 200px"
            placeholder="请选择读取状态"
            allow-clear
            @change="stateChange"
          >
            <a-option :value="0">未读</a-option>
            <a-option :value="1">已读</a-option>
          </a-select>
          <a-button type="outline" @click="reset">
            <template #icon>
              <icon-refresh />
            </template>
            重置
          </a-button>
        </a-space>
        <a-table
          row-key="id"
          :loading="loading"
          :columns="columns"
          :data="msgList"
          :bordered="false"
          :scrollbar="true"
          :pagination="{
            showTotal: true,
            showPageSize: true,
            total: pagination.total,
            pageSize: pagination.pageSize,
            current: pagination.pageNo,
          }"
          :scroll="{ x: 100, y: 400 }"
          @page-change="pageChange"
          @page-size-change="pageSizeChange"
          @row-click="getMsgDetail"
        >
          <template #state="{ record }">
            <a-tag v-if="record.msgUser.state === 0" color="blue">未读</a-tag>
            <a-tag v-if="record.msgUser.state === 1" color="green">已读</a-tag>
          </template>
        </a-table>
      </a-card>

      <a-modal v-model:visible="visible" :footer="false" title="详细信息">
        <a-descriptions align="right" :column="2" size="large">
          <a-descriptions-item label="标题" :span="2">
            {{ currentRecord.title }}
          </a-descriptions-item>
          <a-descriptions-item label="内容" :span="2">
            {{ currentRecord.content }}
          </a-descriptions-item>
          <a-descriptions-item label="发送时间" :span="2">
            {{ currentRecord.sendTime }}
          </a-descriptions-item>
          <a-descriptions-item label="状态">
            <a-tag v-if="currentRecord.msgUser.state === 0" color="red"
              >未读</a-tag
            >
            <a-tag v-if="currentRecord.msgUser.state === 1" color="green"
              >已读</a-tag
            >
          </a-descriptions-item>
        </a-descriptions>
      </a-modal>
    </a-layout>
  </div>
</template>

<script setup lang="ts">
  import { onMounted, ref, watch } from 'vue';
  import { MsgVO } from '@/types/model/vo/MsgVO';
  import {
    getNotification,
    getReadNotification,
    getUnReadNotification,
    updateMsgUserById,
  } from '@/api/msg';
  import { useI18n } from 'vue-i18n';
  import { UpdateMsgUserDTo } from '@/types/model/dto/UpdateMsgUserDTo';
  import usePagination from '@/hooks/pagination';
  import useLoading from '@/hooks/loading';
  import SimplePage from '@/types/model/po/SimplePage';

  const { loading, setLoading } = useLoading(true);
  const { pagination, setPagination } = usePagination();

  const { t } = useI18n();

  // 详细信息对话框开关
  const visible = ref(false);

  // 当前对话框显示的信息
  const currentRecord = ref<MsgVO>({ msgUser: {} });

  const msgList = ref<MsgVO[]>([]);

  // 当前列表信息的状态（-1是获取所有信息）
  const state = ref<number>();

  const columns = [
    {
      title: t('announcement.columns.title'),
      dataIndex: 'title',
      slotName: 'title',
    },
    {
      title: t('announcement.columns.sendTime'),
      dataIndex: 'sendTime',
      slotName: 'sendTime',
    },
    {
      title: t('announcement.columns.state'),
      dataIndex: 'state',
      slotName: 'state',
    },
  ];

  const pageInfo = ref<SimplePage>(new SimplePage());

  const reloadNotification = async (page: SimplePage) => {
    setLoading(true);
    await getNotification(page).then((res: any) => {
      msgList.value = res.data.list;
      setPagination({
        total: res.data.totalCount,
        pageSize: res.data.pageSize,
        pageNo: res.data.pageNo,
        pageTotal: res.data.pageTotal,
      });
    });
    setLoading(false);
  };

  const reloadReadNotification = async (page: SimplePage) => {
    setLoading(true);
    await getReadNotification(page).then((res: any) => {
      msgList.value = res.data.list;
      setPagination({
        total: res.data.totalCount,
        pageSize: res.data.pageSize,
        pageNo: res.data.pageNo,
        pageTotal: res.data.pageTotal,
      });
    });
    setLoading(false);
  };

  const reloadUnReadNotification = async (page: SimplePage) => {
    setLoading(true);
    await getUnReadNotification(page).then((res: any) => {
      msgList.value = res.data.list;
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
    await reloadNotification(pageInfo.value);
  });

  const reset = async () => {
    state.value = undefined;
    await reloadNotification(new SimplePage());
  };

  // 下拉框改变
  const stateChange = async (value: number) => {
    state.value = value;
  };

  // 页码变化
  const pageChange = (pageNo: number) => {
    pageInfo.value.pageNo = pageNo;
  };
  // 每页数据量变化
  const pageSizeChange = (pageSize: number) => {
    pageInfo.value.pageSize = pageSize;
  };

  const getMsgDetail = async (record: MsgVO) => {
    visible.value = true;
    currentRecord.value = record;
    if (record.msgUser?.state === 0) {
      const temp = record.msgUser;
      temp.state = 1;
      const updateDTO: UpdateMsgUserDTo = {
        id: temp.id,
        msgUser: temp,
      };

      // 更新状态已读状态
      await updateMsgUserById(updateDTO).then(async (res: any) => {
        if (res.data === true) {
          // 重新通知获取列表
          state.value = -1;
          await reloadNotification({ pageSize: 10, pageNo: 1 } as SimplePage);
        }
      });
    }
  };

  watch(
    () => state.value,
    async (newState, oldState) => {
      if (state.value === 0) {
        await reloadUnReadNotification(new SimplePage());
      } else if (state.value === 1) {
        await reloadReadNotification(new SimplePage());
      }
    }
  );

  watch(
    pageInfo.value,
    async (newPagination, oldPagination) => {
      if (state.value === 0) {
        await reloadUnReadNotification(pageInfo.value);
      } else if (state.value === 1) {
        await reloadReadNotification(pageInfo.value);
      } else {
        await reloadNotification(pageInfo.value);
      }
    },
    {
      deep: true,
    }
  );
</script>

<style scoped></style>
