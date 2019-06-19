package com.hsy.compartment.rest.purchase;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hsy.core.bean.ResultInfo;
import com.hsy.core.service.IBlogic;
import com.hsy.compartment.dto.purchase.purchaseDetailQuery.PurchaseDetailRespDto;
import com.hsy.compartment.dto.purchase.purchaseQuery.PurchaseQueryReqtDto;
import com.hsy.compartment.dto.purchase.purchaseQuery.PurchaseQueryRespDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 刘志恒
 * @date 2019年6月5日下午5:54
 * @description
 */
@Slf4j
@RestController
@RequestMapping("purchase")
@Api(value = "PurchaseResource", tags = "采购单api")
public class PurchaseResource {

	@Autowired
	private IBlogic<PurchaseQueryReqtDto, List<PurchaseQueryRespDto>> purchaseQueryBlogic;

	@PostMapping("/list")
	@ApiOperation(value = "[采购单api]->查询采购单列表信息", notes = "根据PurchaseQueryReqtDto查询采购单列表信息")
	public ResponseEntity<ResultInfo<List<PurchaseQueryRespDto>>> getPurchaseList(@RequestBody @ApiParam @Valid PurchaseQueryReqtDto reqt) throws Exception {
		log.debug("REST[采购单api]->根据PurchaseQueryReqtDto查询采购单列表信息：{}", reqt);
		ResultInfo<List<PurchaseQueryRespDto>> results = purchaseQueryBlogic.execute(reqt);
		return new ResponseEntity<>(results, HttpStatus.OK);
	}

	@Autowired
	private IBlogic<Integer, PurchaseDetailRespDto> purchaseDetailQueryBlogic;

	@GetMapping("/detail/{id}")
	@ApiOperation(value = "[采购单api]->查询采购单详情信息", notes = "根据id查询采购单详情信息")
	public ResponseEntity<ResultInfo<PurchaseDetailRespDto>> getPurchaseDetail(@PathVariable Integer id) throws Exception {
		log.debug("REST[采购单api]->根据id查询采购单详情信息：{}", id);
		ResultInfo<PurchaseDetailRespDto> results = purchaseDetailQueryBlogic.execute(id);
		return new ResponseEntity<>(results, HttpStatus.OK);
	}
}
