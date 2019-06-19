package com.hsy.compartment.dto.regions;

import java.io.Serializable;

import com.hsy.core.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 张梓枫
 * @date 2019年5月28日上午10:45:38
 * @description
 */
@Data
@ApiModel(description = "区域查询请求dto")
public class RegionsQueryReqtDto implements Serializable {

	private static final long serialVersionUID = 6975480792811605187L;

	@NotNull(message = "区域上级id不能为空.")
	@ApiModelProperty(value = "区域上级id", required = true)
	private Integer parentId;
}
