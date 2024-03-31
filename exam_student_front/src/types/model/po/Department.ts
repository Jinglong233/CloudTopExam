export interface Department {
  /**
   * ID
   */
  id?: string;

  /**
   * 上层部门code
   */
  parentCode?: string;

  /**
   * 部门编码
   */
  deptCode?: string;

  /**
   * 部门层级
   */
  deptLevel?: number;

  /**
   * 部门类型（预留）
   */
  deptType?: string;

  /**
   * 部门名称
   */
  deptName?: string;

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

  /**
   * 备注
   */
  remark?: string;

  /**
   * 排序
   */
  sort?: number;

}
