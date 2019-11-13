<template>
  <div id="personal">
    <div class="nav_center">
      <div class="personalBody">
        <el-row class="tac">
          <el-col :span="4" class="tacFrm">
            <el-menu background-color="#fff" text-color="#000" :active-text-color="onColor"
            :default-active="activeIndex"
            :default-openeds="[openTab]"
            router
            @open="getTab"
            @select="handleSelect">
              <el-submenu v-for="(item, i) in navList" :key="i" :index="String(i)">
                <template slot="title">
                  <i :class="item.classN"></i>
                  <span>{{item.name}}</span>
                </template>
                <el-menu-item v-for="(subItem, subKey) in item.child" :key="subKey" :index="subItem.path">{{subItem.name}}</el-menu-item>
              </el-submenu>
            </el-menu>
          </el-col>
          <router-view></router-view>
        </el-row>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Personal',
  data(){
    return {
      onColor: "#ff366f",
      activeIndex: "/",
      openTab: "0",
      navList: [
        {name: "个人中心", classN: "el-icon-s-custom", child: [
          {path: '/personal/basicInfo', name: "基本信息"},
          {path: "/personal/blackList", name: "黑名单"},
          {path: "/personal/newsManage", name: "消息管理"}
        ]},
        {name: "任务管理", classN: "el-icon-tickets", child: [
          {path: "/personal/taskManagement", name: "试用任务进展"},
          {path: "/personal/checkedOrder", name: "查询试客订单"}
        ]},
        {name: "店铺管理", classN: "el-icon-takeaway-box", child: [
          {path: "/", name: "淘宝店铺"},
          {path: "/", name: "天猫店铺"},
          {path: "/", name: "京东店铺"}
        ]},
        {name: "资金管理", classN: "el-icon-money", child: [
          {path: "/personal/pushGold", name: "充值金豆"},
          {path: "/personal/prolongateTime", name: "延长技术服务时长"},
          {path: "/personal/capitalRecord", name: "资金记录"},
          {path: "/personal/cash", name: "提现"},
        ]}
      ]
    }
  },
  watch: {
    $route(){
      this.handleSelect(this.activeIndex)
      this.getTab(this.openTab)
    }
  },
  mounted(){
    this.activeIndex = this.$route.matched[1].path || '/'
    this.navList.find((item, key) => {
      if(item.child.filter(subItem => subItem.path == this.activeIndex).length != 0){
        this.openTab = String(key)
      }
    })
  },
  methods: {
    handleSelect(index){
      this.activeIndex = index
    },
    getTab(index){
      this.openTab = index
    }
  }
}
</script>

<style scoped>
#personal{
  margin-top: 30px;
}
.personalBody .el-menu{
  overflow: hidden;
  border-right: none;
}
.tacFrm{
  border-right: 1px solid #e6e6e6;
}
</style>
