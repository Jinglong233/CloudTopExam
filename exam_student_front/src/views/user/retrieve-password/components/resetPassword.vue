<template>
  <a-form
    :model="passwordForm"
    class="form"
    :label-col-props="{ span: 6 }"
    :wrapper-col-props="{ span: 18 }"
    @submit="sendPassword"
  >
    <a-form-item
      field="password"
      :rules="[{ required: true, message: '密码不能为空' }]"
    >
      <a-input
        v-model="passwordForm.password"
        :style="{ width: '320px' }"
        placeholder="请输入验证码"
        allow-clear
      />
    </a-form-item>
    <a-form-item
      field="confirmPassword"
      :rules="[{ required: true, message: '密码不能为空' }]"
    >
      <a-input
        v-model="passwordForm.confirmPassword"
        :style="{ width: '320px' }"
        placeholder="请确认密码"
        allow-clear
      />
    </a-form-item>
    <a-form-item>
      <a-button html-type="submit" :loading="loading">重置</a-button>
    </a-form-item>
  </a-form>
</template>

<script setup lang="ts">
  import { PropType, ref } from 'vue';
  import { Message, ValidatedError } from '@arco-design/web-vue';
  import { Record } from '@icon-park/vue-next';
  import { RetrievePasswordDTO } from '@/types/model/dto/RetrievePasswordDTO';
  import { retrievePassword } from '@/api/user';

  const loading = ref(false);
  const passwordForm = ref({
    password: '',
    confirmPassword: '',
  });
  const emit = defineEmits(['stepChange']);

  const props = defineProps({
    retrieveFrom: {
      type: Object as PropType<RetrievePasswordDTO>,
    },
  });

  const finallyForm = ref<RetrievePasswordDTO>({});
  const sendPassword = async ({
    errors,
    values,
  }: {
    errors: Record<string, ValidatedError> | undefined;
    values: Record<string, any>;
  }) => {
    if (!errors) {
      // 通过
      // 判断两次密码是否相等
      if (passwordForm.value.confirmPassword === passwordForm.value.password) {
        finallyForm.value.password = passwordForm.value.password;
        finallyForm.value.userName = props.retrieveFrom?.userName;
        finallyForm.value.email = props.retrieveFrom?.email;
        // 重置密码
        loading.value = true;
        await retrievePassword(finallyForm.value as RetrievePasswordDTO).then(
          (res: any) => {
            if (res.data === true) {
              loading.value = false;
              emit('stepChange', 4, passwordForm.value.password);
            }
          }
        );
        loading.value = false;
      } else {
        Message.warning({
          content: '两次密码不一致',
          duration: 2000,
        });
      }
    } else {
      // 未通过
      console.log('未通过');
    }
  };
</script>

<style scoped></style>
