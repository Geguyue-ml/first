import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

let bannerVal = new Set();
bannerVal.add("首页");
const store = new Vuex.Store({
    state:{
        bannerVal : bannerVal
    },
    mutations:{
        updateBannerVal(val){
            state.bannerVal.push(val)
        }
    }
})

export default store