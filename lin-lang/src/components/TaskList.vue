<template>
    <div id="taskList">
        <div class="nav_center">
            <el-menu :default-active="defaultActive" class="el-menu-demo" mode="horizontal" @select="handleSelect">
                <el-menu-item v-for="(item, index) in navTabList" :key="index" :index="String(index+1)" onselectstart="return false">{{ item }}</el-menu-item>
            </el-menu>
            <div class="filterFrm">
                <div class="filterItem">
                    <label>平台：</label>
                    <el-select v-model="platformVal" placeholder="请选择">
                        <el-option label="所有平台" value="0"></el-option>
                        <el-option label="淘宝" value="1"></el-option>
                        <el-option label="天猫" value="2"></el-option>
                        <el-option label="京东" value="3"></el-option>
                    </el-select>
                </div>
                <div class="filterItem">
                    <label>店铺：</label>
                    <el-select v-model="storeVal" placeholder="请选择">
                        <el-option v-for="(item, key) in storeList" :key="key" :label="item" :value="String(key + 1)"></el-option>
                    </el-select>
                </div>
                <div class="filterItem">
                    <label>任务类型：</label>
                    <el-select v-model="taskType" placeholder="请选择">
                        <el-option label="所有类型" value="0"></el-option>
                        <el-option label="折扣商品" value="1"></el-option>
                        <el-option label="赛马任务" value="2"></el-option>
                    </el-select>
                </div>
                <div class="filterItem clearfix">
                    <el-input v-model="filterInfo" placeholder="请输入任务编号、商品名称或关键词"></el-input>
                    <el-button type="success">查询</el-button>
                </div>
            </div>
            <div class="tableFrm">
                <table>
                    <thead>
                        <tr>
                            <td style="width:360px;">商品信息</td>
                            <td style="width: 250px;">任务信息</td>
                            <td>数量信息</td>
                            <td>代办事项</td>
                            <td>任务状态</td>
                            <td style="width: 140px;">操作</td>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>
                                <div class="iBlock imgFrm">
                                    <img src="../assets/goodsImg.jpg">
                                </div>
                                <div class="iBlock">
                                    <div class="shopName">
                                        <img src="../assets/tb_small.png">
                                        <span >MIKU521</span>
                                    </div>
                                    <p class="shopTitle">商品标题1介绍及详情等等商品标题1介绍及详情等等商品标题1介绍及详情等等</p>
                                    <span class="shopPrice">23元</span>
                                </div>
                            </td>
                            <td>
                                <p class="tdLine">任务类型：折扣商品</p>
                                <p class="tdLine">任务编号：lsaidfjwlefjwoief1233</p>
                                <p class="tdLine">投放时间：2019-12-12</p>
                            </td>
                            <td>
                                <p class="tdLine">投放数量：20</p>
                                <p class="tdLine">申请人数：0</p>
                                <p class="tdLine">已下单：0</p>
                                <p class="tdLine">已完成：0</p>
                                <p class="tdLine">未完成：0</p>
                            </td>
                            <td>
                                <p class="tdLine">待审核订单金额：0</p>
                                <p class="tdLine">待审核好评：0</p>
                                <p class="tdLine">待审核好评截图：0</p>
                            </td>
                            <td class="tdCenter">
                                <el-tag>标签一</el-tag>
                            </td>
                            <td class="tdCenter">
                                <el-select v-model="operation" placeholder="操作" size="mini">
                                    <el-option label="继续投放" value="0"></el-option>
                                    <el-option label="删除任务" value="1"></el-option>
                                    <el-option label="投放加速" value="2"></el-option>
                                    <el-option label="立即付款" value="3"></el-option>
                                </el-select>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div class="iBlock imgFrm">
                                    <img src="../assets/goodsImg.jpg">
                                </div>
                                <div class="iBlock">
                                    <div class="shopName">
                                        <img src="../assets/tb_small.png">
                                        <span >MIKU521</span>
                                    </div>
                                    <p class="shopTitle">商品标题1介绍及详情等等商品标题1介绍及详情等等商品标题1介绍及详情等等</p>
                                    <span class="shopPrice">23元</span>
                                </div>
                            </td>
                            <td>
                                <p class="tdLine">任务类型：折扣商品</p>
                                <p class="tdLine">任务编号：lsaidfjwlefjwoief1233</p>
                                <p class="tdLine">投放时间：2019-12-12</p>
                            </td>
                            <td>
                                <p class="tdLine">投放数量：20</p>
                                <p class="tdLine">申请人数：0</p>
                                <p class="tdLine">已下单：0</p>
                                <p class="tdLine">已完成：0</p>
                                <p class="tdLine">未完成：0</p>
                            </td>
                            <td>
                                <p class="tdLine">待审核订单金额：0</p>
                                <p class="tdLine">待审核好评：0</p>
                                <p class="tdLine">待审核好评截图：0</p>
                            </td>
                            <td class="tdCenter">
                                <el-tag>标签一</el-tag>
                            </td>
                            <td class="tdCenter">
                                <el-select v-model="operation" placeholder="操作" size="mini">
                                    <el-option label="继续投放" value="0"></el-option>
                                    <el-option label="删除任务" value="1"></el-option>
                                    <el-option label="投放加速" value="2"></el-option>
                                    <el-option label="立即付款" value="3"></el-option>
                                </el-select>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <div class="pageInation">
                <el-pagination background layout="prev, pager, next" :total="1000" :page-size="50" @current-change="handleCurrentChange"></el-pagination>
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
        taskType: '0',
        filterInfo: '',
        tableData: [],
        operation: '1',
    }
  },
  methods: {
      handleSelect: function(val){
          console.log(val);
      },
      sendTask(index, rows) {
        rows.splice(index, 1);
      },
      handleCurrentChange(val){
          console.log("当前给后台的页数：" + val);
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
    padding: 25px 0;
    text-align: left;
}
.filterFrm .el-select{
    margin-right: 25px;
}
.filterItem{
    display: inline-block;
    vertical-align: top;
}
.filterItem .el-button{
    margin-top: 15px;
    float: right;
}
.tableFrm table{
    width: 100%;
    text-align: left;
    border-collapse: collapse;
}
.tableFrm td{
    padding: 15px;
}
.tableFrm thead td{
    font-size: 15px;
    font-weight: bold;
    color: var(--on-color);
    text-align: center;
}
.tableFrm td{
    border: 1px solid #e6e6e6;
}
.tdLine{
    padding: 10px;
}
.tdCenter{
    text-align: center;
}
.tdCenter .el-select{
    width: 100%;
}
.iBlock{
    display: inline-block;
    vertical-align: middle;
}
.imgFrm{
    height: 150px;
    width: 100px;
    overflow: hidden;
    margin-right: 10px;
}
.shopName{
    margin-bottom: 15px;
}
.shopName img, .shopName span{
    vertical-align: middle;
}
.shopTitle{
    max-width: 215px;
    text-overflow: -o-ellipsis-lastline;
    overflow: hidden;
    text-overflow: ellipsis;
    display: -webkit-box;
    -webkit-line-clamp: 2;
    -webkit-box-orient: vertical;
    margin-bottom: 15px;
    font-size: 15px;
}
.shopPrice{
    color: var(--on-color);
    font-size: 16px;
    font-weight: bold;
}
.pageInation{
    text-align: right;
    margin-top: 25px;
}
</style>
