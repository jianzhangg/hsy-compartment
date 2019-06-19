package com.hsy.compartment.sql.productBack;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 黄必诚
 * @date 2019/6/6 15:05
 * @description
 */
@Data
public class ProductBackStatusUpdateSqlInDto implements Serializable{

    private static final long serialVersionUID = -9131849929359931639L;

    private Integer id;

    private Integer stateReturn;

    private String remark;
}
