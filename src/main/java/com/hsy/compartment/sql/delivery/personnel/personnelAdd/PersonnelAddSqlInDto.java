package com.hsy.compartment.sql.delivery.personnel.personnelAdd;

import com.hsy.mybatis.bean.SqlInsertInputBean;

import lombok.Getter;
import lombok.Setter;

/**
 * @author 张梓枫
 * @date 2019年5月27日下午3:11:21
 * @description 配送人员新增sql输入dto
 */
@Getter
@Setter
public class PersonnelAddSqlInDto extends SqlInsertInputBean {

	private static final long serialVersionUID = -2579474311356240800L;

	private Integer sellerId;

	private String fullName;

	private String mobilePhone;

}
