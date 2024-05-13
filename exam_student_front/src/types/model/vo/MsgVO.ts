import { MsgUser } from '@/types/model/po/MsgUser';
import { Msg } from '../po/Msg';

export interface MsgVO extends Msg {
  msgUser?: MsgUser;
}
