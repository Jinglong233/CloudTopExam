import QuAnswer from '@/types/model/po/QuAnswer';

class AddQuAndAnswerDTO {
  /**
   * 所属题库的ID
   */
  repoId?: string;

  /**
   * 关联题库标题
   */
  repoText?: string;

  /**
   * 题目内容
   */
  content?: string;

  /**
   * 题目图片
   */
  image?: string;

  /**
   * 题目难度0:简单1:困难
   */
  level?: number;

  /**
   * 题目分析
   */
  analysis?: string;

  /**
   * 题型
   */
  quType?: number;

  /**
   * 知识点
   */
  knowledge?:string;

  /**
   * 选项列表
   */
  quAnswerList?: QuAnswer[];
}

export default AddQuAndAnswerDTO;
