<template>
  <div id="path1">
    <el-collapse :value="['1', '2']">
      <el-collapse-item title="1、选择平台和店铺" name="1" class="pathTitle">
        <div class="modelBox">
          <div class="modelItem">
            <div class="modelPage">
              <img src="../../assets/taobao.png" alt="选择淘宝网的店铺">
            </div>
            <div class="modelbody">
              <el-radio v-model="radio" label="1">梨花带雨</el-radio>
              <el-radio v-model="radio" label="2">KK机械</el-radio>
              <el-radio v-model="radio" label="3">MOTU-X</el-radio>
            </div>
          </div>
          <div class="modelItem">
            <div class="modelPage">
              <img src="../../assets/tmall.png" alt="选择淘宝网的店铺">
            </div>
            <div class="modelbody">
              <el-radio v-model="radio" label="4">梨花带雨</el-radio>
              <el-radio v-model="radio" label="5">KK机械</el-radio>
            </div>
          </div>
          <div class="modelItem">
            <div class="modelPage">
              <img src="../../assets/jd.png" alt="选择淘宝网的店铺">
            </div>
            <div class="modelbody">
              <el-radio v-model="radio" label="6">梨花带雨</el-radio>
              <el-radio v-model="radio" label="7">MOTU-X</el-radio>
            </div>
          </div>
        </div>
      </el-collapse-item>
      <el-collapse-item title="2、选择任务类型" name="2">
        <div class="modelBox">
          <div class="clickBox">
            <el-radio v-model="taskTypeRadio" label="1">人气权重爆款试用</el-radio>
            <div class="txtFrm">
              <p class="txtLine">
                <span class="txtPoint"></span>
                <span class="txt">任务流程：适店提交申请，平台根据商家设置的每日投放数量从申请试客中，抽取符合中奖条件的试客完成下单；</span>
              </p>
              <p class="txtLine">
                <span class="txtPoint"></span>
                <span class="txt">商家可自定个时段平均进店申请试用商品；</span>
              </p>
              <p class="txtLine">
                <span class="txtPoint"></span>
                <span class="txt">琳琅智能AI人准控制进店人群；</span>
              </p>
              <p class="txtLine">
                <span class="txtPoint"></span>
                <span class="txt">该任务类型可以排队；</span>
              </p>
              <p class="txtLine">
                <span class="txtPoint"></span>
                <span class="txt">试客1-3天进店通过购，下单，评价，追评等操作优化整个uv价值链条；</span>
              </p>
            </div>
          </div>
          <div class="clickBox">
            <el-radio v-model="taskTypeRadio" label="1">下单返现</el-radio>
            <div class="txtFrm">
              <p class="txtLine">
                <span class="txtPoint"></span>
                <span class="txt">任务流程：适店提交申请，平台根据商家设置中奖条件的试客完成下单；</span>
              </p>
              <p class="txtLine">
                <span class="txtPoint"></span>
                <span class="txt">商家可自定个时段平均进店申请试用商品；</span>
              </p>
              <p class="txtLine">
                <span class="txtPoint"></span>
                <span class="txt">琳琅智能AI人准控制进店人群；</span>
              </p>
            </div>
          </div>
        </div>
      </el-collapse-item>
    </el-collapse>
    <llTaskModel :next="2"></llTaskModel>
  </div>
</template>

<script>
import TaskModel from '../TaskModel'

export default {
  name: 'FlowPath1',
  data () {
    return {
      radio: '1',
      taskTypeRadio: '1'
    }
  },
  components: {
    "llTaskModel": TaskModel,
  },
  beforeRouteLeave(to, from, next){
    this.$store.commit("changeTask", $(".clickBox.active").attr("name"));
    next();
  }
}
</script>

<style scoped>
.modelBox{
  display: flex;
  justify-content: space-around;
  flex-direction: row;
  flex-wrap: nowrap;
  align-items: center;
}
.modelBox.Btn{
  justify-content: center;
}
.modelItem{
  cursor: pointer;
  border-radius: 5px;
  padding: 15px;
  border: 1px solid var(--on-color);
  min-width: 312px;
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