import BaseQuery from '@/types/model/query/BaseQuery';

class BookQuery extends BaseQuery {
  id?: string;

  idFuzzy?: string;

  userId?: string;

  userIdFuzzy?: string;

  quId?: string;

  quIdFuzzy?: string;

  quContent?: string;

  quContentFuzzy?: string;

  subjectId?: string;

  subjectIdFuzzy?: string;

  wrongCount?: number;

  quType?: number;

  knContent?: string;

  knContentFuzzy?: string;
}

export default BookQuery;
