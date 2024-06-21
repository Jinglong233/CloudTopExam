<template>
  <a-card
    class="general-card"
    :title="$t('workplace.docs')"
    :header-style="{ paddingBottom: 0 }"
    :body-style="{ paddingTop: 0 }"
    style="height: 166px"
  >
    <a-row>
      <a-space align="center">
        <a-tag color="green">开发文档: </a-tag>
        <a-link href="https://jinglong233.github.io/CloudTopExamDoc/">
          点击前往地址
        </a-link>
      </a-space>
    </a-row>
    <a-row>
      <a-space align="center">
        <a-tag color="green"> CloudTopExam交流群: </a-tag>967055645
      </a-space>
    </a-row>
  </a-card>
</template>

<style lang="less" scoped>
  .arco-card-body .arco-link {
    margin: 10px 0;
    color: rgb(var(--gray-8));
  }
</style>
