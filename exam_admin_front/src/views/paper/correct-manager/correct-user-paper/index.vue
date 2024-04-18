<template>
  <div class="container">
    <Breadcrumb :items="['menu.exam.answerDetail']" />
    <a-row class="grid-demo" justify="space-between" :gutter="12">
      <!--左侧题目总数展示（看所有题）-->
      <template v-if="!subView">
        <a-col :span="5">
          <VerticalNav :title="exam.title">
            <template
              v-for="(groupList, index) in paper.groupLists"
              :key="index"
            >
              <a-row :gutter="10">
                <a-col :span="8">{{ groupList.title }}</a-col>
                <a-col :span="16"
                  >共{{ groupList.quCount }}题 / 共{{
                    groupList.totalScore
                  }}分</a-col
                >
              </a-row>
              <a-row :gutter="50">
                <a-col
                  v-for="qu in groupList.quList"
                  :key="qu.id"
                  style="margin-top: 10px"
                  :span="4"
                >
                  <LeftNavButton :anchor-id="qu.id" :qu-sort="qu.sort" />
                </a-col>
              </a-row>
            </template>
          </VerticalNav>
        </a-col>
      </template>
      <!--左侧题目总数展示（只看主观题）-->
      <template v-else>
        <a-col :span="5">
          <VerticalNav :title="exam.title">
            <template
              v-for="(groupList, index) in paper.groupLists"
              :key="index"
            >
              <template v-if="groupList.quType === QuestionType.SHORTANSWER">
                <a-row :gutter="10">
                  <a-col :span="8">{{ groupList.title }}</a-col>
                  <a-col :span="16"
                    >共{{ groupList.quCount }}题 / 共{{
                      groupList.totalScore
                    }}分</a-col
                  >
                </a-row>
                <a-row :gutter="50">
                  <a-col
                    v-for="qu in groupList.quList"
                    :key="qu.id"
                    style="margin-top: 10px"
                    :span="4"
                  >
                    <LeftNavButton :qu-sort="qu.sort" :anchor-id="qu.id" />
                  </a-col>
                </a-row>
              </template>
            </template>
          </VerticalNav>
        </a-col>
      </template>

      <!--问题预览部分（看所有题）-->
      <template v-if="!subView">
        <a-col :span="15">
          <template v-for="(qu, outIndex) in allQuestion" :key="outIndex">
            <a-card class="general-card">
              <!--问题部分-->
              <template #title>
                <a-space>
                  <span>
                    <BookMark :number="outIndex + 1" :anchor-id="qu.id" />
                  </span>
                  <div v-html="qu.content" />
                </a-space>
              </template>
              <a-row :gutter="10">
                <a-col :span="17">
                  <!--选项部分(非简答)-->
                  <template v-if="qu.quType !== QuestionType.SHORTANSWER">
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
                          <a-typography-text
                            v-if="
                              qu.quType !== QuestionType.JUDGING &&
                              qu.quType !== QuestionType.GAPFILLING
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

                  <!--解析-->
                  <a-card :style="{ backgroundColor: '#fcfcfc' }">
                    <a-space direction="vertical" fill>
                      <a-space align="center">
                        <template
                          v-if="getUserAnswerByQuId(qu.id).isRight === 1"
                        >
                          <a-button
                            type="primary"
                            status="success"
                            shape="circle"
                          >
                            <icon-check />
                          </a-button>
                          <a-typography-text bold> 答对了 </a-typography-text>
                        </template>
                        <template
                          v-if="getUserAnswerByQuId(qu.id).isRight === 0"
                        >
                          <a-button
                            type="primary"
                            status="danger"
                            shape="circle"
                          >
                            <icon-close />
                          </a-button>
                          <a-typography-text bold> 答错了 </a-typography-text>
                        </template>
                      </a-space>
                      <a-space>
                        <a-typography-text
                          >学员得分：{{
                            getUserAnswerByQuId(qu.id).score
                          }}</a-typography-text
                        >
                      </a-space>
                      <a-space>
                        <a-typography-text>学员答案：</a-typography-text>
                        <!--分为简答题、填空题 | 判断题 |其他-->
                        <!--简答题、填空题-->
                        <div
                          v-if="
                            qu.quType === QuestionType.SHORTANSWER ||
                            qu.quType === QuestionType.GAPFILLING
                          "
                          v-html="getUserAnswerByQuId(qu.id).answer"
                        />
                        <!--选择题-->
                        <div
                          v-if="
                            qu.quType === QuestionType.SINGLECHOICE ||
                            qu.quType === QuestionType.MULTIPLECHOICE
                          "
                        >
                          <template
                            v-for="(answerId, index) in parsedAnswerIds(qu)"
                            :key="index"
                          >
                            {{ getAnswerTagById(answerId) }}&emsp;
                          </template>
                        </div>
                        <!--判断题-->
                        <div v-if="qu.quType === QuestionType.JUDGING">
                          <template
                            v-if="getUserAnswerByQuId(qu.id).isRight === 1"
                          >
                            正确
                          </template>
                          <template v-else> 错误 </template>
                        </div>
                      </a-space>
                      <a-space>
                        <a-typography-text>答案解析：</a-typography-text>
                        <div
                          v-html="
                            qu.analysis === null || '' ? '无' : qu.analysis
                          "
                        />
                      </a-space>
                    </a-space>
                  </a-card>
                </a-col>
                <a-col :span="7">
                  <a-card>
                    <a-space direction="vertical" fill size="50px">
                      <a-space align="center">
                        <a-typography-text>判题：</a-typography-text>
                        <a-button
                          :status="
                            getUserAnswerByQuId(qu.id).isRight === 1 ||
                            getUserAnswerByQuId(qu.id).score > 0
                              ? 'success'
                              : 'normal'
                          "
                          shape="circle"
                          @click="judgeCorrectly(qu.id, qu.score)"
                        >
                          <icon-check />
                        </a-button>
                        <a-button
                          :status="
                            getUserAnswerByQuId(qu.id).isRight === 0
                              ? 'danger'
                              : 'normal'
                          "
                          shape="circle"
                          @click="judgeError(qu.id)"
                        >
                          <icon-close />
                        </a-button>
                      </a-space>
                      <!--得分部分-->
                      <a-space align="center">
                        <a-typography-text>得分：</a-typography-text>
                        <a-input-number
                          v-model="getUserAnswerByQuId(qu.id).score"
                          :max="qu.score"
                          :style="{ width: '100px' }"
                          :min="0"
                          mode="button"
                          :precision="1"
                          size="larger"
                          @change="scoreChange(qu.id, $event)"
                        />
                      </a-space>
                      <!--总分部分-->
                      <a-space align="center">
                        <a-typography-text>总分：</a-typography-text>
                        <a-typography-text>{{ qu.score }}</a-typography-text>
                      </a-space>
                    </a-space>
                  </a-card>
                </a-col>
              </a-row>
              <!--分割线-->
              <a-divider :size="2" style="border-bottom-style: dotted" />
            </a-card>
          </template>
        </a-col>
      </template>
      <!--问题预览部分（只看主观题）-->
      <template v-else>
        <a-col :span="15">
          <template v-for="(qu, outIndex) in allQuestion" :key="outIndex">
            <a-card
              v-if="qu.quType === QuestionType.SHORTANSWER"
              class="general-card"
            >
              <!--锚点位置-->
              <div :id="`单选${outIndex + 1}`" class="cli"></div>
              <!--问题部分-->
              <template #title>
                <a-space>
                  <span>
                    <BookMark :number="outIndex + 1" />
                  </span>
                  <div v-html="qu.content" />
                </a-space>
              </template>
              <a-row :gutter="10">
                <a-col :span="17">
                  <!--选项部分(非简答)-->
                  <template v-if="qu.quType !== QuestionType.SHORTANSWER">
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
                          <a-typography-text
                            v-if="
                              qu.quType !== QuestionType.JUDGING &&
                              qu.quType !== QuestionType.GAPFILLING
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

                  <!--解析-->
                  <a-card :style="{ backgroundColor: '#fcfcfc' }">
                    <a-space direction="vertical" fill>
                      <a-space align="center">
                        <template
                          v-if="getUserAnswerByQuId(qu.id).isRight === 1"
                        >
                          <a-button
                            type="primary"
                            status="success"
                            shape="circle"
                          >
                            <icon-check />
                          </a-button>
                          <a-typography-text bold> 答对了 </a-typography-text>
                        </template>
                        <template
                          v-if="getUserAnswerByQuId(qu.id).isRight === 0"
                        >
                          <a-button
                            type="primary"
                            status="danger"
                            shape="circle"
                          >
                            <icon-close />
                          </a-button>
                          <a-typography-text bold> 答错了 </a-typography-text>
                        </template>
                      </a-space>
                      <a-space>
                        <a-typography-text
                          >学员得分：{{
                            getUserAnswerByQuId(qu.id).score
                          }}</a-typography-text
                        >
                      </a-space>
                      <a-space>
                        <a-typography-text>学员答案：</a-typography-text>
                        <!--分为简答题、填空题 | 判断题 |其他-->
                        <!--简答题、填空题-->
                        <div
                          v-if="
                            qu.quType === QuestionType.SHORTANSWER ||
                            qu.quType === QuestionType.GAPFILLING
                          "
                          v-html="getUserAnswerByQuId(qu.id).answer"
                        />
                        <!--选择题-->
                        <div
                          v-if="
                            qu.quType === QuestionType.SINGLECHOICE ||
                            qu.quType === QuestionType.MULTIPLECHOICE
                          "
                        >
                          <template
                            v-for="(answerId, index) in parsedAnswerIds(qu)"
                            :key="index"
                          >
                            {{ getAnswerTagById(answerId) }}&emsp;
                          </template>
                        </div>
                        <!--判断题-->
                        <div v-if="qu.quType === QuestionType.JUDGING">
                          <template
                            v-if="getUserAnswerByQuId(qu.id).isRight === 1"
                          >
                            正确
                          </template>
                          <template v-else> 错误 </template>
                        </div>
                      </a-space>

                      <a-space>
                        <a-typography-text>答案解析：</a-typography-text>
                        <div
                          v-html="
                            qu.analysis === null || '' ? '无' : qu.analysis
                          "
                        />
                      </a-space>
                    </a-space>
                  </a-card>
                </a-col>
                <a-col :span="7">
                  <a-card>
                    <a-space direction="vertical" fill size="50px">
                      <a-space align="center">
                        <a-typography-text>判题：</a-typography-text>
                        <a-button
                          :status="
                            getUserAnswerByQuId(qu.id).isRight === 1 ||
                            getUserAnswerByQuId(qu.id).score > 0
                              ? 'success'
                              : 'normal'
                          "
                          shape="circle"
                          @click="judgeCorrectly(qu.id, qu.score)"
                        >
                          <icon-check />
                        </a-button>
                        <a-button
                          :status="
                            getUserAnswerByQuId(qu.id).isRight === 0
                              ? 'danger'
                              : 'normal'
                          "
                          shape="circle"
                          @click="judgeError(qu.id)"
                        >
                          <icon-close />
                        </a-button>
                      </a-space>
                      <!--得分部分-->
                      <a-space align="center">
                        <a-typography-text>得分：</a-typography-text>
                        <a-input-number
                          v-model="getUserAnswerByQuId(qu.id).score"
                          :max="qu.score"
                          :style="{ width: '100px' }"
                          :min="0"
                          mode="button"
                          :precision="1"
                          size="larger"
                          @change="scoreChange(qu.id, $event)"
                        />
                      </a-space>
                      <!--总分部分-->
                      <a-space align="center">
                        <a-typography-text>总分：</a-typography-text>
                        <a-typography-text>{{ qu.score }}</a-typography-text>
                      </a-space>
                    </a-space>
                  </a-card>
                </a-col>
              </a-row>
              <!--分割线-->
              <a-divider :size="2" style="border-bottom-style: dotted" />
            </a-card>
          </template>
        </a-col>
      </template>

      <!--右侧批阅展示-->
      <a-col :span="4">
        <VerticalNav style="text-align: center">
          <a-space direction="vertical" fill>
            <a-typography-title :heading="6">人员姓名</a-typography-title>
            <a-typography-text>张三</a-typography-text>
            <a-divider />
            <a-typography-title :heading="6">考试成绩</a-typography-title>
            <a-typography-text>{{
              examRecordInfo.totalScore
            }}</a-typography-text>
            <a-divider />
            <a-divider />
            <a-typography-title :heading="6">仅看主观题</a-typography-title>
            <a-switch v-model="subView" @change="subViewSwitch" />
            <a-divider />
            <a-button type="primary" @click="submitCorrect">提交阅卷</a-button>
          </a-space>
        </VerticalNav>
      </a-col>
    </a-row>
  </div>
