<template>
    <keep-alive>
      <div id="path1">
        <el-collapse :value="['1', '2']">
          <el-collapse-item title="1、选择平台和店铺" name="1" class="pathTitle">
            <div class="modelItem" v-for="(item, i) in filterStoreList" :key="i">
              <div class="modelPage">
                <img :src="storeImg[item.name]">
              </div>
              <div class="modelbody">
                <el-radio v-for="(subItem, subIndex) in item.shop" :key="subIndex" v-model="activeStore" @change="activeTypeVal(subItem.storeType)" :label="String(subItem.storeId)">{{subItem.name}}</el-radio>
              </div>
            </div>
          </el-collapse-item>
          <el-collapse-item title="2、选择任务类型" name="2">
            <div class="modelBox">
              <div class="clickBox">
                <el-radio v-model="taskType" label="1">人气权重爆商品</el-radio>
                <div class="txtFrm">
                  <p class="txtLine">
                    <span class="txtPoint"></span>
                    <span class="txt">商家可自定义每日投放数量、商品转化率，平台平均分布用户在每个时段进店申请；</span>
                  </p>
                  <p class="txtLine">
                    <span class="txtPoint"></span>
                    <span class="txt">琳琅智能AI人群标签系统自动推送符合商品标签用户，精准控制进店人群；</span>
                  </p>
                  <p class="txtLine">
                    <span class="txtPoint"></span>
                    <span class="txt">用户1-3天进店通过关键词或淘口令搜索进店，点击，浏览，收藏，加购，下单，评价，追评等操作优化整个uv价值链条。</span>
                  </p>
                </div>
              </div>
              <div class="clickBox">
                <el-radio v-model="taskType" label="2">下单返现</el-radio>
                <div class="txtFrm">
                  <p class="txtLine">
                    <span class="txtPoint"></span>
                    <span class="txt">下单返现解析语句没有；</span>
                  </p>
                </div>
              </div>
            </div>
          </el-collapse-item>
        </el-collapse>
        <llTaskModel ref="nextBtnFrm" :next="2" @click="saveData()"></llTaskModel>
      </div>
    </keep-alive>
</template>

<script>
import TaskModel from '../TaskModel'
import { mapMutations } from 'vuex'

export default {
  name: 'FlowPath1',
  data () {
    return {
      activeStore: null,
      activeStoreType: null,
      taskType: null,
      storeList: null,
      nextVal: false,
      taskSn: localStorage.getItem("taskSn"),
      storeImg: {
        "taobao": require('../../assets/taobao.png'),
        "tmall": require('../../assets/tmall.png'),
        "jindong": require('../../assets/jd.png'),
        "pingduoduo": require('../../assets/jd.png'),
      }
    }
  },
  components: {
    "llTaskModel": TaskModel,
  },
  methods: {
    ...mapMutations(["setTaskSn"]),
    getStoreData(){
      this.$api.flowPath.getStore()
      .then(res => {
        this.storeList = res.data.data;
      })
    },
    activeTypeVal(val){
      this.storeType = val
    },
    saveData(){
      let param = {
        proStoreId: this.activeStore,
        taskType: this.taskType,
        storeType: this.storeType
      }
      this.$api.flowPath.savePath1(param).then(res => {
        if(res.data.code == 0){
          this.setTaskSn(res.data.data.taskSn)
          localStorage.setItem("taskSn", res.data.data.taskSn);
          this.$message({
            message: "保存成功!",
            type: 'success',
            duration: 3 * 1000
          })
          this.$refs.nextBtnFrm.nextGo()
        }
      })
    },
    queryData(){
      let param = {
        flowStatus: 'platform',
        taskSn: this.taskSn
      }
      this.$api.flowPath.viewFlowData(param)
      .then(res => {
        //获取到数据后指向渲染操作
        let result = res.data.data;
        this.storeType = String(result.storeType)
        this.activeStore = String(result.proStoreId)
        this.taskType = String(result.taskType )
      })
    }
  },
  created(){
    //获取店铺列表
    this.getStoreData();

    //更具taskSn获取已有的数据
    if(this.taskSn){
      this.queryData();
    }
  },
  computed: {
    filterStoreList(){
      if(this.storeList){
        return this.storeList.filter(item => item.shop.length != 0)
      }
      return this.storeList
    }
  },
  beforeRouteLeave(to, from, next){
    this.$store.commit("changeTaskType", this.taskType);
    next();
  }
}
</script>

<style scoped>
.modelItem{
  display: inline-block;
  cursor: pointer;
  border-radius: 5px;
  padding: 15px;
  border: 1px solid var(--on-color);
  vertical-align: top;
  margin: 0 35px;
  min-width: 220px;
}
.modelPage{
  text-align: center;
  height: 40px;
}
.modelbody{
  display: flex;
  justify-content: flex-start;
  flex-direction: row;
  flex-wrap: wrap;
  align-items: center;
}
.modelbody::-webkit-scrollbar{
  width: 0;
}
.addBtn{
  padding: 15px;
  text-align: center;
  color: rgb(160, 160, 160);
}
.addBtn:hover{
  color: var(--on-color);
}
.clickBox{
  padding: 15px;
  border-radius: 5px;
  border: 1px solid  var(--on-color);
  width: 46%;
}
#path1 >>>.el-radio{
  margin-right: 15px;
}
#path1 .modelBox{
  align-items:flex-start;
}
.txtFrm{
  font-size: 12px;
  color: var(--off-color);
  padding: 0 15px;
}
.txtFrm h3{
  margin-bottom: 15px;
}
.txtPoint{
  display: inline-block;
  height: 7px;
  width: 7px;
  background-color: var(--on-color);
  border-radius: 100%;
  vertical-align: middle;
  margin-right: 7px;
}
.txt{
  display: inline-block;
  width: calc(100% - 25px);
  vertical-align: middle;
}
.txtLine{
  padding-bottom: 3px;
}
</style>