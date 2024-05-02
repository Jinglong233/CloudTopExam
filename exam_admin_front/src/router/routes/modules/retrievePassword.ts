import { AppRouteRecordRaw } from '../types';

export const PAGE_LAYOUT = () => import('@/layout/page-layout.vue');

const RETRIEVEPASSWORD: AppRouteRecordRaw = {
  path: '/password',
  name: 'password',
  component: PAGE_LAYOUT,
  meta: {
    locale: 'menu.exam',
    requiresAuth: true,
    icon: 'icon-drive-file',
    order: 2,
  },
  children: [
    {
      path: '/retrievePassword',
      name: 'RetrievePassword',
      component: () => import('@/views/user/retrieve-password/index.vue'),
      meta: {
        locale: 'menu.user.retrievePassword',
        requiresAuth: true,
        roles: ['*'],
        hideInMenu: true,
      },
    },
  ],
};

export default RETRIEVEPASSWORD;
