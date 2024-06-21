<template>
  <div class="container">
    <Breadcrumb :items="['msg.center', 'msg.center.sendMsg']" />
    <a-layout style="margin: 0 20px">
      <a-card
        style="height: 530px"
        class="general-card"
        :title="t('msg.center.sendMsg')"
      >
        <a-form
          ref="sendMessageFormRef"
          :model="sendMessageForm"
          :scroll-to-first-error="true"
          :rules="formRule"
        >
          <!--消息标题-->
          <a-form-item label="消息标题" field="msgTitle">
            <a-input v-model="sendMessageForm.msgTitle" />
          </a-form-item>
          <!--消息内容-->
          <a-form-item label="消息内容" field="msgContent">
            <a-textarea
              v-model="sendMessageForm.msgContent"
              placeholder="请输入消息内容"
              allow-clear
            />
          </a-form-item>
          <!--提示信息-->
          <a-form-item>
            <a-alert>邮件目前只支持QQ邮箱发送</a-alert>
          </a-form-item>
          <!--消息类型-->
          <a-form-item
            tooltip="公告类型默认向所有人员开放,且不支持和其他消息类型一起发布"
            label="消息类型"
            field="msgType"
          >
            <a-checkbox-group
              v-model="sendMessageForm.msgType"
              @change="watchCheckBox"
            >
              <a-checkbox :value="0">公告</a-checkbox>
              <a-checkbox :value="1">通知</a-checkbox>
              <a-checkbox :value="2">邮件消息</a-checkbox>
            </a-checkbox-group>
          </a-form-item>

          <!--发送类型（全部、部门、指定人员）-->
          <a-form-item
            v-if="!sendMessageForm.msgType.includes(0)"
            label="发送类型"
            field="sendType"
          >
            <a-select
              v-model="sendMessageForm.sendType"
              :style="{ width: '320px' }"
              placeholder="请选择发送类型"
              @change="sendTypeChange"
            >
              <a-option :value="0">全部人员</a-option>
              <a-option :value="1">指定人员</a-option>
              <a-option :value="2">指定部门</a-option>
            </a-select>
            <a-button
              v-if="sendMessageForm.sendType === 1"
              type="primary"
              @click="dialogFlag = true"
              >继续添加</a-button
            >
          </a-form-item>
          <!--选择部门，人员的标签-->
          <a-form-item>
            <template v-if="sendMessageForm.sendType === 0">
              <a-tag color="arcoblue"> 全体人员 </a-tag>
            </template>
            <template v-if="sendMessageForm.sendType === 1">
              <a-tag color="arcoblue">
                已选{{ sendMessageForm.userList.length }}人
              </a-tag>
            </template>
            <template v-if="sendMessageForm.sendType === 2">
              <a-tag color="arcoblue">
                {{ getDeptText(sendMessageForm.deptCode, deptTree) }}
              </a-tag>
            </template>
          </a-form-item>
        </a-form>
        <a-button type="primary" :loading="loading" @click="send"
          >发布</a-button
        >
      </a-card>

      <a-modal
        :visible="dialogFlag"
        width="auto"
        @ok="dialogFlag = false"
        @cancel="dialogFlag = false"
      >
        <template v-if="sendMessageForm.sendType === 1">
          <a-space>
            <a-select
              v-model="userSearch.role"
              style="width: 200px"
              allow-clear
              placeholder="请选择角色"
            >
              <a-option value="student">学生</a-option>
              <a-option value="teacher">教师</a-option>
              <a-option value="admin">管理员</a-option>
            </a-select>
            <a-tree-select
              v-model="userSearch.deptCodeFuzzy"
              :data="deptTree"
              :field-names="{
                key: 'deptCode',
                title: 'deptName',
                children: 'children',
              }"
              placeholder="请选择部门"
              style="width: 200px"
              allow-clear
            />
            <a-input
              v-model="userSearch.userNameFuzzy"
              placeholder="搜索用户名"
            />
            <a-typography-text>
              已选择{{ sendMessageForm.userList.length }}人
            </a-typography-text>
          </a-space>
          <!--表格使用v-if销毁-->
          <a-table
            v-if="sendMessageForm.sendType === 1"
            ref="tableRef"
            :table-layout-fixed="true"
            row-key="id"
            style="margin-top: 20px"
            :data="userList"
            :columns="userColumns"
            :row-selection="{
              type: 'checkbox',
            }"
            :pagination="{
              showTotal: true,
              showPageSize: true,
              total: pageInfo.total,
              pageSize: pageInfo.pageSize,
              current: pageInfo.pageNo,
            }"
            :scroll="{ x: 100, y: 400 }"
            @page-change="pageChange"
            @page-size-change="pageSizeChange"
            @select="userTableRowSelect"
          >
            <template #role="{ record }">
              <a-tag v-if="record.role === 'student'" color="green">学生</a-tag>
              <a-tag v-if="record.role === 'teacher'" color="skyblue"
                >教师</a-tag
              >
              <a-tag v-if="record.role === 'admin'" color="orange"
                >管理员</a-tag
              >
            </template>
            <template #state="{ record }">
              <a-tag v-if="record.state === 0" color="green">正常</a-tag>
              <a-tag v-if="record.state === 1" color="red">异常</a-tag>
            </template>
          </a-table>
        </template>
        <template v-if="sendMessageForm.sendType === 2">
          <a-scrollbar type="track" style="height: 400px; overflow: auto">
            <a-space>
              <a-tree-select
                v-model="sendMessageForm.deptCode"
                :data="deptTree"
                :field-names="{
                  key: 'deptCode',
                  title: 'deptName',
                  children: 'children',
                }"
                placeholder="请选择部门"
                style="width: 500px"
                allow-clear
              />
            </a-space>
          </a-scrollbar>
        </template>
      </a-modal>
    </a-layout>
  </div>
