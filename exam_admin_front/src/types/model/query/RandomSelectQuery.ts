import BaseQuery from '@/types/model/query/BaseQuery';

class RandomSelectQuery extends BaseQuery {
  /**
   * 题库id
   */
  repoId?: string;

  /**
   * 随机抽取题目的数量
   */
  number?: number;

  /**
   * 题型
   */
  quType?: number;

  /**
   * 难度
   */
  level?: number;
}
export default RandomSelectQuery;
