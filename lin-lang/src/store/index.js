import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

const store = new Vuex.Store({
    state:{
        taskVal: 1,     //任务进程的参数（1-6）
        taskType: '0',  //任务类型（0-1）
        storeType: 0,   //店铺类型
        taskSn: null,   //任务编号
        loginStatus: false,
        userName: null
    },
    mutations:{
        taskChange(state, val){
            state.taskVal = val;
            // console.log(state.taskVal);
        },
        changeTaskType: (state, val) => {
            state.taskType = val;
        },
        changeLoginStatus: (state, val) => {
            state.loginStatus = val;
        },
        changeUserName: (state, val) => {
            state.userName = val
        },
        setTaskSn: (state, val) => {
            state.taskSn = val
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