</template>

<script lang="ts" setup>
  import { useI18n } from 'vue-i18n';
  import { onMounted, ref, toRefs, watch } from 'vue';
  import UserQuery from '@/types/model/query/UserQuery';
  import { getDeptTree } from '@/api/department';
  import { getDeptText } from '@/utils/common';
  import { getUserList } from '@/api/user';
  import SimplePage from '@/types/model/po/SimplePage';
  import { SendMessageDTO } from '@/types/model/dto/SendMessageDTO';
  import { TableColumnData } from '@arco-design/web-vue/es/table/interface';
  import { User } from '@/types/model/po/User';
  import { Message, ValidatedError } from '@arco-design/web-vue';
  import { sendMessage } from '@/api/message';
  import { useRouter } from 'vue-router';

  const { t } = useI18n();

  const loading = ref<boolean>(false);

  const router = useRouter();

  const dialogFlag = ref<boolean>(false);

  const userSearch = ref<UserQuery>({} as UserQuery);

  const deptTree = ref();

  // 用户列表数据
  const userList = ref<[]>();
  // 分页信息
  const pageInfo = ref<SimplePage>({
    pageNo: 1,
    pageSize: 5,
    pageTotal: 0,
    total: 0,
  });

  const formRule = {
    msgTitle: [{ required: true, message: '请输入消息标题' }],
    msgContent: { required: true, message: '请输入消息内容' },
    msgType: { required: true, message: '请勾选消息类型' },
    sendType: { required: true, message: '请选择发送类型' },
  };

  // 加载用户列表
  const reloadUserList = async (userQuery: UserQuery) => {
    await getUserList(userQuery).then((res: any) => {
      userList.value = res.data.list;
      pageInfo.value.total = res.data.totalCount;
      pageInfo.value.pageSize = res.data.pageSize;
      pageInfo.value.pageNo = res.data.pageNo;
      pageInfo.value.pageTotal = res.data.pageTotal;
    });
  };
  onMounted(async () => {
    await reloadUserList(pageInfo.value);
    await getDeptTree().then((res: any) => {
      deptTree.value = res.data;
    });
  });

  // 用户列配置
  const userColumns = ref<TableColumnData[]>([
    {
      title: t('department.userColumns.userName'),
      dataIndex: 'userName',
    },
    {
      title: t('department.userColumns.realName'),
      dataIndex: 'realName',
    },
    {
      title: t('department.userColumns.deptCode'),
      dataIndex: 'deptText',
    },
    {
      title: t('department.userColumns.role'),
      dataIndex: 'role',
      slotName: 'role',
    },
    {
      title: t('department.userColumns.state'),
      dataIndex: 'state',
      slotName: 'state',
    },
  ]);

  // 页码变化
  const pageChange = (pageNo: number) => {
    pageInfo.value.pageNo = pageNo;
  };
  // 每页数据量变化
  const pageSizeChange = (pageSize: number) => {
    pageInfo.value.pageSize = pageSize;
  };

  const sendMessageFormRef = ref();

  const sendMessageForm = ref<SendMessageDTO>({ userList: [], msgType: [] });

  const sendTypeChange = async (sendType: any) => {
    if (sendType !== 0) {
      dialogFlag.value = true;
    }

    if (sendType === 1) {
      // 重置指定部门
      sendMessageForm.value.deptCode = '';
      await reloadUserList(pageInfo.value);
      await getDeptTree().then((res: any) => {
        deptTree.value = res.data;
      });
    } else if (sendType === 2) {
      // 切换开放权限，清空用户列表
      sendMessageForm.value.userList = [];
      // 加载部门列表树
      await getDeptTree().then((res: any) => {
        deptTree.value = res.data;
      });
    } else {
      // 切换开放权限，清空用户列表
      sendMessageForm.value.userList = [];
      // 重置指定部门
      sendMessageForm.value.deptCode = '';
    }
    sendMessageForm.value.sendType = sendType;
  };

  const userTableRowSelect = (rowKeys: any, rowKey: any, record: User) => {
    if (!sendMessageForm.value.userList) {
      sendMessageForm.value.userList = [];
    }
    const isInclude = sendMessageForm.value.userList?.some(
      (userId: string) => userId === rowKey
    );
    if (!isInclude) {
      sendMessageForm.value.userList.push(rowKey);
    } else {
      // 移除取消选中的用户
      sendMessageForm.value.userList = sendMessageForm.value.userList.filter(
        (item) => item !== rowKey
      );
    }
  };

  // 检测复选框值的变化(如果选了公告,则移除其他消息类型)
  const watchCheckBox = () => {
    if (
      sendMessageForm.value.msgType !== undefined &&
      sendMessageForm.value.msgType.includes(0)
    ) {
      // 移除其他
      sendMessageForm.value.msgType = sendMessageForm.value.msgType.filter(
        (item: number) => item === 0
      );
    }
  };

  const send = () => {
    sendMessageFormRef.value.validate(
      async (errors: undefined | Record<string, ValidatedError>) => {
        if (!errors) {
          // 如果发送类型是指定成员和指定部门,对应列表则不能为空
          if (sendMessageForm.value.sendType === 1) {
            // 判断用户列表是否为空
            if (
              sendMessageForm.value.userList === undefined ||
              sendMessageForm.value.userList.length === 0
            ) {
              Message.warning({
                content: '请选择用户',
                duration: 2000,
              });
              return;
            }
          } else if (sendMessageForm.value.sendType === 2) {
            // 判断部门编号是否为空
            if (sendMessageForm.value.deptCode === '') {
              Message.warning({
                content: '请选择选择部门',
                duration: 2000,
              });
              return;
            }
          }
          loading.value = true;
          // 发送
          await sendMessage(sendMessageForm.value).then((res: any) => {
            if (res.data === true) {
              Message.success({
                content: res.msg,
                duration: 2000,
              });

              loading.value = false;
              // 清空添加消息表单
              sendMessageForm.value = {
                userList: [],
                msgType: [],
              };
            }
            loading.value = false;
          });
        }
      }
    );
  };

  // 监视查询数据及其页码变化(针对于指定用户)
  watch(
    [pageInfo.value, userSearch.value],
    async (
      [newPageInfo, oldPageInfo],
      [newUserRecordSearch, oldUserRecordSearch]
    ) => {
      await reloadUserList({ ...pageInfo.value, ...userSearch.value });
    },
    { deep: true }
  );
</script>

<style scoped></style>
