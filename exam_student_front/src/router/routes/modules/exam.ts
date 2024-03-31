import { DEFAULT_LAYOUT } from '../base';
import { AppRouteRecordRaw } from '../types';

const EXAM: AppRouteRecordRaw = {
  path: '/exam',
  name: 'exam',
  component: DEFAULT_LAYOUT,
  meta: {
    locale: 'menu.exam',
    requiresAuth: true,
    icon: 'icon-dashboard',
    order: 0,
  },
  children: [
    {
      path: 'my-exam',
      name: 'MyExam',
      component: () => import('@/views/exam/my-exam/index.vue'),
      meta: {
        locale: 'menu.exam.myExam',
        requiresAuth: true,
        roles: ['*'],
      },
    },
    {
      path: 'exam-info/:examId',
      name: 'ExamInfo',
      component: () => import('@/views/exam/exam-info/index.vue'),
      meta: {
        locale: 'menu.exam.examInfo',
        requiresAuth: true,
        hideInMenu: true,
        roles: ['*'],
      },
    },
    {
      path: 'start-exam/:examId',
      name: 'StartExam',
      component: () => import('@/views/exam/start-exam/index.vue'),
      meta: {
        locale: 'menu.exam.examInfo',
        requiresAuth: true,
        hideInMenu: true,
        roles: ['*'],
      },
    },
    {
      path: 'exam-result/:examRecordId',
      name: 'ExamResult',
      component: () => import('@/views/exam/exam-result/index.vue'),
      meta: {
        locale: 'menu.exam.examResult',
        requiresAuth: true,
        hideInMenu: true,
        roles: ['*'],
      },
    },
  ],
};

export default EXAM;
