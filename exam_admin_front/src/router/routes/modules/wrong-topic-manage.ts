import { DEFAULT_LAYOUT } from '../base';
import { AppRouteRecordRaw } from '../types';

const wrongManage: AppRouteRecordRaw = {
  path: '/wrong-topic-manage',
  name: 'wrongManage',
  component: DEFAULT_LAYOUT,
  meta: {
    locale: 'menu.wrongManage',
    requiresAuth: true,
    icon: 'icon-subscribed',
    order: 2,
  },
  children: [
    {
      path: 'class-wrong-analyse',
      name: 'ClassWrongAnalyse',
      component: () =>
        import('@/views/wrong-topic-management/class-wrong-analyse/index.vue'),
      meta: {
        locale: 'menu.wrongManage.classWrongAnalyse',
        requiresAuth: true,
        roles: ['*'],
      },
    },
    {
      path: 'paper-wrong-analyse',
      name: 'PaperWrongAnalyse',
      component: () =>
        import('@/views/wrong-topic-management/paper-wrong-analyse/index.vue'),
      meta: {
        locale: 'menu.wrongManage.paperWrongAnalyse',
        requiresAuth: true,
        roles: ['*'],
      },
    },
    {
      path: 'class-wrong-detail/:examId',
      name: 'ClassWrongDetail',
      component: () =>
        import('@/views/wrong-topic-management/class-wrong-detail/index.vue'),
      meta: {
        locale: 'menu.wrongManage.classWrongAnalyse.detail',
        requiresAuth: true,
        roles: ['*'],
        hideInMenu: true,
      },
    },
    {
      path: 'paper-wrong-detail/:paperId',
      name: 'PaperWrongDetail',
      component: () =>
        import('@/views/wrong-topic-management/paper-wrong-detail/index.vue'),
      meta: {
        locale: 'menu.wrongManage.paperWrongAnalyse.detail',
        requiresAuth: true,
        hideInMenu: true,
      },
    },
  ],
};

export default wrongManage;
