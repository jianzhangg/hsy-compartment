package com.hsy.compartment.dto.purchase.purchaseTakeOver;

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
 * @author 刘志恒
 * @date 2019年6月6日下午3:47
 * @description
 */
@Getter
@Setter
@ApiModel(description = "库存查询返回dto")
public class PurchaseStockRespDto extends IdBean<Integer> {

	private static final long serialVersionUID = 5483171681924750429L;

	@ApiModelProperty(value = "库存表id")
	private Integer id;
	
	@ApiModelProperty(value = "商品数量")
	private Integer number;
	
}
