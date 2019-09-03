package com.qihoo.dmp;

import com.qihoo.dmp.southernAirlines.utils.RSA;
import com.qihoo.dmp.southernAirlines.utils.HttpClientUtils;

/**
 * @author: jiahaixin
 * @date: 2019/1/16 17:14
 * @description:
 */
public class httpClientTest extends DmpApplicationTests{



    public static void main(String[] args) {
        String url = "http://58.248.41.144/E-UNION/data/service/minPrice/queryMinPriceInSeventyOfInternational.json?type=360Search&param=360Search@2019";

        String account = "360Search";
        String password = "360Search@2019";

        try {
            String completeUrl = String.format("%s?type=%s", url, account);
            //加密后的密码
            String cipher = null;

            cipher = RSA.toHexString(new RSA().encrypt(password, RSA.getPublicKey()));
            System.out.println(cipher);

            completeUrl = String.format("%s&param=%s", completeUrl, cipher);

            System.out.println(completeUrl);

            //请求参数封装
            String isInter = "N";
            String channel = "PC";
            String params = "{\"isInter\":\"" + isInter + "\",\"channel\":\"" + channel + "\"}";

            //发送请求，获取结果
            String result = HttpClientUtils.httpPost(completeUrl,params,null);



            System.out.println("result:"+result);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
