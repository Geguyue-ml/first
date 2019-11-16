<template>
  <div id="path2">
    <el-collapse :value="['1', '2', '3', '4']">
      <el-collapse-item title="1、填写商品信息及运费" name="1" class="pathTitle">
        <div class="modelBox">
          <div class="modelItem">
            <span>商品名称：</span>
            <div class="itemInput">
              <el-input v-model="form.name" maxlength="12" placeholder="请输入商品名称" show-word-limit></el-input>
              <!-- https://mobile.yangkeduo.com/goods.html?goods_id=2784921172&_x_link_id=5ef64ed0-405e-4f9c-a486-efe1d4612e31&refer_share_uid=6941554729&share_uin=LBA2FSYC6OLWNWKVBWIB5ISB7M_GEXDA&page_from=39&_wv=41729&refer_share_channel=copy_link&refer_share_id=c51e06WsObu9jibuMqhftba4CjVOhecX&share_uid=6941554729&_wvx=10 -->
            </div>
          </div>
          <div class="modelItem">
            <span>商品链接：</span>
            <div class="itemInput b">
              <el-input v-model="form.link" placeholder="请输入商品链接"></el-input>
            </div>
          </div>
          <div class="modelItem">
            <span>商品分类：</span>
            <div class="itemInput">
              <el-select v-model="form.select" slot="prepend" placeholder="请选择商品分类">
                <el-option label="潮流女装" value="1"></el-option>
                <el-option label="时尚男装" value="2"></el-option>
                <el-option label="鞋子箱包" value="3"></el-option>
              </el-select>
            </div>
          </div>
          <div class="modelItem">
            <span>平台展示图：</span>
            <div class="itemInput">
              <el-upload
                class="avatar-uploader"
                action="https://jsonplaceholder.typicode.com/posts/"
                :show-file-list="false"
                :on-success="handleAvatarSuccess"
                :before-upload="beforeAvatarUpload">
                <img v-if="form.imageUrl" :src="form.imageUrl" class="avatar">
                <i v-else class="el-icon-plus avatar-uploader-icon"></i>
              </el-upload>
            </div>
          </div>
          <div class="modelItem">
            <span>商品价格（直接购买价）：</span>
            <div class="itemInput">
              <el-input v-model="form.buyPrice" placeholder="请输入商品直接购买价格"></el-input>
            </div>
          </div>
          <div class="modelItem">
            <span>商品价格（拼团价）：</span>
            <div class="itemInput">
              <el-input v-model="form.teamPrice" placeholder="请输入商品拼团购买价格"></el-input>
            </div>
          </div>
          <div class="modelItem">
            <span>试客每单拍（件）：</span>
            <div class="itemInput">
              <el-input v-model="form.num" placeholder="请输入每单拍的件数"></el-input>
            </div>
          </div>
          <div class="modelItem">
            <span>商品规格：</span>
            <div class="itemInput b">
              <el-input type="textarea" autosize placeholder="任意规格（按试用价格下单）" v-model="form.textarea1"></el-input>
            </div>
          </div>
          <div class="modelItem line">
            <span>选择付款方式：</span>
            <span class="point">允许试客使用花呗和信用卡支付，会使下单付款更加真实（产生的手续费由商家自行承担）</span>
            <div class="modelBox">
              <div class="modelItem">
                <span>是否允许试客使用花呗付款：</span>
                <div class="itemInput">
                  <el-radio v-model="form.radio" label="1">允许</el-radio>
                  <el-radio v-model="form.radio" label="2">不允许</el-radio>
                </div>
              </div>
              <div class="modelItem">
                <span>是否允许试客使用信用卡付款：</span>
                <div class="itemInput">
                  <el-radio v-model="form.radio" label="1">允许</el-radio>
                  <el-radio v-model="form.radio" label="2">不允许</el-radio>
                </div>
              </div>
              <div class="modelItem">
                <span>是否允许试客使用优惠券付款：</span>
                <div class="itemInput">
                  <el-radio v-model="form.radio" label="1">允许</el-radio>
                  <el-radio v-model="form.radio" label="2">不允许</el-radio>
                </div>
              </div>
            </div>
          </div>
        </div>
      </el-collapse-item>
      <el-collapse-item title="2、设置如何找到商品" name="2">
        
      </el-collapse-item>
      <el-collapse-item title="3、设置商品收取运费的方式" name="3">
        
      </el-collapse-item>
      <el-collapse-item title="4、任务联系方式" name="4">
        
      </el-collapse-item>
    </el-collapse>
    <div class="modelBox Btn">
      <div>
        <router-link class="npBtn prev" tag="div" :to="{name: 'flowPath1'}" @click.native="taskOk(1)"></router-link>
        <router-link class="npBtn next" tag="div" :to="{name: 'flowPath3'}" @click.native="taskOk(3)"></router-link>
      </div>
    </div>
  </div>
</template>

<script>
import { mapMutations } from 'vuex'

export default {
  name: 'FlowPath2',
  data(){
    return {
      form: {
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
.modelBox{
  display: flex;
  justify-content: flex-start;
  flex-direction: row;
  flex-wrap: wrap;
  align-items: center;
  padding: 25px 0;
  border-bottom: 1px solid #EBEEF5;
}
.modelBox.Btn{
  justify-content: center;
}
.modelItem{
  width: 50%;
  margin-bottom: 25px;
}
.modelItem.line{
  width: 100%;
}
#path2 >>>.el-input.is-focus .el-input__inner{
  border-color: var(--on-color);
}
#path2 >>>.el-input__inner:focus{
  border-color: var(--on-color);
}
#path2 >>>.el-textarea__inner:focus{
  border-color: var(--on-color);
}
.el-select-dropdown__item.selected{
  color: var(--on-color);
}
#path2 >>>.el-select{
  min-width: 250px;
}
.itemInput{
  display: inline-block;
  vertical-align: middle;
}
.itemInput.b{
  min-width: 450px;
}
#path2 >>>.avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
}
#path2 >>>.avatar-uploader .el-upload:hover {
  border-color: var(--on-color);
}
#path2 >>>.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 98px;
  height: 98px;
  line-height: 98px;
  text-align: center;
}
#path2 >>>.avatar {
  width: 98px;
  height: 98px;
  display: block;
}
.point{
  color: var(--off-color);
}
</style>
