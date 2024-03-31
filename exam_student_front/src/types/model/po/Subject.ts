export interface Subject {
  /**
   * ID
   */
  id?: string;

  /**
   * 学科名称
   */
  title?: string;

  /**
   * 描述/备注
   */
  description?: string;

  /**
   * 上层学科ID
   */
  parentId?: string;

  /**
   * 所属部门（专业）
   */
  deptCode?: string;

  /**
   * 所属部门名称
   */
  deptText?: string;

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
