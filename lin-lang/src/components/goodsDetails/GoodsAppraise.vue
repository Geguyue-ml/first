<template>
  <div id="appraise">
    <ul class="appraiseTitle">
        <router-link tag="li" :to="{name:'tryDetails'}">试用详情</router-link>
        <router-link tag="li" :to="{name:'tryAppraise'}">试用评价</router-link>
        <router-link tag="li" :to="{name:'tryPoint'}">试用需知</router-link>
    </ul>
    <div class="appraiseFrm">
        <router-view></router-view>
    </div>
  </div>
</template>

<script>
export default {
  name: 'GoodsAppraise',
  data () {
    return {
      
    }
  }
}
</script>

<style scoped>
#appraise{
    display: inline-block;
    width: 900px;
    font-size: 14px;
    padding-right: 20px;
    vertical-align: top;
}
.appraiseTitle{
    background: #eee;
    font-size: 0;
    border-bottom: 1px solid var(--on-color);
}
.appraiseTitle li{
    display: inline-block;
    font-size: 14px;
    padding: 10px 25px;
    cursor: pointer;
}
.appraiseTitle li:hover{
    color: var(--on-color);
}
.router-link-exact-active{
    color: #fff;
    background: var(--on-color);
}
.router-link-exact-active:hover{
    color: #fff !important;
}
.appraiseFrm{
    min-height: 500px;
    overflow-y: auto;
}
</style>