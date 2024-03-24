import { ExamRecord } from '@/types/model/po/ExamRecord';

export interface UpdateExamRecordDTO {
  // 考试记录
  examRecord?: ExamRecord;

  // 考试记录的Id
  id?: string;
}
