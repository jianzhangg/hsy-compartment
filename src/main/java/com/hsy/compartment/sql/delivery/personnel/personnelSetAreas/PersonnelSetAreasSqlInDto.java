package com.hsy.compartment.sql.delivery.personnel.personnelSetAreas;

import com.hsy.mybatis.bean.SqlInsertInputBean;

import lombok.Getter;
import lombok.Setter;

/**
 * @author 张梓枫
 * @date 2019年5月27日下午4:32:58
 * @description 设置配送人员负责区域
 */
@Getter
@Setter
public class PersonnelSetAreasSqlInDto extends SqlInsertInputBean {

	private static final long serialVersionUID = 7740220635904791459L;

	private Integer personnelId;

	private Integer provinceId;

	private Integer cityId;

	private Integer areaId;

	private String addressAll;

}
