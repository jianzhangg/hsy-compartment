package com.hsy.compartment.dto.order.orderDetailQuery;

import java.io.Serializable;
import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 张梓枫
 * @date 2019年5月27日下午1:36:12
 * @description
 */
@Data
@ApiModel(description = "订单商品明信息返回dto")
public class OrderDetailProductRespDto implements Serializable {

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

	@ApiModelProperty(value = "网单金额")
	private BigDecimal moneyAmount;

	@ApiModelProperty(value = "立减优惠金额和")
	private BigDecimal moneyActSingle;
}
