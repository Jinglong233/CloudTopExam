<template>
  <div class="container">
    <Breadcrumb :items="['menu.repo', 'menu.repo.addQu']" />
    <a-row :gutter="20" align="stretch">
      <a-col :span="24">
        <a-card class="general-card" :title="$t('menu.repo.addQu')">
          <a-alert type="warning" style="margin-bottom: 10px"
            >注意：切换添加题型会导致当前未完成添加的题目信息丢失</a-alert
          >
          <a-row justify="space-between">
            <!--tab标签切换-->
            <a-col :span="24">
              <a-tabs
                ref="tabsRef"
                v-model="activeKey"
                :animation="true"
                :destroy-on-hide="true"
                :default-active-tab="1"
                type="rounded"
                @tab-click="tabChange"
              >
                <a-tab-pane key="1" :title="$t('cardList.tab.title.single')">
                  <a-card class="general-card">
                    <a-form
                      ref="formRef"
                      :model="quForm"
                      :style="{ width: '600px' }"
                      @submit="handleSubmit"
                    >
                      <!--题库-->
                      <a-form-item
                        field="repoId"
                        tooltip="选择题库"
                        label="题库"
                        :rules="[{ required: true, message: '题库不能为空' }]"
                      >
                        <a-select
                          :style="{ width: '320px' }"
                          :model-value="quForm.repoId"
                          placeholder="请选择题库"
                          @change="handleSelectChange"
                        >
                          <a-option
                            v-for="repo in repoList"
                            :key="repo.id"
                            :value="repo.id"
                            :label="repo.title"
                          />
                        </a-select>
                      </a-form-item>

                      <!--题干-->
                      <a-form-item
                        field="content"
                        label="题干"
                        :rules="[{ required: true, message: '题干不能为空' }]"
                      >
                        <a-input
                          v-model="quForm.content"
                          :style="{ width: '320px' }"
                          placeholder="请输入题干"
                          @focus="handleEditor('content')"
                        />
                      </a-form-item>

                      <!--选项-->
                      <template
                        v-for="(option, index) in quForm.quAnswerList"
                        :key="index"
                      >
                        <a-form-item
                          :field="`quAnswerList[${index}].content`"
                          :label="`选项${numberToChar(index)}`"
                          :rules="[{ required: true, message: '选项不能为空' }]"
                        >
                          <a-space>
                            <a-input
                              v-model="quForm.quAnswerList[index].content"
                              :style="{ width: '320px' }"
                              placeholder="输入选项"
                              @focus="handleEditor(index)"
                            />
                            <a-button
                              type="outline"
                              status="danger"
                              @click="deleteOption(index)"
                            >
                              <template #icon>
                                <icon-delete />
                              </template>
                              <template #default>删除</template>
                            </a-button>
                          </a-space>
                        </a-form-item>
                      </template>

                      <!--答案-->
                      <a-form-item
                        field="quAnswerList"
                        label="答案"
                        :rules="singleAnswerRule"
                      >
                        <a-space size="large">
                          <a-radio
                            v-for="(number, index) in quForm.quAnswerList
                              .length"
                            :key="index"
                            :model-value="
                              Boolean(quForm.quAnswerList[index].isRight)
                            "
                            @change="handleRadioChange(index)"
                            >{{ numberToChar(index) }}
                          </a-radio>
                        </a-space>
                      </a-form-item>

                      <!--解析-->
                      <a-form-item
                        field="analysis"
                        label="解析"
                        :rules="[{ required: true, message: '解析不能为空' }]"
                      >
                        <a-input
                          v-model="quForm.analysis"
                          :style="{ width: '320px' }"
                          placeholder="请输入题目解析"
                          @focus="handleEditor('analysis')"
                        />
                      </a-form-item>

                      <!--难度-->
                      <a-form-item
                        field="level"
                        label="难度"
                        :rules="[{ required: true, message: '难度不能为空' }]"
                      >
                        <a-select v-model="quForm.level">
                          <a-option :value="0">简单</a-option>
                          <a-option :value="1">困难</a-option>
                        </a-select>
                      </a-form-item>

                      <!--按钮-->
                      <a-form-item>
                        <a-space>
                          <a-button
                            type="primary"
                            html-type="submit"
                            :loading="loading"
                            >提交
                          </a-button>
                          <a-button type="primary" @click="addOption"
                            >添加选项
                          </a-button>
                        </a-space>
                      </a-form-item>
                    </a-form>
                  </a-card>
                </a-tab-pane>
                <a-tab-pane key="2" :title="$t('cardList.tab.title.multiple')">
                  <a-card class="general-card">
                    <a-form
                      ref="formRef"
                      :model="quForm"
                      :style="{ width: '600px' }"
                      @submit="handleSubmit"
                    >
                      <!--题库-->
                      <a-form-item
                        field="repoId"
                        tooltip="选择题库"
                        label="题库"
                        :rules="[{ required: true, message: '题库不能为空' }]"
                      >
                        <a-select
                          :style="{ width: '320px' }"
                          :model-value="quForm.repoId"
                          placeholder="请选择题库"
                          @change="handleSelectChange"
                        >
                          <a-option
                            v-for="repo in repoList"
                            :key="repo.id"
                            :value="repo.id"
                            :label="repo.title"
                          />
                        </a-select>
                      </a-form-item>

                      <!--题干-->
                      <a-form-item
                        field="content"
                        label="题干"
                        :rules="[{ required: true, message: '题干不能为空' }]"
                      >
                        <a-input
                          v-model="quForm.content"
                          :style="{ width: '320px' }"
                          placeholder="请输入题干"
                          @focus="handleEditor('content')"
                        />
                      </a-form-item>

                      <!--选项-->
                      <template
                        v-for="(option, index) in quForm.quAnswerList"
                        :key="index"
                      >
                        <a-form-item
                          :field="`quAnswerList[${index}].content`"
                          :label="`选项${numberToChar(index)}`"
                          :rules="[{ required: true, message: '选项不能为空' }]"
                        >
                          <a-space>
                            <a-input
                              v-model="quForm.quAnswerList[index].content"
                              :style="{ width: '320px' }"
                              placeholder="输入选项"
                              @focus="handleEditor(index)"
                            />
                            <a-button
                              type="outline"
                              status="danger"
                              @click="deleteOption(index)"
                            >
                              <template #icon>
                                <icon-delete />
                              </template>
                              <template #default>删除</template>
                            </a-button>
                          </a-space>
                        </a-form-item>
                      </template>

                      <!--答案-->
                      <a-form-item
                        field="quAnswerList"
                        label="答案"
                        :rules="multipleAnswerRule"
                      >
                        <a-space size="large">
                          <a-checkbox
                            v-for="(number, index) in quForm.quAnswerList
                              .length"
                            :key="index"
                            :value="quForm.quAnswerList[index].isRight"
                            @change="handleCheckBoxChange(index, $event)"
                            >{{ numberToChar(index) }}
                          </a-checkbox>
                        </a-space>
                      </a-form-item>

                      <!--解析-->
                      <a-form-item
                        field="analysis"
                        label="解析"
                        :rules="[{ required: true, message: '解析不能为空' }]"
                      >
                        <a-input
                          v-model="quForm.analysis"
                          :style="{ width: '320px' }"
                          placeholder="请输入题目解析"
                          @focus="handleEditor('analysis')"
                        />
                      </a-form-item>

                      <!--难度-->
                      <a-form-item
                        field="level"
                        label="难度"
                        :rules="[{ required: true, message: '难度不能为空' }]"
                      >
                        <a-select v-model="quForm.level">
                          <a-option :value="0">简单</a-option>
                          <a-option :value="1">困难</a-option>
                        </a-select>
                      </a-form-item>

                      <!--按钮-->
                      <a-form-item>
                        <a-space>
                          <a-button
                            type="primary"
                            html-type="submit"
                            :loading="loading"
                            >提交
                          </a-button>
                          <a-button type="primary" @click="addOption"
                            >添加选项
                          </a-button>
                        </a-space>
                      </a-form-item>
                    </a-form>
                  </a-card>
                </a-tab-pane>
                <a-tab-pane key="3" :title="$t('cardList.tab.title.judge')">
                  <a-card class="general-card">
                    <a-form
                      ref="formRef"
                      :model="quForm"
                      :style="{ width: '600px' }"
                      @submit="handleSubmit"
                    >
                      <a-form-item
                        field="repoId"
                        tooltip="选择题库"
                        label="题库"
                        :rules="[{ required: true, message: '题库不能为空' }]"
                      >
                        <a-select
                          :style="{ width: '320px' }"
                          :model-value="quForm.repoId"
                          placeholder="请选择题库"
                          @change="handleSelectChange"
                        >
                          <a-option
                            v-for="repo in repoList"
                            :key="repo.id"
                            :value="repo.id"
                            :label="repo.title"
                          />
                        </a-select>
                      </a-form-item>

                      <!--题干-->
                      <a-form-item
                        field="content"
                        label="题干"
                        :rules="[{ required: true, message: '题干不能为空' }]"
                      >
                        <a-input
                          v-model="quForm.content"
                          :style="{ width: '320px' }"
                          placeholder="请输入题干"
                          @focus="handleEditor('content')"
                        />
                      </a-form-item>

                      <!--选项-->
                      <template
                        v-for="(option, index) in quForm.quAnswerList"
                        :key="index"
                      >
                        <a-form-item
                          :field="`quAnswerList[${index}].content`"
                          :label="`选项${numberToChar(index)}`"
                          :rules="[{ required: true, message: '选项不能为空' }]"
                        >
                          <a-space>
                            <a-input
                              v-model="quForm.quAnswerList[index].content"
                              :style="{ width: '320px' }"
                              placeholder="输入选项"
                              @focus="handleEditor(index)"
                            />
                            <a-button
                              type="outline"
                              status="danger"
                              @click="deleteOption(index)"
                            >
                              <template #icon>
                                <icon-delete />
                              </template>
                              <template #default>删除</template>
                            </a-button>
                          </a-space>
                        </a-form-item>
                      </template>

                      <!--答案-->
                      <a-form-item
                        field="quAnswerList"
                        label="答案"
                        :rules="singleAnswerRule"
                      >
                        <a-space size="large">
                          <a-radio
                            v-for="(number, index) in quForm.quAnswerList
                              .length"
                            :key="index"
                            :model-value="
                              Boolean(quForm.quAnswerList[index].isRight)
                            "
                            @change="handleRadioChange(index)"
                          >
                            {{ index === 0 ? '正确' : '错误' }}
                          </a-radio>
                        </a-space>
                      </a-form-item>

                      <!--解析-->
                      <a-form-item
                        field="analysis"
                        label="解析"
                        :rules="[{ required: true, message: '解析不能为空' }]"
                      >
                        <a-input
                          v-model="quForm.analysis"
                          :style="{ width: '320px' }"
                          placeholder="请输入题目解析"
                          @focus="handleEditor('analysis')"
                        />
                      </a-form-item>

                      <!--难度-->
                      <a-form-item
                        field="level"
                        label="难度"
                        :rules="[{ required: true, message: '难度不能为空' }]"
                      >
                        <a-select v-model="quForm.level">
                          <a-option :value="0">简单</a-option>
                          <a-option :value="1">困难</a-option>
                        </a-select>
                      </a-form-item>

                      <!--按钮-->
                      <a-form-item>
                        <a-space>
                          <a-button
                            type="primary"
                            html-type="submit"
                            :loading="loading"
                            >提交
                          </a-button>
                        </a-space>
                      </a-form-item>
                    </a-form>
                  </a-card>
                </a-tab-pane>
                <a-tab-pane key="4" :title="$t('cardList.tab.title.fill')">
                  <a-card class="general-card">
                    <a-form
                      ref="formRef"
                      :model="quForm"
                      :style="{ width: '600px' }"
                      @submit="handleSubmit"
                    >
                      <a-form-item
                        field="repoId"
                        tooltip="选择题库"
                        label="题库"
                        :rules="[{ required: true, message: '题库不能为空' }]"
                      >
                        <a-select
                          :style="{ width: '320px' }"
                          :model-value="quForm.repoId"
                          placeholder="请选择题库"
                          @change="handleSelectChange"
                        >
                          <a-option
                            v-for="repo in repoList"
                            :key="repo.id"
                            :value="repo.id"
                            :label="repo.title"
                          />
                        </a-select>
                      </a-form-item>

                      <!--题干-->
                      <a-form-item
                        field="content"
                        label="题干"
                        :rules="[{ required: true, message: '题干不能为空' }]"
                      >
                        <a-input
                          v-model="quForm.content"
                          :style="{ width: '320px' }"
                          placeholder="请输入题干"
                          @focus="handleEditor('content')"
                        />
                      </a-form-item>

                      <!--选项-->
                      <template
                        v-for="(option, index) in quForm.quAnswerList"
                        :key="index"
                      >
                        <a-form-item
                          :field="`quAnswerList[${index}].content`"
                          :label="`填空${index + 1}`"
                          :rules="[{ required: true, message: '填空不能为空' }]"
                        >
                          <a-space>
                            <a-input
                              v-model="quForm.quAnswerList[index].content"
                              :style="{ width: '320px' }"
                              placeholder="输入填空"
                              @focus="handleEditor(index)"
                            />
                            <a-button
                              type="outline"
                              status="danger"
                              @click="deleteOption(index)"
                            >
                              <template #icon>
                                <icon-delete />
                              </template>
                              <template #default>删除</template>
                            </a-button>
                          </a-space>
                        </a-form-item>
                      </template>

                      <!--解析-->
                      <a-form-item
                        field="analysis"
                        label="解析"
                        :rules="[{ required: true, message: '解析不能为空' }]"
                      >
                        <a-input
                          v-model="quForm.analysis"
                          :style="{ width: '320px' }"
                          placeholder="请输入题目解析"
                          @focus="handleEditor('analysis')"
                        />
                      </a-form-item>

                      <!--难度-->
                      <a-form-item
                        field="level"
                        label="难度"
                        :rules="[{ required: true, message: '难度不能为空' }]"
                      >
                        <a-select v-model="quForm.level">
                          <a-option :value="0">简单</a-option>
                          <a-option :value="1">困难</a-option>
                        </a-select>
                      </a-form-item>

                      <!--按钮-->
                      <a-form-item>
                        <a-space>
                          <a-button
                            type="primary"
                            html-type="submit"
                            :loading="loading"
                            >提交
                          </a-button>
                          <a-button type="primary" @click="addOption"
                            >添加选项
                          </a-button>
                        </a-space>
                      </a-form-item>
                    </a-form>
                  </a-card>
                </a-tab-pane>
                <a-tab-pane
                  key="5"
                  :title="$t('cardList.tab.title.shortAnswer')"
                >
                  <a-card class="general-card">
                    <a-form
                      ref="formRef"
                      :model="quForm"
                      :style="{ width: '600px' }"
                      @submit="handleSubmit"
                    >
                      <!--题库-->
                      <a-form-item
                        field="repoId"
                        tooltip="选择题库"
                        label="题库"
                        :rules="[{ required: true, message: '题库不能为空' }]"
                      >
                        <a-select
                          :style="{ width: '320px' }"
                          :model-value="quForm.repoId"
                          placeholder="请选择题库"
                          @change="handleSelectChange"
                        >
                          <a-option
                            v-for="repo in repoList"
                            :key="repo.id"
                            :value="repo.id"
                            :label="repo.title"
                          />
                        </a-select>
                      </a-form-item>

                      <!--题干-->
                      <a-form-item
                        field="content"
                        label="题干"
                        :rules="[{ required: true, message: '题干不能为空' }]"
                      >
                        <a-input
                          v-model="quForm.content"
                          :style="{ width: '320px' }"
                          placeholder="请输入题干"
                          @focus="handleEditor('content')"
                        />
                      </a-form-item>

                      <!--解析-->
                      <a-form-item
                        field="analysis"
                        label="解析"
                        :rules="[{ required: true, message: '解析不能为空' }]"
                      >
                        <a-input
                          v-model="quForm.analysis"
                          :style="{ width: '320px' }"
                          placeholder="请输入题目解析"
                          @focus="handleEditor('analysis')"
                        />
                      </a-form-item>

                      <!--难度-->
                      <a-form-item
                        field="level"
                        label="难度"
                        :rules="[{ required: true, message: '难度不能为空' }]"
                      >
                        <a-select v-model="quForm.level">
                          <a-option :value="0">简单</a-option>
                          <a-option :value="1">困难</a-option>
                        </a-select>
                      </a-form-item>

                      <!--按钮-->
                      <a-form-item>
                        <a-space>
                          <a-button
                            type="primary"
                            html-type="submit"
                            :loading="loading"
                            >提交
                          </a-button>
                        </a-space>
                      </a-form-item>
                    </a-form>
                  </a-card>
                </a-tab-pane>
              </a-tabs>
            </a-col>
          </a-row>
        </a-card>
      </a-col>
    </a-row>
    <!--富文本编辑器-->
    <a-modal
      :visible="visible"
      width="800px"
      @ok="handleEditorOk"
      @cancel="handleEditorCancel"
    >
      <MyEditor
        v-if="visible"
        :ref="editorRef"
        :content-confirm-change="contentChange"
        :editor-text="currentEditorText"
        @editor-get-html="handleEditorGetText"
        @add-delete-picture="addDeletePicture"
        @add-insert-picture="addInsertPicture"
      />
    </a-modal>
  </div>
