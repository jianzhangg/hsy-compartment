package com.hsy.compartment.blogic.delivery.order.haveAdd;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hsy.common.bean.User;
import com.hsy.common.context.ContextHolder;
import com.hsy.common.utils.DateUtils;
import com.hsy.common.utils.DecimalUtils;
import com.hsy.compartment.dto.delivery.order.haveAdd.DeliveryOrderHaveAddReqtDto;
import com.hsy.compartment.sql.delivery.order.haveAdd.DeliveryOrderHaveAddSqlInDto;
import com.hsy.core.bean.ResultInfo;
import com.hsy.core.service.IBlogic;
import com.hsy.core.utils.BeanUtils;
import com.hsy.core.utils.ResultUtils;
import com.hsy.mybatis.UpdateDao;
import com.hsy.resource.enums.IDelivery.DeliveryState;
import com.hsy.resource.enums.IDelivery.DeliveryType;

/**
 * @author 张梓枫
 * @date 2019年5月29日下午2:07:54
 * @description 配送单新增业务类
 */
@Service("deliveryOrderHaveAddBlogic")
@Transactional(rollbackFor = Exception.class)
public class DeliveryOrderHaveAddBlogic implements IBlogic<DeliveryOrderHaveAddReqtDto, Integer> {

	@Autowired
	private UpdateDao updateDao;

	@Override
	public ResultInfo<Integer> execute(DeliveryOrderHaveAddReqtDto paramP) throws Exception {
		List<Integer> orderIds = paramP.getOrderIds();
		User user = ContextHolder.getUser();
		List<DeliveryOrderHaveAddSqlInDto> addSqlInDtos = new ArrayList<DeliveryOrderHaveAddSqlInDto>();
		for (Integer orderId : orderIds) {
			DeliveryOrderHaveAddSqlInDto sqlInDto = BeanUtils.copy(paramP, DeliveryOrderHaveAddSqlInDto.class);
			sqlInDto.setOrderId(orderId);
			String deliveryOrderSn = DateUtils.now(DateUtils.PATTERN_FULL_SIMPLE).concat(DecimalUtils.generateRandom(6));
			sqlInDto.setDeliveryOrderSn(deliveryOrderSn);
			sqlInDto.setSellerId(user.getSellerId());
			sqlInDto.setDeliveryState(DeliveryState.DELIVERY_NO.getState());
			sqlInDto.setDeliveryDate(DateUtils.nowDate());
			sqlInDto.setDeliveryType(DeliveryType.HAVE.getType());
			addSqlInDtos.add(sqlInDto);
		}
		Integer result = updateDao.execute("DeliveryOrderHaveAddSql", addSqlInDtos);
		return ResultUtils.createRet(result);
	}

}
