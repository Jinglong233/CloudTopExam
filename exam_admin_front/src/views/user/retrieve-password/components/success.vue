<template>
  <a-result status="success" title="重置成功" subtitle="密码重置成功" />
  <a-space :size="16">
    <a-button type="primary" @click="router.push({ name: 'login' })">
      登录
    </a-button>
  </a-space>
</template>

<script setup lang="ts">
  import { useRouter } from 'vue-router';

  const router = useRouter();
</script>

<style scoped></style>
