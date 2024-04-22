import { DEFAULT_LAYOUT } from '../base';
import { AppRouteRecordRaw } from '../types';

const ERROR_SET: AppRouteRecordRaw = {
  path: '/error-set',
  name: 'ErrorSet',
  component: DEFAULT_LAYOUT,
  meta: {
    locale: 'menu.menu.error-set',
    requiresAuth: true,
    icon: 'icon-bookmark',
    order: 0,
  },
  children: [
    {
      path: '/error-count',
      name: 'ErrorsCount',
      component: import('@/views/errorSet/error-count/index.vue'),
      meta: {
        locale: 'menu.menu.error-set.count',
        requiresAuth: true,
        icon: 'icon-folder-add',
        order: 0,
      },
    },
  ],
};

export default ERROR_SET;
