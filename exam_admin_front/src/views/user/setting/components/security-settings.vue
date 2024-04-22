<template>
  <a-list :bordered="false">
    <a-list-item>
      <a-list-item-meta>
        <template #avatar>
          <a-typography-paragraph>
            {{ $t('userSetting.SecuritySettings.form.label.password') }}
          </a-typography-paragraph>
        </template>
        <template #description>
          <div class="content">
            <a-typography-paragraph>
              {{ $t('userSetting.SecuritySettings.placeholder.password') }}
            </a-typography-paragraph>
          </div>
          <div class="operation">
            <a-link @click="startUpdate('password')">
              {{ $t('userSetting.SecuritySettings.button.update') }}
            </a-link>
          </div>
        </template>
      </a-list-item-meta>
    </a-list-item>
    <a-list-item>
      <a-list-item-meta>
        <template #avatar>
          <a-typography-paragraph>
            {{ $t('userSetting.SecuritySettings.form.label.phone') }}
          </a-typography-paragraph>
        </template>
        <template #description>
          <div class="content">
            <a-typography-paragraph>
              已绑定：150******50
            </a-typography-paragraph>
          </div>
          <div class="operation">
            <a-link @click="startUpdate('phone')">
              {{ $t('userSetting.SecuritySettings.button.update') }}
            </a-link>
          </div>
        </template>
      </a-list-item-meta>
    </a-list-item>
    <a-list-item>
      <a-list-item-meta>
        <template #avatar>
          <a-typography-paragraph>
            {{ $t('userSetting.SecuritySettings.form.label.email') }}
          </a-typography-paragraph>
        </template>
        <template #description>
          <div class="content">
            <a-typography-paragraph class="tip">
              {{ $t('userSetting.SecuritySettings.placeholder.email') }}
            </a-typography-paragraph>
          </div>
          <div class="operation">
            <a-link @click="startUpdate('email')">
              {{ $t('userSetting.SecuritySettings.button.update') }}
            </a-link>
          </div>
        </template>
      </a-list-item-meta>
    </a-list-item>
  </a-list>
  <a-modal
    :visible="modalVisible"
    ok-text="确认修改"
    :ok-loading="loading"
    @cancel="modalVisible = false"
    @ok="confirmUpdate"
  >
    <template #title>
      <template v-if="currentIndex === 'password'">修改密码</template>
      <template v-if="currentIndex === 'phone'">修改手机号</template>
      <template v-if="currentIndex === 'email'">修改/绑定邮箱</template>
    </template>
    <a-form
      v-if="currentIndex === 'password'"
      ref="passwordRef"
      :model="updatePasswordForm"
      :rules="passwordRules"
    >
      <a-form-item label="原密码" field="oldPassword">
        <a-input-password
          v-model="updatePasswordForm.oldPassword"
          placeholder="请输入旧密码"
        />
      </a-form-item>
      <a-form-item label="新密码" field="newPassword">
        <a-input-password
          v-model="updatePasswordForm.newPassword"
          placeholder="请输入新密码"
        />
      </a-form-item>
      <a-form-item label="确认新密码" field="confirmPassword">
        <a-input-password
          v-model="updatePasswordForm.confirmPassword"
          placeholder="请确认密码"
        />
      </a-form-item>
    </a-form>
    <a-form v-if="currentIndex === 'phone'"></a-form>
    <a-form
      v-if="currentIndex === 'email'"
      ref="emailRef"
      :model="bindEmailForm"
    >
      <div v-if="userStore.email">
        <a-row>
          <a-space>
            {{ userStore.email }}
          </a-space>
        </a-row>
        <a-row>
          <a-input-search
            :style="{ width: '320px' }"
            placeholder="请输入邮箱验证码"
            button-text="获取验证码"
            search-button
          />
        </a-row>
      </div>
      <div v-else>
        <a-row>
          <a-space> 您还未绑定邮箱 </a-space>
        </a-row>
        <a-row>
          <a-form-item
            :rules="[
              { required: true, message: '邮箱不能为空' },
              { type: 'email', message: '请输入正确的邮箱地址' },
            ]"
          >
            <a-input v-model="bindEmailForm.email" placeholder="请输入QQ邮箱" />
          </a-form-item>
          <a-form-item
            :rules="[
              { required: true, message: '验证码不能为空' },
              { type: 'number', length: 5 },
            ]"
          >
            <a-input-search
              v-model="bindEmailForm.code"
              :style="{ width: '320px' }"
              placeholder="请输入邮箱验证码"
              search-button
              button-text="获取验证码"
              :button-props="{
                disabled: setCode,
              }"
              @search="sendCode"
            >
              <template #button-icon>
                <a-countdown
                  v-if="setCode"
                  :value="Date.now() + 60000"
                  format="ss"
                  :now="Date.now()"
                  :value-style="{
                    color: '#f2f3f5',
                    fontSize: '15px',
                  }"
                  @finish="setCode = false"
                />
              </template>
            </a-input-search>
          </a-form-item>
        </a-row>
      </div>
    </a-form>
  </a-modal>
