export interface MsgUser {
  /**
   * ID
   */
  id?: string;

  /**
   * 消息ID
   */
  msgId?: string;

  /**
   * 用户ID
   */
  userId?: string;

  /**
   * 状态：-1异常 0未读 1已读
   */
  state?: number;
}
