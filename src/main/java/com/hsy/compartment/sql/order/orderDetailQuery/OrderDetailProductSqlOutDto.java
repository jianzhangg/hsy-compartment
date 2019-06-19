package com.hsy.compartment.sql.order.orderDetailQuery;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

/**
 * @author 张梓枫
 * @date 2019年5月27日上午11:31:49
 * @description 订单明细商品信息
 */
@Data
public class OrderDetailProductSqlOutDto implements Serializable {

	private static final long serialVersionUID = -3326640543916701896L;

	/**
	 * 商品id
	 */
	private Integer productId;

	/**
	 * 货品id
	 */
	private Integer productGoodsId;

	/**
	 * 规格信息
	 */
	private String specInfo;

	/**
	 * 商品名称
	 */
	private String productName;

	/**
	 * 商品sku
	 */
	private String productSku;

	/**
	 * 商品单价
	 */
	private BigDecimal moneyPrice;

	/**
	 * 商品数量
	 */
	private Integer number;

	/**
	 * 网单金额
	 */
	private BigDecimal moneyAmount;

	/**
	 * 立减优惠金额和
	 */
	private BigDecimal moneyActSingle;
}
