import { Exam } from '@/types/model/po/Exam';
import { User } from '@/types/model/po/User';

export interface AddExamDTO extends Exam {
  userList?: User[];
}
