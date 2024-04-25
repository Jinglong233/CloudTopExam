import { QuQuery } from '@/types/model/query/QuQuery';

export interface QuExcludeQuery extends QuQuery {
  /**
   * 排除列表
   */
  excludes?: string[];
}
