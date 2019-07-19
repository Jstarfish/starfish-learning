package com.qihoo.dmp.southernAirlines.bo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: jiahaixin
 * @date: 2019/1/16 15:45
 * @description:
 */
@Setter
@Getter
public class FlightProductStruct implements Serializable {

    private static final long serialVersionUID = 6108016349621695817L;

    private String pid;
    private String pName;
    private String price;
    private String clickUrl;
    private String imgUrl;


    private String priceUnit;
    private String origin;      //出发地
    private String destination;  //目的地

    private Date depDate;    //出发日期
    private Date returnDate;







    private String imgUrl1;
    private String imgUrl2;
    private String imgUrl3;

    private String category;
    private String subCategory;
    private String thirdCategory;
    private String androidDplink;
    private String iosDplink;
    private String targetUrl;
    private String mClickUrl;
    private String title;
    private String availability;
    private String inventoryNum;
    private String lproperty;
    private String sellerSiteUrl;
    private String bName;
    private String label;
}
