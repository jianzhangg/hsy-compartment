package com.hsy.compartment.sql.delivery.personnel.personnelList;

import com.hsy.common.bean.IdBean;

import lombok.Getter;
import lombok.Setter;

/**
 * @author 张梓枫
 * @date 2019年5月27日下午2:37:24
 * @description 配送人员列表查询sql输出dto
 */
@Getter
@Setter
public class PersonnelListQuerySqlOutDto extends IdBean<Integer> {

	private static final long serialVersionUID = 5070687112164074733L;

	/**
	 * 配送人姓名
	 */
	private String fullName;

	/**
	 * 配送人电话号码
	 */
	private String mobilePhone;
}
