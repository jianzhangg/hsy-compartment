package com.hsy.compartment.dto.order.orderQuery;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hsy.common.bean.IdBean;
import com.hsy.common.constant.CommonConstant;
import com.hsy.common.utils.DateUtils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author 张梓枫
 * @date 2019年5月27日上午9:48:39
 * @description 订单列表查询返回dto
 */
@Getter
@Setter
@ApiModel(description = "订单列表查询返回dto")
public class OrderQueryRespDto extends IdBean<Integer> {

	private static final long serialVersionUID = -8270767461948735649L;

	@ApiModelProperty(value = "订单编号")
	private String orderSn;

	@ApiModelProperty(value = "订单类型：1、普通订单，2、限时抢购订单，3、团购订单，4、竞价定金订单，5、竞价尾款订单，6、积分商城订单")
	private Integer orderType;

	@ApiModelProperty(value = "商家ID")
	private Integer sellerId;

	@ApiModelProperty(value = "买家id")
	private Integer memberId;

	@ApiModelProperty(value = "买家账号")
	private String memberName;

	@ApiModelProperty(value = "买家姓名")
	private String nickName;

	@ApiModelProperty(value = "订单状态：1、未付款的订单；2、待确认的订单；3、待发货的订单；4、已发货的订单；5、已完成的订单；6、取消的订单；7待安装订单")
	private Integer orderState;

	@ApiModelProperty(value = "订单支付时间")
	@JsonFormat(pattern = DateUtils.PATTERN_NORMAL, timezone = CommonConstant.TIMEZONE)
	private Date payTime;

	@ApiModelProperty(value = "订单支付状态")
	private Integer paymentStatus;

	@ApiModelProperty(value = "订单总金额")
	private BigDecimal moneyOrder;

	@ApiModelProperty(value = "下单时间")
	@JsonFormat(pattern = DateUtils.PATTERN_NORMAL, timezone = CommonConstant.TIMEZONE)
	private Date createTime;
}
