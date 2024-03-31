import { mergeConfig } from 'vite';
import eslint from 'vite-plugin-eslint';
import baseConfig from './vite.config.base';

export default mergeConfig(
  {
    mode: 'development',
    server: {
      open: true,
      fs: {
        strict: true,
      },
      port: '5174',
      proxy: {
        '/api': {
          // 配置需要代理的路径 --> 这里的意思是代理http://localhost:80/api/后的所有路由
          target: 'http://localhost:8088', // 目标地址 --> 服务器地址
          changeOrigin: true, // 允许跨域
          // ws: true  // 允许websocket代理
          // 重写路径 --> 作用与vue配置pathRewrite作用相同
          rewrite: (path: any) => path.replace(/^\/api/, '/api/student'),
        },
      },
    },
    plugins: [
      eslint({
        cache: false,
        include: ['src/**/*.ts', 'src/**/*.tsx', 'src/**/*.vue'],
        exclude: ['node_modules'],
      }),
    ],
  },
  baseConfig
);
