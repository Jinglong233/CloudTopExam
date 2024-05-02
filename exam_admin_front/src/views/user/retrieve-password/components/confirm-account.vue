<template>
  <a-form
    ref="confirmAccountRef"
    :model="resetPasswordForm"
    class="form"
    :label-col-props="{ span: 6 }"
    :wrapper-col-props="{ span: 18 }"
    @submit="getEmailCode"
  >
    <a-form-item
      field="userName"
      :rules="[{ required: true, message: '用户名不能为空' }]"
    >
      <a-input
        v-model="resetPasswordForm.userName"
        :style="{ width: '320px' }"
        placeholder="请输入用户名"
        allow-clear
      />
    </a-form-item>
    <a-form-item
      field="email"
      :rules="[{ required: true, message: '邮箱不能为空' }]"
    >
      <a-input
        v-model="resetPasswordForm.email"
        :style="{ width: '320px' }"
        placeholder="请输入邮箱"
        allow-clear
      />
    </a-form-item>
    <a-form-item>
      <a-button html-type="submit" :loading="loading">下一步</a-button>
    </a-form-item>
  </a-form>
</template>

<script setup lang="ts">
  import { ref } from 'vue';
  import { RetrievePasswordDTO } from '@/types/model/dto/RetrievePasswordDTO';
  import { Message, ValidatedError } from '@arco-design/web-vue';
  import { Record } from '@icon-park/vue-next';
  import { getRetrievePasswordCode } from '@/api/user';

  const confirmAccountRef = ref();
  const loading = ref(false);
  const resetPasswordForm = ref<RetrievePasswordDTO>({});
  const emit = defineEmits(['stepChange']);

  const getEmailCode = async ({
    errors,
    values,
  }: {
    errors: Record<string, ValidatedError> | undefined;
    values: Record<string, any>;
  }) => {
    if (!errors) {
      // 通过
      loading.value = true;
      await getRetrievePasswordCode({
        userName: resetPasswordForm.value.userName,
        email: resetPasswordForm.value.email,
      }).then((res: any) => {
        if (res.data === true) {
          Message.success({
            content: '验证码发送成功',
            duration: 2000,
          });
          loading.value = false;
          emit('stepChange', 2, resetPasswordForm.value);
        }
      });
      loading.value = false;
    } else {
      // 未通过
      console.log('未通过');
    }
  };
</script>

<style scoped></style>
