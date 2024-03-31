// @ts-ignore
import { PaperAndQuVO } from '@/types/model/vo/PaperAndQuVO';

export interface AddUserAnswerDTO {
  paperAndQuVO?: PaperAndQuVO;
  /**
   * 考试记录Id
   */
  examRecordId?: string;

  /**
   * 用户Id
   */
  userId?: string;
}
