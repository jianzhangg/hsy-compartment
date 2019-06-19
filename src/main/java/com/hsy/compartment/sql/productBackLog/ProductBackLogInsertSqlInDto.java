package com.hsy.compartment.sql.productBackLog;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 黄必诚
 * @date 2019/6/6 15:50
 * @description
 */
@Data
public class ProductBackLogInsertSqlInDto implements Serializable{

    private static final long serialVersionUID = 833799401419869195L;

    private Integer operatingId;

    private String operatingName;

    private Integer memberProductBackId;

    private String content;

    private Date createTime;
}
