package com.hsy.compartment.sql.delivery.order.list;

import java.io.Serializable;

import lombok.Data;

/**
 * @author 张梓枫
 * @date 2019年5月29日上午9:40:17
 * @description 配送单列表查询sql输入dto
 */
@Data
public class DeliveryOrderQuerySqlInDto implements Serializable {

	private static final long serialVersionUID = 2318139487913670463L;

	/**
	 * 分仓id
	 */
	private Integer sellerId;

	/**
	 * 关联订单号
	 */
	private String orderSn;

	/**
	 * 配送单号
	 */
	private String deliveryOrderSn;

	/**
	 * 配送员姓名
	 */
	private String personnelName;

	/**
	 * 配送状态
	 */
	private Integer deliveryState;
}
