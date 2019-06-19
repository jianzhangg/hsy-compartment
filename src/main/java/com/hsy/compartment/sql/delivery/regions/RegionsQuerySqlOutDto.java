package com.hsy.compartment.sql.delivery.regions;

import com.hsy.common.bean.IdBean;

import lombok.Getter;
import lombok.Setter;

/**
 * @author 张梓枫
 * @date 2019年5月28日上午10:39:42
 * @description 区域查询sql输出dto
 */
@Getter
@Setter
public class RegionsQuerySqlOutDto extends IdBean<Integer> {

	private static final long serialVersionUID = 3985295369766450768L;

	private String regionName;
}
