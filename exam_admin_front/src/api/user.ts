import axios from 'axios';

import { UserState } from '@/store/modules/user/types';
import { UserQuery } from '@/types/model/query/UserQuery';
import { User } from '@/types/model/po/User';
import { UpdateUserDTO } from '@/types/model/dto/UpdateUserDTO';
import { UpdateUserPasswordDTO } from '@/types/model/dto/UpdateUserPasswordDTO';
import { CheckEmailCodeDTO } from '@/types/model/dto/CheckEmailCodeDTO';
import { RetrievePasswordDTO } from '@/types/model/dto/RetrievePasswordDTO';

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
 * 发送解绑邮箱验证码
 */
export function getUnBindEmailCode() {
  return axios.post<boolean>('/api/user/getUnBindEmailCode');
}

/**
 * 获取绑定邮箱验证码
 */
export function getBindEmailCode(email: string) {
  return axios.post<boolean>('/api/user/getBindEmailCode', email, {
    headers: {
      'Content-Type': 'text/plain',
    },
  });
}

/**
 * 绑定邮箱
 */
export function bindUserEmail(checkEmailCodeDTO: CheckEmailCodeDTO) {
  return axios.post<boolean>('/api/user/bindUserEmail', checkEmailCodeDTO);
}

/**
 * 解绑邮箱
 */
export function unBindUserEmail(checkEmailCodeDTO: CheckEmailCodeDTO) {
  return axios.post<boolean>('/api/user/unBindUserEmail', checkEmailCodeDTO);
}

/**
 * 获取找回密码邮箱验证码
 */
export function getRetrievePasswordCode(
  retrievePasswordDTO: RetrievePasswordDTO
) {
  return axios.post<boolean>(
    '/api/user/getRetrievePasswordCode',
    retrievePasswordDTO
  );
}

/**
 * 找回密码
 */
export function retrievePassword(retrievePasswordDTO: RetrievePasswordDTO) {
  return axios.post<boolean>('/api/user/retrievePassword', retrievePasswordDTO);
}
