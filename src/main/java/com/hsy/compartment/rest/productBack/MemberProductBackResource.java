package com.hsy.compartment.rest.productBack;

import com.hsy.compartment.dto.order.orderQuery.OrderQueryReqtDto;
import com.hsy.compartment.dto.order.orderQuery.OrderQueryRespDto;
import com.hsy.compartment.dto.productBack.MemberProductBackDetailRespDto;
import com.hsy.compartment.dto.productBack.MemberProductBackReqtDto;
import com.hsy.compartment.dto.productBack.MemberProductBackRespDto;
import com.hsy.compartment.dto.productBack.ProductBackStatusUpdateReqtDto;
import com.hsy.core.bean.ResultInfo;
import com.hsy.core.service.IBlogic;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author 黄必诚
 * @date 2019/6/6 10:47
 * @description
 */
@Slf4j
@RestController
@RequestMapping("back")
@Api(value = "MemberProductBackResource", tags = "退货api")
public class MemberProductBackResource {
    @Autowired
    private IBlogic<MemberProductBackReqtDto,List<MemberProductBackRespDto>> memberProductBackListBlogic;

    @PostMapping("/list")
    @ApiOperation(value = "[退货api]->查询退货列表信息", notes = "根据MemberProductBackReqtDto查询退货列表信息")
    public ResponseEntity<ResultInfo<List<MemberProductBackRespDto>>> getOrderList(@RequestBody @ApiParam @Valid MemberProductBackReqtDto reqt) throws Exception {
        log.debug("REST[退货api]->根据MemberProductBackReqtDto查询退货列表信息：{}", reqt);
        ResultInfo<List<MemberProductBackRespDto>> results = memberProductBackListBlogic.execute(reqt);
        return new ResponseEntity<>(results, HttpStatus.OK);
    }

    @Autowired
    private  IBlogic<Integer, MemberProductBackDetailRespDto> memberProductBackDetailBlogic;

    @GetMapping("/detail/{id}")
    @ApiOperation(value = "[退货api]->查询退货详情信息", notes = "根据主键id查询退货详情信息")
    public ResponseEntity<ResultInfo<MemberProductBackDetailRespDto>> getOrderDetail(@PathVariable Integer id) throws Exception {
        log.debug("REST[退货api]->根据id查询退货详情信息：{}", id);
        ResultInfo<MemberProductBackDetailRespDto> result = memberProductBackDetailBlogic.execute(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Autowired
    private  IBlogic<ProductBackStatusUpdateReqtDto,Integer> productBackStatusUpdateBlogic;

    @PutMapping("/adopt")
    @ApiOperation(value = "[退货api]->审核(通过/不通过)", notes = "根据审核结果更新退货状态")
    public ResponseEntity<ResultInfo<Integer>> adopt(@RequestBody @ApiParam @Valid ProductBackStatusUpdateReqtDto reqtDto) throws Exception{
        log.debug("REST[退货api]->根据审核结果更新退货状态：{}", reqtDto);
        ResultInfo<Integer> resultInfo = productBackStatusUpdateBlogic.execute(reqtDto);
        return new ResponseEntity<>(resultInfo,HttpStatus.OK);
    }
}
