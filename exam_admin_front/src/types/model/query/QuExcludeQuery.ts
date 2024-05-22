import QuQuery from '@/types/model/query/QuQuery';

class QuExcludeQuery extends QuQuery {
  /**
   * 排除列表
   */
  excludes: string[] = [];
}

export default QuExcludeQuery;
