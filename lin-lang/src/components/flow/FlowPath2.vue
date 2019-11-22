<template>
  <div id="path2">
    <el-collapse :value="['1', '2', '3']">
      <el-collapse-item title="1、填写商品信息及运费" name="1" class="pathTitle">
        <llSetGoodsInfo></llSetGoodsInfo>
      </el-collapse-item>
      <el-collapse-item title="2、设置如何找到商品" name="2">
        <llSetCheckGoods></llSetCheckGoods>
      </el-collapse-item>
      <el-collapse-item title="3、设置包邮及联系方式" name="3">
        <llTransportInfo></llTransportInfo>
      </el-collapse-item>
    </el-collapse>
    <llTaskModel :next="3" :prev="1"></llTaskModel>
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
  }
}
</script>

<style scoped>

</style>
