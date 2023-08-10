import { request } from "@/utils/service"
import type * as Blog from "./types/index"
import { log } from "console"

/** 获取审核的博客 */
export function GetBlogApi(userid,currentPage,pagesize) {
  return request<any>({
    url: "api/blog/list?blogStatus=1&userid=" + userid+"&page="+currentPage+"&size="+pagesize,
    method: "get"
  })
}
/** 获取w未审核的博客 */
export function GetUnauditedBlogApi(userid,currentPage,pagesize) {
  return request<any>({
    url: "api/blog/list?blogStatus=0&userid=" + userid+"&page="+currentPage+"&size="+pagesize,
    method: "get"
  })
}

/** 博客修改或增加 */
export function GetBloguodate(data) {
  return request<any>({
    url: "api/blog/save",
    method: "post",
    data
  })
}

