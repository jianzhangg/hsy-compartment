package com.hsy.compartment.sql.productBack;

import io.swagger.models.auth.In;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 黄必诚
 * @date 2019/6/6 9:10
 * @description 对货列表查询dto
 */
@Data
public class MemberProdcutBackSqlOutDto implements Serializable{

    private static final long serialVersionUID = -538081053173541718L;

    private Integer id;

    private String orderSn;

    private Integer orderProductId;

    private Integer productId;

    private String productName;

    private String memberName;

    private Integer number;

    private BigDecimal backMoney;

    private Integer stateReturn;

    private Integer stateMoney;

    private Date backMoneyTime;

    private Date createTime;
}
