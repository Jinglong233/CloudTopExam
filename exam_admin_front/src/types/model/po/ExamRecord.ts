export interface ExamRecord {
  /**
   * ID
   */
  id?: string;

  /**
   * 考试ID
   */
  examId?: string;

  /**
   * 用户ID
   */
  userId?: string;

  /**
   * 是否通过0:否1:是
   */
  passed?: number;

  /**
   * 得分
   */
  totalScore?: number;

  /**
   * 阅卷人
   */
  reviewUser?: string;

  /**
   * 阅卷评语
   */
  reviewMsg?: string;

  /**
   * 异常状态
   */
  exState?: number;

  /**
   * 异常信息
   */
  exMsg?: string;

  /**
   * 处理状态0:未处理1:已处理
   */
  handState?: number;

  /**
   * 阅卷时间
   */
  reviewTime?: Date;

  /**
   * 开始答卷时间
   */
  startTime?: Date;

  /**
   * 结束答卷时间
   */
  endTime?: Date;

  /**
   * 作答状态0:未作答1:未完成2:已交卷
   */
  state?: number;
}
