import axios from 'axios';
import { ExamQuery } from '@/types/model/query/ExamQuery';
import { AddExamDTO } from '@/types/model/dto/AddExamDTO';
// eslint-disable-next-line import/namespace
import { ExamVO } from '@/types/model/vo/ExamVO';

import { UpdateExamDTO } from '@/types/model/dto/UpdateExamDTO';
import { CorrectExamVO } from '@/types/model/vo/CorrectExamVO';
import { CorrectUserExamUserVO } from '@/types/model/vo/CorrectUserExamUserVO';
import { ExamRecordQuery } from '@/types/model/query/ExamRecordQuery';
import { WrongQuVO } from '@/types/model/vo/WrongQuVO';
import { ExamRecord } from '@/types/model/po/ExamRecord';

/**
 * 获取考试列表
 * @param examQuery
 */
// eslint-disable-next-line import/prefer-default-export
export function getExamList(examQuery: ExamQuery) {
  return axios.post('/api/exam/loadExamList', examQuery);
}

/**
 * 保存考试
 * @param addExamDTO
 */
export function addExam(addExamDTO: AddExamDTO) {
  return axios.post<boolean>('/api/exam/add', addExamDTO);
}

/**
 * 获取考试信息
 * @param addExamDTO
 */
export function getExamById(examId: string) {
  return axios.post<ExamVO>('/api/exam/getExamById', examId, {
    headers: {
      'Content-Type': 'text/plain',
    },
  });
}

/**
 * 获取考试信息
 * @param addExamDTO
 */
export function updateExamById(updateExamDTO: UpdateExamDTO) {
  return axios.post<boolean>('/api/exam/updateExamById', updateExamDTO);
}

/**
 * 删除考试信息
 * @param examId
 */
export function deleteExamById(examId: string) {
  return axios.post<boolean>('/api/exam/deleteExamById', examId, {
    headers: {
      'Content-Type': 'text/plain',
    },
  });
}

/**
 * 获取阅卷信息
 */
export function getCorrectExam(examQuery: ExamQuery) {
  return axios.post<CorrectExamVO[]>('/api/exam/getCorrectExam', examQuery);
}

/**
 * 获取阅卷信息
 */
export function getExamRecordByExamId(examRecordQuery: ExamRecordQuery) {
  return axios.post<CorrectUserExamUserVO[]>(
    '/api/examRecord/getExamRecordByExamId',
    examRecordQuery
  );
}

/**
 * 获取考试记录
 */
export function getExamRecord(examRecordQuery: ExamRecordQuery) {
  return axios.post<ExamRecord[]>(
    '/api/examRecord/loadDataList',
    examRecordQuery
  );
}

/**
 * 获取阅卷信息根据条件
 */
export function getCorrectExamByParam(examQuery: ExamQuery) {
  return axios.post<CorrectUserExamUserVO[]>(
    '/api/exam/getCorrectExamByParam',
    examQuery
  );
}

/**
 * 获取考试题目分析
 */
export function getExamQuAnalyse(examId: string) {
  return axios.post<WrongQuVO[]>('/api/exam/getExamQuAnalyse', examId, {
    headers: {
      'Content-Type': 'text/plain',
    },
  });
}

/**
 * 获取试卷题目分析
 */
export function getPaperAnalyse(paperId: string) {
  return axios.post<WrongQuVO[]>('/api/exam/getPaperQuAnalyse', paperId, {
    headers: {
      'Content-Type': 'text/plain',
    },
  });
}

/**
 * 获取考试二维码
 */
export function getExamQrCode(examId: string) {
  return axios.get(`/api/exam/qrcode/${examId}`, {
    responseType: 'blob', // 设置响应类型为 blob
  });
}
