import axios from 'axios'
import router from '../router';
import store from '../store'
import { Message, Loading } from 'element-ui'

let loading

let Service = axios.create({timeout: 3000})
Service.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded'

/**
 * 请求拦截器
 */
Service.interceptors.request.use(config => {
    if(config.url == "/auth/refreshToken"){
        config.headers.refreshToken = "authRefreshToken"
    }
    if(config.isLoading){
        openLoading()
    }
    return config
})

/**
 * 响应拦截器
 */
Service.interceptors.response.use(response => {
    closeLoading()
    response.status === 200 ? Promise.resolve(response) : Promise.reject(response)
    return response
}, error => {
    const { response } = error;
    if(response){
        errorHandle(response.status, response.data.message)
        closeLoading()
        return Promise.reject(error)
    }else{
        // 处理断网的情况
        // eg:请求超时或断网时，更新state的network状态
        // network状态在app.vue中控制着一个全局的断网提示组件的显示隐藏
        // 关于断网组件中的刷新重新获取数据，会在断网组件中说明
        store.commit('changeNetwork', false);
    }
    closeLoading()
})

/**
 * 跳转登录页，携带当前页面的路由
 * 便于登录成功后，返回值当前页
 */
const toLogin = () => {
    router.replace({
        path: '/login',
        query: {
            redirect: router.currentRoute.fullPath
        }
    })
}

/**
 * 请求失败后，错误统一处理
 */
const errorHandle = (status, other) => {
    switch (status) {
        //未登录状态
        case 401: toLogin();
        break;

        //token过期
        //清除token并跳转登录页
        case 403: Message({
            message: '登录过期，请重新登录',
            type: 'error',
            duration: 3 * 1000
        })
        localStorage.removeItem('token');
        store.commit('loginSuccess', null);
        setTimeout(() => {
            toLogin();
        }, 1000);
        break;

       // 404请求不存在
        case 404: Message({
            message: '请求的资源不存在',
            type: 'error',
            duration: 3 * 1000
        })
        break;
        default: console.log(other);
    }
}

/**
 * 开启loading页面
 */
const openLoading = () => {
    closeLoading()
    loading = Loading.service({
        lock: true,
        text: '拼命加载中...',
        background: 'rgba(0, 0, 0, 0.7)'
    })
}

/**
 * 关闭loading页面
 */
const closeLoading = () => {
    if(loading){
        loading.close();
    }
}

export default Service