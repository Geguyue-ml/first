<template>
  <div id="path3">
    <el-collapse :value="['1']">
      <el-collapse-item title="1、设置上线时间及投放计划" name="1" class="pathTitle">
        <table class="dateInput">
          <tr>
            <td style="width:120px;">任务上线的日期：</td>
            <td>
              <el-date-picker
                id="showDate"
                v-model="upDate"
                type="date"
                placeholder="请选择任务上线的日期"
                format="yyyy 年 MM 月 dd 日"
                value-format="yyyy 年 MM 月 dd 日"
                @change="getTime">
              </el-date-picker>
              <el-date-picker
                id="hideDate"
                v-model="nowDate"
                type="date"
                format="yyyy 年 MM 月 dd 日"
                value-format="yyyy 年 MM 月 dd 日">
              </el-date-picker>
              <span class="errorInfo">设置计划日期不可在当前日期之前</span>
            </td>
            <td colspan="2"></td>
          </tr>
        </table>
        <table class="dateInfo">
            <thead>
              <tr>
                <td colspan="7">{{ upDateStr }}</td>
              </tr>
              <tr class="week">
                <td>日</td>
                <td>一</td>
                <td>二</td>
                <td>三</td>
                <td>四</td>
                <td>五</td>
                <td>六</td>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>
                  <em>19</em>
                  <p>
                    <span>
                      投放数量
                      <el-input-number
                      v-model="num1"
                      @change="handleChange"
                      :min="0"
                      :max="999"
                      label="描述文字"
                      size='mini'></el-input-number>
                    </span>
                  </p>
                  <p>
                    <span>
                      日转化率
                      <el-input size="mini" placeholder="转化率" v-model="input1"></el-input>
                      %
                    </span>
                  </p>
                  <p>
                    <span>限制进店人数{{personNum1}}</span>
                  </p>
                </td>
                <td><em>20</em><p><span>投放数量</span></p><p><span>日转化率</span></p><p><span>限制进店人数</span></p></td>
                <td><em>21</em><p><span>投放数量</span></p><p><span>日转化率</span></p><p><span>限制进店人数</span></p></td>
                <td><em>22</em><p><span>投放数量</span></p><p><span>日转化率</span></p><p><span>限制进店人数</span></p></td>
                <td><em>23</em><p><span>投放数量</span></p><p><span>日转化率</span></p><p><span>限制进店人数</span></p></td>
                <td><em>24</em><p><span>投放数量</span></p><p><span>日转化率</span></p><p><span>限制进店人数</span></p></td>
                <td><em>25</em><p><span>投放数量</span></p><p><span>日转化率</span></p><p><span>限制进店人数</span></p></td>
              </tr>
              <tr>
                <td><em>19</em><p><span>投放数量</span></p><p><span>日转化率</span></p><p><span>限制进店人数</span></p></td>
                <td><em>20</em><p><span>投放数量</span></p><p><span>日转化率</span></p><p><span>限制进店人数</span></p></td>
                <td><em>21</em><p><span>投放数量</span></p><p><span>日转化率</span></p><p><span>限制进店人数</span></p></td>
                <td><em>22</em><p><span>投放数量</span></p><p><span>日转化率</span></p><p><span>限制进店人数</span></p></td>
                <td><em>23</em><p><span>投放数量</span></p><p><span>日转化率</span></p><p><span>限制进店人数</span></p></td>
                <td><em>24</em><p><span>投放数量</span></p><p><span>日转化率</span></p><p><span>限制进店人数</span></p></td>
                <td><em>25</em><p><span>投放数量</span></p><p><span>日转化率</span></p><p><span>限制进店人数</span></p></td>
              </tr>
              <tr>
                <td><em>19</em><p><span>投放数量</span></p><p><span>日转化率</span></p><p><span>限制进店人数</span></p></td>
                <td><em>20</em><p><span>投放数量</span></p><p><span>日转化率</span></p><p><span>限制进店人数</span></p></td>
                <td><em>21</em><p><span>投放数量</span></p><p><span>日转化率</span></p><p><span>限制进店人数</span></p></td>
                <td><em>22</em><p><span>投放数量</span></p><p><span>日转化率</span></p><p><span>限制进店人数</span></p></td>
                <td><em>23</em><p><span>投放数量</span></p><p><span>日转化率</span></p><p><span>限制进店人数</span></p></td>
                <td><em>24</em><p><span>投放数量</span></p><p><span>日转化率</span></p><p><span>限制进店人数</span></p></td>
                <td><em>25</em><p><span>投放数量</span></p><p><span>日转化率</span></p><p><span>限制进店人数</span></p></td>
              </tr>
            </tbody>
        </table>
      </el-collapse-item>
    </el-collapse>
    <div class="modelBox Btn">
      <div>
        <router-link class="npBtn prev" tag="div" :to="{name: 'flowPath1'}" @click.native="taskOk(2)"></router-link>
        <router-link class="npBtn next" tag="div" :to="{name: 'flowPath3'}" @click.native="taskOk(4)"></router-link>
      </div>
    </div>
  </div>
</template>

<script>
import { mapMutations } from 'vuex'

