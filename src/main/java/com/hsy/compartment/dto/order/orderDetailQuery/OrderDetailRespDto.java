package com.hsy.compartment.dto.order.orderDetailQuery;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

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
 * @date 2019年5月27日上午11:59:09
 * @description
 */
@Getter
@Setter
@ApiModel(description = "订单明细返回dto")
public class OrderDetailRespDto extends IdBean<Integer> {

	private static final long serialVersionUID = -151510323957303178L;

	@ApiModelProperty(value = "订单编号")
	private String orderSn;

	@ApiModelProperty(value = "订单类型")
	private Integer orderType;

	@ApiModelProperty(value = "订单状态")
	private Integer orderState;

	@ApiModelProperty(value = "下单时间")
	@JsonFormat(pattern = DateUtils.PATTERN_NORMAL, timezone = CommonConstant.TIMEZONE)
	private Date createTime;

	@ApiModelProperty(value = "订单总金额")
	private BigDecimal moneyOrder;

	@ApiModelProperty(value = "商品总金额")
	private BigDecimal moneyProduct;

	@ApiModelProperty(value = "物流费用")
	private BigDecimal moneyLogistics;

	@ApiModelProperty(value = "收货人")
	private String name;

	@ApiModelProperty(value = "收货人地址")
	private String address;

	@ApiModelProperty(value = "收货人电话")
	private String mobile;

	@ApiModelProperty(value = "收货人邮编")
	private String zipCode;

	@ApiModelProperty(value = "物流公司ID")
	private Integer logisticsId;

	@ApiModelProperty(value = "物流公司名称")
	private String logisticsName;

	@ApiModelProperty(value = "快递单号")
	private String logisticsNumber;

	@ApiModelProperty(value = "发货时间")
	@JsonFormat(pattern = DateUtils.PATTERN_NORMAL, timezone = CommonConstant.TIMEZONE)
	private Date deliverTime;

	@ApiModelProperty(value = "订单商品信息")
	List<OrderDetailProductRespDto> orderProducts;
}
