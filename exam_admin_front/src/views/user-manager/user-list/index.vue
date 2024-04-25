<template>
  <div class="container">
    <Breadcrumb :items="['menu.userManager', 'menu.userManager.userList']" />
    <a-row :gutter="10">
      <!--左侧部门筛选-->
      <a-col :span="4">
        <a-card style="height: 650px">
          <a-space align="center">
            <a-input-search
              v-model="searchTree.deptNameFuzzy"
              style="margin-bottom: 8px; max-width: 240px"
              placeholder="筛选部门"
              @input="searchTreeChange"
            />
            <a-button
              type="primary"
              shape="round"
              status="danger"
              @click="clearUserSearch"
            >
              <template #icon>
                <icon-refresh />
              </template>
            </a-button>
          </a-space>
          <a-tree
            v-model:selected-keys="userSearch.deptCodeFuzzy"
            :field-names="{
              key: 'deptCode',
              title: 'deptName',
              children: 'children',
            }"
            :data="deptTree"
          />
        </a-card>
      </a-col>
      <a-col :span="20">
        <a-card
          style="height: 650px"
          class="general-card"
          :title="$t('menu.userManager.userList')"
        >
          <a-space>
            <!--用户名-->
            <a-input
              v-model="userSearch.userNameFuzzy"
              :placeholder="$t('userList.form.placeholder.userName')"
            />
            <!--手机号-->
            <a-input
              v-model="userSearch.phoneFuzzy"
              :placeholder="$t('userList.form.placeholder.phone')"
            />
            <!--角色-->
            <a-select
              v-if="userStore.role === 'admin'"
              v-model="userSearch.role"
              :allow-clear="true"
              style="width: 200px"
              :placeholder="$t('userList.form.placeholder.roles')"
            >
              <a-option value="student">学生</a-option>
              <a-option value="teacher">教师</a-option>
              <a-option value="admin">管理员</a-option>
            </a-select>
            <!--状态-->
            <a-select
              v-model="userSearch.state"
              :allow-clear="true"
              style="width: 200px"
              :placeholder="$t('userList.form.placeholder.state')"
            >
              <a-option value="0">正常</a-option>
              <a-option value="1">隐藏</a-option>
            </a-select>
          </a-space>
          <a-row style="margin-bottom: 16px; margin-top: 16px">
            <a-col :span="12">
              <a-space>
                <!--添加用户-->
                <a-button
                  v-permission="['admin']"
                  type="primary"
                  @click="addUserVisible = true"
                >
                  <template #icon>
                    <icon-plus />
                  </template>
                  添加
                </a-button>
                <!--导出-->
                <a-button v-permission="['admin']" type="primary">
                  <template #icon>
                    <icon-download />
                  </template>
                  {{ $t('userList.operation.import') }}
                </a-button>
                <!--导出-->
                <a-upload action="/">
                  <template #upload-button>
                    <a-button v-permission="['admin']">
                      {{ $t('userList.operation.derive') }}
                    </a-button>
                  </template>
                </a-upload>
              </a-space>
            </a-col>
          </a-row>
          <a-table
            row-key="id"
            :loading="loading"
            :columns="columns"
            :data="userList"
            :bordered="false"
            :scrollbar="true"
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
          >
            <template #avatar="{ record }">
              <a-avatar :image-url="record.avatar"> </a-avatar>
            </template>
            <template #sex="{ record }">
              <span v-if="record.sex === 0">
                <icon-woman />
                女
              </span>
              <span v-if="record.sex === 1">
                <icon-man />
                男
              </span>
            </template>
            <template #state="{ record }">
              <span v-if="record.state === 1" class="circle" />
              <span v-else class="circle pass" />
              {{ $t(`userList.columns.status.${record.state}`) }}
            </template>
            <template #option="{ record }">
              <a-space>
                <!--修改查看用户-->
                <a-button
                  v-permission="['admin']"
                  type="primary"
                  @click="handleView(record)"
                  >{{ $t('userList.columns.view') }}</a-button
                >
                <a-button
                  v-permission="['admin']"
                  type="primary"
                  status="danger"
                  @click="deleteUserVisible = true"
                >
                  {{ $t('userList.columns.delete') }}
                </a-button>
              </a-space>
              <!--删除确认框-->
              <a-modal
                :visible="deleteUserVisible"
                @ok="deleteOk(record.id)"
                @cancel="deleteUserVisible = false"
              >
                <template #title> 删除提醒 </template>
                <div> 确认删除该用户？ </div>
              </a-modal>
            </template>
          </a-table>
        </a-card>
      </a-col>
    </a-row>

    <!--查看用户信息模态框-->
    <a-modal
      width="auto"
      :visible="checkUserInfoVisible"
      @ok="handleOk"
      @cancel="checkUserInfoVisible = false"
    >
      <template #title> 用户信息 </template>
      <div style="width: 850px; height: 500px">
        <a-form ref="userInfoRef" :model="userInfoForm" auto-label-width>
          <a-row :gutter="16">
            <a-col :span="12">
              <a-form-item
                field="userName"
                label="用户名"
                :rules="[{ required: true, message: '用户名不能为空' }]"
              >
                <a-input v-model="userInfoForm.userName" />
              </a-form-item>
            </a-col>
            <a-col :span="12">
              <a-form-item
                field="role"
                label="角色"
                :rules="[{ required: true, message: '角色不能为空' }]"
              >
                <a-select
                  v-model="userInfoForm.role"
                  :style="{ width: '320px' }"
                  :default-value="userInfoForm.role"
                >
                  <a-option value="student">学生</a-option>
                  <a-option value="teacher">老师</a-option>
                  <a-option value="admin">管理员</a-option>
                </a-select>
              </a-form-item>
            </a-col>
          </a-row>
          <a-row :gutter="16">
            <a-col :span="12">
              <a-form-item
                field="deptCode"
                label="所属部门"
                :rules="[{ required: true, message: '所属部门不能为空' }]"
              >
                <a-tree-select
                  v-model="userInfoForm.deptCode"
                  :data="deptTree"
                  :field-names="{
                    key: 'deptCode',
                    title: 'deptName',
                    children: 'children',
                  }"
                />
              </a-form-item>
            </a-col>
            <a-col :span="12">
              <a-form-item field="password" label="密码">
                <a-input
                  v-model="userInfoForm.password"
                  placeholder="不更改密码，切勿输入"
                />
              </a-form-item>
            </a-col>
          </a-row>
          <a-row :gutter="16">
            <a-col :span="12">
              <a-form-item
                field="phone"
                label="手机"
                :rules="[{ type: 'number' }]"
              >
                <a-input-number
                  v-model="userInfoForm.phone"
                  :hide-button="true"
                />
              </a-form-item>
            </a-col>
            <a-col :span="12">
              <a-form-item
                field="email"
                label="邮箱"
                :rules="[{ required: false, type: 'email' }]"
              >
                <a-input v-model="userInfoForm.email" />
              </a-form-item>
            </a-col>
          </a-row>
          <a-row :gutter="16">
            <a-col :span="12">
              <a-form-item field="createTime" label="创建时间">
                <a-time-picker
                  v-model="userInfoForm.createTime"
                  format="YYYY-MM-DD hh:mm:ss"
                  disabled
                />
              </a-form-item>
            </a-col>
            <a-col :span="12">
              <a-form-item field="state" label="状态">
                <a-select v-model="userInfoForm.state">
                  <a-option :value="0">正常</a-option>
                  <a-option :value="1">禁用</a-option>
                </a-select>
              </a-form-item>
            </a-col>
          </a-row>
          <a-row :gutter="16">
            <a-col :span="12">
              <a-form-item
                field="realName"
                label="真实姓名"
                :rules="[{ required: true, message: '真实姓名不能为空' }]"
              >
                <a-input v-model="userInfoForm.realName" />
              </a-form-item>
            </a-col>
            <a-col :span="12">
              <a-form-item field="sex" label="性别">
                <a-select v-model="userInfoForm.sex">
                  <a-option :value="0">女</a-option>
                  <a-option :value="1">男</a-option>
                </a-select>
              </a-form-item>
            </a-col>
          </a-row>
          <a-row :gutter="16">
            <a-col :span="12">
              <a-form-item field="updateTime" label="最近更新时间">
                <a-time-picker
                  v-model="userInfoForm.updateTime"
                  disabled
                  format="YYYY-MM-DD hh:mm:ss"
                />
              </a-form-item>
            </a-col>
          </a-row>
        </a-form>
      </div>
    </a-modal>
    <!--添加用户信息模态框-->
    <a-modal
      width="auto"
      :visible="addUserVisible"
      @ok="addOk"
      @cancel="addCancel"
    >
      <template #title> 用户信息 </template>
      <div style="width: 850px; height: 500px">
        <a-form ref="addUserFormRef" :model="addUserForm" auto-label-width>
          <a-row :gutter="16">
            <a-col :span="12">
              <a-form-item
                field="userName"
                label="用户名"
                :rules="[{ required: true, message: '用户名不能为空' }]"
              >
                <a-input v-model="addUserForm.userName" />
              </a-form-item>
            </a-col>
            <a-col :span="12">
              <a-form-item
                field="role"
                label="角色"
                :rules="[{ required: true, message: '角色不能为空' }]"
              >
                <a-select
                  v-model="addUserForm.role"
                  :style="{ width: '320px' }"
                >
                  <a-option value="student">学生</a-option>
                  <a-option value="teacher">老师</a-option>
                  <a-option value="admin">管理员</a-option>
                </a-select>
              </a-form-item>
            </a-col>
          </a-row>
          <a-row :gutter="16">
            <a-col :span="12">
              <a-form-item
                field="deptCode"
                label="所属部门"
                :rules="[{ required: true, message: '所属部门不能为空' }]"
              >
                <a-tree-select
                  v-model="addUserForm.deptCode"
                  :data="deptTree"
                  :field-names="{
                    key: 'deptCode',
                    title: 'deptName',
                    children: 'children',
                  }"
                />
              </a-form-item>
            </a-col>
            <a-col :span="12">
              <a-form-item
                field="password"
                label="密码"
                :rules="[{ required: true, message: '密码不能为空' }]"
              >
                <a-input v-model="addUserForm.password" />
              </a-form-item>
            </a-col>
          </a-row>
          <a-row :gutter="16">
            <a-col :span="12">
              <a-form-item
                field="phone"
                label="手机"
                :rules="[{ type: 'number' }]"
              >
                <a-input-number
                  v-model="addUserForm.phone"
                  :hide-button="true"
                />
              </a-form-item>
            </a-col>
            <a-col :span="12">
              <a-form-item
                field="email"
                label="邮箱"
                :rules="[{ required: false, type: 'email' }]"
              >
                <a-input v-model="addUserForm.email" />
              </a-form-item>
            </a-col>
          </a-row>
          <a-row :gutter="16">
            <a-col :span="12">
              <a-form-item
                field="realName"
                label="真实姓名"
                :rules="[{ required: true, message: '真实姓名不能为空' }]"
              >
                <a-input v-model="addUserForm.realName" />
              </a-form-item>
            </a-col>
            <a-col :span="12">
              <a-form-item field="sex" label="性别">
                <a-select v-model="addUserForm.sex">
                  <a-option :value="0">女</a-option>
                  <a-option :value="1">男</a-option>
                </a-select>
              </a-form-item>
            </a-col>
          </a-row>
        </a-form>
      </div>
    </a-modal>
  </div>
