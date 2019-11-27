<template>
  <div id="releaseTask" class="nav_center">
      <div class="releaseTitle">
        <span class="txt">发布任务流程</span>
        <div class="progressTask">
            <div class="subFrm show">
                <div class="subFrmTitle lef">选平台</div>
                <div class="circleFrm">
                    <div class="subCircle" onselectstart="return false">1</div>
                    <div class="subline r"></div>
                </div>
            </div>
            <div class="subFrm">
                <div class="subFrmTitle cent">填写商品信息</div>
                <div class="circleFrm">
                    <div class="subline l"></div>
                    <div class="subCircle" onselectstart="return false">2</div>
                    <div class="subline r"></div>
                </div>
            </div>
            <div class="subFrm">
                <div class="subFrmTitle cent">设置投放计划</div>
                <div class="circleFrm">
                    <div class="subline l"></div>
                    <div class="subCircle" onselectstart="return false">3</div>
                    <div class="subline r"></div>
                </div>
            </div>
            <div class="subFrm">
                <div class="subFrmTitle cent">增值服务</div>
                <div class="circleFrm">
                    <div class="subline l"></div>
                    <div class="subCircle" onselectstart="return false">4</div>
                    <div class="subline r"></div>
                </div>
            </div>
            <div class="subFrm">
                <div class="subFrmTitle rig">支付</div>
                <div class="circleFrm">
                    <div class="subline l"></div>
                    <div class="subCircle" onselectstart="return false">5</div>
                </div>
            </div>
        </div>
      </div>
      <div class="releaseBody">
          <router-view @showTask="showAlert"></router-view>
      </div>

    <!-- 支付提示弹框 -->
    <el-dialog title="支付结果" :visible.sync="dialogVisible" width="30%">
        <span class="payMessage">{{ message }}</span>
        <span slot="footer" class="dialog-footer">
            <el-button @click="oncePay">重新选择支付方式</el-button>
            <el-button type="primary" @click="showTaskInfo">查看任务详情</el-button>
        </span>
    </el-dialog>
  </div>
</template>

<script>
export default {
    name: 'ReleaseTask',
    data(){
        return {
            message: '支付成功，任务已发布等待客服审核',
            dialogVisible: false,
        }
    },
    watch: {
        "$store.state.taskVal": function(){
            this.addShow(this.$store.state.taskVal);
        }
    },
    methods: {
        addShow(num){
            for(let i = 0; i < num; i++){
                $(".subFrm").eq(i).addClass("show");
            }
        },
        oncePay(){
            console.log("跳转至支付页第五步");
        },
        showTaskInfo(){
            console.log("查看该任务详情");
        },
        showAlert(){
            this.dialogVisible = true;
        }
    }
}
</script>

<style scoped>
#releaseTask{
    margin-top: 30px;
}
.releaseTitle{
    padding-bottom: 30px;
    text-align: center;
}
.releaseTitle .txt{
    font-size: 20px;
    font-weight: bold;
    color: var(--on-color);
    vertical-align: middle;
}
.progressTask{
    display: inline-block;
    vertical-align: middle;
    margin-left: 58px;
    font-size: 0;
}
.subFrm{
    display: inline-block;
    vertical-align: middle;
    font-size: 14px;
    height: 100px;
    padding: 10px 0;
    cursor: pointer;
}
.subFrm.show{
    color: var(--on-color);
}
.subFrm.show .subCircle{
    color: #fff;
    background-color: var(--on-color);
}
.subFrm.show .subline{
    background-color: var(--on-color);
}
.circleFrm{
    margin-top: 20px;
    font-size: 0;
}
.subFrmTitle.lef{
    margin-left: -42px;
}
.subFrmTitle.cent{
    text-align: center;
}
.subFrmTitle.rig{
    margin-right: -38px;
}
.subCircle{
    display: inline-block;
    height: 35px;
    line-height: 35px;
    width: 35px;
    border:1px solid var(--on-color);
    color: var(--on-color);
    border-radius: 100%;
    text-align: center;
    vertical-align: middle;
    font-size: 14px;
}
.subline{
    position: relative;
    display: inline-block;
    height: 3px;
    width: 40px;
    background-color: #fff;
    vertical-align: middle;
    border-top: 1px solid var(--on-color);
    border-bottom: 1px solid var(--on-color);
}
.subline.l{
    margin-right: -0.8px;
}
.subline.r{
    margin-left: -0.6px;
}
.payMessage{
    font-size: 15px;
    font-weight: bold;
    color: var(--on-color);
    padding: 15px 0 15px 55px;
    background: url(../assets/check.png) no-repeat 0 center;
    background-size: 15%;
}
.releaseBody >>>.el-collapse-item__header{
    font-size: 16px;
    font-weight: bold;
}
#releaseTask >>>.modelBox{
  display: flex;
  justify-content: space-around;
  flex-direction: row;
  flex-wrap: wrap;
  align-items: center;
  padding-top: 25px;
}
#releaseTask >>>.modelBox.Btn{
  justify-content: center;
}

/**element-ui选中样式，统一修改 */
/**选中的input框 */
#releaseTask >>>.el-input.is-focus .el-input__inner{
  border-color: var(--on-color);
}
#releaseTask >>>.el-input__inner:focus{
  border-color: var(--on-color);
}
/**选中的textarea框 */
#releaseTask >>>.el-textarea__inner:focus{
  border-color: var(--on-color);
}
/**上传图片框 */
#releaseTask >>>.avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
}
#releaseTask >>>.avatar-uploader .el-upload:hover {
  border-color: var(--on-color);
}
#releaseTask >>>.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 98px;
  height: 98px;
  line-height: 98px;
  text-align: center;
}
#releaseTask >>>.avatar {
  width: 98px;
  height: 98px;
  display: block;
}
/**单选框样式 */
#releaseTask >>>.el-radio{
  margin-right: 0;
  width: 50%;
  text-align: center;
  padding: 15px 0;
}
/**padding: 15px 0;上面的选择器加入该行样式，在第四步：细化中将人群标签中乱了样式 */
#releaseTask >>>.is-checked .el-radio__inner {
  border-color: var(--on-color);
  background: var(--on-color);
}
#releaseTask >>>.is-checked .el-radio__label{
    color: var(--on-color);
}
/**复选框样式 */
#releaseTask >>>.el-checkbox__input.is-checked .el-checkbox__inner{
    background-color: var(--on-color);
    border-color: var(--on-color);
}
#releaseTask >>>.el-checkbox__input.is-checked+.el-checkbox__label{
    color: var(--on-color);
}
#releaseTask >>>.el-checkbox__input.is-focus .el-checkbox__inner{
    border-color: var(--on-color);
}
#releaseTask >>>.el-checkbox__inner:hover{
    border-color: var(--on-color);
}
/* #releaseTask >>>.el-checkbox__label{
    vertical-align: middle;
} 
flow4中，第一给checkbox，加了该属性，反而不对齐
*/
#releaseTask >>>.el-input-number__decrease:hover, #releaseTask >>>.el-input-number__increase:hover{
    color: var(--on-color);
}
#releaseTask >>>.el-input-number__decrease:hover:not(.is-disabled)~.el-input .el-input__inner:not(.is-disabled),
#releaseTask >>>.el-input-number__increase:hover:not(.is-disabled)~.el-input .el-input__inner:not(.is-disabled){
    border-color: var(--on-color);
}
</style>