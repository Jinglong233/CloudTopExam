<template>
  <div class="container">
    <Breadcrumb :items="['menu.exam.preview']" />
    <a-row class="grid-demo" justify="space-between" :gutter="5">
      <!--左侧题目总数展示-->
      <a-col :span="5">
        <a-affix :offset-top="80">
          <a-card hoverable style="margin-left: 20px">
            <a-scrollbar type="track" style="height: 680px; overflow: auto">
              <template
                v-for="(groupList, index) in paper.groupLists"
                :key="index"
              >
                <!--大题标题-->
                <a-typography-title
                  type="primary"
                  :heading="6"
                  style="padding: 10px 0px"
                >
                  {{ groupList.title }}
                </a-typography-title>
                <a-divider :margin="0" />
                <a-space>
                  共
                  <a-typography-text type="primary">
                    {{ groupList.quCount }}
                  </a-typography-text>
                  题,共
                  <a-typography-text type="primary">
                    {{ groupList.totalScore }}
                  </a-typography-text>
                  分
                </a-space>
                <div />
                <a-space style="margin: 10px 0px" :wrap="true">
                  <a-button
                    v-for="qu in groupList.quList"
                    :key="qu.id"
                    type="primary"
                  >
                    {{ qu.sort }}
                  </a-button>
                </a-space>
              </template>
              <div style="margin-top: 20px" />
            </a-scrollbar>
          </a-card>
        </a-affix>
      </a-col>

      <!--问题预览部分-->
      <a-col :span="15">
        <a-card
          v-for="(groupList, outIndex) in paper.groupLists"
          :key="outIndex"
          class="general-card"
          style="margin-bottom: 20px"
        >
          <!--问题部分-->
          <template #title>
            {{ groupList.title }}
          </template>
          <!--题目展示部分-->
          <a-card
            v-for="(qu, index) in groupList.quList"
            :key="index"
            :bordered="false"
          >
            <!--问题部分-->
            <a-space>
              <BookMark :number="qu.sort" />
              <v-md-preview-html
                :html="qu.content"
                preview-class="vuepress-markdown-body"
              ></v-md-preview-html>
            </a-space>

            <a-row :gutter="10">
              <a-col :span="17">
                <!--选项部分-->
                <a-card
                  v-for="(quAnswer, index) in qu.quAnswerList"
                  :key="index"
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
                      <a-typography-text type="primary">
                        {{ quAnswer.tag }}
                      </a-typography-text>
                      <a-typography-text>
                        <v-md-preview-html
                          :html="quAnswer.content"
                          preview-class="vuepress-markdown-body"
                        ></v-md-preview-html>
                      </a-typography-text>
                    </a-space>
                    <a-space v-if="quAnswer.isRight === 1">
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
                <a-card style="background-color: #fcfcfc">
                  答案解析：
                  <v-md-preview-html
                    :html="qu.analysis"
                    preview-class="vuepress-markdown-body"
                  ></v-md-preview-html>
                </a-card>
              </a-col>
              <a-col :span="7">
                <a-card :style="{ textAlign: 'center' }">
                  <a-space direction="vertical" fill>
                    <!--得分部分-->
                    <a-space align="center">
                      <a-typography-text>本题</a-typography-text>
                      <a-typography-text type="secondary">{{
                        qu.score
                      }}</a-typography-text>
                      <a-typography-text>分</a-typography-text>
                    </a-space>
                  </a-space>
                </a-card>
              </a-col>
            </a-row>
            <!--分割线-->
            <a-divider :size="2" style="border-bottom-style: dotted" />
          </a-card>
        </a-card>
      </a-col>

      <!--右侧批阅展示-->
      <a-col :span="4">
        <a-affix :offset-top="80">
          <a-card style="text-align: center">
            <a-scrollbar type="track" style="height: 680px; overflow: auto">
              <a-space direction="vertical" fill>
                <a-typography-title :heading="6">试卷标题</a-typography-title>
                <a-typography-text>{{ paper.title }}</a-typography-text>
                <a-divider />
                <a-typography-title :heading="6">试卷总分</a-typography-title>
                <a-typography-text>{{ paper.totalCount }}</a-typography-text>
                <a-divider />
                <a-typography-title :heading="6">试题数量</a-typography-title>
                <a-typography-text>{{ paper.quCount }}</a-typography-text>
                <a-divider />
              </a-space>
              <div style="margin-top: 20px" />
            </a-scrollbar>
          </a-card>
        </a-affix>
      </a-col>
    </a-row>
  </div>
</template>

<script lang="ts" setup>
  import { onMounted, ref } from 'vue';
  import { useRoute, useRouter } from 'vue-router';
  import BookMark from '@/components/bookMark/index.vue';
  import { getPaperDetail } from '@/api/paper';
  import { PaperAndQuVO } from '@/types/model/vo/PaperAndQuVO';

  // todo wangEditor的预览展示
  import MyEditor from '@/components/my-editor/index.vue';

  // eslint-disable-next-line import/extensions

  const paper = ref<PaperAndQuVO>({});
  // 控制编辑器显示时机，因为编辑器内容需要父组件传递
  const isShowEditor = ref<boolean>(false);
  const router = useRouter();
  const route = useRoute();
  onMounted(async () => {
    const paperId = route.query.id;
    if (!paperId) {
      router.back();
    }
    await getPaperDetail(route.query.id as string).then((res: any) => {
      paper.value = res.data;
      isShowEditor.value = true;
    });
  });
</script>

<style scoped></style>
