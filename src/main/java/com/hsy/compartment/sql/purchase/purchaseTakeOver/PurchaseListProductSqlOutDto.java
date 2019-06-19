package com.hsy.compartment.sql.purchase.purchaseTakeOver;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

/**
 * @author 刘志恒
 * @date 2019年6月6日下午3：15
 * @description 采购单商品列表
 */
@Data
public class PurchaseListProductSqlOutDto implements Serializable {

	private static final long serialVersionUID = -3326640543916701896L;

	/**
	 * 商家id
	 */
	private Integer sellerId;

	/**
	 * 货品id
	 */
	private Integer productGoodsId;
	
	/**
	 * 商品id
	 */
	private Integer productId;

	/**
	 * 商品数量
	 */
	private Integer number;

}
