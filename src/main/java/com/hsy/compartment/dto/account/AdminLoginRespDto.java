package com.hsy.compartment.dto.account;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 张梓枫
 * @date 2019年5月22日下午1:37:14
 * @description
 */
@Data
@ApiModel(description = "用户任何信息")
public class AdminLoginRespDto implements Serializable {

	private static final long serialVersionUID = 5123062012461951208L;

	@ApiModelProperty(value = "用户id")
	private Integer id;

	@ApiModelProperty(value = "用户名称")
	private String username;

	@ApiModelProperty(value = "用户认证token")
	private String token;
}
