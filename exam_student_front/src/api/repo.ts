import axios from 'axios';
import { RepoQuery } from '@/types/model/query/RepoQuery';

/**
 * 获取题库列表
 * @param
 */
// eslint-disable-next-line import/prefer-default-export
export function getRepoList(repoQuery: RepoQuery) {
  return axios.post<QuRepo[]>('/api/studentTrain/repoList', repoQuery);
}
