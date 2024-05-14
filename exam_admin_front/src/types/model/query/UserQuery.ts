import SimplePage from '@/types/model/po/SimplePage';

class UserQuery extends SimplePage {
  /**
   * ID
   */
  id?: number;

  /**
   * 用户名
   */
  userName?: string;

  userNameFuzzy?: string;

  /**
   * 头像
   */
  avatar?: string;

  avatarFuzzy?: string;

  /**
   * 邮箱
   */
  email?: string;

  emailFuzzy?: string;

  /**
   * 部门编号
   */
  deptCode?: string;

  /**
   * 部门名称
   */
  deptText?: string;

  deptTextFuzzy?: string;

  deptCodeFuzzy?: string;

  /**
   * 状态
   */
  state?: number;

  /**
   * 性别
   */
  sex?: number;

  /**
   * 手机
   */
  phone?: string;

  phoneFuzzy?: string;

  /**
   * 密码
   */
  password?: string;

  passwordFuzzy?: string;

  /**
   * 盐值
   */
  salt?: string;

  saltFuzzy?: string;

  /**
   * 真实姓名
   */
  realName?: string;

  realNameFuzzy?: string;

  /**
   * 角色
   */
  role?: string;

  rolesFuzzy?: string;

  /**
   * 创建时间
   */
  createTime?: Date;

  createTimeStart?: string;

  createTimeEnd?: string;

  /**
   * 创建者
   */
  createBy?: string;

  createByFuzzy?: string;

  /**
   * 更新时间
   */
  updateTime?: Date;

  updateTimeStart?: string;

  updateTimeEnd?: string;

  /**
   * 更新者
   */
  updateBy?: Date;

  updateByStart?: string;

  updateByEnd?: string;
}
export default UserQuery;
