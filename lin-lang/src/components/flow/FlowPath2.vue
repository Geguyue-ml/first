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
  },
  methods: {
    saveData(){
      setTimeout(() => {
        let param = {
          name: this.$refs.setGoods.name,
          link: this.$refs.setGoods.link,
          proProductCategoryId: this.$refs.setGoods.select,
          platformImage: null,
          price: this.$refs.setGoods.buyPrice,
          specValue: this.$refs.setGoods.goodsSpecification,
          limitNumber: this.$refs.setGoods.num,

          productImage: null,
          proRangeSearchId: this.$refs.setCheck.wordVal.find((item) => {
            item.word
          }),

          whetherMail: this.$refs.tranSport.post,
          mailType: this.$refs.tranSport.goodsPost,
          phone: this.$refs.tranSport.phone,
          qq: this.$refs.tranSport.QQ,
          weixin: this.$refs.tranSport.weChart,

          specKey: 0,
          taskComment: null,
          ambush: null,
          enterStoreRate: null,
          showPrice: null
        }
        console.log(param);
        this.$api.flowPath.savePath2(param).then(res => {
          if(res.data.code == 0){
            Message({
              message: "保存成功!",
              type: 'success',
              duration: 3 * 1000
            })
          }
        })
      }, 0)
    }
  }
}
</script>

<style scoped>

</style>
