package com.hsy.compartment.sql.delivery.personnel.personnelList;

import java.io.Serializable;

import lombok.Data;

/**
 * @author 张梓枫
 * @date 2019年5月27日下午2:35:45
 * @description 配送人员列表查询sql输入dto
 */
@Data
public class PersonnelListQuerySqlInDto implements Serializable {

	private static final long serialVersionUID = 3093487809790293143L;

	/**
	 * 分仓id
	 */
	private Integer sellerId;

	/**
	 * 配送人员姓名
	 */
	private String fullName;

}
