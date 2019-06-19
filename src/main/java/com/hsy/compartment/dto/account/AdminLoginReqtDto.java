package com.hsy.compartment.dto.account;

import java.io.Serializable;

import com.hsy.core.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 张梓枫
 * @date 2019年5月22日下午1:36:07
 * @description
 */
@Data
@ApiModel(description = "登录请求dto")
public class AdminLoginReqtDto implements Serializable {

	private static final long serialVersionUID = 5809521850900440388L;

	@NotBlank(message = "用户登录名不能为空")
	@ApiModelProperty(value = "用户登录名")
	private String username;

	@NotBlank(message = "用户登录密码不能为空.")
	@ApiModelProperty(value = "用户密码")
	private String password;
}
