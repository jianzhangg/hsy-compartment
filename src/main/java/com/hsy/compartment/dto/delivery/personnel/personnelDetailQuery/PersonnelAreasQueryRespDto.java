package com.hsy.compartment.dto.delivery.personnel.personnelDetailQuery;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 张梓枫
 * @date 2019年5月27日下午6:00:16
 * @description
 */
@Data
@ApiModel(description = "配送人员负责区域查询返回dto")
public class PersonnelAreasQueryRespDto implements Serializable {

	private static final long serialVersionUID = 3148020669690167212L;

	@ApiModelProperty(value = "负责区域")
	private String addressAll;
}
