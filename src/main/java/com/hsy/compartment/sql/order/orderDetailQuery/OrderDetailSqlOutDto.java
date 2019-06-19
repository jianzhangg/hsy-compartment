package com.hsy.compartment.sql.order.orderDetailQuery;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hsy.common.bean.IdBean;
import com.hsy.common.constant.CommonConstant;
import com.hsy.common.utils.DateUtils;

import lombok.Getter;
import lombok.Setter;

/**
 * @author 张梓枫
 * @date 2019年5月27日上午11:14:45
 * @description 订单明细查询
 */
@Getter
@Setter
public class OrderDetailSqlOutDto extends IdBean<Integer> {

	private static final long serialVersionUID = 1766011291916414052L;

	/**
	 * 订单编号
	 */
	private String orderSn;

	/**
	 * 订单类型
	 */
	private Integer orderType;

	/**
	 * 订单状态
	 */
	private Integer orderState;

	/**
	 * 下单时间
	 */
	@JsonFormat(pattern = DateUtils.PATTERN_NORMAL, timezone = CommonConstant.TIMEZONE)
	private Date createTime;

	/**
	 * 订单总金额
	 */
	private BigDecimal moneyOrder;

	/**
	 * 商品总金额
	 */
	private BigDecimal moneyProduct;

	/**
	 * 物流费用
	 */
	private BigDecimal moneyLogistics;

	/**
	 * 收货人
	 */
	private String name;

	/**
	 * 收货人地址
	 */
	private String address;

	/**
	 * 收货人电话
	 */
	private String mobile;

	/**
	 * 收货人邮编
	 */
	private String zipCode;

	/**
	 * 物流公司ID
	 */
	private Integer logisticsId;

	/**
	 * 物流公司名称
	 */
	private String logisticsName;

	/**
	 * 快递单号
	 */
	private String logisticsNumber;

	/**
	 * 发货时间
	 */
	@JsonFormat(pattern = DateUtils.PATTERN_NORMAL, timezone = CommonConstant.TIMEZONE)
	private Date deliverTime;
}
