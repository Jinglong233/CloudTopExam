import { LoginLogQuery } from '@/types/model/query/LoginLogQuery';
import axios from 'axios';
import { LoginLog } from '@/types/model/po/LoginLog';
import { OperLogQuery } from '@/types/model/query/OperLogQuery';

/**
 * 获取登录日志
 * @param loginLogQuery
 */
// eslint-disable-next-line import/prefer-default-export
export function getLoginLogList(loginLogQuery: LoginLogQuery) {
  return axios.post<LoginLog[]>('/api/loginLog/loadDataList', loginLogQuery);
}

/**
 * 获取操作日志
 * @param operLogQuery
 */
export function getOperationLogList(operLogQuery: OperLogQuery) {
  return axios.post<LoginLog[]>('/api/operLog/loadDataList', operLogQuery);
}
