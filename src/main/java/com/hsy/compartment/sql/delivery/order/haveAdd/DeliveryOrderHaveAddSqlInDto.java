package com.hsy.compartment.sql.delivery.order.haveAdd;

import java.util.Date;

import com.hsy.mybatis.bean.SqlInsertInputBean;

import lombok.Getter;
import lombok.Setter;

/**
 * @author 张梓枫
 * @date 2019年5月29日上午11:50:37
 * @description 配送单新增SQL输入dto
 */
@Getter
@Setter
public class DeliveryOrderHaveAddSqlInDto extends SqlInsertInputBean {

	private static final long serialVersionUID = 1335542316279002213L;

	private Integer orderId;

	private String deliveryOrderSn;

	private Integer personnelId;

	private Date deliveryDate;

	private Integer deliveryState;

	private Integer sellerId;

	private Integer deliveryType;
}
