<template>
  <div id="setGoodsInfo">
    <table>
      <tr>
        <td class="title" style="width:240px;">商品名称：</td>
        <td style="width:260px;">
          <el-input v-model="name" maxlength="12" placeholder="请输入商品名称" show-word-limit></el-input>
          <!-- https://mobile.yangkeduo.com/goods.html?goods_id=2784921172&_x_link_id=5ef64ed0-405e-4f9c-a486-efe1d4612e31&refer_share_uid=6941554729&share_uin=LBA2FSYC6OLWNWKVBWIB5ISB7M_GEXDA&page_from=39&_wv=41729&refer_share_channel=copy_link&refer_share_id=c51e06WsObu9jibuMqhftba4CjVOhecX&share_uid=6941554729&_wvx=10 -->
        </td>
        <td class="title" style="width:180px;">商品链接：</td>
        <td><el-input v-model="link" placeholder="请输入商品链接"></el-input></td>
      </tr>
      <tr>
        <td class="title">商品分类：</td>
        <td>
          <el-select v-model="select" slot="prepend" placeholder="请选择商品分类">
            <el-option label="潮流女装" value="1"></el-option>
            <el-option label="时尚男装" value="2"></el-option>
            <el-option label="鞋子箱包" value="3"></el-option>
          </el-select>
        </td>
        <td class="title">平台展示图：</td>
        <td>
          <el-upload
            class="avatar-uploader"
            action="https://jsonplaceholder.typicode.com/posts/"
            :show-file-list="false"
            :on-success="handleAvatarSuccess"
            :before-upload="beforeAvatarUpload">
            <img v-if="imageUrl" :src="imageUrl" class="avatar">
            <i v-else class="el-icon-plus avatar-uploader-icon"></i>
          </el-upload>
        </td>
      </tr>
      <tr>
        <td class="title">试客每单拍：</td>
        <td><el-input v-model="num" placeholder="请输入每单拍的件数"></el-input></td>
        <td colspan="2" class="infoPoint">说明</td>
      </tr>
      <tr>
        <td class="title">商品价格：</td>
        <td>
          <el-input v-model="buyPrice" placeholder="请输入商品直接购买价格"></el-input>
        </td>
        <td colspan="2" class="infoPoint">说明</td>
      </tr>
      <tr>
        <td class="title">商品规格：</td>
        <td>
          <el-input type="textarea" autosize placeholder="任意规格（按试用价格下单）" v-model="textarea1"></el-input>
        </td>
        <td colspan="2" class="infoPoint">说明</td>
      </tr>
    </table>
  </div>
</template>

<script>
import { mapMutations } from 'vuex'

export default {
  name: 'SetGoodsInfo',
  data () {
    return {
      name: '',
      link: '',
      select: '',
      imageUrl: '',
      buyPrice: '',
      teamPrice: '',
      num: 1,
      textarea1: '',
      radio: ''
    }
  },
  mounted(){
    this.taskOk(2)
  },
  methods: {
    ...mapMutations(["taskOk"]),
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
.title{
  padding-right: 20px;
  text-align: right;
}
.point{
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
</style>
