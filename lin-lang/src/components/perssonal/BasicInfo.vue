<template>
  <el-col :span="20" id="basicInfo">
    <el-col :span="12" class="blockModel">
      <div class="grid-content bg-purple-light">
        <div class="title">账号信息</div>
        <div>
          <table>
            <tr>
              <td>用户头像</td>
              <td>
                <div class="useImg"><div></div></div>
              </td>
              <td><i class="el-icon-check"></i></td>
            </tr>
            <tr>
              <td>登录密码</td>
              <td>********</td>
              <td><i class="el-icon-check"></i></td>
            </tr>
            <tr>
              <td>提现密码</td>
              <td>********</td>
              <td><i class="el-icon-check"></i></td>
            </tr>
            <tr>
              <td colspan="3" class="point">
                <span>联系方式</span>
                <span>完善一下信息有助于平台与您联系</span>
              </td>
            </tr>
            <tr>
              <td>QQ账号</td>
              <td></td>
              <td><i class="el-icon-edit-outline"></i></td>
            </tr>
            <tr>
              <td>邮箱</td>
              <td>1021170632@qq.com</td>
              <td><i class="el-icon-check"></i></td>
            </tr>
            <tr>
              <td>手机</td>
              <td>18916495762</td>
              <td><i class="el-icon-check"></i></td>
            </tr>
          </table>
        </div>
      </div>
    </el-col>
    <el-col :span="12" class="blockModel">
      <div class="grid-content bg-purple-light">
        <div class="title">我的资金</div>
        <div>
          <div class="modelB">
            <div class="moneyInfo">
              <span>我的可用金豆：10293.39</span>
            </div>
            <input class="goBtn" type="button" value="发布试用任务">
          </div>
          <div class="modelB pointer">
            <img class="moneyIcon" src="../../assets/money.png" alt="金豆充值">
            <div class="moneyTxt">金豆充值</div>
          </div>
        </div>
      </div>
    </el-col>
    <el-col :span="12" class="blockModel">
      <div class="grid-content bg-purple-light">
        <div class="title">官方公告</div>
        <div>
          123
        </div>
      </div>
    </el-col>
    <el-col :span="12" class="blockModel">
      <div class="grid-content bg-purple-light">
        <div class="title">任务进展</div>
        <div>
          123
        </div>
      </div>
    </el-col>
  </el-col>
</template>

<script>
export default {
  name: 'BasicInfo',
  data () {
    return {
      
    }
  }
}
</script>

<style scoped>
#basicInfo{
  float: left;
  padding: 0 20px;
}
.el-col {
    border-radius: 4px;
    padding: 15px;
}
.bg-purple-light {
  background: #f0eeee;
  padding: 15px;
}
.grid-content {
  border-radius: 4px;
  min-height: 36px;
}
.row-bg {
  padding: 10px 0;
  background-color: #f9fafc;
}
.title{
  height: 40px;
  line-height: 40px;
  font-weight: bold;
  font-size: 16px;
  border-bottom: 1px solid #b9b9b9;
}
table{
  width: 100%;
}
table i{
  cursor: pointer;
}
tr{
  height: 40px;
}
.point{
  font-weight: bold;
}
.point span{
  margin-right: 15px;
}
.useImg{
  height: 50px;
  width: 50px;
  border-radius: 50px;
  overflow: hidden;
  margin: 15px 0;
}
.useImg div{
  background: url(../../assets/customer_service.png) no-repeat;
  background-size: 100%;
  height: 100%;;
}
.goBtn{
  margin-top: 20px;
  padding: 10px 30px;
  border-radius: 5px;
  border: none;
  background: var(--on-color);
  color: #fff;
  outline: none;
  font-size: 16px;
  cursor: pointer;
}
.moneyInfo{
  padding: 15px 0;
  font-weight: bold;
  color: var(--on-color);
}
.modelB{
  display: inline-block;
  margin-right: 35px;
  vertical-align: middle;
}
.modelB.pointer{
  cursor: pointer;
}
.moneyIcon{
  height: 80px;
  width: 80px;
}
.moneyTxt{
  text-align: center;
}
</style>
