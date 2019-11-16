import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

const store = new Vuex.Store({
    state:{
        taskVal : 1
    },
    mutations:{
        taskOk(state, val){
            state.taskVal = val;
            // console.log(state.taskVal);
        }
    }
})

export default store