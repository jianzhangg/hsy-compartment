package com.hsy.compartment.sql.delivery.personnel.personnelDetailQuery;

import java.io.Serializable;

import lombok.Data;

/**
 * @author 张梓枫
 * @date 2019年5月27日下午5:55:11
 * @description 配送人员负责的区域查询sql输出dto
 */
@Data
public class PersonnelAreasQuerySqlOutDto implements Serializable {

	private static final long serialVersionUID = 4404631866415418373L;

	private String addressAll;
}
