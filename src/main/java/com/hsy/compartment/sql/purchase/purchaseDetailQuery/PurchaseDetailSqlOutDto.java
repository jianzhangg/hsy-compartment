package com.hsy.compartment.sql.purchase.purchaseDetailQuery;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hsy.common.bean.IdBean;
import com.hsy.common.constant.CommonConstant;
import com.hsy.common.utils.DateUtils;

import lombok.Getter;
import lombok.Setter;

/**
 * @author 刘志恒
 * @date 2019年6月6日上午9:35
 * @description 采购单明细查询
 */
@Getter
@Setter
public class PurchaseDetailSqlOutDto extends IdBean<Integer> {

	private static final long serialVersionUID = 1766011291916414052L;
	
	/**
	 * 采购单id
	 */
	private Integer id;

	/**
	 * 订单号
	 */
	private String orderSn;

	/**
	 * 订单状态
	 */
	private Integer orderState;
	
	/**
	 * 订单总金额
	 */
	private BigDecimal moneyOrder;
	
	/**
	 * 收货人
	 */
	private String name;
	
	/**
	 * 收货人电话
	 */
	private String mobile;
	
	/**
	 * 收货人地址
	 */
	private String addressInfo;
	
	/**
	 * 审核状态：1审核通过，2审核不通过
	 */
	private Integer auditState;

	/**
	 * 下单时间
	 */
	@JsonFormat(pattern = DateUtils.PATTERN_NORMAL, timezone = CommonConstant.TIMEZONE)
	private Date createTime;

	/**
	 * 发货时间
	 */
	@JsonFormat(pattern = DateUtils.PATTERN_NORMAL, timezone = CommonConstant.TIMEZONE)
	private Date deliverTime;

	/**
	 * 订单备注
	 */
	private String remark;

	/**
	 * 订单完成时间
	 */
	@JsonFormat(pattern = DateUtils.PATTERN_NORMAL, timezone = CommonConstant.TIMEZONE)
	private Date finishTime;

	/**
	 * 物流公司
	 */
	private String logisticsName;

	/**
	 * 快递单号
	 */
	private String logisticsNumber;

	
}
