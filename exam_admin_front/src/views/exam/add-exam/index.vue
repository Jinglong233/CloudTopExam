<template>
  <div class="container">
    <Breadcrumb :items="['menu.exam', 'menu.exam.addExam']" />

    <a-layout style="margin-left: 20px">
      <a-layout-content style="height: 580px; width: 800px">
        <a-card
          style="height: 530px"
          class="general-card"
          :title="t('menu.exam.addExam')"
        >
          <a-tabs
            direction="vertical"
            :active-key="activeKey"
            @change="panelChange"
          >
            <a-tab-pane :key="1" title="基础设置">
              <a-form
                ref="addExamFormRef"
                :model="addExamForm"
                :scroll-to-first-error="true"
                :rules="formRules"
              >
                <a-row>
                  <a-form-item label="考试名称" field="title">
                    <a-input
                      v-model="addExamForm.title"
                      placeholder="输入考试名称"
                    />
                  </a-form-item>
                </a-row>
                <a-row :gutter="8">
                  <a-col :span="12">
                    <a-form-item
                      label="考试开始时间"
                      label-col-flex="120px"
                      field="startTime"
                    >
                      <a-date-picker
                        v-model="addExamForm.startTime"
                        placeholder="请选择考试开始时间"
                        style="width: 220px; margin: 0 24px 24px 0"
                        show-time
                        format="YYYY-MM HH:mm:ss"
                        :disabled-input="true"
                        :disabled-date="
                          (current) =>
                            dayjs(current).isBefore(dayjs().subtract(1, 'day'))
                        "
                      />
                    </a-form-item>
                  </a-col>
                  <a-col :span="12">
                    <a-form-item
                      label="考试结束时间"
                      field="endTime"
                      label-col-flex="120px"
                    >
                      <a-date-picker
                        v-model="addExamForm.endTime"
                        placeholder="请选择考试结束时间"
                        style="width: 220px; margin: 0 24px 24px 0"
                        show-time
                        format="YYYY-MM HH:mm:ss"
                        :disabled-input="true"
                        :disabled-date="
                          (current) =>
                            dayjs(current).isBefore(
                              dayjs(addExamForm.startTime).subtract(1, 'day')
                            )
                        "
                      />
                    </a-form-item>
                  </a-col>
                </a-row>
                <a-row :gutter="8">
                  <a-col :span="12">
                    <a-form-item
                      label="及格分"
                      field="qualifyScore"
                      label-col-flex="120px"
                    >
                      <a-input-number
                        v-model="addExamForm.qualifyScore"
                        style="width: 220px; margin: 0 24px 24px 0"
                        :min="0"
                        :max="paperInfo.totalCount"
                        mode="button"
                        placeholder="输入及格分"
                      />
                    </a-form-item>
                  </a-col>
                  <a-col :span="12">
                    <a-form-item
                      label="考试时长"
                      field="duration"
                      label-col-flex="120px"
                      tooltip="单位：分钟（时长由开始时间和结束时间推算而来）"
                    >
                      <a-input-number
                        v-model="addExamForm.duration"
                        style="width: 220px; margin: 0 24px 24px 0"
                        :min="0"
                        mode="button"
                        disabled
                        placeholder="请输入考试时长"
                      />
                    </a-form-item>
                  </a-col>
                </a-row>
                <a-row :gutter="8">
                  <a-col :span="12">
                    <a-form-item
                      label="最低交卷时长"
                      field="handMin"
                      label-col-flex="120px"
                      tooltip="最低答题分钟数，未达到不允许交卷，0为不开启"
                    >
                      <a-input-number
                        v-model="addExamForm.handMin"
                        style="width: 220px; margin: 0 24px 24px 0"
                        :default-value="0"
                        :min="0"
                        :max="
                          addExamForm.duration >= 0 ? addExamForm.duration : 0
                        "
                        mode="button"
                        placeholder="输入最低交卷时长"
                      />
                    </a-form-item>
                  </a-col>
                  <a-col :span="12">
                    <a-form-item
                      label="允许迟到时间"
                      field="lateMax"
                      label-col-flex="120px"
                      tooltip="允许迟到的分钟数，注意:某段时间都可以考试的长期考试请设置为0"
                    >
                      <a-input-number
                        v-model="addExamForm.lateMax"
                        :default-value="0"
                        style="width: 220px; margin: 0 24px 24px 0"
                        :min="0"
                        :max="
                          addExamForm.duration >= 0 ? addExamForm.duration : 0
                        "
                        mode="button"
                        placeholder="输入迟到时间"
                      />
                    </a-form-item>
                  </a-col>
                </a-row>
              </a-form>
            </a-tab-pane>
            <a-tab-pane :key="2" title="权限设置">
              <a-radio-group
                v-model="addExamForm.openType"
                direction="horizontal"
                @change="openTypeChange"
              >
                <a-radio :value="0">完全公开</a-radio>
                <a-radio :value="1">指定成员</a-radio>
                <a-radio :value="2">指定部门</a-radio>
              </a-radio-group>
              <a-divider />
              <a-scrollbar type="track" style="height: 400px; overflow: auto">
                <template v-if="addExamForm.openType === 1">
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
                      v-model="userSearch.deptCode"
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
                      已选择{{ addExamForm.userList.length }}人
                    </a-typography-text>
                  </a-space>

                  <!--表格使用v-if销毁-->
                  <a-table
                    v-if="addExamForm.openType === 1"
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
                      <a-tag v-if="record.role === 'student'" color="green"
                        >学生</a-tag
                      >
                      <a-tag v-if="record.role === 'teacher'" color="skyblue"
                        >教师</a-tag
                      >
                      <a-tag v-if="record.role === 'admin'" color="orange"
                        >管理员</a-tag
                      >
                    </template>
                    <template #state="{ record }">
                      <a-tag v-if="record.state === 0" color="green"
                        >正常</a-tag
                      >
                      <a-tag v-if="record.state === 1" color="red">异常</a-tag>
                    </template>
                  </a-table>
                </template>
                <template v-if="addExamForm.openType === 2">
                  <a-space>
                    <a-tree-select
                      v-model="addExamForm.deptCode"
                      :data="deptTree"
                      :field-names="{
                        key: 'deptCode',
                        title: 'deptName',
                        children: 'children',
                      }"
                      placeholder="请选择部门"
                      style="width: 200px"
                      allow-clear
                      @change="searchUserList"
                    />
                  </a-space>
                </template>
              </a-scrollbar>
            </a-tab-pane>
            <a-tab-pane :key="3" title="考试结果展示">
              <a-radio-group
                v-model="addExamForm.resultType"
                direction="horizontal"
                @change="resultTypeChange"
              >
                <a-radio :value="0">仅展示感谢文字</a-radio>
                <a-radio :value="1">显示感谢文字+成绩</a-radio>
                <a-radio :value="2">显示试卷明细</a-radio>
              </a-radio-group>
              <a-divider />
              <a-scrollbar type="track" style="height: 400px; overflow: auto">
                <template
                  v-if="
                    addExamForm.resultType === 0 || addExamForm.resultType === 1
                  "
                >
                  <a-textarea
                    v-model="addExamForm.thanks"
                    placeholder="输入感谢文字"
                    :max-length="{ length: 500, errorOnly: true }"
                    show-word-limit
                  />
                </template>
                <template v-if="addExamForm.resultType === 2">
                  <a-tag checkable color="red" :default-checked="true">
                    显示所有的题目的作答情况
                  </a-tag>
                </template>
              </a-scrollbar>
            </a-tab-pane>
          </a-tabs>
        </a-card>
        <a-button type="primary" :loading="saveLoading" @click="saveExam"
          >保存</a-button
        >
      </a-layout-content>
      <a-layout-sider style="width: 300px; margin-left: 30px">
        <a-card class="general-card" :title="t('menu.exam.paperInfo')">
          <a-descriptions style="margin-top: 20px" size="large" :column="1">
            <a-descriptions-item label="试卷标题">{{
              paperInfo.title
            }}</a-descriptions-item>
            <a-descriptions-item label="试卷总分">{{
              paperInfo.totalCount
            }}</a-descriptions-item>
            <a-descriptions-item label="题目数量">{{
              paperInfo.quCount
            }}</a-descriptions-item>
            <a-descriptions-item label="创建时间">{{
              paperInfo.createTime
            }}</a-descriptions-item>
          </a-descriptions>
        </a-card>
      </a-layout-sider>
    </a-layout>
  </div>
