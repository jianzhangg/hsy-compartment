package com.hsy.compartment.blogic.delivery.personnel.personnelList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hsy.common.bean.PageInfo;
import com.hsy.common.bean.User;
import com.hsy.common.context.ContextHolder;
import com.hsy.core.bean.ResultInfo;
import com.hsy.core.service.IBlogic;
import com.hsy.core.utils.BeanUtils;
import com.hsy.mybatis.QueryDao;
import com.hsy.mybatis.utils.PageBeanUtils;
import com.hsy.mybatis.utils.PageResultUtils;
import com.hsy.compartment.dto.delivery.personnel.personnelList.PersonnelListQueryReqtDto;
import com.hsy.compartment.dto.delivery.personnel.personnelList.PersonnelListQueryRespDto;
import com.hsy.compartment.sql.delivery.personnel.personnelList.PersonnelListQuerySqlInDto;
import com.hsy.compartment.sql.delivery.personnel.personnelList.PersonnelListQuerySqlOutDto;

/**
 * @author 张梓枫
 * @date 2019年5月27日下午2:51:12
 * @description
 */
@Service("personnelListQueryBlogic")
@Transactional(rollbackFor = Exception.class)
public class PersonnelListQueryBlogic implements IBlogic<PersonnelListQueryReqtDto, List<PersonnelListQueryRespDto>> {

	@Autowired
	private QueryDao queryDao;

	@Override
	public ResultInfo<List<PersonnelListQueryRespDto>> execute(PersonnelListQueryReqtDto paramP) throws Exception {
		PersonnelListQuerySqlInDto sqlParams = BeanUtils.copy(paramP, PersonnelListQuerySqlInDto.class);
		User user = ContextHolder.getUser();
		sqlParams.setSellerId(user.getSellerId());

		PageInfo pageInfo = ContextHolder.getPage();
		List<PersonnelListQuerySqlOutDto> sqlOutDtos = queryDao.executeForObjectListByPage("PersonnelListQuerySql", sqlParams, pageInfo);
		List<PersonnelListQueryRespDto> results = PageBeanUtils.copy(sqlOutDtos, PersonnelListQueryRespDto.class);
		return PageResultUtils.createRet(results);
	}

}
