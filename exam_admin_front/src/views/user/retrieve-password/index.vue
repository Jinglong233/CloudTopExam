<template>
  <div class="container">
    <Breadcrumb :items="['登录', 'menu.user.retrievePassword']" />
    <a-spin :loading="loading" style="width: 100%">
      <a-card class="general-card">
        <template #title>
          <a-button @click="router.push({ name: 'login' })"
            ><icon-left />登录</a-button
          >
          {{ $t('menu.user.retrievePassword') }}
        </template>
        <a-card
          style="background-color: #e5eecc; border-radius: 10px; width: 500px"
        >
          说明：如果没有绑定邮箱，请联系<strong>管理员</strong>重置密码
        </a-card>
        <div class="wrapper">
          <a-steps :current="step" style="width: 580px" line-less class="steps">
            <a-step description="Confirm account"> 确认账户 </a-step>
            <a-step description="verify"> 验证 </a-step>
            <a-step description="Reset password"> 重置密码 </a-step>
            <a-step description="Reset successfully"> 重置成功 </a-step>
          </a-steps>
          <keep-alive>
            <ConfirmAccount v-if="step === 1" @step-change="getEmitInfo" />
            <Verify
              v-else-if="step === 2"
              :email="resetPasswordForm.email"
              @step-change="getEmitInfo"
            />
            <ResetPassword
              v-else-if="step === 3"
              :retrieve-from="resetPasswordForm"
              @step-change="getEmitInfo"
            />
            <Success v-else-if="step === 4" @step-change="getEmitInfo" />
          </keep-alive>
        </div>
      </a-card>
    </a-spin>
  </div>
</template>

<script lang="ts" setup>
  import { ref } from 'vue';
  import { RetrievePasswordDTO } from '@/types/model/dto/RetrievePasswordDTO';
  import ConfirmAccount from '@/views/user/retrieve-password/components/confirm-account.vue';
  import Verify from '@/views/user/retrieve-password/components/verify.vue';
  import ResetPassword from '@/views/user/retrieve-password/components/resetPassword.vue';
  import Success from '@/views/user/retrieve-password/components/success.vue';
  import { useRouter } from 'vue-router';

  const router = useRouter();
  const loading = ref(false);
  const resetPasswordForm = ref<RetrievePasswordDTO>({});
  const step = ref(1);
  const getEmitInfo = (st: number, form?: RetrievePasswordDTO) => {
    step.value = st;
    if (form) {
      resetPasswordForm.value = form;
    }
  };
</script>

<style scoped lang="less">
  .container {
    padding: 0 20px 20px 20px;
  }
  .wrapper {
    display: flex;
    flex-direction: column;
    align-items: center;
    padding: 64px 0;
    background-color: var(--color-bg-2);
    :deep(.arco-form) {
      .arco-form-item {
        &:last-child {
          margin-top: 20px;
        }
      }
    }
  }

  .steps {
    margin-bottom: 76px;
  }

  .form {
    width: 500px;
  }
</style>
