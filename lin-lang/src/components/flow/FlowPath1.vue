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
              <template>
                <el-radio v-model="radio" label="1">备选项</el-radio>
                <el-radio v-model="radio" label="2">备选项</el-radio>
              </template>
            </div>
          </div>
          <div class="modelItem">
            <div class="modelPage">
              <img src="../../assets/tmall.png" alt="选择淘宝网的店铺">
            </div>
          </div>
          <div class="modelItem">
            <div class="modelPage">
              <img src="../../assets/jd.png" alt="选择淘宝网的店铺">
            </div>
          </div>
        </div>
      </el-collapse-item>
      <el-collapse-item title="第二步、选择任务类型" name="2">
        <div>控制反馈：通过界面样式和交互动效让用户可以清晰的感知自己的操作；</div>
        <div>页面反馈：操作后，通过页面元素的变化清晰地展现当前状态。</div>
      </el-collapse-item>
    </el-collapse>
  </div>
</template>

<script>
export default {
  name: 'FlowPath1',
  data () {
    return {
      radio: '1'
    }
  },
  methods: {
    handleChange(){

    }
  }
}
</script>

<style scoped>
.modelBox{
  display: flex;
  justify-content: space-around;
  flex-direction: row;
  flex-wrap: nowrap;
  padding-top: 25px;
}
.modelItem{
  flex-grow: 1;
}
.modelPage{
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
</style>