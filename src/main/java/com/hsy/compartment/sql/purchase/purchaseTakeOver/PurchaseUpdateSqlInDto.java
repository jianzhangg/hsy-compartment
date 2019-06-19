package com.hsy.compartment.sql.purchase.purchaseTakeOver;

import com.hsy.mybatis.bean.SqlUpdateInputBean;

import lombok.Getter;
import lombok.Setter;

/**
 * @author 刘志恒
 * @date 2019年6月6日下午2:27
 * @description 采购单信息更新SQL输入dto
 */
@Getter
@Setter
public class PurchaseUpdateSqlInDto extends SqlUpdateInputBean {

	private static final long serialVersionUID = 4071907823185676755L;

	private Integer id;
	
}
