<template>
  <div class="container">
    <Breadcrumb :items="['menu.exam', 'menu.exam.modifyPaper']" />

    <a-layout>
      <!--左侧题目总数展示-->
      <a-affix :offset-top="100">
        <a-layout-sider :width="310" style="margin-left: 20px">
          <a-card hoverable>
            <a-scrollbar type="track" style="height: 680px; overflow: auto">
              <a-space direction="vertical" fill>
                <a-typography-text style="font-weight: bold"
                  >组卷方式：
                  <template v-if="updatePaperForm.joinType === 0"
                    >抽题组卷</template
                  >
                  <template v-if="updatePaperForm.joinType === 1"
                    >指定选题</template
                  >
                </a-typography-text>
                <a-typography-text style="font-weight: bold"
                  >试题总数：{{ updatePaperForm.quCount || 0 }}
                </a-typography-text>
                <a-typography-text style="font-weight: bold"
                  >试卷总分：{{ updatePaperForm.totalCount || 0 }}
                </a-typography-text>
                <a-button type="primary" long @click="updatePaper"
                  >保存试卷</a-button
                >
              </a-space>
              <!--1.单选题 2.多选题 3.判断题 4.填空题 5.简答题-->
              <template
                v-for="(groupList, index) in updatePaperForm.groupLists"
                :key="index"
              >
                <!--大题标题-->
                <a-typography-title
                  type="primary"
                  :heading="6"
                  style="padding: 10px 0px"
                >
                  {{
                    groupList.title ||
                    getQuestionTypeName(Number(groupList.quType))
                  }}
                </a-typography-title>
                <a-divider :margin="0" />
                <!--大题概览区-->
                <a-space align="center">
                  <a-typography
                    >共
                    <a-typography-text type="primary">
                      {{ groupList.quCount || 0 }}
                    </a-typography-text>
                    题,共
                    <a-typography-text type="primary">
                      {{ groupList.totalScore || 0 }}
                    </a-typography-text>
                    分
                  </a-typography>
                  <a-popconfirm
                    content="确定要删除本大题吗？"
                    position="bottom"
                    @ok="confirmDelete(groupList.quType, index)"
                    @cancel="cancelDelete(groupList.quType, index)"
                  >
                    <a-button type="text">
                      <template #icon>
                        <icon-delete />
                      </template>
                      删除
                    </a-button>
                  </a-popconfirm>
                </a-space>
                <!--每题给分-->
                <a-space>
                  每题
                  <a-input-number
                    v-model="groupList.perScore"
                    :precision="1"
                    :default-value="0"
                    :min="0"
                    :hide-button="true"
                    @input="inputScoreChange($event, index)"
                  />
                  分
                </a-space>
              </template>
              <div style="margin-top: 20px" />
            </a-scrollbar>
          </a-card>
        </a-layout-sider>
      </a-affix>
      <!--问题预览部分-->
      <a-layout-content style="margin: 0 15px">
        <!--添加大题标头-->
        <a-card>
          <a-row :gutter="16">
            <a-col :span="20">
              <a-space direction="vertical" fill>
                <a-form-item label="试卷名称" :style="{ width: '600px' }">
                  <a-input
                    v-model="updatePaperForm.title"
                    placeholder="请输入试卷名称"
                  />
                </a-form-item>
                <a-form-item label="试卷分类" :style="{ width: '600px' }">
                  <a-tree-select
                    v-model="updatePaperForm.deptCode"
                    placeholder="请选择试卷分类"
                    :data="deptTree"
                    :field-names="{
                      key: 'deptCode',
                      title: 'deptName',
                      children: 'children',
                    }"
                  />
                </a-form-item>
              </a-space>
            </a-col>
            <a-col :span="4">
              <a-button-group>
                <a-dropdown @select="dropDownSelect">
                  <a-button type="primary" long>添加新的大题</a-button>
                  <template #content>
                    <a-doption :value="QuestionType.SINGLECHOICE"
                      >单选题</a-doption
                    >
                    <a-doption :value="QuestionType.MULTIPLECHOICE"
                      >多选题</a-doption
                    >
                    <a-doption :value="QuestionType.JUDGING">判断题</a-doption>
                    <a-doption :value="QuestionType.GAPFILLING"
                      >填空题</a-doption
                    >
                    <a-doption :value="QuestionType.SHORTANSWER"
                      >简答题</a-doption
                    >
                  </template>
                </a-dropdown>
              </a-button-group>
            </a-col>
          </a-row>
        </a-card>
        <a-typography-title :heading="5">题目管理</a-typography-title>
        <a-card
          v-for="(groupList, groupIndex) in updatePaperForm.groupLists"
          :key="groupIndex"
          style="margin-top: 25px"
          :bordered="false"
        >
          <!--大题标题-->
          <template #title>
            <a-space>
              <a-input v-model="groupList.title" />
              <a-button
                type="primary"
                @click="addItem(groupList.quType, groupIndex)"
              >
                <template #icon>
                  <icon-plus />
                </template>
                添加题目
              </a-button>
            </a-space>
          </template>

          <!--大题乱序选项-->
          <template #extra>
            <a-checkbox
              type="checkbox"
              :value="1"
              @change="checkBoxChange($event, groupList, 'quRand')"
              >试题乱序</a-checkbox
            >

            <a-checkbox
              type="checkbox"
              :value="1"
              @change="checkBoxChange($event, groupList, 'itemRand')"
              >选项乱序</a-checkbox
            >
          </template>
          <!--题目展示部分-->
          <a-card
            v-for="(qu, index) in groupList.quList"
            :key="index"
            :bordered="false"
          >
            <!--锚点位置-->
            <div :id="`单选${index + 1}`"></div>
            <!--问题部分-->
            <template #title>
              <a-space>
                <BookMark :number="index + 1" />
                {{ qu.content }}
              </a-space>
            </template>
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
                        {{ quAnswer.content }}
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
              </a-col>
              <a-col :span="7">
                <a-card :style="{ textAlign: 'center' }">
                  <a-space direction="vertical" fill size="50px">
                    <!--按钮-->
                    <a-space align="center">
                      <a-button
                        shape="circle"
                        status="danger"
                        type="primary"
                        @click="removeItem(qu.quType, index)"
                      >
                        <icon-delete />
                      </a-button>
                      <a-button shape="circle" @click="sortUp(groupList)">
                        <icon-arrow-up />
                      </a-button>
                      <a-button shape="circle" @click="sortDown(groupList)">
                        <icon-arrow-down />
                      </a-button>
                    </a-space>
                    <!--得分部分-->
                    <a-space align="center">
                      <a-typography-text>本题</a-typography-text>
                      <a-input-number
                        v-model="qu.score"
                        :default-value="0.0"
                        :style="{ width: '100px' }"
                        :min="0"
                        mode="button"
                        :precision="1"
                        size="larger"
                      />
                      分
                    </a-space>
                  </a-space>
                </a-card>
              </a-col>
            </a-row>
            <!--分割线-->
            <a-divider :size="2" style="border-bottom-style: dotted" />
          </a-card>
        </a-card>
      </a-layout-content>
    </a-layout>

    <!--抽取题目模态框-->
    <a-modal
      v-model:visible="addTypeVisible"
      :style="{ textAlign: 'center' }"
      width="auto"
      :closable="false"
      @ok="confirmAdd"
      @cancel="cancelAdd"
    >
      <!--随机抽题-->
      <template v-if="updatePaperForm.joinType === 0">
        <a-space>
          <a-form-item label="选择题库">
            <a-select
              v-model="randomSelectQuForm.repoId"
              :style="{ width: '320px' }"
              placeholder="选择题库"
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
          <a-form-item>
            <a-input
              :placeholder="getQuestionTypeName(randomSelectQuForm.quType)"
              disabled
            />
          </a-form-item>
        </a-space>
        <div></div>
        <a-space direction="vertical" fill>
          <a-space>
            <a-typography-text>简单题</a-typography-text>
            抽取
            <a-input-number
              v-model="randomSelectQuForm.levels[0].num"
              :max="Number(randomSelectQuForm.levels[0].quCount)"
              :min="0"
              :style="{ width: '200px' }"
              :default-value="0"
              mode="button"
            />
            题/共
            <span>
              {{ classfiyResult.easyCount }}
            </span>
            题
          </a-space>
          <a-space>
            <a-typography-text>困难题</a-typography-text>
            抽取
            <a-input-number
              v-model="randomSelectQuForm.levels[1].num"
              :max="Number(randomSelectQuForm.levels[1].quCount)"
              :min="0"
              :style="{ width: '200px' }"
              :default-value="0"
              mode="button"
            />
            题/共
            <span>
              {{ classfiyResult.hardCount }}
            </span>
            题
          </a-space>
        </a-space>
      </template>
      <!--  指定选题-->
      <template v-if="updatePaperForm.joinType === 1">
        <div style="width: 750px">
          <a-space>
            <a-select
              v-model="appointSelectQuForm.repoId"
              :style="{ width: '320px' }"
              placeholder="选择题库"
              @change="appointFormChange"
            >
              <a-option
                v-for="repo in repoList"
                :key="repo.id"
                :value="repo.id"
                :label="repo.title"
              />
            </a-select>
            <a-input
              v-model="appointSelectQuForm.contentFuzzy"
              placeholder="试题内容"
              @input="appointFormChange"
            />
            <a-input
              :placeholder="
                getQuestionTypeName(Number(appointSelectQuForm.quType))
              "
              disabled
              @input="appointFormChange"
            />
          </a-space>

          <!--表格使用v-if销毁-->
          <a-table
            v-if="addTypeVisible === true"
            ref="tableRef"
            :table-layout-fixed="true"
            row-key="id"
            style="margin-top: 20px"
            :data="quList"
            :columns="quColumns"
            :row-selection="{
              type: 'checkbox',
            }"
            @select="quTableRowSelect"
          >
            <template #quType="{ record }">
              {{ getQuestionTypeName(Number(record.quType)) }}
            </template>
            <template #level="{ record }">
              <template v-if="record.level === 1">困难</template>
              <template v-if="record.level === 0">简单</template>
            </template>
          </a-table>
        </div>
      </template>
    </a-modal>
  </div>
