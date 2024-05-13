import { LoginLogQuery } from '@/types/model/query/LoginLogQuery';
import axios from 'axios';
import { LoginLog } from '@/types/model/po/LoginLog';

// eslint-disable-next-line import/prefer-default-export
export function getLoginLogList(loginLogQuery: LoginLogQuery) {
  return axios.post<LoginLog[]>('/api/loginLog/loadDataList', loginLogQuery);
}
