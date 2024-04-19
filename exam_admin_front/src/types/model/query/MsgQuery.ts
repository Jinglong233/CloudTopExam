import { SimplePage } from '@/types/model/po/SimplePage';

export interface MsgQuery extends SimplePage {
  /**
   * ID
   */
  id?: string;

  idFuzzy?: string;

  /**
   * 模板ID
   */
  templId?: string;

  templIdFuzzy?: string;

  /**
   * 标题
   */
  title?: string;

  titleFuzzy?: string;

  /**
   * 消息内容
   */
  content?: string;

  contentFuzzy?: string;

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

  sendTimeStart?: string;

  sendTimeEnd?: string;

  /**
   * 状态
   */
  state?: number;
}
