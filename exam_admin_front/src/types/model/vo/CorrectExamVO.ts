import { Exam } from '@/types/model/po/Exam';

export interface CorrectExamVO {
  exam?: Exam;
  /**
   * 考试人数
   */
  examTotal?: number;

  /**
   * 待批阅人数
   */
  correctTotal?: number;
}
