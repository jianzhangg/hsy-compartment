package com.hsy.compartment.dto.productBack;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hsy.common.constant.CommonConstant;
import com.hsy.common.utils.DateUtils;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 黄必诚
 * @date 2019/6/6 14:09
 * @description
 */
@Data
public class MemberProductBackDetailRespDto implements Serializable{

    private static final long serialVersionUID = 3472250329570428836L;

    @ApiModelProperty(value = "退货单id")
    private Integer id;

    @ApiModelProperty(value = "订单号")
    private String orderSn;

    @ApiModelProperty(value = "网单ID")
    private Integer orderProductId;

    @ApiModelProperty(value = "商品ID")
    private Integer productId;

    @ApiModelProperty(value = "商品名称")
    private String productName;

    @ApiModelProperty(value = "退款人姓名")
    private String memberName;

    @ApiModelProperty(value = "退货数量")
    private Integer number;

    @ApiModelProperty(value = "退款金额")
    private BigDecimal backMoney;

    @ApiModelProperty(value = "退货状态：1、未处理；2、审核通过；3、用户发货，4、店铺收货；5、不予处理；6、审核不通过；7、不予处理驳回")
    private Integer stateReturn;

    @ApiModelProperty(value = "退款状态：1、未退款；2、退款到账户；3、退款到银行")
    private Integer stateMoney;

    @ApiModelProperty(value = "退款时间")
    @JsonFormat(pattern = DateUtils.PATTERN_NORMAL, timezone = CommonConstant.TIMEZONE)
    private Date backMoneyTime;

    @ApiModelProperty(value = "退款单生成时间")
    @JsonFormat(pattern = DateUtils.PATTERN_NORMAL, timezone = CommonConstant.TIMEZONE)
    private Date createTime;

    @ApiModelProperty(value = "退货人地址")
    private String address;

    @ApiModelProperty(value = "物流公司")
    private String logistics_name;

    @ApiModelProperty(value = "快递单号")
    private String logistics_number;

    @ApiModelProperty(value = "问题描述")
    private String question;

    @ApiModelProperty(value = "问题图片")
    private String image;

    @ApiModelProperty(value = "处理人名称")
    private String optName;

    @ApiModelProperty(value = "平台端审核人名称")
    private String adminOptName;

    @ApiModelProperty(value = "平台驳回理由")
    private String rejectDesc;
}
