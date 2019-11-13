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
import BasicInfo from '../components/perssonal/BasicInfo'
import BlackList from '../components/perssonal/BlackList'
import CapitalRecord from '../components/perssonal/CapitalRecord'
import Cash from '../components/perssonal/Cash'
import CheckedOrder from '../components/perssonal/CheckedOrder'
import NewsManage from '../components/perssonal/NewsManage'
import ProlongateTime from '../components/perssonal/ProlongateTime'
import PushGold from '../components/perssonal/PushGold'
import TaskManagement from '../components/perssonal/TaskManagement'

const routerPush = Router.prototype.push
Router.prototype.push = function push(location) {
  return routerPush.call(this, location).catch(error=> error)
}

Vue.use(Router)

export default new Router({
  routes: [
    {path: '/', name: 'home', component: Home},
    {path: '/storeReader', name: 'storeReader', component: StoreReader},
    {path: '/goodsDetails', name: 'goodsDetails', component: GoodsDetails, redirect: "/goodsDetails/tryDetails", children: [
      {path: '/goodsDetails/tryDetails', name: 'tryDetails', component: TryDetails},
      {path: '/goodsDetails/tryAppraise', name: 'tryAppraise', component: TryAppraise},
      {path: '/goodsDetails/tryPoint', name: 'tryPoint', component: TryPoint},
    ]},
    {path: '/betterNum', name: 'betterNum', component: BetterNum},
    {path: '/advertisement', name: 'advertisement', component: Advertisement},
    {path: '/personal', name: 'personal', component: Personal, redirect: "/personal/basicInfo", children: [
      {path: "/personal/basicInfo", name: "basicInfo", component: BasicInfo},
      {path: "/personal/blackList", name: "blackList", component: BlackList},
      {path: "/personal/capitalRecord", name: "capitalRecord", component: CapitalRecord},
      {path: "/personal/cash", name: "cash", component: Cash},   
      {path: "/personal/checkedOrder", name: "checkedOrder", component: CheckedOrder},
      {path: "/personal/newsManage", name: "newsManage", component: NewsManage},
      {path: "/personal/prolongateTime", name: "prolongateTime", component: ProlongateTime},
      {path: "/personal/taskManagement", name: "taskManagement", component: TaskManagement},
      {path: "/personal/pushGold", name: "pushGold", component: PushGold}
    ]},
  ],
  mode: 'history'
})
