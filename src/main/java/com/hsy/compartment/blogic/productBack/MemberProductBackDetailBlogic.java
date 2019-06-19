package com.hsy.compartment.blogic.productBack;

import com.hsy.common.exception.BLogicException;
import com.hsy.common.utils.ObjectUtils;
import com.hsy.compartment.dto.productBack.MemberProductBackDetailRespDto;
import com.hsy.compartment.sql.productBack.MemberProductBackDetailSqlOutDto;
import com.hsy.core.bean.ResultInfo;
import com.hsy.core.service.IBlogic;
import com.hsy.core.utils.BeanUtils;
import com.hsy.core.utils.ResultUtils;
import com.hsy.mybatis.QueryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 黄必诚
 * @date 2019/6/6 14:07
 * @description  退货明细查询
 */
@Service("memberProductBackDetailBlogic")
@Transactional(rollbackFor = Exception.class)
public class MemberProductBackDetailBlogic implements IBlogic<Integer, MemberProductBackDetailRespDto> {

    @Autowired
    private QueryDao queryDao;

    @Override
    public ResultInfo<MemberProductBackDetailRespDto> execute(Integer id) throws Exception {
        MemberProductBackDetailSqlOutDto sqlOutDto = queryDao.executeForObject("productBackDetailById", id, MemberProductBackDetailSqlOutDto.class);
        if (ObjectUtils.isEmpty(sqlOutDto)) {
            throw new BLogicException("退货单不存在.");
        }
        MemberProductBackDetailRespDto result = BeanUtils.copy(sqlOutDto, MemberProductBackDetailRespDto.class);
        return ResultUtils.createRet(result);
    }
}
