export interface StartTrainDTO {
  /**
   * 题库Id
   */
  repoId?: string;
  /**
   * 训练模式
   */
  mode?: number;

  /**
   * 题型
   */
  quType?: number;

  /**
   * 用户Id
   */
  userId?: string;

  /**
   * 开始训练时间
   */
  startTime?: Date;
}
