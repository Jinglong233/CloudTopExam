import { QuAnswer } from '@/types/model/po/QuAnswer';
import { Qu } from '../po/Qu';

export interface QuAndAnswerVO extends Qu {
  quAnswerList?: QuAnswer[];
}
