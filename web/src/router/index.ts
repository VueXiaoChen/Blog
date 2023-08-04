import { createRouter, createWebHistory } from "vue-router";

//理由地址配置
const routes=[
    {
        path:"/",
        name:"",
        component:()=>import("../components/Loading.vue")
    },
]

//添加到创建的路由中
const router=createRouter({
    history:createWebHistory(),
    routes
})

export default router
