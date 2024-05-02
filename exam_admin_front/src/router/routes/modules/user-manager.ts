import { DEFAULT_LAYOUT } from '../base';
import { AppRouteRecordRaw } from '../types';

const userManager: AppRouteRecordRaw = {
  path: '/user-manager',
  name: 'userManager',
  component: DEFAULT_LAYOUT,
  meta: {
    locale: 'menu.userManager',
    requiresAuth: true,
    icon: 'icon-user-group',
    order: 2,
  },
  children: [
    {
      path: 'user-manager-list', // The midline path complies with SEO specifications
      name: 'userList',
      component: () => import('@/views/user-manager/user-list/index.vue'),
      meta: {
        locale: 'menu.userManager.userList',
        requiresAuth: true,
        roles: ['*'],
      },
    },
    {
      path: 'department', // The midline path complies with SEO specifications
      name: 'Department',
      component: () => import('@/views/user-manager/department/index.vue'),
      meta: {
        locale: 'menu.userManager.department',
        requiresAuth: true,
        roles: ['admin'],
      },
    },
    {
      path: 'subject', // The midline path complies with SEO specifications
      name: 'Subject',
      component: () => import('@/views/user-manager/subject/index.vue'),
      meta: {
        locale: 'menu.userManager.subject',
        requiresAuth: true,
        roles: ['admin'],
      },
    },
  ],
};

export default userManager;
