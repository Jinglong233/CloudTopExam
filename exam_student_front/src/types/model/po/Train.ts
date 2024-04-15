export interface Train {
  /**
   * ID
   */

  id?: string;

  /**
   * 题库ID
   */

  repoId?: string;

  /**
   * 回答数量
   */

  answerCount?: number;

  /**
   * 正确数量
   */

  rightCount?: number;

  /**
   * 总题目数量
   */

  totalCount?: number;

  /**
   * 训练者
   */

  userId?: string;

  /**
   * 训练模式
   */

  mode?: number;

  /**
   * 训练进度
   */

  percent?: string;

  /**
   * 状态 0:未完成1:完成
   */

  state?: number;

  /**
   * 最近训练时间
   */
  trainTime?: Date;

  /**
   * 题型（mode为3的时候需要）
   */

  quType?: number;
}
