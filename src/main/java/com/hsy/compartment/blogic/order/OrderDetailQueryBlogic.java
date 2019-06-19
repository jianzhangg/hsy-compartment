package com.hsy.compartment.blogic.order;

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
import com.hsy.compartment.dto.order.orderDetailQuery.OrderDetailProductRespDto;
import com.hsy.compartment.dto.order.orderDetailQuery.OrderDetailRespDto;
import com.hsy.compartment.sql.order.orderDetailQuery.OrderDetailProductSqlOutDto;
import com.hsy.compartment.sql.order.orderDetailQuery.OrderDetailSqlOutDto;

/**
 * @author 张梓枫
 * @date 2019年5月27日下午1:39:16
 * @description 查询订单明细信息业务操作类
 */
@Service("orderDetailQueryBlogic")
@Transactional(rollbackFor = Exception.class)
public class OrderDetailQueryBlogic implements IBlogic<Integer, OrderDetailRespDto> {

	@Autowired
	private QueryDao queryDao;

	@Override
	public ResultInfo<OrderDetailRespDto> execute(Integer params) throws Exception {
		OrderDetailSqlOutDto orderDetailDto = queryDao.executeForObject("OrderDetailSqlById", params, OrderDetailSqlOutDto.class);
		if (ObjectUtils.isEmpty(orderDetailDto)) {
			throw new BLogicException("订单不存在.");
		}
		List<OrderDetailProductSqlOutDto> productSqlOutDtos = queryDao.executeForObjectList("OrderDetailProductSql", params);
		List<OrderDetailProductRespDto> productRespDtos = BeanUtils.copy(productSqlOutDtos, OrderDetailProductRespDto.class);
		OrderDetailRespDto result = BeanUtils.copy(orderDetailDto, OrderDetailRespDto.class);
		result.setOrderProducts(productRespDtos);
		return ResultUtils.createRet(result);
	}

}
