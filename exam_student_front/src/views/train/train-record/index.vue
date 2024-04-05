<template>
  <a-row>
    <a-col :span="6" style="margin-top: 20px">
      <a-card style="width: 300px; margin-left: 20px">
        <a-scrollbar style="height: 650px; overflow: auto">
          <a-col :span="16">共{{ quCount }}题</a-col>
          <a-row :gutter="50">
            <a-col
              v-for="index in quCount"
              :key="index.id"
              style="margin-top: 10px"
              :span="4"
            >
              <a-button
                :type="isNowNumber(index) ? 'primary' : 'outline'"
                @click="jumpQuestion(index)"
                >{{ index }}</a-button
              >
            </a-col>
          </a-row>
        </a-scrollbar>
      </a-card>
    </a-col>
    <a-col :span="18">
      <a-card style="height: 680px; margin: 10px; margin-top: 20px">
        <!--问题部分-->
        <a-row :gutter="20">
          <a-col :span="2">
            <BookMark :number="nowQuestion.trainRecord.sort" />
          </a-col>
          <a-col :span="17">
            <div v-html="nowQuestion.quAndAnswerVo.content" />
          </a-col>
        </a-row>

        <template
          v-for="(quAnswer, index) in nowQuestion.quAndAnswerVo.quAnswerList"
          :key="index"
        >
          <!--如果不是多选题-->
          <a-card
            v-if="
              nowQuestion.quAndAnswerVo.quType !== QuestionType.MULTIPLECHOICE
            "
            hoverable
            :style="{
              width: '100%',
              marginBottom: '20px',
              cursor: 'pointer',
              borderColor: isContainCurrentAnswer(
                nowQuestion.trainRecord,
                quAnswer.id
              )
                ? '#0085f2'
                : '',
            }"
            @click="
              sendSelectAnswerId(
                nowQuestion.trainRecord,
                quAnswer.id,
                nowQuestion.quAndAnswerVo.quType
              )
            "
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
              <!--判断是否答案-->
              <a-space
                v-if="
                  nowQuestion.trainRecord.answered === 1 &&
                  quAnswer.isRight === 1
                "
              >
                <a-badge style="float: right">
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

          <!--如果是多选题-->
          <a-card
            v-if="
              nowQuestion.quAndAnswerVo.quType === QuestionType.MULTIPLECHOICE
            "
            hoverable
            :style="{
              width: '100%',
              marginBottom: '20px',
              cursor: 'pointer',
              borderColor: isContainCurrentAnswer(
                nowQuestion.trainRecord,
                quAnswer.id
              )
                ? '#0085f2'
                : '',
            }"
            @click="answerTrain(quAnswer.id, nowQuestion.quAndAnswerVo.quType)"
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
              <!--判断是否答案-->
              <a-space
                v-if="
                  nowQuestion.trainRecord.answered === 1 &&
                  quAnswer.isRight === 1
                "
              >
                <a-badge style="float: right">
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
        <div
          v-if="
            nowQuestion.quAndAnswerVo.quType === QuestionType.MULTIPLECHOICE
          "
        >
          <!--  如果是多选题就得有确认按钮-->
          <a-button
            type="primary"
            :disabled="nowQuestion.trainRecord.answered === 1"
            @click="multSelectAnswerId()"
            >确认答案</a-button
          >
        </div>
        <div
          v-if="nowQuestion.trainRecord.answered === 1"
          v-html="
            nowQuestion.quAndAnswerVo.analysis === null
              ? '无解析'
              : nowQuestion.quAndAnswerVo.analysis
          "
        />
      </a-card>
    </a-col>
  </a-row>
</template>

