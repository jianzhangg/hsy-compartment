package com.hsy.compartment.blogic.delivery.personnel.personnelDetailQuery;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hsy.common.exception.BLogicException;
import com.hsy.common.utils.ObjectUtils;
import com.hsy.core.bean.ResultInfo;
import com.hsy.core.service.IBlogic;
import com.hsy.core.utils.BeanUtils;
import com.hsy.core.utils.ResultUtils;
import com.hsy.mybatis.QueryDao;
import com.hsy.compartment.dto.delivery.personnel.personnelDetailQuery.PersonnelAreasQueryRespDto;
import com.hsy.compartment.dto.delivery.personnel.personnelDetailQuery.PersonnelDetailQueryRespDto;
import com.hsy.compartment.sql.delivery.personnel.personnelDetailQuery.PersonnelAreasQuerySqlOutDto;
import com.hsy.compartment.sql.delivery.personnel.personnelDetailQuery.PersonnelDetailQuerySqlOutDto;

/**
 * @author 张梓枫
 * @date 2019年5月27日下午6:01:32
 * @description 配送人员明细信息查询业务操作类
 */
@Service("personnelDetailQueryBlogic")
@Transactional(rollbackFor = Exception.class)
public class PersonnelDetailQueryBlogic implements IBlogic<Integer, PersonnelDetailQueryRespDto> {

	@Autowired
	private QueryDao queryDao;

	@Override
	public ResultInfo<PersonnelDetailQueryRespDto> execute(Integer paramP) throws Exception {
		PersonnelDetailQuerySqlOutDto sqlOutDto = queryDao.executeForObject("PersonnelDetailQuerySql", paramP, PersonnelDetailQuerySqlOutDto.class);
		if (ObjectUtils.isEmpty(sqlOutDto)) {
			throw new BLogicException("配送员不存在.");
		}
		List<PersonnelAreasQuerySqlOutDto> areas = queryDao.executeForObjectList("PersonnelAreasQuerySql", paramP);
		PersonnelDetailQueryRespDto results = BeanUtils.copy(sqlOutDto, PersonnelDetailQueryRespDto.class);
		List<PersonnelAreasQueryRespDto> respDtos = BeanUtils.copy(areas, PersonnelAreasQueryRespDto.class);
		results.setPersonnelAreas(respDtos);
		return ResultUtils.createRet(results);
	}

}
