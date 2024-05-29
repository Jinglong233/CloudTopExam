<template>
  <!--逐个展示问题-->
  <a-card :bordered="false" style="height: 720px">
    <!--问题部分-->
    <a-row :gutter="20">
      <a-col :span="2">
        <BookMark :number="nowQuestion.sort" />
      </a-col>
      <a-col :span="17">
        <div v-html="nowQuestion.content" />
      </a-col>
      <a-col :span="5">
        <a-typography-text
          style="float: right; height: 45px; line-height: 45px"
          type="primary"
        >
          本题{{ nowQuestion.score }}分
        </a-typography-text>
      </a-col>
    </a-row>
    <!--选项部分(除了填空题和简答题)-->
    <template
      v-if="
        nowQuestion.quType !== QuestionType.SHORTANSWER &&
        nowQuestion.quType !== QuestionType.GAPFILLING
      "
    >
      <template
        v-for="(quAnswer, index) in nowQuestion.quAnswerList"
        :key="index"
      >
        <a-card
          hoverable
          :style="{
            width: '100%',
            marginBottom: '20px',
            borderColor: isContainCurrentAnswer(quAnswer.id) ? '#0085f2' : '',
          }"
          @click="sendSelectAnswerId(quAnswer.id)"
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
      </template>
    </template>

    <!--填空题区域-->
    <template v-if="nowQuestion.quType === QuestionType.GAPFILLING">
      <a-card
        hoverable
        :style="{
          width: '100%',
          marginBottom: '20px',
        }"
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
            <a-typography-text type="primary"> 答案 </a-typography-text>
            <a-typography-text @blur="sendEditorAnswer">
              <SimpleEditor
                style="margin-bottom: 15px"
                :content="nowUserQuAnswer.answer ? nowUserQuAnswer.answer : ''"
                @editor-get-text="getEditorAnswer"
              />
            </a-typography-text>
          </a-space>
        </div>
        <a-button type="primary" @click="sendEditorAnswer">保存</a-button>
      </a-card>
    </template>

    <!--简答题区域-->
    <template v-if="nowQuestion.quType === QuestionType.SHORTANSWER">
      <a-card
        hoverable
        :style="{
          width: '100%',
          marginBottom: '20px',
        }"
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
            <a-typography-text type="primary"> 答案 </a-typography-text>
            <a-typography-text @blur="sendEditorAnswer">
              <SimpleEditor
                style="margin-bottom: 15px"
                :content="nowUserQuAnswer.answer ? nowUserQuAnswer.answer : ''"
                :content-confirm-change="contentConfirmChange"
                @editor-get-html="getEditorAnswer"
                @add-insert-picture="addInsertPicture"
                @add-delete-picture="addDeletePicture"
              />
            </a-typography-text>
          </a-space>
        </div>
        <a-button type="primary" @click="sendEditorAnswer">保存</a-button>
      </a-card>
    </template>

    <!--分割线-->
    <a-divider :size="2" style="border-bottom-style: dotted" />
  </a-card>
</template>

<script lang="ts" setup>
  import { PropType, ref, toRaw } from 'vue';
  import BookMark from '@/components/bookMark/index.vue';
  import { Qu } from '@/types/model/po/Qu';
  import { QuestionType } from '@/types/model/QuestionType';
  import { UserAnswer } from '@/types/model/po/UserAnswer';
  import SimpleEditor from '@/components/simple-editor/index.vue';
  import { deleteBatchImage } from '@/api/ossUpload';

  const props = defineProps({
    nowQuestion: {
      type: Object as PropType<Qu>,
    },
    nowUserQuAnswer: {
      type: Object as PropType<UserAnswer>,
    },
  });

  const emits = defineEmits(['getAnswerId']);

  // 确认改变标志
  const contentConfirmChange = ref(false);

  // 删除图片的列表
  const deletePictureList = ref<string[]>([]);

  // 添加图片的列表
  const insertPictureList = ref<string[]>([]);

  // 添加删除的图片
  const addDeletePicture = (deleteList: string[]) => {
    deletePictureList.value = deletePictureList.value.concat(deleteList);
  };

  // 添加插入的图片
  const addInsertPicture = (insertList: string[]) => {
    insertPictureList.value = insertPictureList.value.concat(insertList);
  };

  const userAnswer = ref<any>({});

  const sendSelectAnswerId = (content: string, glId: string) => {
    userAnswer.value = props.nowUserQuAnswer;
    // 1. 单选 2. 多选 3. 判断 4.填空 5. 简答
    const quType = props.nowQuestion?.quType;
    if (
      userAnswer.value.answerId === null ||
      userAnswer.value.answerId === undefined
    ) {
      userAnswer.value.answerId = '[]';
    }

    // 转换Json
    let answerIdArray = Object.values(JSON.parse(userAnswer.value.answerId));

    // 先判断是否数组为空
    if (answerIdArray.length === 0) {
      answerIdArray.push(content);
    } else if (answerIdArray.includes(content)) {
      // 判断答案列表中是否已经有该选项
      answerIdArray = answerIdArray.filter((answer) => answer !== content);
    } else if (
      quType === QuestionType.SINGLECHOICE ||
      quType === QuestionType.JUDGING ||
      quType === QuestionType.SHORTANSWER
    ) {
      // 单选、判断、填空、简答直接清空数组，重新添加
      answerIdArray.splice(0, 1, content);
    } else {
      // 多选题
      answerIdArray.push(content);
    }

    // 将数组重新转换为Json字符串
    userAnswer.value.answerId = JSON.stringify(answerIdArray);

    // 触发事件
    emits('getAnswerId', toRaw(userAnswer.value));
  };

  const getEditorAnswer = (answer: string) => {
    userAnswer.value = props.nowUserQuAnswer;
    userAnswer.value.answer = answer;
  };

  const sendEditorAnswer = async () => {
    contentConfirmChange.value = true;
    if (deletePictureList.value.length === 0) {
      emits('getAnswerId', toRaw(userAnswer.value));
      contentConfirmChange.value = false;
      return;
    }
    // 先删除待删除的图片
    await deleteBatchImage(deletePictureList.value).then(async (res: any) => {
      if (res.data === true) {
        // 触发事件
        emits('getAnswerId', toRaw(userAnswer.value));
        contentConfirmChange.value = false;
      }
    });
  };

  const isContainCurrentAnswer = (answerId: string) => {
    return props.nowUserQuAnswer?.answerId?.includes(answerId);
  };
</script>

<style></style>
