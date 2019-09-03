package com.qihoo.dmp.southernAirlines.handle;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qihoo.dmp.southernAirlines.utils.RSA;
import com.qihoo.dmp.southernAirlines.bo.StandardProductStruct;
import com.qihoo.dmp.southernAirlines.bo.StandardProductStructStorage;
import com.qihoo.dmp.southernAirlines.dto.Flight;
import com.qihoo.dmp.southernAirlines.dto.FromFlights;
import com.qihoo.dmp.southernAirlines.dto.ResponseEntity;
import com.qihoo.dmp.southernAirlines.observable.XmlGenerator;
import com.qihoo.dmp.southernAirlines.utils.DateUtils;
import com.qihoo.dmp.southernAirlines.utils.HttpClientUtils;
import org.apache.commons.io.FileUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

import static com.qihoo.dmp.southernAirlines.utils.Constants.*;

/**
 * @author: jiahaixin
 * @date: 2019/1/16 14:15
 * @description: 南航70天低价航线查询解析
 */
@EnableScheduling
@Component
public class SoutherAirlinesParser {

    private final static Logger logger = LoggerFactory.getLogger(SoutherAirlinesParser.class);

    private int size = 1000;
    private String flag = "China_southern_airlines";

    private static final String dir = "/home/sync360/product-xml/bin/southerAirlines";

    private String xmlPath = XMLPATH + flag + "/";
    private String ftpPath = FTPPATH + flag + "/";

    @Value("${airlines.url}")
    private String url;

    @Value("${airlines.account}")
    private String account;

    @Value("${airlines.password}")
    private String password;

    public SoutherAirlinesParser(String flag, int size) {
        System.out.println("====================2");
        this.flag = flag;
        this.size = size;
    }

    public SoutherAirlinesParser() {
        System.out.println("==============1");
    }

    @Scheduled(cron = "0 0/5 * * * ? ")
    //@Scheduled(cron = "0 0 * * * ?")
    public void handler() throws IOException {

        StandardProductStructStorage standardProductStructStorage = new StandardProductStructStorage(flag);
        String data = dir + flag + ".dat";
        SoutherAirlinesParser southerAirlinesParser = new SoutherAirlinesParser(flag, 20000);

        southerAirlinesParser.clearXmlDir();

        File file = new File(data);
        if (file.exists()) {
            FileUtils.deleteQuietly(file);
        }
        file.createNewFile();

        List<ResponseEntity> responseEntityList = getRequestResult();

        responseEntityList.forEach((responseEntity) -> {
            HashSet<FromFlights> fromFlights = responseEntity.getFROMOFLIGHTS();
            fromFlights.forEach((fromFlight) -> {

                HashSet<Flight> flights = fromFlight.getFLIGHT();
                flights.forEach((flight) -> {

                    StandardProductStruct standardProduct = new StandardProductStruct();
                    //设置数据
                    standardProduct.setPid(fromFlight.getDEPCITY() + flight.getARRCITY());   //始发地目的地航线三字代码 构建6字ID
                    standardProduct.setPName(fromFlight.getDEPCTIYNAME_ZH() + "到" + flight.getARRCTIYNAME_ZH() + ("S".equals(flight.getSEGTYPE()) ? "单程机票" : "往返机票"));
                    standardProduct.setPrice(flight.getMINPRICE());
                    standardProduct.setPriceUnit(flight.getMoney());
                    standardProduct.setClickUrl("https://www.csair.com/");
                    standardProduct.setImgUrl("https://www.csair.com/cn/cmsad/resource/a8d09d65a2bdb23d62f212f430ef4bfc.jpg");

                    standardProduct.setCategory(fromFlight.getDEPCTIYNAME_ZH());
                    standardProduct.setSubCategory(flight.getARRCTIYNAME_ZH());
                    standardProduct.setOrigin(fromFlight.getDEPCITY());
                    standardProduct.setDestination(flight.getARRCITY());
                    standardProduct.setDepDate(flight.getDEPDATE());
                    standardProduct.setReturnDate(flight.getRETURNDATE());
                    standardProduct.setAirliftMode(flight.getSEGTYPE());

                    standardProductStructStorage.addStandardProductStruct(standardProduct);
                });
            });
        });

        XmlGenerator xmlGenerator = new XmlGenerator(flag);
        xmlGenerator.buildXml(standardProductStructStorage.standardProductStructs);
        standardProductStructStorage.clear();
        //最后写入index.xml
        sitemap(flag);
    }


