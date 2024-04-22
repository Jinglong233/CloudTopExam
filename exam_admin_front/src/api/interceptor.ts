import type { AxiosRequestConfig, AxiosResponse } from 'axios';
import axios from 'axios';
import { Message } from '@arco-design/web-vue';
import { getToken } from '@/utils/auth';
import router from '@/router';

export interface HttpResponse<T = unknown> {
  status: string;
  info: string;
  code: number;
  data: T;
}

if (import.meta.env.VITE_API_BASE_URL) {
  axios.defaults.baseURL = import.meta.env.VITE_API_BASE_URL;
}

axios.interceptors.request.use(
  (config: AxiosRequestConfig) => {
    const token = getToken();
    if (token) {
      if (!config.headers) {
        config.headers = {};
      }
      config.headers.Authorization = token;
    }
    return config;
  },
  (error) => {
    return Promise.reject(error);
  }
);

// 响应拦截器
axios.interceptors.response.use(
  (response: AxiosResponse<HttpResponse>) => {
    const res = response.data;
    if (res.code === 200) {
      return res;
    }

    if (res.code === 401) {
      Message.warning({
        content: '请登录',
        duration: 2000,
      });
      router.push({ name: 'login' });
      return null;
    }
    if (response.status === 200) {
      return response.data;
    }

    Message.error({
      content: res.info || '请求出错',
      duration: 5 * 1000,
    });

    return Promise.reject(new Error(res.info || '请求出错'));
  },
  (error) => {
    Message.error({
      content: error.msg || 'Request Error',
      duration: 2 * 1000,
    });
    return Promise.reject(error);
  }
);
