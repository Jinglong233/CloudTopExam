import axios from 'axios';
import { ExamQuery } from '@/types/model/query/ExamQuery';
import { AddExamDTO } from '@/types/model/dto/AddExamDTO';
// eslint-disable-next-line import/namespace
import { ExamVO } from '@/types/model/vo/ExamVO';

import { UpdateExamDTO } from '@/types/model/dto/UpdateExamDTO';
import { CorrectExamVO } from '@/types/model/vo/CorrectExamVO';
import { CorrectUserExamUserVO } from '@/types/model/vo/CorrectUserExamUserVO';
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
