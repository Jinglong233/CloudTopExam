<template>
  <!--左侧序号按钮-->
  <a-button
    :type="isNowNumber(anchorId) ? 'primary' : 'outline'"
    @click="clickAnchor(anchorId)"
  >
    {{ quSort }}
  </a-button>
</template>

<script setup lang="ts">
  import { clickAnchor } from '@/utils/common';

  defineProps(['anchorId', 'quSort']);

  const isNowNumber = (anchorId: any) => {
    return true;
  };
</script>

<style scoped></style>
