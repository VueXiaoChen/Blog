<script setup lang="ts">
import { ref,onMounted } from 'vue'
import request from '../service'
const count = ref(0)
onMounted(async () => {
})

</script>

<template>
 <div class="div">{{count}}</div>
</template>

<style scoped>

</style>
