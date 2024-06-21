class UserAnswerQuery extends BaseQuery {
  /**
   * id
   */
  id?: string;

  idFuzzy?: string;

  /**
   * 是否已答0:未答1:已答
   */
  answered?: number;

  /**
   * 关联的题目Id
   */
  quId?: string;

  quIdFuzzy?: string;

  /**
   * 答案Id
   */
  answerId?: string;

  answerIdFuzzy?: string;

  /**
   * 所属记录Id
   */
  examRecordId?: string;

  examRecordIdFuzzy?: string;

  /**
   * 是否答对0:错1:对
   */
  isRight?: number;

  /**
   * 用户id
   */
  userId?: string;

  userIdFuzzy?: string;

  /**
   * 题目排序（只在乱序的时候生效）
   */
  sort?: string;

  sortFuzzy?: string;

  /**
   * 得分
   */
  score?: number;

  /**
   * 填空，主观题答案
   */
  answer?: string;

  answerFuzzy?: string;
}
