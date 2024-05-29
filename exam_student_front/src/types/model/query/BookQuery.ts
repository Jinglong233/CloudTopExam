import SimplePage from '@/types/model/po/SimplePage';

class BookQuery extends SimplePage {
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
