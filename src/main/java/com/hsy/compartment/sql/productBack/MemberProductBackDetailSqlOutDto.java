package com.hsy.compartment.sql.productBack;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 黄必诚
 * @date 2019/6/6 14:33
 * @description
 */
@Data
public class MemberProductBackDetailSqlOutDto implements Serializable{

    private static final long serialVersionUID = 3383799761141281515L;

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

    private String address;

    private String logistics_name;

    private String logistics_number;

    private String question;

    private String image;

    private String optName;

    private String adminOptName;

    private String rejectDesc;
}
