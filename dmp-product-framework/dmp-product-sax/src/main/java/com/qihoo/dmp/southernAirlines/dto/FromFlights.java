package com.qihoo.dmp.southernAirlines.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.HashSet;

/**
 * @author: jiahaixin
 * @date: 2019/1/16 15:13
 * @description:
 */

@Setter
@Getter
@ToString
public class FromFlights implements Serializable {


    private static final long serialVersionUID = 4805473349911986185L;

    private String DEPCITY;          //起飞城市
    private String DEPCTIYNAME_ZH;
    private String DEPCTIYNAME_EN;
    private String REGION;
    private String REGION_CODE;

    private HashSet<Flight> FLIGHT;   //所有目的航线信息集合
}
