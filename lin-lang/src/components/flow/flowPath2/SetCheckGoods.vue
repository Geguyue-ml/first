<template>
  <div id="setCheckGoods">
    <div>
      <el-checkbox v-model="checkedPC">设置试客从PC端淘宝自然搜索找商品</el-checkbox>
    </div>
    <div>
      <el-checkbox v-model="checkedMo">设置试客从手机淘宝App入店</el-checkbox>
    </div>
  </div>
</template>

<script>
export default {
  name: 'SetCheckGoods',
  data () {
    return {
      checkedPC: true,
      checkedMo: true,
    }
  }
}
</script>

<style scoped>

</style>
