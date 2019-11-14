<template>
  <div id="releaseTask" class="nav_center">
      <div class="releaseTitle">
        <span class="txt">发布任务流程</span>
        <div class="progressTask">
            <router-link class="subFrm show" tag="div" :to="{name: 'flowPath1'}">
                <div class="subFrmTitle lef">选平台</div>
                <div class="circleFrm">
                    <div class="subCircle">1</div>
                    <div class="subline r"></div>
                </div>
            </router-link>
            <router-link class="subFrm" tag="div" :to="{name: 'flowPath2'}">
                <div class="subFrmTitle cent">填写商品信息</div>
                <div class="circleFrm">
                    <div class="subline l"></div>
                    <div class="subCircle">2</div>
                    <div class="subline r"></div>
                </div>
            </router-link>
            <router-link class="subFrm" tag="div" :to="{name: 'flowPath3'}">
                <div class="subFrmTitle cent">设置投放计划</div>
                <div class="circleFrm">
                    <div class="subline l"></div>
                    <div class="subCircle">3</div>
                    <div class="subline r"></div>
                </div>
            </router-link>
            <router-link class="subFrm" tag="div" :to="{name: 'flowPath4'}">
                <div class="subFrmTitle cent">增值服务</div>
                <div class="circleFrm">
                    <div class="subline l"></div>
                    <div class="subCircle">4</div>
                    <div class="subline r"></div>
                </div>
            </router-link>
            <router-link class="subFrm" tag="div" :to="{name: 'flowPath5'}">
                <div class="subFrmTitle cent">支付</div>
                <div class="circleFrm">
                    <div class="subline l"></div>
                    <div class="subCircle">5</div>
                    <div class="subline r"></div>
                </div>
            </router-link>
            <router-link class="subFrm" tag="div" :to="{name: 'flowPath6'}">
                <div class="subFrmTitle rig">发布成功</div>
                <div class="circleFrm">
                    <div class="subline l"></div>
                    <div class="subCircle">6</div>
                </div>
            </router-link>
        </div>
      </div>
      <div class="releaseBody">
          <router-view></router-view>
      </div>
  </div>
</template>

<script>
export default {
  name: 'ReleaseTask',
  data () {
    return {
      
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
.releaseBody >>>.el-collapse-item__header{
    font-size: 16px;
    font-weight: bold;
}
</style>