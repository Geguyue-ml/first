<template>
  <div id="setGoodsInfo">
    <div class="goodsBtn"><el-button type="primary" @click="showGoods">从商品库中选择宝贝</el-button></div>
    <div class="modelBox">
      <div class="itemBox">
        <span class="title">商品名称：</span>
        <div class="lengthType short"><el-input v-model="param.name" maxlength="12" placeholder="请输入商品名称" show-word-limit></el-input></div>
      </div>
      <div class="itemBox">
        <span class="title" title="商品在平台展示的名称，不要和淘宝商品名称相同，防止用户通过淘宝商品名称购买">商品链接：</span>
        <div class="lengthType long"><el-input v-model="param.link" placeholder="商品在平台展示的名称，不要和淘宝商品名称相同，防止用户通过淘宝商品名称购买"></el-input></div>
      </div>
      <div class="itemBox">
        <span class="title">商品分类：</span>
        <div class="lengthType short">
          <el-select v-model="param.proProductCategoryId" slot="prepend" placeholder="请选择商品分类">
            <el-option v-for="(item, index) in goodsTypeList" :key="index" :label="item.fullName" :value="index + 1"></el-option>
          </el-select>
        </div>
      </div>
      <div class="itemBox">
        <span class="title">平台展示图：</span>
        <div class="lengthType long">
          <el-upload
            class="upload-demo"
            action="https://jsonplaceholder.typicode.com/posts/"
            :before-remove="beforeRemove"
            multiple
            :limit="1"
            :file-list="platformImage">
            <el-button size="small" type="primary">点击上传</el-button>
            <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
          </el-upload>
        </div>
      </div>
      <div class="itemBox">
        <span class="title">商品价格：</span>
        <div class="lengthType short">
          <el-input v-model="param.price" placeholder="请输入商品直接购买价格"></el-input>
        </div>
      </div>
      <div class="itemBox">
        <span class="title">用户每单拍：</span>
        <div class="lengthType short"><el-input v-model="param.limitNumber" placeholder="请输入每单拍的件数"></el-input></div>
      </div>
      <div class="itemBox line">
        <span class="title">商品规格：</span>
        <div class="lengthType short">
          <el-input type="textarea" autosize placeholder="任意规格（按商品价格下单）" v-model="param.specValue"></el-input>
        </div>
        <span class="point">如需用户拍下指定规格，请务必填写具体规格;若有阶梯价商品，需要用户拍下任意规格，商品的价格请设置为阶梯价的最高价格，并填写不限规格；鞋子服装类商品，不可限制产品的尺码，如有疑问请联系在线客服</span>
      </div>
      <div class="itemBox" v-if="taskType == '1'">
        <span class="title">返给用户佣金：</span>
        <div class="lengthType short">
          <el-input v-model="param.giveGold" placeholder="佣金的价格不能低于商品价格的10%"></el-input>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapMutations } from 'vuex'

export default {
  name: 'SetGoodsInfo',
  data () {
    return {
      taskType: null,
      goodsTypeList: null,
      teamPrice: null,
      radio: null,
      platformImage: [
        {name: 'food.jpeg', url: 'http://img/01.jpg'}
      ],
      param: {
        name: null,                   //商品名称
        link: null,                   //商品链接
        proProductCategoryId: null,   //商品分类
        platformImage: null,          //平台展示图
        price: null,                  //商品价格
        limitNumber: 1,               //每单拍的件数
        specValue: null,              //商品规格
        giveGold: null,               //返佣金
      }
    }
  },
  mounted(){
    this.taskChange(2)
    this.taskType = this.$store.state.taskType
    this.getGoodsType()
    this.param.platformImage = this.platformImage[0].url
  },
  methods: {
    ...mapMutations(["taskChange"]),

    //获取商品分类字段的选择信息
    getGoodsType(){
      this.$api.flowPath.getGoodsType()
      .then(res => {
        this.goodsTypeList = res.data.data
      })
    },
    handleAvatarSuccess(res, file) {
      this.imageUrl = URL.createObjectURL(file.raw);
    },
    beforeAvatarUpload(file) {
      const isJPG = file.type === 'image/jpeg';
      const isLt2M = file.size / 1024 / 1024 < 2;

      if (!isJPG) {
        this.$message.error('上传头像图片只能是 JPG 格式!');
      }
      return isJPG && isLt2M;
    },
    showGoods(){
      console.log("123")
    },
    beforeRemove(file, fileList) {
      return this.$confirm(`确定移除 ${ file.name }？`);
    }
  },
  watch: {
    param: {
      handler(newVal){
        this.$parent.$parent.$parent.setGoodsParam = newVal
      },
      immediate: true,
      deep: true
    }
  }
}
</script>

<style scoped>
#setGoodsInfo table{
  width: 100%;
}
#setGoodsInfo td{
  padding-top: 15px;
  padding-bottom: 15px;
}
#setGoodsInfo .modelBox{
  padding-top: 0;
}
.goodsBtn{
  padding: 25px 0;
}
.itemBox{
  width: 50%;
  margin: 10px 0;
}
.itemBox.line{
  width: 100%;
}
.lengthType{
  display: inline-block;
  vertical-align: middle;
}
.lengthType.short{
  width: 40%;
}
.lengthType.long{
  width: 80%;
}
.lengthType.center{
  width: 60%;
}
.el-upload__tip{
  display: inline-block;
  margin-left: 15px;
  color: var(--off-color);
}
.el-button--primary{
  background-color: var(--on-color);
  border-color: var(--on-color);
}
.title{
  vertical-align: middle;
}
.point{
  padding-left: 15px;
  display: inline-block;
  vertical-align: middle;
  width: 50%;
  color: var(--off-color);
}
.modelItem{
  padding: 15px 20px;
  border-radius: 5px;
  border: 1px solid var(--on-color);
  cursor: pointer;
}
.modelItem.active{
  background-color: var(--on-color);
  color: #fff;
}
.infoPoint{
  padding-left: 15px;
  color: var(--off-color);
}
#setGoodsInfo >>>.modelBox{
  justify-content: flex-start;
}
</style>
