package com.hsy.compartment.blogic.delivery.personnel.personnelSetAreas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hsy.core.bean.ResultInfo;
import com.hsy.core.service.IBlogic;
import com.hsy.core.utils.BeanUtils;
import com.hsy.core.utils.ResultUtils;
import com.hsy.mybatis.UpdateDao;
import com.hsy.compartment.dto.delivery.personnel.personnelSetAreas.PersonnelSetAreasReqtDto;
import com.hsy.compartment.dto.delivery.personnel.personnelSetAreas.PersonnelSetReqtDto;
import com.hsy.compartment.sql.delivery.personnel.personnelSetAreas.PersonnelSetAreasSqlInDto;

/**
 * @author 张梓枫
 * @date 2019年5月27日下午4:49:28
 * @description
 */
@Service("personnelSetAreasBlogic")
@Transactional(rollbackFor = Exception.class)
public class PersonnelSetAreasBlogic implements IBlogic<PersonnelSetReqtDto, Integer> {

	@Autowired
	private UpdateDao updateDao;

	@Override
	public ResultInfo<Integer> execute(PersonnelSetReqtDto paramP) throws Exception {
		List<PersonnelSetAreasSqlInDto> sqlParams = new ArrayList<PersonnelSetAreasSqlInDto>();
		Integer personnelId = paramP.getPersonnelId();
		updateDao.execute("PersonnelSetAreasDeleteSql", personnelId);
		List<PersonnelSetAreasReqtDto> areasReqtDtos = paramP.getPersonnelAreas();
		for (PersonnelSetAreasReqtDto areasReqtDto : areasReqtDtos) {
			StringBuilder sb = new StringBuilder(areasReqtDto.getProvince()).append(areasReqtDto.getCity()).append(areasReqtDto.getArea());
			PersonnelSetAreasSqlInDto sqlInDto = BeanUtils.copy(areasReqtDto, PersonnelSetAreasSqlInDto.class);
			sqlInDto.setAddressAll(sb.toString());
			sqlInDto.setPersonnelId(personnelId);
			sqlParams.add(sqlInDto);
		}
		Integer result = updateDao.execute("PersonnelSetAreasSql", sqlParams);
		return ResultUtils.createRet(result);
	}

}
