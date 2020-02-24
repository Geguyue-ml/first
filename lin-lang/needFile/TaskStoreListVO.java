package com.hui.pojo.web.model.response;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.hui.pojo.base.enums.StoreEnum;
import com.hui.pojo.base.util.DateUtil;
import com.hui.pojo.dto.ProStoreDTO;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName StoreListVO
 * @Description TODO
 * @Author Caoyang
 * @Date 2019/12/24 16:09
 **/
@Data
public class TaskStoreListVO implements Serializable {

    private static final long serialVersionUID = 242664221127702815L;

    private String name;

    /**
     * 店铺类型，0淘宝 1天猫 2京东 3拼多多
     */
    private Integer storeType;

    List<StoreListVO> shop = new ArrayList<StoreListVO>();

    private void copyFrom(StoreEnum.Type type,List<ProStoreDTO> proStores) {
        this.name = type.name();
        this.storeType = type.ordinal();
        this.shop = StoreListVO.bindListData(proStores,type);
    }

    public static  List<TaskStoreListVO> bindListData(List<ProStoreDTO> proStores) {
        List<TaskStoreListVO> models = new ArrayList<TaskStoreListVO>();
        for (StoreEnum.Type type : StoreEnum.Type.values()) {
            TaskStoreListVO model = new TaskStoreListVO();
            model.copyFrom(type,proStores);
            models.add(model);
        }
        return models;
    }
}
