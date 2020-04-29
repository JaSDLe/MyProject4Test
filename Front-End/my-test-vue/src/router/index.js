import Vue from 'vue'
import Router from 'vue-router'

import Index from '@/views/Index'
import CORS from '@/views/CORS'
import File from '@/views/File'
import Page from '@/views/Page'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Index',
      component: Index
    },
    {
      path: '/cors',
      name: 'CORS',
      component: CORS
    },
    {
      path: '/file',
      name: 'File',
      component: File
    },
    {
      path: '/page',
      name: 'Page',
      component: Page
    }
  ]
})
