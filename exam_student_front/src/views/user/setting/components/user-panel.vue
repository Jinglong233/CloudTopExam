<template>
  <a-card :bordered="false">
    <a-space :size="54">
      <a-upload
        :custom-request="customRequest"
        list-type="picture-card"
        :file-list="fileList"
        :show-upload-button="true"
        :show-file-list="false"
        @change="uploadChange"
      >
        <template #upload-button>
          <a-avatar
            :size="100"
            class="info-avatar"
            :image-url="userStore.avatar"
          >
            <template #trigger-icon>
              <icon-camera />
            </template>
          </a-avatar>
        </template>
      </a-upload>
      <a-descriptions
        :data="renderData"
        :column="2"
        align="right"
        layout="inline-horizontal"
        :label-style="{
          width: '140px',
          fontWeight: 'normal',
          color: 'rgb(var(--gray-8))',
        }"
        :value-style="{
          width: '200px',
          paddingLeft: '8px',
          textAlign: 'left',
        }"
      >
        <template #label="{ label }">{{ $t(label) }} :</template>

        <template #value="{ value, data }">
          <template v-if="data.label === 'userSetting.label.sex'">
            <a-tag v-if="value == '1'" color="skyBlue" size="small">
              <icon-man />
              男
            </a-tag>
            <a-tag v-if="value == '0'" color="pink" size="small">
              <icon-woman />
              女
            </a-tag>
          </template>
          <template v-else-if="data.label === 'userSetting.label.roles'">
            <a-tag v-if="value == 'student'" color="skyBlue" size="small">
              学生
            </a-tag>
            <a-tag v-if="value == 'teacher'" color="pink" size="small">
              教师
            </a-tag>
            <a-tag v-if="value == 'admin'" color="grey" size="small">
              管理员
            </a-tag>
          </template>
          <span v-else>{{ value }}</span>
        </template>
      </a-descriptions>
    </a-space>
  </a-card>
</template>

<script lang="ts" setup>
  import { getCurrentInstance, ref } from 'vue';
  import type {
    FileItem,
    RequestOption,
  } from '@arco-design/web-vue/es/upload/interfaces';
  import { useUserStore } from '@/store';
  import type { DescData } from '@arco-design/web-vue/es/descriptions/interface';
  import { userUploadApi } from '@/api/user-center';
  import { Message } from '@arco-design/web-vue';

  const userStore = useUserStore();
  const file = {
    uid: '-2',
    name: 'avatar.png',
    url: userStore.avatar,
  };
  const renderData = [
    {
      label: 'userSetting.label.userName',
      value: userStore.userName,
    },
    {
      label: 'userSetting.label.realName',
      value: userStore.realName,
    },
    {
      label: 'userSetting.label.sex',
      value: userStore.sex,
    },
    {
      label: 'userSetting.label.deptCode',
      value: userStore.deptText,
    },
    {
      label: 'userSetting.label.roles',
      value: userStore.role,
    },
    {
      label: 'userSetting.label.createTime',
      value: userStore.createTime,
    },
  ] as DescData[];
  const fileList = ref<FileItem[]>([file]);

  const userInfo = useUserStore();
  const uploadChange = (fileItemList: FileItem[], fileItem: FileItem) => {
    fileList.value = [fileItem];
  };
  const customRequest = (options: RequestOption) => {
    const controller = new AbortController();
    (async function requestWrap() {
      const {
        onProgress,
        onError,
        onSuccess,
        fileItem,
        name = 'file',
      } = options;
      onProgress(20);
      const formData = new FormData();
      formData.append(name as string, fileItem.file as Blob);
      const onUploadProgress = (event: ProgressEvent) => {
        let percent;
        if (event.total > 0) {
          percent = (event.loaded / event.total) * 100;
        }
        onProgress(parseInt(String(percent), 10), event);
      };

      try {
        const res = await userUploadApi(formData, {
          controller,
          onUploadProgress,
        }).then(async (r: any) => {
          if (r.data === true) {
            Message.success({
              content: '上传成功',
              duration: 2000,
            });
            await userInfo.reloadState();
            // 重新渲染页面
            const { ctx: that } = getCurrentInstance() as any;
            that.$forceUpdate();
            onSuccess(res);
          }
        });
      } catch (error) {
        onError(error);
      }
    })();
    return {
      abort() {
        controller.abort();
      },
    };
  };
</script>

<style scoped lang="less">
  .arco-card {
    padding: 14px 0 4px 4px;
    border-radius: 4px;
  }

  :deep(.arco-avatar-trigger-icon-button) {
    width: 32px;
    height: 32px;
    line-height: 32px;
    background-color: #e8f3ff;

    .arco-icon-camera {
      margin-top: 8px;
      color: rgb(var(--arcoblue-6));
      font-size: 14px;
    }
  }
</style>
