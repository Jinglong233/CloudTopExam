<template>
  <div class="container">
    <Breadcrumb :items="['menu.repo', 'menu.repo.modifyQu']" />
    <a-row :gutter="20" align="stretch">
      <a-col :span="24">
        <a-card class="general-card" style="padding-top: 50px">
          <a-row justify="space-between">
            <a-col :span="24">
              <a-tabs :default-active-tab="1" type="rounded">
                <a-tab-pane
                  v-if="form.quType === 1"
                  key="1"
                  :title="$t('cardList.tab.title.single')"
                >
                  <a-card class="general-card">
                    <a-form
                      :model="form"
                      :style="{ width: '600px' }"
                      @submit="handleSubmit"
                    >
                      <!--题库-->
                      <a-form-item
                        field="repoId"
                        label="题库"
                        :rules="[{ required: true, message: '题库不能为空' }]"
                      >
                        <a-select
                          v-model="form.repoId"
                          :style="{ width: '320px' }"
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
                          v-model="form.content"
                          :style="{ width: '320px' }"
                          placeholder="请输入题干"
                          @focus="handleEditor('content')"
                        />
                      </a-form-item>

                      <!--选项-->
                      <template
                        v-for="(option, index) in form.quAnswerList"
                        :key="index"
                      >
                        <a-form-item
                          :field="`quAnswerList[${index}].content`"
                          :label="`选项${numberToChar(index)}`"
                          :rules="[{ required: true, message: '选项不能为空' }]"
                        >
                          <a-space>
                            <a-input
                              v-model="form.quAnswerList[index].content"
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
                            v-for="(number, index) in form.quAnswerList.length"
                            :key="index"
                            :model-value="
                              Boolean(form.quAnswerList[index].isRight)
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
                          v-model="form.analysis"
                          :style="{ width: '320px' }"
                          placeholder="请输入题目解析"
                          @focus="handleEditor('analysis')"
                        />
                      </a-form-item>

                      <!--知识点-->
                      <a-form-item field="knowledge" label="知识点">
                        <a-input
                          v-model="form.knowledge"
                          :style="{ width: '320px' }"
                          placeholder="请输入知识点"
                          @focus="handleEditor('knowledge')"
                        />
                      </a-form-item>

                      <!--难度-->
                      <a-form-item
                        field="level"
                        label="难度"
                        :rules="[{ required: true, message: '难度不能为空' }]"
                      >
                        <a-select v-model="form.level">
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
                            >修改</a-button
                          >
                          <a-button type="primary" @click="addOption"
                            >添加选项</a-button
                          >
                        </a-space>
                      </a-form-item>
                    </a-form>
                  </a-card>
                </a-tab-pane>
                <a-tab-pane
                  v-if="form.quType === 2"
                  key="2"
                  :title="$t('cardList.tab.title.multiple')"
                >
                  <a-card class="general-card">
                    <a-form
                      :model="form"
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
                          v-model="form.repoId"
                          :style="{ width: '320px' }"
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
                          v-model="form.content"
                          :style="{ width: '320px' }"
                          placeholder="请输入题干"
                          @focus="handleEditor('content')"
                        />
                      </a-form-item>

                      <!--选项-->
                      <template
                        v-for="(option, index) in form.quAnswerList"
                        :key="index"
                      >
                        <a-form-item
                          :field="`quAnswerList[${index}].content`"
                          :label="`选项${numberToChar(index)}`"
                          :rules="[{ required: true, message: '选项不能为空' }]"
                        >
                          <a-space>
                            <a-input
                              v-model="form.quAnswerList[index].content"
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
                            v-for="(number, index) in form.quAnswerList.length"
                            :key="index"
                            :default-checked="
                              Boolean(form.quAnswerList[index].isRight)
                            "
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
                          v-model="form.analysis"
                          :style="{ width: '320px' }"
                          placeholder="请输入题目解析"
                          @focus="handleEditor('analysis')"
                        />
                      </a-form-item>

                      <!--知识点-->
                      <a-form-item field="knowledge" label="知识点">
                        <a-input
                          v-model="form.knowledge"
                          :style="{ width: '320px' }"
                          placeholder="请输入知识点"
                          @focus="handleEditor('knowledge')"
                        />
                      </a-form-item>

                      <!--难度-->
                      <a-form-item
                        field="level"
                        label="难度"
                        :rules="[{ required: true, message: '难度不能为空' }]"
                      >
                        <a-select v-model="form.level">
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
                            >修改</a-button
                          >
                          <a-button type="primary" @click="addOption"
                            >添加选项</a-button
                          >
                        </a-space>
                      </a-form-item>
                    </a-form>
                  </a-card>
                </a-tab-pane>
                <a-tab-pane
                  v-if="form.quType === 3"
                  key="3"
                  :title="$t('cardList.tab.title.judge')"
                >
                  <a-card class="general-card">
                    <a-form
                      :model="form"
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
                          v-model="form.repoId"
                          :style="{ width: '320px' }"
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
                          v-model="form.content"
                          :style="{ width: '320px' }"
                          placeholder="请输入题干"
                          @focus="handleEditor('content')"
                        />
                      </a-form-item>

                      <!--选项-->
                      <template
                        v-for="(option, index) in form.quAnswerList"
                        :key="index"
                      >
                        <a-form-item
                          :field="`quAnswerList[${index}].content`"
                          :label="`选项${numberToChar(index)}`"
                          :rules="[{ required: true, message: '选项不能为空' }]"
                        >
                          <a-space>
                            <a-input
                              v-model="form.quAnswerList[index].content"
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
                            v-for="(number, index) in form.quAnswerList.length"
                            :key="index"
                            :model-value="
                              Boolean(form.quAnswerList[index].isRight)
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
                          v-model="form.analysis"
                          :style="{ width: '320px' }"
                          placeholder="请输入题目解析"
                          @focus="handleEditor('analysis')"
                        />
                      </a-form-item>

                      <!--知识点-->
                      <a-form-item field="knowledge" label="知识点">
                        <a-input
                          v-model="form.knowledge"
                          :style="{ width: '320px' }"
                          placeholder="请输入知识点"
                          @focus="handleEditor('knowledge')"
                        />
                      </a-form-item>

                      <!--难度-->
                      <a-form-item
                        field="level"
                        label="难度"
                        :rules="[{ required: true, message: '难度不能为空' }]"
                      >
                        <a-select v-model="form.level">
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
                            >修改</a-button
                          >
                        </a-space>
                      </a-form-item>
                    </a-form>
                  </a-card>
                </a-tab-pane>
                <a-tab-pane
                  v-if="form.quType === 4"
                  key="4"
                  :title="$t('cardList.tab.title.fill')"
                >
                  <a-card class="general-card">
                    <a-form
                      :model="form"
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
                          v-model="form.repoId"
                          :style="{ width: '320px' }"
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
                          v-model="form.content"
                          :style="{ width: '320px' }"
                          placeholder="请输入题干"
                          @focus="handleEditor('content')"
                        />
                      </a-form-item>

                      <!--选项-->
                      <template
                        v-for="(option, index) in form.quAnswerList"
                        :key="index"
                      >
                        <a-form-item
                          :field="`quAnswerList[${index}].content`"
                          :label="`填空${index + 1}`"
                          :rules="[{ required: true, message: '填空不能为空' }]"
                        >
                          <a-space>
                            <a-input
                              v-model="form.quAnswerList[index].content"
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
                          v-model="form.analysis"
                          :style="{ width: '320px' }"
                          placeholder="请输入题目解析"
                          @focus="handleEditor('analysis')"
                        />
                      </a-form-item>

                      <!--知识点-->
                      <a-form-item field="knowledge" label="知识点">
                        <a-input
                          v-model="form.knowledge"
                          :style="{ width: '320px' }"
                          placeholder="请输入知识点"
                          @focus="handleEditor('knowledge')"
                        />
                      </a-form-item>

                      <!--难度-->
                      <a-form-item
                        field="level"
                        label="难度"
                        :rules="[{ required: true, message: '难度不能为空' }]"
                      >
                        <a-select v-model="form.level">
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
                            >修改</a-button
                          >
                          <a-button type="primary" @click="addOption"
                            >添加选项</a-button
                          >
                        </a-space>
                      </a-form-item>
                    </a-form>
                  </a-card>
                </a-tab-pane>
                <a-tab-pane
                  v-if="form.quType === 5"
                  key="5"
                  :title="$t('cardList.tab.title.shortAnswer')"
                >
                  <a-card class="general-card">
                    <a-form
                      :model="form"
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
                          v-model="form.repoId"
                          :style="{ width: '320px' }"
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
                          v-model="form.content"
                          :style="{ width: '320px' }"
                          placeholder="请输入题干"
                          @focus="handleEditor('content')"
                        />
                      </a-form-item>

                      <!--解析（简答题，解析就是答案）-->
                      <a-form-item
                        field="analysis"
                        label="解析"
                        :rules="[{ required: true, message: '解析不能为空' }]"
                      >
                        <a-input
                          v-model="form.analysis"
                          :style="{ width: '320px' }"
                          placeholder="请输入题目解析"
                          @focus="handleEditor('analysis')"
                        />
                      </a-form-item>

                      <!--知识点-->
                      <a-form-item field="knowledge" label="知识点">
                        <a-input
                          v-model="form.knowledge"
                          :style="{ width: '320px' }"
                          placeholder="请输入知识点"
                          @focus="handleEditor('knowledge')"
                        />
                      </a-form-item>

                      <!--难度-->
                      <a-form-item
                        field="level"
                        label="难度"
                        :rules="[{ required: true, message: '难度不能为空' }]"
                      >
                        <a-select v-model="form.level">
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
                            >修改</a-button
                          >
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
  import { Message } from '@arco-design/web-vue';

  import { getRepoList } from '@/api/repo';
  import { getQuById, updateQuById } from '@/api/qu';
  import QuAnswer from '@/types/model/po/QuAnswer';
  import { useRoute, useRouter } from 'vue-router';
  import { UpdateQuAndAnswerDTO } from '@/types/model/dto/UpdateQuAndAnswerDTO';
  import { Repo } from '@/types/model/po/Repo';
  import { useUserStore } from '@/store';
  import RepoQuery from '@/types/model/query/RepoQuery';
  import { deleteBatchImage } from '@/api/ossUpload';
  import useLoading from '@/hooks/loading';

  const userStore = useUserStore();
  const route = useRoute();
  const router = useRouter();
  const { loading, setLoading } = useLoading();
  const defaultQuAnswer: QuAnswer = {
    analysis: '', // 默认为空字符串
    content: '', // 默认为空字符串
    id: '', // 默认为空字符串
    isRight: 0,
  };

  /**
   * 题库列表
   */
  const repoList = ref<Repo[]>([]);

  const editorRef = ref();

  const visible = ref<boolean>(false);
  // 保存当前选择的输入框
  const currentSelect = ref<any>(0);
  // 临时保存编辑器的值
  const currentEditorText = ref<any>('');

  // 当前编辑器中的内容是否改变的标志
  const contentChange = ref<boolean>(false);

  const form = ref<UpdateQuAndAnswerDTO>({
    quAnswerList: [],
  });

  // 删除图片的列表
  const deletePictureList = ref<string[]>([]);

  // 添加图片的列表
  const insertPictureList = ref<string[]>([]);

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

    // 获取题目Id
    const quId = route.query.id;
    if (!quId) {
      router.back();
    }
    await getQuById(quId as string).then((res: any) => {
      form.value = res.data;
    });
    deletePictureList.value = [];
    insertPictureList.value = [];
  });

  // 添加删除的图片
  const addDeletePicture = (deleteList: string[]) => {
    deletePictureList.value = deletePictureList.value.concat(deleteList);
  };

  // 添加插入的图片
  const addInsertPicture = (insertList: string[]) => {
    insertPictureList.value = insertPictureList.value.concat(insertList);
  };
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
    // 重置内容更改标志
    contentChange.value = false;
    visible.value = true;
    currentSelect.value = index;
    if (index === 'content') {
      currentEditorText.value = form.value.content;
    } else if (index === 'analysis') {
      currentEditorText.value = form.value.analysis;
    } else if (index === 'knowledge') {
      currentEditorText.value = form.value.knowledge;
    } else if (form.value.quAnswerList) {
      currentEditorText.value =
        form.value.quAnswerList[currentSelect.value].content;
    }
  };

  /**
   * 单选按钮发生改变的时候，设置值
   * @param index
   */
  const handleRadioChange = (index: number) => {
    if (form.value.quAnswerList) {
      form.value.quAnswerList.forEach((option: QuAnswer, i: number) => {
        option.isRight = i === index ? 1 : 0;
      });
    }
  };

  /**
   * 多选题按钮发生改变的时候，设置值
   * @param index
   */
  const handleCheckBoxChange = (index: number, value: any) => {
    if (form.value.quAnswerList) {
      form.value.quAnswerList[index].isRight = Number(value);
    }
  };

  /**
   * 获取编辑器内容
   * @param htmlContent
   */
  const handleEditorGetText = (htmlContent: string) => {
    currentEditorText.value = htmlContent.trim();
  };

  const handleEditorOk = () => {
    contentChange.value = true;
    if (currentSelect.value === 'content') {
      // 题干
      form.value.content = currentEditorText.value;
    } else if (currentSelect.value === 'analysis') {
      // 解析
      form.value.analysis = currentEditorText.value;
    } else if (currentSelect.value === 'knowledge') {
      // 知识点
      form.value.knowledge = currentEditorText.value;
    } else if (form.value.quAnswerList) {
      // 下标
      form.value.quAnswerList[currentSelect.value].content =
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
    form.value.repoId = repoId;
    form.value.repoText = resultRepo?.title;
  };

  const handleSubmit = async ({ values, errors }: any) => {
    if (!errors) {
      setLoading(true);
      // 先修改图片相关，再修改题目信息
      await deleteBatchImage(deletePictureList.value).then(async (r: any) => {
        if (r.data === true) {
          // 相关图片处理完毕之后才进行题目信息的修改
          values.updateBy = userStore.id;
          await updateQuById(values).then((res: any) => {
            if (res.data === true) {
              Message.success({
                content: '修改成功',
              });
              router.back();
            } else {
              Message.error({
                content: '修改失败',
              });
            }
          });
        }
        setLoading(true);
      });
    } else {
      console.log('校验未通过');
    }
  };

  // 添加选项按钮
  const addOption = () => {
    if (form.value.quAnswerList) {
      form.value.quAnswerList.push(new QuAnswer());
    }
  };

  /**
   * 删除选项按钮
   */
  const deleteOption = (index: number) => {
    // 如果是填空可以只有一个选项
    if (Number(form.value.quType) === 4 && form.value.quAnswerList) {
      if (form.value.quAnswerList.length <= 1) {
        Message.warning({
          content: '已到最小删除数',
        });
        return;
      }
    } else if (
      form.value.quAnswerList &&
      form.value.quAnswerList?.length <= 2
    ) {
      Message.warning({
        content: '已到最小删除数',
      });
      return;
    }
    // 获取删除选项中的图片链接（如果有）
    deletePictureList.value = deletePictureList.value.concat(
      getImgUrl(form.value.quAnswerList?.[index].content as string)
    );
    form.value.quAnswerList?.splice(index, 1);
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
