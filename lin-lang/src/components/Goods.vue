<template>
    <div id="goods">
        <div class="nav_center">
            <h3>{{title}}</h3>
            <div class="swiper-container" :id="typeId">
                <ul class="swiper-wrapper">
                    <router-link tag="li" :to="{name : 'goodsDetailsLink'}" class="swiper-slide">
                        <div class="list_img_a">
                            <img src="http://cdn.static.linlang.com/upload_test/trade/20191101/c37c8f38fbb8d1b73e43d3a2dc9a8106.jpg?imageView2/2/w/300">
                        </div>
                        <p class="goodsTitle">免费任务1免费试用免费试吃，免费品尝士大夫撒旦发射点发违法违法手段范文芳</p>
                        <div class="price">
                            <b>¥78.00</b>
                            <span>限量14份</span>
                        </div>
                        <div class="list_a">免费试用</div>
                    </router-link>
                    <router-link tag="li" :to="{name : 'goodsDetailsLink'}" class="swiper-slide">
                        <div class="list_img_a">
                            <img src="http://cdn.static.linlang.com/upload_test/trade/20191031/68d88533be15b5bfd69171407568bb1a.jpg?imageView2/2/w/300">
                        </div>
                        <p class="goodsTitle">索尼</p>
                        <div class="price">
                            <b>¥199.00</b>
                            <span>限量100份</span>
                        </div>
                        <div class="list_a">免费试用</div>
                    </router-link>
                    <router-link tag="li" :to="{name : 'goodsDetailsLink'}" class="swiper-slide">
                        <div class="list_img_a">
                            <img src="http://cdn.static.linlang.com/upload_test/trade/20191031/68d88533be15b5bfd69171407568bb1a.jpg?imageView2/2/w/300">
                        </div>
                        <p class="goodsTitle">索尼</p>
                        <div class="price">
                            <b>¥199.00</b>
                            <span>限量100份</span>
                        </div>
                        <div class="list_a">免费试用</div>
                    </router-link>
                    <li class="swiper-slide">
                        <div class="list_img_a">
                            <img src="http://cdn.static.linlang.com/upload_test/trade/20191031/68d88533be15b5bfd69171407568bb1a.jpg?imageView2/2/w/300">
                        </div>
                        <p class="goodsTitle">索尼</p>
                        <div class="price">
                            <b>¥199.00</b>
                            <span>限量100份</span>
                        </div>
                        <div class="list_a">免费试用</div>
                    </li>
                    <li class="swiper-slide">
                        <div class="list_img_a">
                            <img src="http://cdn.static.linlang.com/upload_test/trade/20191031/68d88533be15b5bfd69171407568bb1a.jpg?imageView2/2/w/300">
                        </div>
                        <p class="goodsTitle">索尼</p>
                        <div class="price">
                            <b>¥199.00</b>
                            <span>限量100份</span>
                        </div>
                        <div class="list_a">免费试用</div>
                    </li>
                    <li class="swiper-slide">
                        <div class="list_img_a">
                            <img src="http://cdn.static.linlang.com/upload_test/trade/20191031/68d88533be15b5bfd69171407568bb1a.jpg?imageView2/2/w/300">
                        </div>
                        <p class="goodsTitle">索尼</p>
                        <div class="price">
                            <b>¥199.00</b>
                            <span>限量100份</span>
                        </div>
                        <div class="list_a">免费试用</div>
                    </li>
                    <li class="swiper-slide">
                        <div class="list_img_a">
                            <img src="http://cdn.static.linlang.com/upload_test/trade/20191031/68d88533be15b5bfd69171407568bb1a.jpg?imageView2/2/w/300">
                        </div>
                        <p class="goodsTitle">索尼</p>
                        <div class="price">
                            <b>¥199.00</b>
                            <span>限量100份</span>
                        </div>
                        <div class="list_a">免费试用</div>
                    </li>
                    <li class="swiper-slide">
                        <div class="list_img_a">
                            <img src="http://cdn.static.linlang.com/upload_test/trade/20191031/68d88533be15b5bfd69171407568bb1a.jpg?imageView2/2/w/300">
                        </div>
                        <p class="goodsTitle">索尼</p>
                        <div class="price">
                            <b>¥199.00</b>
                            <span>限量100份</span>
                        </div>
                        <div class="list_a">免费试用</div>
                    </li>
                </ul>
                <div class="swiper-button-next goodsNext"></div>
                <div class="swiper-button-prev goodsPrev"></div>
            </div>
        </div>
    </div>
</template>

<script>
import Swiper from 'swiper'
export default {
    name: 'Goods',
    props: {
        title : {
            type : String,
            required : true
        },
        typeId : {
            type : String,
            required : true
        },
        data : {
            type : Object
        }
    },
    mounted(){
        var swiper = new Swiper('#' + this.typeId, {
            slidesPerView: 5,
            spaceBetween: 30,
            navigation: {
                nextEl: '.goodsNext',
                prevEl: '.goodsPrev',
            },
        });
    }
}
</script>

<style scoped>
#goods{
    margin: 20px auto;
}
#goods li{
    display: inline-block;
    cursor: pointer;
    vertical-align: top;
    text-align: center;
}
#goodsFrm{
    margin-bottom: 20px;
}
.list_img_a{
    display: block;
    overflow: hidden;
    max-height: 200px;
    overflow: hidden;
}
.list_img_a img{
    width: 100%;
    transition: all 0.6s;
}
.goodsTitle{
    font-size: 14px;
    color: #666;
    overflow: hidden;
    text-overflow: ellipsis;
    word-break: break-all;
    display: -webkit-box;
    -webkit-line-clamp: 2;
    -webkit-box-orient: vertical;
    margin: 10px;
    height: 40px;
    text-align: left;
}
h3{
    display: inline-block;
    background: #fff url('../assets/banner_arrowoff.png') no-repeat 112px center;
    border-bottom: 2px solid #ff366f;
    padding: 8px 20px 8px 0;
    cursor: pointer;
    margin-bottom: 20px;
}
.price{
    height: 25px;
    line-height: 25px;
    font-size: 14px;
    margin: 10px;
    text-align: left;
}
.price b{
    font-size: 18px;
    text-decoration: line-through;
}
.price span{
    float: right;
}
.list_a{
    display: inline-block;
    border: 1px solid #FF0653;
    border-radius: 20px;
    margin: 10px auto;
    font-size: 16px;
    color: #ff0653;
    text-align: center;
    padding: 8px 30px;
}
.swiper-button-prev,.swiper-button-next{
    margin-top: -96px;
}
.swiper-button-next.swiper-button-disabled, .swiper-button-prev.swiper-button-disabled{
    cursor: pointer;
    pointer-events: auto;
}
.goodsPrev{
    border-radius: 0 20px 20px 0;
    left: 0;
    background: var(--on-color) url('../assets/arrow_left.png') no-repeat 0 center;
}
.goodsNext{
    border-radius: 20px 0 0 20px;
    right: 0;
    background: var(--on-color) url('../assets/arrow_right_b.png') no-repeat 3px center;
}
.goodsPrev, .goodsNext{
    height: 30px;
    width: 25px;
    background-size: 95%;
    opacity: 0.38;
}
.goodsPrev:hover, .goodsNext:hover{
    opacity: 0.68;
}
.goodsPrev::after{
    content: none;
}
.goodsNext::after{
    content: none;
}
</style>