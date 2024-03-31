export interface RandomSelectQuery {
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
