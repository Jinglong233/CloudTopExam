import axios from 'axios';
import { CheckEmailCodeDTO } from '@/types/model/dto/CheckEmailCodeDTO';

// eslint-disable-next-line import/prefer-default-export
export function checkCode(checkEmailCodeDTO: CheckEmailCodeDTO) {
  return axios.post('/api/email/checkCode', checkEmailCodeDTO);
}
