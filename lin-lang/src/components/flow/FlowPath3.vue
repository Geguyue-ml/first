<template>
  <div id="path3">
    <el-collapse :value="['top1', 'top2']">
      <el-collapse-item title="1、设置上线时间及投放计划" name="top1">
        <table class="dateInput">
          <tr>
            <td style="width:120px;">任务上线的日期：</td>
            <td>
              <el-date-picker
                id="showDate"
                v-model="upDate"
                type="date"
                placeholder="请选择任务上线的日期"
                format="yyyy-MM-dd"
                value-format="yyyy-MM-dd"
                @change="getTime">
              </el-date-picker>
              <el-date-picker
                id="hideDate"
                v-model="nowDate"
                type="date"
                format="yyyy-MM-dd"
                value-format="yyyy-MM-dd">
              </el-date-picker>
              <span class="errorInfo">设置计划日期不可在当前日期之前</span>
            </td>
            <td colspan="2"></td>
          </tr>
          <tr>
            <td style="width:120px;">本次投放总量：</td>
            <td style="width:150px;"><el-input placeholder="多少件？" v-model="taskData.pushNum"></el-input></td>
            <td class="unit" style="width:60px;">件</td>
            <td class="point">建议投放5件</td>
          </tr>
          <tr>
            <td style="width:120px;">进店转化率：</td>
            <td><el-input placeholder="百分之多少？" v-model="taskData.percentage"></el-input></td>
            <td class="unit">%</td>
            <td class="point">不填写则不限制进店人数</td>
          </tr>
          <tr>
            <td>本次投放时长：</td>
            <td colspan="3" style="width:680px;">
              <el-radio v-model="taskData.dayNum" label="1">1天</el-radio>
              <el-radio v-model="taskData.dayNum" label="2">3天</el-radio>
              <el-radio v-model="taskData.dayNum" label="3">5天</el-radio>
              <el-radio v-model="taskData.dayNum" label="4">7天</el-radio>
              <el-radio v-model="taskData.dayNum" label="5">9天</el-radio>
              <el-radio v-model="taskData.dayNum" label="6">自定义</el-radio>
              <div class="lineInputFrm" :class="{show: taskData.dayNum == '6'}">
                <div class="lineInput">
                  <el-input placeholder="最多30天" v-model="taskData.taskDay"></el-input>
                </div>
                <span class="unit">天</span>
              </div>
            </td>
            <td>
              <div class="creatTable">生成投放计划表</div>
            </td>
          </tr>
        </table>
      </el-collapse-item>
      <el-collapse-item title="2、计划表展示" name="top2">
        <table class="dateInfo">
            <thead>
              <tr>
                <td colspan="7" class="title">{{ upDateStr }}</td>
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
                    <p><span>投放数量<el-input-number v-model="subItem.num" :min="0" :max="999" size='mini' @change="val => beforeData(val, key, subKey)"></el-input-number></span></p>
                    <p><span>进店比列<el-input size="mini" placeholder="进店率" v-model="subItem.percent"></el-input>%</span></p>
                    <p><span>限制进店人数{{ Math.ceil(subItem.num / subItem.percent) || '最大化' }}</span></p>
                  </template>
                </td>
              </tr>
            </tbody>
        </table>
      </el-collapse-item>
    </el-collapse>
    <llTaskModel :next="4" :prev="2"></llTaskModel>
  </div>
</template>

<script>
import TaskModel from '../TaskModel' 

