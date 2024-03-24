export interface QuAnswerQuery {
  /**
   * 答案ID
   */
  id?: string;

  idFuzzy?: string;

  /**
   * 问题ID
   */
  quId?: string;

  quIdFuzzy?: string;

  /**
   * 是否正确
   */
  isRight?: number;

  /**
   * 图片
   */
  image?: string;

  imageFuzzy?: string;

  /**
   * 答案内容
   */
  content?: string;

  contentFuzzy?: string;

  /**
   * 答案分析
   */
  analysis?: string;

  analysisFuzzy?: string;
}
