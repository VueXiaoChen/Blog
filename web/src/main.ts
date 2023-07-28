import { createApp } from 'vue'
import './style.css'
import App from './App.vue'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import router from './router/index'
import axios from 'axios'
import VueAxios from 'vue-axios'
const app = createApp(App)

app.use(VueAxios,axios).use(ElementPlus).use(router).mount('#app')
