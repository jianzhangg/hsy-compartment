package com.hsy.compartment.sql.delivery.personnel.personnelDetailQuery;

import com.hsy.common.bean.IdBean;

import lombok.Getter;
import lombok.Setter;

/**
 * @author 张梓枫
 * @date 2019年5月27日下午5:52:52
 * @description 配送人员明细信息查询sql输出dto
 */
@Getter
@Setter
public class PersonnelDetailQuerySqlOutDto extends IdBean<Integer> {

	private static final long serialVersionUID = -4881070310347850791L;

	/**
	 * 配送人姓名
	 */
	private String fullName;

	/**
	 * 配送人电话号码
	 */
	private String mobilePhone;
}
