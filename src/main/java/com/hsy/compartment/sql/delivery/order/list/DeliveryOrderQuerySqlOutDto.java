package com.hsy.compartment.sql.delivery.order.list;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hsy.common.bean.IdBean;
import com.hsy.common.constant.CommonConstant;
import com.hsy.common.utils.DateUtils;

import lombok.Getter;
import lombok.Setter;

/**
 * @author 张梓枫
 * @date 2019年5月29日上午9:13:49
 * @description 配送单列表查询SQL输出dto
 */
@Getter
@Setter
public class DeliveryOrderQuerySqlOutDto extends IdBean<Integer> {

	private static final long serialVersionUID = -5944996753315869041L;

	/**
	 * 订单id
	 */
	private Integer orderId;

	/**
	 * 关联订单号
	 */
	private String orderSn;

	/**
	 * 配送单号
	 */
	private String deliveryOrderSn;

	/**
	 * 配送员id
	 */
	private Integer personnelId;

	/**
	 * 配送员姓名
	 */
	private String personnelName;

	/**
	 * 收货人姓名
	 */
	private String name;

	/**
	 * 收货人地址
	 */
	private String address;

	@JsonFormat(pattern = DateUtils.PATTERN_NORMAL, timezone = CommonConstant.TIMEZONE)
	private Date deliveryDate;

	/**
	 * 配送状态
	 */
	private Integer deliveryState;

	/**
	 * 配送单生成日期
	 */
	private Date createDate;
}
