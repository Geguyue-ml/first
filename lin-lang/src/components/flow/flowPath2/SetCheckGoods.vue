<template>
  <div id="setCheckGoods">
    <div class="modelFrm">
      <el-checkbox v-model="checkedPC" @change="isSow(checkedPC, '#PC', PCH)">设置试客从PC端淘宝自然搜索找商品</el-checkbox>
      <div class="model" id="PC">
        <table>
          <tr>
            <td class="title" style="width:150px;">商品主图：</td>
            <td colspan="2">
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
            <td colspan="3">设置让试客在淘宝中搜索的关键字：</td>
          </tr>
          <tr v-for="(item, key) in wordVal" :key="key">
            <td class="title">设置关键词{{key + 1}}：</td>
            <td style="width:250px;">
              <el-input v-model="wordVal[key]" placeholder="请输入商品关键词" maxlength="10" show-word-limit></el-input>
            </td>
            <td>
              <i class="el-icon-circle-plus-outline inputBtn" title="最多添加十个关键词" @click="addLine"></i>
              <i class="el-icon-remove-outline inputBtn" title="删除当前关键词" @click="removeLine($event)" :data-wordNum="key"></i>
            </td>
          </tr>
        </table>
      </div>

      <el-checkbox v-model="checkedMo" @change="isSow(checkedMo, '#Mo', MoH)">设置试客从手机淘宝App入店</el-checkbox>
      <div class="model" id="Mo">
        123
      </div>
    </div>
    <div class="modelFrm">
      <table>
        <tr>
          <td colspan="3">
            <span>关键词1设置</span>
            <span class="point">（缩小关键词搜索范围,试客选择搜索列表中的“分类”和“排序”缩小范围）</span>
            <span>：</span>
          </td>
        </tr>
        <tr>
          <td style="width:140px;">分类名称-关键词：</td>
          <td>
            <el-input placeholder="请输入分类名称" v-model="input1"></el-input>
          </td>
          <td>
            <el-input placeholder="请输入分类关键词" v-model="input2"></el-input>
          </td>
        </tr>
        <tr>
          <td style="width:140px;">分类名称-关键词：</td>
          <td>
            <el-input placeholder="请输入分类名称" v-model="input1"></el-input>
          </td>
          <td>
            <el-input placeholder="请输入分类关键词" v-model="input2"></el-input>
          </td>
        </tr>
        <tr>
          <td style="width:140px;">分类名称-关键词：</td>
          <td>
            <el-input placeholder="请输入分类名称" v-model="input1"></el-input>
          </td>
          <td>
            <el-input placeholder="请输入分类关键词" v-model="input2"></el-input>
          </td>
        </tr>
        <tr>
          <td>选择折扣及服务：</td>
          <td colspan="2">
            <div class="selectItem" :class="{'show': by}" @click="by = !by" :v-model="by">包邮</div>
            <div class="selectItem" :class="{'show': yfx}" @click="yfx = !yfx" :v-model="yfx">赠送退货运费险</div>
            <div class="selectItem" :class="{'show': hdfk}" @click="hdfk = !hdfk" :v-model="hdfk">货到付款</div>
            <div class="selectItem" :class="{'show': hwsp}" @click="hwsp = !hwsp" :v-model="hwsp">海外商品</div>
            <div class="selectItem" :class="{'show': es}" @click="es = !es" :v-model="es">二手</div>
            <div class="selectItem" :class="{'show': zpbz}" @click="zpbz = !zpbz" :v-model="zpbz">正品保障</div>
          </td>
        </tr>
        <tr>
          <td>排序方式：</td>
          <td colspan="2">
            <el-select v-model="selectRq" slot="prepend" placeholder="请选择商品排序方式">
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
        </tr>
        <tr>
          <td>价格区间：</td>
          <td>
            <el-input placeholder="最低价格" v-model="input1"></el-input>
          </td>
          <td>
            <el-input placeholder="最高价格" v-model="input2"></el-input>
          </td>
        </tr>
        <tr>
          <td>发货地：</td>
          <td>
            <el-select v-model="selectFhd" slot="prepend" placeholder="请选择发货地">
              <el-option label="上海" value="1"></el-option>
              <el-option label="浙江" value="2"></el-option>
              <el-option label="湖北" value="3"></el-option>
              <el-option label="安徽" value="4"></el-option>
            </el-select>
          </td>
        </tr>
      </table>
    </div>
  </div>
</template>

<script>
export default {
  name: 'SetCheckGoods',
  data () {
    return {
      checkedPC: true,
      checkedMo: true,
      imageUrl: '',
      wordVal: ['123', ''],
      PCH: '',
      MoH: '',
      input1: '',
      input2: '',
      by: true,
      yfx: false,
      hdfk: false,
      hwsp: false,
      es: false,
      zpbz: false,
      selectRq: '',
      selectFhd: ''
    }
  },
  mounted(){
    this.PCH = $('#PC').height();
    this.isSow(this.checkedPC, '#PC', this.PCH);
    this.MoH = $('#Mo').height();
    this.isSow(this.checkedMo, '#Mo', this.MoH);
  },
  methods: {
    isSow(val, ele, height){
      if(val == true){
        $(ele).css("height", height)
        setTimeout(function(){
          $(ele).css("height", "auto")
        }, 300)
      }else{
        console.log($(ele).height());
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
      if(this.wordVal.length < 10){
        this.wordVal.push("")
      }else{
        alert("最多只能添加十个关键词")
      }
    },
    removeLine(ele){
      if(this.wordVal.length > 1){
        this.wordVal.splice($(ele.target).attr("data-wordNum"), 1)
      }else{
        alert("至少设置一个关键词")
      }
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
  padding: 20px 20px 20px 0;
}
.modelVal table .title{
  text-align: right;
}
.inputBtn{
  font-size: 20px;
  margin-left: 15px;
  cursor: pointer;
}
.selectItem{
  display: inline-block;
  padding: 5px 15px;
  margin: 5px;
  border-radius: 5px;
  border: 1px solid var(--on-color);
  cursor: pointer;
}
.selectItem.show{
  background-color: var(--on-color);
  color: #fff;
}
#setCheckGoods{
  font-size: 0;
}
.modelFrm{
  width: 50%;
  display: inline-block;
  font-size: 13px;
  vertical-align: top;
  max-height: 690px;
  overflow-y: auto;
}
.modelFrm::-webkit-scrollbar{
  width: 0;
}
</style>
