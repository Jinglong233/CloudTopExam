import { DEFAULT_LAYOUT } from '../base';
import { AppRouteRecordRaw } from '../types';

const Repo: AppRouteRecordRaw = {
  path: '/repo',
  name: 'repo',
  component: DEFAULT_LAYOUT,
  meta: {
    locale: 'menu.repo',
    requiresAuth: true,
    icon: 'icon-home',
    order: 4,
  },
  children: [
    {
      path: 'repo-manager', // The midline path complies with SEO specifications
      name: 'RepoManager',
      component: () => import('@/views/repo/repo-manager/index.vue'),
      meta: {
        locale: 'menu.repo.repoManager',
        requiresAuth: true,
        roles: ['*'],
      },
    },
    {
      path: 'qu-manager', // The midline path complies with SEO specifications
      name: 'quManager',
      component: () => import('@/views/repo/qu-manager/index.vue'),
      meta: {
        locale: 'menu.repo.quManager',
        requiresAuth: true,
        roles: ['*'],
      },
    },
    {
      path: 'add-qu', // The midline path complies with SEO specifications
      name: 'addQu',
      component: () => import('@/views/repo/add-qu/index.vue'),
      meta: {
        locale: 'menu.repo.addQu',
        hideInMenu: true,
        requiresAuth: true,
        roles: ['*'],
      },
    },
    {
      name: 'ModifyQu',
      path: 'modify-qu', // The midline path complies with SEO specifications
      component: () => import('@/views/repo/modify-qu/index.vue'),
      meta: {
        locale: 'menu.repo.modifyQu',
        requiresAuth: true,
        hideInMenu: true,
        roles: ['*'],
      },
    },
    {
      name: 'AddRepo',
      path: 'add-repo', // The midline path complies with SEO specifications
      component: () => import('@/views/repo/add-repo/index.vue'),
      meta: {
        locale: 'menu.repo.addRepo',
        requiresAuth: true,
        hideInMenu: true,
        roles: ['*'],
      },
    },
    {
      name: 'ModifyRepo',
      path: 'modify-repo', // The midline path complies with SEO specifications
      component: () => import('@/views/repo/modify-repo/index.vue'),
      meta: {
        locale: 'menu.repo.updateRepo',
        requiresAuth: true,
        hideInMenu: true,
        roles: ['*'],
      },
    },
  ],
};

export default Repo;
