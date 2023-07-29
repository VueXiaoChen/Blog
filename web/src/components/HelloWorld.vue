<script setup lang="ts">
import { ref,onMounted } from 'vue'
import axios from "axios";
const count = ref(0)
// async function ceshi(){
//     axios.post("encode/HotComments",{
//         format : 'json',
//     }).then((res)=>{
//         console.log(res);   
//     })
// }

onMounted(async () => {
    
})


</script>

<template>
 <div class="div">{{count}}</div>
</template>

<style scoped>

</style>
