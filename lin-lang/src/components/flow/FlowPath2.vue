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
    <div class="modelBox Btn">
      <div>
        <router-link class="npBtn prev" tag="div" :to="{name: 'flowPath1'}" @click.native="taskOk(1)"></router-link>
        <router-link class="npBtn next" tag="div" :to="{name: 'flowPath3'}" @click.native="taskOk(3)"></router-link>
      </div>
    </div>
  </div>
</template>

<script>
import { mapMutations } from 'vuex'
import SetCheckGoods from './flowPath2/SetCheckGoods'
import SetGoodsInfo from './flowPath2/SetGoodsInfo'
import TransportInfo from './flowPath2/TransportInfo'

export default {
  name: 'FlowPath2',
  components: {
    'llSetCheckGoods': SetCheckGoods,
    'llSetGoodsInfo': SetGoodsInfo,
    'llTransportInfo': TransportInfo,
  },
  methods: {
    ...mapMutations(["taskOk"])
  }
}
</script>

<style scoped>

</style>
