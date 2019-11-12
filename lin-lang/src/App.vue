<template>
  <div id="app">
    <!-- caiwu 123456q -->
    <llHeader />
    <llSearch />
    <div class="rowMenu">
      <div class="nav_center">
        <el-menu class="el-menu-demo" text-color="#000" :active-text-color="onColor"
        :default-active="activeIndex"
        router
        mode="horizontal"
        @select="handleSelect">
          <el-menu-item v-for="item in unChildTab" :key="item.path" :index="item.path">{{ item.name }}</el-menu-item>
          <el-submenu v-for="(item, key) in childTab" :key="key" :index="String(key)">
            <template slot="title">{{ item.name }}</template>
            <el-menu-item v-for="(subItem, subKey) in item.child" :key="subKey" class="nav-subItem-width">{{ subItem.name }}</el-menu-item>
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
      activeIndex2: '1',
      activeIndex: "/",
      onColor: "#ff366f",
      navList:[
        {path:'/', name:'首页'},
        {path:'/storeReader', name:'商家必读'},
        {path:'/betterNum', name:'提高申请人数'},
        {path:'/advertisement', name:'广告位服务'},
        {path:'/personal', name:'个人中心'},
        {name:'热门试用分类', child: [
          {path:'/', name:'潮流女装'},
          {path:'/', name:'时尚男装'},
          {path:'/', name:'美食特产'},
          {path:'/', name:'家纺家装'},
          {path:'/', name:'数码家电'},
          {path:'/', name:'母婴用品'},
          {path:'/', name:'日用百货'},
          {path:'/', name:'鞋类箱包'},
          {path:'/', name:'精品配饰'},
          {path:'/', name:'护肤彩妆'},
          {path:'/', name:'内衣内裤'},
          {path:'/', name:'车品车饰'},
          {path:'/', name:'户外运动'},
          {path:'/', name:'医疗保险'}
        ]}
      ]
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
.clearfix::after{
  content: "\20";
  display: block;
  height: 0;
  clear: both;
}
body{
  font-family: "microsoft yahei";
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
.rowMenu{
  background-color: #fff;
}
</style>
