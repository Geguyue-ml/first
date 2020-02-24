package com.hui.pojo.web.model.response;

import com.hui.pojo.dto.ProKeywordsEvaluateDTO;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class KeywordsEvaluateListVO implements Serializable {

    private static final long serialVersionUID = -4851737249684528988L;

    /**
     * 增值服务id
     */
    private Long proIncrementServiceId;

    /**
     * 关键字
     */
    private String keyWords;

    /**
     * 设置发放好评关键字人数
     */
    private Integer keyWordsPeople;



    private void copyFrom(ProKeywordsEvaluateDTO proKeywordsEvaluateDTO) {
        this.proIncrementServiceId = proKeywordsEvaluateDTO.getProIncrementServiceId();
        this.keyWords = proKeywordsEvaluateDTO.getKeyWords();
        this.keyWordsPeople = proKeywordsEvaluateDTO.getKeyWordsPeople();
    }

    public static List<KeywordsEvaluateListVO> bindListData(List<ProKeywordsEvaluateDTO> proKeywordsEvaluates) {
        List<KeywordsEvaluateListVO> models = new ArrayList<KeywordsEvaluateListVO>();
        for (ProKeywordsEvaluateDTO proKeywordsEvaluateDTO : proKeywordsEvaluates) {
            KeywordsEvaluateListVO model = new KeywordsEvaluateListVO();
            model.copyFrom(proKeywordsEvaluateDTO);
            models.add(model);
        }
        return models;
    }
}