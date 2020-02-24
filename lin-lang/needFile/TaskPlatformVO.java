package com.hui.pojo.web.model.response;

import com.hui.pojo.dto.ProTaskDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@ApiModel(value="选择平台详情",description="任务选择平台详情返回参数" )
@Data
public class TaskPlatformVO implements Serializable {

    private static final long serialVersionUID = 6334090545322073278L;

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

    private void copyFrom(ProTaskDTO proTaskProductDTO) {
        this.taskId = proTaskProductDTO.getId();
        this.taskSn = proTaskProductDTO.getTaskSn();
        this.proStoreId = proTaskProductDTO.getProStoreId();
        this.storeType = proTaskProductDTO.getStoreType();
        this.taskType = proTaskProductDTO.getTaskType();
    }
    public static TaskPlatformVO bindData(ProTaskDTO proTaskDTO) {
        TaskPlatformVO model = new TaskPlatformVO();
        if (proTaskDTO!=null) {
            model.copyFrom(proTaskDTO);
        }
        return model;
    }
}
