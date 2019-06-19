package com.hsy.compartment.rest.delivery;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hsy.core.bean.ResultInfo;
import com.hsy.core.service.IBlogic;
import com.hsy.compartment.dto.delivery.order.haveAdd.DeliveryOrderHaveAddReqtDto;
import com.hsy.compartment.dto.delivery.order.list.DeliveryOrderQueryReqtDto;
import com.hsy.compartment.dto.delivery.order.list.DeliveryOrderQueryRespDto;
import com.hsy.compartment.dto.delivery.personnel.delete.PersonnelDeleteReqtDto;
import com.hsy.compartment.dto.delivery.personnel.personnelAdd.PersonnelAddReqtDto;
import com.hsy.compartment.dto.delivery.personnel.personnelDetailQuery.PersonnelDetailQueryRespDto;
import com.hsy.compartment.dto.delivery.personnel.personnelList.PersonnelListQueryReqtDto;
import com.hsy.compartment.dto.delivery.personnel.personnelList.PersonnelListQueryRespDto;
import com.hsy.compartment.dto.delivery.personnel.personnelSetAreas.PersonnelSetReqtDto;
import com.hsy.compartment.dto.delivery.personnel.update.PersonnelUpdateReqtDto;
import com.hsy.compartment.dto.regions.RegionsQueryReqtDto;
import com.hsy.compartment.dto.regions.RegionsQueryRespDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 张梓枫
 * @date 2019年5月27日下午2:58:25
 * @description
 */
@Slf4j
@RestController
@RequestMapping("delivery")
@Api(value = "DeliveryResource", tags = "配送管理api")
public class DeliveryResource {

	@Autowired
	private IBlogic<PersonnelListQueryReqtDto, List<PersonnelListQueryRespDto>> personnelListQueryBlogic;

	@PostMapping("/pesonnel/list")
	@ApiOperation(value = "[配送管理api]->查询配送人员列表信息", notes = "根据OrderQueryReqtDto查询订单列表信息")
	public ResponseEntity<ResultInfo<List<PersonnelListQueryRespDto>>> getPersonnelList(@RequestBody @ApiParam @Valid PersonnelListQueryReqtDto reqt) throws Exception {
		log.debug("REST[配送管理api]->根据OrderQueryReqtDto查询订单列表信息：{}", reqt);
		ResultInfo<List<PersonnelListQueryRespDto>> results = personnelListQueryBlogic.execute(reqt);
		return new ResponseEntity<>(results, HttpStatus.OK);
	}

	@Autowired
	private IBlogic<PersonnelAddReqtDto, Integer> personnelAddBlogic;

	@PostMapping("/pesonnel/add")
	@ApiOperation(value = "[配送管理api]->新增配送人员信息", notes = "根据PersonnelAddReqtDto新增配送人员信息")
	public ResponseEntity<ResultInfo<Integer>> addPesonnel(@RequestBody @ApiParam @Valid PersonnelAddReqtDto reqt) throws Exception {
		log.debug("REST[配送管理api]->根据PersonnelAddReqtDto新增配送人员信息：{}", reqt);
		ResultInfo<Integer> results = personnelAddBlogic.execute(reqt);
		return new ResponseEntity<>(results, HttpStatus.OK);
	}

	@Autowired
	private IBlogic<PersonnelSetReqtDto, Integer> personnelSetAreasBlogic;

	@PostMapping("/pesonnel/setAreas")
	@ApiOperation(value = "[配送管理api]->设置配送人员负责区域", notes = "根据PersonnelSetReqtDto设置配送人员负责区域")
	public ResponseEntity<ResultInfo<Integer>> setAreas(@RequestBody @ApiParam @Valid PersonnelSetReqtDto reqt) throws Exception {
		log.debug("REST[配送管理api]->根据PersonnelSetReqtDto设置配送人员负责区域：{}", reqt);
		ResultInfo<Integer> results = personnelSetAreasBlogic.execute(reqt);
		return new ResponseEntity<>(results, HttpStatus.OK);
	}

	@Autowired
	private IBlogic<Integer, PersonnelDetailQueryRespDto> personnelDetailQueryBlogic;

