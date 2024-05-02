import axios from 'axios';

// eslint-disable-next-line import/prefer-default-export
export function getTrainCount() {
  return axios.get<number>('/api/student/trainCount');
}

export function getExamCount() {
  return axios.get<number>('/api/student/examCount');
}

export function getMyRecentExam() {
  return axios.get('/api/student/myRecentExam');
}
