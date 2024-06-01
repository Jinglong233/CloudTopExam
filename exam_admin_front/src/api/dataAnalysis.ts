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

// 获取错题类型占比信息
export function getQuTypeProportion() {
  return axios.get('/api/dataAnalysis/quTypeProportion');
}

// 获取错题占比前五的知识点
export function getTopFiveWrongTopics() {
  return axios.get('/api/dataAnalysis/topFiveWrongTopics');
}

// 获取错题知识点列表
export function getKnowledgeList() {
  return axios.get('/api/dataAnalysis/knowledgeList');
}

// 分类获取每个题型每个知识点错题总和
export function getWrongCountSummary() {
  return axios.get('/api/dataAnalysis/getWrongCountSummary');
}

// 分类获取每个题型每个知识点错题总和
export function getWrongDeptWrongKn(deptCode: string) {
  return axios.post('/api/dataAnalysis/wrongDeptWrongKn', deptCode, {
    headers: {
      'Content-Type': 'text/plain',
    },
  });
}

// 分类获取每个题型每个知识点错题总和
export function getWrongDeptSubject(deptCode: string) {
  return axios.post('/api/dataAnalysis/wrongDeptSubject', deptCode, {
    headers: {
      'Content-Type': 'text/plain',
    },
  });
}

// 分页获取部门错题统计
export function errorCount(deptObj: any) {
  return axios.post('/api/dataAnalysis/errorCount', deptObj);
}
