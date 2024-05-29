import { QuAndAnswerVO } from '@/types/model/vo/QuAndAnswerVO';

export interface ErrorVO {
  quAndAnswerVO?: QuAndAnswerVO;

  /**
   * 错题选项分布统计（非填空、简答）
   */
  wrongAnswerCount?: Map<string, number>;

  /**
   * 答题总数（考试+训练）
   * @return
   */
  answerCount?: number;
}
