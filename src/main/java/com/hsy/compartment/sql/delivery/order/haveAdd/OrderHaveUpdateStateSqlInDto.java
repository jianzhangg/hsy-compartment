package com.hsy.compartment.sql.delivery.order.haveAdd;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * @author 张梓枫
 * @date 2019年5月30日下午2:58:35
 * @description 生成自有物流配送单时修改订单状态SQL输入dto
 */
@Data
public class OrderHaveUpdateStateSqlInDto implements Serializable {

	private static final long serialVersionUID = -3867309654396408807L;

	private Integer orderState;

	private Date deliverTime;

	private List<Integer> orderIds;
}
