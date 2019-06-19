package com.hsy.compartment.dto.productBack;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 黄必诚
 * @date 2019/6/6 10:23
 * @description
 */
@Data
@ApiModel(description = "退货列表查询请求dto")
public class MemberProductBackReqtDto implements Serializable{

    private static final long serialVersionUID = -2990996075720306243L;

    @ApiModelProperty(value = "订单号,模糊查询")
    private String orderSn;

    @ApiModelProperty(value = "商品名称,模糊查询")
    private String productName;

    @ApiModelProperty(value = "退款人姓名,模糊查询")
    private String memberName;

    @ApiModelProperty(value = "退货状态：1、未处理；2、审核通过；3、用户发货，4、店铺收货；5、不予处理；6、审核不通过；7、不予处理驳回")
    private Integer stateReturn;
}
