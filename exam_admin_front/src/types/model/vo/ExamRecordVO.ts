import { ExamRecord } from '@/types/model/po/ExamRecord';

export interface ExamRecordVO extends ExamRecord {
  userName?: string;
  answerTime?: number;
}
