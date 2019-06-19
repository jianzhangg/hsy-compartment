package com.hsy.compartment.dto.purchase.purchaseTakeOver;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 刘志恒
 * @date 2019年6月6日下午3:40
 * @description
 */
@Data
@ApiModel(description = "库存表查询请求dto")
public class PurchaseStockReqtDto implements Serializable {

	private static final long serialVersionUID = -1662672999895416224L;

	@ApiModelProperty(value = "商家id")
	private Integer sellerId;
	
	@ApiModelProperty(value = "货品id")
	private Integer productGoodsId;

}
