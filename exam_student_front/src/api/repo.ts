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

/**
 * 获取题库列表
 * @param
 */
export function getQuTypeClassifyByRepoId(repoId: string) {
  return axios.post<Map<number, number>>(
    '/api/studentTrain/getQuTypeClassifyByRepoId',
    repoId,
    {
      headers: {
        'Content-Type': 'text/plain',
      },
    }
  );
}
