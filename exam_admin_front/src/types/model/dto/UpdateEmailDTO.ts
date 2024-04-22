export interface UpdateEmailDTO {
  /**
   * 用户Id
   */
  userId?: string;

  /**
   * 邮箱
   */
  email?: string;

  /**
   * 验证码
   */
  code?: string;
}
