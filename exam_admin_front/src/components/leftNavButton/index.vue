<template>
  <!--左侧序号按钮-->
  <a-button
    style="width: 35px"
    type="primary"
    :status="
      getIsRight(anchorId) === 1
        ? 'success'
        : getIsRight(anchorId) === 0
        ? 'danger'
        : 'warning'
    "
    @click="clickAnchor(anchorId)"
  >
    {{ quSort }}
  </a-button>
</template>

<script setup lang="ts">
  import { clickAnchor } from '@/utils/common';
  import { PropType } from 'vue/dist/vue';
  import { UserAnswer } from '@/types/model/po/UserAnswer';
  import { watch } from 'vue';

  const props = defineProps({
    userAnswerList: {
      type: Array as PropType<UserAnswer[]>,
      default: () => {
        return [];
      },
    },
    state: {
      type: String,
    },
    anchorId: {
      type: String,
      default: () => {
        return '';
      },
    },
    quSort: {
      type: Number,
    },
  });

  // 获取当前题目是否正确
  // eslint-disable-next-line consistent-return
  const getIsRight = (id: string) => {
    // eslint-disable-next-line no-plusplus
    for (let i = 0; i < props.userAnswerList.length; i++) {
      if (id === props.userAnswerList[i].quId) {
        return props.userAnswerList[i].isRight;
      }
    }
    return -1;
  };
</script>

<style scoped></style>
