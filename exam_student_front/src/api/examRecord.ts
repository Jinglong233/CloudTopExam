import axios from 'axios';
import { ExamVO } from '@/types/model/vo/ExamVO';
import { ExamQuery } from '@/types/model/query/ExamQuery';
import { ExamRecordQuery } from '@/types/model/query/ExamRecordQuery';
import { ExamResultVO } from '@/types/model/vo/ExamResultVO';

export function getMyExamList(examQuery: ExamQuery) {
  return axios.post<ExamVO[]>('/api/exam/loadDataList', examQuery);
}

// 根据试卷Id获取试卷信息
export function getExamRecord(examRecordQuery: ExamRecordQuery) {
  return axios.post<ExamRepo>('/api/student/loadDataList', examRecordQuery);
}

// 开始考试
export function startAnswer(examRecordQuery: ExamRecordQuery) {
  return axios.post<boolean>('/api/student/startAnswer', examRecordQuery);
}

// 获取考试结果信息
export function getExamResult(examRecordId: string) {
  return axios.post<ExamResultVO>('/api/student/examResult', examRecordId, {
    headers: {
      'Content-Type': 'text/plain',
    },
  });
}
