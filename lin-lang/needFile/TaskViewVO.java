package com.hui.pojo.web.model.response;

import com.hui.pojo.dto.ProTaskDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@ApiModel(value="任务商品详情",description="任务商品详情返回参数" )
@Data
public class TaskViewVO implements Serializable {
    private static final long serialVersionUID = -529093551773400638L;
    private Long taskId;

    /**
     * 任务编号
     */
    private String taskSn;

    /**
     * 商品发布流程走向0商品1投放计划2增值服务3已支付4已审核5审核未通过
     */
    private Integer flowStatus;

    /**
     * 发布商品
     */
    private TaskProductViewVO taskProduct;

    /**
     * 发布计划
     */
   private TaskPlanVO taskPlan;
    /**
     * 增值服务
     */
    IncrementServiceVO incrementService;

    private void copyFrom(ProTaskDTO proTaskDTO) {
        this.taskId = proTaskDTO.getId();
        this.taskSn = proTaskDTO.getTaskSn();
        this.flowStatus = proTaskDTO.getFlowStatus();
        this.taskProduct = TaskProductViewVO.bindData(proTaskDTO);
        this.incrementService = IncrementServiceVO.bindData(proTaskDTO);
        this.taskPlan = TaskPlanVO.bindData(proTaskDTO);
    }
    public static TaskViewVO bindData(ProTaskDTO proTaskDTO) {
        TaskViewVO model = new TaskViewVO();
        if (proTaskDTO!=null) {
            model.copyFrom(proTaskDTO);
        }
        return model;
    }
}
