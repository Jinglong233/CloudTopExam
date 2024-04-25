import { Exam } from '@/types/model/po/Exam';
import { User } from '@/types/model/po/User';

export interface UpdateExamDTO extends Exam {
  /**
   * 考试Id
   */
  id?: string;

  userList?: string[];
}
