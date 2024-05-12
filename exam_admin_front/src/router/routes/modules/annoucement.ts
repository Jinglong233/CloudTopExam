import { DEFAULT_LAYOUT } from '../base';
import { AppRouteRecordRaw } from '../types';

const ANNOUCEMENT: AppRouteRecordRaw = {
  path: '/annoucement',
  name: 'Annoucement',
  component: DEFAULT_LAYOUT,
  meta: {
    locale: 'menu.announcement',
    requiresAuth: true,
    icon: 'icon-list',
    hideInMenu: true,
    order: 2,
  },
  children: [
    {
      path: 'my-message', // The midline path complies with SEO specifications
      name: 'MyMsg',
      component: () => import('@/views/announcement/my-message/index.vue'),
      meta: {
        locale: 'menu.announcement.myMsg',
        requiresAuth: true,
        hideInMenu: true,
        roles: ['admin', 'teacher'],
      },
    },
    {
      path: 'announce-list', // The midline path complies with SEO specifications
      name: 'AnnounceList',
      component: () =>
        import('@/views/announcement/announcement-list/index.vue'),
      meta: {
        locale: 'menu.announcement.announce',
        requiresAuth: true,
        hideInMenu: true,
        roles: ['admin', 'teacher'],
      },
    },
  ],
};

export default ANNOUCEMENT;
