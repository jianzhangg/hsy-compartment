package com.hsy.compartment.dto.purchase.purchaseQuery;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 刘志恒
 * @date 2019年6月5日下午5:30
 * @description
 */
@Data
@ApiModel(description = "采购单列表查询请求dto")
public class PurchaseQueryReqtDto implements Serializable {

	private static final long serialVersionUID = -1662672999895416224L;

	@ApiModelProperty(value = "订单号")
	private String orderSn;
	
	@ApiModelProperty(value = "订单状态：3、待发货的订单；4、已发货的订单；5、已完成的订单；6、取消的订单")
	private Integer orderState;
	
	@ApiModelProperty(value = "审核状态：1审核通过，2审核不通过")
	private Integer auditState;

}
