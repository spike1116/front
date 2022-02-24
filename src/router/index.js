import { createRouter, createWebHistory } from 'vue-router'
import Test from '../views/test.vue'
import Login from '../views/Login.vue'
import Layout from '../layout/layout.vue'
import Register from '../views/Register.vue'
import Home from '../views/Home.vue'

const routes = [
  {
    path: '/',
    name: 'layout',
    component: Layout,
    children:[{
      path: '/test',
      name: 'test',
      component: Test,
    },{
      path: '/',
      name: 'Home',
      component: Home,
    },


    ]
  },
  {
    path: '/login',
    name: 'Login',
    component: Login
  },
  {
    path: '/register',
    name: 'Register',
    component: Register
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
