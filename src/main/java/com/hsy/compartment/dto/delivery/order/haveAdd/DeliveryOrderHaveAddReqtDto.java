package com.hsy.compartment.dto.delivery.order.haveAdd;

import java.io.Serializable;
import java.util.List;

import com.hsy.core.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 张梓枫
 * @date 2019年5月29日下午1:59:14
 * @description
 */
@Data
@ApiModel(description = "配送单新增SQL输入dto")
public class DeliveryOrderHaveAddReqtDto implements Serializable {

	private static final long serialVersionUID = 5959201851568115989L;

	@NotNull(message = "配送员ID不能为空.")
	@ApiModelProperty(value = "配送员ID", required = true)
	private Integer personnelId;

	@NotNull(message = "订单id不能为空")
	@ApiModelProperty(value = "订单id数组", required = true)
	private List<Integer> orderIds;
}
