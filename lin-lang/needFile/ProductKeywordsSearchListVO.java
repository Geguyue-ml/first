package com.hui.pojo.web.model.response;

import com.hui.pojo.dto.ProKeywordsSearchDTO;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName TaskKeywordsSearchVO
 * @Description TODO
 * @Author Caoyang
 * @Date 2019/12/12 14:54
 **/
@Data
public class ProductKeywordsSearchListVO implements Serializable {

    private static final long serialVersionUID = 4552137877070083435L;
    /**
     * 任务编码
     */
    private String taskSn;

    /**
     * 关键字
     */
    private String keyWords;

    /**
     * 进店比例
     */
    private Integer keyWordsRate;

    /**
     * 是否高级设置
     */
    private Integer whetherAdvancedSetting;

    /**
     * 分类名称筛选(多个，号隔开)
     */
    private String className;

    /**
     * 分类值筛选(多个，号隔开)
     */
    private String classValue;

    /**
     * 折扣和服务(多个服务用，号分割)
     */
    private String disServices;

    /**
     * 排序方式
     */
    private Integer sortOrder;

    /**
     * 价格筛选
     */
    private BigDecimal startPrice;

    /**
     * 价格筛选
     */
    private BigDecimal endPrice;

    /**
     * 发货地筛选
     */
    private String deliveryPlace;

    private void copyFrom(ProKeywordsSearchDTO proKeywordsSearchDTO) {
        this.taskSn = proKeywordsSearchDTO.getTaskSn();
        this.keyWords = proKeywordsSearchDTO.getKeyWords();
        this.keyWordsRate = proKeywordsSearchDTO.getKeyWordsRate();
        this.whetherAdvancedSetting = proKeywordsSearchDTO.getWhetherAdvancedSetting();
        this.className = proKeywordsSearchDTO.getClassName();
        this.classValue = proKeywordsSearchDTO.getClassValue();
        this.disServices = proKeywordsSearchDTO.getDisServices();
        this.sortOrder = proKeywordsSearchDTO.getSortOrder();
        this.startPrice = proKeywordsSearchDTO.getStartPrice();
        this.endPrice = proKeywordsSearchDTO.getEndPrice();
        this.deliveryPlace = proKeywordsSearchDTO.getDeliveryPlace();
    }

    public static List<ProductKeywordsSearchListVO> bindListData(List<ProKeywordsSearchDTO> proKeywordsSearchs) {
        List<ProductKeywordsSearchListVO> models = new ArrayList<ProductKeywordsSearchListVO>();
        for (ProKeywordsSearchDTO proKeywordsSearchDTO : proKeywordsSearchs) {
            ProductKeywordsSearchListVO model = new ProductKeywordsSearchListVO();
            model.copyFrom(proKeywordsSearchDTO);
            models.add(model);
        }
        return models;
    }
}
