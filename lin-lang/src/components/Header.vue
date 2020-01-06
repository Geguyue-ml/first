<template>
    <header class="web_nav" id="llHeader">
        <div class="nav_center clearfix">
            <div class="myfl">
                <router-link tag="a" :to="{name: 'personal'}" @click.native="unActive()">个人中心</router-link>
                <i>|</i>
                <a href="#">我的金豆：个[充值金豆]</a>
                <i>|</i>
                <a href="#">延长技术年费服务</a>
                <i>|</i>
                <a href="#">提醒</a>
                <i>|</i>
                <a href="#">帮助中心</a>
            </div>
            <div v-if="!this.$store.getters.getLoginStatus" class="myfr">
                <router-link tag="a" :to="{name: 'login'}">登录</router-link>
                <i>|</i>
                <router-link tag="a" :to="{name: 'register'}">商家注册</router-link>
            </div>
            <div v-else class="myfr">
                <el-popover
                    placement="bottom"
                    width="80"
                    trigger="click">
                    <div class="infoBtn" @click="getOut">退出</div>
                    <el-button slot="reference">欢迎：{{ this.$store.getters.getUserName }}</el-button>
                </el-popover>
            </div>
        </div>
    </header>
</template>

<script>
export default {
  name: 'llHeader',
  data () {
    return {
      
    }
  },
  methods: {
      unActive: function(){
        this.$emit('unActiveEmit');
      },
      getOut: function(){
        localStorage.removeItem("token")
        this.$router.push({ path:'/login'})
        this.$store.commit("changeLoginStatus", false)
        this.$store.commit("changeUserName", null)
      }
  }
}
</script>

<style scoped>
.web_nav{
    width: 100%;
    min-width: 1100px;
    height: 40px;
    line-height: 40px;
    border-bottom: 1px solid #dfdfdf;
}
#llHeader a{
    color: var(--off-color);
    font-size: 12px;
    padding: 0 18px;
    display: inline-block;
    vertical-align: top;
}
#llHeader i{
    color: rgb(199, 199, 199);
    vertical-align: top;
}
.myfr .el-button{
    border: 0;
}
.infoBtn{
    cursor: pointer;
}
</style>