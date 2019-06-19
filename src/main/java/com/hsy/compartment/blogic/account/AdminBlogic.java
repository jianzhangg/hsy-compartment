package com.hsy.compartment.blogic.account;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hsy.common.bean.User;
import com.hsy.common.exception.BLogicException;
import com.hsy.common.jwt.JwtSecurityUtils;
import com.hsy.common.utils.JsonUtils;
import com.hsy.common.utils.ObjectUtils;
import com.hsy.core.bean.ResultInfo;
import com.hsy.core.service.IBlogic;
import com.hsy.core.utils.BeanUtils;
import com.hsy.core.utils.ResultUtils;
import com.hsy.mybatis.QueryDao;
import com.hsy.redis.client.RedisClient;
import com.hsy.resource.constant.JwtConstant;
import com.hsy.resource.enums.AccountState;
import com.hsy.compartment.dto.account.AdminLoginReqtDto;
import com.hsy.compartment.dto.account.AdminLoginRespDto;
import com.hsy.compartment.sql.account.AccountLoginSqlInDto;
import com.hsy.compartment.sql.account.AccountLoginSqlOutDto;

/**
 * @author 张梓枫
 * @date 2019年5月22日下午1:38:15
 * @description
 */
@Service("adminBlogic")
@Transactional(rollbackFor = Exception.class)
public class AdminBlogic implements IBlogic<AdminLoginReqtDto, AdminLoginRespDto> {

	@Autowired
	private QueryDao queryDao;

	@Autowired
	private RedisClient<String> redisClient;

	@Override
	public ResultInfo<AdminLoginRespDto> execute(AdminLoginReqtDto requestDto) throws Exception {
		AccountLoginSqlInDto sqlInDto = BeanUtils.copy(requestDto, AccountLoginSqlInDto.class);
		AccountLoginSqlOutDto sqlOutDto = queryDao.executeForObject("AccountLoginSql", sqlInDto, AccountLoginSqlOutDto.class);
		if (ObjectUtils.isEmpty(sqlOutDto)) {
			throw new BLogicException("用户名不存在.");
		}
		String pass = sqlOutDto.getPassword();
		String password = requestDto.getPassword();
		if (!ObjectUtils.equals(pass, password)) {
			throw new BLogicException("您输入的密码有误，请重新输入.");
		}
		Integer state = sqlOutDto.getState();
		if (ObjectUtils.equals(state, AccountState.FROZEN.getState())) {
			throw new BLogicException("账号已被冻结.");
		}

		String id = ObjectUtils.convertToString(sqlOutDto.getId());
		String username = requestDto.getUsername();
		Integer sellerId = sqlOutDto.getSellerId();
		String token = this.createToken(sqlOutDto.getId(), sellerId, requestDto.getUsername());
		User user = this.createUser(id, username, sellerId, token);
		AdminLoginRespDto result = BeanUtils.copy(user, AdminLoginRespDto.class);
		result.setToken(token);
		return ResultUtils.createRet(result);
	}

	private User createUser(String id, String username, Integer sellerId, String token) {
		this.expirToken(id, username);
		User user = new User();
		user.setId(ObjectUtils.convertToInteger(id));
		user.setUsername(username);
		user.setSellerId(sellerId);
		redisClient.set(id.concat(username), token, 0);
		Map<Object, Object> userMap = new HashMap<>();
		userMap.put(JwtConstant.JWT_USER, JsonUtils.toJson(user));
		userMap.put(JwtConstant.JWT_EXPIRATION, ObjectUtils.convertToString(0));
		redisClient.hset(token, userMap, 0);
		return user;
	}

	private String createToken(Integer id, Integer sellerId, String username) {
		String token = JwtSecurityUtils.createToken(ObjectUtils.convertToString(id), ObjectUtils.convertToString(sellerId), username, 0);
		return token;
	}

	private void expirToken(String id, String username) {
		String key = id.concat(username);
		if (!redisClient.exists(key)) {
			return;
		}
		String oldToken = ObjectUtils.convertToString(redisClient.get(key));
		redisClient.remove(oldToken);
		redisClient.remove(key);
	}
}
