package com.qihoo.dmp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qihoo.dmp.southernAirlines.dto.Flight;
import com.qihoo.dmp.southernAirlines.dto.FromFlights;
import com.qihoo.dmp.southernAirlines.dto.ResponseEntity;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

/**
 * @author: jiahaixin
 * @date: 2019/1/16 17:11
 * @description:
 */
public class FastjsonTest extends DmpApplicationTests{

    @Test
    public void testHashSetToJson(){

        Flight flight1 = new Flight();
        Flight flight2 = new Flight();
        Flight flight3 = new Flight();

        flight1.setARRCITY("哈尔滨");
        flight1.setARRCTIYNAME_EN("Harbin");
        flight1.setARRCTIYNAME_ZH("哈尔滨");
        flight1.setDEPDATE("2019-01-16");
        flight1.setRETURNDATE("2019-01-16");
        flight1.setSEGTYPE("S");
        flight1.setMINPRICE("1430");
        flight1.setMoney("RMB");

        flight2.setARRCITY("纽约");
        flight2.setARRCTIYNAME_EN("New York");
        flight2.setARRCTIYNAME_ZH("纽约");
        flight2.setDEPDATE("2019-02-16");
        flight2.setRETURNDATE("2019-02-17");
        flight2.setSEGTYPE("R");
        flight2.setMINPRICE("800");
        flight2.setMoney("dollar");

        flight3.setARRCITY("柬埔寨");
        flight3.setARRCTIYNAME_EN("Cambodia");
        flight3.setARRCTIYNAME_ZH("柬埔寨");
        flight3.setDEPDATE("2019-03-01");
        flight3.setRETURNDATE("2019-03-01");
        flight3.setSEGTYPE("S");
        flight3.setMINPRICE("10000000");
        flight3.setMoney("riel");

        HashSet<Flight> FLIGHT = new HashSet<>();
        FLIGHT.add(flight1);
        FLIGHT.add(flight2);
        FLIGHT.add(flight3);

        FromFlights fromFlights1 = new FromFlights();
        FromFlights fromFlights2 = new FromFlights();


        fromFlights2.setDEPCITY("太原");
        fromFlights2.setDEPCTIYNAME_EN("Taiyuan");
        fromFlights2.setDEPCTIYNAME_ZH("太原");
        fromFlights2.setREGION("中国");
        fromFlights2.setREGION_CODE("001");
        fromFlights2.setFLIGHT(FLIGHT);

        fromFlights1.setDEPCITY("北京");
        fromFlights1.setDEPCTIYNAME_EN("Beijing");
        fromFlights1.setDEPCTIYNAME_ZH("北京");
        fromFlights1.setREGION("中国");
        fromFlights1.setREGION_CODE("001");
        fromFlights1.setFLIGHT(FLIGHT);


        HashSet<FromFlights> fromFlights = new HashSet<>();
        fromFlights.add(fromFlights1);
        fromFlights.add(fromFlights2);

        ResponseEntity response = new ResponseEntity();
        response.setFROMOFLIGHTS(fromFlights);

        String result = JSON.toJSONString(response);

        Assert.assertNotNull(result);
        System.out.println(result);
    }


