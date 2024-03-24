import axios from 'axios';
import { ExamVO } from '@/types/model/vo/ExamVO';
import { ExamQuery } from '@/types/model/query/ExamQuery';
import { ExamRecordQuery } from '@/types/model/query/ExamRecordQuery';
import { UpdateExamRecordDTO } from '@/types/model/dto/UpdateExamRecordDTO';

export function getMyExamList(examQuery: ExamQuery) {
  return axios.post<ExamVO[]>('/api/exam/loadDataList', examQuery);
}

// 根据试卷Id获取试卷信息
export function getExamRecord(examRecordQuery: ExamRecordQuery) {
  return axios.post('/api/student/loadDataList', examRecordQuery);
}

// 更新考试记录
export function updateExamRecord(updateExamRecordDTO: UpdateExamRecordDTO) {
  return axios.post<boolean>(
    '/api/examRecord/updateExamRecordById',
    updateExamRecordDTO
  );
}
