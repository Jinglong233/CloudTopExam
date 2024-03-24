export interface SubjectTreeVO {
  /**
   * ID
   */
  id?: string;

  /**
   * 父Id
   */
  parentId?: string;

  /**
   * 学科名称
   */
  title?: string;

  /**
   * 所属部门
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

  /**
   * 备注
   */
  description?: string;

  /**
   * 子列表
   */
  children?: SubjectTreeVO[];
}
