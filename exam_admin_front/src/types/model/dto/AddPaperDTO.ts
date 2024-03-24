import { AddGroupListDTO } from './AddGroupListDTO';

export interface AddPaperDTO {
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
   * 大题列表
   */
  groupLists?: AddGroupListDTO[];
}
