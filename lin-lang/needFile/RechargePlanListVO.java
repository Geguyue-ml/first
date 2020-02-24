package com.hui.pojo.web.model.response;

import com.hui.pojo.base.enums.StoreEnum;
import com.hui.pojo.base.util.CommonUtil;
import com.hui.pojo.base.util.DateUtil;
import com.hui.pojo.dto.ProRechargePlanDTO;
import com.hui.pojo.dto.ProStoreDTO;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName RechargePlanListVO
 * @Description TODO
 * @Author Caoyang
 * @Date 2020/1/2 14:09
 **/
@Data
public class RechargePlanListVO implements Serializable {

    private static final long serialVersionUID = 4978043232639288439L;

    private Long rechargePlanId;
    /**
     * 购买时长
     */
    private Integer months;
    /**
     * 购买金额
     */
    private String amount;
    /**
     * 赠送金豆
     */
    private String giftAmount;
    /**
     * 是否是充值活动0:否，1:是
     */
    private Boolean whetherRechargeActivity;
    /**
     * 活动开始时间
     */
    private String startDate;
    /**
     * 活动结束时间
     */
    private String endDate;

    private void copyFrom(ProRechargePlanDTO proRechargePlanDTO) {
        this.rechargePlanId = proRechargePlanDTO.getId();
        this.months = proRechargePlanDTO.getMonths();
        this.amount = CommonUtil.fenToyuan(proRechargePlanDTO.getAmount());
        this.giftAmount = CommonUtil.fenToyuan(proRechargePlanDTO.getGiftAmount());
        this.whetherRechargeActivity = proRechargePlanDTO.getWhetherRechargeActivity();
        if (proRechargePlanDTO.getStartDate() != null) {
            this.startDate = DateUtil.dateToString(proRechargePlanDTO.getStartDate(), DateUtil.PATTERN_STANDARD);
        }
        if (proRechargePlanDTO.getEndDate() != null) {
            this.endDate = DateUtil.dateToString(proRechargePlanDTO.getEndDate(), DateUtil.PATTERN_STANDARD);
        }
    }
    public static List<RechargePlanListVO> bindListData(List<ProRechargePlanDTO> proRechargePlans) {
            List<RechargePlanListVO> models = new ArrayList<RechargePlanListVO>();
            for (ProRechargePlanDTO proRechargePlanDTO : proRechargePlans) {
                RechargePlanListVO model = new RechargePlanListVO();
                model.copyFrom(proRechargePlanDTO);
                models.add(model);
            }
            return models;
        }
}
