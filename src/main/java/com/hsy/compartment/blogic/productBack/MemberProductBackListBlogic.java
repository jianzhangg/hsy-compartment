package com.hsy.compartment.blogic.productBack;

import com.hsy.common.bean.PageInfo;
import com.hsy.common.bean.User;
import com.hsy.common.context.ContextHolder;
import com.hsy.compartment.dto.productBack.MemberProductBackReqtDto;
import com.hsy.compartment.dto.productBack.MemberProductBackRespDto;
import com.hsy.compartment.sql.productBack.MemberProdcutBackSqlInDto;
import com.hsy.compartment.sql.productBack.MemberProdcutBackSqlOutDto;
import com.hsy.core.bean.ResultInfo;
import com.hsy.core.service.IBlogic;
import com.hsy.core.utils.BeanUtils;
import com.hsy.mybatis.QueryDao;
import com.hsy.mybatis.utils.PageBeanUtils;
import com.hsy.mybatis.utils.PageResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 黄必诚
 * @date 2019/6/6 10:19
 * @description
 */
@Service("memberProductBackListBlogic")
@Transactional(rollbackFor = Exception.class)
public class MemberProductBackListBlogic implements IBlogic<MemberProductBackReqtDto,List<MemberProductBackRespDto>> {

    @Autowired
    private QueryDao queryDao;

    @Override
    public ResultInfo execute(MemberProductBackReqtDto reqtDto) throws Exception {
        MemberProdcutBackSqlInDto sqlInDto = BeanUtils.copy(reqtDto, MemberProdcutBackSqlInDto.class);
        User user = ContextHolder.getUser();
        sqlInDto.setSellerId(user.getSellerId());
        PageInfo pageInfo = ContextHolder.getPage();
        List<MemberProdcutBackSqlOutDto> sqlOutDtos = queryDao.executeForObjectListByPage("memberProductBackQuerySqlList", sqlInDto, pageInfo);
        List<MemberProductBackRespDto> results = PageBeanUtils.copy(sqlOutDtos, MemberProductBackRespDto.class);
        return PageResultUtils.createRet(results);
    }
}
