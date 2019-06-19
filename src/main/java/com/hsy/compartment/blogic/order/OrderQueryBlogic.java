package com.hsy.compartment.blogic.order;

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
import com.hsy.compartment.dto.order.orderQuery.OrderQueryReqtDto;
import com.hsy.compartment.dto.order.orderQuery.OrderQueryRespDto;
import com.hsy.compartment.sql.order.OrderQuery.OrderQuerySqlInDto;
import com.hsy.compartment.sql.order.OrderQuery.OrderQuerySqlOutDto;

/**
 * @author 张梓枫
 * @date 2019年5月27日上午9:52:49
 * @description 订单列表查询业务操作类
 */
@Service("orderQueryBlogic")
@Transactional(rollbackFor = Exception.class)
public class OrderQueryBlogic implements IBlogic<OrderQueryReqtDto, List<OrderQueryRespDto>> {

	@Autowired
	private QueryDao queryDao;

	@Override
	public ResultInfo<List<OrderQueryRespDto>> execute(OrderQueryReqtDto requestDto) throws Exception {
		OrderQuerySqlInDto sqlInDto = BeanUtils.copy(requestDto, OrderQuerySqlInDto.class);
		User user = ContextHolder.getUser();
		sqlInDto.setSellerId(user.getSellerId());

		PageInfo pageInfo = ContextHolder.getPage();
		List<OrderQuerySqlOutDto> sqlOutDtos = queryDao.executeForObjectListByPage("OrderQuerySqlList", sqlInDto, pageInfo);
		List<OrderQueryRespDto> results = PageBeanUtils.copy(sqlOutDtos, OrderQueryRespDto.class);
		return PageResultUtils.createRet(results);
	}

}
