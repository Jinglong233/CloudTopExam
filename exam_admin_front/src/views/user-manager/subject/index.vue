<template>
  <div class="container">
    <Breadcrumb :items="['menu.userManager', 'menu.userManager.subject']" />
    <a-card class="general-card" :title="$t('menu.userManager.subject')">
      <a-space>
        <a-button
          v-permission="['admin']"
          type="primary"
          @click="addSubjectConfirm"
        >
          <template #icon>
            <icon-plus />
          </template>
          添加
        </a-button>
        <a-input
          v-model="searchSubjectForm.titleFuzzy"
          :style="{ width: '320px' }"
          placeholder="搜索学科名称"
          @input="searchSubject"
        />
      </a-space>
      <a-drawer />
      <!--添加学科模态框-->
      <a-modal v-model:visible="addSubjectVisible" :footer="false">
        <template #title> 学科管理 </template>
        <a-form ref="subjectRef" :model="subject" @submit="handleOk">
          <a-form-item
            label="学科名称"
            field="title"
            :rules="[{ required: true, message: '请输入学科名称' }]"
          >
            <a-input v-model="subject.title" placeholder="输入学科名称" />
          </a-form-item>
          <a-form-item
            label="所属专业"
            field="deptCode"
            :rules="[{ required: true, message: '请选择所属专业' }]"
          >
            <a-tree-select
              v-model="subject.deptCode"
              :data="deptTree"
              :filter-tree-node="filterDept"
              :field-names="{
                key: 'deptCode',
                title: 'deptName',
                children: 'children',
              }"
              placeholder="选择所属专业"
              allow-clear
            />
          </a-form-item>
          <a-form-item label="备注" field="description">
            <a-input v-model="subject.description" placeholder="输入备注" />
          </a-form-item>
          <a-form-item>
            <a-space>
              <a-button @click="handleCancel">取消</a-button>
              <a-button type="primary" html-type="handleOk">确认</a-button>
            </a-space>
          </a-form-item>
        </a-form>
      </a-modal>
      <!--更新学科模态框-->
      <a-modal
        v-model:visible="updateDeptVisible"
        :footer="false"
        @cancel="updateCancel"
      >
        <template #title> 学科管理 </template>
        <a-form
          ref="subjectUpdateRef"
          :model="updateSubjectForm"
          @submit="updateOk"
        >
          <a-form-item
            label="学科名称"
            field="subject.title"
            :rules="[{ required: true, message: '请输入学科名称' }]"
          >
            <a-input
              v-model="updateSubjectForm.subject.title"
              placeholder="输入学科名称"
            />
          </a-form-item>
          <a-form-item
            label="所属专业"
            field="subject.deptCode"
            :rules="[{ required: true, message: '请选择所属专业' }]"
          >
            <a-tree-select
              v-model="updateSubjectForm.subject.deptCode"
              :data="deptTree"
              :field-names="{
                key: 'deptCode',
                title: 'deptName',
                children: 'children',
              }"
              placeholder="选择所属专业"
              allow-clear
            />
          </a-form-item>
          <a-form-item label="备注" field="subject.description">
            <a-input
              v-model="updateSubjectForm.subject.description"
              placeholder="输入备注"
            />
          </a-form-item>
          <a-form-item>
            <a-space>
              <a-button @click="updateCancel">取消</a-button>
              <a-button type="primary" html-type="updateOk">更新</a-button>
            </a-space>
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
        :pagination="false"
        :scroll="{ x: 100, y: 400 }"
        style="margin-top: 20px"
      >
        <!--操作插槽-->
        <template #option="{ record }">
          <a-space>
            <!--添加学科-->
            <a-button
              v-permission="['admin']"
              shape="round"
              @click="addSubjectConfirm(record)"
            >
              <template #icon>
                <icon-plus />
              </template>
            </a-button>
            <!--修改编辑学科-->
            <a-button
              v-permission="['admin']"
              shape="round"
              @click="updateSubject(record)"
            >
              <template #icon>
                <icon-edit />
              </template>
            </a-button>
            <!--删除学科-->
            <a-button
              v-permission="['admin']"
              shape="round"
              @click="deleteSubjectConfirm(record.id)"
            >
              <template #icon>
                <icon-delete />
              </template>
            </a-button>
          </a-space>
        </template>

        <template #empty>
          <div style="text-align: center"> 无子学科 </div>
        </template>
      </a-table>
    </a-card>
  </div>
</template>

