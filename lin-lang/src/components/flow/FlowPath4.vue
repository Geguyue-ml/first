<template>
  <div id="path4">
    <el-collapse :value="taskAll">
      <el-collapse-item title="系统默认" name="defaultServe">
        <el-row>
          <el-col :span="24">
            <div class="grid-content bg-purple">
              <span class="pointTitle">精准投放（20金豆）</span>
              <div class="infoFrm">
                <p class="point">选择此服务后，琳琅将根据地区、性别、年龄段、收入、职业筛选准确的人群通过审核</p>
              </div>
            </div>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="24">
            <div class="grid-content bg-purple">
              <span class="pointTitle">任务审核（2金豆）</span>
              <div class="infoFrm">
                <p>9-24点发布的任务，琳琅会在30分钟内审核完毕，若任务发布有问题，系统会驳回让您修改，客服会第一时间与您联系。</p>
              </div>
            </div>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="24">
            <div class="grid-content bg-purple">
              <span class="pointTitle">短信通知（1金豆）</span>
              <div class="infoFrm">
                <p class="point">选择此服务后，系统将推送中奖短信给用户，提示用户将在指定时间内完成进店下单</p>
              </div>
            </div>
          </el-col>
        </el-row>
        <el-row v-if="taskType == '1'">
          <el-col :span="24">
            <div class="grid-content bg-purple">
              <span class="pointTitle">担保金（商品金额大于250时，多少钱？）</span>
              <div class="infoFrm">
                <p class="point">选择此服务，需支付商品金额的10%作为担保金，任务完成后退还</p>
                <p class="pointTitle">注：有以下行为者，担保金不予以退还</p>
                <p>1、商家拍A发B，用户收到的商品跟发布任务的商品不符，且商家不同意补发；</p>
                <p>2、用户收到的商品为残次品，且商家不愿意补发；</p>
                <p>3、发布的任务商品不是预售商品时，超过72小时不给用户发货；</p>
                <p>4、因商家个人或快递等原因，导致用户收到的商品破损，影响正常使用，且商家不愿意补发。</p>
              </div>
            </div>
          </el-col>
        </el-row>
        <el-row v-if="taskType == '1'">
          <el-col :span="24">
            <div class="grid-content bg-purple">
              <span class="pointTitle">搜索关键词截图</span>
              <div class="infoFrm">
                <p class="point">选择此服务后，所有做第一天任务流程的用户，需要按照任务关键词搜索进店，并上传搜索截图便于商家审核</p>
                <p class="pointTitle">温馨提示：系统默认用户做任务不用上传关键词截图，若需要用户上传关键词截图可以勾选。强制设置用户上传截图，可能会影响用户积极性。</p>
              </div>
            </div>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="24">
            <div class="grid-content bg-purple">
              <span class="pointTitle">用户中奖2小时内下单</span>
              <div class="infoFrm">
                <p class="point">选择此服务后，用户要在中奖后2小时内完成领奖下单，用户超时未下单平台将自动取消中奖资格，推送给其他用户完成</p>
                <p class="pointTitle">未设置此选项的任务，系统默认用户最晚在21:30前下单，超时未下单将自动取消。</p>
              </div>
            </div>
          </el-col>
        </el-row>
      </el-collapse-item>
      <el-collapse-item title="提升用户积极性" name="upPositive" v-if="taskType == '1'">
        <el-row>
          <el-col :span="24">
            <div class="grid-content bg-purple">
              <el-checkbox v-model="upPositive.uphfd">提升店铺回访度（40金豆）</el-checkbox>
              <div class="infoFrm">
                <p class="point">选择此服务后，连续3天访问店铺并完成申请的用户将获得平台的积分奖励，极大提高用户回访店铺的积极性</p>
                <p>用户将3天分别完成：搜索找商品、浏览店铺、加入购物车、收藏商品、收藏店铺，有助于提高：搜索点击率、重复访问率、人气权重等。</p>
              </div>
            </div>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="24">
            <div class="grid-content bg-purple">
              <el-checkbox v-model="upPositive.jdjl">金豆激励</el-checkbox>
              <div class="infoFrm">
                <p class="point">选择此服务，完成第1天申请任务的用户可获得金豆奖励，奖励的金豆越多，用户申请的积极性越大，可刺激更多用户参与申请</p>
                <p class="pointTitle">强烈推荐车用品/家庭保健/手机配件/护肤彩妆类目或平日商品申请人数少的商家选择</p>
                <div class="infoTable" :class="{'hide': !upPositive.jdjl}">
                  <table>
                    <tr>
                      <td style="width:118px;">金豆奖励：</td>
                      <td style="width:150px;"><el-input v-model="upPositive.gold" placeholder="多少金豆？" size="mini"></el-input></td>
                      <td style="width:80px;">金豆/人</td>
                      <td>(最低1金豆/人)</td>
                    </tr>
                    <tr>
                      <td>设置奖励人数：</td>
                      <td><el-input v-model="upPositive.people" placeholder="多少人？" size="mini"></el-input></td>
                      <td>人</td>
                      <td>共计：100人x1金豆=100金豆</td>
                    </tr>
                  </table>
                </div>
              </div>
            </div>
          </el-col>
        </el-row>
      </el-collapse-item>
      <el-collapse-item title="广告位投放" name="adsense" v-if="taskType == '1'">
        <el-row>
          <el-col :span="24">
            <div class="grid-content bg-purple">
              <el-checkbox v-model="adsense.ggwtf">我要上首页、列表页固定展示位 (60金豆)</el-checkbox>
              <div class="infoFrm">
                <p class="point">选择此项服务后，您发布的商品将在任务上线后，每隔15分钟将轮播展示在琳琅首页【平台推荐】的位置，同时为您的宝贝打上"<span>荐</span>"的标签，提升你宝贝在平台的综合排名，直至活动结束</p>
                <p class="point">选择此项服务后，您发布的商品将在第1天重新固定展示在琳琅首页或列表页【平台推荐】的位置继续展示4天</p>               <p class="pointTitle">广告位有限，预购请联系客服：</p>
                <p>任务发布后，您发布的商品在前3天，能获得一定数量的用户申请，为解决第4天没有用户申请的问题，建议选择广告投放的服务，可提高商品在琳琅的曝光度，让更多用户看到并参与申请。</p>
              </div>
            </div>
          </el-col>
        </el-row>
      </el-collapse-item>
      <el-collapse-item title="安全优化" name="safe">
        <el-row>
          <el-col :span="24">
            <div class="grid-content bg-purple">
              <div class="radioFrm">
                <span>禁止老用户中奖：</span>
                <div class="radioItem"><el-radio v-model="safe.safeDay" label="1">30天/0金豆</el-radio></div>
                <div class="radioItem"><el-radio v-model="safe.safeDay" label="2">60天/10金豆</el-radio></div>
                <div class="radioItem"><el-radio v-model="safe.safeDay" label="3">90天/20金豆</el-radio></div>
                <div class="radioItem"><el-radio v-model="safe.safeDay" label="4">150天/30金豆</el-radio></div>
              </div>
              <div class="infoFrm">
                <p class="point">选择此服务不会影响用户申请人数，仅推荐重复购买率低的商品使用，如：家居、家电、高价值的商品等</p>
                <p class="point">选择此服务后，1个月内中过您店铺任一商品的用户将不会获得本次商品品的中奖机会</p>
              </div>
            </div>
          </el-col>
        </el-row>
      </el-collapse-item>
      <el-collapse-item title="用户进店控制" name="intoControl">
        <el-row>
          <el-col :span="24">
            <div class="grid-content bg-purple">
              <el-checkbox v-model="intoControl.isShowProblem">用户浏览宝贝详情页中的问题（10金豆/次）</el-checkbox>
              <div class="infoFrm">
                <p class="point">规范用户进店深度访问店铺宝贝</p>
                <p>请在您发布的商品详情页中，查找1个商品信息作为本次活动的问题和答案；平台将在用户第1天进店访问时展示</p>
                <div class="infoTable" :class="{'hide': !intoControl.isShowProblem}">
                  <table>
                    <tr>
                      <td style="width:58px;">问题：</td>
                      <td style="width:220px;"><el-input v-model="intoControl.porblem" placeholder="产品参数中，宝贝风格是什么？" size="mini"></el-input></td>
                      <td></td>
                    </tr>
                    <tr>
                      <td>答案：</td>
                      <td><el-input v-model="intoControl.answer" placeholder="香香猪" size="mini"></el-input></td>
                      <td></td>
                    </tr>
                  </table>
                </div>
              </div>
            </div>
          </el-col>
        </el-row>
      </el-collapse-item>
      <el-collapse-item title="细化中奖人群标签" name="labelObj">
        <el-row>
          <el-col :span="24">
            <div class="grid-content bg-purple">
              <el-checkbox v-model="labelObj.isLabel">细化中奖人群标签</el-checkbox>
              <div class="infoFrm">
                <p class="point">选择此服务，可精准控制中奖人群，使流量更精准，快速提高宝贝真实转化率</p>
                <p class="pointTitle">温馨提示：用户中奖条件繁多，如再过多的设置中奖条件，将降低任务完成率。</p>
                <p>系统将根据任务要求优先抽取符合条件的用户中奖，当没有用户可以完成匹配的时候，系统将对用户的兴趣标签择优匹配，（如果选择性别条件后，用户需要满足条件才可中奖）。</p>
                <p>平台不保证中奖用户100%符合中奖条件，未匹配的人群标签费用将在任务完成后退回到您的琳琅账户。</p>
                <p>系统将优先匹配符合多项条件的用户中奖，其余部分将根据设置的条件进行单项筛选用户中奖。</p>
                <div class="infoTable" :class="{'hide': !labelObj.isLabel}">
                  <div class="subFrm">
                    <el-checkbox v-model="labelObj.isSex">性别：</el-checkbox>
                    <span class="point">选择此项后，用户需要满足条件才可中奖</span>
                    <div class="infoFrm">
                      <div class="infoTable" :class="{'hide': !labelObj.isSex}">
                        <table>
                          <tr>
                            <td style="width:110px;">性别：</td>
                            <td colspan="3">
                              <div class="radioItem"><el-radio v-model="labelObj.sex" label="1">男</el-radio></div>
                              <div class="radioItem"><el-radio v-model="labelObj.sex" label="2">女</el-radio></div>
                            </td>
                          </tr>
                          <tr>
                            <td>设置下单人数：</td>
                            <td style="width:110px;"><el-input v-model="labelObj.sexNum" placeholder="多少人？" size="mini"></el-input></td>
                            <td style="width:50px;">人</td>
                            <td>共计：10人×1金豆=10金豆</td>
                          </tr>
                        </table>
                      </div>
                    </div>
                  </div>
                  <div class="subFrm">
                    <el-checkbox v-model="labelObj.isAge">年龄段：</el-checkbox>
                    <span class="point">可多选</span>
                    <div class="infoFrm">
                      <div class="infoTable" :class="{'hide': !labelObj.isAge}">
                        <table>
                          <tr>
                            <td style="width:110px;">年龄段：</td>
                            <td colspan="3">
                              <div class="radioItem"><el-checkbox v-model="labelObj.age18">18-26岁</el-checkbox></div>
                              <div class="radioItem"><el-checkbox v-model="labelObj.age26">26-37岁</el-checkbox></div>
                              <div class="radioItem"><el-checkbox v-model="labelObj.age37">37-51岁</el-checkbox></div>
                              <div class="radioItem"><el-checkbox v-model="labelObj.age51">51岁以上</el-checkbox></div>
                            </td>
                          </tr>
                          <tr>
                            <td>设置下单人数：</td>
                            <td style="width:110px;"><el-input v-model="labelObj.ageNum" placeholder="多少人？" size="mini"></el-input></td>
                            <td style="width:50px;">人</td>
                            <td>共计：10人×1金豆=10金豆</td>
                          </tr>
                        </table>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </el-col>
        </el-row>
      </el-collapse-item>
      <el-collapse-item title="口碑营销" name="market">
        <el-row>
          <el-col :span="24">
            <div class="grid-content bg-purple">
              <el-checkbox v-model="goodWord.star">五星好评</el-checkbox>
              <div class="infoFrm">
                <p class="point">选择此服务后，用户在评价时只需五星好评，不做任何文字、图片的评价</p>
                <p class="pointTitle">注：此服务不能和图文好评、买家秀、好评悬赏以及关键字好评、视频评价同时选择。</p>
                <div class="infoTable" :class="{'hide': !goodWord.star}">
                  <table>
                    <tr>
                      <td style="width:188px;" class="tableTitle">设置五星好评的用户比例：</td>
                      <td style="width:110px;"><el-input v-model="goodWord.starNum" placeholder="多少？" maxlength="10" size="mini" show-word-limit></el-input></td>
                      <td>%</td>
                      <td>您总计投放10份，其中10人将分配为五星评价，剩余0人将分配为普通文字评价</td>
                    </tr>
                  </table>
                </div>
              </div>
            </div>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="24">
            <div class="grid-content bg-purple">
              <el-checkbox v-model="goodWord.isGoodWord">设置好评关键字（1金豆/每单）</el-checkbox>
              <div class="infoFrm">
                <p class="point">选择此服务后，您可以设置用户对商品好评的内容范围</p>
                <p class="point">选择此服务后，系统会将以下关键词随机分配给中奖用户，用户评价内容需涉及到分配的相关关键词</p>
                <p>请根据您发布的商品设定相关的关键词，用户将根据关键词独自发挥撰写评价，如"手感舒适、款式漂亮、服务满意、性价比高"等。 注意：填写的内容中不要有标点和空格，只能填写商品相关的词语，不得填写不相关的词汇，不要填写完整评价内容，避免用户评价相识度过高。</p>
                <div class="infoTable" :class="{'hide': !goodWord.isGoodWord}">
                  <table>
                    <tr v-for="(item, key) in goodWord.wordVal" :key="key">
                      <td style="width:88px;" class="tableTitle">关键词{{key + 1}}：</td>
                      <td style="width:200px;"><el-input v-model="item.name" placeholder="关键词" maxlength="10" size="mini" show-word-limit></el-input></td>
                      <td style="width:180px;" class="tableTitle">设置发放好评关键字份数：</td>
                      <td style="width:90px;"><el-input v-model="item.num" placeholder="几份？" size="mini"></el-input></td>
                      <td style="width:200px;">份（数量不能超过中奖人数）</td>
                      <td>
                        <i class="el-icon-circle-plus-outline inputBtn" title="最多添加六个关键词" @click="addLine"></i>
                        <i class="el-icon-remove-outline inputBtn" title="删除当前关键词" @click="removeLine($event)" :data-wordNum="key"></i>
                      </td>
                    </tr>
                  </table>
                </div>
              </div>
            </div>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="24">
            <div class="grid-content bg-purple">
              <el-checkbox v-model="goodWord.imgGood">普通文字好评(2金豆/单)</el-checkbox>
              <div class="infoFrm">
                <p class="point">选择此服务后，中奖用户需进行普通文字好评</p>
                <p>建议服装、配饰、鞋包、护肤等类目商品，需要快速提高宝贝转化率，优化宝贝文字评价，精准控制进店人群。</p>
                <div class="infoTable" :class="{'hide': !goodWord.txtGood}">
                  <table>
                    <tr>
                      <td style="width:118px;" class="tableTitle">设置执行人数：</td>
                      <td style="width:110px;"><el-input v-model="goodWord.txtGoodNum" placeholder="几人？" maxlength="10" size="mini" show-word-limit></el-input></td>
                      <td>人</td>
                    </tr>
                  </table>
                </div>
              </div>
            </div>
          </el-col>
        </el-row>
        <el-row v-if="taskType == '1'">
          <el-col :span="24">
            <div class="grid-content bg-purple">
              <el-checkbox v-model="goodWord.imgGood">普通图文好评(3金豆/单)</el-checkbox>
              <div class="infoFrm">
                <p class="point">选择此服务后，中奖用户需进行上传普通图片，商家不可强制要求用户真人露脸上镜，用户可选择只拍商品照片</p>
                <p>建议服装、配饰、鞋包、护肤等类目商品，需要快速提高宝贝转化率，优化宝贝晒图评价，精准控制进店人群。</p>
                <div class="infoTable" :class="{'hide': !goodWord.imgGood}">
                  <table>
                    <tr>
                      <td style="width:118px;" class="tableTitle">设置执行人数：</td>
                      <td style="width:110px;"><el-input v-model="goodWord.imgGoodNum" placeholder="几人？" maxlength="10" size="mini" show-word-limit></el-input></td>
                      <td>人</td>
                    </tr>
                  </table>
                </div>
              </div>
            </div>
          </el-col>
        </el-row>
      </el-collapse-item>
      <el-collapse-item title="费用合计" name="costCount">
        <el-row>
          <el-col :span="24">
            <div class="grid-content bg-purple">
              <table class="costTable">
                <thead>
                  <tr>
                    <td style="width:110px;">分类</td>
                    <td style="width:500px;">费用明细</td>
                    <td style="width:300px;">小计</td>
                    <td>合计</td>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td>系统默认</td>
                    <td>精准投放：20金豆</td>
                    <td>20金豆</td>
                    <td>20金豆</td>
                  </tr>
                </tbody>
                <tfoot>
                  <tr>
                    <td colspan="3"></td>
                    <td colspan="1">费用合计：20金豆</td>
                  </tr>
                </tfoot>
              </table>
            </div>
          </el-col>
        </el-row>
      </el-collapse-item>
    </el-collapse>
    <llTaskModel :next="5" :prev="3"></llTaskModel>
  </div>
