package com.hsy.compartment.sql.purchase.purchaseTakeOver;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hsy.common.bean.IdBean;
import com.hsy.common.constant.CommonConstant;
import com.hsy.common.utils.DateUtils;

import lombok.Getter;
import lombok.Setter;

/**
 * @author 刘志恒
 * @date 2019年6月6日下午4：15
 * @description 库存查询返回dto
 */
@Getter
@Setter
public class PurchaseStockSqlOutDto extends IdBean<Integer> {

	private static final long serialVersionUID = -8278118916942449129L;
	
	private Integer id;

	private Integer number;

}
