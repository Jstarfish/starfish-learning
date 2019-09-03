package com.qihoo.dmp.southernAirlines.dto;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.HashSet;

/**
 * @author: jiahaixin
 * @date: 2019/1/16 15:09
 * @description:
 */
@Setter
@Getter
@ToString
public class ResponseEntity implements Serializable {


    private static final long serialVersionUID = -6285422470784079389L;

    @JSONField(name = "FROMOFLIGHTS")
    HashSet<FromFlights> FROMOFLIGHTS;   //航线信息
}
