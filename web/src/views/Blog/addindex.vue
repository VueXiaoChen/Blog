<script lang="ts" setup>
import { ref, watch, reactive,onMounted } from "vue"
import type { FormInstance, FormRules } from 'element-plus'
import { GetBlogTypeApi,GetBlogTagApi,GetBlogUpdateOrAddApi } from "@/api/blog/index"
const loading = ref<boolean>(false)


const formSize = ref('default')
const ruleFormRef = ref<FormInstance>()
const ruleForm = reactive<any>({
  blogTitle: '',
  coverImage: '',
  typeId: '',
  blogContent: '',
  tagBlog: [],
})
//博客类型数组
const bolgtype = ref()
//博客标签数组
const bolgtag = ref([])
const rules = reactive<FormRules<RuleForm>>({
  
})
//typeId
const typeName = ref()
const tag = ref()


const resetForm = (formEl: FormInstance | undefined) => {
  if (!formEl) return
  formEl.resetFields()
}

const options = Array.from({ length: 10000 }).map((_, idx) => ({
  value: `${idx + 1}`,
  label: `${idx + 1}`,
}))


/** 博客类型获取 */
const GetBlogType = () => {
  return new Promise((resolve,reject)=>{
    GetBlogTypeApi().then((res:any)=>{
      if(res){   
        bolgtype.value = res.data.list
        console.log(res);
      }
    }).catch((error)=>{
      reject(error)
      console.log(error);
    })
  })
}
/** 博客标签获取 */
const GetBlogTag = () => {
  return new Promise((resolve,reject)=>{
    GetBlogTagApi().then((res:any)=>{
      if(res){   
        bolgtag.value = res.data.list
        console.log(bolgtag.value);
      }
    }).catch((error)=>{
      reject(error)
      console.log(error);
    })
  })
}

/** 博客增加 */
const GetBlogUpdateOrAdd = (ruleForm) => {
  return new Promise((resolve,reject)=>{
    console.log(ruleForm);
    GetBlogUpdateOrAddApi(ruleForm).then((res:any)=>{
      if(res){   
        console.log(res);
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
      console.log('submit!')
    } else {
      console.log('error submit!', fields)
    }
  })
}
function BlogRadioChange(typeId){
  ruleForm.typeId = typeId
}

function BlogCheckRadioChange(item){
  ruleForm.tagBlog.push(item)
}

onMounted(() => {
  GetBlogType()
  GetBlogTag()
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
        <el-form-item label="文章标题：" prop="blogTitle">
          <el-input v-model="ruleForm.blogTitle" />
        </el-form-item>
        <el-form-item label="文章图片：" prop="coverImage">
          <el-input v-model="ruleForm.coverImage" />
        </el-form-item>
        <el-form-item label="文章类型：" prop="typeName">
          <el-radio-group v-model="typeName">
            <el-radio :label=item.typeName v-for="(item,index) in bolgtype" :key="index" @change="BlogRadioChange(item.typeId)"/>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="文章标签：" prop="tag">
          <el-checkbox-group v-model="tag">
            <el-checkbox :label="item.tagName" :name="item.tagName" v-for="(item,index) in bolgtag" :key="index" @change="BlogCheckRadioChange(item)"/>
          </el-checkbox-group>
        </el-form-item>
        <el-form-item label="文章内容：" prop="blogContent">
          <el-input v-model="ruleForm.blogContent" type="textarea" />
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
    width: 30%;
  }
}
</style>