</template>

<script lang="ts" setup>
  import { IconCheckCircleFill } from '@arco-design/web-vue/es/icon';
  import BookMark from '@/components/bookMark/index.vue';
  import { onMounted, ref } from 'vue';

  import { useRoute, useRouter } from 'vue-router';
  import { PaperAndQuVO } from '@/types/model/vo/PaperAndQuVO';
  import { UserAnswer } from '@/types/model/po/UserAnswer';
  import { getExamRecord, updateExamRecord } from '@/api/examRecord';
  import { ExamRecord } from '@/types/model/po/ExamRecord';
  import { getExamById } from '@/api/exam';
  import { ExamVO } from '@/types/model/vo/ExamVO';
  import { getPaperDetail } from '@/api/paper';
  import { QuestionType } from '@/types/model/QuestionType';
  import { getUserAnswerList, updateUserAnswerList } from '@/api/userAnswer';
  import { Qu } from '@/types/model/po/Qu';
  import { Message } from '@arco-design/web-vue';
  import { ExamRecordQuery } from '@/types/model/query/ExamRecordQuery';
  import VerticalNav from '@/components/verticalNav/index.vue';
  import LeftNavButton from '@/components/leftNavButton/index.vue';

  const route = useRoute();
  const router = useRouter();

  const exam = ref<ExamVO>({});
  const paper = ref<PaperAndQuVO>({});
  const examRecordInfo = ref<ExamRecord>({});
  const userAnswerList = ref<UserAnswer[]>([]);
  const allQuestion = ref<Qu[]>([]);

  // 仅看主观题开关
  const subView = ref<boolean>(false);

  onMounted(async () => {
    // 获取试卷信息
    const examRecordId = route.params.examRecordId as string;
    if (!examRecordId) {
      router.back();
    }

    // 获取考试记录
    await getExamRecord({
      id: examRecordId,
    } as ExamRecordQuery).then((res: any) => {
      examRecordInfo.value = res.data[0] as ExamRecord;
    });

    // 获取该场考试信息
    const examId = examRecordInfo.value?.examId as string;

    await getExamById(examId).then((res: any) => {
      exam.value = res.data;
    });
    if (!exam.value.paperId) {
      router.back();
    }

    const paperId = exam.value.paperId as string;
    // 获取试卷信息
    await getPaperDetail(paperId).then((res: any) => {
      paper.value = res.data;

      // 抽取所有问题列表
      if (res.data) {
        allQuestion.value = res.data.groupLists
          .map((obj: any) => obj.quList)
          .flat(2);
      }
    });

    // 获取用户作答记录
    await getUserAnswerList({
      userId: examRecordInfo.value.userId,
      examRecordId,
    }).then((res: any) => {
      userAnswerList.value = res.data;
    });
  });

  // 更新所有信息
  const updateAllInitInfo = async () => {
    // 获取用户作答记录
    await getUserAnswerList({
      userId: examRecordInfo.value.userId,
      examRecordId: examRecordInfo.value.id,
    }).then((r: any) => {
      userAnswerList.value = r.data;
    });

    // 获取考试信息
    await getExamById(exam.value.id as string).then((res: any) => {
      exam.value = res.data;
    });

    // 获取考试记录信息
    await getExamRecord({
      id: examRecordInfo.value.id,
    } as ExamRecordQuery).then((res: any) => {
      examRecordInfo.value = res.data[0] as ExamRecord;
    });
  };

  // 判断当前显示题目是否是侧边对应的题号
  const isNowNumber = (id: string) => {
    return true;
  };

  // 获取题目对应的用户作答详情
  // eslint-disable-next-line no-undef
  const getUserAnswerByQuId = (quId: string): UserAnswer => {
    // @ts-ignore
    // eslint-disable-next-line no-restricted-syntax
    for (const userAnswer of userAnswerList.value) {
      const id = userAnswer.quId as string;
      if (id === quId) {
        return userAnswer;
      }
    }
    return {};
  };

  // 判对
  const judgeCorrectly = async (quId: string, quScore: number) => {
    const userAnswer = getUserAnswerByQuId(quId);
    userAnswer.score = quScore;
    userAnswer.isRight = 1;
    // 更新该条记录
    await updateUserAnswerList({ userAnswer }).then(async (res: any) => {
      if (res.data === false) {
        Message.error({
          id: 'updateError1',
          content: '更新失败',
          duration: 2000,
        });
      } else {
        await updateAllInitInfo();
      }
    });
  };

  // 判错
  const judgeError = async (quId: string) => {
    const userAnswer = getUserAnswerByQuId(quId);
    userAnswer.score = 0;
    userAnswer.isRight = 0;
    // 更新该条记录
    await updateUserAnswerList({ userAnswer }).then(async (res: any) => {
      if (res.data === false) {
        Message.error({
          id: 'updateError2',
          content: '更新失败',
          duration: 2000,
        });
      } else {
        await updateAllInitInfo();
      }
    });
  };

  // 手动给分
  const scoreChange = async (quId: string, quScore: number) => {
    const userAnswer = getUserAnswerByQuId(quId);
    userAnswer.score = quScore;
    if (quScore > 0) {
      userAnswer.isRight = 1;
    } else {
      userAnswer.isRight = 0;
    }
    // 更新该条记录
    await updateUserAnswerList({ userAnswer }).then(async (res: any) => {
      if (res.data === false) {
        Message.error({
          id: 'updateError1',
          content: '更新失败',
          duration: 2000,
        });
      } else {
        await updateAllInitInfo();
      }
    });
  };

  // 获取选项对应的tag
  const getAnswerTagById = (answerId: string) => {
    let result = '';
    allQuestion.value.forEach((qu: any) => {
      if (
        qu.quType === QuestionType.SINGLECHOICE ||
        qu.quType === QuestionType.MULTIPLECHOICE
      ) {
        qu.quAnswerList.forEach((answer: any) => {
          if (answerId === answer.id) {
            result = answer.tag;
          }
        });
      }
    });
    return result;
  };

  // 获取解析后的 answerId 列表
  const parsedAnswerIds = (qu: Qu) => {
    const userAnswer = getUserAnswerByQuId(qu.id as string);
    if (userAnswer && userAnswer.answerId) {
      try {
        return JSON.parse(userAnswer.answerId);
      } catch (error) {
        console.error('Error parsing JSON:', error);
        return [];
      }
    } else {
      return [];
    }
  };

  // 提交阅卷
  const submitCorrect = async () => {
    examRecordInfo.value.handState = 1;
    await updateExamRecord({
      id: examRecordInfo.value.id,
      examRecord: examRecordInfo.value,
    }).then((res: any) => {
      if (res.data === true) {
        Message.success({
          content: '阅卷完成',
          duration: 2000,
        });
        router.push({
          name: 'CorrectUserExam',
          params: {
            examId: exam.value.id,
          },
        });
      } else {
        Message.error({
          content: '提交失败',
          duration: 2000,
        });
      }
    });
  };
</script>

<style scoped></style>
