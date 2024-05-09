import axios from 'axios';
import { SendMessageDTO } from '@/types/model/dto/SendMessageDTO';
import { MsgQuery } from '@/types/model/query/MsgQuery';
import { Msg } from '@/types/model/po/Msg';
import { MsgUserQuery } from '@/types/model/query/MsgUserQuery';
import { MsgUser } from '@/types/model/po/MsgUser';

// eslint-disable-next-line import/prefer-default-export
export function sendMessage(sendMessageDTO: SendMessageDTO) {
  return axios.post<boolean>('/api/msg/sendMessage', sendMessageDTO);
}

// 获取消息记录
export function getMessageRecord(msgQuery: MsgQuery) {
  return axios.post<Msg[]>('/api/msg/loadDataList', msgQuery);
}

// 根据消息ID查询关联的用户
export function getMessageUser(msgUserQuery: MsgUserQuery) {
  return axios.post<MsgUser[]>('/api/msgUser/loadDataList', msgUserQuery);
}
