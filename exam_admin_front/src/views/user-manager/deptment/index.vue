<template>
  <div class="container">
    <Breadcrumb :items="['menu.userManager', 'menu.userManager.department']" />
    <a-card class="general-card" :title="$t('menu.userManager.department')">
      <a-space>
        <a-button
          v-permission="['admin']"
          type="primary"
          @click="addDepartment"
        >
          <template #icon>
            <icon-plus />
          </template>
          添加
        </a-button>
        <a-input
          :style="{ width: '320px' }"
          placeholder="搜索部门名称"
          @input="searchDept"
        />
      </a-space>
      <a-drawer />
      <!--添加部门模态框-->
      <a-modal
        v-model:visible="addDeptVisible"
        @ok="handleOk"
        @cancel="handleCancel"
      >
        <template #title> 部门管理 </template>
        <a-form ref="deptRef" :model="department">
          <a-form-item
            label="部门名称"
            field="deptName"
            :rules="[{ required: true, message: '请输入部门名称' }]"
          >
            <a-input v-model="department.deptName" placeholder="输入部门名称" />
          </a-form-item>
        </a-form>
      </a-modal>
      <!--更新部门模态框-->
      <a-modal
        v-model:visible="updateDeptVisible"
        @ok="updateOk"
        @cancel="updateCancel"
      >
        <template #title> 部门管理 </template>
        <a-form ref="deptUpdateRef" :model="updateDept">
          <a-form-item
            label="部门名称"
            field="department.deptName"
            :rules="[{ required: true, message: '请输入部门名称' }]"
          >
            <a-input
              v-model="updateDept.department.deptName"
              placeholder="输入部门名称"
            />
          </a-form-item>
        </a-form>
      </a-modal>
      <!--删除模态框-->
      <a-modal
        v-model:visible="deleteDeptVisible"
        @ok="deleteOk"
        @cancel="deleteCancel"
      >
        <template #title> 删除 </template>
        <div> 确认删除？ </div>
      </a-modal>
      <a-table
        :columns="columns"
        :data="data"
        row-key="deptCode"
        :hide-expand-button-on-empty="true"
        show-empty-tree
        style="margin-top: 20px"
      >
        <!--排序插槽-->
        <template #sort="{ record }">
          <a-space>
            <a-button
              v-permission="['admin']"
              shape="round"
              @click="sortUp(record)"
            >
              <template #icon>
                <icon-caret-up />
              </template>
            </a-button>
            <a-button
              v-permission="['admin']"
              shape="round"
              @click="sortDown(record)"
            >
              <template #icon>
                <icon-caret-down />
              </template>
            </a-button>
          </a-space>
        </template>
        <!--操作插槽-->
        <template #option="{ record }">
          <a-space>
            <!--添加部门-->
            <a-button
              v-permission="['admin']"
              shape="round"
              @click="addDepartment(record)"
            >
              <template #icon>
                <icon-plus />
              </template>
            </a-button>
            <!--修改编辑部门-->
            <a-button
              v-permission="['admin']"
              shape="round"
              @click="updateDepartment(record)"
            >
              <template #icon>
                <icon-edit />
              </template>
            </a-button>
            <!--删除部门-->
            <a-button
              v-permission="['admin']"
              shape="round"
              @click="deleteDepartment(record.id)"
            >
              <template #icon>
                <icon-delete />
              </template>
            </a-button>
          </a-space>
        </template>

        <!--用户插槽-->
        <template #view="{ record }">
          <a-space>
            <a-button type="text" @click="loadUserList(record.deptCode)">
              <template #icon>
                <icon-user />
              </template>
              用户列表
            </a-button>
          </a-space>
        </template>

        <template #empty>
          <div style="text-align: center"> 无子部门 </div>
        </template>
      </a-table>
      <!--用户列表抽屉-->
      <a-drawer
        :width="750"
        :visible="userVisible"
        :footer="true"
        @cancel="userVisible = false"
      >
        <template #header> 用户列表 </template>
        <a-space>
          <a-select
            v-model="userSearch.role"
            style="width: 200px"
            allow-clear
            placeholder="请选择角色"
            @change="searchUserList"
          >
            <a-option :value="1">1</a-option>
            <a-option :value="2">2</a-option>
            <a-option :value="3">3</a-option>
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
        </a-space>
        <template #footer>
          <!--占位-->
          <template />
        </template>
        <a-table
          :columns="userColumns"
          :data="userList"
          row-key="deptCode"
          show-empty-tree
          style="margin-top: 20px"
        >
          <template #role="{ record }">
            <a-tag v-if="record.role === 'student'" color="red">学生</a-tag>
            <a-tag v-if="record.role === 'teacher'" color="green">教师</a-tag>
            <a-tag v-if="record.role === 'admin'" color="blue">管理员</a-tag>
          </template>
          <template #state="{ record }">
            <span v-if="record.state === 1" class="circle" />
            <span v-else class="circle pass" />
            {{ $t(`department.userColumns.${record.state}`) }}
          </template>
        </a-table>
      </a-drawer>
    </a-card>
  </div>
</template>

