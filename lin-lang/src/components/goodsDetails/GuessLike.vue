<template>
  <div id="guess">
    <div class="guessTitle">
        <span>猜你喜欢</span>
    </div>
    <div class="guessBody">
        123
    </div>
  </div>
</template>

<script>
export default {
  name: 'GuessLike',
  data () {
    return {
      
    }
  }
}
</script>

<style scoped>
#guess{
    display: inline-block;
    width: 300px;
    font-size: 14px;
    vertical-align: top;
}
.guessTitle{
    padding: 10px 25px;
    background: #eee;
}
.guessBody{
    padding: 10px;
}
</style>
