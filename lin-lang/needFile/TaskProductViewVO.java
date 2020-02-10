package com.hui.pojo.web.model.response;

import com.hui.pojo.dto.ProTaskDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;

@ApiModel(value="任务商品详情",description="任务商品详情返回参数" )
@Data
public class TaskProductViewVO implements Serializable {
    private static final long serialVersionUID = -529093551773400638L;
    private Long taskId;

    /**
     * 任务编号
     */
    private String taskSn;

    /**
     * 店铺id
     */
    private Long proStoreId;

    /**
     * 店铺类型，0淘宝 1天猫 2京东 3拼多多
     */
    private Integer storeType;

    /**
     * 商品类型 0人气 1销量
     */
    private Integer taskType;


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
     * 商品规格:0任意规格1自定义
     */
    private Integer specKey;

    /**
     * 商品价格(请务必填写券前价。若宝贝有多种规格且价格不同，请务必填写最高价)
     */
    private BigDecimal price;

    /**
     * 客户每单限拍几件
     */
    private Integer limitNumber;

    /**
     * 规格值
     */
    private String specValue;

    /**
     * 商品主图
     */
    private String productImage;

    /**
     * 淘口令
     */
    private String ambush;

    /**
     * 关键字搜索(多个关键字用，号分割)
     */
    private String proRangeSearchId;

    /**
     * 关键词搜索
     */
    private List<ProductKeywordsSearchListVO> productKeywordsSearchs = new ArrayList<ProductKeywordsSearchListVO>();

    /**
     * APP进店比例(自然搜索进店：淘宝令进店)
     */
    private String enterStoreRate;

    /**
     * 页面展示价格(商品有满减、促销、多规格等情况，请填写此项)
     */
    private BigDecimal showPrice;

    /**
     * 是否包邮  0付邮试用 1包邮试用
     */
    private Boolean whetherMail;

    /**
     * 包邮类型  0商品本身不包邮 1商品本身包邮
     */
    private Integer mailType;

    private Integer phone;

    /**
     * QQ
     */
    private String qq;

    /**
     * weixin
     */
    private String weixin;

    /**
     * 商品发布流程走向0商品1投放计划2增值服务3已支付4已审核5审核未通过
     */
    private Integer flowStatus;



    private void copyFrom(ProTaskDTO proTaskProductDTO) {
        this.taskId = proTaskProductDTO.getId();
        this.taskSn = proTaskProductDTO.getTaskSn();
        this.proStoreId = proTaskProductDTO.getProStoreId();
        this.storeType = proTaskProductDTO.getStoreType();
        this.taskType = proTaskProductDTO.getTaskType();
        this.name = proTaskProductDTO.getName();
        this.taskComment = proTaskProductDTO.getTaskComment();
        this.proProductCategoryId = proTaskProductDTO.getProProductCategoryId();
        this.platformImage = proTaskProductDTO.getPlatformImage();
        this.link = proTaskProductDTO.getLink();
        this.productImage = proTaskProductDTO.getProductImage();
        this.ambush = proTaskProductDTO.getAmbush();
        this.proRangeSearchId = proTaskProductDTO.getProRangeSearchId();
        this.enterStoreRate = proTaskProductDTO.getEnterStoreRate();
        this.specKey = proTaskProductDTO.getSpecKey();
        this.specValue = proTaskProductDTO.getSpecValue();
        this.price = proTaskProductDTO.getPrice();
        this.showPrice = proTaskProductDTO.getShowPrice();
        this.limitNumber = proTaskProductDTO.getLimitNumber();
        this.whetherMail = proTaskProductDTO.getWhetherMail();
        this.mailType = proTaskProductDTO.getMailType();
        this.phone = proTaskProductDTO.getPhone();
        this.qq = proTaskProductDTO.getQq();
        this.weixin = proTaskProductDTO.getWeixin();
        this.flowStatus = proTaskProductDTO.getFlowStatus();
    }
    public static TaskProductViewVO bindData(ProTaskDTO proTaskProductDTO) {
        TaskProductViewVO model = new TaskProductViewVO();
        if (proTaskProductDTO!=null) {
            model.copyFrom(proTaskProductDTO);
        }
        return model;
    }
}
