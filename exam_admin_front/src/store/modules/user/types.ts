export type RoleType = '*' | 'student' | 'teacher' | 'admin';

export interface UserState {
  id?: string;
  avatar?: string;
  deptText?: string;
  deptCode?: string;
  sex?: string;
  userName?: string;
  realName?: string;
  password?: string;
  phone?: string;
  email?: string;
  state?: number;
  createTime?: Date;
  role?: RoleType;
  token?: string;
}
