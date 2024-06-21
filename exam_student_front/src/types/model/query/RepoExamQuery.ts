import BaseQuery from '@/types/model/query/BaseQuery';

class RepoExamQuery extends BaseQuery {
  /**
   * ID
   */
  id?: string;

  idFuzzy?: string;

  /**
   * 考试ID
   */
  examId?: string;

  examIdFuzzy?: string;

  /**
   * 题库ID
   */
  repoId?: string;

  repoIdFuzzy?: string;

  /**
   * 单选题数量
   */
  radioCount?: number;

  /**
   * 单选题分数
   */
  radioScore?: number;

  /**
   * 多选题数量
   */
  multiCount?: number;

  /**
   * 多选题分数
   */
  multiScore?: number;

  /**
   * 判断题数量
   */
  judgeCount?: number;

  /**
   * 判断题分数
   */
  judgeScore?: number;

  /**
   * 简答题数量
   */
  saqCount?: number;

  /**
   * 简答题分数
   */
  saqScore?: number;
}
export default RepoExamQuery;
