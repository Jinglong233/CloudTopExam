import LoginLogQuery from '@/types/model/query/LoginLogQuery';
import axios from 'axios';
import { LoginLog } from '@/types/model/po/LoginLog';
import OperLogQuery from '@/types/model/query/OperLogQuery';

/**
 * 获取登录日志
 * @param loginLogQuery
 */
// eslint-disable-next-line import/prefer-default-export
export function getLoginLogList(loginLogQuery: LoginLogQuery) {
  return axios.post<LoginLog[]>('/api/loginLog/loadDataList', loginLogQuery);
}

/**
 * 批量删除登录日志
 * @param deleteList
 */
export function deleteBatchLoginLog(deleteList: number[]) {
  return axios.post<boolean>(
    '/api/loginLog/deleteBatch',
    JSON.stringify(deleteList),
    {
      headers: {
        'Content-Type': 'application/json', // 设置请求头为 JSON 格式
      },
    }
  );
}

/**
 * 获取操作日志
 * @param operLogQuery
 */
export function getOperationLogList(operLogQuery: OperLogQuery) {
  return axios.post<LoginLog[]>('/api/operLog/loadDataList', operLogQuery);
}

/**
 * 批量删除操作日志
 * @param deleteList
 */
export function deleteBatchOperLog(deleteList: number[]) {
  return axios.post<boolean>('/api/loginLog/loadDataList', deleteList);
}
