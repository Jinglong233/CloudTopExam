import axios from 'axios';
import { MsgUserQuery } from '@/types/model/query/MsgUserQuery';
import { MsgVO } from '@/types/model/vo/MsgVO';
import { MsgUser } from '@/types/model/po/MsgUser';

// eslint-disable-next-line import/prefer-default-export
/**
 * 获取对应用户的信息列表
 * @param userId
 */
export function loadMyMsgList(msgUserQuery: MsgUserQuery) {
  return axios.post<MsgVO[]>('/api/msgUser/loadDataList', msgUserQuery);
}

/**
 * 获取用户未读信息总数
 * @param msgUserQuery
 */
export function getMyUnreadMsgCount(msgUserQuery: MsgUserQuery) {
  return axios.post<number>('/api/msgUser/getMyUnreadCount', msgUserQuery);
}

/**
 * 批量更新
 * @param msgUsers
 */
export function addOrUpdateBatch(msgUsers: MsgUser[]) {
  return axios.post<boolean>('/api/msgUser/addOrUpdateBatch', msgUsers);
}
