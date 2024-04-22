import { SimplePage } from '@/types/model/po/SimplePage';

export interface MsgUserQuery extends SimplePage {
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
