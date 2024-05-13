export interface OperLog {
  /**
   * ID
   */
  id?: number;

  /**
   * 操作人员名称
   */
  userName?: string;

  /**
   * 请求地址
   */
  url?: string;

  /**
   * 用户IP
   */
  ip?: string;

  /**
   * 操作地点
   */
  operAddress?: string;

  /**
   * 是否成功
   */
  success?: number;

  /**
   * 操作时间
   */
  operTime?: Date;

  /**
   * 请求方式（get、post...）
   */
  requestMode?: string;

  /**
   * 操作方法（哪个方法处理的）
   */
  operationMethod?: string;

  /**
   * 请求参数
   */
  requestArg?: string;

  /**
   * 返回参数
   */
  returnArg?: string;

  /**
   * 操作类型（增删改查...）
   */
  operType?: number;
}
