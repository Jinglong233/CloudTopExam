<template>
  <div class="container">
    <Breadcrumb
      :items="['menu.visualization', 'menu.visualization.dataAnalysis']"
    />
    <a-space direction="vertical" :size="12" fill>
      <a-space direction="vertical" :size="16" fill>
        <div class="space-unit">
          <QuizErrorAnalysis />
        </div>
        <div>
          <WrongKnowledgeDistribution />
        </div>
      </a-space>
    </a-space>
  </div>
</template>

<script lang="ts" setup>
  import QuizErrorAnalysis from '@/views/visualization/data-analysis/components/quiz-error-analysis.vue';
  import WrongKnowledgeDistribution from '@/views/visualization/data-analysis/components/wrong-knowledge-distribution.vue';
  import ContentPeriodAnalysis from './components/content-period-analysis.vue';
</script>

<script lang="ts">
  export default {
    name: 'DataAnalysis',
  };
</script>

<style scoped lang="less">
  .container {
    margin-bottom: 20px;
    padding: 0 20px 20px 20px;
  }

  .space-unit {
    background-color: var(--color-bg-2);
    border-radius: 4px;
  }

  .title-fix {
    margin: 0 0 12px 0;
    font-size: 14px;
  }
  :deep(.section-title) {
    margin: 0 0 12px 0;
    font-size: 14px;
  }
</style>
