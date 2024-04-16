import { QuAndAnswerVO } from '@/types/model/vo/QuAndAnswerVO';

export interface WrongQuVO {
  /**
   * 题目和对应选项列表
   */
  quAndAnswerVo?: QuAndAnswerVO;
  /**
   * 答对人数
   */
  rightCount?: number;

  /**
   * 答错人数
   */
  errorCount?: number;

  /**
   * 正确率
   */
  rightRate?: string;
}
