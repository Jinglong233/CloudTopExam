export interface Repo {
  /**
   * ID
   */
  id?: string;

  /**
   * 部门编码（专业）
   */
  deptCode?: string;

  /**
   * 部门名称
   */
  deptText?: string;

  /**
   * 学科ID
   */
  subjectId?: string;
  /**
   * 学科名称
   */
  subjectText?: string;
  /**
   * 总题数
   */
  totalCount?: number;

  /**
   * 主观题数
   */
  subCount?: number;

  /**
   * 客观题数
   */
  objCount?: number;

  /**
   * 题库标题
   */
  title?: string;

  /**
   * 是否用于考试
   */
  isExam?: number;

  /**
   * 是否用于训练
   */
  isTrain?: number;

  /**
   * 备注
   */
  remark?: string;

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