</template>

<script lang="ts" setup>
  import { onMounted, ref, watch } from 'vue';
  import { useI18n } from 'vue-i18n';
  import useLoading from '@/hooks/loading';
  import {
    addUser,
    deleteUserByIb,
    getUserList,
    updateUserById,
  } from '@/api/user';
  import { UserQuery } from '@/types/model/query/UserQuery';
  import { UserDetailVO } from '@/types/model/vo/UserDetailVO';
  import { getDeptTree, loadDataList } from '@/api/department';
  import { TableColumnData } from '@arco-design/web-vue/es/table/interface';
  import { DepartmentQuery } from '@/types/model/query/DepartmentQuery';
  import { User } from '@/types/model/po/User';
  import { Message } from '@arco-design/web-vue';
  import usePermission from '@/hooks/permission';
  import { useUserStore } from '@/store';
  import { SimplePage } from '@/types/model/po/SimplePage';

  const { loading, setLoading } = useLoading(true);
  const { t } = useI18n();

  // 分页信息
  const pageInfo = ref<SimplePage>({
    pageNo: 1,
    pageSize: 10,
    pageTotal: 0,
    total: 0,
  });

  // 部门树列表
  const deptTree = ref<[]>();

  // 搜索部门树
  const searchTree = ref<DepartmentQuery>({});

  // 查询表单
  const userSearch = ref<UserQuery>({} as UserQuery);

  // 用户列表
  const userList = ref<UserDetailVO[]>([]);

  // 添加用户信息模态框开关
  const addUserVisible = ref<boolean>(false);

  // 查看用户信息模态框开关
  const checkUserInfoVisible = ref<boolean>(false);

  // 删除用户模态开关
  const deleteUserVisible = ref<boolean>(false);

  // 用户信息表单
  const userInfoForm = ref<User>({});

  // 用户信息表单引用
  const userInfoRef = ref();

  // 添加用户表单
  const addUserForm = ref<User>({});
  // 添加用户引用
  const addUserFormRef = ref();

  const permission = usePermission();
  const userStore = useUserStore();

  // 加载用户列表
  const reloadUserList = async (userQuery: UserQuery) => {
    setLoading(true);
    permission.addRoleToQuery(userQuery);
    await getUserList(userQuery).then((res: any) => {
      userList.value = res.data.list;
      pageInfo.value.total = res.data.totalCount;
      pageInfo.value.pageSize = res.data.pageSize;
      pageInfo.value.pageNo = res.data.pageNo;
      pageInfo.value.pageTotal = res.data.pageTotal;
    });
    setLoading(false);
  };

  onMounted(async () => {
    await getDeptTree().then((res: any) => {
      deptTree.value = res.data;
    });
    await reloadUserList(pageInfo.value);
  });

  // 清空查询表单
  const clearUserSearch = () => {
    userSearch.value.deptCodeFuzzy = '';
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
      title: t('userList.columns.userName'),
      dataIndex: 'userName',
      slotName: 'userName',
    },
    {
      title: t('userList.columns.avatar'),
      dataIndex: 'avatar',
      slotName: 'avatar',
    },
    {
      title: t('userList.columns.realName'),
      dataIndex: 'realName',
      slotName: 'realName',
    },
    {
      title: t('userList.columns.sex'),
      dataIndex: 'sex',
      slotName: 'sex',
    },
    {
      title: t('userList.columns.deptText'),
      dataIndex: 'deptText',
    },
    {
      title: t('userList.columns.phone'),
      dataIndex: 'phone',
      slotName: 'phone',
    },
    {
      title: t('userList.columns.state'),
      dataIndex: 'state',
      slotName: 'state',
    },
    {
      title: t('userList.columns.option'),
      dataIndex: 'option',
      slotName: 'option',
      width: 180,
    },
  ]);

  // 搜索部门
  const searchTreeChange = async () => {
    if (searchTree.value.deptNameFuzzy === '') {
      await getDeptTree().then((res: any) => {
        deptTree.value = res.data;
      });
    } else {
      await loadDataList(searchTree.value).then((res: any) => {
        deptTree.value = res.data.list;
      });
    }
  };

  // 查看用户信息
  const handleView = (record: any) => {
    checkUserInfoVisible.value = true;
    userInfoForm.value = { ...record };
    userInfoForm.value.password = '';
  };

  // 头像上传组件引用
  const avatarRef = ref();
  // 确认更改用户信息
  const handleOk = async () => {
    userInfoRef.value.validate().then(async (errors: any) => {
      if (!errors) {
        // 上传头像
        avatarRef.value.submit();
        userInfoForm.value.updateBy = userStore.id as string;
        // 更新用户信息
        await updateUserById({
          user: userInfoForm.value,
          id: userInfoForm.value.id,
        }).then(async (res: any) => {
          if (res.data === true) {
            checkUserInfoVisible.value = false;
            await reloadUserList({ ...pageInfo.value, ...userSearch.value });
          }
        });
      } else {
        Message.error({
          content: '检验失败',
        });
      }
      Message.error({
        content: `错误信息：${errors}`,
      });
    });
  };

  // 删除确认
  const deleteOk = async (id: string) => {
    await deleteUserByIb(id).then(async (res: any) => {
      deleteUserVisible.value = false;
      await reloadUserList({ ...pageInfo.value, ...userSearch.value });
    });
  };

  // 头像上传相关
  const file = ref();

  const onChange = (_: any, currentFile: any) => {
    file.value = {
      ...currentFile,
    };
  };
  const onProgress = (currentFile: any) => {
    file.value = currentFile;
  };

  // 确认添加用户
  const addOk = () => {
    addUserFormRef.value.createBy = userStore.id;
    addUserFormRef.value.validate().then(async (errors: any) => {
      if (!errors) {
        await addUser(addUserForm.value).then(async (res: any) => {
          if (res.data === true) {
            Message.success({
              content: '添加成功',
            });
            await reloadUserList({ ...pageInfo.value, ...userSearch.value });
            addUserVisible.value = false;
          }
        });
      } else {
        console.log('校验失败');
      }
    });
  };

  // 取消添加用户
  const addCancel = () => {
    addUserVisible.value = false;
  };

  watch(
    userSearch.value,
    async () => {
      if (Array.isArray(userSearch.value.deptCodeFuzzy)) {
        const code = userSearch.value.deptCodeFuzzy?.[0];
        userSearch.value.deptCodeFuzzy = code;
      }
      /* await getDeptUserList(userSearch.value).then((res: any) => {
        userList.value = res.data;
      });
      setLoading(false); */
    },
    { deep: true, immediate: true }
  );

  // 监视查询数据及其页码变化
  watch(
    [pageInfo.value, userSearch.value],
    async ([newPageInfo, oldPageInfo], [newUserSearch, oldUserSearch]) => {
      await reloadUserList({ ...pageInfo.value, ...userSearch.value });
    },
    { deep: true }
  );
</script>

<style scoped lang="less">
  .container {
    padding: 0 20px 20px 20px;
  }

  :deep(.arco-table-th) {
    &:last-child {
      .arco-table-th-item-title {
        margin-left: 16px;
      }
    }
  }

  .action-icon {
    margin-left: 12px;
    cursor: pointer;
  }

  .active {
    color: #0960bd;
    background-color: #e3f4fc;
  }

  .setting {
    display: flex;
    align-items: center;
    width: 200px;

    .title {
      margin-left: 12px;
      cursor: pointer;
    }
  }
</style>
