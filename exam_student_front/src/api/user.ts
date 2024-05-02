import axios from 'axios';
import type { RouteRecordNormalized } from 'vue-router';
import { UserState } from '@/store/modules/user/types';
import { UpdateUserDTO } from '@/types/model/dto/UpdateUserDTO';
import { CheckEmailCodeDTO } from '@/types/model/dto/CheckEmailCodeDTO';
import { RetrievePasswordDTO } from '@/types/model/dto/RetrievePasswordDTO';
import { UpdateUserPasswordDTO } from '@/types/model/dto/UpdateUserPasswordDTO';

export interface LoginData {
  username: string;
  password: string;
}

export interface LoginRes {
  token: string;
}
export function login(data: LoginData) {
  return axios.post<LoginRes>('/api/student/login', data);
}

export function logout() {
  return axios.post<LoginRes>('/api/student/logout');
}

export function getUserInfo() {
  return axios.post<UserState>('/api/user/info');
}

export function getMenuList() {
  return axios.post<RouteRecordNormalized[]>('/api/student/menu');
}

/**
 * 根据用户Id更新用户
 */
export function updateUserById(updateUserDTO: UpdateUserDTO) {
  return axios.post<boolean>('/api/student/updateUserById', updateUserDTO);
}

/**
 * 修改密码
 */
export function updateUserPassword(
  updateUserPasswordDTO: UpdateUserPasswordDTO
) {
  return axios.post<boolean>(
    '/api/student/updateUserPassword',
    updateUserPasswordDTO
  );
}

/**
 * 发送解绑邮箱验证码
 */
export function getUnBindEmailCode() {
  return axios.post<boolean>('/api/email/getUnBindEmailCode');
}

/**
 * 获取绑定邮箱验证码
 */
export function getBindEmailCode(email: string) {
  return axios.post<boolean>('/api/email/getBindEmailCode', email, {
    headers: {
      'Content-Type': 'text/plain',
    },
  });
}

/**
 * 绑定邮箱
 */
export function bindUserEmail(checkEmailCodeDTO: CheckEmailCodeDTO) {
  return axios.post<boolean>('/api/email/bindUserEmail', checkEmailCodeDTO);
}

/**
 * 解绑邮箱
 */
export function unBindUserEmail(checkEmailCodeDTO: CheckEmailCodeDTO) {
  return axios.post<boolean>('/api/email/unBindUserEmail', checkEmailCodeDTO);
}

/**
 * 获取找回密码邮箱验证码
 */
export function getRetrievePasswordCode(
  retrievePasswordDTO: RetrievePasswordDTO
) {
  return axios.post<boolean>(
    '/api/student/getRetrievePasswordCode',
    retrievePasswordDTO
  );
}

/**
 * 找回密码
 */
export function retrievePassword(retrievePasswordDTO: RetrievePasswordDTO) {
  return axios.post<boolean>(
    '/api/student/retrievePassword',
    retrievePasswordDTO
  );
}
