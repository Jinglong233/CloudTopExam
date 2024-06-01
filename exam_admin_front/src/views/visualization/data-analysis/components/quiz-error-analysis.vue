<template>
  <a-card
    class="general-card"
    :title="$t('dataAnalysis.title.wrongAnalyze')"
    :header-style="{ paddingBottom: '12px' }"
  >
    <a-row :gutter="10">
      <a-col :span="12">
        <TopFiveWrongTopics
          :title="$t('dataAnalysis.card.title.topFiveKnoCount')"
          :card-style="{
            background: isDark
              ? ' linear-gradient(180deg, #3D492E 0%, #263827 100%)'
              : 'linear-gradient(180deg, #F5FEF2 0%, #E6FEEE 100%)',
            width: '500px',
          }"
        />
      </a-col>
      <a-col :span="12">
        <QuTypeProportion
          :title="$t('dataAnalysis.card.title.wrongQuCount')"
          :card-style="{
            background: isDark
              ? 'linear-gradient(180deg, #312565 0%, #201936 100%)'
              : 'linear-gradient(180deg, #F7F7FF 0%, #ECECFF 100%)',
            width: '500px',
          }"
        />
      </a-col>
    </a-row>
  </a-card>
</template>

<script lang="ts" setup>
  import useThemes from '@/hooks/themes';
  import QuTypeProportion from '@/views/visualization/data-analysis/components/quType-proportion.vue';
  import TopFiveWrongTopics from '@/views/visualization/data-analysis/components/top-five-wrong-topics.vue';

  const { isDark } = useThemes();
</script>