</template>

<script lang="ts" setup>
  // 导入
  import MyEditor from '@/components/my-editor/index.vue';
  import { onMounted, ref } from 'vue';
  import { getImgUrl, numberToChar } from '@/utils/common';
  import { Message, Modal } from '@arco-design/web-vue';

  import { getRepoList } from '@/api/repo';
  import { QuAnswer } from '@/types/model/po/QuAnswer';
  import { Repo } from '@/types/model/po/Repo';
  import { AddQuAndAnswerDTO } from '@/types/model/dto/AddQuAndAnswerDTO';
  import { useRouter } from 'vue-router';
  import { addQuAndQuAnswer } from '@/api/qu';
  import RepoQuery from '@/types/model/query/RepoQuery';
  import { deleteBatchImage } from '@/api/ossUpload';
  import useLoading from '@/hooks/loading';

  const editorRef = ref();
  const activeKey = ref<number>();
  const { loading, setLoading } = useLoading();

  const router = useRouter();
  // 答案对象
  const defaultQuAnswer: QuAnswer = {
    analysis: '', // 默认为空字符串
    content: '', // 默认为空字符串
    id: '', // 默认为空字符串
    isRight: 0,
    image: '',
    tag: '',
  };

  // 当前编辑器中的内容是否改变的标志
  const contentChange = ref<boolean>(false);

  // 删除图片的列表
  const deletePictureList = ref<string[]>([]);

  // 添加图片的列表
  const insertPictureList = ref<string[]>([]);

  // 清除添加列表、删除列表、改变标志
  const clearFlag = () => {
    contentChange.value = false;
    deletePictureList.value = [];
    insertPictureList.value = [];
  };

  /**
   * 产生一个默认的选项对象
   */
  const generateDefaultAnswer = (): QuAnswer => {
    return {
      ...defaultQuAnswer, // 使用展开运算符创建新对象，而不是引用同一个对象
    };
  };

  /**
   * 题库列表
   */
  const repoList = ref<Repo[]>([]);

  onMounted(async () => {
    // 监听页面刷新
    window.addEventListener('beforeunload', (e) => {
      e = e || window.event;
      if (e) {
        e.returnValue = '关闭提示';
      }
      return '关闭提示';
    });

    // todo 刷新之后必须得发送删除一个删除请求

    // 获取题库列表
    await getRepoList({} as RepoQuery).then((res: any) => {
      repoList.value = res.data.list;
    });

    deletePictureList.value = [];
    insertPictureList.value = [];
  });

  const visible = ref<boolean>(false);
  // 保存当前选择的输入框
  const currentSelect = ref<any>(0);
  // 临时保存编辑器的值
  const currentEditorText = ref<any>('');

  const formRef = ref();

  const quForm = ref<AddQuAndAnswerDTO>({
    quType: 1,
    quAnswerList: [new QuAnswer(), new QuAnswer()],
  });

  /**
   * 单选题答案校验规则
   */
  const singleAnswerRule = [
    {
      validator: (value: QuAnswer[], cb: any) => {
        let count = 0;
        value.forEach((option: QuAnswer) => {
          if (option.isRight === 1) {
            count += 1;
          }
        });
        if (count !== 1) {
          cb('答案有且只能有一个');
        }
      },
    },
  ];

  // 切换tab的时候，切换题型，清空原form对象中的数据
  const tabChange = async (key: number) => {
    // 切换的时候得清空OSS相关的状态记录
    if (insertPictureList.value.length > 0) {
      await deleteBatchImage(insertPictureList.value);
    }
    clearFlag();

    quForm.value = {
      quType: Number(key),
      quAnswerList: [generateDefaultAnswer(), generateDefaultAnswer()],
    } as AddQuAndAnswerDTO;
    // 判断题提前赋值
    if (Number(key) === 3 && quForm.value.quAnswerList) {
      quForm.value.quAnswerList[0].content = '正确';
      quForm.value.quAnswerList[1].content = '错误';
    }
  };

  /**
   * 多选题答案校验规则
   */
  const multipleAnswerRule = [
    {
      validator: (value: QuAnswer[], cb: any) => {
        let count = 0;
        value.forEach((option: QuAnswer) => {
          if (option.isRight === 1) {
            count += 1;
          }
        });
        if (count < 2) {
          cb('答案至少有两个');
        }
      },
    },
  ];

  /**
   * 选项对应的编辑器处理方式
   * @param index 选项下标
   */
  const handleEditor = (index: any) => {
    visible.value = true;
    currentSelect.value = index;
    if (index === 'content') {
      currentEditorText.value = quForm.value.content;
    } else if (index === 'analysis') {
      currentEditorText.value = quForm.value.analysis;
    } else {
      currentEditorText.value =
        quForm.value.quAnswerList?.[currentSelect.value].content;
    }
  };

  /**
   * 单选按钮发生改变的时候，设置值
   * @param index
   */
  const handleRadioChange = (index: number) => {
    quForm.value.quAnswerList?.forEach((option: QuAnswer, i: number) => {
      option.isRight = i === index ? 1 : 0;
    });
  };

  /**
   * 多选题按钮发生改变的时候，设置值
   * @param index
   */
  const handleCheckBoxChange = (index: number, value: any) => {
    if (quForm.value.quAnswerList) {
      quForm.value.quAnswerList[index].isRight = Number(value);
    }
  };

  /**
   * 获取编辑器内容
   * @param htmlContent
   */
  const handleEditorGetText = (htmlContent: string) => {
    currentEditorText.value = htmlContent.trim();
  };

  // 根据不同输入框选择对应的处理情况
  const handleEditorOk = () => {
    contentChange.value = true;

    if (currentSelect.value === 'content') {
      quForm.value.content = currentEditorText.value;
    } else if (currentSelect.value === 'analysis') {
      quForm.value.analysis = currentEditorText.value;
    } else if (quForm.value.quAnswerList) {
      quForm.value.quAnswerList[currentSelect.value].content =
        currentEditorText.value;
    }
    Promise.resolve().then(() => {
      visible.value = false;
    });
    currentEditorText.value = '';
  };

  const handleEditorCancel = () => {
    contentChange.value = false;
    Promise.resolve().then(() => {
      visible.value = false;
    });
    currentEditorText.value = '';
  };

  // 下拉框变化，给repoId和repoText赋值
  const handleSelectChange = (repoId: string) => {
    const resultRepo = repoList.value.find((repo: Repo) => {
      return repo.id === repoId;
    });
    quForm.value.repoId = repoId;
    quForm.value.repoText = resultRepo?.title;
  };

  // 继续添加题目对话框
  const continueAddQu = (values: any) => {
    // 继续添加
    quForm.value = {
      repoId: '',
      repoText: '',
      quType: values.quType, // 保留当前提醒防止丢失
      quAnswerList: [new QuAnswer(), new QuAnswer()],
    } as AddQuAndAnswerDTO;
    // 判断题提前赋值
    if (Number(values.quType) === 3 && quForm.value.quAnswerList) {
      quForm.value.quAnswerList[0].content = '正确';
      quForm.value.quAnswerList[1].content = '错误';
    }
  };

  /**
   * 添加提交
   * @param values
   * @param errors
   */
  const handleSubmit = async ({ values, errors }: any) => {
    if (!errors) {
      setLoading(true);
      // 先修改图片相关，再修改题目信息
      await deleteBatchImage(deletePictureList.value).then(async (r: any) => {
        if (r.data === true) {
          await addQuAndQuAnswer(values).then((res: any) => {
            if (res.data === true) {
              Message.success({
                content: '添加成功',
              });
              Modal.info({
                content: '返回列表或者继续添加',
                hideCancel: false,
                closable: true,
                okText: '继续添加',
                cancelText: '返回列表',
                okButtonProps: { type: 'primary' },
                cancelButtonProps: { type: 'primary' },
                onOk: () => {
                  continueAddQu(values);
                },
                onCancel: () => {
                  // 返回列表
                  router.push({
                    path: '/repo/qu-manager',
                  });
                },
              });
            }
          });
        }
        setLoading(false);
      });
    } else {
      console.log('校验未通过');
    }
  };

  /**
   * 添加选项按钮
   */
  const addOption = () => {
    if (quForm.value.quAnswerList) {
      quForm.value.quAnswerList.push(generateDefaultAnswer());
    }
  };

  /**
   * 删除选项按钮
   */
  const deleteOption = (index: number) => {
    // 如果是填空可以只有一个选项
    if (Number(quForm.value.quType) === 4) {
      if (quForm.value.quAnswerList && quForm.value.quAnswerList.length <= 1) {
        Message.warning({
          content: '已到最小删除数',
        });
        return;
      }
    } else if (
      quForm.value.quAnswerList &&
      quForm.value.quAnswerList?.length <= 2
    ) {
      Message.warning({
        content: '已到最小删除数',
      });
      return;
    }
    // 获取删除选项中的图片链接（如果有）
    deletePictureList.value = deletePictureList.value.concat(
      getImgUrl(quForm.value.quAnswerList?.[index].content as string)
    );
    quForm.value.quAnswerList?.splice(index, 1);
  };

  // 添加删除的图片
  const addDeletePicture = (deleteList: string[]) => {
    deletePictureList.value = deletePictureList.value.concat(deleteList);
  };

  // 添加插入的图片
  const addInsertPicture = (insertList: string[]) => {
    insertPictureList.value = insertPictureList.value.concat(insertList);
  };
</script>

<style scoped lang="less">
  .container {
    padding: 0 20px 20px 20px;

    :deep(.arco-list-content) {
      overflow-x: hidden;
    }

    :deep(.arco-card-meta-title) {
      font-size: 14px;
    }
  }

  :deep(.arco-list-col) {
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    justify-content: space-between;
  }

  :deep(.arco-list-item) {
    width: 33%;
  }

  :deep(.block-title) {
    margin: 0 0 12px 0;
    font-size: 14px;
  }

  :deep(.list-wrap) {
    // min-height: 140px;
    .list-row {
      align-items: stretch;

      .list-col {
        margin-bottom: 16px;
      }
    }

    :deep(.arco-space) {
      width: 100%;

      .arco-space-item {
        &:last-child {
          flex: 1;
        }
      }
    }
  }
</style>
