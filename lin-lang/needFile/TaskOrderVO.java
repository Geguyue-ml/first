package com.hui.pojo.web.model.response;

import com.hui.pojo.base.util.CommonUtil;
import com.hui.pojo.dto.ProOrderDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author caoyang
 */
@ApiModel(value="任务支付详情",description="任务支付详情返回参数" )
@Data
public class TaskOrderVO implements Serializable {

    private static final long serialVersionUID = -5203307057524720690L;

    /**
     * 任务订单编号
     */
    private String orderSn;

    /**
     * 发布任务编码
     */
    private String taskSn;

    /**
     * 投放总数量
     */
    private Integer totalQuantitys;

    /**
     * 总支付金额
     */
    private String amount;

    /**
     * 账户余额
     */
    private String balance;

    /**
     * 订单金额
     */
    private String money;
    /**
     * 金豆
     */
    private BigDecimal goldPea;


    private void copyFrom(ProOrderDTO proTaskOrderDTO) {
        this.orderSn = proTaskOrderDTO.getSn();
        this.taskSn = proTaskOrderDTO.getTaskSn();
        this.totalQuantitys = proTaskOrderDTO.getTotalQuantitys();
        this.amount = CommonUtil.mathToDivid(proTaskOrderDTO.getAmount(),100);
        this.money = CommonUtil.mathToDivid(proTaskOrderDTO.getMoney(),100);
        this.goldPea = proTaskOrderDTO.getGoldPea();
    }
    public static TaskOrderVO bindData(ProOrderDTO proTaskOrderDTO) {
        TaskOrderVO model = new TaskOrderVO();
        if (proTaskOrderDTO!=null) {
            model.copyFrom(proTaskOrderDTO);
        }
        return model;
    }
}
