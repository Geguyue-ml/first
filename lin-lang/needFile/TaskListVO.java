package com.hui.pojo.web.model.response;

import com.hui.pojo.base.util.DateUtil;
import com.hui.pojo.dto.ProTaskDTO;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName TaskListVO
 * @Description TODO
 * @Author Caoyang
 * @Date 2019/12/15 16:09
 **/
@Data
public class TaskListVO implements Serializable {

    private static final long serialVersionUID = -6429074253625663672L;

    private String taskSn;

    private BigDecimal price;

    /**
     * 投放时间
     */
    private String releaseDate;

    /**
     * 投放数量
     */
    private Integer totalQuantitys;
    /**
     * 申请人数
     */
    private Integer applyNum;
    /**
     * 已下单数量
     */
    private Integer orderNum;
    /**
     * 已完成数量
     */
    private Integer completeNum;
    /**
     * 未完成数量
     */
    private Integer unCompleteNum;
    /**
     * 待审核订单数量
     */
    private Integer waitAuditeOrderNum;
    /**
     * 待审核好评数量
     */
    private Integer waitAuditeEvaluateNum;
    /**
     * 待审核好评截图数量
     */
    private Integer waitAuditeScreenshotNum;


    private void copyFrom(ProTaskDTO proTaskDTO) {
        this.taskSn = proTaskDTO.getTaskSn();
        this.price = proTaskDTO.getPrice();
        if(proTaskDTO.getReleaseDate()!=null) {
            this.releaseDate = DateUtil.dateToString(proTaskDTO.getReleaseDate(),DateUtil.PATTERN_STANDARD);
        }
        this.totalQuantitys = proTaskDTO.getTotalQuantitys();
        this.applyNum = proTaskDTO.getApplyNum();
        this.orderNum = proTaskDTO.getOrderNum();
        this.completeNum = proTaskDTO.getCompleteNum();
        this.unCompleteNum = proTaskDTO.getUnCompleteNum();
        this.waitAuditeOrderNum = proTaskDTO.getWaitAuditeOrderNum();
        this.waitAuditeEvaluateNum = proTaskDTO.getWaitAuditeEvaluateNum();
        this.waitAuditeScreenshotNum = proTaskDTO.getWaitAuditeScreenshotNum();
    }

    public static List<TaskListVO> bindListData(List<ProTaskDTO> proTasks) {
        List<TaskListVO> models = new ArrayList<TaskListVO>();
        for (ProTaskDTO proTaskDTO : proTasks) {
            TaskListVO model = new TaskListVO();
            model.copyFrom(proTaskDTO);
            models.add(model);
        }
        return models;
    }
}
