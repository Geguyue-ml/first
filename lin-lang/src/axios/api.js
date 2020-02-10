import axios from './http'
import base from './base'

const loginAbout = {
    //账户密码登录
    loginAddress(param){
        return axios.post(`${base.sc}/auth/login`, param)
    },

    //手机号登录
    toLogin(param){
        return axios.post(`${base.sc}/auth/captchaLogin`, param, {
            isLoading: true
        })
    },

    //刷新token
    refreshToken(param){
        return axios.post(`${base.sc}/auth/refreshToken`, param)
    },

    //获取图形校验码
    getCheckImg(param){
        return axios.post(`${base.sc}/common/imagesCode/code`, param, {
            responseType: 'blob',
            isLoading: false
        })
    },

    //发送短信验证码
    sendCode(param){
        return axios.post(`${base.sc}/common/sms/send_mobile`, param)
    },

    //注册时的验证码
    sendCodeRegister(param){
        return axios.post(`${base.sc}/member/common/sms/send_mobile`, param)
    },

    //商家注册
    registerAccount(param){
        return axios.post(`${base.sc}/register/register`, param)
    }
}
const flowPath = {
    //发布任务第一步，获取店铺接口
    getStore(){
        return axios.post(`${base.sc}/member/store/groupList`, )
    },
    savePath1(param){
        return axios.post(`${base.sc}/member/task/addTaskPlatform`, param)
    },
    viewFlowData(param){
        return axios.post(`${base.sc}/member/task/queryByTaskFlowStatusData`, param)
    },
    getGoodsType(){
        return axios.post(`${base.sc}/productCategory/roots`)
    },
    savePath2(param){
        return axios.post(`${base.sc}/member/task/addAndUpdateTaskProduct`, param)
    }
}

export default {
    loginAbout,
    flowPath
}