	@GetMapping("/pesonnel/detail/{id}")
	@ApiOperation(value = "[配送管理api]->根据id查询配送员信息", notes = "根据id查询配送员信息")
	public ResponseEntity<ResultInfo<PersonnelDetailQueryRespDto>> getPesonnelDetail(@PathVariable Integer id) throws Exception {
		log.debug("REST[配送管理api]->根据id查询配送员信息：{}", id);
		ResultInfo<PersonnelDetailQueryRespDto> results = personnelDetailQueryBlogic.execute(id);
		return new ResponseEntity<>(results, HttpStatus.OK);
	}

	@Autowired
	private IBlogic<PersonnelUpdateReqtDto, Integer> personnelUpdateBlogic;

	@PutMapping("/pesonnel/update")
	@ApiOperation(value = "[配送管理api]->更新配送人员信息", notes = "根据PersonnelUpdateReqtDto更新配送人员信息")
	public ResponseEntity<ResultInfo<Integer>> updatePesonnel(@RequestBody @ApiParam @Valid PersonnelUpdateReqtDto reqt) throws Exception {
		log.debug("REST[配送管理api]->根据PersonnelUpdateReqtDto更新配送人员信息：{}", reqt);
		ResultInfo<Integer> results = personnelUpdateBlogic.execute(reqt);
		return new ResponseEntity<>(results, HttpStatus.OK);
	}

	@Autowired
	private IBlogic<PersonnelDeleteReqtDto, Integer> personnelDeleteBlogic;

	@DeleteMapping("/pesonnel/delete")
	@ApiOperation(value = "[配送管理api]->删除配送人员信息", notes = "根据PersonnelDeleteReqtDto删除配送人员信息")
	public ResponseEntity<ResultInfo<Integer>> deletePesonnel(@RequestBody @ApiParam @Valid PersonnelDeleteReqtDto reqt) throws Exception {
		log.debug("REST[配送管理api]->根据PersonnelDeleteReqtDto更新配送人员信息：{}", reqt);
		ResultInfo<Integer> results = personnelDeleteBlogic.execute(reqt);
		return new ResponseEntity<>(results, HttpStatus.OK);
	}

	@Autowired
	private IBlogic<RegionsQueryReqtDto, List<RegionsQueryRespDto>> regionsQueryBlogic;

	@PostMapping("/regions")
	@ApiOperation(value = "[配送管理api]->根据上级id查询区域", notes = "根据RegionsQueryReqtDto根据上级id查询区域")
	public ResponseEntity<ResultInfo<List<RegionsQueryRespDto>>> regions(@RequestBody @ApiParam @Valid RegionsQueryReqtDto reqt) throws Exception {
		log.debug("REST[配送管理api]->根据RegionsQueryReqtDto根据上级id查询区域：{}", reqt);
		ResultInfo<List<RegionsQueryRespDto>> results = regionsQueryBlogic.execute(reqt);
		return new ResponseEntity<>(results, HttpStatus.OK);
	}

	@Autowired
	private IBlogic<DeliveryOrderQueryReqtDto, List<DeliveryOrderQueryRespDto>> deliveryOrderQueryBlogic;

	@PostMapping("/order/list")
	@ApiOperation(value = "[配送管理api]->查询配送单列表", notes = "根据DeliveryOrderQueryReqtDto查询配送单列表")
	public ResponseEntity<ResultInfo<List<DeliveryOrderQueryRespDto>>> getDeliveryOrders(@RequestBody @ApiParam @Valid DeliveryOrderQueryReqtDto reqt) throws Exception {
		log.debug("REST[配送管理api]->根据DeliveryOrderQueryReqtDto根据上级id查询配送单列表：{}", reqt);
		ResultInfo<List<DeliveryOrderQueryRespDto>> results = deliveryOrderQueryBlogic.execute(reqt);
		return new ResponseEntity<>(results, HttpStatus.OK);
	}

	@Autowired
	private IBlogic<DeliveryOrderHaveAddReqtDto, Integer> deliveryOrderHaveAddBlogic;

	@PostMapping("/order/add")
	@ApiOperation(value = "[配送管理api]->自有物流配送单新增", notes = "根据DeliveryOrderHaveAddReqtDto自有物流配送单新增")
	public ResponseEntity<ResultInfo<Integer>> add(@RequestBody @ApiParam @Valid DeliveryOrderHaveAddReqtDto reqt) throws Exception {
		log.debug("REST[配送管理api]->根据DeliveryOrderHaveAddReqtDto自有物流配送单新增：{}", reqt);
		ResultInfo<Integer> results = deliveryOrderHaveAddBlogic.execute(reqt);
		return new ResponseEntity<>(results, HttpStatus.OK);
	}
}
