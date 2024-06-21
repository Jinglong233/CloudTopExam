import BaseQuery from '@/types/model/query/BaseQuery';

class MsgQuery extends BaseQuery {
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
   * 消息类型
   */
  msgType?: number;

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

  /**
   * 发送人Id
   */
  createUser?: string;

  createUserFuzzy?: string;

  /**
   * 发送人姓名
   */
  createUserText?: string;

  createUserTextFuzzy?: string;

  orderBy = 'send_time';
}
export default MsgQuery;
