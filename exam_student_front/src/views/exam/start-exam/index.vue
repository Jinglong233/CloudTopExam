<template>
  <a-row>
    <a-col :span="4" style="margin-top: 20px">
      <a-card style="height: 720px; margin-left: 20px" :title="exam.title">
        <template v-for="(groupList, index) in paper.groupLists" :key="index">
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
              <a-button
                :type="isNowNumber(qu.id) ? 'primary' : 'outline'"
                @click="jumpQuestion(qu.id)"
                >{{ qu.sort }}</a-button
              >
            </a-col>
          </a-row>
        </template>
      </a-card>
    </a-col>
    <a-col :span="16" style="margin-top: 20px">
      <a-scrollbar type="track" style="height: 720px; overflow: auto">
        <!--展示全部问题-->
        <!-- <a-card
          v-for="(groupList, outIndex) in paper.groupLists"
          :key="outIndex"
          class="general-card"
          style="margin-left: 20px"
        >
          &lt;!&ndash;问题部分&ndash;&gt;
          <template #title>
            {{ groupList.title }}
          </template>
          &lt;!&ndash;题目展示部分&ndash;&gt;
          <a-card
            v-for="(qu, index) in groupList.quList"
            :key="index"
            :bordered="false"
          >
            &lt;!&ndash;问题部分&ndash;&gt;
            <a-row :gutter="20">
              <a-col :span="2">
                <BookMark :number="qu.sort" />
              </a-col>
              <a-col :span="17">
                <div v-html="qu.content" />
              </a-col>
              <a-col :span="5">
                <a-typography-text
                  style="float: right; height: 45px; line-height: 45px"
                  type="primary"
                >
                  本题{{ qu.score }}分
                </a-typography-text>
              </a-col>
            </a-row>
            &lt;!&ndash;选项部分&ndash;&gt;
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
                    <div v-html="quAnswer.content" />
                  </a-typography-text>
                </a-space>
              </div>
            </a-card>
            &lt;!&ndash;分割线&ndash;&gt;
            <a-divider :size="2" style="border-bottom-style: dotted" />
          </a-card>
        </a-card>-->

        <ShowQuestion
          :now-question="nowQuestion"
          :now-user-qu-answer="nowUserQuAnswer"
          @get-answer-id="answerQuestion"
        />
      </a-scrollbar>
    </a-col>
    <a-col :span="4" style="margin-top: 20px">
      <a-card style="height: 720px; margin-right: 20px; text-align: center">
        <a-typography-title :heading="6"> 剩余时间 </a-typography-title>
        <a-countdown
          :value="Date.now() + compTimeDiff()"
          :now="Date.now()"
          :start="true"
        />
        <a-divider />
        <a-button type="primary" @click="submitExam">提交试卷</a-button>
        <a-divider />
        <a-space direction="vertical">
          <a-button
            type="primary"
            :disabled="nowQuestionIndex === 0"
            @click="skipPreProblem"
          >
            <template #icon>
              <icon-arrow-left />
            </template>
            上一题
          </a-button>
          <a-button
            type="primary"
            :disabled="nowQuestionIndex === allQuestion.length - 1"
            @click="skipNextProblem"
          >
            <template #icon>
              <icon-arrow-right />
            </template>
            下一题
          </a-button>
        </a-space>
      </a-card>
    </a-col>
  </a-row>
</template>

