class Exam {
  /**
   * ID
   */
  id?: string;

  /**
   * 试卷ID
   */
  paperId?: string;

  /**
   * 考试标题
   */
  title?: string;

  /**
   * 考试部门编码
   */
  deptCode?: string;

  /**
   * 考试部门名称
   */
  deptText?: string;

  /**
   * 考试开始时间
   */
  startTime?: Date;

  /**
   * 考试结束时间
   */
  endTime?: Date;

  /**
   * 考试状态 0:未开始1:已开始2:已结束
   */
  statue?: number;

  /**
   * 开放权限 0:完全公开 1:指定学生
   */
  openType?: number;

  /**
   * 考试时长
   */
  duration?: number;

  /**
   * 感谢语
   */
  thanks?: string;

  /**
   * 允许迟到时间
   */
  lateMax?: number;

  /**
   * 最少答题时间
   */
  handMin?: number;

  /**
   * 结果显示类型（只显示分数/显示分数+答题详情）
   */
  resultType?: number;

  /**
   * 及格分数
   */
  qualifyScore?: number;

  /**
   * 是否需要阅卷0:不需要1:需要
   */
  reviewQuire?: number;

  /**
   * 创建时间
   */
  createTime?: Date;

  /**
   * 创建者
   */
  createBy?: string;

  /**
   * 更新时间
   */
  updateTime?: Date;

  /**
   * 更新者
   */
  updateBy?: string;
}
export default Exam;
