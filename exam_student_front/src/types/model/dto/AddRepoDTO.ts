export interface AddRepoDTO {
  /**
   * 题库标题
   */
  title?: string;
  /**
   * 部门编码（专业）
   */
  deptCode?: string;


  /**
   * 学科ID
   */
  subjectId?: string;

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
   * 创建者
   */
  createBy?:string;
}
