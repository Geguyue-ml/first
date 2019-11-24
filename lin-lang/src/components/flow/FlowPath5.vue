<template>
  <div id="path5">
    <el-collapse :value="showModel">
      <el-collapse-item title="1、技术服务" name="artServe">
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
        <el-row>
          <el-col :span="24">
            <div class="grid-content bg-purple">
              
            </div>
          </el-col>
        </el-row>
      </el-collapse-item>
    </el-collapse>
    <el-collapse-item title="2、付款信息" name="payInfo">
      <el-row>
        <el-col :span="24">
          <div class="grid-content bg-purple">
            
          </div>
        </el-col>
      </el-row>
    </el-collapse-item>
    <llTaskModel :next="6" :prev="4"></llTaskModel>
  </div>
</template>

<script>
import TaskModel from '../TaskModel'

export default {
  name: 'FlowPath5',
  data () {
    return {
      showModel: ['artServe', 'payInfo'],
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
</style>
