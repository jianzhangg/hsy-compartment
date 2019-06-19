package com.hsy.compartment.dto.delivery.personnel.personnelList;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 张梓枫
 * @date 2019年5月27日下午2:48:21
 * @description
 */
@Data
@ApiModel(description = "配送人员列表查询请求dto")
public class PersonnelListQueryReqtDto implements Serializable {

	private static final long serialVersionUID = -1662672999895416224L;

	@ApiModelProperty(value = "配送人姓名")
	private String fullName;

}
