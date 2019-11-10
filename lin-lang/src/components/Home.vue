<template>
  <div id="home">
    <llSwiper />
    <llGoods title="精品活动专题" typeId="goods1"/>
    <llGoods title="新品上市" typeId="goods2"/>
    <llGoods title="高价值试用" typeId="goods3"/>
    <llGoods title="高通过率试用" typeId="goods4"/>
  </div>
</template>

<script>
import Swiper from "./Swiper"
import Goods from "./Goods"

export default {
  name: 'Home',  
  components: {
    "llSwiper" : Swiper,
    "llGoods" : Goods
  }
}
</script>

<style>

</style>
