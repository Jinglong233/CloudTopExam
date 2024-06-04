import { createApp } from 'vue';
import ArcoVue from '@arco-design/web-vue';
import ArcoVueIcon from '@arco-design/web-vue/es/icon';
import globalComponents from '@/components';
// Vue倒计时插件
import VueCountdown from '@chenfengyuan/vue-countdown';
import router from './router';
import store from './store';
import i18n from './locale';
import directive from './directive';
import App from './App.vue';

import '@/assets/style/global.less';
import '@/api/interceptor';

const app = createApp(App);
app.component(VueCountdown.name, VueCountdown);

app.use(ArcoVue, {});
app.use(ArcoVueIcon);

app.use(router);
app.use(store);
app.use(i18n);
app.use(globalComponents);
app.use(directive);
app.mount('#app');
