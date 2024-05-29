// eslint-disable-next-line import/namespace
import axios from 'axios';
import { AddSubjectDTO } from '@/types/model/dto/AddSubjectDTO';
import { SubjectTreeVO } from '@/types/model/vo/SubjectTreeVO';
import { SubjectQuery } from '@/types/model/query/SubjectQuery';
import { UpdateSubjectDTO } from '@/types/model/dto/UpdateSubjectDTO';

/**
 * 添加学科
 * @param subjectDTO
 */
// eslint-disable-next-line import/prefer-default-export
export function addSubject(subjectDTO: AddSubjectDTO) {
  return axios.post<boolean>('/api/subject/add', subjectDTO);
}

/**
 * 获取学科树
 */
export function getSubjectTree() {
  return axios.post<SubjectTreeVO>('/api/subject/treeList');
}

/**
 * 查询学科
 * @param subjectQuery
 */
export function loadDataList(subjectQuery: SubjectQuery) {
  return axios.post<SubjectTreeVO[]>('/api/subject/loadDataList', subjectQuery);
}

/**
 * 根据Id更新学科
 * @param subjectDTO
 */
export function updateSubjectById(updateSubjectDTO: UpdateSubjectDTO) {
  return axios.post<SubjectTreeVO>(
    '/api/subject/updateSubjectById',
    updateSubjectDTO
  );
}

/**
 * 根据Id删除学科
 * @param subjectId
 */
export function deleteSubjectById(subjectId: string) {
  return axios.post<SubjectTreeVO>(
    '/api/subject/deleteSubjectById',
    subjectId,
    {
      headers: {
        'Content-Type': 'text/plain',
      },
    }
  );
}
