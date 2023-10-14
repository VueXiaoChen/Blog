<script lang="ts" setup>
import { ref, watch, reactive,onMounted,shallowRef,onBeforeUnmount } from "vue"
import {type FormInstance,FormRules,ElMessage } from 'element-plus'
import { GetvideoaddressApi,GetvideoaddressUpdateOrAddApi } from "@/api/videoaddress/index"
import { useUserStore } from "@/store/modules/user"

const loading = ref<boolean>(false)
const user = useUserStore()
const ruleFormRef = ref<FormInstance>()
const formSize = ref('default')
const ruleForm = reactive<any>({
  videotag: '',
  videosource: '',
  videoaddress: '',
})

const rules = reactive<FormRules>({
  videotag: [
    { required: true, message: '视频标题不能为空', trigger: 'blur' },
  ],
  videosource: [
    { required: true, message: '视频来源不能为空', trigger: 'blur' },
  ],
  videoaddress: [
    { required: true, message: '视频地址不能为空', trigger: 'blur' },
  ],
})

const resetForm = (formEl: FormInstance | undefined) => {
  if (!formEl) return
  formEl.resetFields()
}
/** 博客增加 */
const GetBlogUpdateOrAdd = (ruleForm: any) => {
  return new Promise((resolve,reject)=>{
    GetvideoaddressUpdateOrAddApi(ruleForm).then((res:any)=>{
      if(res){   
        ElMessage({
          message: res.message,
          type: 'success',
        })
      }
    }).catch((error)=>{
      reject(error)
      console.log(error);
    })
  })
}

const submitForm = async (formEl: FormInstance | undefined) => {
  if (!formEl) return
  await formEl.validate((valid, fields) => {
    if (valid) {
      GetBlogUpdateOrAdd(ruleForm)
    } else {
      console.log('error submit!', fields)
    }
  })
}


onMounted(() => {
  

});

</script>

<template>
  <div class="app-container">
    <el-card v-loading="loading" shadow="never" class="search-wrapper">
      <el-form
        ref="ruleFormRef"
        :model="ruleForm"
        :rules="rules"
        label-width="120px"
        class="demo-ruleForm"
        :size="formSize"
        status-icon
      >
        <el-form-item label="视频标签：" prop="videotag" required>
          <el-input v-model="ruleForm.videotag" />
        </el-form-item>
        <el-form-item label="视频来源：" prop="videosource" required>
          <el-input v-model="ruleForm.videosource" />
        </el-form-item>
        <el-form-item label="视频地址：" prop="videoaddress" required>
          <el-input v-model="ruleForm.videoaddress" />
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submitForm(ruleFormRef)">创建</el-button>
          <el-button @click="resetForm(ruleFormRef)">重置</el-button>
        </el-form-item>
      </el-form>
    </el-card>
  </div>
</template>

<style lang="scss" scoped>
.search-wrapper {
  margin-bottom: 20px;
  :deep(.el-card__body) {
    padding-bottom: 2px;
  }
}
.app-container{
  :deep(.el-input){
    width: 80%;
  }
}
</style>
