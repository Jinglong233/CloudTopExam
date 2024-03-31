import axios from 'axios';
import { PaperAndQuVO } from '@/types/model/vo/PaperAndQuVO';

/**
 * 根据ID获取试卷详细信息
 * @param
 */
// eslint-disable-next-line import/prefer-default-export
export function getPaperDetail(paperId: string) {
  return axios.post<PaperAndQuVO[]>('/api/paper/getPaperDetailById', paperId, {
    headers: {
      'Content-Type': 'text/plain',
    },
  });
}
