<template>
  <div class="card-wrap">
    <a-card v-if="loading" :bordered="false" hoverable>
      <slot name="skeleton"></slot>
    </a-card>
    <a-card v-else :bordered="false" hoverable>
      <a-space align="start">
        <a-avatar
          v-if="icon"
          :size="24"
          style="margin-right: 8px; background-color: #626aea"
        >
          <icon-filter />
        </a-avatar>
        <a-card-meta>
          <template #title>
            <a-typography-text style="margin-right: 10px">
              {{ title }}
            </a-typography-text>
            <template v-if="showTag">
              <a-tag size="small" color="green">
                <template #icon>
                  <icon-check-circle-fill />
                </template>
                <span>{{ tagText }}</span>
              </a-tag>
            </template>
          </template>
          <template #description>
            {{ description }}
            <slot></slot>
          </template>
        </a-card-meta>
      </a-space>
      <template #actions>
        <div>
          <a-space>
            <a-button
              :disabled="
                userStore.id === repo.createBy && userStore.role !== 'admin'
              "
              @click="handleDelete"
            >
              {{ closeTxt }}
            </a-button>
            <a-button
              type="primary"
              :disabled="
                userStore.id === repo.createBy && userStore.role !== 'admin'
              "
              @click="handleEdit"
            >
              {{ openTxt }}
            </a-button>
          </a-space>
        </div>
      </template>
    </a-card>
  </div>
</template>

<script lang="ts" setup>
  import { Message, Modal } from '@arco-design/web-vue';
  import { deleteRepoById } from '@/api/repo';
  import { Repo } from '@/types/model/po/Repo';
  import { useRouter } from 'vue-router';
  import { useUserStore } from '@/store';

  const userStore = useUserStore();
  const props = defineProps({
    loading: {
      type: Boolean,
      default: false,
    },
    title: {
      type: String,
      default: '',
    },
    description: {
      type: String,
      default: '',
    },
    actionType: {
      type: String,
      default: '',
    },
    defaultValue: {
      type: Boolean,
      default: false,
    },
    openTxt: {
      type: String,
      default: '',
    },
    closeTxt: {
      type: String,
      default: '',
    },
    icon: {
      type: String,
      default: '',
    },
    showTag: {
      type: Boolean,
      default: true,
    },
    tagText: {
      type: String,
      default: '',
    },
    expires: {
      type: Boolean,
      default: false,
    },
    expiresTagText: {
      type: String,
      default: '',
    },
    repo: {
      type: Object,
      default: () => {
        return {} as Repo;
      },
    },
  });

  const router = useRouter();
  // 通知父组件刷新
  const emit = defineEmits(['reloadRepoList']);

  // 删除卡片
  const handleDelete = () => {
    Modal.warning({
      title: '警告',
      content: '确认删除?',
      cancelText: '取消',
      hideCancel: false,
      onCancel: () => {},
      onOk: async () => {
        await deleteRepoById(props.repo?.id).then((res: any) => {
          if (res.data === true) {
            Message.success({
              content: '删除成功',
            });
            // 通知父组件刷新
            emit('reloadRepoList');
          } else {
            Message.error({
              content: '删除失败',
            });
          }
        });
      },
    });
  };

  // 编辑卡片
  const handleEdit = async () => {
    router.push({
      path: '/repo/modify-repo',
      query: {
        id: props.repo.id,
      },
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
