package com.hsy.compartment.dto.delivery.personnel.personnelList;

import com.hsy.common.bean.IdBean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author 张梓枫
 * @date 2019年5月27日下午2:49:26
 * @description
 */
@Getter
@Setter
@ApiModel(description = "配送人员列表查询返回dto")
public class PersonnelListQueryRespDto extends IdBean<Integer> {

	private static final long serialVersionUID = 5483171681924750429L;

	@ApiModelProperty(value = "配送人姓名")
	private String fullName;

	@ApiModelProperty(value = " 配送人电话号码")
	private String mobilePhone;
}
