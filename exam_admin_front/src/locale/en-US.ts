import localeMessageBox from '@/components/message-box/locale/en-US';
import localeLogin from '@/views/login/locale/en-US';

import localeWorkplace from '@/views/dashboard/workplace/locale/en-US';

import localeDataAnalysis from '@/views/visualization/data-analysis/locale/en-US';
import localeMultiDAnalysis from '@/views/visualization/multi-dimension-data-analysis/locale/en-US';

import localeSuccess from '@/views/result/success/locale/en-US';
import localeError from '@/views/result/error/locale/en-US';

import locale403 from '@/views/exception/403/locale/en-US';
import locale404 from '@/views/exception/404/locale/en-US';
import locale500 from '@/views/exception/500/locale/en-US';

import localeUserInfo from '@/views/user/info/locale/en-US';
import localeUserSetting from '@/views/user/setting/locale/en-US';

import localeCorrectManager from '@/views/exam/correct-manager/locale/en-US';
import localeUserManager from '@/views/user-manager/user-list/locale/en-US';
import localeDepartment from '@/views/user-manager/deptment/locale/en-US';
import localeSubject from '@/views/user-manager/subject/locale/en-US';

import localeQu from '@/views/repo/repo-manager/locale/en-US';
import localeQuestionBankManager from '@/views/repo/repo-manager/locale/en-US';
import localeQuManager from '@/views/repo/qu-manager/locale/en-US';
import localePaperManager from '@/views/exam/paper-manager/locale/en-US';
import localeExamManager from '@/views/exam/exam-manager/locale/en-US';

import localeSettings from './en-US/settings';

export default {
  'menu.dashboard': 'Dashboard',
  'menu.server.dashboard': 'Server Dashboard',
  'menu.server.workplace': 'Server Workplace',
  'menu.server.monitor': 'Server Real-time Monitoring',
  'menu.userManager': 'User Management',
  'menu.userList': 'User List',
  'menu.class': 'Class Management',
  'menu.classList': 'Class List',
  'menu.repo': 'Question Bank Management',
  'menu.quManager': 'Question Management',
  'menu.exam': 'Exam Management',
  'menu.list': 'List Page',
  'menu.result': 'Result Page',
  'menu.exception': 'Exception Page',
  'menu.form': 'Form Page',
  'menu.profile': 'Profile Page',
  'menu.visualization': 'Data Visualization',
  'menu.user': 'Personal Center',
  'menu.GitHub': 'GitHub',
  'menu.faq': 'FAQ',
  'navbar.docs': 'Documentation Center',
  'navbar.action.locale': 'Switch to Chinese',

  ...localeSettings,
  ...localeMessageBox,
  ...localeLogin,
  ...localeWorkplace,

  ...localeDataAnalysis,
  ...localeMultiDAnalysis,
  ...localeSuccess,
  ...localeError,
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
};
