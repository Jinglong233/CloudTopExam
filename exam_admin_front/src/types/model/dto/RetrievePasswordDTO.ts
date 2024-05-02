export interface RetrievePasswordDTO {
  /**
   * 用户名
   */
  userName?: string;
  /**
   * 邮箱
   */
  email?: string;
  /**
   * 验证码正确之后，该字段用于接收新密码
   */
  password?: string;
}
