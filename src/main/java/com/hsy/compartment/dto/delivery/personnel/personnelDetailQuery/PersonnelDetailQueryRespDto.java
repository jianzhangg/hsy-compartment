package com.hsy.compartment.dto.delivery.personnel.personnelDetailQuery;

import java.util.List;

import com.hsy.common.bean.IdBean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author 张梓枫
 * @date 2019年5月27日下午5:58:43
 * @description 
 */
@Getter
@Setter
@ApiModel(description = "配送人员明细信息查询返回dto")
public class PersonnelDetailQueryRespDto extends IdBean<Integer> {

	private static final long serialVersionUID = 7639331927586227069L;

	@ApiModelProperty(value = "配送人姓名")
	private String fullName;

	@ApiModelProperty(value = "配送人电话号码")
	private String mobilePhone;

	@ApiModelProperty(value = "配送人员负责区域信息")
	private List<PersonnelAreasQueryRespDto> personnelAreas;

}
