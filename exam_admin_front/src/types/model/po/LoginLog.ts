export interface LoginLog {
  /**
   * ID
   */
  id?: number;

  /**
   * 登录用户名
   */
  userName?: string;

  /**
   * 用户IP
   */
  ip?: string;

  /**
   * 登录状态
   */
  loginState?: number;

  /**
   * 登录时间
   */
  loginTime?: Date;

  /**
   * 操作信息
   */
  operMsg?: string;

  /**
   * 登录地址
   */
  loginAddress?: string;
}
