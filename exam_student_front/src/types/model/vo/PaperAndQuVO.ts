import { GroupListVO } from '@/types/model/vo/GroupListVO';
import { Paper } from '@/types/model/po/Paper';

export interface PaperAndQuVO extends Paper {
  /**
   * 大题列表
   */
  groupLists?: GroupListVO[];
}
