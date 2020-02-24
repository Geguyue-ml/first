package com.hui.pojo.web.model.response;

import com.hui.pojo.base.util.DateUtil;
import com.hui.pojo.dto.ProProductDTO;
import com.hui.pojo.dto.ProTaskDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author caoyang
 */
@ApiModel(value="商品详情",description="商品详情返回参数" )
@Data
public class ProductListVO implements Serializable {
    private static final long serialVersionUID = -8781660614902821445L;

    private Long productId;

    /**
     * 商品编号
     */
    private String productSn;

    /**
     * 店铺id
     */
    private Long proStoreId;

    /**
     * 店铺类型，0淘宝 1天猫 2京东 3拼多多
     */
    private Integer storeType;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 任务备注
     */
    private String taskComment;

    /**
     * 商品分类
     */
    private Long proProductCategoryId;

    /**
     * 平台主图
     */
    private String platformImage;

    /**
     * 商品链接
     */
    private String link;

    /**
     * 商品主图
     */
    private String productImage;

    /**
     * 淘口令
     */
    private String ambush;

    /**
     * APP进店比例(自然搜索进店：淘宝令进店)
     */
    private String enterStoreRate;

    /**
     * 商品规格:0任意规格1自定义
     */
    private Integer specKey;

    /**
     * 规格值
     */
    private String specValue;

    /**
     * 商品价格(请务必填写券前价。若宝贝有多种规格且价格不同，请务必填写最高价)
     */
    private BigDecimal price;

    /**
     * 页面展示价格(商品有满减、促销、多规格等情况，请填写此项)
     */
    private BigDecimal showPrice;

    /**
     * 优惠券下单:0允许1不允许
     */
    private BigDecimal whetherCoupon;

    /**
     * 优惠券金额
     */
    private BigDecimal couponPrice;

    /**
     * 券后价
     */
    private BigDecimal couponAfterPrice;

    /**
     * 优惠券链接
     */
    private BigDecimal couponLink;

    /**
     * 商品折扣率(1-9)
     */
    private Integer discountRate;

    /**
     * 商品折扣后价格
     */
    private BigDecimal discountAfterPrice;

    /**
     * 客户每单限拍几件
     */
    private Integer limitNumber;

    /**
     * 是否包邮  0付邮试用 1包邮试用
     */
    private Boolean whetherMail;

    /**
     * 包邮类型  0商品本身不包邮 1商品本身包邮
     */
    private Boolean mailType;

    private Integer phone;

    /**
     * QQ
     */
    private String qq;

    /**
     * weixin
     */
    private String weixin;

    private String modifyDate;

    private void copyFrom(ProProductDTO proProductDTO) {
        this.productId =proProductDTO.getId();
        this.productSn =proProductDTO.getProductSn();
        this.proStoreId =proProductDTO.getProStoreId();
        this.storeType =proProductDTO.getStoreType();
        this.name =proProductDTO.getName();
        this.taskComment =proProductDTO.getTaskComment();
        this.proProductCategoryId =proProductDTO.getProProductCategoryId();
        this.platformImage =proProductDTO.getPlatformImage();
        this.link =proProductDTO.getLink();
        this.productImage =proProductDTO.getProductImage();
        this.ambush =proProductDTO.getAmbush();
        this.enterStoreRate =proProductDTO.getEnterStoreRate();
        this.specKey =proProductDTO.getSpecKey();
        this.specValue =proProductDTO.getSpecValue();
        this.price =proProductDTO.getPrice();
        this.showPrice =proProductDTO.getShowPrice();
        this.whetherCoupon =proProductDTO.getWhetherCoupon();
        this.couponPrice =proProductDTO.getCouponPrice();
        this.couponAfterPrice =proProductDTO.getCouponAfterPrice();
        this.couponLink =proProductDTO.getCouponLink();
        this.discountRate =proProductDTO.getDiscountRate();
        this.discountAfterPrice =proProductDTO.getDiscountAfterPrice();
        this.limitNumber =proProductDTO.getLimitNumber();
        this.whetherMail =proProductDTO.getWhetherMail();
        this.mailType =proProductDTO.getMailType();
        this.phone =proProductDTO.getPhone();
        this.qq =proProductDTO.getQq();
        this.weixin =proProductDTO.getWeixin();
        if(proProductDTO.getModifyDate()!=null) {
            this.modifyDate = DateUtil.dateToString(proProductDTO.getModifyDate(),DateUtil.PATTERN_STANDARD);
        }
    }


    public static List<ProductListVO> bindListData(List<ProProductDTO> proProducts) {
        List<ProductListVO> models = new ArrayList<ProductListVO>();
        for (ProProductDTO proProductDTO : proProducts) {
            ProductListVO model = new ProductListVO();
            model.copyFrom(proProductDTO);
            models.add(model);
        }
        return models;
    }
}
