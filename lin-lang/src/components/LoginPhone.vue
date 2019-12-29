<template>
    <div id="loginFrm">
        <div class="modelBox">
            <div class="modelItem">
                <img src="../assets/login_bag.png">
            </div>
            <div class="modelItem centerFrm">
                <p class="loginTitle">手机登录</p>
                <el-input placeholder="请输入图片中的内容" v-model="loginInfo.imgCode" class="inputFrm imgCode">
                    <template slot="prepend"><i class="el-icon-cpu inputIcon"></i></template>
                    <template slot="append"><img :src="codeImg" @click="getImgCode()"></template>
                </el-input>
                <el-input placeholder="请输入您的手机号" v-model="loginInfo.phoneNum" class="inputFrm">
                    <template slot="prepend"><i class="el-icon-user inputIcon"></i></template>
                    <el-button slot="append" @click="checkoutPhone()">发送验证码</el-button>
                </el-input>
                <el-input placeholder="请输入短信中的验证码" v-model="loginInfo.password" show-password class="inputFrm">
                    <template slot="prepend"><i class="el-icon-key inputIcon"></i></template>
                </el-input>
                <div class="lineFrm">
                    <router-link tag="span" :to="{name: 'login'}" class="changeBtn">使用账号密码登录</router-link>
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
        loginInfo: {
            imgCode: null,
            phoneNum: null,
            password: null
        },
        codeImg: null,
        timeStamp: null,
    }
  },
  methods: {
    checkoutPhone(){
        //手机号登录发送验证码时：需要手机号，图形码，才能发送验证码
        let param = {
            imageCode: this.loginInfo.imgCode,
            kind: 'login',
            phone: this.loginInfo.phoneNum,
            randCode: this.timeStamp
        }
        this.$api.article.sendCode(param).then(res => {
            console.log(res.data);
        })
    },
    getImgCode(){
        this.timeStamp = String(new Date().getTime())
        let param = {
            randCode: this.timeStamp
        }
        this.$api.article.getCheckImg(JSON.stringify(param)).then(res => {
            const myBlob = new window.Blob([res.data], {type: 'image/jpeg'})
            this.codeImg = window.URL.createObjectURL(myBlob)
        })
    },
    loginBtn(){
        //手机号登陆时：需要手机号，验证码匹配才能登录
        let param = {
            captcha: this.loginInfo.password,
            phone: this.loginInfo.phoneNum,
            inviteCode: ""
        }
        this.$api.article.toLogin(param).then(res => {
            console.log(res);
        })
    }
  },
  created(){
      this.getImgCode();
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