<script lang="ts" setup>
  import { useI18n } from 'vue-i18n';
  import { useRoute, useRouter } from 'vue-router';
  import { onMounted, ref } from 'vue';
  import {
    getTrainRecordById,
    getTrainRecordQu,
    updateTrainRecord,
  } from '@/api/train';
  import { Message } from '@arco-design/web-vue';
  import BookMark from '@/components/bookMark/index.vue';

  import { TrainRecordQuVO } from '@/types/model/vo/TrainRecordQuVO';
  import { TrainRecord } from '@/types/model/po/TrainRecord';
  import { QuestionType } from '@/types/model/QuestionType';

  const { t } = useI18n();

  const router = useRouter();
  const route = useRoute();
  const trainId = ref<string>('');

  // 题目总数
  const quCount = ref();
  // 当前题目下标
  const nowQuIndex = ref(1);

  // 当前问题
  const nowQuestion = ref<TrainRecordQuVO>({
    quAndAnswerVo: {
      quType: undefined,
      quAnswerList: [],
    },
    trainRecord: {},
  });

  onMounted(async () => {
    // 获取路由参数
    trainId.value = route.params.trainId as string;

    if (trainId.value) {
      // 获取训练记录
      await getTrainRecordById(trainId.value).then((res) => {
        if (res.data) {
          quCount.value = res.data;
        } else {
          Message.warning({
            content: '获取训练记录失败',
            duration: 2000,
          });
        }
      });

      // 获取第一个问题的详情
      await getTrainRecordQu({
        sort: nowQuIndex.value,
        trainId: trainId.value,
      }).then((res) => {
        nowQuestion.value = res.data;
      });
    }
  });

  const isNowNumber = (index: number) => {
    if (index === nowQuIndex.value) {
      return true;
    }

    return false;
  };

  const jumpQuestion = async (index: number) => {
    nowQuIndex.value = index;
    await getTrainRecordQu({
      sort: nowQuIndex.value,
      trainId: trainId.value,
    }).then((res) => {
      nowQuestion.value = res.data;
    });
  };

  const isContainCurrentAnswer = (
    trainRecord: TrainRecord,
    quAnswerId: string
  ) => {
    return trainRecord.answerId?.includes(quAnswerId);
  };

  // 更新当前作答记录操作(多选题触发)
  const answerTrain = (quAnswerId: string, quType: any) => {
    if (nowQuestion.value.trainRecord?.answered === 1) {
      return;
    }

    // 如果已经作答了，就不能触发更新了
    if (nowQuestion.value.trainRecord?.answered === 1) {
      return;
    }
    if (nowQuestion.value.trainRecord?.answerId === null) {
      nowQuestion.value.trainRecord.answerId = '[]';
    }

    // 转换Json
    let answerIdArray = Object.values(
      JSON.parse(nowQuestion.value.trainRecord?.answerId as string)
    );

    // 先判断是否数组为空
    if (answerIdArray.length === 0) {
      answerIdArray.push(quAnswerId);
    } else if (answerIdArray.includes(quAnswerId)) {
      // 判断答案列表中是否已经有该选项
      answerIdArray = answerIdArray.filter((answer) => answer !== quAnswerId);
    } else if (
      quType === QuestionType.SINGLECHOICE ||
      quType === QuestionType.JUDGING ||
      quType === QuestionType.SHORTANSWER
    ) {
      // 单选、判断、填空、简答直接清空数组，重新添加
      answerIdArray.splice(0, 1, quAnswerId);
    } else {
      // 多选题
      answerIdArray.push(quAnswerId);
    }

    // 将数组重新转换为Json字符串
    if (nowQuestion.value.trainRecord) {
      nowQuestion.value.trainRecord.answerId = JSON.stringify(answerIdArray);
    }
  };

  // 多选题作答逻辑
  const multSelectAnswerId = async () => {
    // 判断是否作答了
    if (nowQuestion.value.trainRecord?.answerId === null) {
      Message.warning({
        content: '未作答',
        duration: 2000,
      });
    }

    if (nowQuestion.value.trainRecord?.answerId !== null) {
      // 转换Json
      const answerIdArray = Object.values(
        JSON.parse(nowQuestion.value.trainRecord?.answerId as string)
      );
      if (answerIdArray.length === 0) {
        Message.warning({
          content: '未作答',
          duration: 2000,
        });
      }
    }

    // 更新训练作答记录
    await updateTrainRecord(nowQuestion.value.trainRecord as TrainRecord).then(
      async (res: any) => {
        if (res.data === true) {
          // 更新成功则重获获取该题目的作答记录
          await getTrainRecordQu({
            sort: nowQuIndex.value,
            trainId: trainId.value,
          }).then((r) => {
            nowQuestion.value = r.data;
          });
        } else {
          Message.warning({ content: '更新失败', duration: 2000 });
        }
      }
    );
  };

  // 单选、判断作答逻辑
  const sendSelectAnswerId = async (
    trainRecord: TrainRecord,
    quAnswerId: string,
    quType: any
  ) => {
    // 如果已经作答了，就不能触发更新了
    if (trainRecord.answered === 1) {
      return;
    }
    trainRecord.answered = 1;
    // 单选每次都清空
    trainRecord.answerId = '[]';

    // 转换Json
    let answerIdArray = Object.values(JSON.parse(trainRecord.answerId));

    // 先判断是否数组为空
    if (answerIdArray.length === 0) {
      answerIdArray.push(quAnswerId);
    } else if (answerIdArray.includes(quAnswerId)) {
      // 判断答案列表中是否已经有该选项
      answerIdArray = answerIdArray.filter((answer) => answer !== quAnswerId);
    } else if (
      quType === QuestionType.SINGLECHOICE ||
      quType === QuestionType.JUDGING ||
      quType === QuestionType.SHORTANSWER
    ) {
      // 单选、判断、填空、简答直接清空数组，重新添加
      answerIdArray.splice(0, 1, quAnswerId);
    } else {
      // 多选题
      answerIdArray.push(quAnswerId);
    }

    // 将数组重新转换为Json字符串
    trainRecord.answerId = JSON.stringify(answerIdArray);

    // 更新训练作答记录
    await updateTrainRecord(trainRecord).then(async (res: any) => {
      if (res.data === true) {
        // 更新成功则重获获取该题目的作答记录
        await getTrainRecordQu({
          sort: nowQuIndex.value,
          trainId: trainId.value,
        }).then((r) => {
          nowQuestion.value = r.data;
        });
      } else {
        Message.warning({ content: '更新失败', duration: 2000 });
      }
    });
  };

  const stopTrain = () => {};
</script>

<style scoped></style>
