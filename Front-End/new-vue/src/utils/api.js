import axios from 'axios'
import { Message } from 'element-ui'

axios.interceptors.request.use(config => {
  return config
}, err => {
  Message.error({ message: '请求超时!' })
  return Promise.resolve(err)
})

let base = ''
export const getRequest = (url) => {
  alert('111')
  return axios({
    method: 'get',
    url: `${base}${url}`
  })
}