<script lang="ts" setup>
  import { useI18n } from 'vue-i18n';
  import { onMounted, ref, toRaw } from 'vue';
  import { AddDepartmentDTO } from '@/types/model/dto/AddDepartmentDTO';
  import { useRouter } from 'vue-router';
  import {
    addDepart,
    deleteDeptById,
    departmentSort,
    getDeptTree,
    loadDataList,
    updateDeptById,
  } from '@/api/department';
  import { DepartmentTreeVO } from '@/types/model/vo/DepartmentTreeVO';
  import { UpdateDeptDTO } from '@/types/model/dto/UpdateDeptDTO';
  import { UserQuery } from '@/types/model/query/UserQuery';
  import { getDeptUserList } from '@/api/user';

  const { t } = useI18n();

  // 部门列配置
  const columns = [
    {
      title: t('department.columns.deptName'),
      dataIndex: 'deptName',
    },
    {
      title: t('department.columns.deptCode'),
      dataIndex: 'deptCode',
    },
    {
      title: t('department.columns.sort'),
      slotName: 'sort',
      dataIndex: 'sort',
      sorter: true,
    },
    {
      title: t('department.columns.option'),
      slotName: 'option',
      dataIndex: 'email',
    },
    {
      title: t('department.columns.view'),
      slotName: 'view',
      dataIndex: 'email',
    },
  ];
  // 部门列表数据
  const data = ref<DepartmentTreeVO[]>();

  // 部门树状列表
  const deptTree = ref<[]>();

  // 用户列配置
  const userColumns = [
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
      title: t('department.userColumns.role'),
      dataIndex: 'role',
      slotName: 'role',
    },
    {
      title: t('department.userColumns.state'),
      dataIndex: 'state',
      slotName: 'state',
    },
  ];
  // 用户列表数据
  const userList = ref<[]>();

  // 用户筛选表单
  const userSearch = ref<UserQuery>({});

  const reloadData = async () => {
    await getDeptTree().then((res: any) => {
      data.value = res.data;
      deptTree.value = res.data;
    });
  };
  onMounted(async () => {
    await reloadData();
  });

  const router = useRouter();

  // 添加部门开关
  const addDeptVisible = ref(false);

  // 更新部门开关
  const updateDeptVisible = ref(false);

  // 删除部门开关
  const deleteDeptVisible = ref(false);

  // 抽屉开关
  const userVisible = ref(false);

  const deptRef = ref({});
  const deptUpdateRef = ref({});

  const department = ref<AddDepartmentDTO>({});
  const updateDept = ref<UpdateDeptDTO>({
    id: '',
    department: {
      deptName: '',
    },
  });
  const deleteDept = ref<string>();

  const addDepartment = (record: DepartmentTreeVO) => {
    department.value = {
      parentCode: record.deptCode || '0',
      deptLevel: record.deptLevel + 1 || 0,
    };
    addDeptVisible.value = true;
  };

  const updateDepartment = (record: DepartmentTreeVO) => {
    updateDept.value = {
      id: record.id,
      department: {
        deptName: record.deptName,
      },
    };
    updateDeptVisible.value = true;
  };

  const deleteDepartment = (id: string) => {
    deleteDept.value = id;
    deleteDeptVisible.value = true;
  };

  // 查询部门
  const searchDept = async (value: string) => {
    if (value === '') {
      await reloadData();
    } else {
      await loadDataList({ deptNameFuzzy: value }).then((res: any) => {
        data.value = res.data.list;
      });
    }
  };

  // 添加部门确认
  const handleOk = async () => {
    deptRef.value.validate().then(async (errors: any) => {
      if (!errors) {
        await addDepart(department.value).then(async (res: any) => {
          if (res.data === true) {
            await reloadData();
          }
        });
        addDeptVisible.value = false;
      } else {
        console.log('校验不通过');
      }
    });
  };

  // 添加部门取消
  const handleCancel = () => {
    addDeptVisible.value = false;
    department.value = {};
  };

  // 更新部门确认
  const updateOk = async () => {
    deptUpdateRef.value.validate().then(async (errors: any) => {
      if (!errors) {
        await updateDeptById(updateDept.value).then(async (res: any) => {
          if (res.data === true) {
            await reloadData();
          }
        });
        updateDeptVisible.value = false;
      } else {
        console.log('校验不通过');
      }
    });
  };

  // 更新部门取消
  const updateCancel = () => {
    updateDeptVisible.value = false;
    updateDept.value = {};
  };

  // 删除部门确认
  const deleteOk = async () => {
    console.log('deleteDept.value', deleteDept.value);
    await deleteDeptById(deleteDept.value).then(async (res: any) => {
      if (res.data === true) {
        await reloadData();
      }
    });
    deleteDeptVisible.value = false;
  };

  // 删除部门取消
  const deleteCancel = () => {
    deleteDeptVisible.value = false;
    deleteDept.value = '';
  };

  // 排序上移
  const sortUp = async (record: any) => {
    await departmentSort({ deptId: record.id, sort: 1 }).then(
      async (res: any) => {
        if (res.data === true) {
          await reloadData();
        }
      }
    );
  };

  // 排序下移
  const sortDown = async (record: any) => {
    await departmentSort({ deptId: record.id, sort: 0 }).then(
      async (res: any) => {
        if (res.data === true) {
          await reloadData();
        }
      }
    );
  };

  // 打开抽屉的时候加载当前部门下的所有用户列表
  const loadUserList = async (deptCode: string) => {
    userSearch.value.deptCode = deptCode;
    userSearch.value.userNameFuzzy = '';
    userSearch.value.role = '';
    await getDeptUserList(userSearch.value).then((res: any) => {
      userList.value = res.data;
    });
    userVisible.value = true;
  };

  // 搜索用户
  const searchUserList = async () => {
    await getDeptUserList(userSearch.value).then((res: any) => {
      userList.value = res.data;
    });
  };
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
