import BaseQuery from '@/types/model/query/BaseQuery';

class PaperQuery extends BaseQuery {
  /**
   * 试卷ID
   */
  id?: string;

  idFuzzy?: string;

  /**
   * 关联学科ID
   */
  subjectId?: string;

  subjectIdFuzzy?: string;

  /**
   * 试卷标题
   */
  title?: string;

  titleFuzzy?: string;

  /**
   * 所属部门（专业）编码
   */
  deptCode?: string;

  deptCodeFuzzy?: string;

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

  createTimeStart?: string;

  createTimeEnd?: string;

  /**
   * 创建者
   */
  createBy?: string;

  createByFuzzy?: string;

  /**
   * 更新时间
   */
  updateTime?: Date;

  updateTimeStart?: string;

  updateTimeEnd?: string;

  /**
   * 更新者
   */
  updateBy?: string;

  updateByFuzzy?: string;

  orderBy = 'create_time';
}
export default PaperQuery;
