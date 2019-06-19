package com.hsy.compartment.sql.order.OrderQuery;

import java.io.Serializable;

import lombok.Data;

/**
 * @author 张梓枫
 * @date 2019年5月27日上午9:36:11
 * @description 订单列表查询sql输入dto
 */
@Data
public class OrderQuerySqlInDto implements Serializable {

	private static final long serialVersionUID = -1278504501214624763L;

	private Integer orderState;

	private Integer sellerId;
}
