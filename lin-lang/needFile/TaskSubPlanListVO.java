package com.hui.pojo.web.model.response;

import com.hui.pojo.dto.ProTaskSubPlanDTO;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName TaskSubPlanListVO
 * @Description TODO
 * @Author Caoyang
 * @Date 2019/12/12 16:09
 **/
@Data
public class TaskSubPlanListVO implements Serializable {

    private static final long serialVersionUID = -1263311677130920037L;

    private Long taskSubPlanId;

    /**
     * 投放计划id
     */
    private Long proTaskPlanId;

    /**
     * 投放数量
     */
    private Integer quantity;

    /**
     * 库存
     */
    private Integer stock;

    /**
     * 限制人数
     */
    private Integer limits;

    /**
     * 转化率
     */
    private Integer converRate;

    /**
     * 投放状态 0未开始 1已开始（投放计划有且只有一个子计划为开始中） 2已结束(已开奖)
     */
    private Integer status;

    /**
     * 投放时间点（第一天就是1）
     */
    private Integer day;


    private void copyFrom(ProTaskSubPlanDTO proTaskSubPlanDTO) {
        this.taskSubPlanId = proTaskSubPlanDTO.getId();
        this.proTaskPlanId = proTaskSubPlanDTO.getProTaskPlanId();
        this.quantity = proTaskSubPlanDTO.getQuantity();
        this.limits = proTaskSubPlanDTO.getLimits();
        this.converRate = proTaskSubPlanDTO.getConverRate();
        this.status = proTaskSubPlanDTO.getStatus();
        this.day = proTaskSubPlanDTO.getDay();

    }

    public static List<TaskSubPlanListVO> bindListData(List<ProTaskSubPlanDTO> proTaskSubPlanDTOs) {
        List<TaskSubPlanListVO> models = new ArrayList<TaskSubPlanListVO>();
        for (ProTaskSubPlanDTO proTaskSubPlanDTO : proTaskSubPlanDTOs) {
            TaskSubPlanListVO model = new TaskSubPlanListVO();
            model.copyFrom(proTaskSubPlanDTO);
            models.add(model);
        }
        return models;
    }
}