</template>

<script>
import { mapState } from 'vuex'
import TaskModel from '../TaskModel'

export default {
  name: 'FlowPath4',
  data () {
    return {
      taskAll: ['defaultServe', 'upPositive', 'adsense', 'safe', 'intoControl', 'labelObj', 'market', 'costCount'],
      showList: {},
      taskType : '',
      addServe: {
        sydbj: true,
        yjfh: true,
        xtcj: true
      },
      upPositive: {
        uphfd: true,
        jdjl: false,
        people: "",
        gold: "",
        hpgjz: true,
      },
      adsense: {
        ggwtf: true,
      },
      goodWord: {
        isGoodWord: true,
        imgGood: true,
        txtGood: true,
        imgGoodNum: '',
        txtGoodNum: '',
        star: true,
        starNum: '',
        wordVal: [
          {name: '123', num: 0},
          {name: '', num: ''}
        ],
      },
      safe: {
        safeDay: "1",
        isWord: true,
        isMessage: true
      },
      intoControl: {
        isShowProblem: true,
        problem: '',
        answer: '',
        isHours: true
      },
      labelObj: {
        isLabel: true,
        sex: '1',
        sexNum: '',
        ageNum: '',
        age18: true,
        age26: true,
        age37: true,
        age51: true
      }
    }
  },
  components: {
    "llTaskModel": TaskModel,
  },
  mounted(){
    this.taskType = this.$store.state.taskType
    if(this.$store.state.taskType == "1"){
      this.showList
    }
  },
  methods: {
    addLine(){
      if(this.goodWord.wordVal.length < 6){
        this.goodWord.wordVal.push({name: "", num: ""})
      }else{
        alert("最多只能添加六个关键词")
      }
    },
    removeLine(ele){
      if(this.goodWord.wordVal.length > 1){
        this.goodWord.wordVal.splice($(ele.target).attr("data-wordNum"), 1)
      }else{
        alert("至少设置一个关键词")
      }
    }
  }
}
</script>

