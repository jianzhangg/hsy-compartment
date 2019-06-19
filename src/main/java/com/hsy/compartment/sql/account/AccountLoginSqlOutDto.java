package com.hsy.compartment.sql.account;

import java.io.Serializable;

import lombok.Data;

/**
 * @author 张梓枫
 * @date 2019年5月24日上午11:08:46
 * @description
 */
@Data
public class AccountLoginSqlOutDto implements Serializable{

	private static final long serialVersionUID = 2441409922349979715L;

	private Integer id;

	private String password;

	private Integer state;

	private Integer sellerId;
}
