import axios from 'axios';
import { AddUserAnswerDTO } from '@/types/model/dto/AddUserAnswerDTO';
import { CorrectUserAnswerDTO } from '@/types/model/dto/CorrectUserAnswerDTO';

// 用户答题
// eslint-disable-next-line import/prefer-default-export
export function updateStudentAnswer(
  correctUserAnswerDTO: CorrectUserAnswerDTO
) {
  return axios.post<boolean>(
    '/api/studentAnswer/updateStudentAnswerById',
    correctUserAnswerDTO
  );
}

// 批量新建用户答案记录
export function addBatchStudentAnswer(addUserAnswerDTO: AddUserAnswerDTO) {
  return axios.post<boolean>('/api/studentAnswer/add', addUserAnswerDTO);
}
