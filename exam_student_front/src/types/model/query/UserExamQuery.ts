import BaseQuery from '@/types/model/query/BaseQuery';

class UserExamQuery extends BaseQuery {
  createTime?: string;

  createTimeEnd?: string;

  createTimeStart?: string;

  examId?: string;

  examIdFuzzy?: string;

  id?: string;

  idFuzzy?: string;

  maxScore?: number;

  orderBy?: string;

  pageNo?: number;

  pageSize?: number;

  passed?: number;

  tryCount?: number;

  updateTime?: string;

  updateTimeEnd?: string;

  updateTimeStart?: string;

  userId?: string;

  userIdFuzzy?: string;
}
export default UserExamQuery;
