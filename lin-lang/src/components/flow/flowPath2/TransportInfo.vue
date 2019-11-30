<template>
  <div id="transportInfo">
    <table>
      <tr>
        <td colspan="6">
          <div class="selectItem" :class="{'show': by}" @click="by = !by" :v-model="by">包邮</div>
          <el-radio v-model="goodsPost" label="1">商品本身不包邮</el-radio>
          <el-radio v-model="goodsPost" label="2">商品本身包邮</el-radio>
          <span>温馨提示：请在发布试用推广期间，暂停淘宝客等返利设置，避免不必要的损失</span>
        </td>
      </tr>
      <tr>
        <td class="title">手机：</td>
        <td>
          <el-input placeholder="请输入您的手机联系方式" v-model="phone"></el-input>
        </td>
        <td class="title">QQ：</td>
        <td>
           <el-input placeholder="请输入您的QQ联系方式" v-model="QQ"></el-input>
        </td>
        <td class="title">微信：</td>
        <td>
           <el-input placeholder="请输入您的微信联系方式" v-model="weChart"></el-input>
        </td>
      </tr>
      <tr>
        <td class="title">说明：</td>
        <td colspan="3">
          123
        </td>
      </tr>
    </table>
  </div>
</template>

<script>
export default {
  name: 'TransportInfo',
  data () {
    return {
      by: true,
      goodsPost: '',
      phone: '',
      QQ: '',
      weChart: '',
    }
  }
}
</script>

<style scoped>
#transportInfo table{
  width: 100%;
}
.title{
  text-align: right;
}
td{
  padding: 15px 0 15px 20px;
}
#transportInfo .el-radio{
  display: inline-block;
  width: auto;
  margin-left: 20px;
}
.selectItem{
  display: inline-block;
  padding: 5px 15px;
  margin: 5px;
  border-radius: 5px;
  border: 1px solid var(--on-color);
  cursor: pointer;
}
.selectItem.show{
  background-color: var(--on-color);
  color: #fff;
}
</style>
