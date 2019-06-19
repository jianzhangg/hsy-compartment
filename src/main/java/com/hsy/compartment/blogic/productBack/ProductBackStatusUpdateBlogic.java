package com.hsy.compartment.blogic.productBack;

import com.hsy.common.bean.User;
import com.hsy.common.context.ContextHolder;
import com.hsy.common.utils.DateUtils;
import com.hsy.compartment.dto.productBack.ProductBackStatusUpdateReqtDto;
import com.hsy.compartment.sql.productBack.ProductBackStatusUpdateSqlInDto;
import com.hsy.compartment.sql.productBackLog.ProductBackLogInsertSqlInDto;
import com.hsy.core.bean.ResultInfo;
import com.hsy.core.service.IBlogic;
import com.hsy.core.utils.BeanUtils;
import com.hsy.core.utils.ResultUtils;
import com.hsy.mybatis.QueryDao;
import com.hsy.mybatis.UpdateDao;
import com.hsy.resource.enums.ProductBackState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author 黄必诚
 * @date 2019/6/6 15:18
 * @description 退货单审核(通过/不通过)
 */
@Service("productBackStatusUpdateBlogic")
@Transactional(rollbackFor = Exception.class)
public class ProductBackStatusUpdateBlogic implements IBlogic<ProductBackStatusUpdateReqtDto,Integer> {

    @Autowired
    private UpdateDao updateDao;

    @Override
    public ResultInfo execute(ProductBackStatusUpdateReqtDto reqtDto) throws Exception {
        /* 修改退货单 */
        ProductBackStatusUpdateSqlInDto inDto = BeanUtils.copy(reqtDto, ProductBackStatusUpdateSqlInDto.class);
        Integer result = updateDao.execute("productStatuUpdateSql", inDto);
        /* 新增退货流水纪录*/
        User user = ContextHolder.getUser();
        ProductBackLogInsertSqlInDto backLogInsertSqlInDto = new ProductBackLogInsertSqlInDto();
        backLogInsertSqlInDto.setMemberProductBackId(reqtDto.getId());
        backLogInsertSqlInDto.setContent(ProductBackState.getByState(reqtDto.getStateReturn()));
        backLogInsertSqlInDto.setOperatingId(user.getId());
        backLogInsertSqlInDto.setOperatingName(user.getUsername());
        backLogInsertSqlInDto.setCreateTime(DateUtils.nowDate());
        int execute = updateDao.execute("productBackLogInsertSql", backLogInsertSqlInDto);
        return ResultUtils.createRet(result);
    }
}
