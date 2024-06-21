import axios from 'axios';
import QuQuery from '@/types/model/query/QuQuery';
import Qu from '@/types/model/po/Qu';
import AddQuAndAnswerDTO from '@/types/model/dto/AddQuAndAnswerDTO';
import QuAndAnswerVO from '@/types/model/vo/QuAndAnswerVO';
import { UpdateQuAndAnswerDTO } from '@/types/model/dto/UpdateQuAndAnswerDTO';
import { RandomSelectQuDTO } from '@/types/model/dto/RandomSelectQuDTO';
import QuExcludeQuery from '@/types/model/query/QuExcludeQuery';

/**
 * 添加题目
 * @param repo
 */
// eslint-disable-next-line import/prefer-default-export
export function addQuAndQuAnswer(quAndAnswerDTO: AddQuAndAnswerDTO) {
  return axios.post<boolean>('/api/qu/add', quAndAnswerDTO);
}

/**
 * 获取题目列表
 * @param repo
 */
export function getQuList(quQuery: QuQuery) {
  return axios.post<Qu[]>('/api/qu/loadQuList', quQuery);
}

/**
 * 获取详细题目列表（排除之后的）
 * @param quQuery
 */
export function getExluceQuDetailList(excludeQuery: QuExcludeQuery) {
  return axios.post<Qu[]>('/api/qu/loadExcludeQuAnAnswerList', excludeQuery);
}

/**
 * 根据题目Id获取题目
 * @param repo
 */
export function getQuById(id: string) {
  return axios.post<QuAndAnswerVO>('/api/qu/getQuById', id, {
    headers: {
      'Content-Type': 'text/plain',
    },
  });
}

/**
 * 根据题目id删除所有题目，包括所关联的选项、题库表中的数据
 * @param id
 */
export function deleteQuById(id: string) {
  return axios.post<boolean>('/api/qu/deleteQuById', id, {
    headers: {
      'Content-Type': 'text/plain',
    },
  });
}

/**
 * 根据题目id更新所有题目，包括所关联的选项、题库表中的数据
 * @param quAndAnswerDTO
 */
export function updateQuById(quAndAnswerDTO: UpdateQuAndAnswerDTO) {
  return axios.post<boolean>('/api/qu/updateQuById', quAndAnswerDTO);
}

/**
 * 随机获取题目
 * @param selectQuDTO
 */
export function randomSelectQu(selectQuDTO: RandomSelectQuDTO) {
  return axios.post<QuAndAnswerVO[]>('/api/qu/randomSelectQu', selectQuDTO);
}

/**
 * 获取题目总数
 * @param selectQuDTO
 */
export function getQuCount(query: QuQuery) {
  return axios.post<number>('/api/qu/quCount', query);
}
