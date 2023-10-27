<script setup lang="ts">
import { onBeforeUnmount, ref, shallowRef, onMounted ,reactive} from 'vue'
import axios from "axios";
import { Tool } from "../../utils/tool"
import { ElMessage } from 'element-plus'
import { useUserStore } from "@/store/modules/user"
let websocket: any;
let token: any;
/** 调用user Pian */
const user = reactive(JSON.parse(sessionStorage.getItem("user")))
const onOpen = () => {
    console.log('WebSocket连接成功，状态码：', websocket.readyState)
};
const onMessage = (event: any) => {
    console.log('WebSocket收到消息：', event.data);
    ElMessage({
        message:event.data,
        type: 'success',
    })
};
const onError = () => {
    console.log('WebSocket连接错误，状态码：', websocket.readyState)
};
const onClose = () => {
    console.log('WebSocket连接关闭，状态码：', websocket.readyState)
};
const initWebSocket = () => {
    // 连接成功
    websocket.onopen = onOpen;
    // 收到消息的回调
    websocket.onmessage = onMessage;
    // 连接错误
    websocket.onerror = onError;
    // 连接关闭的回调
    websocket.onclose = onClose;
};
onMounted(async() => {
    console.log(user.userid);
    // WebSocket
    if ('WebSocket' in window) {
        //token = Tool.uuid(10);
        token = "userid"+user.userid
        // 连接地址：ws://127.0.0.1:8080/ws/xxx
        const url = "ws://127.0.0.1:8080/ws/" + token
        websocket = new WebSocket(url);
        await initWebSocket()
        // 关闭
        // websocket.close();s
    } else {
        alert('当前浏览器 不支持')
    }
    
    
})

</script>

<template></template>

<style scoped></style>
