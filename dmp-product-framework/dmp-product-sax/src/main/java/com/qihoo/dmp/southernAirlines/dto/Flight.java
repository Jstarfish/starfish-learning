package com.qihoo.dmp.southernAirlines.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author: jiahaixin
 * @date: 2019/1/16 15:14
 * @description:
 */
@Setter
@Getter
@ToString
public class Flight implements Serializable {

    private static final long serialVersionUID = -8021696843717164732L;
    private String ARRCITY;               //到达城市
    private String ARRCTIYNAME_ZH;
    private String ARRCTIYNAME_EN;
    private String DEPDATE;              //出发日期
    private String RETURNDATE;           //到达日期
    private String SEGTYPE;              //往返标识,S:单程,R:往返程
    private String MINPRICE;
    private String money;                //价格单位
}
