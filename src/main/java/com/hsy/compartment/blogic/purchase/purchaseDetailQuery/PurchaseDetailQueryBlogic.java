package com.hsy.compartment.blogic.purchase.purchaseDetailQuery;

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
import com.hsy.compartment.dto.purchase.purchaseDetailQuery.PurchaseDetailProductRespDto;
import com.hsy.compartment.dto.purchase.purchaseDetailQuery.PurchaseDetailRespDto;
import com.hsy.compartment.sql.purchase.purchaseDetailQuery.PurchaseDetailProductSqlOutDto;
import com.hsy.compartment.sql.purchase.purchaseDetailQuery.PurchaseDetailSqlOutDto;

/**
 * @author 刘志恒
 * @date 2019年6月6日上午9:39
 * @description 查询采购单明细信息业务操作类
 */
@Service("purchaseDetailQueryBlogic")
@Transactional(rollbackFor = Exception.class)
public class PurchaseDetailQueryBlogic implements IBlogic<Integer, PurchaseDetailRespDto> {

	@Autowired
	private QueryDao queryDao;

	@Override
	public ResultInfo<PurchaseDetailRespDto> execute(Integer params) throws Exception {
		PurchaseDetailSqlOutDto purchaseDetailDto = queryDao.executeForObject("PurchaseDetailSqlById", params, PurchaseDetailSqlOutDto.class);
		if (ObjectUtils.isEmpty(purchaseDetailDto)) {
			throw new BLogicException("采购单不存在.");
		}
		List<PurchaseDetailProductSqlOutDto> productSqlOutDtos = queryDao.executeForObjectList("PurchaseDetailProductSql", params);
		List<PurchaseDetailProductRespDto> productRespDtos = BeanUtils.copy(productSqlOutDtos, PurchaseDetailProductRespDto.class);
		PurchaseDetailRespDto result = BeanUtils.copy(purchaseDetailDto, PurchaseDetailRespDto.class);
		result.setPurchaseProducts(productRespDtos);
		return ResultUtils.createRet(result);
	}

}
