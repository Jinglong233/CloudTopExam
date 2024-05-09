export interface Msg {
  /**
   * ID
   */
  id?: string;

  /**
   * 模板ID
   */
  templId?: string;

  /**
   * 标题
   */
  title?: string;

  /**
   * 消息内容
   */
  content?: string;

  /**
   * 消息类型
   */
  msgType?: number;

  /**
   * 发送人数
   */
  sendCount?: number;

  /**
   * 已读人数
   */
  readCount?: number;

  /**
   * 发送时间
   */
  sendTime?: Date;

  /**
   * 状态
   */
  state?: number;
}
