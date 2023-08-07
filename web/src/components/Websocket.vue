<script setup lang="ts">
import { onBeforeUnmount, ref, shallowRef, onMounted } from 'vue'
import axios from "axios";
import { Tool } from "../util/tool"
import { ElMessage } from 'element-plus'
let websocket: any;
let token: any;

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
    // // WebSocket
    // if ('WebSocket' in window) {
    //     token = Tool.uuid(10);
    //     // 连接地址：ws://127.0.0.1:8880/ws/xxx
    //     const url = "ws://127.0.0.1:8080/ws/" + token
    //     websocket = new WebSocket(url);
    //     await initWebSocket()
    //     // 关闭
    //     // websocket.close();s
    // } else {
    //     alert('当前浏览器 不支持')
    // }
})

</script>

<template></template>

<style scoped></style>
