package com.hsy.compartment.rest.account;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hsy.core.bean.ResultInfo;
import com.hsy.core.service.IBlogic;
import com.hsy.compartment.dto.account.AdminLoginReqtDto;
import com.hsy.compartment.dto.account.AdminLoginRespDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("admin")
@Api(value = "AdminResource", tags = "用户api")
public class AdminResource {

	@Autowired
	private IBlogic<AdminLoginReqtDto, AdminLoginRespDto> adminBlogic;

	@PostMapping("/login")
	@ApiOperation(value = "[用户api]->根据name生成token", notes = "根据name生成token")
	public ResponseEntity<ResultInfo<AdminLoginRespDto>> login(@RequestBody @ApiParam @Valid AdminLoginReqtDto reqt) throws Exception {
		log.debug("REST[用户api]->根据name生成token : {}", reqt);
		ResultInfo<AdminLoginRespDto> results = adminBlogic.execute(reqt);
		return new ResponseEntity<>(results, HttpStatus.OK);
	}
}