export default {
  name: 'FlowPath3',
  data () {
    return {
      upDate: new Date(),
      nowDate: new Date(),
      upDateStr: '',
      num1: 0,
      input1: '',
      personNum1: '',
      dateData: {
        "2019-11-29": {"num": 10, "percent": 30,},
        "2019-11-30": {"num": 10, "percent": 30,},
        "2019-12-01": {"num": 10, "percent": 30,},
        "2019-12-02": {"num": 10, "percent": 30,},
        "2019-12-03": {"num": 10, "percent": 30,},
        "2019-12-04": {"num": 10, "percent": 30,},
        "2019-12-05": {"num": 10, "percent": 30,},
        "2019-12-06": {"num": 10, "percent": 30,},
        "2019-12-07": {"num": 10, "percent": 30,},
        "2019-12-08": {"num": 10, "percent": 30,},
        "2019-12-09": {"num": 10, "percent": 30,},
        "2019-12-10": {"num": 10, "percent": 30,},
        "2019-12-11": {"num": 10, "percent": 30,},
        "2019-12-12": {"num": 10, "percent": 30,}
      },
    }
  },
  mounted(){
    this.getTimeStr();
    this.plan();
  },
  methods: {
    ...mapMutations(["taskOk"]),
    getTimeStr(){
      this.upDateStr = $('#showDate').val()
      this.nowDate = $('#hideDate').val()
      $('#hideDate').parent().hide()
    },
    getTime(val){
      if(this.nowDate > val){
        $(".errorInfo").show();
      }else{
        this.upDate = val;
        this.upDateStr = val;
        $(".errorInfo").hide();
      }
    },
    plan(){
      var plandate  = new Date();               //今天日期
      var plan_date = this.upDate;              //日期栏选择的日期

      plan_date.getDay();


      var days = 0;
      var planval = 0;
      if(plandate.getMonth() == plan_date.getMonth() && plandate.getDate() == plan_date.getDate()){
        if( plandate.getHours()>17 ){
          var week = plan_date.getDay()+1; //周几
          if( plan_date.getDay() == 8){
            week = 0;
          }
          var plandate_day = plan_date.getDate()+1;  //当前的日期
        }else{
          var week = plan_date.getDay(); //周几
          if( plan_date.getDay() == 7){
            week = 0;
          }
          var plandate_day = plan_date.getDate();  //当前的日期
        }
      }else{
        var week = plan_date.getDay(); //周几
        if( plan_date.getDay() == 7){
          week = 0;
        }
        var plandate_day = plan_date.getDate();  //当前的日期
      }
  
      //计算每月天数
      var plan_month = plan_date.getMonth()+1;
      var year       = plan_date.getYear();
      if (plan_month == 2) {
        days = year % 4 == 0 ? 29 : 28;
      }else if (plan_month == 1 || plan_month == 3 || plan_month == 5 || plan_month == 7 || plan_month == 8 || plan_month == 10 || plan_month == 12) {
        days = 31;
      }else {
        days = 30;
      }
      
	    planval = 1;
      var tmp_idx = week;
      var tmp_idx1 = 0 + week;
    
      if(plandate_day > days){
        plandate_day = plandate_day - days;
      }
      $(".plan_table").find("td").eq(tmp_idx1).html('<div class="plan_box3"><em>'+plandate_day+'</em><div class="plan_single"><span>投放数量</span><a href="javascript:;" val="1"></a><input type="text" name="day_num[]" onKeyUp="javascript:this.value=this.value.replace(/[^\\d]/g,\'\');if(this.value<0){this.value=0}" value="0" planval="1" class="day_num" /><a href="javascript:;" val="2"></a></div>'+
      '<div class="day_rate"><span>日转化率</span><input type="text" name="rate_num[]" onKeyUp="javascript:this.value=this.value.replace(/[^\\d]/g,\'\');if(this.value<0){this.value=0}" value="" class="rate_num" placeholder="不限制" /><span>%</span></div>'+
      '<div class="visitor">限制进店人数<span>不限制</span>人</div>'+
      '</div>');
      plandate_day++;
      if(plandate_day > days){
        plandate_day = plandate_day - days;
      }
      var tmp_idx = week;
    },
    handleChange(){

    }
  }
}
</script>

<style scoped>
.dateInput{
  width: 100%;
}
.dateInfo{
  margin-top: 20px;
  border-collapse:collapse;
  width: 99.9%;
}
.dateInfo thead td{
  text-align: center;
  font-size: 15px;
  padding: 10px 0;
}
.week td, tbody td{
  border: 1px solid #DCDFE6;
  text-align: center;
}
.errorInfo{
  display: none;
  color: #d81e06;
  margin-left: 15px;
  padding-left: 20px;
  background: url(../../assets/close.png) no-repeat 0 0;
  background-size: 9%;
}
tbody em{
  font-size: 20px;
  font-weight: bold;
  color: var(--on-color);
}
tbody td{
  padding-left: 10px;
  width: 14.2%;
}
tbody p{
  padding-bottom: 10px;
  text-align: left;
}
.el-input-number--mini{
  width: 96px;
}
.el-input--mini{
  width: 70px;
}
</style>
