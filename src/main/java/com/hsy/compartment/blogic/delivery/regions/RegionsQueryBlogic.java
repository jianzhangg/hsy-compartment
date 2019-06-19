package com.hsy.compartment.blogic.delivery.regions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hsy.core.bean.ResultInfo;
import com.hsy.core.service.IBlogic;
import com.hsy.core.utils.BeanUtils;
import com.hsy.core.utils.ResultUtils;
import com.hsy.mybatis.QueryDao;
import com.hsy.compartment.dto.regions.RegionsQueryReqtDto;
import com.hsy.compartment.dto.regions.RegionsQueryRespDto;
import com.hsy.compartment.sql.delivery.regions.RegionsQuerySqlOutDto;

/**
 * @author 张梓枫
 * @date 2019年5月28日上午10:50:43
 * @description
 */
@Service("regionsQueryBlogic")
@Transactional(rollbackFor = Exception.class)
public class RegionsQueryBlogic implements IBlogic<RegionsQueryReqtDto, List<RegionsQueryRespDto>> {

	@Autowired
	private QueryDao queryDao;

	@Override
	public ResultInfo<List<RegionsQueryRespDto>> execute(RegionsQueryReqtDto paramP) throws Exception {
		List<RegionsQuerySqlOutDto> sqlOutDtos = queryDao.executeForObjectList("RegionsQuerySql", paramP.getParentId());
		List<RegionsQueryRespDto> results = BeanUtils.copy(sqlOutDtos, RegionsQueryRespDto.class);
		return ResultUtils.createRet(results);
	}

}
