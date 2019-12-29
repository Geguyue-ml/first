import axios from './http'
import base from './base'

const article = {
    //账户密码登录
    loginAddress(param){
        return axios.post(`${base.sc}/auth/login`, param)
    },

    //手机号登录
    toLogin(param){
        return axios.post(`${base.sc}/auth/captchaLogin`, param)
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
    }
}
export default article