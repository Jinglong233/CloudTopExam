import { Paper } from '@/types/model/po/Paper';
import { ExamRecord } from '@/types/model/po/ExamRecord';

export interface CorrectUserExamUserVO {
  userName?: string;
  paper?: Paper;
  examRecord?: ExamRecord;
}
