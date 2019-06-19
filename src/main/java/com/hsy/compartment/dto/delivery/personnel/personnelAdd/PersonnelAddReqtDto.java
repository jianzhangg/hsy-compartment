package com.hsy.compartment.dto.delivery.personnel.personnelAdd;

import java.io.Serializable;

import com.hsy.core.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 张梓枫
 * @date 2019年5月27日下午4:04:04
 * @description
 */
@Data
@ApiModel(description = "配送人员新增请求dto")
public class PersonnelAddReqtDto implements Serializable {

	private static final long serialVersionUID = -1690118335351719129L;

	@NotBlank(message = "配送人员姓名不能为空.")
	@ApiModelProperty(value = "配送人员姓名")
	private String fullName;

	@NotBlank(message = "配送人员电话号码不能为空.")
	@ApiModelProperty(value = "配送人员电话号码")
	private String mobilePhone;
}
