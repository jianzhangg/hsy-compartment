package com.hsy.compartment.dto.delivery.personnel.personnelSetAreas;

import java.io.Serializable;

import com.hsy.core.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 张梓枫
 * @date 2019年5月27日下午4:37:49
 * @description 配送人员负责区域请求dto
 */
@Data
@ApiModel(description = "配送人员负责区域请求dto")
public class PersonnelSetAreasReqtDto implements Serializable {

	private static final long serialVersionUID = 2011649268510250960L;

	@NotNull(message = "省id不能为空.")
	@ApiModelProperty(value = "省id", required = true)
	private Integer provinceId;

	@NotNull(message = "市id不能为空.")
	@ApiModelProperty(value = "市id", required = true)
	private Integer cityId;

	@NotNull(message = "区id不能为空.")
	@ApiModelProperty(value = "区id", required = true)
	private Integer areaId;

	@ApiModelProperty(value = "省名称")
	private String province;

	@ApiModelProperty(value = "市名称")
	private String city;

	@ApiModelProperty(value = "区名称")
	private String area;

}
