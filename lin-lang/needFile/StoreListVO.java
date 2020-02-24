package com.hui.pojo.web.model.response;

import com.hui.pojo.base.enums.StoreEnum;
import com.hui.pojo.base.util.DateUtil;
import com.hui.pojo.dto.ProStoreDTO;
import com.hui.pojo.dto.ProTaskDTO;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName StoreListVO
 * @Description TODO
 * @Author Caoyang
 * @Date 2019/12/24 16:09
 **/
@Data
public class StoreListVO implements Serializable {

    private static final long serialVersionUID = 242664221127702815L;

    private Long storeId;

    /**
     * 店主
     */
    private Long proMemberId;

    private String name;

    private String storeLink;

    /**
     * 店铺类型，0淘宝 1天猫 2京东 3拼多多
     */
    private Integer storeType;

    private String logo;

    private String qq;

    private String wechat;

    private String phone;

    /**
     * 店铺分类
     */
    private Long proTenantCategoryId;

    private Long proAreaId;

    /**
     * 店铺状态，0待审核 1已审核(未付费) 2已开通 3已过期 4已关闭
     */
    private Integer status;

    private String expireDate;

    private String createDate;

    private String modifyDate;

    private String address;

    private void copyFrom(ProStoreDTO proStoreDTO) {
        this.storeId = proStoreDTO.getId();
        this.proMemberId = proStoreDTO.getProMemberId();
        this.name = proStoreDTO.getName();
        this.storeLink = proStoreDTO.getStoreLink();
        this.storeType = proStoreDTO.getStoreType();
        this.logo = proStoreDTO.getLogo();
        this.qq = proStoreDTO.getQq();
        this.wechat = proStoreDTO.getWechat();
        this.phone = proStoreDTO.getPhone();
        this.status = proStoreDTO.getStatus();
        if(proStoreDTO.getExpireDate()!=null) {
            this.expireDate = DateUtil.dateToString(proStoreDTO.getExpireDate(),DateUtil.PATTERN_STANDARD);
        }
        if(proStoreDTO.getCreateDate()!=null) {
            this.createDate = DateUtil.dateToString(proStoreDTO.getCreateDate(),DateUtil.PATTERN_STANDARD);
        }
        this.address = proStoreDTO.getAddress();
    }

    public static List<StoreListVO> bindListData(List<ProStoreDTO> proStoreDTOs) {
        List<StoreListVO> models = new ArrayList<StoreListVO>();
        for (ProStoreDTO proStoreDTO : proStoreDTOs) {
            StoreListVO model = new StoreListVO();
            model.copyFrom(proStoreDTO);
            models.add(model);
        }
        return models;
    }

    public static List<StoreListVO> bindListData(List<ProStoreDTO> proStoreDTOs, StoreEnum.Type type) {
        List<StoreListVO> models = new ArrayList<StoreListVO>();
        for (ProStoreDTO proStoreDTO : proStoreDTOs) {
            if(proStoreDTO.getStoreType().equals(type.ordinal())) {
                StoreListVO model = new StoreListVO();
                model.copyFrom(proStoreDTO);
                models.add(model);
            }
        }
        return models;
    }
}
