package com.hsy.compartment.blogic.purchase.purchaseTakeOver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hsy.core.bean.ResultInfo;
import com.hsy.core.service.IBlogic;
import com.hsy.core.utils.BeanUtils;
import com.hsy.core.utils.ResultUtils;
import com.hsy.mybatis.QueryDao;
import com.hsy.mybatis.UpdateDao;
import com.hsy.common.exception.BLogicException;
import com.hsy.common.utils.ObjectUtils;
import com.hsy.compartment.dto.purchase.purchaseTakeOver.PurchaseListProductRespDto;
import com.hsy.compartment.dto.purchase.purchaseTakeOver.PurchaseStockAddReqtDto;
import com.hsy.compartment.dto.purchase.purchaseTakeOver.PurchaseStockReqtDto;
import com.hsy.compartment.dto.purchase.purchaseTakeOver.PurchaseUpdateReqtDto;
import com.hsy.compartment.sql.delivery.personnel.personnelAdd.PersonnelAddSqlInDto;
import com.hsy.compartment.sql.purchase.purchaseDetailQuery.PurchaseDetailSqlOutDto;
import com.hsy.compartment.sql.purchase.purchaseTakeOver.PurchaseListProductSqlOutDto;
import com.hsy.compartment.sql.purchase.purchaseTakeOver.PurchaseStockAddSqlInDto;
import com.hsy.compartment.sql.purchase.purchaseTakeOver.PurchaseStockSqlInDto;
import com.hsy.compartment.sql.purchase.purchaseTakeOver.PurchaseStockSqlOutDto;
import com.hsy.compartment.sql.purchase.purchaseTakeOver.PurchaseUpdateSqlInDto;

/**
 * @author 刘志恒
 * @date 2019年6月6日下午2:39
 * @description
 */
@Service("purchaseUpdateBlogic")
@Transactional(rollbackFor = Exception.class)
public class PurchaseTakeOverBlogic implements IBlogic<PurchaseUpdateReqtDto, Integer> {

	@Autowired
	private UpdateDao updateDao;
	@Autowired
	private QueryDao queryDao;

	@Override
	public ResultInfo<Integer> execute(PurchaseUpdateReqtDto paramP) throws Exception {
		PurchaseUpdateSqlInDto sqlParams = BeanUtils.copy(paramP, PurchaseUpdateSqlInDto.class);
		//修改采购单状态为已完成的订单
		Integer result = updateDao.execute("PurchaseUpdateSql", sqlParams);
		//根据采购单id查询商品列表信息
		List<PurchaseListProductSqlOutDto> productSqlOutDtos = queryDao.executeForObjectList("PurchaseListProductSql", sqlParams);
		List<PurchaseListProductRespDto> productRespDtos = BeanUtils.copy(productSqlOutDtos, PurchaseListProductRespDto.class);
		for(PurchaseListProductRespDto productRespDto : productRespDtos){
			PurchaseStockReqtDto purchaseStockReqtDto=new PurchaseStockReqtDto();
			purchaseStockReqtDto.setSellerId(productRespDto.getSellerId());
			purchaseStockReqtDto.setProductGoodsId(productRespDto.getProductGoodsId());
			PurchaseStockSqlInDto stockSqlInDto=BeanUtils.copy(purchaseStockReqtDto, PurchaseStockSqlInDto.class);
			PurchaseStockSqlOutDto stockSqlOutDto=queryDao.executeForObject("StockSql", stockSqlInDto, PurchaseStockSqlOutDto.class);
			if (ObjectUtils.isEmpty(stockSqlOutDto)) {
				throw new BLogicException("库存信息不存在.");
				//新增库存信息
				
			}else{
				//修改库存信息
			}
		}
		return ResultUtils.createRet(result);
	}
	
	//新增库存信息
	public void addStock(PurchaseStockAddReqtDto paramP)throws Exception {
		PurchaseStockAddSqlInDto sqlParams = BeanUtils.copy(paramP, PurchaseStockAddSqlInDto.class);
	}
	
	//修改库存信息
	public void updateStock(){
		
	}

}