<script lang="ts" setup>
  import { onBeforeUnmount, onMounted, ref } from 'vue';
  import { useAppStore, useUserStore } from '@/store';
  import { Message, Modal } from '@arco-design/web-vue';
  import { useRoute, useRouter } from 'vue-router';
  import { getExamById, submitMyExam } from '@/api/exam';
  import { ExamVO } from '@/types/model/vo/ExamVO';
  import { PaperAndQuVO } from '@/types/model/vo/PaperAndQuVO';
  import { getPaperDetail } from '@/api/paper';
  import { getExamRecord, startAnswer } from '@/api/examRecord';
  import ShowQuestion from '@/components/showQuestion/index.vue';
  import dayjs from 'dayjs';
  import duration from 'dayjs/plugin/duration';
  import { ExamRecord } from '@/types/model/po/ExamRecord';
  import {
    addBatchStudentAnswer,
    updateStudentAnswer,
  } from '@/api/studentAnswer';
  import { UserAnswer } from '@/types/model/po/UserAnswer';
  import { Qu } from '@/types/model/po/Qu';
  import { QuestionType } from '@/types/model/QuestionType';
  import { GroupList } from '@/types/model/po/GroupList';

  dayjs.extend(duration);

  const appStore = useAppStore();

  const userStore = useUserStore();

  const router = useRouter();
  const route = useRoute();

  const startTime = ref();

  // stopDebug(router);

  const exam = ref<ExamVO>({});
  const paper = ref<PaperAndQuVO>({});
  const examRecordInfo = ref();
  const userAnswerList = ref<UserAnswer[]>([]);

  // 当前题目
  const nowQuestion = ref<Qu>({ id: '' });
  // 当前题目的索引
  const nowQuestionIndex = ref(0);

  // 所有问题的数组
  const allQuestion = ref<Qu[]>([]);

  // 所有答题分组的数组
  const allGroupList = ref<GroupList[]>([]);

  // 当前问题所对应的用户的答案
  const nowUserQuAnswer = ref<UserAnswer>();

  // 当前这个答案用户所选的答案列表
  const getNowUserQuAnswer = () => {
    return userAnswerList.value.find((userAnswer) => {
      if ((nowQuestion.value.id as string) === userAnswer.quId) {
        return true;
      }
      return false;
    });
  };

  // 根据问题查找其对应的glId
  const getGlIdByQu = (quId: string): any => {
    let id = null;
    allGroupList.value.forEach((groupList: any) => {
      groupList.quList.forEach((qu: any) => {
        if (quId === qu.id) {
          id = groupList.id;
        }
      });
    });
    return id;
  };

  // 答题
  const answerQuestion = async (userAnswer: any) => {
    await updateStudentAnswer({
      userAnswer,
      glId: getGlIdByQu(userAnswer.quId) as string,
    }).then((res: any) => {
      if (res.data !== null && res.data.length !== 0) {
        // 更新成功，重新获取用户答案列表
        userAnswerList.value = res.data;
        // 更新当前问题的答案列表
        nowUserQuAnswer.value = getNowUserQuAnswer();
      } else {
        Message.error({
          id: 'updateUserAnswerError',
          content: res.info,
          duration: 2000,
        });
      }
    });
  };

  onMounted(async () => {
    // 隐藏导航栏
    appStore.updateSettings({
      navbar: false,
    });
    // 获取试卷信息+用户开始记录
    const examId = route.params.examId as string;
    if (!examId) {
      router.back();
    }
    await getExamById(examId).then((res: any) => {
      exam.value = res.data;
    });
    if (!exam.value.paperId) {
      router.back();
    }

    await getExamRecord({
      userId: userStore.id,
      examId,
    }).then((res: any) => {
      examRecordInfo.value = res.data[0] as ExamRecord;
    });
    if (examRecordInfo.value.state === 2) {
      // 已提交就到结果回显页面
      router.push({
        name: 'ExamResult',
        params: { examRecordId: examRecordInfo.value.id },
      });
    }

    // 在此处修改该用户该考试记录的相关信息
    await startAnswer({ userId: userStore.id, examId: examId as string }).then(
      (res: any) => {
        if (res.data !== undefined) {
          Message.success({
            id: 'startAnswer',
            content: res.info,
            duration: 2000,
          });
          startTime.value = res.data;
        } else {
          Message.error({
            id: 'startAnswer1',
            content: res.info,
            duration: 2000,
          });
        }
      }
    );

    const paperId = exam.value.paperId as string;
    // 获取试卷信息
    await getPaperDetail(paperId).then((res: any) => {
      paper.value = res.data;

      if (res.data) {
        allGroupList.value = res.data.groupLists;
        allQuestion.value = res.data.groupLists
          .map((obj: any) => obj.quList)
          .flat(2);
      }
      // 默认当前题目为第一个
      nowQuestion.value = allQuestion.value[0] as any;
    });

    // 创建该用户的所有题目答题记录
    await addBatchStudentAnswer({
      paperAndQuVO: paper.value as PaperAndQuVO,
      examRecordId: examRecordInfo.value.id as string,
      userId: userStore.id,
    }).then((res: any) => {
      if (res.data === null || res.data.length === 0) {
        Message.error({
          id: 'answerAddError',
          content: '考试初始化失败,请联系管理员',
          duration: 2000,
        });
      } else {
        userAnswerList.value = res.data;
        // 同时获取当前问题的用户答案列表
        nowUserQuAnswer.value = getNowUserQuAnswer();
      }
    });
  });

  onBeforeUnmount(() => {
    // 显示导航栏
    appStore.updateSettings({
      navbar: true,
    });
  });

  // 计算时差
  const compTimeDiff = () => {
    return dayjs(exam.value.endTime).diff(Date.now());
  };

  // 跳转下一题
  const skipNextProblem = () => {
    if (nowQuestionIndex.value + 1 < allQuestion.value.length) {
      nowQuestionIndex.value += 1;
      nowQuestion.value = allQuestion.value[nowQuestionIndex.value];
      // 同时修改当前题目的用户答案列表
      nowUserQuAnswer.value = getNowUserQuAnswer();
    }
  };

  // 跳转上一题
  const skipPreProblem = () => {
    if (nowQuestionIndex.value - 1 >= 0) {
      nowQuestionIndex.value -= 1;
      nowQuestion.value = allQuestion.value[nowQuestionIndex.value];
      // 同时修改当前题目的用户答案列表
      nowUserQuAnswer.value = getNowUserQuAnswer();
    }
  };

  // 跳转对应题目
  const jumpQuestion = (id: string) => {
    // eslint-disable-next-line no-plusplus
    for (let i = 0; i < allQuestion.value.length; i++) {
      const temp = allQuestion.value[i] as any;
      if (temp.id === id) {
        nowQuestion.value = allQuestion.value[i];
        nowQuestionIndex.value = i;
        // 同时修改当前题目的用户答案列表
        nowUserQuAnswer.value = getNowUserQuAnswer();
      }
    }
  };

  // 判断当前显示题目是否是侧边对应的题号
  const isNowNumber = (id: string) => {
    const temp = nowQuestion.value as any;
    return id === temp.id;
  };

  const showSubmitModal = (showContext: string) => {
    Modal.info({
      title: '提交确认',
      content: showContext,
      okText: '确认提交',
      cancelText: '取消',
      hideCancel: false,
      closable: true,
      onOk: async () => {
        await submitMyExam({
          examRecordId: examRecordInfo.value.id,
          quList: allQuestion.value as Qu[],
        }).then((res: any) => {
          if (res.data === true) {
            Message.success({
              id: 'submitSuccessInfo',
              content: '提交成功',
              duration: 2000,
            });
          } else {
            Message.success({
              id: 'submitErrorInfo',
              content: res.info,
              duration: 2000,
            });
          }
        });
        // 提交成功前往考试结果页面

        router.push({
          name: 'ExamResult',
          params: { examRecordId: examRecordInfo.value.id },
        });
      },
      onCancel: () => {
        console.log('取消提交');
      },
    });
  };

  // 根据问题Id，获取问题的类型
  const getQuTypeByQuId = (quId: string) => {
    // eslint-disable-next-line no-restricted-syntax
    for (const qu of allQuestion.value) {
      if (qu.id === quId) {
        return qu.quType;
      }
    }
    return '';
  };
  // 提交考试
  const submitExam = () => {
    let flag = false;
    // 首先判断是否有题目未作答完
    userAnswerList?.value.forEach((userAnswer: UserAnswer) => {
      const quType = getQuTypeByQuId(userAnswer.quId as string);
      // 如果是非简答题和非填空题则遍历answerId
      if (
        quType !== QuestionType.SHORTANSWER &&
        quType !== QuestionType.GAPFILLING
      ) {
        const answerIdArray = Object.values(
          JSON.parse(userAnswer.answerId as string)
        );
        if (answerIdArray.length === 0) {
          flag = true;
        }
      } else {
        // 简答题和填空题判断answer
        // eslint-disable-next-line no-lonely-if
        if (
          userAnswer.answer === undefined ||
          userAnswer.answer?.trim() === ''
        ) {
          flag = true;
        }
      }
    });
    if (flag) {
      showSubmitModal('题目未打完，确认提交试卷？');
    } else {
      showSubmitModal('确认提交试卷？');
    }
  };
</script>

<style scoped>
  .grid-demo-grid .demo-item,
  .grid-demo-grid .demo-suffix {
    height: 48px;
    line-height: 48px;
    color: var(--color-white);
    text-align: center;
  }
  .grid-demo-grid .demo-item:nth-child(2n) {
    background-color: rgba(var(--arcoblue-6), 0.9);
  }
  .grid-demo-grid .demo-item:nth-child(2n + 1) {
    background-color: var(--color-primary-light-4);
  }
</style>