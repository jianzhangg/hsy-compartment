package com.hsy.compartment.dto.delivery.order.list;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 张梓枫
 * @date 2019年5月29日上午10:04:12
 * @description
 */
@Data
@ApiModel(description = "配送单列表查询请求dto")
public class DeliveryOrderQueryReqtDto implements Serializable {

	private static final long serialVersionUID = 3001220556254393485L;

	@ApiModelProperty(value = "关联订单号")
	private String orderSn;

	@ApiModelProperty(value = "配送单号")
	private String deliveryOrderSn;

	@ApiModelProperty(value = "配送员姓名")
	private String personnelName;

	@ApiModelProperty(value = " 配送状态")
	private Integer deliveryState;
}