<script lang="ts" setup>
  import { useI18n } from 'vue-i18n';
  import { onMounted, ref } from 'vue';
  import { useRouter } from 'vue-router';
  import { UpdateSubjectDTO } from '@/types/model/dto/UpdateSubjectDTO';
  import { UserQuery } from '@/types/model/query/UserQuery';
  import { AddSubjectDTO } from '@/types/model/dto/AddSubjectDTO';
  import { useUserStore } from '@/store';
  import { SubjectTreeVO } from '@/types/model/vo/SubjectTreeVO';
  import {
    addSubject,
    deleteSubjectById,
    getSubjectTree,
    loadDataList,
    updateSubjectById,
  } from '@/api/subject';
  import { getProfession } from '@/api/department';
  import { Message } from '@arco-design/web-vue';
  import { SubjectQuery } from '@/types/model/query/SubjectQuery';
  import { DepartmentTreeVO } from '@/types/model/vo/DepartmentTreeVO';

  const { t } = useI18n();

  // 学科列配置
  const columns = [
    {
      title: t('subject.columns.title'),
      dataIndex: 'title',
    },
    {
      title: t('subject.columns.deptText'),
      dataIndex: 'deptText',
    },
    {
      title: t('subject.columns.description'),
      dataIndex: 'description',
    },
    {
      title: t('subject.columns.option'),
      slotName: 'option',
    },
  ];
  // 学科列表数据
  const data = ref<SubjectTreeVO[]>();

  // 学科树状列表
  const subjectTree = ref<SubjectTreeVO[]>([]);

  // 搜索学科信息
  const searchSubjectForm = ref<SubjectQuery>({});

  // 部门树
  const deptTree = ref<[]>();

  // 用户筛选表单
  const userSearch = ref<UserQuery>({});

  const reloadData = async () => {
    await getSubjectTree().then((res: any) => {
      data.value = res.data;
      subjectTree.value = res.data;
    });
  };
  onMounted(async () => {
    await reloadData();

    await getProfession().then((res: any) => {
      deptTree.value = res.data;
    });
  });

  const router = useRouter();

  // 添加学科开关
  const addSubjectVisible = ref(false);

  // 更新学科开关
  const updateDeptVisible = ref(false);

  // 删除学科开关
  const deleteDeptVisible = ref(false);

  // 抽屉开关
  const userVisible = ref(false);

  const subjectRef = ref({});
  const subjectUpdateRef = ref({});

  const userStore = useUserStore();
  const subject = ref<AddSubjectDTO>({
    createBy: userStore.id,
  });
  const updateSubjectForm = ref<UpdateSubjectDTO>({
    subject: {
      title: '',
      description: '',
      deptCode: '',
      updateBy: userStore.id,
    },
  });
  const deleteSubjectForm = ref<string>();

  const addSubjectConfirm = (record: SubjectTreeVO) => {
    if (!record) {
      subject.value.parentId = '';
    } else {
      subject.value.parentId = record.id;
    }
    addSubjectVisible.value = true;
  };

  const updateSubject = (record: SubjectTreeVO) => {
    updateSubjectForm.value = {
      id: record.id,
      subject: {
        title: record.title,
        deptCode: record.deptCode,
        deptText: record.deptText,
        description: record.description,
        updateBy: userStore.id,
      },
    };
    updateDeptVisible.value = true;
  };

  const deleteSubjectConfirm = (id: string) => {
    deleteSubjectForm.value = id;
    deleteDeptVisible.value = true;
  };

  // 查询学科
  const searchSubject = async () => {
    await loadDataList(searchSubjectForm.value).then((res: any) => {
      data.value = res.data.list;
    });
  };

  // 添加学科确认
  const handleOk = async ({ values, errors }: any) => {
    if (!errors) {
      await addSubject(subject.value).then(async (res: any) => {
        if (res.data === true) {
          await reloadData();
        }
      });
      addSubjectVisible.value = false;
    } else {
      console.log('校验不通过');
    }
  };

  // 添加学科取消
  const handleCancel = () => {
    addSubjectVisible.value = false;
    subject.value = {
      createBy: userStore.id,
    };
  };

  // 更新学科确认
  const updateOk = async ({ values, errors }: any) => {
    if (!errors) {
      await updateSubjectById(updateSubjectForm.value).then(
        async (res: any) => {
          if (res.data === true) {
            Message.success({
              content: '更新成功',
            });
            await reloadData();
          } else {
            Message.error({
              content: '更新失败',
            });
            await reloadData();
          }
        }
      );
      updateDeptVisible.value = false;
    } else {
      console.log('校验不通过');
    }
  };

  // 更新学科取消
  const updateCancel = () => {
    updateDeptVisible.value = false;
    updateSubjectForm.value = {
      subject: {
        updateBy: userStore.id,
      },
    };
  };

  // 删除学科确认
  const deleteOk = async () => {
    await deleteSubjectById(deleteSubjectForm.value as string).then(
      async (res: any) => {
        if (res.data === true) {
          await reloadData();
        }
      }
    );
    deleteDeptVisible.value = false;
  };

  // 删除学科取消
  const deleteCancel = () => {
    deleteDeptVisible.value = false;
    deleteSubjectForm.value = '';
  };

  // 过滤部门
  const filterDept = (
    searchKey: string,
    nodeData: DepartmentTreeVO
  ): boolean => {
    // console.log('searchKey', searchKey);
    // console.log('nodeData', nodeData.deptLevel);
    // if (nodeData.deptLevel === 1) {
    //   return true;
    // }
    return false;
  };

  // 打开抽屉的时候加载当前学科下的所有用户列表
  const loadUserList = async (deptCode: string) => {
    // userSearch.value.deptCode = deptCode;
    // userSearch.value.userNameFuzzy = '';
    // userSearch.value.role = '';
    // await getDeptUserList(userSearch.value).then((res: any) => {
    //   userList.value = res.data;
    // });
    // userVisible.value = true;
  };

  // 搜索用户
  const searchUserList = async () => {
    // await getDeptUserList(userSearch.value).then((res: any) => {
    //   userList.value = res.data;
    // });
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
