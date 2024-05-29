class Qu {
  /**
   * ID
   */
  id?: string;

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
   * 创建时间
   */
  createTime?: Date;

  /**
   * 创建者
   */
  createBy?: string;

  /**
   * 更新时间
   */
  updateTime?: Date;

  /**
   * 更新者
   */
  updateBy?: string;

  /**
   * 题型
   */
  quType?: number;

  /**
   * 分值(从关联表获得)
   */
  score?: number;

  /**
   * 排序(从关联表获得)
   */
  sort?: number;


  /**
   * 知识点
   */
  knowledge?:string;
}
export default Qu;
