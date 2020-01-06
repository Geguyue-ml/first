<template>
    <div id="loginFrm">
        <div class="modelBox">
            <div class="modelItem">
                <img src="../assets/login_bag.png">
            </div>
            <div class="modelItem centerFrm">
                <p class="loginTitle">商家注册</p>
                <el-input placeholder="请输入图片中的内容" v-model="imgCode" class="inputFrm imgCode">
                    <template slot="prepend"><i class="el-icon-cpu inputIcon"></i></template>
                    <template slot="append"><img :src="codeImg" @click="getImgCode()"></template>
                </el-input>
                <el-input placeholder="请输入您的手机号" v-model="registerInfo.phoneNum" class="inputFrm">
                    <template slot="prepend"><i class="el-icon-mobile-phone inputIcon"></i></template>
                    <el-button slot="append" @click="sendCodeNum()">发送验证码</el-button>
                </el-input>
                <el-input placeholder="请输入短信中的验证码" v-model="registerInfo.checkNum" class="inputFrm">
                    <template slot="prepend"><i class="el-icon-cpu inputIcon"></i></template>
                </el-input>
                <el-input placeholder="请输入您的密码" v-model="registerInfo.password" show-password class="inputFrm">
                    <template slot="prepend"><i class="el-icon-key inputIcon"></i></template>
                </el-input>
                <el-input placeholder="请再次输入您的密码" v-model="registerInfo.passwordDB" show-password class="inputFrm">
                    <template slot="prepend"><i class="el-icon-aim inputIcon"></i></template>
                </el-input>
                <div class="lineFrm">
                    <router-link tag="span" :to="{name: 'login'}" class="changeBtn">去使用密码登录</router-link>
                    <router-link tag="span" :to="{name: 'loginPhone'}" class="changeBtn rightBtn">使用手机号登录</router-link>
                </div>
                <div class="lineFrm">
                    <div class="importantBtn" @click="registerBtn">注册</div>
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
        registerInfo: {
            phoneNum: null,
            checkNum: null,
            password: null,
            passwordDB: null,
        },
        imgCode: null,
        codeImg: null,
        timeStamp: null,
    }
  },
  methods: {
    checkPhoneNum(){
        //一些列的手机号校验
        if(!this.registerInfo.phoneNum){
            Message({
                message: '请填写手机号',
                type: 'error',
                duration: 3 * 1000
            })
        }else if(this.registerInfo.phoneNum.length != 11){
            Message({
                message: '请校验手机号是否正确',
                type: 'error',
                duration: 3 * 1000
            })
        }else{
            this.checkPhone = true
        }
    },
    sendCodeNum(){
        this.checkPhoneNum();
        if(this.checkPhone){
            //手机号登录发送验证码时：需要手机号，图形码，才能发送验证码
            let param = {
                imageCode: this.imgCode,
                kind: 'register',
                phone: this.registerInfo.phoneNum,
                randCode: this.timeStamp
            }
            this.$api.loginAbout.sendCode(param).then(res => {
                console.log(res.data);
            })
        }
    },
    registerBtn(){
        let param = {
            phone: this.registerInfo.phoneNum,
            password: this.registerInfo.password,
            captcha: this.registerInfo.checkNum
        }
        console.log(param);
        this.$api.loginAbout.registerAccount().then(res => {
            console.log(res);
        })
    },
    getImgCode(){
        this.timeStamp = String(new Date().getTime())
        let param = {
            randCode: this.timeStamp
        }
        this.$api.loginAbout.getCheckImg(JSON.stringify(param)).then(res => {
            const myBlob = new window.Blob([res.data], {type: 'image/jpeg'})
            this.codeImg = window.URL.createObjectURL(myBlob)
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
.inputFrm >>>.el-input-group__append{
    cursor: pointer;
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