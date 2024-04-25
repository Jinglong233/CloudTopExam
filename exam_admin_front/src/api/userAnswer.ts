import axios from 'axios';
// eslint-disable-next-line import/namespace
import { UserAnswerQuery } from '@/types/model/query/UserAnswerQuery';
import { UpdateUserAnswerDTO } from '@/types/model/dto/UpdateUserAnswerDTO';

/**
 * 获取考试列表
 * @param examQuery
 */
// eslint-disable-next-line import/prefer-default-export
export function getUserAnswerList(userAnswerQuery: UserAnswerQuery) {
  return axios.post('/api/userAnswer/getDataList', userAnswerQuery);
}

// 更新答题记录
export function updateUserAnswerList(userAnswerQuery: UpdateUserAnswerDTO) {
  return axios.post('/api/userAnswer/updateById', userAnswerQuery);
}