</template>

<script lang="ts" setup>
  import { IconCheckCircleFill } from '@arco-design/web-vue/es/icon';
  import BookMark from '@/components/bookMark/index.vue';
  import { onMounted, ref, toRaw, watch } from 'vue';
  import { Repo } from '@/types/model/po/Repo';
  import { classifyByQuType, getRepoList } from '@/api/repo';

  import { AddPaperDTO } from '@/types/model/dto/AddPaperDTO';
  import { QuestionType } from '@/types/model/QuestionType';
  import { AddGroupListDTO } from '@/types/model/dto/AddGroupListDTO';
  import { useRoute, useRouter } from 'vue-router';
  import { RandomSelectQuDTO } from '@/types/model/dto/RandomSelectQuDTO';
  import { getExluceQuDetailList, randomSelectQu } from '@/api/qu';
  import { Qu } from '@/types/model/po/Qu';
  import { Message } from '@arco-design/web-vue';
  import { TableColumnData } from '@arco-design/web-vue/es/table/interface';
  import { useI18n } from 'vue-i18n';

  import { QuExcludeQuery } from '@/types/model/query/QuExcludeQuery';
  import { QuAndAnswerVO } from '@/types/model/vo/QuAndAnswerVO';
  import { getPaperDetail, updatePaperById } from '@/api/paper';
  import { DepartmentTreeVO } from '@/types/model/vo/DepartmentTreeVO';
  import { getDeptTree } from '@/api/department';
  import { RepoQuery } from '@/types/model/query/RepoQuery';
  import { getQuestionTypeName } from '../../../utils/common';

  const { t } = useI18n();

  const route = useRoute();
  const router = useRouter();

  // 题库列表
  const repoList = ref<Repo[]>();

  // 部门树
  const deptTree = ref<DepartmentTreeVO[]>([]);

  // 题目列表
  const quList = ref<Qu[]>();

  // 大题是否追加标志
  const isAdditional = ref<boolean>(false);
  // 追加大题下标
  const additionalIndex = ref<number>();
  // 表格引用
  const tableRef = ref();

  // 添加试卷表单
  const updatePaperForm = ref<AddPaperDTO>({
    groupLists: [],
  });
  // 添加大题的表单
  const groupList = ref<AddGroupListDTO>({
    totalScore: 0,
    perScore: 0,
    itemRand: 0,
    quRand: 0,
    quCount: 0,
    quList: [],
  });

  // 生成大题对象
  const generateGroupList = () => {
    return { ...groupList.value };
  };

  // 随机抽取题目查询表单
  const randomSelectQuForm = ref<RandomSelectQuDTO>({
    excludes: [],
    repoId: '',
    levels: [
      { level: '0', num: 0, quCount: '' },
      { level: '1', num: 0, quCount: '' },
    ],
    quType: 0,
  });

  // 指定选题查询表单
  const appointSelectQuForm = ref<QuExcludeQuery>({
    excludes: [],
  });

  // 问题列表列
  const quColumns = ref<TableColumnData[]>([
    {
      title: t('quManager.columns.quType'),
      dataIndex: 'quType',
      slotName: 'quType',
      width: 100,
    },
    {
      title: t('quManager.columns.content'),
      dataIndex: 'content',
      slotName: 'content',
      width: 150,
      ellipsis: true,
    },
    {
      title: t('quManager.columns.repoText'),
      dataIndex: 'repoText',
      slotName: 'repoText',
      width: 100,
    },
    {
      title: t('quManager.columns.level'),
      dataIndex: 'level',
      slotName: 'level',
      width: 100,
    },
  ]);

  onMounted(async () => {
    await getRepoList({} as RepoQuery).then((res: any) => {
      repoList.value = res.data.list;
    });
    const paperId = route.query.id;
    if (!paperId) {
      router.back();
    }
    await getPaperDetail(paperId as string).then((res: any) => {
      updatePaperForm.value = res.data;
    });

    await getDeptTree().then((res: any) => {
      deptTree.value = res.data;
    });
  });

  // 分类对象
  const classfiyResult = ref({});

  // 选择题库下拉框发生改变时触发(随机抽取)
  const handleSelectChange = async () => {
    // 获取分类题数
    await classifyByQuType(
      randomSelectQuForm.value.repoId,
      randomSelectQuForm.value.quType
    ).then((res: any) => {
      classfiyResult.value = res.data;
      // 给抽题表单赋值
      randomSelectQuForm.value.levels[0].quCount = res.data.easyCount;
      randomSelectQuForm.value.levels[1].quCount = res.data.hardCount;
    });
  };

  // 添加新的大题模态框开关
  const addTypeVisible = ref(false);

  // 添加题目
  const addItem = async (type: number, index: number) => {
    addTypeVisible.value = true;
    if (updatePaperForm.value.joinType === 0) {
      // 给获取大题表单题型赋值（因为之前被清空）
      randomSelectQuForm.value.quType = type;
      // 重新获取原来选中题库的分类数据
      await handleSelectChange();
    } else if (updatePaperForm.value.joinType === 1) {
      appointSelectQuForm.value.quType = type;
      await getExluceQuDetailList(appointSelectQuForm.value).then(
        (res: any) => {
          quList.value = res.data;
        }
      );
    }
    // 修改追加标志
    isAdditional.value = true;
    // 给追加的大题下标赋值
    additionalIndex.value = index;
  };

  // 选择添加的大题类型
  const dropDownSelect = async (type: number) => {
    addTypeVisible.value = true;
    if (updatePaperForm.value.joinType === 0) {
      randomSelectQuForm.value.quType = type;
      // 获取原来选定题库的题目分类
      if (randomSelectQuForm.value.repoId) {
        // 只有以前选过题库才可以获取
        await handleSelectChange();
      }
    } else if (updatePaperForm.value.joinType === 1) {
      // 对于指定选题，初始化应该加载全部题库的题目
      appointSelectQuForm.value.quType = type;
      await getExluceQuDetailList(appointSelectQuForm.value).then(
        (res: any) => {
          quList.value = res.data;
        }
      );
    }
  };

  // 确认删除对应大题
  const confirmDelete = (type: number, index: number) => {
    updatePaperForm.value.groupLists?.forEach(
      (item: AddGroupListDTO, subScript: number) => {
        if (item.quType === type && subScript === index) {
          // 删除大题
          updatePaperForm.value.groupLists?.splice(index, 1);
        }
      }
    );
  };

  // 取消删除对应大题
  const cancelDelete = (type: string) => {};

  // 排序下移
  const sortDown = (group: AddGroupListDTO) => {
    // 先移除最后一个元素
    const lastEle = group.quList?.pop();
    // 将第一个元素添加到第一个位置
    if (lastEle) {
      group.quList?.unshift(lastEle);
    }
  };

  // 排序上移
  const sortUp = (group: AddGroupListDTO) => {
    // 先移除第一个元素
    const firstEle = group.quList?.shift();
    // 将第一个元素添加到第一个位置
    if (firstEle) {
      group.quList?.push(firstEle);
    }
  };

  // 移除题目
  const removeItem = (type: number, index: number) => {
    updatePaperForm.value.groupLists?.forEach((group: AddGroupListDTO) => {
      group.quList?.forEach((qu: Qu, subScript: number) => {
        if (qu.quType === type && index === subScript) {
          group.quList?.splice(index, 1);
        }
      });
    });
  };

  // 左侧分数修改框触发
  const inputScoreChange = (value: number, index: number) => {
    updatePaperForm.value.groupLists?.forEach(
      (grop: AddGroupListDTO, subscript: number) => {
        if (subscript === index) {
          // 设置每个大题的perScore
          grop.perScore = value;
          grop.quList?.forEach((qu: Qu) => {
            qu.score = value;
          });
        }
      }
    );
  };

  // 复选框改变触发
  const checkBoxChange = (
    val: number,
    group: AddGroupListDTO,
    type: string
  ) => {
    if (type === 'itemRand') {
      group.itemRand = Number(val);
    }

    if (type === 'quRand') {
      group.quRand = Number(val);
    }
  };

  // 指定选题题目搜索表单
  const appointFormChange = async () => {
    await getExluceQuDetailList(appointSelectQuForm.value).then((res: any) => {
      quList.value = res.data;
    });
  };

  // 临时存储大题变量（配合指定选题使用）
  let tempGroup: AddGroupListDTO | undefined;

  // 问题列表行被选择时触发
  const quTableRowSelect = (
    rowKeys: any,
    rowKey: any,
    record: AddGroupListDTO
  ) => {
    if (!tempGroup) {
      tempGroup = generateGroupList();
    }
    tempGroup.quList?.push(toRaw(record) as AddGroupListDTO);
    tempGroup.quType = appointSelectQuForm.value.quType;
    // 遍历临时大题题目列表，不再rowKeys里边的直接移除
    tempGroup.quList?.forEach((qu: QuAndAnswerVO, index: number) => {
      if (!rowKeys.includes(qu.id)) {
        tempGroup?.quList?.splice(index, 1);
      }
    });

    tempGroup.title = getQuestionTypeName(
      Number(appointSelectQuForm.value.quType)
    );
    tempGroup.quCount = rowKeys.length;
  };

  // 确认添加大题
  const confirmAdd = async () => {
    if (updatePaperForm.value.joinType === 0) {
      // 发送题库，题型，抽取数量
      await randomSelectQu(randomSelectQuForm.value).then((res: any) => {
        if (isAdditional.value) {
          // 追加
          updatePaperForm.value.groupLists?.forEach(
            (group: AddGroupListDTO, index: number) => {
              if (index === additionalIndex.value) {
                group.quList = group.quList?.concat(res.data);
              }
            }
          );

          // 追加标志置为false
          isAdditional.value = false;
        } else {
          // 新增
          // 创建大题
          const group = generateGroupList();
          group.quType = randomSelectQuForm.value.quType;
          group.title = getQuestionTypeName(
            Number(randomSelectQuForm.value.quType)
          );
          group.quCount = res.data.length;
          group.quList = res.data;

          // 将大题添加进addPaperForm
          updatePaperForm.value.groupLists?.push(group);
        }

        // 重置抽题表单
        randomSelectQuForm.value = {
          excludes: [],
          repoId: randomSelectQuForm.value.repoId,
          levels: [
            { level: '0', num: 0, quCount: '' },
            { level: '1', num: 0, quCount: '' },
          ],
          quType: 0,
        };
      });
    } else if (updatePaperForm.value.joinType === 1) {
      // 重新加载题目列表（因为table使用v-if销毁了）
      await getExluceQuDetailList(appointSelectQuForm.value).then(
        (res: any) => {
          quList.value = res.data;
        }
      );
      if (isAdditional.value) {
        // 追加
        updatePaperForm.value.groupLists?.forEach(
          (group: AddGroupListDTO, index: number) => {
            if (index === additionalIndex.value) {
              group.quList = group.quList?.concat(
                // todo 待处理
                tempGroup?.quList as unknown as QuAndAnswerVO
              );
            }
          }
        );

        // 追加标志置为false
        isAdditional.value = false;
      } else {
        // 新增
        // 将大题添加进addPaperForm
        updatePaperForm.value.groupLists?.push(tempGroup as AddGroupListDTO);
      }
      // 重置临时大题
      tempGroup = {
        totalScore: 0,
        perScore: 0,
        itemRand: 0,
        quRand: 0,
        quCount: 0,
        quList: [],
      };
    }
    addTypeVisible.value = false;
  };

  // 取消添加大题
  const cancelAdd = () => {
    addTypeVisible.value = false;
  };

  // 保存试卷
  const updatePaper = async () => {
    try {
      // 先判断是否符合要求
      if ((updatePaperForm.value.quCount as number) <= 0) {
        Message.warning({
          content: '试卷总分应大于0',
        });
        throw new Error('EndIterative');
      }

      // 判断每个题目的分数
      // eslint-disable-next-line array-callback-return
      updatePaperForm.value.groupLists?.some((group: AddGroupListDTO) => {
        if (!group || (group.totalScore as number) <= 0) {
          Message.warning({
            content: '大题总分应大于0',
          });
          throw new Error('EndIterative');
        }
        // eslint-disable-next-line array-callback-return
        group.quList?.some((qu: Qu) => {
          if ((qu.score as number) <= 0) {
            Message.warning({
              content: `${qu.content}的分数应该大于0`,
            });
            throw new Error('EndIterative');
          }
        });
      });
      // 通过，发送请求
      await updatePaperById({
        addPaperDTO: updatePaperForm.value,
        id: updatePaperForm.value.id,
      }).then((res: any) => {
        if (res.data === true) {
          Message.success({
            content: '更新成功',
          });
          router.back();
        } else {
          Message.error({
            content: '更新失败',
          });
        }
      });
    } catch (error) {
      console.log('失败');
    }
  };

  // 监听每道题
  watch(
    updatePaperForm,
    (newData: any, oldData: any) => {
      let questionCount = 0; // 总题数
      let score = 0; // 分数
      randomSelectQuForm.value.excludes = []; // 重置排除列表(随机组题)
      appointSelectQuForm.value.excludes = []; // 重置排除列表(指定选题)
      // 遍历大题
      newData.groupLists.forEach((group: AddGroupListDTO) => {
        let quScore = 0; // 每个大题总分统计
        let quCount = 0; // 每个大题的总数
        // 遍历大题中的每个题目
        group.quList?.forEach((qu: Qu) => {
          randomSelectQuForm.value.excludes.push(qu.id as string);
          appointSelectQuForm.value.excludes.push(qu.id as string);
          quScore += qu.score as number;
          score += qu.score as number;
          questionCount += 1;
          quCount += 1;
        });
        group.totalScore = quScore;
        group.quCount = quCount;
      });
      updatePaperForm.value.totalCount = score;
      updatePaperForm.value.quCount = questionCount;
    },
    {
      deep: true,
      immediate: true,
    }
  );
</script>

<style scoped></style>
