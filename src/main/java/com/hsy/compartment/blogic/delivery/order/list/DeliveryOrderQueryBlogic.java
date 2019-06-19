package com.hsy.compartment.blogic.delivery.order.list;

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
import com.hsy.compartment.dto.delivery.order.list.DeliveryOrderQueryReqtDto;
import com.hsy.compartment.dto.delivery.order.list.DeliveryOrderQueryRespDto;
import com.hsy.compartment.sql.delivery.order.list.DeliveryOrderQuerySqlInDto;
import com.hsy.compartment.sql.delivery.order.list.DeliveryOrderQuerySqlOutDto;

/**
 * @author 张梓枫
 * @date 2019年5月29日上午10:09:48
 * @description 配送单列表查询业务类
 */
@Service("deliveryOrderQueryBlogic")
@Transactional(rollbackFor = Exception.class)
public class DeliveryOrderQueryBlogic implements IBlogic<DeliveryOrderQueryReqtDto, List<DeliveryOrderQueryRespDto>> {

	@Autowired
	private QueryDao queryDao;

	@Override
	public ResultInfo<List<DeliveryOrderQueryRespDto>> execute(DeliveryOrderQueryReqtDto paramP) throws Exception {
		DeliveryOrderQuerySqlInDto sqlParams = BeanUtils.copy(paramP, DeliveryOrderQuerySqlInDto.class);
		User user = ContextHolder.getUser();
		sqlParams.setSellerId(user.getSellerId());
		PageInfo pageInfo = ContextHolder.getPage();
		List<DeliveryOrderQuerySqlOutDto> sqlOutDtos = queryDao.executeForObjectListByPage("DeliveryOrderQuerySql", sqlParams, pageInfo);
		List<DeliveryOrderQueryRespDto> results = PageBeanUtils.copy(sqlOutDtos, DeliveryOrderQueryRespDto.class);
		return PageResultUtils.createRet(results);
	}

}
