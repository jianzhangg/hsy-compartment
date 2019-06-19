package com.hsy.compartment.sql.purchase.purchaseTakeOver;

import java.util.Date;

import com.hsy.mybatis.bean.SqlInsertInputBean;

import lombok.Getter;
import lombok.Setter;

/**
 * @author 刘志恒
 * @date 2019年6月10日上午9:29
 * @description 商品库存新增sql输入dto
 */
@Getter
@Setter
public class PurchaseStockAddSqlInDto extends SqlInsertInputBean {

	private static final long serialVersionUID = -2579474311356240800L;

	private Integer sellerId;

	private Integer productGoodsId;

	private Integer productId;
	
	private Integer productStock;
	
	private Integer productStockWarning;
	
	private Date createTime;

}
