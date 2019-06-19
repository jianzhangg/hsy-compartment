package com.hsy.compartment.dto.delivery.personnel.personnelSetAreas;

import java.io.Serializable;
import java.util.List;

import com.hsy.core.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 张梓枫
 * @date 2019年5月27日下午4:52:26
 * @description
 */
@Data
@ApiModel(description = "配送人员负责区域请求dto")
public class PersonnelSetReqtDto implements Serializable {

	private static final long serialVersionUID = -7513370009181491151L;

	@NotNull(message = "配送人员id不能为空.")
	@ApiModelProperty(value = "配送人员id", required = true)
	private Integer personnelId;

	@NotNull(message = "配送人员负责区域")
	@ApiModelProperty(value = "配送人员负责区域", required = true)
	private List<PersonnelSetAreasReqtDto> personnelAreas;
}
