import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

const store = new Vuex.Store({
    state:{
        taskVal : 1,     //任务进程的参数（1-6）
        taskType : 'task1',
    },
    mutations:{
        taskOk(state, val){
            state.taskVal = val;
            // console.log(state.taskVal);
        },
        changeTask(state, val){
            state.taskType = val;
        },
        changeNetwork(state, val){
            console.log(val);
        }
    }
})

export default store