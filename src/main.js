import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import '@/css/global.css'

import ElementPlus from 'element-plus'
import zhCn from 'element-plus/es/locale/lang/zh-cn'
import 'element-plus/dist/index.css'
import * as icons from '@element-plus/icons'
const app=createApp(App)

app.use(router)
app.use(ElementPlus,{locale:zhCn})

app.mount('#app')
Object.keys(icons).forEach(key => {
    app.component(key, icons[key])
})
// createApp(App).use(router).use(ElementPlus).mount('#app')
