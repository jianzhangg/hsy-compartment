package com.hsy.compartment.sql.account;

import java.io.Serializable;

import lombok.Data;

/**
 * @author 张梓枫
 * @date 2019年5月24日上午11:05:06
 * @description
 */
@Data
public class AccountLoginSqlInDto implements Serializable {

	private static final long serialVersionUID = -8857036509946388383L;

	/**
	 * 登录用户
	 */
	private String username;

}
