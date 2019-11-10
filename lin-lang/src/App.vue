<template>
  <div id="app">
    <!-- caiwu 123456q -->
    <llHeader />
    <llSearch />
    <div class="banner">
      <div class="nav_center">
        <div class="CATEGORY">
          <span>热门试用分类</span>
          <img src="./assets/list.png">
          <div class="CATEGORY-infoFrm">
            <ul>
              <li>潮流女装</li>
              <li>时尚男装</li>
              <li>美食特产</li>
              <li>家纺家装</li>
              <li>数码家电</li>
              <li>母婴用品</li>
              <li>日用百货</li>
              <li>鞋类箱包</li>
              <li>精品配饰</li>
              <li>护肤彩妆</li>
              <li>内衣内裤</li>
              <li>车品车饰</li>
              <li>户外运动</li>
              <li>医疗保险</li>
            </ul>
          </div>
        </div>
        <ul class="nav-index">
          <router-link tag="li" :to="{name: 'homeLink'}">首页</router-link>
          <router-link tag="li" :to="{name: 'betterNum'}">提高申请人数</router-link>
          <router-link tag="li" :to="{name: 'advertisement'}">广告位服务</router-link>
          <router-link tag="li" :to="{name: 'storeReaderLink'}">商家必读</router-link>
        </ul>
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
  data(){
    return {
      
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
.CATEGORY{
  vertical-align: middle;
  display: inline-block;
  padding: 10px 20px;
  position: relative;
  cursor: pointer;
  background: #333;
  color: #fff;
}
.CATEGORY:hover .CATEGORY-infoFrm{
  display: block;
}
.CATEGORY span,.CATEGORY img{
  vertical-align: middle;
}
.CATEGORY img{
  margin-left: 10px;
}
.CATEGORY-infoFrm{
  display: none;
  position: absolute;
  z-index: 2;
  width: 100%;
  left: 0;
  top: 100%;
  background: #fff;
  padding: 5px 10px;
  color: #000;
  overflow-y: scroll;
  height: 500px;
}
.CATEGORY-infoFrm.show{
  display: block;
}
.CATEGORY-infoFrm::-webkit-scrollbar {
  display:none
}
.CATEGORY-infoFrm li{
  padding: 8px 10px;
  background: #fff url('./assets/arrow_right_b.png') no-repeat 110px center;
  background-size: 15%;
}
.CATEGORY-infoFrm li:hover{
  color: var(--on-color);
  background: url('./assets/arrow_right_p.png') no-repeat 110px center;
  background-size: 15%;
}
</style>
