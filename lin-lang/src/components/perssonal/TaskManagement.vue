<template>
    <el-col :span="20" id="taskManagement">
        <div class="grid-content bg-purple-light">
            <div class="title">试用任务进展</div>
            <div class="taskNav">
                <div class="item" v-for="(item, key) in navList" :key="key" @click="activeTab($event)">
                  <span>{{ item.name }}</span>
                  <span class="point"></span>
                </div>
            </div>
            <div class="taskQuery">
              <el-form :inline="true" class="demo-form-inline taskQueryFrm">
                <el-form-item label="商品关键词">
                  <el-input placeholder="商品关键词"></el-input>
                </el-form-item>
                <el-form-item label="任务类型">
                  <el-select placeholder="任务类型">
                    <el-option label="全部" value=""></el-option>
                    <el-option label="类型1" value="first"></el-option>
                    <el-option label="类型2" value="second"></el-option>
                  </el-select>
                </el-form-item>
                <el-form-item label="平台">
                  <el-select placeholder="平台">
                    <el-option label="全部" value=""></el-option>
                    <el-option label="淘宝" value="tb"></el-option>
                    <el-option label="天猫" value="tm"></el-option>
                    <el-option label="京东" value="jd"></el-option>
                  </el-select>
                </el-form-item>
                <el-form-item label="店铺">
                  <el-select placeholder="店铺">
                    <el-option label="全部" value=""></el-option>
                    <el-option label="机车" value="jc"></el-option>
                    <el-option label="神级" value="sj"></el-option>
                    <el-option label="品凡" value="pf"></el-option>
                  </el-select>
                </el-form-item>
                <el-form-item>
                  <el-button type="primary" @click="onSubmit">查询</el-button>
                </el-form-item>
              </el-form>
            </div>
            <div class="taskBody">
              这里是个table，然后请求数据
            </div>
        </div>
    </el-col>
</template>

<script>
export default {
  name: 'TaskManagement',
  data () {
    return {
      onColor: "#ff366f",
      activeIndex: '1',
      navList: [
        {path: "/personal/taskManagement", name: "所有任务", value: 18},
        {path: "/personal/taskManagement", name: "待审核的任务", value: 23},
        {path: "/personal/taskManagement", name: "进行中的任务", value: 3},
        {path: "/personal/taskManagement", name: "已完成的任务", value: 6},
        {path: "/personal/taskManagement", name: "暂停的任务", value: 12},
        {path: "/personal/taskManagement", name: "未支付的任务", value: 0},
        {path: "/personal/taskManagement", name: "删除的任务", value: 12}
      ]
    }
  },
  watch: {
    $route(){
      this.handleSelect(this.activeIndex)
    }
  },
  mounted(){
    this.activeIndex = this.$route.matched[0].path || '/'
  },
  methods: {
    handleSelect(index){
      this.activeIndex = index
    },
    activeTab(event){
      for(let item of document.getElementsByClassName("item")){
        item.classList.remove("active");
      }
      event.currentTarget.classList.add("active")
    },
    onSubmit() {
      console.log('submit!');
    }
  }
}
</script>

<style scoped>
.taskNav{
  padding: 15px 0;
  display: flex;
  justify-content: space-around;
  flex-direction: row;
  flex-wrap: nowrap;
}
.item{
  position: relative;
  padding: 15px 20px;
  cursor: pointer;
  transition:background-color 0.3s linear;
  -moz-transition: background-color 0.3s linear;
  -webkit-transition:background-color 0.3s linear;
  -o-transition:background-color 0.3s linear;
}
.item:hover{
  background: rgb(204, 204, 204);
}
.item.active{
  border-bottom: 2px solid var(--on-color);
}
.item .point{
  height: 8px;
  width: 8px;
  position: absolute;
  background: var(--on-color);
  border-radius: 8px;
  top: 8px;
  right: 14px;
}
.taskQuery{
  padding: 15px 0;
  border-top: 1px solid #e6e6e6;
  border-bottom: 1px solid #e6e6e6;
}
.taskQueryFrm{
  display: flex;
  justify-content: space-between;
  flex-direction: row;
  flex-wrap: wrap;
}
.taskQueryFrm .el-form-item{
  margin-right: 0;
}
.taskQueryFrm .el-button--primary{
  background-color: var(--on-color);
  border-color: var(--on-color);
}
</style>
