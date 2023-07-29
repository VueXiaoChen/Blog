<script setup lang="ts">
import { onBeforeUnmount, ref, shallowRef, onMounted } from 'vue'
import axios from "axios";
import '@wangeditor/editor/dist/css/style.css'
import { Editor,Toolbar } from '@wangeditor/editor-for-vue'
const count = ref(0)
// async function ceshi(){
//     axios.post("encode/HotComments",{
//         format : 'json',
//     }).then((res)=>{
//         console.log(res);   
//     })
// }


const mode = ref('default')
// 编辑器实例，必须用 shallowRef
const editorRef = shallowRef()
const toolbarConfig = {}
const editorConfig = { placeholder: '请输入内容...' }

// 组件销毁时，也及时销毁编辑器
onBeforeUnmount(() => {
    const editor = editorRef.value
    if (editor == null) return
    editor.destroy()
})

const handleCreated = (editor: any) => {
    editorRef.value = editor // 记录 editor 实例，重要！
}
// 内容 HTML
const valueHtml = ref('<p style="text-align: left;"><strong>我不是人么</strong></p><p style="text-align: left;"><span style="color: rgb(245, 219, 77);">我就不是人么</span></p><p style="text-align: left;"><span style="color: rgb(0, 0, 0);"><strong>测试一下我的</strong></span></p><p style="text-align: left;"><span style="color: rgb(0, 0, 0);">字体是是吗</span></p><p style="text-align: left;"><span style="color: rgb(0, 0, 0);"><u><em>测电动阿松大</em></u></span></p><p style="text-align: left;"><span style="color: rgb(0, 0, 0);">🤔🤡👀</span></p>')

function ceshi(){
    console.log(valueHtml.value);
    
}
onMounted(async () => {
    // setTimeout(() => {
    //     valueHtml.value = '<p>模拟 Ajax 异步设置内容</p>'
    // }, 1500)
})


</script>

<template>
    <div style="border: 1px solid #ccc">
        <Toolbar style="border-bottom: 1px solid #ccc" :editor="editorRef" :defaultConfig="toolbarConfig" :mode="mode" />
        <Editor style="height: 700px; overflow-y: hidden;" v-model="valueHtml" :defaultConfig="editorConfig" :mode="mode"
            @onCreated="handleCreated" />
    </div>
    <el-button @click="ceshi">测试</el-button>
</template>

<style scoped></style>
