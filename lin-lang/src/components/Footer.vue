<template>
  <div id="footer">
        <div class="pointModle">
            <div class="nav_center">
                <ul class="clearfix">
                    <li>
                        <img src="../assets/model1.png">
                        <span><b>闪电到账</b><br><em>收货评价直接现金到账</em></span>
                    </li>
                    <li>
                        <img src="../assets/model2.png">
                        <span><b>好货保障</b><br><em>商品平均客单价200元</em></span>
                    </li>
                    <li>
                        <img src="../assets/model3.png">
                        <span><b>高中奖率</b><br><em>高达平均30%中奖率</em></span>
                    </li>
                    <li>
                        <img src="../assets/model4.png">
                        <span><b>代言人奖</b><br><em>邀请送10元现金+必中</em></span>
                    </li>
                </ul>
            </div>
        </div>
        <div class="infoModel">
            <div class="nav_center clearfix">
                <div class="myfl">
                    <div class="footerLink">
                        <ul>
                            <li><a href="/contact-us" target="view_window">关于我们</a></li>
                            <li><a href="/contact-us" target="view_window">联系我们</a></li>
                            <li><a href="/app/html/home/user_protocolC.html" target="_blank">法律声明</a></li>
                            <li><a href="javascript:;">站点地图</a></li>
                            <li><a href="/help/help_indexb">帮助中心</a></li>
                        </ul>
                    </div>
                    <div class="contact">
                        <div class="contact-info">
                            <img src="../assets/customer_service.png">
                            <span class="on">0571-28120772</span>
                            <img src="../assets/email.png">
                            <span class="off">kefu@laqu.com</span>
                        </div>
                        <p class="contactTime">客服工作时间：周一到周五 9:00-12:00；13:00-18:00（法定节假日除外）</p>
                    </div>
                </div>
                <div class="myfr">
                    <div class="myfr GZH">
                        <span>
                            <p>微信关注我们</p>
                            <p>更多优惠等你来发现</p>
                        </span>
                        <img src="../assets/QRcode_user.jpg">
                    </div>
                </div>
            </div>
        </div>
        <div class="recordModel">
            <div class="nav_center">
                <span>Copyright</span>
                <span>©&nbsp;2017杭州拉趣科技有限公司</span>
                <span>浙ICP17003883号-1</span>
                <span>版权所有</span>
            </div>
        </div>
  </div>
</template>

<script>
export default {
  name: 'Footer',
  data () {
    return {
      
    }
  }
}
</script>

<style scoped>
#footer{
    margin-top: 60px;
    background: #F7F7F7;
}
.pointModle {
    width: 100%;
    border-bottom: 1px solid rgb(199, 199, 199);
    padding-bottom: 24px;
}
.pointModle li {
    width: 25%;
    text-align: center;
    float: left;
    margin-top: 20px;
    border-right: 1px solid rgb(199, 199, 199);
}
.pointModle li img {
    vertical-align: middle;
    margin-right: 15px;
}
.pointModle li span {
    text-align: left;
    vertical-align: middle;
}
.infoModel{
    padding: 20px 0;
    color: var(--off-color);
    font-size: 16px;
    border-bottom: 1px solid rgb(199, 199, 199);
}
.footerLink {
    padding-bottom: 34px;
}
.footerLink ul li {
    display: inline-block;
    margin-right: 30px;
}
.footerLink ul li a {
    color: var(--off-color);
    font-size: 14px;
    line-height: 1;
    display: block;
}
.contact {
    padding-bottom: 20px;
}
.contact-info{
    margin-bottom: 10px;
    line-height: 1;
}
.contact-info img{
    margin-right: 6px;
    width: 30px;
}
.contact-info span{
    margin-right: 36px;
}
.contact-info .on{
    font-size: 22px;
    color: var(--on-color);
}
.contact-info .off{
    font-size: 22px;
    color: var(--off-color);
}
.contactTime {
    font-size: 14px;
    font-family: "MicrosoftYaHei";
    font-weight: 400;
    color: var(--off-color);
    line-height: 28px;
}
.contact-info img, .contact-info span {
    vertical-align: middle;
}
.GZH span{
    display: inline-block;
    vertical-align: middle;
    font-size: 16px;
    text-align: right;
    line-height: 30px;
    padding-right: 35px;
    color: var(--off-color);
    background: url('../assets/arrow_right.png') no-repeat 140px center;
    background-size: 26%;
}
.GZH img{
    height: 140px;
    border: 1px solid rgba(227, 227, 227, 1);
    vertical-align: middle;
}
.recordModel{
    padding: 20px 0;
    text-align: center;
    color: var(--off-color);
}
.recordModel span{
    margin-right: 15px;
}
</style>
