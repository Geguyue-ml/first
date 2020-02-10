<template>
  <div id="path2">
    <el-collapse :value="['1', '2', '3']">
      <el-collapse-item title="1、填写商品信息及运费" name="1" class="pathTitle">
        <llSetGoodsInfo ref="setGoods"></llSetGoodsInfo>
      </el-collapse-item>
      <el-collapse-item title="2、设置如何找到商品" name="2">
        <llSetCheckGoods ref="setCheck"></llSetCheckGoods>
      </el-collapse-item>
      <el-collapse-item title="3、设置包邮及联系方式" name="3">
        <llTransportInfo ref="tranSport"></llTransportInfo>
      </el-collapse-item>
    </el-collapse>
    <llTaskModel ref="nextBtnFrm" :next="3" :prev="1"></llTaskModel>
  </div>
</template>

<script>
import SetCheckGoods from './flowPath2/SetCheckGoods'
import SetGoodsInfo from './flowPath2/SetGoodsInfo'
import TransportInfo from './flowPath2/TransportInfo'
import TaskModel from '../TaskModel'

export default {
  name: 'FlowPath2',
  components: {
    'llSetCheckGoods': SetCheckGoods,
    'llSetGoodsInfo': SetGoodsInfo,
    'llTransportInfo': TransportInfo,
    "llTaskModel": TaskModel,
  },
  data(){
    return {
      setGoodsParam: null,
      findGoodsParam: null,
      contactType: null,
      taskSn: localStorage.getItem("taskSn"),
    }
  },
  methods: {
    queryData(){
      let param = {
        flowStatus: 'product',
        taskSn: this.taskSn
      }
      this.$api.flowPath.viewFlowData(param)
      .then(res => {
        console.log(res);
      })
    },
    saveData(){
      let param = {
        ...this.setGoodsParam,
        ...this.findGoodsParam,
        ...this.contactType,
        proStoreId: 1,
        storeType: 1,
        showPrice: 12,
        ambush: "11",     //淘口令
        taskSn: this.$store.state.taskSn       //任务编号
      }
      if(this.$store.state.taskType == 0){
        delete param.giveGold
      }
      this.$api.flowPath.savePath2(param).then(res => {
        if(res.data.code == 0){
          this.$message({
            message: "保存成功!",
            type: 'success',
            duration: 3 * 1000
          })
          this.$refs.nextBtnFrm.nextGo()
        }
      })
    }
  },
  created(){
    if(this.taskSn){
      this.queryData()
    }
  }
}
</script>

<style scoped>

</style>
