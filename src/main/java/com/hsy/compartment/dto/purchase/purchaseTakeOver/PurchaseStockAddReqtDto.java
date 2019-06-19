package com.hsy.compartment.dto.purchase.purchaseTakeOver;

import java.io.Serializable;

import com.hsy.core.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 刘志恒
 * @date 2019年6月10日上午9:39
 * @description
 */
@Data
@ApiModel(description = "配送人员新增请求dto")
public class PurchaseStockAddReqtDto implements Serializable {

	private static final long serialVersionUID = -1690118335351719129L;

	@ApiModelProperty(value = "商家id")
	private Integer sellerId;

	@ApiModelProperty(value = "货品id")
	private Integer productGoodsId;
	
	@ApiModelProperty(value = "商品id")
	private Integer productId;

	@ApiModelProperty(value = "商品数量")
	private Integer number;
}
