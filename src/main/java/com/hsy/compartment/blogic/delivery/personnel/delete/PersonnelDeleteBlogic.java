package com.hsy.compartment.blogic.delivery.personnel.delete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hsy.core.bean.ResultInfo;
import com.hsy.core.service.IBlogic;
import com.hsy.core.utils.ResultUtils;
import com.hsy.mybatis.UpdateDao;
import com.hsy.compartment.dto.delivery.personnel.delete.PersonnelDeleteReqtDto;

/**
 * @author 张梓枫
 * @date 2019年5月29日上午10:54:26
 * @description 删除配送人员业务类
 */
@Service("personnelDeleteBlogic")
@Transactional(rollbackFor = Exception.class)
public class PersonnelDeleteBlogic implements IBlogic<PersonnelDeleteReqtDto, Integer> {

	@Autowired
	private UpdateDao updateDao;

	@Override
	public ResultInfo<Integer> execute(PersonnelDeleteReqtDto paramP) throws Exception {
		Integer id = paramP.getId();
		updateDao.execute("PersonnelSetAreasDeleteSql", id);
		Integer result = updateDao.execute("PersonnelDeleteSql", id);
		return ResultUtils.createRet(result);
	}

}
