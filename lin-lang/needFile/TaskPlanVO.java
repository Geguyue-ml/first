package com.hui.pojo.web.model.response;

import com.hui.pojo.base.util.CommonUtil;
import com.hui.pojo.base.util.DateUtil;
import com.hui.pojo.dto.ProSettingDTO;
import com.hui.pojo.dto.ProTaskDTO;
import com.hui.pojo.dto.ProTaskPlanDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ApiModel(value="任务计划详情",description="任务计划详情返回参数" )
@Data
public class TaskPlanVO implements Serializable {

    private static final long serialVersionUID = 7274606916281814466L;

    private Long taskPlanId;

    /**
     * 发布任务编码
     */
    private String taskSn;

    /**
     * 开始时间
     */
    private String startDate;

    /**
     * 投放总数量
     */
    private Integer totalQuantitys;

    /**
     * 投放总库存
     */
    private Integer totalStocks;

    /**
     * 投放总天数
     */
    private Integer totalDays;

    /**
     * 已被使用的天数（已经开奖的天数数量）
     */
    private Integer usedSubPlan;

    /**
     * 投放状态 0未开始 1已开始 2已结束(所有计划子表都结束)
     */
    private Integer status;

    /**
     * 试用担保金收取比例(10，就是10%)
     */
    private Integer guaranteeRate;

    /**
     * 运费金额/试用备用金
     */
    private String  mailMoney;

    /**
     * 商品价格
     */
    private String  productPrice;

    /**
     * 子计划
     */
    private List<TaskSubPlanListVO> proTaskSubPlans = new ArrayList<TaskSubPlanListVO>();

    private void copyFrom(ProTaskPlanDTO proTaskPlanDTO,ProTaskDTO proTaskProductDTO) {
        this.taskPlanId = proTaskPlanDTO.getId();
        this.taskSn = proTaskPlanDTO.getTaskSn();
        this.totalQuantitys = proTaskPlanDTO.getTotalQuantitys();
        this.totalStocks = proTaskPlanDTO.getTotalStocks();
        this.totalDays = proTaskPlanDTO.getTotalDays();
        this.usedSubPlan = proTaskPlanDTO.getUsedSubPlan();
        this.status = proTaskPlanDTO.getStatus();
        if(proTaskPlanDTO.getStartDate()!=null) {
            this.startDate = DateUtil.dateToString(proTaskPlanDTO.getStartDate(),DateUtil.PATTERN_STANDARD);
        }
        this.guaranteeRate = proTaskProductDTO.getGuaranteeRate();
        this.mailMoney = CommonUtil.mathToDivid(proTaskProductDTO.getMailMoney(),100);
        this.productPrice = proTaskProductDTO.getfenToyuanPrice();
    }
    public static TaskPlanVO bindData(ProTaskPlanDTO proTaskPlanDTO,ProTaskDTO proTaskProductDTO) {
        TaskPlanVO model = new TaskPlanVO();
        if (proTaskPlanDTO!=null) {
            model.copyFrom(proTaskPlanDTO,proTaskProductDTO);
        }
        return model;
    }


    private void copyFrom(ProTaskDTO proTaskPlanDTO) {
        this.taskPlanId = proTaskPlanDTO.getId();
        this.taskSn = proTaskPlanDTO.getTaskSn();
        this.totalQuantitys = proTaskPlanDTO.getTotalQuantitys();
        this.totalStocks = proTaskPlanDTO.getTotalStocks();
        this.totalDays = proTaskPlanDTO.getTotalDays();
        this.usedSubPlan = proTaskPlanDTO.getUsedSubPlan();
        this.status = proTaskPlanDTO.getStatus();
        if(proTaskPlanDTO.getStartDate()!=null) {
            this.startDate = DateUtil.dateToString(proTaskPlanDTO.getStartDate(),DateUtil.PATTERN_STANDARD);
        }
    }
    public static TaskPlanVO bindData(ProTaskDTO proTaskPlanDTO) {
        TaskPlanVO model = new TaskPlanVO();
        if (proTaskPlanDTO!=null) {
            model.copyFrom(proTaskPlanDTO);
        }
        return model;
    }
}
