import axios from 'axios';
import { Repo } from '@/types/model/po/Repo';
import RepoQuery from '@/types/model/query/RepoQuery';
import { AddRepoDTO } from '@/types/model/dto/AddRepoDTO';
import { UpdateRepoDTO } from '@/types/model/dto/UpdateRepoDTO';
import { ClassfiyByQuTypeVO } from '@/types/model/vo/ClassfiyByQuTypeVO';
import { UnwrapRef } from 'vue';
import { RandomSelectQuery } from '@/types/model/query/RandomSelectQuery';

/**
 * 获取题库
 */
// eslint-disable-next-line import/prefer-default-export
export function getRepoList(repoQuery: RepoQuery) {
  return axios.post<Repo[]>('/api/repo/loadRepoList', repoQuery);
}

/**
 * 添加题库
 */
export function addRepo(addRepoDTO: AddRepoDTO) {
  return axios.post<boolean>('/api/repo/add', addRepoDTO);
}

/**
 * 通过Id获取题库信息
 */
export function getRepoById(id: string) {
  return axios.post<Repo>('/api/repo/getRepoById', id, {
    headers: {
      'Content-Type': 'text/plain',
    },
  });
}

/**
 * 删除题库
 */
export function deleteRepoById(id: string) {
  return axios.post<boolean>('/api/repo/deleteRepoById', id, {
    headers: {
      'Content-Type': 'text/plain',
    },
  });
}

/**
 * 更新题库
 */
export function updateRepoById(repoDTO: UpdateRepoDTO) {
  return axios.post<boolean>('/api/repo/updateRepoById', repoDTO);
}

/**
 * 根据id获取题库中对应题型的难度分类
 */
export function classifyByQuType(
  repoId: string,
  quType: UnwrapRef<RandomSelectQuery['quType']> | undefined
) {
  return axios.post<ClassfiyByQuTypeVO>('/api/repo/classifyByQuType', {
    repoId,
    quType,
  });
}
