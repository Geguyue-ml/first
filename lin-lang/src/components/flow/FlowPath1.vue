<template>
  <div id="path1">
    <el-collapse @change="handleChange" :value="['1', '2']">
      <el-collapse-item title="第一步、选择平台和店铺" name="1" class="pathTitle">
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
            <div class="addBtn" onselectstart="return false">绑定店铺</div>
          </div>
          <div class="modelItem">
            <div class="modelPage">
              <img src="../../assets/jd.png" alt="选择淘宝网的店铺">
            </div>
            <div class="modelbody">
              <el-radio v-model="radio" label="6">梨花带雨</el-radio>
              <el-radio v-model="radio" label="7">MOTU-X</el-radio>
            </div>
            <div class="addBtn" onselectstart="return false">绑定店铺</div>
          </div>
        </div>
      </el-collapse-item>
      <el-collapse-item title="第二步、选择任务类型" name="2">
        <div class="modelBox">
          <div class="clickBox active" @click="clickBoxFunc($event)" name="task1">打造爆款试用</div>
          <div class="clickBox" @click="clickBoxFunc($event)" name="task2">提升权重试用</div>
        </div>
        <div class="document active" id="task1">
          <div class="tableFrm">
            <table>
              <tr>
                <td>适用店铺类型：</td>
                <td>所有类型</td>
                <td>试用商品类型：</td>
                <td>新上架商品</td>
              </tr>
              <tr>
                <td>试用商品类型：</td>
                <td>新上架商品</td>
                <td>建议投放份数：</td>
                <td>10-25件起</td>
              </tr>
              <tr>
                <td>建议发布时间：</td>
                <td>新品上线即可</td>
                <td>任务抽奖时间：</td>
                <td>8点-20点每整点开奖</td>
              </tr>
            </table>
          </div>
          <div class="txtFrm">
            <h3>该任务类型功能解析</h3>
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
        <div class="document" id="task2">
          <div class="tableFrm">
            <table>
              <tr>
                <td>适用店铺类型：</td>
                <td>所有类型</td>
                <td>试用商品类型：</td>
                <td>新上架商品</td>
              </tr>
              <tr>
                <td>试用商品类型：</td>
                <td>新上架商品</td>
                <td>建议投放份数：</td>
                <td>10-25件起</td>
              </tr>
              <tr>
                <td>建议发布时间：</td>
                <td>新品上线即可</td>
                <td>任务抽奖时间：</td>
                <td>8点-20点每整点开奖</td>
              </tr>
            </table>
          </div>
          <div class="txtFrm" id="task2">
            <h3>该任务类型功能解析</h3>
            <p class="txtLine">
              <span class="txtPoint"></span>
              <span class="txt">任务流程：适用于提升新品或宝贝上线权重。试客根据任务关键词搜索进店提交申请，平台根据商家设置的每日投放数量从申请试客中，抽取符合中奖条件的试客完成下单；</span>
            </p>
            <p class="txtLine">
              <span class="txtPoint"></span>
              <span class="txt">商家可自定义每日投放数量、商品转化率，平台分配试客每个时段平均进店申请试用商品；</span>
            </p>
            <p class="txtLine">
              <span class="txtPoint"></span>
              <span class="txt">琳琅智能AI人群标签系统自动推送符合商品标签试客，精准控制进店人群；</span>
            </p>
            <p class="txtLine">
              <span class="txtPoint"></span>
              <span class="txt">该任务类型可以同时发布折扣任务，可以同时在线，无需排队；</span>
            </p>
            <p class="txtLine">
              <span class="txtPoint"></span>
              <span class="txt">试客1-3天进店通过关键词或淘口令搜索进店，点击，浏览，收藏，加购，下单，评价，追评等操作优化整个uv价值链条；</span>
            </p>
          </div>
        </div>
      </el-collapse-item>
      <div class="modelBox">
        <router-link class="nextGo" tag="div" :to="{name: 'flowPath2'}" @click.native="taskOk(2)"></router-link>
      </div>
    </el-collapse>
  </div>
</template>

<script>
import { mapMutations } from 'vuex'

export default {
  name: 'FlowPath1',
  data () {
    return {
      radio: '1'
    }
  },
  methods: {
    handleChange(){

    },
    clickBoxFunc(event){
      $(".clickBox").removeClass("active");
      $(".document").removeClass("active");
      $(event.currentTarget).addClass("active");
      $("#" + $(event.currentTarget).attr("name")).addClass("active");
    },
    ...mapMutations(["taskOk"])
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
  padding: 25px 0;
  border-bottom: 1px solid #EBEEF5;
}
.modelItem{
  width: 300px;
  height: 230px;
  padding: 15px;
  cursor: pointer;
  position: relative;
}
.modelPage{
  text-align: center;
  height: 40px;
}
.modelbody{
  padding: 15px 0;
  display: flex;
  justify-content: flex-start;
  flex-direction: row;
  flex-wrap: wrap;
  align-items: center;
}
.modelbody::-webkit-scrollbar{
  width: 0;
}
.modelbody .el-radio{
  margin-right: 0;
  width: 50%;
  padding: 15px 0;
  text-align: center;
}
.modelbody >>>.is-checked .el-radio__inner {
  border-color: var(--on-color);
  background-color: var(--on-color);
}
.modelbody >>>.is-checked .el-radio__label{
  color: var(--on-color);
}
.modelbody .el-radio__inner:hover {
  border: 1px solid var(--on-color);
}
.modelbody .el-radio__label {
  color: var(--on-color);
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
  padding: 15px 30px;
  font-size: 16px;
  border-radius: 5px;
  border: 1px solid  var(--on-color);
  cursor: pointer;
}
.clickBox.active{
  background-color: var(--on-color);
  color: #fff;
}
.nextGo{
  height: 50px;
  width: 50px;
  background: var(--on-color) url(../../assets/go-to-link.png) no-repeat;
  background-size: 100%;
  border-radius: 100%;
  cursor: pointer;
}
.document{
  display: none;
  padding: 0 25px;
  font-size: 0;
}
.document.active{
  display: block;
}
.tableFrm{
  display: inline-block;
  width: 50%;
  vertical-align: top;
  padding-top: 35px;
}
.document table{
  width: 100%;
  font-size: 14px;
}
.document td{
  padding-bottom: 20px;
}
.document td:nth-of-type(odd){
  text-align: right;
  font-weight: bold;
}
.document td:nth-of-type(even){
  text-align: left;
}
.txtFrm{
  vertical-align: top;
  display: inline-block;
  width: 50%;
  font-size: 14px;
  padding-top: 35px;
}
.txtFrm h3{
  margin-bottom: 15px;
}
.txtPoint{
  display: inline-block;
  height: 10px;
  width: 10px;
  background-color: var(--on-color);
  border-radius: 100%;
  vertical-align: middle;
  margin-right: 10px;
}
.txt{
  display: inline-block;
  width: calc(100% - 25px);
  vertical-align: middle;
}
.txtLine{
  padding-bottom: 10px;
}
</style>