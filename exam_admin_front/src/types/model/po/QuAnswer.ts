export class QuAnswer {
  /**
   * ID
   */
  id?: string;

  /**
   * 题目ID
   */
  quId?: string;

  /**
   * 选项内容
   */
  content?: string;

  /**
   * 是否是答案0:不是1:是
   */
  isRight?: number;

  /**
   * 选项分析
   */
  analysis?: string;

  /**
   * 选项图片
   */
  image?: string;

  /**
   * 选项标签
   */
  tag?: string;
}

export default QuAnswer;
