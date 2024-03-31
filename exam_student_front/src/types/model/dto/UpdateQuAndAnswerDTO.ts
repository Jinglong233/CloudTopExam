import { Qu } from '@/types/model/po/Qu';
import { QuAnswer } from '@/types/model/po/QuAnswer';

export interface UpdateQuAndAnswerDTO extends Qu {
  quAnswerList?: QuAnswer[];
}
