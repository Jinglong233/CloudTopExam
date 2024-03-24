import { AddDepartmentDTO } from '@/types/model/dto/AddDepartmentDTO';
// eslint-disable-next-line import/namespace
import { DepartmentTreeVO } from '@/types/model/vo/DepartmentTreeVO';
import axios from 'axios';
import { UpdateDeptSortDTO } from '@/types/model/dto/UpdateDeptSortDTO';
import { UpdateDeptDTO } from '@/types/model/dto/UpdateDeptDTO';
import { DepartmentQuery } from '@/types/model/query/DepartmentQuery';
import { Department } from '@/types/model/po/Department';

/**
 * 添加部门
 * @param departmentDTO
 */
// eslint-disable-next-line import/prefer-default-export
export function addDepart(departmentDTO: AddDepartmentDTO) {
  return axios.post<boolean>('/api/department/add', departmentDTO);
}

/**
 * 获取部门树状列表
 */
export function getDeptTree() {
  return axios.get<DepartmentTreeVO>('/api/department/treeList');
}

/**
 * 部门排序
 * @param sortDTO
 */
export function departmentSort(sortDTO: UpdateDeptSortDTO) {
  return axios.post<boolean>('/api/department/sort', sortDTO);
}

/**
 * 更新部门信息
 * @param department
 * @param id
 */
export function updateDeptById(department: UpdateDeptDTO) {
  return axios.post<boolean>(
    '/api/department/updateDepartmentById',
    department
  );
}

/**
 * 根据ID删除部门信息
 * @param id
 */
export function deleteDeptById(id: string | undefined) {
  return axios.post<boolean>('/api/department/deleteDepartmentById', id, {
    headers: {
      'Content-Type': 'text/plain',
    },
  });
}

/**
 * 查询部门
 * @param department
 */
export function loadDataList(department: DepartmentQuery) {
  return axios.post<Department[]>('/api/department/loadDataList', department);
}

/**
 * 获取部门数量
 * @param department
 */
export function getDeptCount(department: DepartmentQuery) {
  return axios.post<number>('/api/department/deptCount', department);
}

/**
 * 获取专业
 */
export function getProfession() {
  return axios.post<DepartmentTreeVO[]>('/api/department/profession');
}
