package com.hsy.compartment.sql.purchase.purchaseQuery;

import java.io.Serializable;

import lombok.Data;

/**
 * @author 刘志恒
 * @date 2019年6月5日下午5：39
 * @description 采购单列表查询sql输入dto
 */
@Data
public class PurchaseQuerySqlInDto implements Serializable {

	private static final long serialVersionUID = -1278504501214624763L;

	private String orderSn;
	
	private Integer orderState;

	private Integer auditState;
	
	private Integer sellerId;
	
}
