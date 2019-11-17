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
        <td class="title">商品价格<span class="point">（直接购买价）</span>：</td>
        <td>
          <el-input v-model="buyPrice" placeholder="请输入商品直接购买价格"></el-input>
        </td>
        <td class="title">商品价格<span class="point">（拼团价）</span>：</td>
        <td>
          <el-input v-model="teamPrice" placeholder="请输入商品拼团购买价格"></el-input>
        </td>
      </tr>
      <tr>
        <td class="title">试客每单拍<span class="point">（件）</span>：</td>
        <td>
          <el-input v-model="num" placeholder="请输入每单拍的件数"></el-input>
        </td>
        <td class="title">商品规格：</td>
        <td>
          <el-input type="textarea" autosize placeholder="任意规格（按试用价格下单）" v-model="textarea1"></el-input>
        </td>
      </tr>
      <tr>
        <td colspan="4">选择付款方式<span class="point">允许试客使用花呗和信用卡支付，会使下单付款更加真实（产生的手续费由商家自行承担）</span>：</td>
      </tr>
      <tr>
        <td colspan="4">
          <div class="modelBox">
            <div class="modelItem" :class="{'active': active1}" @click="active1 = !active1" onselectstart="{return false}">允许试客使用花呗付款</div>
            <div class="modelItem" :class="{'active': active2}" @click="active2 = !active2" onselectstart="{return false}">允许试客使用信用卡付款</div>
            <div class="modelItem" :class="{'active': active3}" @click="active3 = !active3" onselectstart="{return false}">允许试客使用优惠券付款</div>
          </div>
        </td>
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
      radio: '',
      active1: false,
      active2: false,
      active3: false
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
</style>
