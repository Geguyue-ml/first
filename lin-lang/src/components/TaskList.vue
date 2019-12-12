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
                        <el-option label="免费试用" value="1"></el-option>
                        <el-option label="折扣试用" value="2"></el-option>
                        <el-option label="赛马任务" value="3"></el-option>
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
                            <td style="width:320px;">商品信息</td>
                            <td>任务信息</td>
                            <td>数量信息</td>
                            <td>代办事项</td>
                            <td>任务状态</td>
                            <td>操作</td>
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
                                <p>任务类型：折扣试用</p>
                                <p>任务编号：lsaidfjwlefjwoief1233</p>
                                <p>投放时间：2019-12-12</p>
                            </td>
                            <td>
                                <p>投放数量：20</p>
                                <p>申请人数：0</p>
                                <p>已下单：0</p>
                                <p>已完成：0</p>
                                <p>未完成：0</p>
                            </td>
                            <td>
                                <p>待审核订单金额：0</p>
                                <p>待审核好评：0</p>
                                <p>待审核好评截图：0</p>
                            </td>
                            <td>
                                <el-tag>标签一</el-tag>
                            </td>
                            <td>
                                <el-popover
                                    placement="bottom"
                                    title="标题"
                                    width="200"
                                    trigger="click"
                                    content="这是一段内容,这是一段内容,这是一段内容,这是一段内容。">
                                    <el-button slot="reference"><i class="el-icon-s-grid"></i>操作</el-button>
                                </el-popover>
                            </td>
                        </tr>
                    </tbody>
                </table>
                <!-- <el-table :data="tableData" style="width: 100%">
                    <el-table-column fixed prop="orderImg" label="商品主图" width="150"></el-table-column>
                    <el-table-column prop="shop" label="投放店铺" width="120"></el-table-column>
                    <el-table-column prop="price" label="商品价格" width="120"></el-table-column>
                    <el-table-column prop="pushNum" label="投放数量" width="120"></el-table-column>
                    <el-table-column prop="applyPerson" label="申请人数" width="300"></el-table-column>
                    <el-table-column prop="pushOrder" label="已下单" width="120"></el-table-column>
                    <el-table-column prop="success" label="已完成" width="120"></el-table-column>
                    <el-table-column prop="unSuccess" label="未完成" width="120"></el-table-column>
                    <el-table-column prop="orderAmount" label="待审核订单金额" width="120"></el-table-column>
                    <el-table-column prop="orderGood" label="待审核好评" width="120"></el-table-column>
                    <el-table-column prop="orderImg" label="待审核好评截图" width="120"></el-table-column>
                    <el-table-column prop="orderState" label="状态" width="120"></el-table-column>
                    <el-table-column fixed="right" label="操作" width="120">
                        <template slot-scope="scope">
                            <el-button @click.native.prevent="sendTask(scope.$index, tableData)" type="text" size="small"> 发布任务 </el-button>
                        </template>
                    </el-table-column>
                </el-table> -->
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
        tableData: [
            {orderImg: '#', shop: '淘宝', price: '12', pushNum: '12', applyPerson: '2', pushOrder: 1, success: 12, unSuccess: 2, orderAmount: '21.6', orderGood: 2, orderImg: 1, orderState: 1}, 
            {orderImg: '#', shop: '京东', price: '23', pushNum: '23', applyPerson: '4', pushOrder: 1, success: 7, unSuccess: 4, orderAmount: '21.6', orderGood: 2, orderImg: 1, orderState: 1}, 
            {orderImg: '#', shop: '天猫', price: '65', pushNum: '34', applyPerson: '5', pushOrder: 22, success: 9, unSuccess: 2, orderAmount: '21.6', orderGood: 2, orderImg: 1, orderState: 1}, 
            {orderImg: '#', shop: '天猫', price: '45', pushNum: '43', applyPerson: '8', pushOrder: 13, success: 14, unSuccess: 6, orderAmount: '21.6', orderGood: 2, orderImg: 1, orderState: 1}, 
            {orderImg: '#', shop: '天猫', price: '132', pushNum: '45', applyPerson: '1', pushOrder: 7, success: 13, unSuccess: 2, orderAmount: '21.6', orderGood: 2, orderImg: 1, orderState: 1}, 
            {orderImg: '#', shop: '京东', price: '4586', pushNum: '6', applyPerson: '5', pushOrder: 3, success: 4, unSuccess: 1, orderAmount: '21.6', orderGood: 2, orderImg: 1, orderState: 1}, 
            {orderImg: '#', shop: '淘宝', price: '5', pushNum: '19', applyPerson: '7', pushOrder: 8, success: 2, unSuccess: 0, orderAmount: '21.6', orderGood: 2, orderImg: 1, orderState: 1}
        ]
    }
  },
  methods: {
      handleSelect: function(val){
          console.log(val);
      },
      sendTask(index, rows) {
        rows.splice(index, 1);
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
.el-select{
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
    padding: 15px 0;
}
.tableFrm thead td{
    font-size: 15px;
    font-weight: bold;
    color: #999;
    text-align: center;
}
.tableFrm tbody td{
    border-bottom: 1px solid #e6e6e6;
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
    max-width: 200px;
    text-overflow: -o-ellipsis-lastline;
    overflow: hidden;
    text-overflow: ellipsis;
    display: -webkit-box;
    -webkit-line-clamp: 2;
    -webkit-box-orient: vertical;
    margin-bottom: 15px;
    color: #000;
    font-size: 15px;
}
.shopPrice{
    color: var(--on-color);
    font-size: 16px;
    font-weight: bold;
}
</style>
