// 随机抽取题目DTO
export interface RandomSelectQuDTO {
  excludes: string[];
  repoId: string;
  levels: [
    { level: '0'; quCount: ''; num: 0 },
    { level: '1'; quCount: ''; num: 0 }
  ];
  quType: number;
}

interface ClassfiySelect {
  /**
   * 题目难度
   */
  level?: number;
  /**
   * 题目数量
   */
  quCount?: number;
  /**
   * 选取的题目数量
   */
  num?: number;
}
