package com.hsy.compartment.dto.purchase.purchaseTakeOver;

import java.io.Serializable;

import com.hsy.core.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 刘志恒
 * @date 2019年6月6日下午2:24
 * @description
 */
@Data
@ApiModel(description = "采购单更新请求dto")
public class PurchaseUpdateReqtDto implements Serializable {

	private static final long serialVersionUID = -4949745825057319230L;

	@NotNull(message = "id不能为空.")
	@ApiModelProperty(value = "采购单id", required = true)
	private Integer id;

}
