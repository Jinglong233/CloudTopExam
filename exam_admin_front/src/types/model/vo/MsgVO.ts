import { Msg } from '@/types/model/po/Msg';
import { MsgUser } from '../po/MsgUser';

export interface MsgVO extends Msg {
  msgUser?: MsgUser;
}
