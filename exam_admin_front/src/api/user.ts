import axios from 'axios';

import { UserState } from '@/store/modules/user/types';
import { UserQuery } from '@/types/model/query/UserQuery';
import { User } from '@/types/model/po/User';
import { UpdateUserDTO } from '@/types/model/dto/UpdateUserDTO';
import { UpdateUserPasswordDTO } from '@/types/model/dto/UpdateUserPasswordDTO';
import { UpdateExamDTO } from '@/types/model/dto/UpdateExamDTO';
import { UpdateEmailDTO } from '@/types/model/dto/UpdateEmailDTO';

export interface LoginData {
  userName: string;
  password: string;
}

export interface LoginRes extends UserState {
  token: string;
}

export function login(data: LoginData) {
  return axios.post<LoginRes>('/api/user/login', data);
}

/**
 * 退出登录
 */
export function logout() {
  return axios.post<boolean>('/api/user/logout');
}

export function getUserInfo() {
  return axios.post<UserState>('/api/user/info');
}

/**
 * 获取用户列表
 */
export function getUserList(userQuery: UserQuery) {
  return axios.post<User[]>('/api/user/loadUserList', userQuery);
}

/**
 * 获取部门用户列表
 */
export function getDeptUserList(userQuery: UserQuery) {
  return axios.post<User[]>('/api/user/loadDeptUserList', userQuery);
}

/**
 * 根据用户Id更新用户
 */
export function updateUserById(updateUserDTO: UpdateUserDTO) {
  return axios.post<boolean>('/api/user/updateUserById', updateUserDTO);
}

/**
 * 根据用户Id删除用户
 */
export function deleteUserByIb(id: string) {
  return axios.post<boolean>('/api/user/deleteUserById', id, {
    headers: {
      'Content-Type': 'text/plain',
    },
  });
}

/**
 * 添加用户
 * @param user
 */
export function addUser(user: User) {
  return axios.post<boolean>('/api/user/register', user);
}

/**
 * 获取用户总数
 * @param query
 */
export function getUserCount(query: UserQuery) {
  return axios.post<boolean>('/api/user/userCount', query);
}

/**
 * 修改密码
 */
export function updateUserPassword(
  updateUserPasswordDTO: UpdateUserPasswordDTO
) {
  return axios.post<boolean>(
    '/api/user/updateUserPassword',
    updateUserPasswordDTO
  );
}

/**
 * 发送验证码
 */
export function getEmailCode(email: string) {
  return axios.post<boolean>('/api/user/getEmailCode', email, {
    headers: {
      'Content-Type': 'text/plain',
    },
  });
}

/**
 * 更新绑定邮箱
 */
export function updateUserEmail(updateEmailDTO: UpdateEmailDTO) {
  return axios.post<boolean>('/api/user/updateUserEmail', updateEmailDTO);
}
