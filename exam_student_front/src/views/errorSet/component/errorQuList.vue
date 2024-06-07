<template>
  <a-space style="margin-bottom: 10px">
    <a-button type="primary" @click="asceSort()">正确次数升序排列</a-button>
    <a-button type="primary" @click="descSort()">正确次数降序排列</a-button>
    <a-button type="primary" @click="resetSort()">重置排序</a-button>
  </a-space>
  <a-spin :loading="loading" tip="加载中" dot>
    <a-scrollbar style="height: 500px; overflow: auto">
      <template v-for="(qu, outIndex) in allQuestion" :key="outIndex">
        <a-card class="general-card" style="width: 1200px">
          <!--问题部分-->
          <template #title>
            <div>
              <a-space>
                <span>
                  <BookMark :number="outIndex + 1" />
                </span>
                <div v-html="qu.quAndAnswerVo.content" />
              </a-space>
            </div>
          </template>
          <a-row :gutter="10">
            <a-col :span="17">
              <!--选项部分(非简答)-->
              <template
                v-if="qu.quAndAnswerVo.quType !== QuestionType.SHORTANSWER"
              >
                <a-card
                  v-for="quAnswer in qu.quAndAnswerVo.quAnswerList"
                  :key="quAnswer.id"
                  hoverable
                  :style="{ width: '100%', marginBottom: '20px' }"
                >
                  <div
                    :style="{
                      display: 'flex',
                      alignItems: 'center',
                      justifyContent: 'space-between',
                    }"
                  >
                    <a-space
                      :style="{
                        display: 'flex',
                        alignItems: 'center',
                        color: '#1D2129',
                      }"
                    >
                      <a-typography-text
                        v-if="
                          qu.quAndAnswerVo.quType !== QuestionType.JUDGING &&
                          qu.quAndAnswerVo.quType !== QuestionType.GAPFILLING
                        "
                        type="primary"
                      >
                        {{ quAnswer.tag }}
                      </a-typography-text>
                      <div v-html="quAnswer.content" />
                    </a-space>
                    <a-space v-if="quAnswer.isRight">
                      <a-badge>
                        <template #content>
                          <icon-check-circle-fill
                            :style="{
                              verticalAlign: 'text-top',
                              color: '#00B42A',
                            }"
                          />
                        </template>
                      </a-badge>
                      <span> 答案 </span>
                    </a-space>
                  </div>
                </a-card>
              </template>

              <!--知识点-->
              <a-space>
                知识点：<a-tag style="margin: 5px" color="green">{{
                  qu.quAndAnswerVo.knowledge
                }}</a-tag>
              </a-space>

              <!--解析-->
              <a-card :style="{ backgroundColor: '#fcfcfc' }">
                <a-space direction="vertical" fill>
                  <a-space>
                    <a-typography-text>答案解析：</a-typography-text>
                    <div
                      v-html="
                        qu.quAndAnswerVo.analysis === null || ''
                          ? '无'
                          : qu.quAndAnswerVo.analysis
                      "
                    />
                  </a-space>
                </a-space>
              </a-card>
            </a-col>
            <a-col :span="7">
              <a-card>
                <a-space direction="horizontal" fill size="50px">
                  <a-statistic
                    title="正确率"
                    align="center"
                    :value="
                      toPercent(
                        (qu.book.wrongCount / qu.answerCount).toFixed(2)
                      )
                    "
                    :value-style="{ color: '#0fbf60' }"
                    show-group-separator
                  >
                    <template #suffix> % </template>
                  </a-statistic>
                  <a-statistic
                    title="总答题次数"
                    align="center"
                    :value="qu.answerCount"
                    :value-style="{ color: '#0fbf60' }"
                    show-group-separator
                  />
                  <a-statistic
                    title="答对次数"
                    align="center"
                    :value="qu.answerCount - qu.book.wrongCount"
                    :value-style="{ color: '#168cff' }"
                    show-group-separator
                  />
                  <a-statistic
                    title="答错次数"
                    align="center"
                    :value="qu.book.wrongCount"
                    :value-style="{ color: '#f53f3f' }"
                    show-group-separator
                  />
                </a-space>
              </a-card>
              <!--选项占比部分(非简答、填空)-->
              <template
                v-if="
                  qu.quAndAnswerVo.quType !== QuestionType.SHORTANSWER &&
                  qu.quAndAnswerVo.quType !== QuestionType.GAPFILLING
                "
              >
                <a-card>
                  <a-typography-title :heading="6" style="display: block">
                    答错占比
                    <a-tag>{{ getQuestionTypeName(qu.book.quType) }}</a-tag>
                  </a-typography-title>
                  <template
                    v-for="(value, key) in qu.wrongAnswerCount"
                    :key="key"
                  >
                    <span style="display: inline-block">{{ key }}</span>
                    <a-progress
                      track-color="var(--color-primary-light-1)"
                      style="margin-bottom: 20px"
                      :percent="wrongAnswer(value, qu.answerCount)"
                    />
                  </template>
                </a-card>
              </template>
            </a-col>
          </a-row>
          <!--分割线-->
          <a-divider :size="2" style="border-bottom-style: dotted" />
        </a-card>
      </template>
    </a-scrollbar>
  </a-spin>
</template>

<script setup lang="ts">
  import { QuestionType } from '@/types/model/QuestionType';
  import BookMark from '@/components/bookMark/index.vue';
  import { getQuestionTypeName } from '../../../utils/common';

  const props = defineProps({
    allQuestion: {
      type: Array,
    },
    loading: {},
  });

  const emit = defineEmits(['reload', 'asce', 'desc']);

  // 正确率升序排列
  const asceSort = () => {
    emit('asce');
  };

  // 正确率降序排列
  const descSort = () => {
    emit('desc');
  };
  // 重置排列
  const resetSort = () => {
    emit('reload');
  };

  // 正确率计算
  const toPercent = (point: any) => {
    const result = Number(point * 100).toFixed(1);
    return Number(result);
  };

  // 选项占比计算
  const wrongAnswer = (num1: any, num2: any) => {
    const result = (num1 / num2).toFixed(2);
    return Number(result);
  };
</script>

<style scoped></style>
