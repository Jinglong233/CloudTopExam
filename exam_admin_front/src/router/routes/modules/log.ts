import { DEFAULT_LAYOUT } from '../base';
import { AppRouteRecordRaw } from '../types';

const LOG: AppRouteRecordRaw = {
  path: '/log',
  name: 'Log',
  component: DEFAULT_LAYOUT,
  meta: {
    locale: 'menu.log',
    requiresAuth: true,
    icon: 'icon-bookmark',
    order: 8,
  },
  children: [
    {
      path: 'login-log',
      name: 'LoginLog',
      component: () => import('@/views/log/login-log/index.vue'),
      meta: {
        locale: 'menu.log.loginLog',
        requiresAuth: true,
        roles: ['admin'],
      },
    },
    {
      path: 'operation-log',
      name: 'OperationLog',
      component: () => import('@/views/log/operation-log/index.vue'),
      meta: {
        locale: 'menu.log.operationLog',
        requiresAuth: true,
        roles: ['admin'],
      },
    },
  ],
};

export default LOG;
