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
                @change="changeTime">
              </el-date-picker>
            </td>
            <td colspan="2">
              <span class="errorInfo">设置计划日期不可在当前日期之前</span>
            </td>
          </tr>
          <tr>
            <td style="width:120px;">本次投放总量：</td>
            <td style="width:150px;"><el-input placeholder="多少件？" v-model="taskData.pushNum" @change="changePushNum"></el-input></td>
            <td class="unit" style="width:60px;">件</td>
            <td class="point">建议投放5件</td>
          </tr>
          <tr>
            <td style="width:120px;">进店转化率：</td>
            <td><el-input placeholder="百分之多少？" v-model="taskData.percentage" @change="changePercentage"></el-input></td>
            <td class="unit">%</td>
            <td class="point">不填写则不限制进店人数</td>
          </tr>
          <tr>
            <td>本次投放时长：</td>
            <td colspan="4">
              <el-radio v-model="taskData.dayNum" label="1" @change="changeRadioTime">1天</el-radio>
              <el-radio v-model="taskData.dayNum" label="2" @change="changeRadioTime">3天</el-radio>
              <el-radio v-model="taskData.dayNum" label="3" @change="changeRadioTime">5天</el-radio>
              <el-radio v-model="taskData.dayNum" label="4" @change="changeRadioTime">7天</el-radio>
              <el-radio v-model="taskData.dayNum" label="5" @change="changeRadioTime">9天</el-radio>
              <el-radio v-model="taskData.dayNum" label="6" @change="changeRadioTime">自定义</el-radio>
              <div class="lineInputFrm" :class="{show: taskData.dayNum == '6'}">
                <div class="lineInput">
                  <el-input placeholder="最多30天" v-model="taskData.taskDay" @change="changeInputTime"></el-input>
                </div>
                <span class="unit">天</span>
              </div>
            </td>
          </tr>
        </table>
      </el-collapse-item>
      <el-collapse-item title="2、计划表展示" name="top2">
        <div class="weekTable">
          <div class="tableTitle">{{ getFormatDate(upDate) }}</div>
          <div class="subItem" v-for="(item, key) in dateData" :key="key">
            <div class="day">{{ item.date.substring(item.date.length, item.date.length - 2) }} <span class="week">/&nbsp;周{{ showWeek(item.date) }}</span></div>
            <p><span>投放数量<el-input-number v-model="item.num" :min="0" :max="999" size='mini' @change="val => beforeData(val, key, subKey)"></el-input-number></span></p>
            <p><span>日进店人数<el-input size="mini" placeholder="进店率" v-model="dateData.npVal"></el-input></span></p>
            <p><span>{{ taskData.percentage ? '日转化率为'+taskData.percentage+'%' : '不限制当日进店人数' }}</span></p>
          </div>
        </div>
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
      upDate: new Date('2019-11-29'),     //日期
      nowDate: null,          //当前日期
      upDateStr: '',          //日期字符串
      taskData: {
        pushNum: '',            //投放件数
        percentage: '',         //转化率总数
        dayNum: null,            //投放时长设置
        taskDay: '' ,           //投放时长自定义
      },
      dateData: []
    }
  },
  components: {
    "llTaskModel": TaskModel,
  },
  computed: {
    showWeek(){
      return function(val){
        return this.getWeek(val);
      }
    },
    npVal(){
      return this.dateData.map(v => parseFloat(v.num) / parseFloat(v.percentage)).reduce((a, b) => a / b)
    }
  },
  created(){
    this.dateData = [
      {"date": '2019-11-29', "num": 0, "percent": 0},
      {"date": '2019-11-30', "num": 0, "percent": 0},
      {"date": '2019-12-01', "num": 0, "percent": 0},
      {"date": '2019-12-02', "num": 0, "percent": 0},
      {"date": '2019-12-03', "num": 0, "percent": 0}
    ]
  },
  mounted(){
    //将当前时间转换格式
    this.nowDate = this.getFormatDate(new Date())

    //设置时长字段的值为dateData的长度
    this.taskData.dayNum = this.getDayLength(false, this.dateData.length)
  },
  methods: {
    //当改变日期时，判断日期格式是否正确
    changeTime(val){
      if(this.nowDate > val){
        $(".errorInfo").show();
      }else{
        this.upDate = val;
        this.upDateStr = val;
        $(".errorInfo").hide();

        //当日期空间切换了正确格式的日期后，根据时长字段，插入默认的日期值
        this.dateData.length = 0;
        this.pushData(this.getDayLength(true, this.taskData.dayNum), this.upDate);

        //切换正确的日期后对每天的投放数量及进店比例计算赋值
        this.changePushNum(this.taskData.pushNum);
        this.changePercentage(this.taskData.percentage || 0);
      }
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

    /**
     * 由nums个数，从小到大排序，依次相加等于total
     * total: '要生成的总数'
     * nums: '这个总数由几个数组成'
     */
    randomDivide: function(total, nums){
      let rest = total;
      let arr = [];
      const result = Array.apply(null, { length: nums })
      .map((n, i) => nums - i)
      .map(n => {
        const v = 1 + Math.floor(Math.random() * (rest / n * 2 - 1));
        rest -= v;
        return v;
      });
      result[nums - 1] += rest;
      return result.sort(function(a, b){
        if(a > b) return 1;
        if(a < b) return -1;
        if(a = b) return 0;
      });
    },

    /**
     * 本次投放量字段对应的输入框变动时
     * 将投放量从小到大随机分配给每天
     */
    changePushNum(val){
      let numArr = this.randomDivide(val, this.dateData.length);
      for(let i = 0; i < this.dateData.length; i++){
        this.dateData[i].num = numArr[i];
      }
    },

    /**
     * 进店转化率字段对应的输入框变动时
     * 将转化率分配给所有的每天
     */
    changePercentage(val){
      for(let i = 0; i < this.dateData.length; i++){
        this.dateData[i].percent = val;
      }
    },

    /**
     * val: '传入几号，计算周几'
     */
    getWeek(val){
      let weekDay = new Date(val).getDay();
      let weekDayStr = '';
      switch (weekDay) {
        case 0: weekDayStr = '天';
          break;
        case 1: weekDayStr = '一';
          break;
        case 2: weekDayStr = '二';
          break;
        case 3: weekDayStr = '三';
          break;
        case 4: weekDayStr = '四';
          break;
        case 5: weekDayStr = '五';
          break;
        case 6: weekDayStr = '六';
          break;
        default:
          break;
      }
      return weekDayStr;
    },

    /**
     * isday: '你要的是不是天数值
     * val：'如果要天数值，val就是label值/如果要label值，val就是天数值'
     */
    getDayLength: function(isday, val){
      if(isday){
        switch (val) {
          case '1':return 1
            break;
          case '2':return 3
            break;
          case '3':return 5
            break;
          case '4':return 7
            break;
          case '5':return 9
            break;
          case '6':return this.taskData.taskDay
            break;
        }
      }else{
        switch (val) {
          case 1:return '1'
            break;
          case 3:return '2'
            break;
          case 5:return '3'
            break;
          case 7:return '4'
            break;
          case 9:return '5'
            break;
          default:this.taskData.taskDay = val;
            return '6';
            break;
        }
      }
    },

    /**
     * company: '要循环几次，代表向里面插入多少次'
     * date: '插入数据的起始日期'
     */
    pushData: function(company, date){
      let today = date;
      for(let i = 0; i < company; i++){
        this.dateData.push({"date": today, "num": 0, "percent": 0});
        today = this.getFormatDate(today, true);
      }
    },

    /**
     * date: '传入日期，返回当前日期的下一天'
     */
    getFormatDate(date, isAdd){
      let newDay = new Date(new Date(date).getTime());
      if(isAdd){
        newDay = new Date(new Date(date).getTime() + 1*24*60*60*1000);
      }
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

    /**
     * 投放时长的单选框切换时触发
     */
    changeRadioTime: function(val){
      if(val !== '6'){
        let dl = this.dateData.length
        let countDl = this.getDayLength(true, val)
        if(dl != countDl){
          this.dateData.length = 0
          this.pushData(countDl, this.getFormatDate(this.upDate));
        }
      }else{
        this.dateData.length = 0
        this.pushData(this.taskData.taskDay || 0, this.getFormatDate(this.upDate));
      }
      this.changePushNum(this.taskData.pushNum);
      this.changePercentage(this.taskData.percentage || 0);
    },

    /**
     * 自定义投放时长输入框，改变值时触发
     */
    changeInputTime: function(val){
      let dl = this.dateData.length;
      if(dl != val){
          this.dateData.length = 0
          this.pushData(val, this.getFormatDate(this.upDate));
      }
      this.changePushNum(this.taskData.pushNum);
      this.changePercentage(this.taskData.percentage || 0);
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
.tableTitle{
  font-size: 16px;
  font-weight: bold;
  text-align: center;
  padding-bottom: 15px;
}
.subItem .day{
  font-size: 16px;
  font-weight: bold;
  color: var(--on-color);
  margin-bottom: 8px;
}
.subItem p{
  padding-bottom: 10px;
  text-align: center;
}
.weekTable{
  font-size: 0;
}
.subItem{
  width: calc(100% / 7);
  display: inline-block;
  text-align: center;
  font-size: 12px;
  padding: 10px 0;
  border: 1px solid #DCDFE6;
  margin-right: -1px;
  margin-bottom: -1px;
}
tbody td{
  padding-left: 10px;
  width: 14.2%;
  height: 145px;
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