import SimplePage from '@/types/model/po/SimplePage';

class QuQuery extends SimplePage {
  /**
   * ID
   */
  id?: string;

  idFuzzy?: string;

  /**
   * 所属题库的ID
   */
  repoId?: string;

  repoIdFuzzy?: string;

  /**
   * 关联题库标题
   */
  repoText?: string;

  repoTextFuzzy?: string;

  /**
   * 题目内容
   */
  content?: string;

  contentFuzzy?: string;

  /**
   * 题目图片
   */
  image?: string;

  imageFuzzy?: string;

  /**
   * 题目难度0:简单1:困难
   */
  level?: number;

  /**
   * 题目分析
   */
  analysis?: string;

  analysisFuzzy?: string;

  /**
   * 创建时间
   */
  createTime?: Date;

  createTimeStart?: string;

  createTimeEnd?: string;

  /**
   * 创建者
   */
  createBy?: string;

  createByFuzzy?: string;

  /**
   * 更新时间
   */
  updateTime?: Date;

  updateTimeStart?: string;

  updateTimeEnd?: string;

  /**
   * 更新者
   */
  updateBy?: string;

  updateByFuzzy?: string;

  /**
   * 题型
   */
  quType?: number;
}
export default QuQuery;
