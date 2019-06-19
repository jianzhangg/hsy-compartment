package com.hsy.compartment.sql.purchase.purchaseDetailQuery;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

/**
 * @author 刘志恒
 * @date 2019年6月6日上午9:39
 * @description 采购单商品明细
 */
@Data
public class PurchaseDetailProductSqlOutDto implements Serializable {

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

}
