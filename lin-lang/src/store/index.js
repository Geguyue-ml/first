import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

const store = new Vuex.Store({
    state:{
        taskVal: 1,     //任务进程的参数（1-6）
        taskType: 'task1',
        loginStatus: false,
        userName: null
    },
    mutations:{
        taskChange(state, val){
            state.taskVal = val;
            // console.log(state.taskVal);
        },
        changeTask: (state, val) => {
            state.taskType = val;
        },
        changeLoginStatus: (state, val) => {
            state.loginStatus = val;
        },
        changeUserName: (state, val) => {
            state.userName = val
        }
    },
    getters:{
        getLoginStatus: state => {
            return state.loginStatus;
        },
        getUserName: state => {
            return state.userName;
        }
    }
})

export default store