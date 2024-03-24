export interface UserExamQuery {
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
