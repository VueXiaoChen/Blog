<script lang="ts" setup>
import { ref, watch,reactive,onMounted  } from "vue"
import {useRoute, useRouter } from "vue-router"
import { type FormInstance, type FormRules, ElMessage, ElMessageBox } from "element-plus"
import { Search, Refresh, CirclePlus, Delete, Download, RefreshRight } from "@element-plus/icons-vue"
import { usePagination } from "@/hooks/usePagination"
import { GetvideoaddressApi,GetvideoaddressUpdateOrAddApi } from "@/api/videoaddress/index"
import { useUserStore } from "@/store/modules/user"
const route = useRoute()
const router = useRouter()
/** 调用user Pian */
const user = useUserStore()
const loading = ref<boolean>(false)
const { paginationData, handleCurrentChange, handleSizeChange } = usePagination()
const dialogFormVisible = ref(false)
const formLabelWidth = ref(120)
const updatedata = ref(
  {
    videotag: '',
    videosource: '',
    videoaddress: '',
  }
)
const oldupdatedata = ref()
const resetSearch = () => {
  searchData.videotag=''
  searchData.videosource=''
  searchData.videoaddress=''
  ElMessage({
    message: '重置成功',
    type: 'success',
  })
}

const searchData = reactive({
  videotag: "",
  videosource: "",
  videoaddress:"",
})
const oldtableData = ref([])
const tableData = ref([
  {
    videotag: "1",
    videosource: "2",
    videoaddress:"3",
  },
  {
    videotag: "4",
    videosource: "5",
    videoaddress:"6",
  },
])

const SearchAll = () => {
  if(searchData.videotag == "" && searchData.videosource == "" && searchData.videoaddress == ""){
    ElMessage.error('请输入查询的数据')
    return
  }
  let newtabledata = []
  if(searchData.videotag!= null && searchData.videotag != ""){
    for(let i=0;i<tableData.value.length;i++){
      if(tableData.value[i].videotag.indexOf(searchData.videotag)!=-1){
        newtabledata.push(tableData.value[i])
      }
    }
    console.log(newtabledata);
    tableData.value= []
    tableData.value = newtabledata
    paginationData.total = tableData.value.length
    newtabledata= []
  }
  if(searchData.videosource!= null && searchData.videosource != ""){
    for(let i=0;i<tableData.value.length;i++){
    if(tableData.value[i].videosource.indexOf(searchData.videosource)!=-1){
      newtabledata.push(tableData.value[i])
    }
  }
    tableData.value= []
    tableData.value = newtabledata
    paginationData.total = tableData.value.length
    newtabledata= []
  }
  if(searchData.videoaddress!= null && searchData.videoaddress != ""){
    for(let i=0;i<tableData.value.length;i++){
    if(tableData.value[i].videoaddress.indexOf(searchData.videoaddress)!=-1){
      newtabledata.push(tableData.value[i])
    }
  }
    tableData.value= []
    tableData.value = newtabledata
    paginationData.total = tableData.value.length
    newtabledata= []
  }
  ElMessage({
    message: '查询成功',
    type: 'success',
  })
}

