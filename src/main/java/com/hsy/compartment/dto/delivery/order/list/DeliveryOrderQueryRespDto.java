package com.hsy.compartment.dto.delivery.order.list;

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
 * @date 2019年5月29日上午10:05:58
 * @description
 */
@Getter
@Setter
@ApiModel(description = "配送单列表查询返回dto")
public class DeliveryOrderQueryRespDto extends IdBean<Integer> {

	private static final long serialVersionUID = -7240787282192407964L;

	@ApiModelProperty(value = "订单id")
	private Integer orderId;

	@ApiModelProperty(value = "关联订单号")
	private String orderSn;

	@ApiModelProperty(value = "配送单号")
	private String deliveryOrderSn;

	@ApiModelProperty(value = "配送员id")
	private Integer personnelId;

	@ApiModelProperty(value = "配送员姓名")
	private String personnelName;

	@ApiModelProperty(value = "收货人姓名")
	private String name;

	@ApiModelProperty(value = "收货人详细地址")
	private String address;

	@ApiModelProperty(value = "配送日期")
	@JsonFormat(pattern = DateUtils.PATTERN_NORMAL, timezone = CommonConstant.TIMEZONE)
	private Date deliveryDate;

	@ApiModelProperty(value = "配送状态，1-待配送，2-配送中，3-配送完成")
	private Integer deliveryState;

	@ApiModelProperty(value = "配送单生成日期")
	@JsonFormat(pattern = DateUtils.PATTERN_NORMAL, timezone = CommonConstant.TIMEZONE)
	private Date createDate;
}
