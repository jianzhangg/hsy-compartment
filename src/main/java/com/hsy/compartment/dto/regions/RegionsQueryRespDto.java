package com.hsy.compartment.dto.regions;

import com.hsy.common.bean.IdBean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author 张梓枫
 * @date 2019年5月28日上午10:45:46
 * @description
 */
@Getter
@Setter
@ApiModel(description = "区域查询返回dto")
public class RegionsQueryRespDto extends IdBean<Integer> {

	private static final long serialVersionUID = -3091805782516425201L;

	@ApiModelProperty(value = "区域名称")
	private String regionName;
}
