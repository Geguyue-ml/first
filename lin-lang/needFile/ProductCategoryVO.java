package com.hui.pojo.web.model.response;

import com.hui.pojo.dto.ProProductCategoryDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ApiModel(value="商品分类",description="商品分类返回参数" )
@Data
public class ProductCategoryVO implements Serializable {

    private static final long serialVersionUID = 1004305279827722649L;
    @ApiModelProperty(value="商品分类id")
    private Long productCategoryId;

    /**
     * 等级(0为顶级)
     */
    @ApiModelProperty(value="等级(0为顶级)")
    private Integer grade;

    @ApiModelProperty(value="分类名称")
    private String name;

    /**
     * 父级id
     */
    @ApiModelProperty(value="父级id")
    private Long parent;

    @ApiModelProperty(value="分类图片")
    private String image;

    @ApiModelProperty(value="分类名称全称")
    private String fullName;


    public void copyFrom(ProProductCategoryDTO proProductCategoryDTO) {
        this.productCategoryId = proProductCategoryDTO.getId();
        this.grade = proProductCategoryDTO.getGrade();
        this.parent = proProductCategoryDTO.getParent();
        this.image = proProductCategoryDTO.getImage();
        this.name = proProductCategoryDTO.getName();
        this.fullName = proProductCategoryDTO.getFullName();
    }

    public static List<ProductCategoryVO> bindData(List<ProProductCategoryDTO> infos) {
        List<ProductCategoryVO> models = new ArrayList<ProductCategoryVO>();
        for (ProProductCategoryDTO proProductCategoryDTO : infos) {
            ProductCategoryVO model = new ProductCategoryVO();
            model.copyFrom(proProductCategoryDTO);
            models.add(model);
        }
        return models;
    }

}
