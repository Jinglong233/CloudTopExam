export interface TrainRecord {
  /**
   * ID
   */
  id?: string;

  /**
   * 题目ID
   */
  quId?: string;

  /**
   * 训练ID
   */
  trainId?: string;

  /**
   * 回答是否正确
   */
  isRight?: number;

  /**
   * 答案ID
   */
  answerId?: string;

  /**
   * 是否回答0:未答1:已答
   */
  answered?: number;

  /**
   * 主观题的答案（预留）
   */
  answer?: string;

  /**
   * 题目的排序
   */
  sort?: number;
}
