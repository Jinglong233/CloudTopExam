import localeMessageBox from '@/components/message-box/locale/zh-CN';
import localeLogin from '@/views/login/locale/zh-CN';

import localeWorkplace from '@/views/dashboard/workplace/locale/zh-CN';

import localeDataAnalysis from '@/views/visualization/data-analysis/locale/zh-CN';
import localeMultiDAnalysis from '@/views/visualization/multi-dimension-data-analysis/locale/zh-CN';

import locale403 from '@/views/exception/403/locale/zh-CN';
import locale404 from '@/views/exception/404/locale/zh-CN';
import locale500 from '@/views/exception/500/locale/zh-CN';

import localeUserInfo from '@/views/user/info/locale/zh-CN';
import localeUserSetting from '@/views/user/setting/locale/zh-CN';

import localeCorrectManager from '@/views/paper/correct-manager/locale/zh-CN';

import localeUserManager from '@/views/user-manager/user-list/locale/zh-CN';
import localeDepartment from '@/views/user-manager/department/locale/zh-CN';
import localeSubject from '@/views/user-manager/subject/locale/zh-CN';

import localeQu from '@/views/repo/repo-manager/locale/zh-CN';
import localeQuestionBankManager from '@/views/repo/repo-manager/locale/zh-CN';
import localeQuManager from '@/views/repo/qu-manager/locale/zh-CN';
import localePaperManager from '@/views/paper/paper-manager/locale/zh-CN';
import localeExamManager from '@/views/exam/exam-manager/locale/zh-CN';
import localeWrongManager from '@/views/wrong-topic-management/locale/zh-CN';

import localMessage from '@/views/msg-center/locale/zh-CN';
import localAnnouncement from '@/views/announcement/locale/zh-CN';
import localeSettings from './zh-CN/settings';

export default {
  'menu.dashboard': '仪表盘',
  'menu.server.dashboard': '仪表盘-服务端',
  'menu.server.workplace': '工作台-服务端',
  'menu.server.monitor': '实时监控-服务端',
  'menu.userManager': '用户管理',
  'menu.userList': '用户列表',
  'menu.class': '班级管理',
  'menu.classList': '班级列表',
  'menu.repo': '题库管理',
  'menu.quManager': '题目管理',
  'menu.exam': '考试管理',
  'menu.list': '列表页',
  'menu.result': '结果页',
  'menu.exception': '异常页',
  'menu.form': '表单页',
  'menu.profile': '详情页',
  'menu.visualization': '数据可视化',
  'menu.user': '个人中心',
  'menu.GitHub': 'GitHub',
  'menu.faq': '常见问题',
  'navbar.docs': '文档中心',
  'navbar.action.locale': '切换为中文',

  ...localeSettings,
  ...localeMessageBox,
  ...localeLogin,
  ...localeWorkplace,

  ...localeDataAnalysis,
  ...localeMultiDAnalysis,

  ...locale403,
  ...locale404,
  ...locale500,
  ...localeUserInfo,
  ...localeUserSetting,

  ...localeCorrectManager,
  ...localeUserManager,
  ...localeDepartment,
  ...localeSubject,

  ...localeQuManager,
  ...localeQu,
  ...localeQuestionBankManager,
  ...localePaperManager,
  ...localeExamManager,
  ...localeWrongManager,

  ...localMessage,
  ...localAnnouncement,
};
