package com.hsy.compartment.dto.delivery.personnel.update;

import java.io.Serializable;

import com.hsy.core.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 张梓枫
 * @date 2019年5月29日上午10:37:39
 * @description
 */
@Data
@ApiModel(description = "配送人员更新请求dto")
public class PersonnelUpdateReqtDto implements Serializable {

	private static final long serialVersionUID = -4949745825057319230L;

	@NotNull(message = "id不能为空.")
	@ApiModelProperty(value = "配送人员id", required = true)
	private Integer id;

	@ApiModelProperty(value = "配送人员姓名")
	private String fullName;

	@ApiModelProperty(value = "配送人员电话号码")
	private String mobilePhone;
}
