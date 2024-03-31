import { UpdateUserAnswerDTO } from './UpdateUserAnswerDTO';

export interface CorrectUserAnswerDTO extends UpdateUserAnswerDTO {
  glId?: string;
}