<style scoped>
.grid-content{
  padding: 15px;
  cursor: pointer;
  border: 1px solid var(--on-color);
}
.title{
  cursor: pointer;
}
.infoFrm{
  padding: 15px 0 0;
}
.point{
  font-size: 12px;
  color: var(--off-color);
  padding-bottom: 10px;
}
.pointTitle{
  color: var(--on-color);
  padding-bottom: 10px;
}
.infoTable{
  transition: all 0.3s linear;
  overflow: hidden;
  padding: 0 15px;
}
.infoTable.hide{
  height: 0;
}
.infoTable table{
  width: 100%;
}
.infoTable td{
  padding-right: 15px;
  padding-top: 15px;
}
.subFrm .infoFrm{
  padding: 0 0 15px;
}
.tableTitle{
  text-align: right;
}
.inputBtn{
  font-size: 20px;
  margin-left: 15px;
  cursor: pointer;
}
.radioItem{
  display: inline-block;
  margin-right: 15px;
}
.radioItem:not(:first-child){
  margin-right: 15px;
}
.el-input--mini{
  display: inline-block;
}
.costTable{
  width: 100%;
  border-collapse: collapse;
}
.costTable thead td{
  padding-bottom: 15px;
}
.costTable tfoot td{
  color: var(--on-color);
}
.costTable tbody td, .costTable tfoot td{
  padding: 15px 0;
}
.costTable thead td, .costTable tfoot td{
  font-size: 15px;
  font-weight: bold;
}
.costTable thead td, .costTable tbody td{
  border-bottom: 1px solid var(--off-color);
}
#path4 >>>.el-radio{
  padding: 0;
}
</style>
