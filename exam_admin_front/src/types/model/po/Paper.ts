export interface Paper {
  /**
   * 试卷ID
   */
  id?: string;

  /**
   * 关联学科ID
   */
  subjectId?: string;

  /**
   * 试卷标题
   */
  title?: string;

  /**
   * 所属部门（专业）编码
   */
  deptCode?: string;

  /**
   * 组卷方式0:题库抽取1:指定选题 其余预留
   */
  joinType?: number;

  /**
   * 题目总数
   */
  quCount?: number;

  /**
   * 试卷总分
   */
  totalCount?: number;

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
