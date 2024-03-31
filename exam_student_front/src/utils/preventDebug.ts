import { Message } from '@arco-design/web-vue';
import { Router } from 'vue-router';

export default function stopDebug(router: Router) {
  document.addEventListener('keydown', (e) => {
    // 禁止f12,禁用ctrl+shift+i,c,禁用shift+f10
    const { code } = e;
    const ctrl = e.ctrlKey;
    const shift = e.shiftKey;
    const isCSI = ctrl && shift && code === 'KeyI';
    const isF12 = code === 'F12';
    const isCSC = ctrl && shift && code === 'KeyC';
    const isSF10 = shift && code === 'F10';
    if (isF12 || isCSI || isCSC || isSF10) {
      e.preventDefault();
      Message.info({
        id: 'keydown',
        content: '非法操作，正在退出...',
        duration: 2000,
      });
      window.setTimeout(() => {
        router.back();
      }, 2000);
    }
  });

  // 禁用菜单
  document.addEventListener('contextmenu', (e) => {
    e.preventDefault();
    Message.info({
      id: 'contextmenu',
      content: '非法操作，正在退出...',
      duration: 2000,
    });
    window.setTimeout(() => {
      router.back();
    }, 2000);
  });
}
