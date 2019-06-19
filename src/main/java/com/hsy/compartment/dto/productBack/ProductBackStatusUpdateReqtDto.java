package com.hsy.compartment.dto.productBack;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 黄必诚
 * @date 2019/6/6 15:13
 * @description
 */
@Data
public class ProductBackStatusUpdateReqtDto implements Serializable{

    private static final long serialVersionUID = -9033544381686019670L;

    @ApiModelProperty(value = "主键id")
    private Integer id;

    @ApiModelProperty(value = "退货状态：1、未处理；2、审核通过；3、用户发货，4、店铺收货；5、不予处理；6、审核不通过；7、不予处理驳回")
    private Integer stateReturn;

    @ApiModelProperty(value = "审核不通过时，填写不通过原因")
    private String remark;
}