</template>

<script lang="ts" setup>
  import dayjs from 'dayjs';
  import { useRoute, useRouter } from 'vue-router';
  import { useI18n } from 'vue-i18n';
  import { onMounted, ref, watch } from 'vue';
  import { Paper } from '@/types/model/po/Paper';
  import { getPaperDetail } from '@/api/paper';
  import UserQuery from '@/types/model/query/UserQuery';
  import { getDeptTree } from '@/api/department';
  import { getUserList } from '@/api/user';
  import { AddExamDTO } from '@/types/model/dto/AddExamDTO';
  import { TableColumnData } from '@arco-design/web-vue/es/table/interface';
  import { User } from '@/types/model/po/User';
  import { Message, ValidatedError } from '@arco-design/web-vue';
  import { useUserStore } from '@/store';
  import SimplePage from '@/types/model/po/SimplePage';
  import { addExam } from '@/api/exam';

  const { t } = useI18n();

  const route = useRoute();
  const router = useRouter();
  const userStore = useUserStore();
  const addExamFormRef = ref();
  // 保存考试按钮加载
  const saveLoading = ref(false);
  // 当前的活动面板
  const activeKey = ref(1);

  // 添加考试表单
  const addExamForm = ref<AddExamDTO>({
    userList: [],
    openType: 0, // 开放权限默认为全部开放
    thanks: '感谢您的作答！',
    resultType: 0, // 显示结果类型默认为显示感谢文字
    lateMax: 0,
    handMin: 0,
  });

  // 试卷信息
  const paperInfo = ref<Paper>({});
  // 部门树状列表
  const deptTree = ref<[]>();

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

  // 用户筛选表单
  const userSearch = ref<UserQuery>({} as UserQuery);

  // 用户列表数据
  const userList = ref<[]>();
  // 分页信息
  const pageInfo = ref<SimplePage>({
    pageNo: 1,
    pageSize: 5,
    pageTotal: 0,
    total: 0,
  });

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
    const paperId = route.query.id;
    if (!paperId) {
      router.back();
    }
    addExamForm.value.paperId = paperId as string;
    await getPaperDetail(paperId as string).then((res: any) => {
      paperInfo.value = res.data;
    });
  });

  // 页码变化
  const pageChange = (pageNo: number) => {
    pageInfo.value.pageNo = pageNo;
  };
  // 每页数据量变化
  const pageSizeChange = (pageSize: number) => {
    pageInfo.value.pageSize = pageSize;
  };

  // tab变化
  const panelChange = (index: any) => {
    activeKey.value = index;
  };

  // 开放权限按钮改变
  const openTypeChange = async (value: any) => {
    if (value === 1) {
      // 重置指定部门
      addExamForm.value.deptCode = '';
      await reloadUserList(pageInfo.value);
      await getDeptTree().then((res: any) => {
        deptTree.value = res.data;
      });
    } else if (value === 2) {
      // 切换开放权限，清空用户列表
      addExamForm.value.userList = [];
      // 加载部门列表树
      await getDeptTree().then((res: any) => {
        deptTree.value = res.data;
      });
    } else {
      // 切换开放权限，清空用户列表
      addExamForm.value.userList = [];
      // 重置指定部门
      addExamForm.value.deptCode = '';
    }
  };

  // 显示考试结果按钮改变
  const resultTypeChange = (value: any) => {};

  // 用户列表行被选择时触发
  const userTableRowSelect = (rowKeys: any, rowKey: any, record: User) => {
    if (!addExamForm.value.userList) {
      addExamForm.value.userList = [];
    }
    const isInclude = addExamForm.value.userList?.some(
      (userId: string) => userId === rowKey
    );
    if (!isInclude) {
      addExamForm.value.userList.push(rowKey);
    } else {
      // 移除取消选中的用户
      addExamForm.value.userList = addExamForm.value.userList.filter(
        (item) => item !== rowKey
      );
    }
  };

  // 保存考试
  const saveExam = async () => {
    try {
      // 判断指定人员情况下未选择人员的情况
      if (
        addExamForm.value.openType === 1 &&
        addExamForm.value.userList?.length === 0
      ) {
        Message.warning({
          content: '请选择考试人员',
          duration: 2000,
        });
        return;
      }
      // 判断指定部门情况下未选择部门的情况
      if (
        addExamForm.value.openType === 2 &&
        (addExamForm.value.deptCode === '' || !addExamForm.value.deptCode)
      ) {
        Message.warning({
          content: '请选择部门',
          duration: 2000,
        });
        return;
      }

      // 判断考试结束显示样式
      if (
        addExamForm.value.resultType === 0 ||
        addExamForm.value.resultType === 1
      ) {
        if (addExamForm.value.thanks?.trim().length === 0) {
          Message.warning({
            content: '请输入感谢语',
            duration: 2000,
          });
          activeKey.value = 3;
          return;
        }
      }

      // 检验表单
      addExamFormRef.value.validate(
        async (errors: undefined | Record<string, ValidatedError>) => {
          if (!errors) {
            // 校验通过
            // 判断时间差
            const { startTime } = addExamForm.value;
            const { endTime } = addExamForm.value;
            if (!dayjs(startTime).isBefore(dayjs(endTime))) {
              Message.warning({
                content: '考试开始时间必须小于结束时间',
                duration: 2000,
              });
              throw new Error();
            }
            saveLoading.value = true;
            // 提交表单
            await addExam(addExamForm.value).then((res: any) => {
              if (res.data === true) {
                Message.success({
                  content: '创建成功',
                  duration: 2000,
                });
                router.back();
              }
            });
            saveLoading.value = false;
          } else {
            // 校验未通过
            activeKey.value = 1;
            throw new Error();
          }
        }
      );
    } catch {
      saveLoading.value = false;
      console.log();
    } finally {
      saveLoading.value = false;
    }
  };

  // 计算考试开始结束时间差
  watch(
    addExamForm.value,
    (newData, oldValue) => {
      addExamForm.value.duration = dayjs(addExamForm.value.endTime).diff(
        dayjs(addExamForm.value.startTime),
        'minutes'
      );
    },
    {
      deep: true,
      immediate: true,
    }
  );

  const formRules = {
    title: [{ required: true, message: '请输入考试名称' }],
    startTime: { required: true, message: '请选择考试开始时间' },
    endTime: { required: true, message: '请选择考试结束时间' },
    qualifyScore: { required: true, message: '请输入及格分数' },
    duration: { required: true, message: '请输入考试时长' },
  };

  // 监视查询数据及其页码变化
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
