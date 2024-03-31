import { DEFAULT_LAYOUT } from '../base';
import { AppRouteRecordRaw } from '../types';

const TRAIN: AppRouteRecordRaw = {
  path: '/train',
  name: 'Train',
  component: DEFAULT_LAYOUT,
  meta: {
    locale: 'menu.train',
    requiresAuth: true,
    icon: 'icon-dashboard',
    order: 0,
  },
  children: [
    {
      path: 'repo-train',
      name: 'RepoTrain',
      component: () => import('@/views/train/repo-train/index.vue'),
      meta: {
        locale: 'menu.train.repoTrain',
        requiresAuth: true,
        roles: ['*'],
      },
    },
    {
      path: 'train-record',
      name: 'TrainRecord',
      component: () => import('@/views/train/train-record/index.vue'),
      meta: {
        locale: 'menu.train.trainRecord',
        requiresAuth: true,
        roles: ['*'],
      },
    },
    {
      path: 'repo-detail',
      name: 'RepoDetail',
      component: () => import('@/views/train/repo-detail/index.vue'),
      meta: {
        locale: 'menu.train.repoDetail',
        requiresAuth: true,
        hideInMenu: true,
        roles: ['*'],
      },
    },
  ],
};

export default TRAIN;
