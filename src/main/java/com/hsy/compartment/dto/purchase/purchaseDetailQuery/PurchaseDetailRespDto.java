package com.hsy.compartment.dto.purchase.purchaseDetailQuery;

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
 * @author 刘志恒
 * @date 2019年6月6日上午9:16
 * @description 
 */
@Getter
@Setter
@ApiModel(description = "采购单明细返回dto")
public class PurchaseDetailRespDto extends IdBean<Integer> {

	private static final long serialVersionUID = 7639331927586227069L;

	@ApiModelProperty(value = "采购单id")
	private Integer id;

	@ApiModelProperty(value = "订单号")
	private String orderSn;
	
	@ApiModelProperty(value = "订单状态：3、待发货的订单；4、已发货的订单；5、已完成的订单；6、取消的订单")
	private Integer orderState;
	
	@ApiModelProperty(value = "订单总金额")
	private BigDecimal moneyOrder;
	
	@ApiModelProperty(value = "收货人")
	private String name;
	
	@ApiModelProperty(value = "收货人电话")
	private String mobile;
	
	@ApiModelProperty(value = "收货人地址")
	private String addressInfo;
	
	@ApiModelProperty(value = "审核状态：1审核通过，2审核不通过")
	private Integer auditState;
	
	@ApiModelProperty(value = "下单时间")
	@JsonFormat(pattern = DateUtils.PATTERN_NORMAL, timezone = CommonConstant.TIMEZONE)
	private Date createTime;
	
	@ApiModelProperty(value = "发货时间")
	@JsonFormat(pattern = DateUtils.PATTERN_NORMAL, timezone = CommonConstant.TIMEZONE)
	private Date deliverTime;
	
	@ApiModelProperty(value = "订单备注")
	private String remark;
	
	@ApiModelProperty(value = "订单完成时间")
	@JsonFormat(pattern = DateUtils.PATTERN_NORMAL, timezone = CommonConstant.TIMEZONE)
	private Date finishTime;
	
	@ApiModelProperty(value = "物流公司")
	private String logisticsName;
	
	@ApiModelProperty(value = "快递单号")
	private String logisticsNumber;
	
	@ApiModelProperty(value = "采购单商品信息")
	List<PurchaseDetailProductRespDto> purchaseProducts;
	
}
