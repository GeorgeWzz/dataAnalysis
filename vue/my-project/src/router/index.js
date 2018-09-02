import Vue from 'vue'
import Router from 'vue-router'
import HomePage from '@/components/HomePage'
import Randompick from '@/components/Randompick'
import czytest from '@/components/czytest'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/randompick',
      name: 'Randompick',
      component: Randompick
    },
    {
      path: '/',
      name: 'HomePage',
      component: HomePage
    },
    {
      path: '/czytest',
      name: 'czytest',
      component: czytest
    }
  ]
})
