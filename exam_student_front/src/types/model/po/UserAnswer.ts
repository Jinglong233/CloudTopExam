class UserAnswer {
  /**
   * id
   */
  id?: string;

  /**
   * 是否已答0:未答1:已答
   */
  answered?: number;

  /**
   * 关联的题目Id
   */
  quId?: string;

  /**
   * 答案Id（是一个Json数组）
   */
  answerId?: string;

  /**
   * 所属记录Id
   */
  examRecordId?: string;

  /**
   * 是否答对0:错1:对
   */
  isRight?: number;

  /**
   * 用户id
   */
  userId?: string;

  /**
   * 题目排序（只在乱序的时候生效）
   */
  sort?: string;

  /**
   * 得分
   */
  score?: number;

  /**
   * 填空，主观题答案
   */
  answer?: string;
}
export default UserAnswer;
