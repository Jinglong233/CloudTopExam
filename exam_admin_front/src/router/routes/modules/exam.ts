import { DEFAULT_LAYOUT } from '../base';
import { AppRouteRecordRaw } from '../types';

const EXAM: AppRouteRecordRaw = {
  path: '/exam',
  name: 'exam',
  component: DEFAULT_LAYOUT,
  meta: {
    locale: 'menu.exam',
    requiresAuth: true,
    icon: 'icon-drive-file',
    order: 2,
  },
  children: [
    {
      path: 'paper-manager', // The midline path complies with SEO specifications
      name: 'ExamList',
      component: () => import('@/views/exam/paper-manager/index.vue'),
      meta: {
        locale: 'menu.exam.paperManager',
        requiresAuth: true,
        roles: ['*'],
      },
    },
    {
      path: 'add-paper/:joinType/:deptCode/:subjectId/:title', // The midline path complies with SEO specifications
      name: 'AddPaper',
      component: () => import('@/views/exam/add-paper/index.vue'),
      meta: {
        locale: 'menu.exam.addPaper',
        requiresAuth: true,
        hideInMenu: true,
        roles: ['*'],
      },
    },
    {
      path: 'preview-paper', // The midline path complies with SEO specifications
      name: 'PreviewPaper',
      component: () => import('@/views/exam/preview-paper/index.vue'),
      meta: {
        locale: 'menu.exam.preview',
        requiresAuth: true,
        hideInMenu: true,
        roles: ['*'],
      },
    },
    {
      path: 'modify-paper', // The midline path complies with SEO specifications
      name: 'ModifyPaper',
      component: () => import('@/views/exam/modify-paper/index.vue'),
      meta: {
        locale: 'menu.exam.modifyPaper',
        requiresAuth: true,
        hideInMenu: true,
        roles: ['*'],
      },
    },
    {
      path: 'exam-manager', // The midline path complies with SEO specifications
      name: 'ExamManager',
      component: () => import('@/views/exam/exam-manager/index.vue'),
      meta: {
        locale: 'menu.exam.examManager',
        requiresAuth: true,
        roles: ['*'],
      },
    },
    {
      path: 'select-exam-paper', // The midline path complies with SEO specifications
      name: 'selectExamPaper',
      component: () => import('@/views/exam/select-exam-paper/index.vue'),
      meta: {
        locale: 'menu.exam.selectExamPaper',
        requiresAuth: true,
        hideInMenu: true,
        roles: ['*'],
      },
    },
    {
      path: 'add-exam', // The midline path complies with SEO specifications
      name: 'AddExam',
      component: () => import('@/views/exam/add-exam/index.vue'),
      meta: {
        locale: 'menu.exam.addExam',
        requiresAuth: true,
        hideInMenu: true,
        roles: ['*'],
      },
    },
    {
      path: 'modify-exam', // The midline path complies with SEO specifications
      name: 'ModifyExam',
      component: () => import('@/views/exam/modify-exam/index.vue'),
      meta: {
        locale: 'menu.exam.modifyExam',
        requiresAuth: true,
        hideInMenu: true,
        roles: ['*'],
      },
    },
    {
      path: 'correct-exam-list', // The midline path complies with SEO specifications
      name: 'CorrectList',
      component: () =>
        import('@/views/exam/correct-manager/correct-exam-list/index.vue'),
      meta: {
        locale: 'menu.exam.correctExam',
        requiresAuth: true,
        roles: ['admin', 'teacher'],
      },
    },
    {
      path: 'correct-user-list/:examId', // The midline path complies with SEO specifications
      name: 'CorrectUserExam',
      component: () =>
        import('@/views/exam/correct-manager/correct-user-list/index.vue'),
      meta: {
        locale: 'menu.exam.correctUserExam',
        requiresAuth: true,
        hideInMenu: true,
        roles: ['admin', 'teacher'],
      },
    },
    {
      path: 'correct-user-paper/:examRecordId', // The midline path complies with SEO specifications
      name: 'CorrectUserPaper',
      component: () =>
        import('@/views/exam/correct-manager/correct-user-paper/index.vue'),
      meta: {
        locale: 'menu.exam.answerDetail',
        requiresAuth: true,
        hideInMenu: true,
        roles: ['admin', 'teacher'],
      },
    },
  ],
};

export default EXAM;
