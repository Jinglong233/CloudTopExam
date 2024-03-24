import { AddPaperDTO } from '@/types/model/dto/AddPaperDTO';
import axios from 'axios';
import { PaperQuery } from '@/types/model/query/PaperQuery';
import { Paper } from '@/types/model/po/Paper';
import { PaperAndQuVO } from '@/types/model/vo/PaperAndQuVO';
import { UpdatePaperAndQuDTO } from '@/types/model/dto/UpdatePaperAndQuDTO';

/**
 * 保存试卷
 */
// eslint-disable-next-line import/prefer-default-export
export function addPaper(addPaperDTO: AddPaperDTO) {
  return axios.post<boolean>('/api/paper/add', addPaperDTO);
}

/**
 * 查询试卷
 * @param paperQuery
 */
export function getPaperList(paperQuery: PaperQuery) {
  return axios.post<Paper[]>('/api/paper/loadDataList', paperQuery);
}

/**
 * 根据ID获取试卷详细信息
 * @param
 */
export function getPaperDetail(paperId: string) {
  return axios.post<PaperAndQuVO[]>('/api/paper/getPaperDetailById', paperId, {
    headers: {
      'Content-Type': 'text/plain',
    },
  });
}

/**
 * 根据id更新试卷
 */
export function updatePaperById(updateDTO: UpdatePaperAndQuDTO) {
  return axios.post<boolean>('/api/paper/updatePaperById', updateDTO);
}

/**
 * 根据id更新试卷
 */
export function deletePaperById(paperId: string) {
  return axios.post<boolean>('/api/paper/deletePaperById', paperId, {
    headers: {
      'Content-Type': 'text/plain',
    },
  });
}

/**
 * 获取试卷总数
 */
export function getPaperCount(paperQuery: PaperQuery) {
  return axios.post<number>('/api/paper/paperCount', paperQuery);
}
