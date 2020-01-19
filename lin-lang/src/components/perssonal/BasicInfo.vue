<template>
  <el-col :span="20" id="basicInfo">
    <el-col :span="16">
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
    <el-col :span="8">
      <div class="grid-content bg-purple-light">
        <div class="title">我的资金</div>
        <div class="modelB">
          <img class="moneyIcon" src="../../assets/money.png" alt="金豆充值"><br/>
          <span class="moneyTxt">金豆充值</span>
        </div>
        <div class="moneyInfo">
          <span>我的可用金豆：10293.39</span>
          <input class="goBtn" type="button" value="发布任务">
        </div>
      </div>
    </el-col>
    <el-col :span="24">
      <div class="grid-content bg-purple-light">
        <div class="title">官方公告</div>
        <div class="maxH-gfgg">
          <ul>
            <li><span>公告第一条：i的分解飞机飞机你覅姐姐菲菲姐都v路v率积分是东京附魔vi哦热i据哦ii而据哦</span></li>
            <li><span>公告第二条：i的分解飞机飞机你覅姐姐圣诞节佛哦玩具哦i恶剧欸菊科菊哦欸率菲菲姐都v路v率积分</span></li>
            <li><span>公告第三条：i的分解飞机飞机你覅姐姐菲菲姐都v路v率积分</span></li>
            <li><span>公告第四条：i的分解飞机收到vv方法v让他给他人飞机你覅姐姐菲菲姐都v路v率积分</span></li>
            <li><span>公告第五条：i的分解对方的vv让他把日本飞机飞机你覅姐姐菲菲姐都v路v率积分</span></li>
            <li><span>公告第六条：i的分解飞机飞机你覅姐姐菲菲姐都v路v率积分</span></li>
          </ul>
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
  font-weight: bold;
  color: var(--on-color);
  text-align: center;
}
.modelB{
  vertical-align: middle;
  margin: 15px auto 25px;
  text-align: center;
}
.moneyIcon{
  height: 80px;
  width: 80px;
  cursor: pointer;
}
.moneyTxt{
  font-weight: bold;
  color: var(--on-color);
  cursor: pointer;
}
.maxH-gfgg li{
  padding: 10px 0;
  cursor: pointer;
  background: url('../../assets/arrow_right_b.png') no-repeat 0 11px;
  background-size: 2.4%;
}
.maxH-gfgg li:hover{
  color: var(--on-color);
  background: url('../../assets/arrow_right_p.png') no-repeat 0 11px;
  background-size: 2.4%;
}
.maxH-gfgg span{
  padding-left: 25px;
  vertical-align: middle;
  white-space: nowrap;
  display: inline-block;
  width: 100%;
  overflow: hidden;
  text-overflow: ellipsis;
}
</style>
