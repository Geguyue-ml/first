<template>
    <div id="taskList">
        <div class="nav_center">
            <el-menu :default-active="defaultActive" class="el-menu-demo" mode="horizontal" @select="handleSelect">
                <el-menu-item v-for="(item, index) in navTabList" :key="index" :index="String(index+1)" onselectstart="return false">{{ item }}</el-menu-item>
            </el-menu>
            <div class="filterFrm">
                <label>平台：</label>
                <el-select v-model="platformVal" placeholder="请选择">
                    <el-option label="所有平台" value="0"></el-option>
                    <el-option label="淘宝" value="1"></el-option>
                    <el-option label="天猫" value="2"></el-option>
                    <el-option label="京东" value="3"></el-option>
                </el-select>
                 <label>店铺：</label>
                <el-select v-model="storeVal" placeholder="请选择">
                    <el-option v-for="(item, key) in storeList" :key="key" :label="item" :value="String(key + 1)"></el-option>
                </el-select>
                <label>任务类型：</label>
                <el-select v-model="taskType" placeholder="请选择">
                    <el-option label="所有类型" value="0"></el-option>
                    <el-option label="免费试用" value="1"></el-option>
                    <el-option label="折扣试用" value="2"></el-option>
                    <el-option label="赛马任务" value="3"></el-option>
                </el-select>
            </div>
        </div>
    </div>
</template>

<script>
export default {
  name: 'TaskList',
  data () {
    return {
        defaultActive: '1',
        navTabList: ['全部', '待支付/提交', '待审核', '审核驳回', '进行中', '即将结束', '已完成', '已结算', '暂停中'],
        platformVal: '0',
        storeVal: '1',
        storeList: ['所有店铺', '店铺B', '店铺C', '店铺D', '店铺E', '店铺F', '店铺G', '店铺H', '店铺I'],
        taskType: '0'
    }
  },
  methods: {
      handleSelect: function(val){
          console.log(val);
      }
  }
}
</script>

<style scoped>
#taskList{
    text-align: center;
}
.el-menu.el-menu--horizontal{
    border-bottom: 0;
}
.el-menu-demo{
    display: inline-block;
    margin-top: 25px;
}
.el-menu--horizontal>.el-menu-item.is-active, .el-menu-item.is-active{
    border-bottom: 2px solid var(--on-color);
}
.filterFrm{
    margin-top: 25px;
    padding: 25px;
    text-align: left;
}
.el-select{
    margin-right: 25px;
}
</style>
