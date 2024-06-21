import BaseQuery from '@/types/model/query/BaseQuery';

class ClassQuery extends BaseQuery {
  /**
   * ID
   */
  id?: string;

  idFuzzy?: string;

  /**
   * 1公司2部门
   */
  deptType?: number;

  /**
   * 所属年级（预留）
   */
  parentId?: string;

  parentIdFuzzy?: string;

  /**
   * 班级名称
   */
  className?: string;

  classNameFuzzy?: string;

  /**
   * 班级编码
   */
  classCode?: string;

  classCodeFuzzy?: string;

  /**
   * 排序
   */
  sort?: number;
}

export default ClassQuery;
