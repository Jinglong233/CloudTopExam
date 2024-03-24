export interface UpdateDeptSortDTO {
  /**
   * 部门ID
   */
  deptId: string;

  /**
   * 排序方式（1：上移 0：下移）
   */
  sort: number;
}
