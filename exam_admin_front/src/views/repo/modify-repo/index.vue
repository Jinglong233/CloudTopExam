<template>
  <div class="container">
    <Breadcrumb :items="['menu.repo', 'menu.repo.updateRepo']" />
    <a-card class="general-card" :title="$t('menu.repo.updateRepo')">
      <a-form
        ref="updateFormRef"
        :model="updateForm"
        :style="{ width: '600px' }"
        @submit="handleSubmit"
      >
        <!--题库名称-->
        <a-form-item
          field="repo.title"
          label="题库"
          :rules="[{ required: true, message: '题库名称不能为空' }]"
        >
          <a-input
            v-model="updateForm.repo.title"
            :style="{ width: '320px' }"
            placeholder="输入题库名称"
          />
        </a-form-item>

        <!--学科-->
        <a-form-item
          field="repo.subjectId"
          label="所属学科"
          :rules="[{ required: true, message: '学科不能为空' }]"
        >
          <a-tree-select
            v-model="updateForm.repo.subjectId"
            :data="subjectTree"
            :field-names="{
              key: 'id',
              title: 'title',
              children: 'children',
            }"
            :style="{ width: '320px' }"
            placeholder="请选择学科"
            allow-clear
          />
        </a-form-item>

        <!--部门-->
        <a-form-item
          field="repo.deptCode"
          label="所属部门"
          :rules="[{ required: true, message: '所属部门不能为空' }]"
        >
          <a-tree-select
            v-model="updateForm.repo.deptCode"
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
        <a-form-item field="repo.isExam" tooltip="考试可以选择该题库题目">
          <a-checkbox v-model="updateForm.repo.isExam">是否用于考试</a-checkbox>
        </a-form-item>
        <a-form-item field="repo.isTrain" tooltip="训练可以使用该题库">
          <a-checkbox v-model="updateForm.repo.isTrain"
            >是否用于训练</a-checkbox
          >
        </a-form-item>

        <!--备注-->
        <a-form-item field="repo.remark" label="备注">
          <a-textarea
            v-model="updateForm.repo.remark"
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
  import { UpdateRepoDTO } from '@/types/model/dto/UpdateRepoDTO';
  import { getDeptTree } from '@/api/department';
  import { Repo } from '@/types/model/po/Repo';
  import { useRoute, useRouter } from 'vue-router';
  import { getRepoById, updateRepoById } from '@/api/repo';
  import { Message } from '@arco-design/web-vue';
  import { SubjectTreeVO } from '@/types/model/vo/SubjectTreeVO';
  import { getSubjectTree } from '@/api/subject';

  const route = useRoute();
  const router = useRouter();
  // 部门树列表
  const deptTree = ref<[]>();

  // 学科树
  const subjectTree = ref<SubjectTreeVO[]>([]);
  // 更新表单
  const updateForm = ref<UpdateRepoDTO>({
    repo: {} as Repo,
    id: '',
  });

  const reloadRepoInfo = async () => {
    // 获取路由参数,进而获取题库信息
    await getRepoById(route.query.id as string).then((res: any) => {
      // 处理Boolean和tinyInt的转换
      res.data.isExam = Boolean(res.data.isExam);
      res.data.isTrain = Boolean(res.data.isTrain);
      updateForm.value.repo = res.data;
      updateForm.value.id = res.data.id;
    });
  };
  // 更新表单引用
  const updateFormRef = ref();

  onMounted(async () => {
    await getDeptTree().then((res: any) => {
      deptTree.value = res.data;
    });
    await reloadRepoInfo();
    await getSubjectTree().then((res: any) => {
      subjectTree.value = res.data;
    });
  });

  // 提交更新
  const handleSubmit = async () => {
    updateForm.value.repo.isExam = Number(updateForm.value.repo.isExam);
    updateForm.value.repo.isTrain = Number(updateForm.value.repo.isTrain);
    await updateRepoById(updateForm.value).then(async (res: any) => {
      if (res.data === true) {
        Message.success({
          content: '更新成功',
        });
        router.back();
      } else {
        Message.error({
          content: '更新失败',
        });
        await reloadRepoInfo();
      }
    });
  };
</script>

<style scoped lang="less">
  .card-wrap {
    height: 100%;
    border: 1px solid var(--color-neutral-3);
    border-radius: 4px;
    transition: all 0.3s;

    &:hover {
      transform: translateY(-4px);
      // box-shadow: 4px 4px 10px rgba(0, 0, 0, 0.1);
    }

    :deep(.arco-card) {
      height: 100%;
      border-radius: 4px;

      .arco-card-body {
        height: 100%;

        .arco-space {
          width: 100%;
          height: 100%;

          .arco-space-item {
            height: 100%;

            &:last-child {
              flex: 1;
            }

            .arco-card-meta {
              display: flex;
              flex-flow: column;
              height: 100%;

              .arco-card-meta-content {
                flex: 1;

                .arco-card-meta-description {
                  margin-top: 8px;
                  color: rgb(var(--gray-6));
                  font-size: 12px;
                  line-height: 20px;
                }
              }

              .arco-card-meta-footer {
                margin-top: 0;
              }
            }
          }
        }
      }
    }

    :deep(.arco-card-meta-title) {
      display: flex;
      align-items: center;

      // To prevent the shaking
      line-height: 28px;
    }

    :deep(.arco-skeleton-line) {
      &:last-child {
        display: flex;
        justify-content: flex-end;
        margin-top: 20px;
      }
    }
  }
</style>
