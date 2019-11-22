<template>
  <div id="path4">
    <div v-if="taskType == 'task1'">
      <el-collapse :value="['1', '2', '3', '4', '5', '6']">
        <el-collapse-item title="1、免费增值服务" name="1">
          <div class="frm">
            <div class="itemFrm">
              <div class="itemTab" @click="sydbj = !sydbj" :class="{'active': sydbj}">试用担保金</div>
              <div class="itemTab" @click="yjfh = !yjfh" :class="{'active': yjfh}">押金直接返还</div>
              <div class="itemTab" @click="xtcj = !xtcj" :class="{'active': xtcj}">系统抽奖（3金豆/单）</div>
              <div class="itemTab" @click="rwsh = !rwsh" :class="{'active': rwsh}">试用任务审核（0金豆）</div>
              <div class="itemTab" @click="jztf = !jztf" :class="{'active': jztf}">精准投放（20金豆）</div>
            </div>
            <div class="infoFrm">
              123
            </div>
          </div>
        </el-collapse-item>
        <el-collapse-item title="3、提升试客积极性" name="2">
          
        </el-collapse-item>
        <el-collapse-item title="4、广告位投放" name="3">
          
        </el-collapse-item>
        <el-collapse-item title="5、安全优化" name="4">
          
        </el-collapse-item>
        <el-collapse-item title="6、试客进店控制" name="5">
          
        </el-collapse-item>
        <el-collapse-item title="7、细化中奖人群标签" name="6">
          
        </el-collapse-item>
      </el-collapse>
    </div>
    <div v-else-if="taskType == 'task2'">
      <el-collapse :value="['1', '2']">
        <el-collapse-item title="1、免费增值服务" name="1">
          
        </el-collapse-item>
        <el-collapse-item title="2、口碑营销" name="2">
          口碑营销
        </el-collapse-item>
      </el-collapse>
    </div>
    <llTaskModel :next="5" :prev="3"></llTaskModel>
  </div>
</template>

<script>
import { mapState } from 'vuex'
import TaskModel from '../TaskModel'

export default {
  name: 'FlowPath4',
  data () {
    return {
      taskType : '',
      sydbj: true,
      yjfh: true,
      xtcj: false,
      rwsh: false,
      jztf: false,
    }
  },
  components: {
    "llTaskModel": TaskModel,
  },
  mounted(){
    this.taskType = this.$store.state.taskType
  }
}
</script>

<style scoped>
.frm{
  margin-top: 15px;
  padding: 0 25px;
}
.itemTab{
  padding: 10px 15px;
  display: inline-block;
  background-color: #fff;
  border: 1px solid var(--on-color);
  border-radius: 5px;
  margin-right: 25px;
  cursor: pointer;
}
.itemTab.active{
  background-color: var(--on-color);
  color: #fff;
}
.infoFrm{
  margin-top: 25px;
}
</style>
