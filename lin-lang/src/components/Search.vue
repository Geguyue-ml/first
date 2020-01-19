<template>
  <div id="search">
        <div class="nav_center clearfix box">
            <div class="myfl">
                <a href="#">
                    <img class="logo" src="../assets/huikeling.jpg">
                </a>
            </div>
            <div class="myfr">
                <div class="search">
                    <form action="" method="get">
                        <input type="text" class="content_input" value="" name="search" placeholder="试试搜索商品吧！">
                        <input class="click_input" type="submit" value="">
                    </form>
                </div>
            </div>
        </div>
  </div>
</template>

<script>
export default {
  name: 'Search',
  data () {
    return {
      
    }
  }
}
</script>

<style scoped>
.logo{
    width: 130px;
    margin: 20px 0;
}
.search{
    background: var(--on-color);
    padding: 2px;
    margin: 20px 0;
    border-radius: 20px;
    position: relative;
    margin-left: 190px;
}
input{
    border: none;
    outline: none;
}
.content_input{
    width: 596px;
    height: 36px;
    line-height: 36px;
    background: #fff;
    padding-left: 10px;
    border-radius: 20px;
}
.click_input{
    width: 70px;
    height: 36px;
    line-height: 36px;
    cursor: pointer;
    border-radius: 18px;
    position: absolute;
    top: 2px;
    right: 1px;
    background: var(--on-color) url(../assets/indexseache.png) no-repeat center;
}
</style>