</template>

<script lang="ts" setup>
  import { ref } from 'vue';
  import { Message, ValidatedError } from '@arco-design/web-vue';
  import {
    getEmailCode,
    updateUserEmail,
    updateUserPassword,
  } from '@/api/user';
  import { useUserStore } from '@/store';
  import useUser from '@/hooks/user';
  import { useRouter } from 'vue-router';

  const userStore = useUserStore();
  const router = useRouter();

  const modalVisible = ref(false);
  const currentIndex = ref();
  const passwordRef = ref();
  const emailRef = ref();

  // 发送验证码禁用状态
  const setCode = ref(false);

  const loading = ref(false);

  const updatePasswordForm = ref({
    oldPassword: '',
    newPassword: '',
    confirmPassword: '',
  });

  const bindEmailForm = ref({
    email: userStore.email,
    code: '',
  });
  const startUpdate = (index: string) => {
    currentIndex.value = index;
    modalVisible.value = true;
  };

  const passwordRules = {
    oldPassword: { required: true, message: '原密码不能为空' },
    newPassword: { required: true, message: '新密码不能为空' },
    confirmPassword: { required: true, message: '确认密码为空' },
  };

  // 发送验证码
  const sendCode = async () => {
    setCode.value = true;
    // 发送验证码
    await getEmailCode(bindEmailForm.value.email as string).then((res: any) => {
      if (res.data === true) {
        Message.success({
          content: '验证码发送成功',
          duration: 2000,
        });
      } else {
        Message.error({
          content: res.info,
          duration: 2000,
        });
      }
    });
  };

  const confirmUpdate = () => {
    // 修改密码的
    if (currentIndex.value === 'password') {
      // 先校验表单
      passwordRef.value.validate(
        async (errors: undefined | Record<string, ValidatedError>) => {
          if (!errors) {
            // 检查新密码和确认密码是否一致
            if (
              updatePasswordForm.value.newPassword !==
              updatePasswordForm.value.confirmPassword
            ) {
              Message.warning({
                content: '两次密码不一致',
                duration: 2000,
              });
            } else {
              loading.value = true;
              // 提交密码修改
              await updateUserPassword({
                userId: userStore.id,
                oldPassword: updatePasswordForm.value.oldPassword,
                newPassword: updatePasswordForm.value.newPassword,
              }).then((res: any) => {
                loading.value = false;
                if (res.data === true) {
                  Message.success({
                    content: '更新成功，请重新登录',
                    duration: 2000,
                  });
                  useUser().logout();
                  router.replace({
                    name: 'login',
                  });
                } else {
                  Message.error({
                    content: res.data.info,
                    duration: 2000,
                  });
                }
              });
            }
          }
        }
      );
    }

    // 修改/绑定邮箱的
    if (currentIndex.value === 'email') {
      if (userStore.email) {
        // 修改邮箱的
      } else {
        // 绑定邮箱的
        // 先校验表单
        emailRef.value.validate(
          async (errors: undefined | Record<string, ValidatedError>) => {
            if (!errors) {
              // 校验通过
              await updateUserEmail({
                userId: userStore.id,
                email: bindEmailForm.value.email,
                code: bindEmailForm.value.code,
              }).then((res: any) => {
                if (res.data === true) {
                  Message.success({
                    content: '绑定成功',
                    duration: 2000,
                  });
                  modalVisible.value = false;
                  userStore.reloadState();
                } else {
                  Message.error({
                    content: res.info,
                    duration: 2000,
                  });
                }
              });
            } else {
              // 校验失败
            }
          }
        );
      }
    }
  };
</script>

<style scoped lang="less">
  :deep(.arco-list-item) {
    border-bottom: none !important;
    .arco-typography {
      margin-bottom: 20px;
    }
    .arco-list-item-meta-avatar {
      margin-bottom: 1px;
    }
    .arco-list-item-meta {
      padding: 0;
    }
  }
  :deep(.arco-list-item-meta-content) {
    flex: 1;
    border-bottom: 1px solid var(--color-neutral-3);

    .arco-list-item-meta-description {
      display: flex;
      flex-flow: row;
      justify-content: space-between;

      .tip {
        color: rgb(var(--gray-6));
      }
      .operation {
        margin-right: 6px;
      }
    }
  }
</style>