    @Test
    public void testjsonToHashSet(){

        String jsonStr = "{\n" +
                "    \"data\": {\n" +
                "        \"FROMOFLIGHTS\": [\n" +
                "            {\n" +
                "                \"DEPCITY\": \"CSX\",\n" +
                "                \"DEPCTIYNAME_EN\": \"changsha\",\n" +
                "                \"DEPCTIYNAME_ZH\": \"长沙\",\n" +
                "                \"FLIGHT\": [\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"SZX\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"shenzhen\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"深圳\",\n" +
                "                        \"DEPDATE\": \"2019-02-23\",\n" +
                "                        \"MINPRICE\": \"1000\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"CKG\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"chongqing\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"重庆\",\n" +
                "                        \"DEPDATE\": \"2019-01-30\",\n" +
                "                        \"MINPRICE\": \"990\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"PVG\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"ShanghaiPudong\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"上海浦东\",\n" +
                "                        \"DEPDATE\": \"2019-01-23\",\n" +
                "                        \"MINPRICE\": \"530\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"PEK\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"beijing\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"北京\",\n" +
                "                        \"DEPDATE\": \"2019-01-21\",\n" +
                "                        \"MINPRICE\": \"730\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"SYX\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"sanya\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"三亚\",\n" +
                "                        \"DEPDATE\": \"2019-01-19\",\n" +
                "                        \"MINPRICE\": \"1160\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"CAN\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"guangzhou\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"广州\",\n" +
                "                        \"DEPDATE\": \"2019-01-19\",\n" +
                "                        \"MINPRICE\": \"200\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"CTU\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"chengdu\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"成都\",\n" +
                "                        \"DEPDATE\": \"2019-01-31\",\n" +
                "                        \"MINPRICE\": \"1010\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"HAK\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"haikou\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"海口\",\n" +
                "                        \"DEPDATE\": \"2019-01-24\",\n" +
                "                        \"MINPRICE\": \"1180\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"UYN\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"yulin\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"榆林\",\n" +
                "                        \"DEPDATE\": \"2019-01-31\",\n" +
                "                        \"MINPRICE\": \"930\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"CGQ\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"changchun\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"长春\",\n" +
                "                        \"DEPDATE\": \"2019-01-24\",\n" +
                "                        \"MINPRICE\": \"1220\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"REGION\": \"华中\",\n" +
                "                \"REGION_CODE\": \"HZ\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"DEPCITY\": \"XMN\",\n" +
                "                \"DEPCTIYNAME_EN\": \"xiamen\",\n" +
                "                \"DEPCTIYNAME_ZH\": \"厦门\",\n" +
                "                \"FLIGHT\": [\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"CAN\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"guangzhou\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"广州\",\n" +
                "                        \"DEPDATE\": \"2019-01-24\",\n" +
                "                        \"MINPRICE\": \"620\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"WUH\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"wuhan\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"武汉\",\n" +
                "                        \"DEPDATE\": \"2019-02-22\",\n" +
                "                        \"MINPRICE\": \"630\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"HRB\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"harbin\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"哈尔滨\",\n" +
                "                        \"DEPDATE\": \"2019-03-13\",\n" +
                "                        \"MINPRICE\": \"1250\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"REGION\": \"华东\",\n" +
                "                \"REGION_CODE\": \"HD\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"DEPCITY\": \"URC\",\n" +
                "                \"DEPCTIYNAME_EN\": \"urumqi\",\n" +
                "                \"DEPCTIYNAME_ZH\": \"乌鲁木齐\",\n" +
                "                \"FLIGHT\": [\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"SZX\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"shenzhen\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"深圳\",\n" +
                "                        \"DEPDATE\": \"2019-01-19\",\n" +
                "                        \"MINPRICE\": \"2210\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"CTU\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"chengdu\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"成都\",\n" +
                "                        \"DEPDATE\": \"2019-02-25\",\n" +
                "                        \"MINPRICE\": \"1060\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"REGION\": \"西北\",\n" +
                "                \"REGION_CODE\": \"XB\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"DEPCITY\": \"SZX\",\n" +
                "                \"DEPCTIYNAME_EN\": \"shenzhen\",\n" +
                "                \"DEPCTIYNAME_ZH\": \"深圳\",\n" +
                "                \"FLIGHT\": [\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"CKG\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"chongqing\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"重庆\",\n" +
                "                        \"DEPDATE\": \"2019-01-22\",\n" +
                "                        \"MINPRICE\": \"1340\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"PEK\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"beijing\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"北京\",\n" +
                "                        \"DEPDATE\": \"2019-02-08\",\n" +
                "                        \"MINPRICE\": \"1020\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"DLC\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"dalian\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"大连\",\n" +
                "                        \"DEPDATE\": \"2019-02-06\",\n" +
                "                        \"MINPRICE\": \"1100\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"HRB\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"harbin\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"哈尔滨\",\n" +
                "                        \"DEPDATE\": \"2019-02-01\",\n" +
                "                        \"MINPRICE\": \"2790\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"URC\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"urumqi\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"乌鲁木齐\",\n" +
                "                        \"DEPDATE\": \"2019-02-22\",\n" +
                "                        \"MINPRICE\": \"2560\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"REGION\": \"华南\",\n" +
                "                \"REGION_CODE\": \"HN\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"DEPCITY\": \"PEK\",\n" +
                "                \"DEPCTIYNAME_EN\": \"beijing\",\n" +
                "                \"DEPCTIYNAME_ZH\": \"北京\",\n" +
                "                \"FLIGHT\": [\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"DLC\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"dalian\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"大连\",\n" +
                "                        \"DEPDATE\": \"2019-01-23\",\n" +
                "                        \"MINPRICE\": \"460\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"HAK\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"haikou\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"海口\",\n" +
                "                        \"DEPDATE\": \"2019-01-23\",\n" +
                "                        \"MINPRICE\": \"1100\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"KWE\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"guiyang\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"贵阳\",\n" +
                "                        \"DEPDATE\": \"2019-01-19\",\n" +
                "                        \"MINPRICE\": \"1000\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"HGH\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"hangzhou\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"杭州\",\n" +
                "                        \"DEPDATE\": \"2019-01-19\",\n" +
                "                        \"MINPRICE\": \"980\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"SHE\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"shenyang\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"沈阳\",\n" +
                "                        \"DEPDATE\": \"2019-01-31\",\n" +
                "                        \"MINPRICE\": \"1180\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"NNG\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"nanning\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"南宁\",\n" +
                "                        \"DEPDATE\": \"2019-02-11\",\n" +
                "                        \"MINPRICE\": \"1050\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"CSX\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"changsha\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"长沙\",\n" +
                "                        \"DEPDATE\": \"2019-02-04\",\n" +
                "                        \"MINPRICE\": \"730\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"SIA\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"xi'an\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"西安\",\n" +
                "                        \"DEPDATE\": \"2019-01-19\",\n" +
                "                        \"MINPRICE\": \"910\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"CTU\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"chengdu\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"成都\",\n" +
                "                        \"DEPDATE\": \"2019-02-20\",\n" +
                "                        \"MINPRICE\": \"830\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"CKG\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"chongqing\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"重庆\",\n" +
                "                        \"DEPDATE\": \"2019-02-26\",\n" +
                "                        \"MINPRICE\": \"800\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"BHY\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"beihai\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"北海\",\n" +
                "                        \"DEPDATE\": \"2019-01-23\",\n" +
                "                        \"MINPRICE\": \"2250\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"WUH\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"wuhan\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"武汉\",\n" +
                "                        \"DEPDATE\": \"2019-01-23\",\n" +
                "                        \"MINPRICE\": \"930\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"KWL\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"guilin\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"桂林\",\n" +
                "                        \"DEPDATE\": \"2019-02-27\",\n" +
                "                        \"MINPRICE\": \"600\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"SYX\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"sanya\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"三亚\",\n" +
                "                        \"DEPDATE\": \"2019-01-19\",\n" +
                "                        \"MINPRICE\": \"2130\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"SZX\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"shenzhen\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"深圳\",\n" +
                "                        \"DEPDATE\": \"2019-02-02\",\n" +
                "                        \"MINPRICE\": \"1020\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"HRB\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"harbin\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"哈尔滨\",\n" +
                "                        \"DEPDATE\": \"2019-02-07\",\n" +
                "                        \"MINPRICE\": \"580\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"SHA\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"Shanghaihongqiao\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"上海虹桥\",\n" +
                "                        \"DEPDATE\": \"2019-01-25\",\n" +
                "                        \"MINPRICE\": \"670\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"CAN\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"guangzhou\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"广州\",\n" +
                "                        \"DEPDATE\": \"2019-02-15\",\n" +
                "                        \"MINPRICE\": \"940\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"REGION\": \"华北\",\n" +
                "                \"REGION_CODE\": \"HB\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"DEPCITY\": \"CTU\",\n" +
                "                \"DEPCTIYNAME_EN\": \"chengdu\",\n" +
                "                \"DEPCTIYNAME_ZH\": \"成都\",\n" +
                "                \"FLIGHT\": [\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"NNG\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"nanning\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"南宁\",\n" +
                "                        \"DEPDATE\": \"2019-01-25\",\n" +
                "                        \"MINPRICE\": \"700\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"CAN\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"guangzhou\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"广州\",\n" +
                "                        \"DEPDATE\": \"2019-01-19\",\n" +
                "                        \"MINPRICE\": \"300\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"PEK\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"beijing\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"北京\",\n" +
                "                        \"DEPDATE\": \"2019-01-19\",\n" +
                "                        \"MINPRICE\": \"830\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"URC\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"urumqi\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"乌鲁木齐\",\n" +
                "                        \"DEPDATE\": \"2019-01-30\",\n" +
                "                        \"MINPRICE\": \"1170\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"CSX\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"changsha\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"长沙\",\n" +
                "                        \"DEPDATE\": \"2019-01-30\",\n" +
                "                        \"MINPRICE\": \"820\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"REGION\": \"西南\",\n" +
                "                \"REGION_CODE\": \"XN\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"DEPCITY\": \"HAK\",\n" +
                "                \"DEPCTIYNAME_EN\": \"haikou\",\n" +
                "                \"DEPCTIYNAME_ZH\": \"海口\",\n" +
                "                \"FLIGHT\": [\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"CAN\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"guangzhou\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"广州\",\n" +
                "                        \"DEPDATE\": \"2019-01-24\",\n" +
                "                        \"MINPRICE\": \"300\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"CKG\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"chongqing\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"重庆\",\n" +
                "                        \"DEPDATE\": \"2019-02-26\",\n" +
                "                        \"MINPRICE\": \"1310\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"REGION\": \"华南\",\n" +
                "                \"REGION_CODE\": \"HN\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"DEPCITY\": \"SYX\",\n" +
                "                \"DEPCTIYNAME_EN\": \"sanya\",\n" +
                "                \"DEPCTIYNAME_ZH\": \"三亚\",\n" +
                "                \"FLIGHT\": [\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"CAN\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"guangzhou\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"广州\",\n" +
                "                        \"DEPDATE\": \"2019-01-24\",\n" +
                "                        \"MINPRICE\": \"700\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"PEK\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"beijing\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"北京\",\n" +
                "                        \"DEPDATE\": \"2019-03-13\",\n" +
                "                        \"MINPRICE\": \"1870\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"REGION\": \"华南\",\n" +
                "                \"REGION_CODE\": \"HN\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"DEPCITY\": \"KWL\",\n" +
                "                \"DEPCTIYNAME_EN\": \"guilin\",\n" +
                "                \"DEPCTIYNAME_ZH\": \"桂林\",\n" +
                "                \"FLIGHT\": [\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"PEK\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"beijing\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"北京\",\n" +
                "                        \"DEPDATE\": \"2019-02-28\",\n" +
                "                        \"MINPRICE\": \"900\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"REGION\": \"华南\",\n" +
                "                \"REGION_CODE\": \"HN\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"DEPCITY\": \"CAN\",\n" +
                "                \"DEPCTIYNAME_EN\": \"guangzhou\",\n" +
                "                \"DEPCTIYNAME_ZH\": \"广州\",\n" +
                "                \"FLIGHT\": [\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"PEK\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"beijing\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"北京\",\n" +
                "                        \"DEPDATE\": \"2019-01-19\",\n" +
                "                        \"MINPRICE\": \"900\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"SWA\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"shantou\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"汕头\",\n" +
                "                        \"DEPDATE\": \"2019-01-20\",\n" +
                "                        \"MINPRICE\": \"100\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"CGO\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"zhengzhou\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"郑州\",\n" +
                "                        \"DEPDATE\": \"2019-01-27\",\n" +
                "                        \"MINPRICE\": \"1410\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"DYG\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"zhangjiajie\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"张家界\",\n" +
                "                        \"DEPDATE\": \"2019-02-14\",\n" +
                "                        \"MINPRICE\": \"500\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"NAO\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"nanchong\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"南充\",\n" +
                "                        \"DEPDATE\": \"2019-01-30\",\n" +
                "                        \"MINPRICE\": \"3840\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"WUH\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"wuhan\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"武汉\",\n" +
                "                        \"DEPDATE\": \"2019-01-19\",\n" +
                "                        \"MINPRICE\": \"90\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"LXA\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"lhasa\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"拉萨\",\n" +
                "                        \"DEPDATE\": \"2019-02-15\",\n" +
                "                        \"MINPRICE\": \"2780\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"CGQ\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"changchun\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"长春\",\n" +
                "                        \"DEPDATE\": \"2019-01-28\",\n" +
                "                        \"MINPRICE\": \"2580\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"BHY\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"beihai\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"北海\",\n" +
                "                        \"DEPDATE\": \"2019-02-23\",\n" +
                "                        \"MINPRICE\": \"320\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"TAO\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"qingdao\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"青岛\",\n" +
                "                        \"DEPDATE\": \"2019-02-13\",\n" +
                "                        \"MINPRICE\": \"1170\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"LJG\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"lijiang\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"丽江\",\n" +
                "                        \"DEPDATE\": \"2019-01-23\",\n" +
                "                        \"MINPRICE\": \"100\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"HGH\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"hangzhou\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"杭州\",\n" +
                "                        \"DEPDATE\": \"2019-01-19\",\n" +
                "                        \"MINPRICE\": \"580\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"NKG\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"nanjing\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"南京\",\n" +
                "                        \"DEPDATE\": \"2019-02-05\",\n" +
                "                        \"MINPRICE\": \"640\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"LYG\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"lianyungang\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"连云港\",\n" +
                "                        \"DEPDATE\": \"2019-03-14\",\n" +
                "                        \"MINPRICE\": \"1560\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"TXN\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"huangshan\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"黄山\",\n" +
                "                        \"DEPDATE\": \"2019-01-30\",\n" +
                "                        \"MINPRICE\": \"960\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"SHE\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"shenyang\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"沈阳\",\n" +
                "                        \"DEPDATE\": \"2019-02-26\",\n" +
                "                        \"MINPRICE\": \"1200\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"URC\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"urumqi\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"乌鲁木齐\",\n" +
                "                        \"DEPDATE\": \"2019-01-19\",\n" +
                "                        \"MINPRICE\": \"840\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"DLC\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"dalian\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"大连\",\n" +
                "                        \"DEPDATE\": \"2019-01-20\",\n" +
                "                        \"MINPRICE\": \"90\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"CTU\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"chengdu\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"成都\",\n" +
                "                        \"DEPDATE\": \"2019-02-04\",\n" +
                "                        \"MINPRICE\": \"300\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"CSX\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"changsha\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"长沙\",\n" +
                "                        \"DEPDATE\": \"2019-02-12\",\n" +
                "                        \"MINPRICE\": \"90\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"NNG\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"nanning\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"南宁\",\n" +
                "                        \"DEPDATE\": \"2019-02-28\",\n" +
                "                        \"MINPRICE\": \"380\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"SIA\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"xi'an\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"西安\",\n" +
                "                        \"DEPDATE\": \"2019-02-21\",\n" +
                "                        \"MINPRICE\": \"750\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"XFN\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"xiangyang\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"襄樊\",\n" +
                "                        \"DEPDATE\": \"2019-02-03\",\n" +
                "                        \"MINPRICE\": \"1240\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"NGB\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"ningbo\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"宁波\",\n" +
                "                        \"DEPDATE\": \"2019-01-29\",\n" +
                "                        \"MINPRICE\": \"1250\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"HAK\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"haikou\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"海口\",\n" +
                "                        \"DEPDATE\": \"2019-02-11\",\n" +
                "                        \"MINPRICE\": \"300\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"KHG\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"kashgar\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"喀什\",\n" +
                "                        \"DEPDATE\": \"2019-03-10\",\n" +
                "                        \"MINPRICE\": \"2010\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"SYX\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"sanya\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"三亚\",\n" +
                "                        \"DEPDATE\": \"2019-02-17\",\n" +
                "                        \"MINPRICE\": \"100\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"DLU\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"dali\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"大理\",\n" +
                "                        \"DEPDATE\": \"2019-01-30\",\n" +
                "                        \"MINPRICE\": \"1940\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"KMG\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"kunming\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"昆明\",\n" +
                "                        \"DEPDATE\": \"2019-02-03\",\n" +
                "                        \"MINPRICE\": \"300\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"SHA\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"Shanghaihongqiao\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"上海虹桥\",\n" +
                "                        \"DEPDATE\": \"2019-01-30\",\n" +
                "                        \"MINPRICE\": \"660\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"PVG\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"ShanghaiPudong\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"上海浦东\",\n" +
                "                        \"DEPDATE\": \"2019-02-05\",\n" +
                "                        \"MINPRICE\": \"660\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"HRB\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"harbin\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"哈尔滨\",\n" +
                "                        \"DEPDATE\": \"2019-02-20\",\n" +
                "                        \"MINPRICE\": \"1400\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"HET\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"hohhot\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"呼和浩特\",\n" +
                "                        \"DEPDATE\": \"2019-01-30\",\n" +
                "                        \"MINPRICE\": \"1690\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"CKG\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"chongqing\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"重庆\",\n" +
                "                        \"DEPDATE\": \"2019-01-25\",\n" +
                "                        \"MINPRICE\": \"100\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"XMN\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"xiamen\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"厦门\",\n" +
                "                        \"DEPDATE\": \"2019-01-20\",\n" +
                "                        \"MINPRICE\": \"620\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"MXZ\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"meizhou\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"梅州\",\n" +
                "                        \"DEPDATE\": \"2019-03-12\",\n" +
                "                        \"MINPRICE\": \"510\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"REGION\": \"华南\",\n" +
                "                \"REGION_CODE\": \"HN\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"DEPCITY\": \"DLC\",\n" +
                "                \"DEPCTIYNAME_EN\": \"dalian\",\n" +
                "                \"DEPCTIYNAME_ZH\": \"大连\",\n" +
                "                \"FLIGHT\": [\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"SYX\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"sanya\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"三亚\",\n" +
                "                        \"DEPDATE\": \"2019-03-13\",\n" +
                "                        \"MINPRICE\": \"2690\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"PEK\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"beijing\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"北京\",\n" +
                "                        \"DEPDATE\": \"2019-01-27\",\n" +
                "                        \"MINPRICE\": \"460\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"WUH\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"wuhan\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"武汉\",\n" +
                "                        \"DEPDATE\": \"2019-01-28\",\n" +
                "                        \"MINPRICE\": \"950\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"CAN\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"guangzhou\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"广州\",\n" +
                "                        \"DEPDATE\": \"2019-01-19\",\n" +
                "                        \"MINPRICE\": \"1070\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"XMN\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"xiamen\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"厦门\",\n" +
                "                        \"DEPDATE\": \"2019-03-08\",\n" +
                "                        \"MINPRICE\": \"1890\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"REGION\": \"东北\",\n" +
                "                \"REGION_CODE\": \"DB\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"DEPCITY\": \"SIA\",\n" +
                "                \"DEPCTIYNAME_EN\": \"xi'an\",\n" +
                "                \"DEPCTIYNAME_ZH\": \"西安\",\n" +
                "                \"FLIGHT\": [\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"CAN\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"guangzhou\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"广州\",\n" +
                "                        \"DEPDATE\": \"2019-01-25\",\n" +
                "                        \"MINPRICE\": \"750\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"REGION\": \"西北\",\n" +
                "                \"REGION_CODE\": \"XB\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"DEPCITY\": \"HFE\",\n" +
                "                \"DEPCTIYNAME_EN\": \"hefei\",\n" +
                "                \"DEPCTIYNAME_ZH\": \"合肥\",\n" +
                "                \"FLIGHT\": [\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"CAN\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"guangzhou\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"广州\",\n" +
                "                        \"DEPDATE\": \"2019-01-30\",\n" +
                "                        \"MINPRICE\": \"580\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"REGION\": \"华东\",\n" +
                "                \"REGION_CODE\": \"HD\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"DEPCITY\": \"NNG\",\n" +
                "                \"DEPCTIYNAME_EN\": \"nanning\",\n" +
                "                \"DEPCTIYNAME_ZH\": \"南宁\",\n" +
                "                \"FLIGHT\": [\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"KWL\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"guilin\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"桂林\",\n" +
                "                        \"DEPDATE\": \"2019-03-24\",\n" +
                "                        \"MINPRICE\": \"400\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"PEK\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"beijing\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"北京\",\n" +
                "                        \"DEPDATE\": \"2019-01-19\",\n" +
                "                        \"MINPRICE\": \"1050\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"HGH\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"hangzhou\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"杭州\",\n" +
                "                        \"DEPDATE\": \"2019-02-26\",\n" +
                "                        \"MINPRICE\": \"800\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"CAN\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"guangzhou\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"广州\",\n" +
                "                        \"DEPDATE\": \"2019-03-25\",\n" +
                "                        \"MINPRICE\": \"420\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"REGION\": \"华南\",\n" +
                "                \"REGION_CODE\": \"HN\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"DEPCITY\": \"HRB\",\n" +
                "                \"DEPCTIYNAME_EN\": \"harbin\",\n" +
                "                \"DEPCTIYNAME_ZH\": \"哈尔滨\",\n" +
                "                \"FLIGHT\": [\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"SZX\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"shenzhen\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"深圳\",\n" +
                "                        \"DEPDATE\": \"2019-02-11\",\n" +
                "                        \"MINPRICE\": \"2790\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"TAO\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"qingdao\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"青岛\",\n" +
                "                        \"DEPDATE\": \"2019-01-25\",\n" +
                "                        \"MINPRICE\": \"880\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"XMN\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"xiamen\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"厦门\",\n" +
                "                        \"DEPDATE\": \"2019-03-14\",\n" +
                "                        \"MINPRICE\": \"1250\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"REGION\": \"东北\",\n" +
                "                \"REGION_CODE\": \"DB\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"DEPCITY\": \"BHY\",\n" +
                "                \"DEPCTIYNAME_EN\": \"beihai\",\n" +
                "                \"DEPCTIYNAME_ZH\": \"北海\",\n" +
                "                \"FLIGHT\": [\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"KWL\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"guilin\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"桂林\",\n" +
                "                        \"DEPDATE\": \"2019-02-28\",\n" +
                "                        \"MINPRICE\": \"450\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"REGION\": \"华南\",\n" +
                "                \"REGION_CODE\": \"HN\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"DEPCITY\": \"KMG\",\n" +
                "                \"DEPCTIYNAME_EN\": \"kunming\",\n" +
                "                \"DEPCTIYNAME_ZH\": \"昆明\",\n" +
                "                \"FLIGHT\": [\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"CAN\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"guangzhou\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"广州\",\n" +
                "                        \"DEPDATE\": \"2019-01-19\",\n" +
                "                        \"MINPRICE\": \"800\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"LJG\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"lijiang\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"丽江\",\n" +
                "                        \"DEPDATE\": \"2019-02-10\",\n" +
                "                        \"MINPRICE\": \"690\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"REGION\": \"西南\",\n" +
                "                \"REGION_CODE\": \"XN\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"DEPCITY\": \"HGH\",\n" +
                "                \"DEPCTIYNAME_EN\": \"hangzhou\",\n" +
                "                \"DEPCTIYNAME_ZH\": \"杭州\",\n" +
                "                \"FLIGHT\": [\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"CAN\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"guangzhou\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"广州\",\n" +
                "                        \"DEPDATE\": \"2019-01-25\",\n" +
                "                        \"MINPRICE\": \"640\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"PEK\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"beijing\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"北京\",\n" +
                "                        \"DEPDATE\": \"2019-02-08\",\n" +
                "                        \"MINPRICE\": \"2000\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"REGION\": \"华东\",\n" +
                "                \"REGION_CODE\": \"HD\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"DEPCITY\": \"NKG\",\n" +
                "                \"DEPCTIYNAME_EN\": \"nanjing\",\n" +
                "                \"DEPCTIYNAME_ZH\": \"南京\",\n" +
                "                \"FLIGHT\": [\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"CAN\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"guangzhou\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"广州\",\n" +
                "                        \"DEPDATE\": \"2019-01-20\",\n" +
                "                        \"MINPRICE\": \"640\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"REGION\": \"华东\",\n" +
                "                \"REGION_CODE\": \"HD\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"DEPCITY\": \"KRL\",\n" +
                "                \"DEPCTIYNAME_EN\": \"korla\",\n" +
                "                \"DEPCTIYNAME_ZH\": \"库尔勒\",\n" +
                "                \"FLIGHT\": [\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"PEK\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"beijing\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"北京\",\n" +
                "                        \"DEPDATE\": \"2019-02-04\",\n" +
                "                        \"MINPRICE\": \"1270\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"REGION\": \"西北\",\n" +
                "                \"REGION_CODE\": \"XB\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"DEPCITY\": \"WUH\",\n" +
                "                \"DEPCTIYNAME_EN\": \"wuhan\",\n" +
                "                \"DEPCTIYNAME_ZH\": \"武汉\",\n" +
                "                \"FLIGHT\": [\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"DLC\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"dalian\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"大连\",\n" +
                "                        \"DEPDATE\": \"2019-01-28\",\n" +
                "                        \"MINPRICE\": \"730\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"CAN\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"guangzhou\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"广州\",\n" +
                "                        \"DEPDATE\": \"2019-02-26\",\n" +
                "                        \"MINPRICE\": \"100\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"SIA\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"xi'an\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"西安\",\n" +
                "                        \"DEPDATE\": \"2019-03-25\",\n" +
                "                        \"MINPRICE\": \"1460\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"KMG\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"kunming\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"昆明\",\n" +
                "                        \"DEPDATE\": \"2019-01-23\",\n" +
                "                        \"MINPRICE\": \"760\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"PEK\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"beijing\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"北京\",\n" +
                "                        \"DEPDATE\": \"2019-02-19\",\n" +
                "                        \"MINPRICE\": \"1410\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"XMN\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"xiamen\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"厦门\",\n" +
                "                        \"DEPDATE\": \"2019-03-24\",\n" +
                "                        \"MINPRICE\": \"530\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"ZUH\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"zhuhai\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"珠海\",\n" +
                "                        \"DEPDATE\": \"2019-01-28\",\n" +
                "                        \"MINPRICE\": \"530\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"CKG\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"chongqing\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"重庆\",\n" +
                "                        \"DEPDATE\": \"2019-01-24\",\n" +
                "                        \"MINPRICE\": \"810\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"REGION\": \"华中\",\n" +
                "                \"REGION_CODE\": \"HZ\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"DEPCITY\": \"SWA\",\n" +
                "                \"DEPCTIYNAME_EN\": \"shantou\",\n" +
                "                \"DEPCTIYNAME_ZH\": \"汕头\",\n" +
                "                \"FLIGHT\": [\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"CAN\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"guangzhou\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"广州\",\n" +
                "                        \"DEPDATE\": \"2019-01-23\",\n" +
                "                        \"MINPRICE\": \"710\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"REGION\": \"华南\",\n" +
                "                \"REGION_CODE\": \"HN\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"DEPCITY\": \"HET\",\n" +
                "                \"DEPCTIYNAME_EN\": \"hohhot\",\n" +
                "                \"DEPCTIYNAME_ZH\": \"呼和浩特\",\n" +
                "                \"FLIGHT\": [\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"CAN\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"guangzhou\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"广州\",\n" +
                "                        \"DEPDATE\": \"2019-02-01\",\n" +
                "                        \"MINPRICE\": \"980\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"REGION\": \"华北\",\n" +
                "                \"REGION_CODE\": \"HB\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"DEPCITY\": \"UYN\",\n" +
                "                \"DEPCTIYNAME_EN\": \"yulin\",\n" +
                "                \"DEPCTIYNAME_ZH\": \"榆林\",\n" +
                "                \"FLIGHT\": [\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"CSX\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"changsha\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"长沙\",\n" +
                "                        \"DEPDATE\": \"2019-01-31\",\n" +
                "                        \"MINPRICE\": \"900\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"REGION\": \"西北\",\n" +
                "                \"REGION_CODE\": \"XB\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"DEPCITY\": \"LJG\",\n" +
                "                \"DEPCTIYNAME_EN\": \"lijiang\",\n" +
                "                \"DEPCTIYNAME_ZH\": \"丽江\",\n" +
                "                \"FLIGHT\": [\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"CKG\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"chongqing\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"重庆\",\n" +
                "                        \"DEPDATE\": \"2019-03-21\",\n" +
                "                        \"MINPRICE\": \"1290\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"CAN\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"guangzhou\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"广州\",\n" +
                "                        \"DEPDATE\": \"2019-01-27\",\n" +
                "                        \"MINPRICE\": \"770\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"REGION\": \"西南\",\n" +
                "                \"REGION_CODE\": \"XN\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"DEPCITY\": \"KWE\",\n" +
                "                \"DEPCTIYNAME_EN\": \"guiyang\",\n" +
                "                \"DEPCTIYNAME_ZH\": \"贵阳\",\n" +
                "                \"FLIGHT\": [\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"URC\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"urumqi\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"乌鲁木齐\",\n" +
                "                        \"DEPDATE\": \"2019-01-19\",\n" +
                "                        \"MINPRICE\": \"1240\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"XMN\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"xiamen\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"厦门\",\n" +
                "                        \"DEPDATE\": \"2019-01-25\",\n" +
                "                        \"MINPRICE\": \"650\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"REGION\": \"西南\",\n" +
                "                \"REGION_CODE\": \"XN\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"DEPCITY\": \"XUZ\",\n" +
                "                \"DEPCTIYNAME_EN\": \"xuzhou\",\n" +
                "                \"DEPCTIYNAME_ZH\": \"徐州\",\n" +
                "                \"FLIGHT\": [\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"CAN\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"guangzhou\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"广州\",\n" +
                "                        \"DEPDATE\": \"2019-01-30\",\n" +
                "                        \"MINPRICE\": \"1190\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"REGION\": \"华东\",\n" +
                "                \"REGION_CODE\": \"HD\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"DEPCITY\": \"SHA\",\n" +
                "                \"DEPCTIYNAME_EN\": \"Shanghaihongqiao\",\n" +
                "                \"DEPCTIYNAME_ZH\": \"上海虹桥\",\n" +
                "                \"FLIGHT\": [\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"CAN\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"guangzhou\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"广州\",\n" +
                "                        \"DEPDATE\": \"2019-01-24\",\n" +
                "                        \"MINPRICE\": \"860\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"REGION\": \"华东\",\n" +
                "                \"REGION_CODE\": \"HD\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"DEPCITY\": \"PVG\",\n" +
                "                \"DEPCTIYNAME_EN\": \"ShanghaiPudong\",\n" +
                "                \"DEPCTIYNAME_ZH\": \"上海浦东\",\n" +
                "                \"FLIGHT\": [\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"CGO\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"zhengzhou\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"郑州\",\n" +
                "                        \"DEPDATE\": \"2019-01-25\",\n" +
                "                        \"MINPRICE\": \"1070\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"SZX\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"shenzhen\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"深圳\",\n" +
                "                        \"DEPDATE\": \"2019-01-24\",\n" +
                "                        \"MINPRICE\": \"1040\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"SHE\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"shenyang\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"沈阳\",\n" +
                "                        \"DEPDATE\": \"2019-02-26\",\n" +
                "                        \"MINPRICE\": \"690\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"CAN\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"guangzhou\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"广州\",\n" +
                "                        \"DEPDATE\": \"2019-02-08\",\n" +
                "                        \"MINPRICE\": \"730\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"WUH\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"wuhan\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"武汉\",\n" +
                "                        \"DEPDATE\": \"2019-01-24\",\n" +
                "                        \"MINPRICE\": \"1560\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"REGION\": \"华东\",\n" +
                "                \"REGION_CODE\": \"HD\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"DEPCITY\": \"CKG\",\n" +
                "                \"DEPCTIYNAME_EN\": \"chongqing\",\n" +
                "                \"DEPCTIYNAME_ZH\": \"重庆\",\n" +
                "                \"FLIGHT\": [\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"CAN\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"guangzhou\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"广州\",\n" +
                "                        \"DEPDATE\": \"2019-01-22\",\n" +
                "                        \"MINPRICE\": \"610\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"WUH\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"wuhan\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"武汉\",\n" +
                "                        \"DEPDATE\": \"2019-02-21\",\n" +
                "                        \"MINPRICE\": \"960\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"PEK\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"beijing\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"北京\",\n" +
                "                        \"DEPDATE\": \"2019-01-23\",\n" +
                "                        \"MINPRICE\": \"800\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"ARRCITY\": \"HAK\",\n" +
                "                        \"ARRCTIYNAME_EN\": \"haikou\",\n" +
                "                        \"ARRCTIYNAME_ZH\": \"海口\",\n" +
                "                        \"DEPDATE\": \"2019-02-24\",\n" +
                "                        \"MINPRICE\": \"670\",\n" +
                "                        \"SEGTYPE\": \"S\",\n" +
                "                        \"money\": \"RMB\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"REGION\": \"西南\",\n" +
                "                \"REGION_CODE\": \"XN\"\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"eunionResponseId\": \"f4eb949bf61642e8ab585223ce3ce247\",\n" +
                "    \"server\": \"\",\n" +
                "    \"success\": true,\n" +
                "    \"version\": \"\"\n" +
                "}";

        JSONObject jsonObject = JSON.parseObject(jsonStr);

        if(jsonObject.getString("success").equals("true")){
            JSONObject data = JSONObject.parseObject(jsonObject.getString("data"));

            ResponseEntity responseEntity = JSON.parseObject(data.toJSONString(),ResponseEntity.class);
            System.out.println(responseEntity.toString());
        }

        // ResponseEntity result = JSON.parseObject(jsonStr,ResponseEntity.class);




    }




}
