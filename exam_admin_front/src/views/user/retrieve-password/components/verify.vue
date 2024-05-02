<template>
  <a-form
    :model="codeForm"
    class="form"
    :label-col-props="{ span: 6 }"
    :wrapper-col-props="{ span: 18 }"
    @submit="confirmCheck"
  >
    <a-form-item
      field="code"
      :rules="[
        { required: true, message: '验证码不能为空' },
        { length: 5, message: '请输入长度为5的验证码' },
        { type: 'number', message: '请输入纯数字' },
      ]"
    >
      <a-input
        v-model="codeForm.code"
        :style="{ width: '320px' }"
        placeholder="请输入验证码"
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
  import { Message, ValidatedError } from '@arco-design/web-vue';
  import { Record } from '@icon-park/vue-next';
  import { CheckEmailCodeDTO } from '@/types/model/dto/CheckEmailCodeDTO';
  import { checkCode } from '@/api/email';

  const codeForm = ref<CheckEmailCodeDTO>({});
  const loading = ref(false);

  const props = defineProps(['email']);
  const emit = defineEmits(['stepChange']);

  const confirmCheck = async ({
    errors,
    values,
  }: {
    errors: Record<string, ValidatedError> | undefined;
    values: Record<string, any>;
  }) => {
    if (!errors) {
      // 通过
      codeForm.value.email = props.email;
      loading.value = true;
      // 验证验证码
      await checkCode(codeForm.value).then((res: any) => {
        if (res.data === true) {
          Message.success({
            content: '验证成功',
            duration: 2000,
          });
          loading.value = false;
          emit('stepChange', 3);
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
