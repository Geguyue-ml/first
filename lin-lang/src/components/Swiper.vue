<template>
  <div id="swiper">
    <div class="swiper-container" id="bannerBackground">
      <!-- 轮播图 -->
      <ul class="swiper-wrapper">
        <li class="swiper-slide">
          <img src="../assets/1.jpg">
        </li>
        <li class="swiper-slide">
          <img src="../assets/2.jpg">
        </li>
        <li class="swiper-slide">
          <img src="../assets/3.jpg">
        </li>
      </ul>
      <!-- 轮播图--圆点 -->
      <div class="swiper-pagination"></div>

      <!-- 轮播图--左右键 -->
      <div class="swiper-button-next"></div>
      <div class="swiper-button-prev"></div>
    </div>

    <div class="navigation">
      <div class="btnFrm">
        <input class="goBtn" type="button" value="发布试用任务">
      </div>
      <div class="infoTitle">商家公告</div>
      <div class="infoFrm">
        <ul>
          <li>
            <span>111</span>
          </li>
          <li>
            <span>safwefsd</span>
          </li>
          <li>
            <span>试点范围发士大夫试点范围发展的无法</span>
          </li>
          <li>
            <span>现场服务热吻日常消费v的氛围</span>
          </li>
          <li>
            <span>12312撒旦士大夫士大夫34人体4rt</span>
          </li>
          <li>
            <span>23为人法2 额外分4法4热无法613264  8463</span>
          </li>
        </ul>
      </div>
    </div>
  </div>
</template>

<script>
import Swiper from 'swiper'
export default {
  name: 'Swiper',
  data () {
    return {
      
    }
  },
  mounted(){
    var swiper = new Swiper('#bannerBackground', {
      pagination: {
        el: '.swiper-pagination',
          dynamicBullets: true,
      },
      navigation: {
        nextEl: '.swiper-button-next',
        prevEl: '.swiper-button-prev',
      },
    });
  }
}
</script>

<style scoped>
#swiper{
  position: relative;
}
.swiper-container {
  width: 100%;
  min-width: 1200px;
  height: 500px;
}
.swiper-slide {
  text-align: center;
  font-size: 18px;
  background: #fff;
  overflow: hidden;

  /* Center slide text vertically */
  display: -webkit-box;
  display: -ms-flexbox;
  display: -webkit-flex;
  display: flex;
  -webkit-box-pack: center;
  -ms-flex-pack: center;
  -webkit-justify-content: center;
  justify-content: center;
  -webkit-box-align: center;
  -ms-flex-align: center;
  -webkit-align-items: center;
  align-items: center;
}
.swiper-slide img {
  height: 100%;
}
.navigation{
  position: absolute;
  top: 0;
  left: 60%;
  margin-left: 240px;
  height: 500px;
  width: 200px;
  background: #fff;
  z-index: 1;
}
.btnFrm{
  text-align: center;
}
.goBtn{
  margin: 20px 0;
  padding: 10px 30px;
  border-radius: 5px;
  border: none;
  background: var(--on-color);
  color: #fff;
  outline: none;
  font-size: 16px;
  cursor: pointer;
}
.infoTitle{
  padding: 5px 18px;
  font-size: 16px;
  text-align: left;
  color: var(--on-color);
  border-bottom: 2px solid var(--on-color);
}
.infoFrm{
  height: 365px;
  overflow-y: auto;
  padding: 0 10px;
}
.infoFrm ul{
  padding: 10px 0;
}
.infoFrm li{
  padding: 10px 10px 10px 25px;
  cursor: pointer;
  background: url('../assets/arrow_right_b.png') no-repeat 0 center;
  background-size: 15%;
}
.infoFrm li:hover{
  color: var(--on-color);
  background: url('../assets/arrow_right_p.png') no-repeat 0 center;
  background-size: 15%;
}
.infoFrm span{
  vertical-align: middle;
  white-space: nowrap;
  display: inline-block;
  width: 100%;
  overflow: hidden;
  text-overflow: ellipsis;
}
</style>
