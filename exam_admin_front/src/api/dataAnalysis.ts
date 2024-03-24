import axios from 'axios';

// 获取性别分类
// eslint-disable-next-line import/prefer-default-export
export function getSexProportion() {
  return axios.get('/api/dataAnalysis/sexProportion');
}

// 获取近期考试信息
export function getRecentExamInfo() {
  return axios.get('/api/dataAnalysis/recentExamInfo');
}
