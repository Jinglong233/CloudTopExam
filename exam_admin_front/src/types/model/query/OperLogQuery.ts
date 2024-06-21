import BaseQuery from '@/types/model/query/BaseQuery';

class OperLogQuery extends BaseQuery {
  /**
   * ID
   */
  id?: number;

  /**
   * 操作人员名称
   */
  userName?: string;

  userNameFuzzy?: string;

  /**
   * 请求地址
   */
  url?: string;

  urlFuzzy?: string;

  /**
   * 用户IP
   */
  ip?: string;

  ipFuzzy?: string;

  /**
   * 操作地点
   */
  operAddress?: string;

  operAddressFuzzy?: string;

  /**
   * 是否成功
   */
  success?: number;

  /**
   * 操作时间
   */
  operTime?: Date;

  operTimeStart?: string;

  operTimeEnd?: string;

  /**
   * 请求方式（get、post...）
   */
  requestMode?: string;

  requestModeFuzzy?: string;

  /**
   * 操作方法（哪个方法处理的）
   */
  operationMethod?: string;

  operationMethodFuzzy?: string;

  /**
   * 请求参数
   */
  requestArg?: string;

  requestArgFuzzy?: string;

  /**
   * 返回参数
   */
  returnArg?: string;

  returnArgFuzzy?: string;

  /**
   * 操作类型（增删改查...）
   */
  operType?: number;

  orderBy = 'oper_time';
}

export default OperLogQuery;
