<template>
    <div id="loginFrm">
        <div class="modelBox">
            <div class="modelItem">
                <img src="../assets/login_bag.png">
            </div>
            <div class="modelItem centerFrm">
                <p class="loginTitle">用户登录</p>
                <el-input placeholder="请输入您的账号/用户名/手机号" v-model="param.username" class="inputFrm">
                    <template slot="prepend"><i class="el-icon-user inputIcon"></i></template>
                </el-input>
                <el-input placeholder="请输入您的密码" v-model="param.password" show-password class="inputFrm">
                    <template slot="prepend"><i class="el-icon-key inputIcon"></i></template>
                </el-input>
                <div class="lineFrm">
                    <span class="assistBtn">忘记密码？</span>
                    <router-link tag="span" :to="{name: 'loginPhone'}" class="changeBtn rightBtn">使用手机号登录</router-link>
                </div>
                <div class="lineFrm">
                    <div class="importantBtn" @click="loginBtn">登录</div>
                </div>
                <div class="lineFrm">
                    <router-link tag="div" :to="{name: 'register'}" class="assistBtn center">商家注册</router-link>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
export default {
  name: 'LoginFrm',
  data () {
    return {
        param: {
            username: null,
            password: null
        }
    }
  },
  methods: {
      loginBtn(){
            this.$api.article.loginAddress(this.param).then( res => {
                utils.handlRes(res.code)
                localStorage.setItem("token", res.token);
                this.$router.push({ path:'/'})
                let hostName = this.$route.query.redirect;
                console.log(hostName);
            })
      }
  }
}
</script>

<style scoped>
.modelBox{
    display: flex;
    justify-content: space-around;
    padding: 50px 0;
    min-height: 260px;
}
.modelItem{
    align-items: flex-start;
}
.lineTxt{
    text-align: right;
    font-size: 18px;
    margin-bottom: 10px;
    color: var(--on-color);
    vertical-align: middle;
}
.centerFrm{
    border: 1px solid #e6e6e6;
    width: 380px;
    padding: 25px;
    background: #fff;
}
.loginTitle{
    font-size: 18px;
}
.inputIcon{
    font-size: 20px;
}
.inputFrm{
    margin-top: 25px;
}
.assistBtn{
    color: #999;
    font-size: 12px;
    cursor: pointer;
}
.changeBtn{
    color: var(--on-color);
    cursor: pointer;
}
.rightBtn{
    float: right;
}
.importantBtn{
    margin: 30px auto 0;
    padding: 10px 30px;
    border-radius: 5px;
    border: none;
    background: var(--on-color);
    color: #fff;
    outline: none;
    font-size: 16px;
    cursor: pointer;
    width: 250px;
    text-align: center;
}
.lineFrm{
    margin-top:15px;
}
</style>