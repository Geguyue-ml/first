<template>
  <div id="setGoodsInfo">
    <div class="goodsBtn"><el-button type="primary" @click="showGoods">从商品库中选择宝贝</el-button></div>
    <div class="modelBox">
      <div class="itemBox">
        <span class="title">商品名称：</span>
        <div class="lengthType short"><el-input v-model="name" maxlength="12" placeholder="请输入商品名称" show-word-limit></el-input></div>
      </div>
      <div class="itemBox">
        <span class="title" title="商品在平台展示的名称，不要和淘宝商品名称相同，防止用户通过淘宝商品名称购买">商品链接：</span>
        <div class="lengthType long"><el-input v-model="link" placeholder="商品在平台展示的名称，不要和淘宝商品名称相同，防止用户通过淘宝商品名称购买"></el-input></div>
      </div>
      <div class="itemBox">
        <span class="title">商品分类：</span>
        <div class="lengthType short">
          <el-select v-model="select" slot="prepend" placeholder="请选择商品分类">
            <el-option label="潮流女装" value="1"></el-option>
            <el-option label="时尚男装" value="2"></el-option>
            <el-option label="鞋子箱包" value="3"></el-option>
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
            :file-list="imageList">
            <el-button size="small" type="primary">点击上传</el-button>
            <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
          </el-upload>
        </div>
      </div>
      <div class="itemBox">
        <span class="title">商品价格：</span>
        <div class="lengthType short">
          <el-input v-model="buyPrice" placeholder="请输入商品直接购买价格"></el-input>
        </div>
      </div>
      <div class="itemBox">
        <span class="title">用户每单拍：</span>
        <div class="lengthType short"><el-input v-model="num" placeholder="请输入每单拍的件数"></el-input></div>
      </div>
      <div class="itemBox line">
        <span class="title">商品规格：</span>
        <div class="lengthType short">
          <el-input type="textarea" autosize placeholder="任意规格（按商品价格下单）" v-model="goodsSpecification"></el-input>
        </div>
        <span class="point">如需用户拍下指定规格，请务必填写具体规格;若有阶梯价商品，需要用户拍下任意规格，商品的价格请设置为阶梯价的最高价格，并填写不限规格；鞋子服装类商品，不可限制产品的尺码，如有疑问请联系在线客服</span>
      </div>
      <div class="itemBox" v-if="taskType == 'task2'">
        <span class="title">返给用户佣金：</span>
        <div class="lengthType short">
          <el-input v-model="giveGold" placeholder="佣金的价格不能低于商品价格的10%" size="mini"></el-input>
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
      taskType: '',
      name: '',
      link: '',
      select: '',
      imageList: [
        {name: 'food.jpeg', url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'}
      ],
      buyPrice: '',
      teamPrice: '',
      giveGold: '',
      num: 1,
      goodsSpecification: '',
      radio: ''
    }
  },
  mounted(){
    this.taskChange(2)
    this.taskType = this.$store.state.taskType
  },
  methods: {
    ...mapMutations(["taskChange"]),
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
