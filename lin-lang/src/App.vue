<template>
  <div id="app">
    <!-- caiwu 123456q -->
    <llHeader @unActiveEmit="unActive"/>
    <llSearch />
    <div class="rowMenu">
      <div class="menuFrm center">
        <el-menu class="el-menu-demo" text-color="#666" :active-text-color="onColor"
        :default-active="activeIndex"
        router
        mode="horizontal"
        @select="handleSelect">
          <el-menu-item v-for="item in unChildTab" :key="item.path" :index="item.path" class="navItem" onselectstart="return false">{{ item.name }}</el-menu-item>
          <el-submenu v-for="(item, key) in childTab" :key="key" :index="String(key)">
            <template slot="title">{{ item.name }}</template>
            <el-menu-item v-for="(subItem, subKey) in item.child" :key="subKey" :index="subItem.path" class="nav-subItem-width" onselectstart="return false">{{ subItem.name }}</el-menu-item>
          </el-submenu>  
        </el-menu>
      </div>
    </div>
    <router-view></router-view>
    <llFooter />
  </div>
</template>

<script>
import Header from "./components/Header"
import Search from "./components/Search"
import Footer from "./components/Footer"

export default {
  name: 'App',  
  data() {
    return {
      activeIndex: '1',
      onColor: "#ff366f",
      navList:[
        {path:'/', name:'首页'},
        {path:'/storeReader', name:'商家必读'},
        {path:'/betterNum', name:'提高申请人数'},
        {path:'/advertisement', name:'广告位服务'},
        {path:'/taskList', name:'任务列表'},
        {name:'热门商品分类', child: [
          {path:'/a', name:'潮流女装'},
          {path:'/b', name:'时尚男装'},
          {path:'/c', name:'美食特产'},
          {path:'/d', name:'家纺家装'},
          {path:'/e', name:'数码家电'},
          {path:'/f', name:'母婴用品'},
          {path:'/g', name:'日用百货'},
          {path:'/gg', name:'鞋类箱包'},
          {path:'/g', name:'精品配饰'},
          {path:'/g', name:'护肤彩妆'},
          {path:'/g', name:'内衣内裤'},
          {path:'/g', name:'车品车饰'},
          {path:'/g', name:'户外运动'},
          {path:'/g', name:'医疗保险'}
        ]}
      ],
      numq:7
    };
  },
  watch: {
    $route(){
      this.handleSelect(this.activeIndex)
    }
  },
  mounted(){
    this.activeIndex = this.$route.matched[0].path || '/'

    let itemArr = document.getElementsByClassName("nav-subItem-width");
    for(let item of itemArr){
      item.style.height = "32px"
      item.style.lineHeight = "32px"
    }
    itemArr[0].parentNode.style.minWidth = "140px"
    itemArr[0].parentNode.style.padding = "0 15px"
  },
  methods: {
    handleSelect(index){
      this.activeIndex = index
    },
    unActive(){
      $(".rowMenu").find(".is-active").addClass("unActive")
    }
  },
  computed: {
    childTab: function(){
      return this.navList.filter(item => item.child);
    },
    unChildTab: function(){
      return this.navList.filter(item => !item.child);
    }
  },
  components: {
    "llHeader" : Header,
    "llSearch" : Search,
    "llFooter" : Footer
  }
}
</script>

<style>
*{
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  font-style: normal;
}
.clearfix{
  zoom: 1;
}
.clearfix:after{
  content: "\20";
  display: block;
  height: 0;
  clear: both;
}
body{
  font-family: "Helvetica Neue",Helvetica,"PingFang SC","Hiragino Sans GB","Microsoft YaHei","微软雅黑",Arial,sans-serif;
  font-size: 14px;
  color: #666;
}
a{
  text-decoration: none;
}
:root{
  --on-color: #ff366f;
  --off-color: #999;
}
.nav_center{
    width: 1200px;
    margin: auto;
}
.myfl{
    float: left;
}
.myfr{
    float: right;
}
ul{
  list-style: none;
}
.el-col {
  border-radius: 4px;
  padding: 0 15px 15px;
}
.bg-purple-light {
  background: #fafafa;
  padding: 15px;
}
.grid-content {
  border-radius: 4px;
  min-height: 36px;
}
.row-bg {
  padding: 10px 0;
  background-color: #f9fafc;
}
.bg-purple-light .title{
  height: 40px;
  line-height: 40px;
  font-weight: bold;
  font-size: 16px;
  border-bottom: 1px solid #b9b9b9;
}
.npBtn{
  height: 50px;
  width: 50px;
  border-radius: 100%;
  cursor: pointer;
  display: inline-block;
}
.npBtn.next{
  background: var(--on-color) url(./assets/go-to-link.png) no-repeat;
  background-size: 100%;
}
.npBtn.prev{
  background: var(--on-color) url(./assets/go-prev-link.png) no-repeat;
  background-size: 100%;
  margin-right: 20px;
}
.center{
  text-align: center;
}

/**由于element-ui组件中的下拉框是全局的，所以放在这里 */
.el-select-dropdown__item.selected{
  color: var(--on-color);
}
</style>
<style scoped>
.menuFrm{
  border-bottom: solid 1px #e6e6e6;
}
.el-menu.el-menu--horizontal{
  display: inline-block;
  border-bottom: 0;
}
.nav-index{
  display: inline-block;
  vertical-align: middle;
  margin-left: 15px;
  font-size: 0;
}
.nav-index li{
  display: inline-block;
  padding: 10px 20px;
  cursor: pointer;
  user-select:none;
  font-size: 16px;
  border-bottom: 2px solid #fff;
}
.nav-index li:hover, .nav-index .router-link-exact-active{
  color: var(--on-color);
  border-bottom: 2px solid #ff366f !important;
}
.unActive{
    color: #303133 !important;
    border-bottom-color: transparent !important;
}
.navItem:hover{
  color: var(--on-color) !important;
}
.el-menu--horizontal>.el-menu-item, #app >>>.el-menu--horizontal>.el-submenu .el-submenu__title{
  height: 40px;
  line-height: 40px;
}
.el-menu-item{
  font-size: 16px;
}
</style>
