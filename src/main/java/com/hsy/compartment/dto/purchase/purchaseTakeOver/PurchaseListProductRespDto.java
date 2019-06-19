package com.hsy.compartment.dto.purchase.purchaseTakeOver;

import java.io.Serializable;
import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 刘志恒
 * @date 2019年6月6日下午3：12
 * @description
 */
@Data
@ApiModel(description = "采购单商品列表返回dto")
public class PurchaseListProductRespDto implements Serializable {

	private static final long serialVersionUID = -7296754350974609600L;

	@ApiModelProperty(value = "商家id")
	private Integer sellerId;

	@ApiModelProperty(value = "货品id")
	private Integer productGoodsId;
	
	@ApiModelProperty(value = "商品id")
	private Integer productId;

	@ApiModelProperty(value = "商品数量")
	private Integer number;

}
