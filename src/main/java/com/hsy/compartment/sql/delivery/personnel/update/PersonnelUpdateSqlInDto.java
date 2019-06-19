package com.hsy.compartment.sql.delivery.personnel.update;

import com.hsy.mybatis.bean.SqlUpdateInputBean;

import lombok.Getter;
import lombok.Setter;

/**
 * @author 张梓枫
 * @date 2019年5月29日上午10:27:59
 * @description 配送人员信息更新SQL输入dto
 */
@Getter
@Setter
public class PersonnelUpdateSqlInDto extends SqlUpdateInputBean {

	private static final long serialVersionUID = 4071907823185676755L;

	private String fullName;

	private String mobilePhone;
}
