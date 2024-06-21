import BaseQuery from '@/types/model/query/BaseQuery';

class DepartmentQuery extends BaseQuery {
  /**
   * ID
   */
  id?: string;

  idFuzzy?: string;

  /**
   * 上层部门code
   */
  parentCode?: string;

  parentCodeFuzzy?: string;

  /**
   * 部门编码
   */
  deptCode?: string;

  deptCodeFuzzy?: string;

  /**
   * 部门层级
   */
  deptLevel?: number;

  /**
   * 部门类型（预留）
   */
  deptType?: string;

  deptTypeFuzzy?: string;

  /**
   * 部门名称
   */
  deptName?: string;

  deptNameFuzzy?: string;

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

  /**
   * 备注
   */
  remark?: string;

  remarkFuzzy?: string;

  /**
   * 排序
   */
  sort?: number;
}
export default DepartmentQuery;
