import createWebServiceHelper from '@/utils/requestUtil'

const request = createWebServiceHelper(process.env.VUE_APP_BASE_API)

// 分页查询
export function userList(data) {
  return request({
    url: `/userc`,
    method: 'post',
    data
  })
}

// // 通过url查询
// export function referenceUrlFindByUrl(url) {
//   return request({
//     url: `/platformApi/referenceUrl/findByUrl`,
//     method: 'post',
//     params: { url }
//   })
// }

// // 通过projectName查询
// export function referenceUrlFindByProjectName(projectName) {
//   return request({
//     url: `/platformApi/referenceUrl/findByProjectName`,
//     method: 'post',
//     params: { projectName }
//   })
// }

// // 通过url和projectName查询
// export function referenceUrlFindByUrlAndProjectName(url, projectName) {
//   return request({
//     url: `/platformApi/referenceUrl/findByUrlAndProjectName`,
//     method: 'post',
//     params: { url, projectName }
//   })
// }
