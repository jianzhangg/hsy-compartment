package com.hsy.compartment.dto.order.orderQuery;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 张梓枫
 * @date 2019年5月27日上午9:47:05
 * @description 订单列表查询请求dto
 */
@Data
@ApiModel(description = "订单列表查询请求dto")
public class OrderQueryReqtDto implements Serializable {

	private static final long serialVersionUID = -7861774769835642805L;

	@ApiModelProperty(value = "订单状态：1、未付款的订单；2、待确认的订单；3、待发货的订单；4、已发货的订单；5、已完成的订单；6、取消的订单；7待安装订单")
	private Integer orderState;
}
