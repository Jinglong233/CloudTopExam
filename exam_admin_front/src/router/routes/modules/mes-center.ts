import { DEFAULT_LAYOUT } from '../base';
import { AppRouteRecordRaw } from '../types';

const MESSAGE: AppRouteRecordRaw = {
  path: '/msg-center',
  name: 'MsgCenter',
  component: DEFAULT_LAYOUT,
  meta: {
    locale: 'msg.center',
    requiresAuth: true,
    icon: 'icon-message',
    order: 7,
  },
  children: [
    {
      path: 'send-message', // The midline path complies with SEO specifications
      name: 'SendMessage',
      component: () => import('@/views/msg-center/send-message/index.vue'),
      meta: {
        locale: 'msg.center.sendMsg',
        requiresAuth: true,
        roles: ['admin'],
      },
    },
    {
      path: 'message-record', // The midline path complies with SEO specifications
      name: 'MessageRecord',
      component: () => import('@/views/msg-center/message-record/index.vue'),
      meta: {
        locale: 'msg.center.msgRecord',
        requiresAuth: true,
        roles: ['admin'],
      },
    },
  ],
};

export default MESSAGE;
