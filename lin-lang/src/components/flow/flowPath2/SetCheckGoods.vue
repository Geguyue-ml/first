<template>
  <div id="setCheckGoods">
    <div class="modelFrm">
      <el-checkbox v-model="checkedMo" @change="isShow(checkedMo, '#Mo', MoH)">设置用户从手机淘宝App入店</el-checkbox>
      <div class="model" id="Mo">
        <table>
          <tr>
            <td class="title" style="width:150px;">淘宝APP商品主图：</td>
            <td colspan="3">
              <el-upload
                class="avatar-uploader"
                action="https://jsonplaceholder.typicode.com/posts/"
                :show-file-list="false"
                :on-success="handleAvatarSuccess"
                :before-upload="beforeAvatarUpload">
                <img v-if="param.productImage" :src="param.productImage" class="avatar">
                <i v-else class="el-icon-plus avatar-uploader-icon"></i>
              </el-upload>
              <span class="point">选择一张宝贝图片作为用户在拼多多APP搜索查看到宝贝主图（需要和拼多多搜索结果主图一致）</span>
            </td>
          </tr>
          <tr>
            <td class="title">设置关键词：</td>
            <td colspan="3" class="point">设置用户搜索关键词，用户将以该关键词完成搜索进店（搜索关键词进店量总数之和必须为100%）</td>
          </tr>
        </table>
        <div v-for="(item, key) in param.productKeywordsSearchs" :key="key" class="wordLine">
          <span class="title">关键词{{key + 1}}：</span>
          <div class="wordInput">
            <el-input v-model="param.productKeywordsSearchs[key].keyWords" placeholder="请输入商品关键词" maxlength="10" show-word-limit></el-input>
          </div>
          <div class="wordInput">
            <i class="el-icon-circle-plus-outline inputBtn" title="最多添加十个关键词" @click="addLine"></i>
            <i class="el-icon-remove-outline inputBtn" title="删除当前关键词" @click="removeLine($event)" :data-wordNum="key"></i>
          </div>
          <span class="setWordInfoBtn" onselectStart="{return false}" @click="showTable($event)">关键词高级设置</span>
          <div class="wordInfoFrm">
            <table>
              <tr>
                <td>排序方式：</td>
                <td colspan="2">
                  <el-select v-model="param.productKeywordsSearchs[key].sortOrder" slot="prepend" placeholder="请选择商品排序方式">
                    <el-option label="综合排序" value="1"></el-option>
                    <el-option label="人气从高到低" value="2"></el-option>
                    <el-option label="销量从高到低" value="3"></el-option>
                    <el-option label="信用从高到低" value="4"></el-option>
                    <el-option label="价格从高到低" value="5"></el-option>
                    <el-option label="价格从低到高" value="6"></el-option>
                    <el-option label="总价从低到高" value="7"></el-option>
                    <el-option label="总价从高到低" value="8"></el-option>
                  </el-select>
                </td>
                <td>价格区间：</td>
                <td>
                  <el-input placeholder="最低价格" v-model="param.productKeywordsSearchs[key].startPrice"></el-input>
                  <span>--</span>
                  <el-input placeholder="最高价格" v-model="param.productKeywordsSearchs[key].endPrice"></el-input>
                </td>
              </tr>
            </table>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'SetCheckGoods',
  data () {
    return {
      checkedMo: true,
      MoH: '',
      param: {
        productImage: "http://123.png",
        productKeywordsSearchs: [
          {keyWords: null, sortOrder: "2", startPrice: 56, endPrice:77}
        ] 
      }
    }
  },
  mounted(){
    this.MoH = $('#Mo').height();
    this.isShow(this.checkedMo, '#Mo', this.MoH);
  },
  methods: {
    isShow(val, ele, height){
      if(val == true){
        $(ele).css("height", height)
        setTimeout(function(){
          $(ele).css("height", "auto")
        }, 300)
      }else{
        $(ele).css("height", $(ele).height());
        setTimeout(function(){
          $(ele).css("height", "0");
        }, 1)
      }
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
    addLine(){
      if(this.productKeywordsSearchs.length < 10){
        this.productKeywordsSearchs.push({word: '', sort: "1", start: '', end:''})
      }else{
        alert("最多只能添加十个关键词")
      }
    },
    removeLine(ele){
      if(this.productKeywordsSearchs.length > 1){
        this.productKeywordsSearchs.splice($(ele.target).attr("data-wordNum"), 1)
      }else{
        alert("至少设置一个关键词")
      }
    },
    showTable(ele){
      let targetEle = ele.target.parentElement.querySelector(".wordInfoFrm")
    }
  },
  watch: {
    param: {
      handler(newVal){
        this.$parent.$parent.$parent.findGoodsParam = newVal
      },
      immediate: true,
      deep: true
    }
  }
}
</script>

<style scoped>
.model{
  width: 100%;
  transition: all 0.2s linear;
  -moz-transition: all 0.2s linear;
  -webkit-transition:all 0.2s linear;
  -o-transition:all 0.2s linear;
  overflow: hidden;
}
.modelInfo{
  padding: 15px;
}
table{
  width: 100%;
}
table .point{
  color: var(--off-color);
}
table td{
  padding: 10px 0 10px 10px;
}
table .title{
  text-align: right;
}
.inputBtn{
  font-size: 20px;
  margin-left: 15px;
  cursor: pointer;
}
#setCheckGoods{
  font-size: 0;
}
.modelFrm{
  font-size: 13px;
}
.modelFrm::-webkit-scrollbar{
  width: 0;
}
.avatar-uploader{
  display: inline-block;
  vertical-align: middle;
  margin-right: 15px;
}
.setUpTxt{
  color: var(--on-color);
  cursor: pointer;
}
.modelFrm .el-input{
  width: 250px;
}
.setWordInfoBtn{
  cursor: pointer;
  color: var(--on-color);
  margin-left: 15px;
}
.wordInput{
  display: inline-block;
  margin-left: 15px;
}
.wordLine{
  margin: 25px 0 25px 90px;
}
.wordInfoFrm{
  display: none;
  border: 1px solid var(--on-color);
  border-radius: 5px;
  margin: 15px;
  padding: 15px;
}
.wordInfoFrm.active{
  display: block;
}
.twoInput .el-input:first-child{
  margin-right: 15px;
}
</style>
