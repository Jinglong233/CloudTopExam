<template>
  <!--树状展示栏-->
  <a-affix :offset-top="100">
    <a-card
      :style="{
        height: '720px',
        marginLeft: '10px',
        marginRight: '10px',
      }"
      :title="title"
    >
      <slot>
        <a-empty>
          <template #image>
            <icon-exclamation-circle-fill />
          </template>
          No data, please reload!
        </a-empty>
      </slot>
    </a-card>
  </a-affix>
</template>

<script setup lang="ts">
  defineProps(['title']);
</script>

<style scoped></style>
