<template>
  <a-layout style="height: 700px; margin-top: 20px">
    <a-layout-content style="margin-left: 20px">
      <a-card :title="t('menu.train.repoDetail')"> 123</a-card>
    </a-layout-content>
    <a-layout-sider style="margin-right: 20px">Sider</a-layout-sider>
  </a-layout>
</template>

<script lang="ts" setup>
  import { useI18n } from 'vue-i18n';
  import { useRouter } from 'vue-router';

  const { t } = useI18n();

  const router = useRouter();
</script>

<style scoped></style>