/** 视频地址获取 */
const Getvideoaddress = (currentPage,pagesize) => {
  return new Promise((resolve,reject)=>{
    GetvideoaddressApi(currentPage,pagesize).then((res:any)=>{
      if(res){   
        tableData.value = res.data.list        
        oldtableData.value = res.data.list      
        paginationData.total = res.data.total
      }
    }).catch((error)=>{
      reject(error)
      console.log(error);
    })
  })
}
/** 视频地址修改 */
const updatevideoaddress = () => {
  return new Promise((resolve,reject)=>{ 
    GetvideoaddressUpdateOrAddApi(updatedata.value).then((res:any)=>{
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


//获取修改的内容
function GetUpdatadata(item){
  dialogFormVisible.value =true
  updatedata.value = item
  oldupdatedata.value = item
}
//监听分页
watch(()=>[paginationData.currentPage,paginationData.pageSize],(newValue, oldValue) => {
  Getvideoaddress(paginationData.currentPage,paginationData.pageSize)
});

onMounted(() => {
  Getvideoaddress(paginationData.currentPage,paginationData.pageSize)
});
</script>

<template>
  
  <div class="app-container">
    <el-card v-loading="loading" shadow="never" class="search-wrapper">
      <el-form ref="searchFormRef" :inline="true" :model="searchData">
        <el-form-item prop="videotag" label="视频标签">
          <el-input v-model="searchData.videotag" placeholder="请输入" />
        </el-form-item>
        <el-form-item prop="videosource" label="视频来源">
          <el-input v-model="searchData.videosource" placeholder="请输入" />
        </el-form-item>
        <el-form-item prop="videoaddress" label="视频地址">
          <el-input v-model="searchData.videoaddress" placeholder="请输入" />
        </el-form-item>
        <el-form-item>
          <el-button type="primary" :icon="Search" @click="SearchAll()">查询</el-button>
          <el-button :icon="Refresh" @click="resetSearch">重置</el-button>
        </el-form-item>
      </el-form>
    </el-card>
    <el-card v-loading="loading" shadow="never">
      <div class="toolbar-wrapper">
        <div>
          <el-button type="danger" :icon="Delete">批量删除</el-button>
        </div>
        <div>
          <el-tooltip content="下载">
            <el-button type="primary" :icon="Download" circle />
          </el-tooltip>
          <el-tooltip content="刷新当前页">
            <el-button type="primary" :icon="RefreshRight" circle @click="" />
          </el-tooltip>
        </div>
      </div>
      <div class="table-wrapper">
        <el-table :data="tableData">
          <el-table-column type="selection" width="50" align="center" />
          <el-table-column type="index" width="50" />
          <el-table-column prop="videotag" label="视频标签" width="160" align="center" :show-overflow-tooltip="true"/>
          <el-table-column prop="videosource" label="视频来源"  align="center"  :show-overflow-tooltip="true"/>
          <el-table-column prop="videoaddress" label="视频地址"  align="center"  :show-overflow-tooltip="true"/>
          <el-table-column fixed="right" label="操作" width="250" align="center">
            <template #default="scope">
              <el-button type="primary"  @click="GetUpdatadata(scope.row)">修改</el-button>
              <el-button type="danger"  @click="">删除</el-button>
            </template>
          </el-table-column>
        </el-table>
      </div>
      <div class="pager-wrapper">
        <el-pagination
          background
          :layout="paginationData.layout"
          :page-sizes="paginationData.pageSizes"
          :total="paginationData.total"
          :page-size="paginationData.pageSize"
          :currentPage="paginationData.currentPage"
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
        />
      </div>
    </el-card>
    <el-dialog v-model="dialogFormVisible" title="修改" center>
    <el-form :model="updatedata">
      <el-form-item label="视频标签：" :label-width="formLabelWidth">
        <el-input v-model="updatedata.videotag" autocomplete="off" />
      </el-form-item>
      <el-form-item label="视频来源：" :label-width="formLabelWidth">
        <el-input v-model="updatedata.videosource" autocomplete="off" />
      </el-form-item>
      <el-form-item label="视频地址：" :label-width="formLabelWidth">
        <el-input v-model="updatedata.videoaddress" autocomplete="off" />
      </el-form-item>
    </el-form>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogFormVisible = false" round>取消</el-button>
        <el-button type="primary" round @click="updatevideoaddress">
          确定
        </el-button>
      </span>
    </template>
  </el-dialog>
  </div>
  
</template>

<style lang="scss">
.search-wrapper {
  margin-bottom: 20px;
  :deep(.el-card__body) {
    padding-bottom: 2px;
  }
}

.toolbar-wrapper {
  display: flex;
  justify-content: space-between;
  margin-bottom: 20px;
}

.table-wrapper {
  margin-bottom: 20px;
}

.pager-wrapper {
  display: flex;
  justify-content: flex-end;
}
// .el-overlay-dialog{
//   :deep(.el-dialog) {
//     border-radius: 20px; 
//   }
// }
.app-container .el-dialog--center{
  border-radius: 20px !important;
}

</style>
