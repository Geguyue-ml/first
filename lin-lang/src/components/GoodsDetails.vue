<template>
    <div id="goodsDetails">
        <div class="nav_center">
          <llBanner :bannerVal="['首页', '商品详情']"/>
          <div class="detailsModel">
            <div class="subModel">
              <div class="imgFrm">
                <img src="http://cdn.static.linlang.com/upload_test/trade/20191101/c37c8f38fbb8d1b73e43d3a2dc9a8106.jpg?imageView2/2/w/300">
                <div class="double"></div>
              </div>
            </div>
            <div class="subModel">
              <div class="detailsFrm">
                <div class="goodsTitleFrm">
                  <img src="../assets/tmall_icon.png">
                  <div class="goodsTitle">
                    <p>这里是商品名称标题特点描述的Title,这里是商品名称标题特点描述的Title,这里是商品名称标题特点描述的Title,这里是商品名称标题特点描述的Title,这里是商品名称标题特点描述的Title</p>
                  </div>
                </div>
                <div class="priceFrm">
                  <div class="priceTitle clearfix">
                    <span class="priceFrmTitle">距离活动结束还剩余:</span>
                    <div class="pricetime"><span>天时分秒</span></div>
                  </div>
                  <div class="priceBody">
                    <table class="priceNumber">
                      <tr>
                        <td style="width: 70px;">商品价值：</td>
                        <td class="numberVal priceVal" colspan="3" style="width: 210px;">￥80.00</td>
                      </tr>
                      <tr>
                        <td>运费：</td>
                        <td class="numberVal">包邮</td>
                        <td style="width:100px;">限量：</td>
                        <td class="numberVal">1件</td>
                      </tr>
                      <tr>
                        <td>规格：</td>
                        <td class="numberVal" colspan="3">任意规格（按照商品价格下单）</td>
                      </tr>
                      <tr>
                        <td>总份数：</td>
                        <td class="numberVal point">20</td>
                        <td>搜索量：</td>
                        <td class="numberVal point">5000</td>
                      </tr>
                      <tr>
                        <td>收藏：</td>
                        <td class="numberVal point">600</td>
                        <td>加购：</td>
                        <td class="numberVal point">150</td>
                      </tr>
                    </table>
                  </div>
                  <div class="priceFooter">
                    <input type="button" value="暂不支持电脑端申请">
                  </div>
                </div>
              </div>
            </div>
            <div class="subModel">3</div>
          </div>
          <div class="appraiseModel">
            <llGoodsAppraise />
            <llGuessLike />
          </div>
        </div>
    </div>
</template>

<script>
import GoodsAppraise from "./goodsDetails/GoodsAppraise"
import GuessLike from "./goodsDetails/GuessLike"
import Banner from "./Banner"

export default {
  name: 'goodsDetails',
  components: {
    "llGoodsAppraise" : GoodsAppraise,
    "llGuessLike" : GuessLike,
    "llBanner" : Banner,
  },
}
</script>

<style scoped>
.detailsModel{
  margin-bottom: 20px;
}
.subModel{
  vertical-align: top;
  display: inline-block;
}
.subModel:nth-child(2){
  margin: 0 30px;
  width: 590px;
}
.imgFrm{
  height: 320px;
  width: 320px;
  overflow: hidden;
  position: relative;
}
.imgFrm img{
  width: 100%;
}
.double{
  position: absolute;
  bottom: 0;
  right: 0;
  height: 35px;
  width: 35px;
  background: var(--on-color) url(../assets/indexseache.png) no-repeat center;
}
.goodsTitleFrm{
  font-size: 0;
}
.goodsTitle p{
  overflow: hidden;
  text-overflow: ellipsis;
  word-break: break-all;
  display: -webkit-box;
  -webkit-line-clamp: 2;
  -webkit-box-orient: vertical;
}
.detailsFrm img{
  vertical-align: middle;
}
.goodsTitle{
  font-size: 16px;
  font-weight: 700;
  width: 564px;
  display: inline-block;
  vertical-align: middle;
  padding: 0 20px;
  color: #666;
}
.priceFrm{
  margin: 10px 0;
  color: #999;
}
.priceTitle{
  padding: 10px;
  background: var(--on-color);
  color: #fff;
}
.pricetime{
  float: right;
}
.priceBody{
  background: #eee;
  padding: 10px;
}
.priceBody span{
  vertical-align: middle;
}
.priceNumber{
  width: 100%;
}
.priceNumber td{
  text-align: left;
}
.numberKey{
  width: 70px;
}
.numberVal{
  color: #000;
}
.numberVal.point{
  color: #FF0000;
  font-weight: bold;
}
.priceVal{
  font-size: 30px;
  margin-right: 40px;
  color: #FF0000;
  font-weight: bold;
}
.priceNumber tr{
  height: 40px;
}
.priceFooter input{
    margin: 20px 0;
    padding: 10px 30px;
    border-radius: 5px;
    border: none;
    background: var(--off-color);
    color: #eee;
    outline: none;
    font-size: 16px;
    cursor: no-drop;
}
.appraiseModel{
  font-size: 0;
}
</style>