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
          <a-tabs direction="vertical">
            <a-tab-pane key="1" title="基础设置">
              <a-form
                ref="updateExamFormRef"
                :model="updateExamForm"
                :scroll-to-first-error="true"
              >
                <a-row>
                  <a-form-item
                    label="考试名称"
                    field="title"
                    :rules="[{ required: true, message: '请输入考试名称' }]"
                  >
                    <a-input
                      v-model="updateExamForm.title"
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
                      :rules="[
                        { required: true, message: '请选择考试开始时间' },
                      ]"
                    >
                      <a-date-picker
                        v-model="updateExamForm.startTime"
                        placeholder="请选择考试开始时间"
                        style="width: 220px; margin: 0 24px 24px 0"
                        show-time
                        :time-picker-props="{ defaultValue: '09:09:06' }"
                        format="YYYY-MM-DD HH:mm:ss"
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
                      :rules="[
                        { required: true, message: '请选择考试结束时间' },
                      ]"
                    >
                      <a-date-picker
                        v-model="updateExamForm.endTime"
                        placeholder="请选择考试结束时间"
                        style="width: 220px; margin: 0 24px 24px 0"
                        show-time
                        format="YYYY-MM-DD HH:mm:ss"
                        :disabled-date="
                          (current) =>
                            dayjs(current).isBefore(
                              dayjs(updateExamForm.startTime).subtract(1, 'day')
                            )
                        "
                        :disabled-time="getDisabledTime"
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
                      :rules="[{ required: true, message: '请输入及格分数' }]"
                    >
                      <a-input-number
                        v-model="updateExamForm.qualifyScore"
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
                      field="qualifyScore"
                      label-col-flex="120px"
                      tooltip="单位：分钟（时长由开始时间和结束时间推算而来）"
                      :rules="[{ required: true, message: '请输入考试时长' }]"
                    >
                      <a-input-number
                        v-model="updateExamForm.duration"
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
                        v-model="updateExamForm.handMin"
                        style="width: 220px; margin: 0 24px 24px 0"
                        :default-value="0"
                        :min="0"
                        :max="
                          updateExamForm.duration >= 0
                            ? updateExamForm.duration
                            : 0
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
                        v-model="updateExamForm.lateMax"
                        :default-value="0"
                        style="width: 220px; margin: 0 24px 24px 0"
                        :min="0"
                        :max="
                          updateExamForm.duration >= 0
                            ? updateExamForm.duration
                            : 0
                        "
                        mode="button"
                        placeholder="输入迟到时间"
                      />
                    </a-form-item>
                  </a-col>
                </a-row>
              </a-form>
            </a-tab-pane>
            <a-tab-pane key="2" title="权限设置">
              <a-radio-group
                v-model="updateExamForm.openType"
                direction="horizontal"
                @change="openTypeChange"
              >
                <a-radio :value="0">完全公开</a-radio>
                <a-radio :value="1">指定成员</a-radio>
                <a-radio :value="2">指定部门</a-radio>
              </a-radio-group>
              <a-divider />
              <a-scrollbar type="track" style="height: 400px; overflow: auto">
                <template v-if="updateExamForm.openType === 1">
                  <a-space>
                    <a-select
                      v-model="userSearch.role"
                      style="width: 200px"
                      allow-clear
                      placeholder="请选择角色"
                      @change="searchUserList"
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
                      @change="searchUserList"
                    />
                    <a-input
                      v-model="userSearch.userNameFuzzy"
                      placeholder="搜索用户名"
                      @input="searchUserList"
                    />
                    <a-typography-text>
                      已选择{{ updateExamForm.userList?.length }}人
                    </a-typography-text>
                  </a-space>

                  <!--表格使用v-if销毁-->
                  <a-table
                    v-if="updateExamForm.openType === 1"
                    ref="tableRef"
                    :table-layout-fixed="true"
                    row-key="id"
                    style="margin-top: 20px"
                    :data="userList"
                    :columns="userColumns"
                    :row-selection="{
                      type: 'checkbox',
                    }"
                    @select="userTableRowSelect"
                  >
                  </a-table>
                </template>
                <template v-if="updateExamForm.openType === 2">
                  <a-space>
                    <a-tree-select
                      v-model="updateExamForm.deptCode"
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
            <a-tab-pane key="3" title="考试结果展示">
              <a-radio-group
                v-model="updateExamForm.resultType"
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
                    updateExamForm.resultType === 0 ||
                    updateExamForm.resultType === 1
                  "
                >
                  <a-textarea
                    v-model="updateExamForm.thanks"
                    placeholder="输入感谢文字"
                    :max-length="{ length: 500, errorOnly: true }"
                    show-word-limit
                  />
                </template>
                <template v-if="updateExamForm.resultType === 2">
                  <a-tag checkable color="red" :default-checked="true">
                    显示所有的题目的作答情况
                  </a-tag>
                </template>
              </a-scrollbar>
            </a-tab-pane>
          </a-tabs>
        </a-card>
        <a-button type="primary" @click="updateExam">保存</a-button>
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
  import { onMounted, ref, toRaw, watch } from 'vue';
  import { Paper } from '@/types/model/po/Paper';
  import { getPaperDetail } from '@/api/paper';
  import { UserQuery } from '@/types/model/query/UserQuery';
  import { getDeptTree } from '@/api/department';
  import { getDeptUserList, getUserList } from '@/api/user';
  import { AddExamDTO } from '@/types/model/dto/AddExamDTO';
  import { TableColumnData } from '@arco-design/web-vue/es/table/interface';
  import { User } from '@/types/model/po/User';
  import { Message, ValidatedError } from '@arco-design/web-vue';
  import { range } from 'lodash';
  import { useUserStore } from '@/store';
  import { addExam, getExamById, updateExamById } from '@/api/exam';
  import { UpdateExamDTO } from '@/types/model/dto/UpdateExamDTO';

  const { t } = useI18n();

  const route = useRoute();
  const router = useRouter();
  const userStore = useUserStore();
  const updateExamFormRef = ref({});

  // 添加考试表单
  const updateExamForm = ref<UpdateExamDTO>({
    userList: [],
    updateBy: userStore.id,
  });

  // 试卷信息
  const paperInfo = ref<Paper>({});
  // 部门树状列表
  const deptTree = ref<[]>([]);

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
      dataIndex: 'deptCode',
    },
    {
      title: t('department.userColumns.roles'),
      dataIndex: 'roles',
    },
    {
      title: t('department.userColumns.state'),
      dataIndex: 'state',
    },
  ]);

  // 用户筛选表单
  const userSearch = ref<UserQuery>({});

  onMounted(async () => {
    // 获取考试信息
    const examId = route.query.id;
    if (!examId) {
      router.back();
    }
    updateExamForm.value.id = examId as string;
    await getExamById(examId as string).then((res: any) => {
      updateExamForm.value = res.data;
    });
    // 获取试卷信息
    await getPaperDetail(updateExamForm.value.paperId as string).then(
      (res: any) => {
        paperInfo.value = res.data;
      }
    );
  });

  // 用户列表数据
  const userList = ref<User[]>([]);

  // 开放权限按钮改变
  const openTypeChange = async (value: any) => {
    if (value === 1) {
      // 重置指定部门
      updateExamForm.value.deptCode = '';
      // 加载用户列表
      await getUserList({}).then((res: any) => {
        userList.value = res.data.list;
      });
    } else if (value === 2) {
      // 切换开放权限，清空用户列表
      updateExamForm.value.userList = [];
      // 加载部门列表树
      await getDeptTree().then((res: any) => {
        deptTree.value = res.data;
      });
    } else {
      // 切换开放权限，清空用户列表
      updateExamForm.value.userList = [];
      // 重置指定部门
      updateExamForm.value.deptCode = '';
    }
  };

  // 获取不可选择的时间
  const getDisabledTime = (date: Date) => {
    if (dayjs(date).day() === dayjs(updateExamForm.value.startTime).day()) {
      return {
        disabledHours: () =>
          range(0, dayjs(updateExamForm.value.startTime).hour()),
        disabledMinutes: () =>
          range(0, dayjs(updateExamForm.value.startTime).minute() + 1),
        disabledSeconds: () =>
          range(0, dayjs(updateExamForm.value.startTime).second()),
      };
    }
    return {};
  };

  // 显示考试结果按钮改变
  const resultTypeChange = (value: any) => {};

  // 搜索用户
  const searchUserList = async () => {
    await getDeptUserList(userSearch.value).then((res: any) => {
      userList.value = res.data;
    });
  };

  // 问题列表行被选择时触发
  const userTableRowSelect = (rowKeys: any, rowKey: any, record: User) => {
    updateExamForm.value.userList = [];
    userList.value?.forEach((user: User) => {
      if (rowKeys.includes(user.id)) {
        updateExamForm.value.userList?.push(user);
      }
    });
  };

  // 保存考试
  const updateExam = async () => {
    try {
      if (
        updateExamForm.value.openType === 1 &&
        updateExamForm.value.userList?.length === 0
      ) {
        Message.warning({
          content: '请选择考试人员',
        });
        throw new Error('请选择考试人员');
      }
      if (
        updateExamForm.value.openType === 2 &&
        (updateExamForm.value.deptCode === '' || !updateExamForm.value.deptCode)
      ) {
        Message.warning({
          content: '请选择部门',
        });
        throw new Error('请选择部门');
      }

      // 检验表单
      updateExamFormRef.value.validate(
        async (errors: undefined | Record<string, ValidatedError>) => {
          if (!errors) {
            // 判断时间
            if (
              !dayjs(updateExamForm.value.startTime).isBefore(
                dayjs(updateExamForm.value.endTime)
              )
            ) {
              Message.warning({
                content: '考试开始时间必须小于结束时间',
              });
              throw new Error('考试开始时间必须小于结束时间');
            }
            console.log('通过');
            await updateExamById(updateExamForm.value).then((res: any) => {
              if (res.data === true) {
                Message.success({
                  content: '考试更新成功',
                });
                router.back();
              } else {
                Message.error({
                  content: '考试更新失败',
                });
              }
            });
          } else {
            console.log('失败');
          }
        }
      );
    } catch (error) {
      console.log('');
    }
  };

  watch(
    updateExamForm.value,
    (newData, oldValue) => {
      updateExamForm.value.duration = dayjs(updateExamForm.value.endTime).diff(
        dayjs(updateExamForm.value.startTime),
        'minutes'
      );
    },
    {
      deep: true,
      immediate: true,
    }
  );
</script>

<style scoped></style>
