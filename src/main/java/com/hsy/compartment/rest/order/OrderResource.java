package com.hsy.compartment.rest.order;

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
import com.hsy.compartment.dto.order.orderDetailQuery.OrderDetailRespDto;
import com.hsy.compartment.dto.order.orderQuery.OrderQueryReqtDto;
import com.hsy.compartment.dto.order.orderQuery.OrderQueryRespDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 张梓枫
 * @date 2019年5月27日上午10:00:24
 * @description
 */
@Slf4j
@RestController
@RequestMapping("order")
@Api(value = "OrderResource", tags = "订单api")
public class OrderResource {

	@Autowired
	private IBlogic<OrderQueryReqtDto, List<OrderQueryRespDto>> orderQueryBlogic;

	@PostMapping("/list")
	@ApiOperation(value = "[订单api]->查询订单列表信息", notes = "根据OrderQueryReqtDto查询订单列表信息")
	public ResponseEntity<ResultInfo<List<OrderQueryRespDto>>> getOrderList(@RequestBody @ApiParam @Valid OrderQueryReqtDto reqt) throws Exception {
		log.debug("REST[订单api]->根据OrderQueryReqtDto查询订单列表信息：{}", reqt);
		ResultInfo<List<OrderQueryRespDto>> results = orderQueryBlogic.execute(reqt);
		return new ResponseEntity<>(results, HttpStatus.OK);
	}

	@Autowired
	private IBlogic<Integer, OrderDetailRespDto> orderDetailQueryBlogic;

	@GetMapping("/detail/{id}")
	@ApiOperation(value = "[订单api]->查询订单详情信息", notes = "根据id查询订单详情信息")
	public ResponseEntity<ResultInfo<OrderDetailRespDto>> getOrderDetail(@PathVariable Integer id) throws Exception {
		log.debug("REST[订单api]->根据id查询订单详情信息：{}", id);
		ResultInfo<OrderDetailRespDto> results = orderDetailQueryBlogic.execute(id);
		return new ResponseEntity<>(results, HttpStatus.OK);
	}
}
