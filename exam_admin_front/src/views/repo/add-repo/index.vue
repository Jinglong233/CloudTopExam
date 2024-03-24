<template>
  <div class="container">
    <Breadcrumb :items="['menu.repo', 'menu.repo.addRepo']" />
    <a-card class="general-card" :title="$t('menu.repo.addRepo')">
      <a-form
        ref="formRef"
        :model="form"
        :style="{ width: '600px' }"
        @submit="handleSubmit"
      >
        <!--题库名称-->
        <a-form-item
          field="title"
          label="题库"
          :rules="[{ required: true, message: '题库名称不能为空' }]"
        >
          <a-input
            v-model="form.title"
            :style="{ width: '320px' }"
            placeholder="输入题库名称"
          />
        </a-form-item>

        <!--学科-->
        <a-form-item
          field="subjectId"
          label="所属学科"
          :rules="[{ required: true, message: '学科不能为空' }]"
        >
          <a-tree-select
            v-model="form.subjectId"
            :data="subjectTree"
            :field-names="{
              key: 'id',
              title: 'title',
              children: 'children',
            }"
            placeholder="请选择学科"
          />
        </a-form-item>

        <!--部门-->
        <a-form-item
          field="deptCode"
          label="所属部门"
          :rules="[{ required: true, message: '所属部门不能为空' }]"
        >
          <a-tree-select
            v-model="form.deptCode"
            placeholder="选择题库所属部门"
            :data="deptTree"
            :field-names="{
              key: 'deptCode',
              title: 'deptName',
              children: 'children',
            }"
          />
        </a-form-item>

        <!--作用范围-->
        <a-form-item field="isExam" tooltip="考试可以选择该题库题目">
          <a-checkbox v-model="form.isExam" :value="1">是否用于考试</a-checkbox>
        </a-form-item>
        <a-form-item field="isTrain" tooltip="训练可以使用该题库">
          <a-checkbox v-model="form.isTrain" :value="1"
            >是否用于训练</a-checkbox
          >
        </a-form-item>

        <!--备注-->
        <a-form-item field="remark" label="备注">
          <a-textarea
            v-model="form.remark"
            placeholder="输入备注"
            :max-length="100"
            show-word-limit
          />
        </a-form-item>

        <!--按钮-->
        <a-form-item>
          <a-space>
            <a-button type="primary" html-type="submit">提交</a-button>
          </a-space>
        </a-form-item>
      </a-form>
    </a-card>
  </div>
</template>

<script lang="ts" setup>
  import { onMounted, ref } from 'vue';

  import { addRepo, getRepoList } from '@/api/repo';
  import { AddRepoDTO } from '@/types/model/dto/AddRepoDTO';
  import { getDeptTree } from '@/api/department';
  import { Message } from '@arco-design/web-vue';
  import { useRouter } from 'vue-router';
  import { useUserStore } from '@/store';
  import { SubjectTreeVO } from '@/types/model/vo/SubjectTreeVO';
  import { getSubjectTree } from '@/api/subject';

  // 题库列表
  const repoList = ref();

  // 部门树
  const deptTree = ref();
  // 学科树
  const subjectTree = ref<SubjectTreeVO[]>([]);

  const router = useRouter();
  const userStore = useUserStore();

  onMounted(async () => {
    // 获取题库列表
    await getRepoList({}).then((res: any) => {
      repoList.value = res.data.list;
    });
    await getDeptTree().then((res: any) => {
      deptTree.value = res.data;
    });

    await getSubjectTree().then((res: any) => {
      subjectTree.value = res.data;
    });
  });

  const formRef = ref();
  const form = ref<AddRepoDTO>({
    createBy: userStore.id,
  });

  /**
   * 添加提交
   * @param values
   * @param errors
   */
  const handleSubmit = async ({ values, errors }: any) => {
    if (!errors) {
      // 类型转换
      form.value.isTrain = form.value.isTrain ? 1 : 0;
      form.value.isExam = form.value.isExam ? 1 : 0;
      await addRepo(form.value).then((res: any) => {
        if (res.data === true) {
          Message.success({
            content: '添加成功',
          });
          // 页面跳转
          router.push({
            path: '/repo/repo-manager',
          });
        } else {
          Message.error({
            content: '添加失败',
          });
        }
      });
    } else {
      console.log('校验未通过');
    }
    form.value = {};
  };
</script>

<style scoped lang="less">
  .container {
    padding: 0 20px 20px 20px;

    :deep(.arco-list-content) {
      overflow-x: hidden;
    }

    :deep(.arco-card-meta-title) {
      font-size: 14px;
    }
  }

  :deep(.arco-list-col) {
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    justify-content: space-between;
  }

  :deep(.arco-list-item) {
    width: 33%;
  }

  :deep(.block-title) {
    margin: 0 0 12px 0;
    font-size: 14px;
  }

  :deep(.list-wrap) {
    // min-height: 140px;
    .list-row {
      align-items: stretch;

      .list-col {
        margin-bottom: 16px;
      }
    }

    :deep(.arco-space) {
      width: 100%;

      .arco-space-item {
        &:last-child {
          flex: 1;
        }
      }
    }
  }
</style>
