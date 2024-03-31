import { QuAndAnswerVO } from "@/types/model/vo/QuAndAnswerVO";

export interface AddGroupListDTO {
  /**
   * 所属试卷ID
   */
  paperId?: string;

  /**
   * 题型
   */
  quType?: number;

  /**
   * 标题
   */
  title?: string;

  /**
   * 总分
   */
  totalScore?: number;

  /**
   * 每个小题的分数
   */
  perScore?: number;

  /**
   * 选项是否乱序0:否1:是
   */
  itemRand?: number;

  /**
   * 题目是否乱序0:否1:是
   */
  quRand?: number;

  /**
   * 题目总数
   */
  quCount?: number;

  /**
   * 题目列表
   */
  quList?: QuAndAnswerVO[];
}
