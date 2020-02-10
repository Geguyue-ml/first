<template>
  <div id="transportInfo">
    <div>
      <span>是否包邮：</span>
      <div class="tabRadio">
        <el-radio v-model="param.whetherMail" label="1">包邮</el-radio>
        <el-radio v-model="param.whetherMail" label="2">不包邮</el-radio>
      </div>
      <span class="point">(需要用户支付运费)</span>
      <span class="point">温馨提示：当商品价格小于100元时，必须选择“包邮”</span>
      <div class="postFrm" :class="{show: param.whetherMail == '1'}">
        <div>
            <div class="tabRadio">
              <el-radio v-model="param.mailType" label="1">商品本身不包邮</el-radio>
            </div>
            <span class="point">用户无需联系客服，商家额外支付10元/单作为运费余额，任务完成后剩余的运费余额将返还给商家</span>
        </div>
        <div>
          <div class="tabRadio">
            <el-radio v-model="param.mailType" label="2">商品本身包邮</el-radio>
          </div>
          <span class="point">用户直接按商品实际金额下单</span>
        </div>
      </div>
    </div>
    <table>
      <tr>
        <td class="title">手机：</td>
        <td>
          <el-input placeholder="请输入您的手机联系方式" v-model="param.phone"></el-input>
        </td>
        <td class="title">微信：</td>
        <td>
           <el-input placeholder="请输入您的微信联系方式" v-model="param.weixin"></el-input>
        </td>
        <td class="title">QQ：</td>
        <td>
           <el-input placeholder="请输入您的QQ联系方式" v-model="param.qq"></el-input>
        </td>
      </tr>
      <tr>
        <td colspan="4">
          <span class="pointTitle">温馨提示：请在发布商品推广期间，暂停淘宝客等返利设置，避免不必要的损失</span>
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
      param: {
        whetherMail: "1",
        mailType: '1',
        phone: null,
        qq: null,
        weixin: null
      }
    }
  },
  watch: {
    param: {
      handler(newVal){
        this.$parent.$parent.$parent.contactType = newVal
      },
      immediate: true,
      deep: true
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
.point{
  font-size: 12px;
  padding-left: 25px;
  color: var(--off-color);
}
.pointTitle{
  color: var(--on-color);
}
.tabRadio{
  display: inline-block;
}
.postFrm{
  display: none;
  margin-left: 100px;
}
.postFrm.show{
  display: block;
}
</style>
