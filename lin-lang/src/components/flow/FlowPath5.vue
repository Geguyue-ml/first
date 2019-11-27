<template>
  <div id="path5">
    <el-collapse :value="showModel">
      <el-collapse-item title="1、付款信息" name="payInfo">
        <div class="grid-content bg-purple">
          <table class="payInfoTable">
            <tr>
              <td style="width:70%">本次任务发布10单</td>
              <td style="text-align:right;">金豆:154.80点</td>
            </tr>
          </table>
        </div>
      </el-collapse-item>
      <el-collapse-item title="2、支付方式" name="payType">
        <el-row>
          <el-col :span="24">
            <div class="grid-content bg-purple">
              <div class="itemPay active" @click="payTypeFunc($event)">
                <img class="payImg" src="../../assets/gold_icon.png">
                <span class="payTxt">金豆支付</span>
                <span class="rightTxt" title="金豆充值">（可用金豆个）</span>
              </div>
              <div class="itemPay" @click="payTypeFunc($event)">
                <img class="payImg" src="../../assets/vxin_icon.jpg">
                <span class="payTxt">微信支付</span>
              </div>
              <div class="itemPay" @click="payTypeFunc($event)">
                <img class="payImg" src="../../assets/alipay_icon.jpg">
                <span class="payTxt">支付宝支付</span>
              </div>
            </div>
          </el-col>
        </el-row>
      </el-collapse-item>
      <el-collapse-item title="3、技术服务" name="artServe">
        <el-row>
          <el-col :span="24">
            <div class="grid-content bg-purple">
              <span>选择开通时间<span class="point">（技术服务充值后不予退还，且不能用于发布任务费用）</span>：</span>
              <div class="flexBox">
                <div class="itemFrm active" @click="changeActive($event)">
                  <p class="title">
                    <span>3个月</span>
                    <i class="icon el-icon-check"></i>
                  </p>
                  <p class="cost">800元</p>
                  <p class="itemPoint">赠800个金豆，适合新手卖家短期使用</p>
                </div>
                <div class="itemFrm" @click="changeActive($event)">
                  <p class="title">
                    <span>6个月</span>
                    <i class="icon el-icon-check"></i>
                  </p>
                  <p class="cost">1200元</p>
                  <p class="itemPoint">赠1400个金豆，适合新手卖家短期使用</p>
                </div>
                <div class="itemFrm" @click="changeActive($event)">
                  <p class="title">
                    <span>12个月</span>
                    <i class="icon el-icon-check"></i>
                  </p>
                  <p class="cost">1900元</p>
                  <p class="itemPoint">赠2000个金豆，适合新手卖家短期使用</p>
                </div>
                <div class="itemFrm" @click="changeActive($event)">
                  <p class="title">
                    <span>24个月</span>
                    <i class="icon el-icon-check"></i>
                  </p>
                  <p class="cost">3200元</p>
                  <p class="itemPoint">赠3900个金豆，适合新手卖家短期使用</p>
                </div>
                <div class="itemFrm" @click="changeActive($event)">
                  <p class="title">
                    <span>48个月</span>
                    <i class="icon el-icon-check"></i>
                  </p>
                  <p class="cost">5200元</p>
                  <p class="itemPoint">赠7000个金豆，适合新手卖家短期使用</p>
                </div>
              </div>
            </div>
          </el-col>
        </el-row>
      </el-collapse-item>
    </el-collapse>
    <llTaskModel :next="6" :prev="4" @showFlow="showAlert"></llTaskModel>
  </div>
</template>

<script>
import TaskModel from '../TaskModel'

export default {
  name: 'FlowPath5',
  data () {
    return {
      showModel: ['artServe', 'payInfo', 'payType'],
      payType: '1',
    }
  },
  components: {
    "llTaskModel": TaskModel,
  },
  methods: {
    changeActive(ele){
      let _this = $(ele.target).parent(".itemFrm");
      if(_this.hasClass("active")){
        _this.removeClass("active");
      }else{
        $(".itemFrm").removeClass("active");
        _this.addClass("active");
      }
    },
    payTypeFunc(ele){
      $(".itemPay").removeClass("active");
      $(ele.target).parent(".itemPay").addClass("active");
      $(ele.target).addClass("active");
    },
    showAlert(){
      this.$emit('showTask');
    }
  }
}
</script>

<style scoped>
.point{
  font-size: 12px;
  color: var(--on-color);
}
.flexBox{
  display: flex;
  flex-wrap: nowrap;
  justify-content: space-around;
  margin-top: 15px;
}
.itemFrm{
  width: 180px;
  text-align: center;
  border: 1px solid  var(--on-color);
  border-radius: 5px;
  cursor: pointer;
  padding: 0 15px;
  position: relative;
}
.icon{
  position: absolute;
  right: 15px;
  top: 15px;
  display: none;
  font-size: 26px;
  font-weight: bold;
}
.itemFrm.active{
  background: var(--on-color);
  color: #fff;
}
.itemFrm.active .title{
  border-color: #fff;
}
.itemFrm.active .cost, .itemFrm.active .itemPoint{
  color: #fff;
}
.itemFrm.active .icon{
  display: inline-block;
}
.title{
  padding: 15px 0;
  border-bottom: 1px solid var(--on-color);
  font-size: 16px;
  font-weight: bold;
}
.cost{
  font-size: 18px;
  font-weight: bold;
  color: var(--on-color);
  padding: 15px 0;
}
.itemPoint{
  font-size: 12px;
  color: var(--on-color);
  text-align: left;
  margin-bottom: 15px;
}
#path5 .el-radio{
  width: auto;
}
.payInfoTable{
  width: 98%;
  margin: 0 30px 0 10px;
  border-collapse: collapse;
}
.payInfoTable td{
  padding: 15px 30px;
  background-color: rgb(252, 233, 233);
  font-size: 15px;
}
.itemPay{
  border-radius: 5px;
  border: 1px solid var(--on-color);
  vertical-align: top;
  cursor: pointer;
  font-size: 15px;
  margin-bottom: 25px;
}
.itemPay.active{
  color: #fff;
  background: var(--on-color);
}
.itemPay.active .rightTxt{
  background: url(../../assets/money_w.png) 110px center no-repeat;
  background-size: 15%;
  color: #fff;
}
.payImg, .payTxt{
  vertical-align: middle;
  padding: 15px 0 15px 25px;
}
.payTxt{
  padding-left: 10px;
}
.rightTxt{
  float: right;
  font-size: 15px;
  line-height: 50px;
  padding-right: 60px;
  background: url(../../assets/money.png) 110px center no-repeat;
  background-size: 15%;
  color: var(--on-color);
}
</style>
