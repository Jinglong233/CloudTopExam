<template>
  <a-list :bordered="false">
    <a-list-item
      v-for="msg in renderList"
      :key="msg.id"
      action-layout="vertical"
    >
      <template #extra>
        <a-tag v-if="msg.msgUser.state === 1" color="gray">已读</a-tag>
        <a-tag v-else-if="msg.msgUser.state === 0" color="green">未读</a-tag>
      </template>
      <div class="item-wrap" @click="getMsgDetail(msg)">
        <a-list-item-meta>
          <template #title>
            <a-space :size="4">
              <span>{{ msg.title }}</span>
              <a-typography-text type="secondary">
                {{ msg.sendTime }}
              </a-typography-text>
            </a-space>
          </template>
          <template #description>
            <div>
              <a-typography-paragraph
                :ellipsis="{
                  rows: 1,
                }"
                >{{ msg.content }}</a-typography-paragraph
              >
            </div>
          </template>
        </a-list-item-meta>
      </div>
    </a-list-item>
    <template #footer>
      <a-space
        fill
        :size="0"
        :class="{ 'add-border-top': renderList.length < showMax }"
      >
        <div class="footer-wrap">
          <a-link @click="allRead">{{ $t('messageBox.allRead') }}</a-link>
        </div>
        <div class="footer-wrap">
          <a-link @click="router.push({ name: 'MyMsg' })">{{
            $t('messageBox.viewMore')
          }}</a-link>
        </div>
      </a-space>
    </template>
    <div
      v-if="renderList.length && renderList.length < 3"
      :style="{ height: (showMax - renderList.length) * 86 + 'px' }"
    />
  </a-list>
</template>

<script lang="ts" setup>
  import { PropType } from 'vue';
  import { Msg } from '@/types/model/po/Msg';
  import { MsgVO } from '@/types/model/vo/MsgVO';
  import { useRouter } from 'vue-router';

  const router = useRouter();
  const props = defineProps({
    renderList: {
      type: Array as PropType<MsgVO[]>,
      required: true,
    },
  });
  const emit = defineEmits(['itemClick']);

  // 触发全部已读
  const allRead = () => {
    emit('itemClick', props.renderList);
  };

  const getMsgDetail = (msg: Msg) => {
    console.log('11111', msg);
  };
  const showMax = 3;
</script>

<style scoped lang="less">
  :deep(.arco-list) {
    .arco-list-item {
      min-height: 86px;
      border-bottom: 1px solid rgb(var(--gray-3));
    }
    .arco-list-item-extra {
      position: absolute;
      right: 20px;
    }
    .arco-list-item-meta-content {
      flex: 1;
    }
    .item-wrap {
      cursor: pointer;
    }
    .time-text {
      color: rgb(var(--gray-6));
      font-size: 12px;
    }
    .arco-empty {
      display: none;
    }
    .arco-list-footer {
      height: 50px;
      padding: 0;
      line-height: 50px;
      border-top: none;
      .arco-space-item {
        width: 100%;
        border-right: 1px solid rgb(var(--gray-3));
        &:last-child {
          border-right: none;
        }
      }
      .add-border-top {
        border-top: 1px solid rgb(var(--gray-3));
      }
    }
    .footer-wrap {
      text-align: center;
    }
    .arco-typography {
      margin-bottom: 0;
    }
    .add-border {
      border-top: 1px solid rgb(var(--gray-3));
    }
  }
</style>
