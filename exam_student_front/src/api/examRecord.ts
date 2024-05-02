import axios from 'axios';
import { ExamRecordQuery } from '@/types/model/query/ExamRecordQuery';
import { ExamResultVO } from '@/types/model/vo/ExamResultVO';
import { ExamRecord } from '@/types/model/po/ExamRecord';

// 获取考试记录
export function getExamRecord(examRecordQuery: ExamRecordQuery) {
  return axios.post<ExamRecord>('/api/student/loadDataList', examRecordQuery);
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

// 获取已经作答的考试记录
export function getAnsweredRecord(userId: string) {
  return axios.post('/api/student/getAnsweredRecord', userId, {
    headers: {
      'Content-Type': 'text/plain',
    },
  });
}
