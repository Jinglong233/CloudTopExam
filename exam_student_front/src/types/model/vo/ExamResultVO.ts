export interface ExamResultVO {
  /**
   * 是否需要阅卷
   */
  reviewQuire?: number;

  /**
   * 得分
   */
  totalScore?: number;

  /**
   * 是否已经处理
   */
  isHandle?: number;
}
