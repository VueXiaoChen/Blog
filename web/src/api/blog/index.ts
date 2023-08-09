import { request } from "@/utils/service"
import type * as Blog from "./types/index"
import { log } from "console"

/** 获取未审核的博客 */
export function GetUnauditedBlogApi(userid) {
  return request<any>({
    url: "api/blog/list?blogStatus=0&userid=" + userid,
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

