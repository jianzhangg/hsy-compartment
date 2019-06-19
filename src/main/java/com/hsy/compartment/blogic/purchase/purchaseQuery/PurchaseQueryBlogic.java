package com.hsy.compartment.blogic.purchase.purchaseQuery;

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
import com.hsy.compartment.dto.purchase.purchaseQuery.PurchaseQueryReqtDto;
import com.hsy.compartment.dto.purchase.purchaseQuery.PurchaseQueryRespDto;
import com.hsy.compartment.sql.purchase.purchaseQuery.PurchaseQuerySqlInDto;
import com.hsy.compartment.sql.purchase.purchaseQuery.PurchaseQuerySqlOutDto;

/**
 * @author 刘志恒
 * @date 2019年6月5日下午5:47
 * @description 采购单列表查询业务操作类
 */
@Service("purchaseQueryBlogic")
@Transactional(rollbackFor = Exception.class)
public class PurchaseQueryBlogic implements IBlogic<PurchaseQueryReqtDto, List<PurchaseQueryRespDto>> {

	@Autowired
	private QueryDao queryDao;

	@Override
	public ResultInfo<List<PurchaseQueryRespDto>> execute(PurchaseQueryReqtDto requestDto) throws Exception {
		PurchaseQuerySqlInDto sqlParams = BeanUtils.copy(requestDto, PurchaseQuerySqlInDto.class);
		PageInfo pageInfo = ContextHolder.getPage();
		User user = ContextHolder.getUser();
		sqlParams.setSellerId(user.getSellerId());
		List<PurchaseQuerySqlOutDto> sqlOutDtos = queryDao.executeForObjectListByPage("PurchaseQuerySqlList", sqlParams, pageInfo);
		List<PurchaseQueryRespDto> results = PageBeanUtils.copy(sqlOutDtos, PurchaseQueryRespDto.class);
		return PageResultUtils.createRet(results);
	}

}
