package com.hsy.compartment.dto.delivery.personnel.delete;

import java.io.Serializable;

import com.hsy.core.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 张梓枫
 * @date 2019年5月29日上午11:09:13
 * @description
 */
@Data
@ApiModel(description = "配送人员删除请求dto")
public class PersonnelDeleteReqtDto implements Serializable {

	private static final long serialVersionUID = 1662920538297602439L;

	@NotNull(message = "id不能为空.")
	@ApiModelProperty(value = "配送人员id")
	private Integer id;
}
