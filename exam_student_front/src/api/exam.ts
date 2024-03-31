import axios from 'axios';
import { ExamVO } from '@/types/model/vo/ExamVO';
import { ExamQuery } from '@/types/model/query/ExamQuery';
import { SubmitExamDTO } from '@/types/model/dto/SubmitExamDTO';

// eslint-disable-next-line import/prefer-default-export
export function getMyExamList(examQuery: ExamQuery) {
  return axios.post<ExamVO[]>('/api/exam/loadDataList', examQuery);
}

// 根据试卷Id获取试卷信息
export function getExamById(examId: string) {
  return axios.post<ExamVO>('/api/exam/getExamById', examId, {
    headers: {
      'Content-Type': 'text/plain',
    },
  });
}

// 获取对应用户的考试列表
export function getExamListByUserId(userId: string) {
  return axios.post<ExamVO[]>('/api/student/loadStudentExamList', userId, {
    headers: {
      'Content-Type': 'text/plain',
    },
  });
}

// 提交试卷
export function submitMyExam(submitExamDTO: SubmitExamDTO) {
  return axios.post<boolean>('/api/student/submitExam', submitExamDTO);
}
