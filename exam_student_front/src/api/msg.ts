import axios from 'axios';
import { MsgUserQuery } from '@/types/model/query/MsgUserQuery';
import { MsgVO } from '@/types/model/vo/MsgVO';
import { MsgUser } from '@/types/model/po/MsgUser';
import { SimplePage } from '@/types/model/po/SimplePage';
import { Msg } from '@/types/model/po/Msg';
import { UpdateMsgUserDTo } from '@/types/model/dto/UpdateMsgUserDTo';

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
export function getMyUnreadMsgCount() {
  return axios.get<number>('/api/msgUser/getMyUnreadCount');
}

/**
 * 获取通知
 */
export function getNotification(simplePage: SimplePage) {
  return axios.post<MsgVO[]>('/api/msgUser/getNotification', simplePage);
}

/**
 * 获取未读通知
 */
export function getUnReadNotification(simplePage: SimplePage) {
  return axios.post<MsgVO[]>('/api/msgUser/getUnReadNotification', simplePage);
}

/**
 * 获取已读通知
 */
export function getReadNotification(simplePage: SimplePage) {
  return axios.post<MsgVO[]>('/api/msgUser/getReadNotification', simplePage);
}

/**
 * 获取公告
 */
export function getAnnouncement() {
  return axios.post<Msg[]>('/api/msgUser/getAnnouncement');
}
/**
 * 批量更新
 * @param msgUsers
 */
export function addOrUpdateBatch(msgUsers: MsgUser[]) {
  return axios.post<boolean>('/api/msgUser/addOrUpdateBatch', msgUsers);
}

export function updateMsgUserById(updateMsgUserDTo: UpdateMsgUserDTo) {
  return axios.post<boolean>(
    '/api/msgUser/updateMsgUserById',
    updateMsgUserDTo
  );
}
