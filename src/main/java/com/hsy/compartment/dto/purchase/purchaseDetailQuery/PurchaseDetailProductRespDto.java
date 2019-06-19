package com.hsy.compartment.dto.purchase.purchaseDetailQuery;

import java.io.Serializable;
import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 刘志恒
 * @date 2019年6月6日上午9:29
 * @description
 */
@Data
@ApiModel(description = "采购单商品明细返回dto")
public class PurchaseDetailProductRespDto implements Serializable {

	private static final long serialVersionUID = -7296754350974609600L;

	@ApiModelProperty(value = "商品id")
	private Integer productId;

	@ApiModelProperty(value = "货品id")
	private Integer productGoodsId;

	@ApiModelProperty(value = "规格信息")
	private String specInfo;

	@ApiModelProperty(value = "商品名称")
	private String productName;

	@ApiModelProperty(value = "商品sku")
	private String productSku;

	@ApiModelProperty(value = "商品单价")
	private BigDecimal moneyPrice;

	@ApiModelProperty(value = "商品数量")
	private Integer number;

}
