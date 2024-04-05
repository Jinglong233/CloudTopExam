import { QuAndAnswerVO } from '@/types/model/vo/QuAndAnswerVO';
import { TrainRecord } from '@/types/model/po/TrainRecord';

export interface TrainRecordQuVO {
  quAndAnswerVo?: QuAndAnswerVO;
  trainRecord?: TrainRecord;
}
