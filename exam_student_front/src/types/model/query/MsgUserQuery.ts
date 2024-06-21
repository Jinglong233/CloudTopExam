import BaseQuery from '@/types/model/query/BaseQuery';

class MsgUserQuery extends BaseQuery {
  /**
   * ID
   */
  id?: string;

  idFuzzy?: string;

  /**
   * 消息ID
   */
  msgId?: string;

  msgIdFuzzy?: string;

  /**
   * 用户ID
   */
  userId?: string;

  userIdFuzzy?: string;

  /**
   * 状态：-1异常 0未读 1已读
   */
  state?: number;
}
export default MsgUserQuery;
