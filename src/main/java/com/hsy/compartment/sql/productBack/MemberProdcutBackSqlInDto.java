package com.hsy.compartment.sql.productBack;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 黄必诚
 * @date 2019/6/6 9:14
 * @description
 */
@Data
public class MemberProdcutBackSqlInDto implements Serializable{

    private static final long serialVersionUID = 6696118184744203171L;

    private String orderSn;

    private String productName;

    private String memberName;

    private Integer stateReturn;

    private Integer sellerId;
}
