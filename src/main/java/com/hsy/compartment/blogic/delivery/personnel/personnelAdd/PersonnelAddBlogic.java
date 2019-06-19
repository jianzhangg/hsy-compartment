package com.hsy.compartment.blogic.delivery.personnel.personnelAdd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hsy.common.bean.User;
import com.hsy.common.context.ContextHolder;
import com.hsy.core.bean.ResultInfo;
import com.hsy.core.service.IBlogic;
import com.hsy.core.utils.BeanUtils;
import com.hsy.core.utils.ResultUtils;
import com.hsy.mybatis.UpdateDao;
import com.hsy.compartment.dto.delivery.personnel.personnelAdd.PersonnelAddReqtDto;
import com.hsy.compartment.sql.delivery.personnel.personnelAdd.PersonnelAddSqlInDto;

/**
 * @author 张梓枫
 * @date 2019年5月27日下午4:07:01
 * @description 配送人员新增业务操作类
 */
@Service("personnelAddBlogic")
@Transactional(rollbackFor = Exception.class)
public class PersonnelAddBlogic implements IBlogic<PersonnelAddReqtDto, Integer> {

	@Autowired
	private UpdateDao updateDao;

	@Override
	public ResultInfo<Integer> execute(PersonnelAddReqtDto paramP) throws Exception {
		PersonnelAddSqlInDto sqlParams = BeanUtils.copy(paramP, PersonnelAddSqlInDto.class);
		User user = ContextHolder.getUser();
		sqlParams.setSellerId(user.getSellerId());
		Integer result = updateDao.execute("PersonnelAddSql", sqlParams);
		return ResultUtils.createRet(result);
	}

}
