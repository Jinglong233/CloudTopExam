import { Department } from "@/types/model/po/Department";

export interface UpdateDeptDTO {
  /**
   * 部门ID
   */
  id?: string;

  department?: Department;
}
