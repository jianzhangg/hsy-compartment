package com.hsy.compartment.sql.order.OrderQuery;

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
 * @date 2019年5月27日上午9:24:19
 * @description 订单列表查询
 */
@Getter
@Setter
public class OrderQuerySqlOutDto extends IdBean<Integer> {

	private static final long serialVersionUID = -8278118916942449129L;

	private String orderSn;

	private Integer orderType;

	private Integer sellerId;

	private Integer memberId;

	private String memberName;

	private String nickName;

	private Integer orderState;

	@JsonFormat(pattern = DateUtils.PATTERN_NORMAL, timezone = CommonConstant.TIMEZONE)
	private Date payTime;

	private Integer paymentStatus;

	private BigDecimal moneyOrder;

	@JsonFormat(pattern = DateUtils.PATTERN_NORMAL, timezone = CommonConstant.TIMEZONE)
	private Date createTime;
}
