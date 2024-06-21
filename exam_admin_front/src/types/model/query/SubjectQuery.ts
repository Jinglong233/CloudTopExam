import BaseQuery from '@/types/model/query/BaseQuery';

class SubjectQuery extends BaseQuery {
  /**
   * ID
   */
  id?: string;

  idFuzzy?: string;

  /**
   * 学科名称
   */
  title?: string;

  titleFuzzy?: string;

  /**
   * 描述/备注
   */
  description?: string;

  descriptionFuzzy?: string;

  /**
   * 上层学科ID
   */
  parentId?: string;

  parentIdFuzzy?: string;

  /**
   * 所属部门（专业）
   */
  deptCode?: string;

  deptCodeFuzzy?: string;

  /**
   * 部门名称
   */
  deptText?: string;

  deptTextFuzzy?: string;

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
}
export default SubjectQuery;