    private  List<ResponseEntity> getRequestResult() {
        String result = null;
        List<ResponseEntity> responseEntityList = new ArrayList<>();
        ResponseEntity responseEntity = new ResponseEntity();
        try {
            String completeUrl = String.format("%s?type=%s", url, account);
            //加密后的密码
            String cipher = null;

            cipher = RSA.toHexString(new RSA().encrypt(password, RSA.getPublicKey()));
            logger.info("url:"+cipher);

            completeUrl = String.format("%s&param=%s", completeUrl, cipher);
            logger.info("completeUrl:"+completeUrl);

            //请求参数封装
            String params = null;
            String[] isInterList = new String[]{"N", "Y"};
            String[] channelList = new String[]{"PC", "MOBILE"};

            for (String anIsInterList : isInterList) {
                for (String aChannelList : channelList) {
                    params = "{\"isInter\":\"" + anIsInterList + "\",\"channel\":\"" + aChannelList + "\"}";
                    //发送请求，获取结果
                    result = HttpClientUtils.httpPost(completeUrl, params, null);
                    logger.info("result:"+result);
                    JSONObject jsonObject = JSON.parseObject(result);
                    if (jsonObject.getString("success").equals("true")) {
                        JSONObject data = JSONObject.parseObject(jsonObject.getString("data"));
                        responseEntity = JSON.parseObject(data.toJSONString(), ResponseEntity.class);
                        responseEntityList.add(responseEntity);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseEntityList;

    }

    private void clearXmlDir() throws IOException {
        String xmlPath = XMLPATH + flag + "/";
        File xmlPathDir = new File(xmlPath);
        if (!xmlPathDir.exists()) {
            xmlPathDir.mkdir();
        } else {
            System.out.println("clear : " + xmlPathDir);
            FileUtils.cleanDirectory(xmlPathDir);
        }
    }

    private void sitemap(String flag) {
        XMLWriter writer = null;
        try {
            File xmlPathDir = new File(xmlPath);
            if (!xmlPathDir.exists()) {
                xmlPathDir.mkdir();
            }
            File dir = new File(xmlPathDir, SUB);
            File[] fileList = dir.listFiles();
            Arrays.sort(fileList, new Comparator<File>() {
                public int compare(File f1, File f2) {
                    long diff = f1.lastModified() - f2.lastModified();
                    if (diff > 0)
                        return 1;
                    else if (diff == 0)
                        return 0;
                    else
                        return -1;
                }

                public boolean equals(Object obj) {
                    return true;
                }

            });
            Document document = DocumentHelper.createDocument();
            Element root = document.addElement("sitemapindex");
            for (File file : fileList) {
                Element sitemap = root.addElement("sitemap");
                Element loc = sitemap.addElement("loc");
                loc.addCDATA(HOST + "/" + flag + "/" + SUB + "/" + file.getName());
                Element lastmod = sitemap.addElement("lastmod");
                lastmod.addCDATA(DateUtils.convertDateToString(new Date(file.lastModified()), DateUtils.DateFormat4));
            }
            File file = new File(xmlPathDir, "index.xml");
            writeXml(document, file);

            File ftpPathDir = new File(ftpPath);
            if (ftpPathDir.exists()) {
                FileUtils.cleanDirectory(ftpPathDir);
            }
            FileUtils.copyDirectory(xmlPathDir, ftpPathDir);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null)
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }


    private void writeXml(Document document, File file) {
        XMLWriter writer = null;
        try {
            OutputFormat format = OutputFormat.createPrettyPrint();
            format.setEncoding("UTF-8");
            FileOutputStream fos = new FileOutputStream(file);
            writer = new XMLWriter(fos, format);
            writer.write(document);
            writer.close();
        } catch (IOException e) {
            System.out.println(file.getName());
            e.printStackTrace();
        } finally {
            if (writer != null)
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }


}
