import { QuestionType } from '@/types/model/QuestionType';

// 将数字映射成A,B,C
// eslint-disable-next-line import/prefer-default-export
export function numberToChar(index: number) {
  return String.fromCharCode(65 + index);
}

/**
 * 根据类型来筛选对应题目的数量
 * @param list 题目管理
 * @return 排序之后的题目列表
 */
export function topicClassify(list: any[]) {
  const resultMap: any = new Map();
  list.forEach((item: any) => {
    if (!resultMap.has(item.questionType)) {
      resultMap.set(item.questionType, []);
    }
    resultMap.get(item.questionType).push(item);
  });

  // 将 Map 的键值对转化为数组
  const sortedArray: any = Array.from(resultMap.entries()).sort(
    (a: any, b: any) => a[0] - b[0]
  );

  // 创建一个新的 Map 来存储排序后的键值对
  const sortedMap = new Map(sortedArray);
  return sortedMap;
}

/**
 * 统计分数
 * @param arr
 */
export function computeScore(arr: any[]) {
  let count: any = 0;
  arr.forEach((item: any) => {
    count += item.score;
  });
  return count;
}

/**
 * 获取类型映射
 */
export function getQuestionTypeName(type: number) {
  const map = new Map();
  map.set(QuestionType.SINGLECHOICE, '单选题');
  map.set(QuestionType.MULTIPLECHOICE, '多选题');
  map.set(QuestionType.JUDGING, '判断题');
  map.set(QuestionType.GAPFILLING, '填空题');
  map.set(QuestionType.SHORTANSWER, '简答题');
  return map.get(type);
}

/**
 * 获取类型映射(用于数量统计的类型)
 */
export function getQuestionNoun(type: number) {
  const map = new Map();
  map.set(QuestionType.SINGLECHOICE, '单选题');
  map.set(QuestionType.MULTIPLECHOICE, '多选题');
  map.set(QuestionType.JUDGING, '判断题');
  map.set(QuestionType.GAPFILLING, '填空题');
  map.set(QuestionType.SHORTANSWER, '简答题');
  return map.get(type);
}

/**
 * 锚点滚动
 */
export function clickAnchor(id: any) {
  document.getElementById(id)?.scrollIntoView({ behavior: 'smooth' });
}

/**
 * 数组对象根据属性值移除对象
 * @param arr 移除对象的数组
 * @param targetProperty 目标属性名
 * @param targetValue 目标属性值
 * @return 移除指定属性值的新数组
 */
export function removeObjByProperty(
  arr: object[],
  targetProperty: string,
  targetValue: any
) {
  const temp = arr.filter((obj: any) => obj[targetProperty] !== targetValue);
  // 转换代理对象为普通数组
  return temp.map((obj: any) => ({ ...obj }));
}

/**
 * 隐藏邮箱
 * @param email
 */
export function maskEmail(email: string) {
  if (!email) {
    return '';
  }
  const [localPart, domain] = email.split('@');
  const maskedLocalPart =
    localPart.slice(0, 2) +
    '*'.repeat(Math.max(0, localPart.length - 4)) +
    localPart.slice(-2);
  return `${maskedLocalPart}@${domain}`;
}
