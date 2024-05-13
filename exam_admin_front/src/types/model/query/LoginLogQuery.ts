import { SimplePage } from '@/types/model/po/SimplePage';

export interface LoginLogQuery extends SimplePage {
  /**
   * ID
   */
  id?: number;

  /**
   * 登录用户名
   */
  userName?: string;

  userNameFuzzy?: string;

  /**
   * 用户IP
   */
  ip?: string;

  ipFuzzy?: string;

  /**
   * 登录状态
   */
  loginState?: number;

  /**
   * 登录时间
   */
  loginTime?: Date;

  loginTimeStart?: string;

  loginTimeEnd?: string;

  /**
   * 操作信息
   */
  operMsg?: string;

  operMsgFuzzy?: string;

  /**
   * 登录地址
   */
  loginAddress?: string;

  loginAddressFuzzy?: string;
}
