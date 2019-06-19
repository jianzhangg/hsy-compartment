package com.hsy.compartment.sql.purchase.purchaseQuery;

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
 * @date 2019年6月5日下午5：40
 * @description 采购单列表查询
 */
@Getter
@Setter
public class PurchaseQuerySqlOutDto extends IdBean<Integer> {

	private static final long serialVersionUID = -8278118916942449129L;
	
	private Integer id;

	private String orderSn;
	
	private Integer orderState;
	
	private BigDecimal moneyOrder;
	
	private String name;
	
	private String mobile;
	
	private String addressInfo;
	
	private Integer auditState;
	
	@JsonFormat(pattern = DateUtils.PATTERN_NORMAL, timezone = CommonConstant.TIMEZONE)
	private Date createTime;

}
