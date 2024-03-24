import { createApp } from 'vue';
import ArcoVue from '@arco-design/web-vue';
import ArcoVueIcon from '@arco-design/web-vue/es/icon';
import globalComponents from '@/components';
// 引入打印插件
// @ts-ignore
import { hiPrintPlugin } from 'vue-plugin-hiprint';

// @ts-ignore
import VMdPreviewHtml from '@kangc/v-md-editor/lib/preview-html';
import '@kangc/v-md-editor/lib/style/preview-html.css';
// @ts-ignore
import Prism from 'prismjs';
import router from './router';
import store from './store';
import i18n from './locale';
import directive from './directive';
import App from './App.vue';

import '@/assets/style/global.less';
import '@/api/interceptor';

// 引入v-md-editor组件
import '@kangc/v-md-editor/lib/style/base-editor.css';
import '@kangc/v-md-editor/lib/theme/style/vuepress.css';

const app = createApp(App);
app.use(VMdPreviewHtml);

app.use(ArcoVue, {});
app.use(ArcoVueIcon);

app.use(router);
app.use(store);
app.use(i18n);
app.use(globalComponents);
app.use(directive);
app.use(hiPrintPlugin, '$pluginName');
hiPrintPlugin.disAutoConnect();
app.mount('#app');
