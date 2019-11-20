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
                value-format="yyyy-MM-dd"
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
              <tr v-for="(item, key) in arrangeDate" :key="key">
                <td v-for="(subItem, subKey) in item" :key="subKey">
                  <template v-if="subItem != ''">
                    <em>{{ subItem.date.substring(subItem.date.length, subItem.date.length-2) }}</em>
                    <p><span>投放数量<el-input-number v-model="subItem.num" :min="0" :max="999" size='mini'></el-input-number></span></p>
                    <p><span>日转化率<el-input size="mini" placeholder="转化率" v-model="subItem.percent"></el-input>%</span></p>
                    <p><span>限制进店人数{{ Math.ceil(subItem.num / subItem.percent) }}</span></p>
                  </template>
                </td>
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
      arrangeDate: [],
      dateData: [
        {"date": '2019-11-29', "num": 10, "percent": 10},
        {"date": '2019-11-30', "num": 20, "percent": 50},
        {"date": '2019-12-01', "num": 60, "percent": 80},
        {"date": '2019-12-02', "num": 70, "percent": 90},
        {"date": '2019-12-03', "num": 80, "percent": 100},
        {"date": '2019-12-04', "num": 90, "percent": 60},
        {"date": '2019-12-05', "num": 95, "percent": 55},
        {"date": '2019-12-06', "num": 85, "percent": 15},
        {"date": '2019-12-07', "num": 75, "percent": 25},
        {"date": '2019-12-08', "num": 65, "percent": 30},
        {"date": '2019-12-09', "num": 55, "percent": 88},
        {"date": '2019-12-10', "num": 55, "percent": 88},
        {"date": '2019-12-11', "num": 55, "percent": 88},
        {"date": '2019-12-12', "num": 55, "percent": 88}
      ]
    }
  },
  mounted(){
    this.getTimeStr();
    this.arrangeFunc(this.dateData[0].date, false);
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

        //当用户改变日期后，根据选择的日期，整理arrangeDate数据，所有num及precent默认都为0
        this.arrangeFunc(val, true);
      }
    },
    arrangeFunc(val, isChange){
      //获取数据中起始日期是星期几
      let weekDay = new Date(val).getDay();
      
      //整理三周的数据
      let num = 0;
      switch (weekDay) {
        case 0:
          num = 7
          break;
        case 1:
          num = 6
          break;
        case 2:
          num = 5
          break;
        case 3:
          num = 4
          break;
        case 4:
          num = 3
          break;
        case 5:
          num = 2
          break;
        case 6:
          num = 1
          break;
        default:
          break;
      }
      let firstWeekArr = [];
      let secondWeekArr = [];
      let thirdWeekArr = [];
      let dateData = [];
      if(isChange){
        for(let i = 0; i < 14; i++){
          dateData.push({"date": '2019-12-12', "num": 0, "percent": 0});
        }
      }else{
        dateData = this.dateData;
      }
      for(let i = 0; i < weekDay; i++){
        firstWeekArr.push("");
      }
      for(let i = 0; i < num; i++){
        firstWeekArr.push(dateData[i]);
      }
      for(let i = num; i < num+7; i++){
        secondWeekArr.push(dateData[i]);
      }
      for(let i = num+7; i < dateData.length; i++){
        thirdWeekArr.push(dateData[i]);
      }
      for(let i = 0; i < num; i++){
        thirdWeekArr.push("");
      }
      if(isChange){
        this.arrangeDate[0] = firstWeekArr;
        this.arrangeDate[1] = secondWeekArr;
        this.arrangeDate[2] = thirdWeekArr;
      }else{
        this.arrangeDate.push(firstWeekArr);
        this.arrangeDate.push(secondWeekArr);
        this.arrangeDate.push(thirdWeekArr);
      }
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
  width: 93px;
  margin-left: 8px;
}
.el-input--mini{
  width: 70px;
  margin: 0 8px;
}
</style>
