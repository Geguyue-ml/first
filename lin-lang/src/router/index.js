import Vue from 'vue'
import Router from 'vue-router'
import Home from '../components/Home'
import StoreReader from '../components/StoreReader'
import GoodsDetails from '../components/GoodsDetails'
import Advertisement from '../components/advertisement'
import BetterNum from '../components/betterNum'
import TryDetails from '../components/goodsDetails/TryDetails'
import TryAppraise from '../components/goodsDetails/TryAppraise'
import TryPoint from '../components/goodsDetails/TryPoint'
import Personal from '../components/Personal'

Vue.use(Router)

export default new Router({
  routes: [
    {path: '/', name: 'homeLink', component: Home},
    {path: '/storeReader', name: 'storeReaderLink', component: StoreReader},
    {path: '/goodsDetails', name: 'goodsDetailsLink', component: GoodsDetails, redirect: "/tryDetails", children: [
      {path: '/tryDetails', name: 'tryDetails', component: TryDetails},
      {path: '/tryAppraise', name: 'tryAppraise', component: TryAppraise},
      {path: '/tryPoint', name: 'tryPoint', component: TryPoint},
    ]},
    {path: '/betterNum', name: 'betterNum', component: BetterNum},
    {path: '/advertisement', name: 'advertisement', component: Advertisement},
    {path: '/personal', name: 'personal', component: Personal},
  ],
  mode: 'history'
})
