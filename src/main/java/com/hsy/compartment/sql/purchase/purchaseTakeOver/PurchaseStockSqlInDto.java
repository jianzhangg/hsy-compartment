package com.hsy.compartment.sql.purchase.purchaseTakeOver;

import java.io.Serializable;

import lombok.Data;

/**
 * @author 刘志恒
 * @date 2019年6月6日下午4：11
 * @description 库存表查询请求dto
 */
@Data
public class PurchaseStockSqlInDto implements Serializable {

	private static final long serialVersionUID = -1278504501214624763L;

	private Integer sellerId;
	
	private Integer productGoodsId;
	
}
