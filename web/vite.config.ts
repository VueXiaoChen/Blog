import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [vue()],
  server: {
    https: false,
    proxy: {
      '/api': {
        target: 'https://api.bilibili.com/',
        changeOrigin: true,
        secure:false,//解决自签名证书错误
        configure: (proxy, options) => {
          proxy.on('proxyReq', function (proxyReq, req, res) {
            proxyReq.removeHeader('referer')  //移除请求头
            proxyReq.removeHeader('origin') //移除请求头
            //proxyReq.setHeader('host','api.bilibili.com/') //添加请求头
          });
          proxy.on('proxyRes', function (proxyRes, req, res) {
            /*添加或删除响应头有两种写法，第一种是操作 proxyRes 参数*/
            delete proxyRes.headers['set-cookie']
            //proxyRes.headers['cookie'] = 'SESSDATA=4e3dedeb%2C1703865426%2C4538b%2A71sf_6Hf4wW_T6R3v9tSesDllgpKAe2Awag0wXqrm67iSXb9AoqYItAB9_7IDrDlJGYvSzXgAAXgA;bili_jct=9b500afa69ee832587ec8f560c364404;DedeUserID=235576894';
            //proxyRes.headers['set-cookie'] = 'SESSDATA=1c3d9b6a%2C1703795894%2C951d8%2A71DHs_AsMbrQPFi-_pgf9g797y2NebhruR4Ktifyz0e-hAbs5P7gYmTA5BOgxK8tpLVBknlwAAXgA';
            /*第二种方法是操作 res 参数*/
            // res.removeHeader("Access-Control-Allow-Origin");
            // res.setHeader("Access-Control-Allow-Origin", req.headers.origin);
            // res.setHeader("Access-Control-Allow-Credentials", 'true');
            // res.setHeader("Access-Control-Allow-Headers", "Content-Type,Content-Length, Authorization, Accept,X-Requested-With");
            // res.setHeader("Access-Control-Allow-Methods", "PUT,POST,GET,DELETE,OPTIONS");
          });
        },
        rewrite: (path) => path.replace(/^\/api/, '')
      },
      '/post': {
        target: 'https://passport.bilibili.com/',
        changeOrigin: true,
        secure:false,//解决自签名证书错误
        //onProxyReq:(proxyReq)=>proxyReq.removeHeader('origin'),
        configure: (proxy, options) => {
          proxy.on('proxyReq', function (proxyReq, req, res) {
            proxyReq.removeHeader('referer')  //移除请求头
            proxyReq.removeHeader('origin') //移除请求头
            //proxyReq.setHeader('host','https://passport.bilibili.com/') //添加请求头
          });
          proxy.on('proxyRes', function (proxyRes, req, res) {
            /*添加或删除响应头有两种写法，第一种是操作 proxyRes 参数*/
            delete proxyRes.headers['set-cookie']
            //res.setHeader("referer", 'https://www.bilibili.com/');
            //proxyRes.headers['set-cookie'] = 'SESSDATA=1c3d9b6a%2C1703795894%2C951d8%2A71DHs_AsMbrQPFi-_pgf9g797y2NebhruR4Ktifyz0e-hAbs5P7gYmTA5BOgxK8tpLVBknlwAAXgA';
            /*第二种方法是操作 res 参数*/
            // res.removeHeader("Access-Control-Allow-Origin");
            //res.setHeader("Access-Control-Allow-Origin", req.headers.origin);
            // res.setHeader("Access-Control-Allow-Credentials", 'true');
            // res.setHeader("Access-Control-Allow-Headers", "Content-Type,Content-Length, Authorization, Accept,X-Requested-With");
            // res.setHeader("Access-Control-Allow-Methods", "PUT,POST,GET,DELETE,OPTIONS");
          });
        },
        rewrite: (path) => path.replace(/^\/post/, '')
      },
      '/encode': {
        target: 'https://api.gmit.vip/Api',
        changeOrigin: true,
        secure:false,//解决自签名证书错误
        rewrite: (path) => path.replace(/^\/encode/, '')
      },
    }
 },
})
