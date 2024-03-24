import { QuAnswer } from '@/types/model/po/QuAnswer';

export interface addQu extends Qu {
  repoId: string;
  answerList: QuAnswer[];
}
