package com.hsy.compartment.blogic.delivery.personnel.update;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hsy.core.bean.ResultInfo;
import com.hsy.core.service.IBlogic;
import com.hsy.core.utils.BeanUtils;
import com.hsy.core.utils.ResultUtils;
import com.hsy.mybatis.UpdateDao;
import com.hsy.compartment.dto.delivery.personnel.update.PersonnelUpdateReqtDto;
import com.hsy.compartment.sql.delivery.personnel.update.PersonnelUpdateSqlInDto;

/**
 * @author 张梓枫
 * @date 2019年5月29日上午10:39:49
 * @description
 */
@Service("personnelUpdateBlogic")
@Transactional(rollbackFor = Exception.class)
public class PersonnelUpdateBlogic implements IBlogic<PersonnelUpdateReqtDto, Integer> {

	@Autowired
	private UpdateDao updateDao;

	@Override
	public ResultInfo<Integer> execute(PersonnelUpdateReqtDto paramP) throws Exception {
		PersonnelUpdateSqlInDto sqlParams = BeanUtils.copy(paramP, PersonnelUpdateSqlInDto.class);
		Integer result = updateDao.execute("PersonnelUpdateSql", sqlParams);
		return ResultUtils.createRet(result);
	}

}