export default {
  name: 'FlowPath3',
  data () {
    return {
      arrangeDate: [],        //整理后的数据
      upDate: new Date(),     //日期
      nowDate: new Date(),    //当前日期
      upDateStr: '',          //日期字符串
      taskData: {
        pushNum: '',            //投放件数
        percentage: '',         //转化率总数
        dayNum: '1',            //投放时长设置
        taskDay: '' ,           //投放时长自定义
      },
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
  components: {
    "llTaskModel": TaskModel,
  },
  mounted(){
    this.getTimeStr();
    this.arrangeFunc(this.dateData[0].date);
  },
  methods: {
    getTimeStr(){
      this.upDateStr = $('#showDate').val()
      this.nowDate = $('#hideDate').val()
      $('#hideDate').parent().hide()
    },
    //当改变日期时，判断日期格式是否正确
    getTime(val){
      if(this.nowDate > val){
        $(".errorInfo").show();
      }else{
        this.upDate = val;
        this.upDateStr = val;
        $(".errorInfo").hide();

        //根据输入的设置收集dateData数据
        this.defaultVal(this.taskData);

        //当用户改变日期后，根据选择的日期，整理arrangeDate数据，所有num及precent默认都为0
        this.arrangeFunc(val);
      }
    },

    //整理数据的方法
    arrangeFunc(val){
      //获取数据中起始日期是星期几
      let weekDay = new Date(val).getDay();
      let firstWeekArr = [];
      let secondWeekArr = [];
      let thirdWeekArr = [];
      let dateData = this.dateData;
      
      //整理三周的数据
      let num = 0;
      switch (weekDay) {
        case 0: num = 7;
          break;
        case 1: num = 6;
          break;
        case 2: num = 5;
          break;
        case 3: num = 4;
          break;
        case 4: num = 3;
          break;
        case 5: num = 2;
          break;
        case 6: num = 1;
          break;
        default:
          break;
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

      this.$set(this.arrangeDate, 0, firstWeekArr);
      this.arrangeDate[1] = secondWeekArr;

      if(thirdWeekArr[0] == ""){
        this.arrangeDate[2] = ""
      }else{
        this.arrangeDate[2] = thirdWeekArr;
      }
    },

    //整理数据时用的：返回当前天+1天
    addDate(date){
      let newDay = new Date(new Date(date).getTime() + 1*24*60*60*1000);
      let year = newDay.getFullYear();
      let month = newDay.getMonth()+1;
      if(month < 10){
        month = '0' + month;
      }
      let day = newDay.getDate();
      if(day < 10){
        day = '0' + day;
      }
      return year + '-' + month + '-' + day;
    },

    //表格中的投放数量，修改后触发，传入被修改元素的下标及子下标，并修改数据
    beforeData(val, key, subKey){
      var arrangeDate = this.arrangeDate;

      //arrangeDate数组中，子下标中num的值不为0时
      if(arrangeDate[key][subKey].num != 0){

        //传入子下标的位置，执行该函数
        changeData(key, subKey);
      }

      this.arrangeDate = arrangeDate;

      //得到下标位置，时该位置之前所有天的投放数量至少为1
      function changeData(key, subKey){
        if(key == 0){
          for(let index in arrangeDate[0]){
            if(index >= subKey && arrangeDate[0][index].num == 0){
              arrangeDate[0][index].num = 1
            }
          }
        }else if(key == 1){
          for(let index in arrangeDate[0]){
            if(typeof arrangeDate[0][index] == "object" && arrangeDate[0][index].num == 0){
              arrangeDate[0][index].num = 1
            }
          }
          for(let index in arrangeDate[1]){
            if(index <= subKey && arrangeDate[1][index].num == 0){
              arrangeDate[1][index].num = 1
            }
          }
        }else{
          for(let index in arrangeDate){
            if(index<2){
              for(let subIndex in arrangeDate[index]){
                if(typeof arrangeDate[index][subIndex] == "object" && arrangeDate[index][subIndex].num == 0){
                  arrangeDate[index][subIndex].num = 1
                }
              }
            }else{
              for(let index in arrangeDate[2]){
                if(index <= subKey && arrangeDate[2][index].num == 0){
                  arrangeDate[2][index].num = 1
                }
              }
            }
          }
        }
      }
    },

    //根据传入的数据，决定设置项的值
    defaultVal(val){
      let wNum = val.pushNum || 0;
      let wPercentage = val.percentage || 0;
      let wTime = '';
      if(val.dayNum == '6'){
        wTime = val.taskDay
      }else if(val.dayNum == '5'){
        wTime = 9
      }else if(val.dayNum == '4'){
        wTime = 7
      }else if(val.dayNum == '3'){
        wTime = 5
      }else if(val.dayNum == '2'){
        wTime = 3
      }else if(val.dayNum == '1'){
        wTime = 1
      }
      
      //根据设置项的值，整理dateData中的值
      let today = this.upDateStr;
      for(let i = 0; i < wTime; i++){
        this.dateData.push(
          {"date": today, "num": 10, "percent": 10},
        );
        today = this.addDate(today);
      }
      const result = this.randomDivide(60, 5 );
      console.log(result.join(","));
    },
    randomDivide: function(total, nums){
      let rest = total;

      const result = Array.apply(null, { length: nums })
      .map((n, i) => nums - i)
      .map(n => {
        const v = 1 + Math.floor(Math.random() * (rest / n * 2 - 1));
        rest -= v;
        return v;
      });
      result[nums - 1] += rest;
      return result;
    }
  },
  watch: {
    arrangeDate: {
      handler(val){
        let isChangeZero = false;     //是否将后面所有天的投放数量归零
        for(let item of val){
          for(let subItem of item){
            if(typeof subItem == "object"){
              if(!isChangeZero){
                if(subItem.num == 0){
                  isChangeZero = true;
                }
              }else{
                subItem.num = 0;
              }
            }
          }
        }
      },
      deep: true
    },
    taskData: {
      handler(newVal){
        this.defaultVal(newVal);
      },
      deep: true
    }
  }
}
</script>

<style scoped>
.dateInput{
  width: 100%;
}
.creatTable{
  display: inline;
  border: 1px solid var(--on-color);
  border-radius: 5px;
  background: var(--on-color);
  color: #fff;
  font-size: 15px;
  text-align: center;
  cursor: pointer;
  padding: 10px 20px;
}
.dateInfo{
  border-collapse:collapse;
  width: 99.9%;
}
.dateInfo thead .title{
  font-size: 16px;
  font-weight: bold;
  padding: 15px 0;
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
  height: 145px;
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
.dateInput td{
  padding: 10px 0;
}
.dateInput .unit{
  padding-left: 10px;
}
.point{
  font-size: 12px;
  color: var(--off-color);
}
#path3 .dateInput .el-radio{
  margin-right: 15px;
}
.lineInputFrm{
  display: none;
}
.lineInputFrm.show{
  display: inline-block;
}
.lineInput{
  display: inline-block;
}
</style>
