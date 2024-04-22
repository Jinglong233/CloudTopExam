import { QuAndAnswerVO } from '@/types/model/vo/QuAndAnswerVO';

export interface ErrorVO {
  quAndAnswerVO?: QuAndAnswerVO;
  rightCount?: number;
  wrongCount?: number;
  totalCount?: number;
}
