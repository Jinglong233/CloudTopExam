<template>
  <a-form
    ref="formRef"
    :model="formData"
    class="form"
    :label-col-props="{ span: 8 }"
    :wrapper-col-props="{ span: 16 }"
  >
    <a-form-item
      field="phone"
      :label="$t('userSetting.basicInfo.form.label.phone')"
    >
      <a-input
        v-model="formData.user.phone"
        :placeholder="$t('userSetting.basicInfo.placeholder.phone')"
      />
    </a-form-item>
    <a-form-item
      field="sex"
      :label="$t('userSetting.basicInfo.form.label.sex')"
    >
      <a-select
        v-model="formData.user.sex"
        :placeholder="$t('userSetting.basicInfo.placeholder.sex')"
      >
        <a-option :value="0">女</a-option>
        <a-option :value="1">男</a-option>
      </a-select>
    </a-form-item>
    <a-form-item>
      <a-space>
        <a-button type="primary" @click="save">
          {{ $t('userSetting.save') }}
        </a-button>
        <a-button type="secondary" @click="reset">
          {{ $t('userSetting.reset') }}
        </a-button>
      </a-space>
    </a-form-item>
  </a-form>
</template>

<script lang="ts" setup>
  import { ref } from 'vue';
  import { useUserStore } from '@/store';
  import { UpdateUserDTO } from '@/types/model/dto/UpdateUserDTO';
  import { updateUserById } from '@/api/user';
  import { User } from '@/types/model/po/User';

  const userInfo = useUserStore();
  const formRef = ref();
  const formData = ref<UpdateUserDTO>({
    user: {} as User,
    id: userInfo.id,
  });

  const save = async () => {
    formRef.value.validate().then(async (errors: any) => {
      if (!errors) {
        await updateUserById(formData.value).then(async (res: any) => {
          if (res.data === true) {
            await userInfo.reloadState();
          }
        });
      }
    });
  };
  const reset = () => {
    formRef.value.resetFields();
  };
</script>

<style scoped lang="less">
  .form {
    width: 540px;
    margin: 0 auto;
  }
</style>
