export interface AddDepartmentDTO {
  /**
   * 上层部门code
   */
  parentCode?: string;

  /**
   * 部门层级
   */
  deptLevel?: number;


  /**
   * 部门名称
   */
  deptName?: string;
}
