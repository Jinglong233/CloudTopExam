export interface User {
  /**
   * ID
   */
  id?: string;

  /**
   * 用户名
   */
  userName?: string;

  /**
   * 头像
   */
  avatar?: string;

  /**
   * 邮箱
   */
  email?: string;

  /**
   * 部门编号
   */
  deptCode?: string;
  /**
   * 部门名称
   */
  deptText?: string;

  /**
   * 状态
   */
  state?: number;

  /**
   * 性别
   */
  sex?: number;

  /**
   * 手机
   */
  phone?: string;

  /**
   * 密码
   */
  password?: string;

  /**
   * 盐值
   */
  salt?: string;

  /**
   * 真实姓名
   */
  realName?: string;

  /**
   * 角色
   */
  role?: string;

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
