<template>
  <div class="container">
    <Breadcrumb :items="['menu.exam', 'menu.exam.addPaper']" />

    <a-layout>
      <!--左侧题目总数展示-->
      <a-affix :offset-top="80">
        <a-layout-sider :width="310" style="margin-left: 20px">
          <a-card hoverable>
            <a-scrollbar type="track" style="height: 680px; overflow: auto">
              <a-space direction="vertical" fill>
                <a-typography-text style="font-weight: bold"
                  >组卷方式：
                  <template v-if="addPaperForm.joinType === 0"
                    >抽题组卷</template
                  >
                  <template v-if="addPaperForm.joinType === 1"
                    >指定选题</template
                  >
                </a-typography-text>
                <a-typography-text style="font-weight: bold"
                  >试题总数：{{ addPaperForm.quCount || 0 }}
                </a-typography-text>
                <a-typography-text style="font-weight: bold"
                  >试卷总分：{{ addPaperForm.totalCount || 0 }}
                </a-typography-text>
                <a-button type="primary" long @click="savePaper"
                  >保存试卷</a-button
                >
              </a-space>
              <!--1.单选题 2.多选题 3.判断题 4.填空题 5.简答题-->
              <template
                v-for="(groupList, index) in addPaperForm.groupLists"
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
                    v-model="addPaperForm.title"
                    placeholder="请输入试卷名称"
                  />
                </a-form-item>

                <a-form-item :style="{ width: '600px' }" label="所属部门">
                  <a-tree-select
                    v-model="addPaperForm.deptCode"
                    placeholder="选择试卷所属部门"
                    :data="deptTree"
                    :field-names="{
                      key: 'deptCode',
                      title: 'deptName',
                      children: 'children',
                    }"
                  />
                </a-form-item>

                <a-form-item label="学科分类" :style="{ width: '600px' }">
                  <a-tree-select
                    v-model="addPaperForm.subjectId"
                    :data="subjectTree"
                    :field-names="{
                      key: 'id',
                      title: 'title',
                      children: 'children',
                    }"
                    placeholder="请选择学科"
                  ></a-tree-select>
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
          v-for="(groupList, groupIndex) in addPaperForm.groupLists"
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
          <!--<template #extra>
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
          </template>-->

          <!--题目展示部分-->
          <a-card
            v-for="(qu, index) in groupList.quList"
            :key="index"
            :bordered="false"
          >
            <!--锚点位置-->
            <div :id="`单选${index + 1}`"></div>
            <!--问题部分-->
            <a-space>
              <BookMark :number="index + 1" />
              <a-typography-text>
                <div v-html="qu.content" />
              </a-typography-text>
            </a-space>
            <a-row :gutter="10">
              <a-col :span="17">
                <!--非简答部分-->
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
                            qu.quType === QuestionType.SINGLECHOICE ||
                            qu.quType === QuestionType.MULTIPLECHOICE
                          "
                          type="primary"
                        >
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
                </template>

                <!-- 简答题 -->
                <template v-if="qu.quType === QuestionType.SHORTANSWER">
                  <a-card
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
                        <a-typography-text>
                          答案：
                          <div style="display: inline-block">
                            <div v-html="qu.analysis" />
                          </div>
                        </a-typography-text>
                      </a-space>
                    </div>
                  </a-card>
                </template>
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
      <template v-if="addPaperForm.joinType === 0">
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
              :max="randomSelectQuForm.levels[0].quCount"
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
              :max="randomSelectQuForm.levels[1].quCount"
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
      <template v-if="addPaperForm.joinType === 1">
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
          :loading="tableLoading"
          row-key="id"
          style="margin-top: 20px"
          :data="quList"
          :columns="quColumns"
          :row-selection="{
            type: 'checkbox',
            showCheckedAll: true,
          }"
          :pagination="{
            showTotal: true,
            showPageSize: true,
            total: pagination.total,
            pageSize: pagination.pageSize,
            current: pagination.pageNo,
          }"
          :scroll="{ x: 100, y: 400 }"
          span-all
          @page-change="pageChange"
          @page-size-change="pageSizeChange"
          @select="quTableRowSelect"
          @select-all="quTableRowSelectAll"
        >
          <template #quType="{ record }">
            {{ getQuestionTypeName(Number(record.quType)) }}
          </template>
          <template #level="{ record }">
            <template v-if="record.level === 1">困难</template>
            <template v-if="record.level === 0">简单</template>
          </template>
        </a-table>
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
  import AddGroupListDTO from '@/types/model/dto/AddGroupListDTO';
  import { useRoute, useRouter } from 'vue-router';
  import { RandomSelectQuDTO } from '@/types/model/dto/RandomSelectQuDTO';
  import { getExluceQuDetailList, randomSelectQu } from '@/api/qu';
  import Qu from '@/types/model/po/Qu';
  import { Message } from '@arco-design/web-vue';
  import { addPaper } from '@/api/paper';
  import { TableColumnData } from '@arco-design/web-vue/es/table/interface';
  import { useI18n } from 'vue-i18n';

  import QuExcludeQuery from '@/types/model/query/QuExcludeQuery';
  import QuAndAnswerVO from '@/types/model/vo/QuAndAnswerVO';
  import { SubjectTreeVO } from '@/types/model/vo/SubjectTreeVO';
  import { getSubjectTree } from '@/api/subject';
  import { DepartmentTreeVO } from '@/types/model/vo/DepartmentTreeVO';
  import { getDeptTree } from '@/api/department';
  import RepoQuery from '@/types/model/query/RepoQuery';
  import usePagination from '@/hooks/pagination';
  import useLoading from '@/hooks/loading';
  import { getQuestionTypeName } from '../../../utils/common';

  const { t } = useI18n();

  const route = useRoute();
  const router = useRouter();

  // 分页参数
  const { pagination, setPagination } = usePagination();

  // 题目列表加载
  const { loading: tableLoading, setLoading: tableSetLoading } = useLoading();

  // 题库列表
  const repoList = ref<Repo[]>();

  // 题目列表
  const quList = ref<Qu[]>([]);
  // 学科树
  const subjectTree = ref<SubjectTreeVO[]>([]);
  // 部门树
  const deptTree = ref<DepartmentTreeVO[]>([]);
  // 大题是否追加标志
  const isAdditional = ref<boolean>(false);
  // 追加大题下标
  const additionalIndex = ref<number>();
  // 表格引用
  const tableRef = ref();

  // 添加试卷表单
  const addPaperForm = ref<AddPaperDTO>({
    groupLists: [],
  });
  // 添加大题的表单
  const groupList = ref<AddGroupListDTO>(new AddGroupListDTO());

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
  const appointSelectQuForm = ref<QuExcludeQuery>(new QuExcludeQuery());

  // 查询题目排除列表
  const reloadExcludeQuDetailList = async (query: QuExcludeQuery) => {
    tableSetLoading(true);
    await getExluceQuDetailList(query).then((res: any) => {
      quList.value = res.data.list;
      setPagination({
        total: res.data.totalCount,
        pageSize: res.data.pageSize,
        pageNo: res.data.pageNo,
        pageTotal: res.data.pageTotal,
      });
    });
    tableSetLoading(false);
  };

  // 页码变化
  const pageChange = (pageNo: number) => {
    appointSelectQuForm.value.pageNo = pageNo;
  };
  // 每页数据量变化
  const pageSizeChange = (pageSize: number) => {
    appointSelectQuForm.value.pageSize = pageSize;
  };

  // 问题列表列
  const quColumns = ref<TableColumnData[]>([
    {
      title: t('quManager.columns.quType'),
      dataIndex: 'quType',
      slotName: 'quType',
      width: 100,
      tooltip: true,
    },
    {
      title: t('quManager.columns.content'),
      dataIndex: 'content',
      slotName: 'content',
      width: 100,
      tooltip: true,
    },
    {
      title: t('quManager.columns.repoText'),
      dataIndex: 'repoText',
      slotName: 'repoText',
      width: 100,
      tooltip: true,
    },
    {
      title: t('quManager.columns.level'),
      dataIndex: 'level',
      slotName: 'level',
      width: 100,
      tooltip: true,
    },
  ]);

  onMounted(async () => {
    await getRepoList(new RepoQuery()).then((res: any) => {
      repoList.value = res.data.list;
    });
    addPaperForm.value.joinType = Number(route.params.joinType);
    addPaperForm.value.title = route.params.title as string;
    addPaperForm.value.subjectId = route.params.subjectId as string;
    addPaperForm.value.deptCode = route.params.deptCode as string;

    await getSubjectTree().then((res: any) => {
      subjectTree.value = res.data;
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
    if (addPaperForm.value.joinType === 0) {
      // 给获取大题表单题型赋值（因为之前被清空）
      randomSelectQuForm.value.quType = type;
      // 重新获取原来选中题库的分类数据
      await handleSelectChange();
    } else if (addPaperForm.value.joinType === 1) {
      appointSelectQuForm.value.quType = type;
      await reloadExcludeQuDetailList(appointSelectQuForm.value);
    }
    // 修改追加标志
    isAdditional.value = true;
    // 给追加的大题下标赋值
    additionalIndex.value = index;
  };

  // 选择添加的大题类型
  const dropDownSelect = async (type: number) => {
    addTypeVisible.value = true;
    if (addPaperForm.value.joinType === 0) {
      randomSelectQuForm.value.quType = type;
      // 获取原来选定题库的题目分类
      if (randomSelectQuForm.value.repoId) {
        // 只有以前选过题库才可以获取
        await handleSelectChange();
      }
    } else if (addPaperForm.value.joinType === 1) {
      // 对于指定选题，初始化应该加载全部题库的题目
      appointSelectQuForm.value.quType = type;
      await reloadExcludeQuDetailList(appointSelectQuForm.value);
    }
  };

  // 确认删除对应大题
  const confirmDelete = (type: number, index: number) => {
    addPaperForm.value.groupLists?.forEach(
      (item: AddGroupListDTO, subScript: number) => {
        if (item.quType === type && subScript === index) {
          // 删除大题
          addPaperForm.value.groupLists?.splice(index, 1);
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
    addPaperForm.value.groupLists?.forEach((group: AddGroupListDTO) => {
      group.quList?.forEach((qu: Qu, subScript: number) => {
        if (qu.quType === type && index === subScript) {
          group.quList?.splice(index, 1);
        }
      });
    });
  };

  // 左侧分数修改框触发
  const inputScoreChange = (value: number, index: number) => {
    addPaperForm.value.groupLists?.forEach(
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
    await reloadExcludeQuDetailList(appointSelectQuForm.value);
  };

  // 临时存储大题变量（配合指定选题使用）
  let tempGroup = new AddGroupListDTO();

  // 题目全选
  const quTableRowSelectAll = (isAll: boolean) => {
    if (isAll === true) {
      if (!tempGroup) {
        tempGroup = generateGroupList();
      }
      tempGroup.quCount = quList.value.length;
      tempGroup.quList = [...quList.value, ...tempGroup.quList];
      tempGroup.quType = appointSelectQuForm.value.quType;
      tempGroup.title = getQuestionTypeName(
        Number(appointSelectQuForm.value.quType)
      );
    } else {
      // 重置临时大题
      tempGroup = new AddGroupListDTO();
    }
  };

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
    if (addPaperForm.value.joinType === 0) {
      // 发送题库，题型，抽取数量
      await randomSelectQu(randomSelectQuForm.value).then((res: any) => {
        if (isAdditional.value) {
          // 追加
          addPaperForm.value.groupLists?.forEach(
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
          addPaperForm.value.groupLists?.push(group);
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
    } else if (addPaperForm.value.joinType === 1) {
      // 重新加载题目列表（因为table使用v-if销毁了）
      await reloadExcludeQuDetailList(appointSelectQuForm.value);

      if (isAdditional.value) {
        // 追加
        addPaperForm.value.groupLists?.forEach(
          (group: AddGroupListDTO, index: number) => {
            if (index === additionalIndex.value) {
              group.quList = group.quList?.concat(
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
        addPaperForm.value.groupLists?.push(tempGroup as AddGroupListDTO);
      }
      // 重置临时大题
      tempGroup = new AddGroupListDTO();
    }
    console.log('addPaperForm', toRaw(addPaperForm.value));
    addTypeVisible.value = false;
  };

  // 取消添加大题
  const cancelAdd = () => {
    addTypeVisible.value = false;
    // 重置
    if (addPaperForm.value.joinType === 1) {
      tempGroup = new AddGroupListDTO();
    }
  };

  // 保存试卷
  const savePaper = async () => {
    try {
      // 先判断是否符合要求
      if ((addPaperForm.value.quCount as number) <= 0) {
        Message.warning({
          content: '试卷总分应大于0',
        });
        throw new Error('EndIterative');
      }

      // 判断每个题目的分数
      // eslint-disable-next-line array-callback-return
      addPaperForm.value.groupLists?.some((group: AddGroupListDTO) => {
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
      await addPaper(addPaperForm.value).then((res: any) => {
        if (res.data === true) {
          Message.success({
            content: '保存成功',
          });
          router.back();
        } else {
          Message.success({
            content: '保存失败',
          });
        }
      });
    } catch (error) {
      console.log('失败');
    }
  };

  // 阻断标志
  let stopWatch = false;
  // 监听模态框的开关
  watch(
    () => addTypeVisible.value,
    (newValue, oldValue) => {
      // 当模态框关闭的时候，页码都重置
      if (newValue === false) {
        stopWatch = true;
        appointSelectQuForm.value.pageNo = 1;
        appointSelectQuForm.value.pageSize = 10;
      }
      stopWatch = false;
    }
  );

  // 监视页码变化
  watch(
    () => [
      appointSelectQuForm.value.pageNo,
      appointSelectQuForm.value.pageSize,
    ],
    async (newValue, oldValue) => {
      if (!stopWatch) {
        await reloadExcludeQuDetailList(appointSelectQuForm.value);
      }
    }
  );

  // 监听每道题
  watch(
    addPaperForm.value,
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
      addPaperForm.value.totalCount = score;
      addPaperForm.value.quCount = questionCount;
    },
    {
      deep: true,
      immediate: true,
    }
  );
</script>

<style scoped></style>
