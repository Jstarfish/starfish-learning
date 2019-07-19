package com.qihoo.dmp.southernAirlines.handle;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qihoo.dmp.southernAirlines.utils.RSA;
import com.qihoo.dmp.southernAirlines.bo.StandardProductStruct;
import com.qihoo.dmp.southernAirlines.bo.StandardProductStructStorage;
import com.qihoo.dmp.southernAirlines.dto.Flight;
import com.qihoo.dmp.southernAirlines.dto.FromFlights;
import com.qihoo.dmp.southernAirlines.dto.ResponseEntity;
import com.qihoo.dmp.southernAirlines.observable.ProductListSizeObserver;
import com.qihoo.dmp.southernAirlines.utils.DateUtils;
import com.qihoo.dmp.southernAirlines.utils.HttpClientUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

import static com.qihoo.dmp.southernAirlines.utils.Constants.*;


@EnableScheduling
@Component
public class SoutherAirlinesParser_bak extends Observable {

    private final static Logger logger = LoggerFactory.getLogger(SoutherAirlinesParser_bak.class);

    StandardProductStructStorage standardProductStructStorage;
    public int size = 1000;
    public String flag;


    public SoutherAirlinesParser_bak(String flag, int size) {
        this.flag = flag;
        this.size = size;
        Runtime.getRuntime().addShutdownHook(new ShutdownHook(flag));
        standardProductStructStorage = new StandardProductStructStorage(flag);
    }

    public SoutherAirlinesParser_bak() {
    }

    private static final String dir = "/home/sync360/product-xml/bin/southerAirlines";


    public static void main(String[] args) throws IOException {
        String flag = "China_southern_airlines";
        String data = dir + flag + ".dat";
        SoutherAirlinesParser_bak aliFileParser = new SoutherAirlinesParser_bak(flag, 20000);
        aliFileParser.clearXmlDir();
        aliFileParser.addObserver(new ProductListSizeObserver());

        File file = new File(data);
        if (file.exists()) {
            FileUtils.deleteQuietly(file);
        }
        file.createNewFile();

        List<ResponseEntity> responseEntityList = getRequestResult();

        responseEntityList.forEach((list)->{

            logger.info("response----->" + list.toString());

            HashSet<FromFlights> fromFlights = list.getFROMOFLIGHTS();

            fromFlights.forEach((fromFlight) -> {

                System.out.println(fromFlight.getDEPCITY());
                System.out.println(fromFlight.getDEPCTIYNAME_EN());
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
                    standardProduct.setOrigin(fromFlight.getDEPCTIYNAME_ZH());
                    standardProduct.setDestination(flight.getARRCTIYNAME_ZH());
                    standardProduct.setDepDate(flight.getDEPDATE());
                    standardProduct.setReturnDate(flight.getRETURNDATE());

                    aliFileParser.addStandardProductStruct(standardProduct);
                });

            });

        });


    }


    private static List<ResponseEntity> getRequestResult() {

        String url = "http://58.248.41.144/E-UNION/data/service/minPrice/queryMinPriceInSeventyOfInternational.json";
        String account = "360Search";
        String password = "360Search@2019";
        String result = null;
        List<ResponseEntity> responseEntityList = new ArrayList<>();
        ResponseEntity responseEntity = new ResponseEntity();
        try {
            String completeUrl = String.format("%s?type=%s", url, account);
            //加密后的密码
            String cipher = null;

            cipher = RSA.toHexString(new RSA().encrypt(password, RSA.getPublicKey()));
            System.out.println(cipher);

            completeUrl = String.format("%s&param=%s", completeUrl, cipher);

            System.out.println(completeUrl);

            //请求参数封装
            /*String isInter = "N";
            String channel = "PC";
            String params = "{\"isInter\":\"" + isInter + "\",\"channel\":\"" + channel + "\"}";*/
            String params = null;

            String[] isInterList = new String[]{"N", "Y"};
            String[] channelList = new String[]{"PC", "MOBILE"};

            for (String anIsInterList : isInterList) {
                for (String aChannelList : channelList) {
                    params = "{\"isInter\":\"" + anIsInterList + "\",\"channel\":\"" + aChannelList + "\"}";
                    //发送请求，获取结果
                    result = HttpClientUtils.httpPost(completeUrl, params, null);
                    System.out.println("result:" + result);
                    JSONObject jsonObject = JSON.parseObject(result);

                    if (jsonObject.getString("success").equals("true")) {
                        JSONObject data = JSONObject.parseObject(jsonObject.getString("data"));

                        responseEntity = JSON.parseObject(data.toJSONString(), ResponseEntity.class);
                        System.out.println(responseEntity.toString());

                        responseEntityList.add(responseEntity);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseEntityList;
    }


    protected synchronized void addStandardProductStruct(StandardProductStruct e) {
        standardProductStructStorage.addStandardProductStruct(e);
        if (standardProductStructStorage.size() >= size) {
            System.out.println("standardProductStructStorage.size() >= " + size);
            update();
        }
    }

    protected SAXReader getSafeSAXReader() {
        SAXReader saxReader = new SAXReader();
        XMLReader xmlReader;
        try {
            xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
            saxReader.setXMLReader(xmlReader);
            saxReader.setEncoding("UTF-8");
        } catch (SAXException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return saxReader;
    }

    protected InputSource getInputSource(File file) {
        InputSource inputSource = null;
        HttpURLConnection conn = null;
        try {
            InputStream is = new FileInputStream(file);
            inputSource = new InputSource(is);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            IOUtils.close(conn);
        }
        return inputSource;
    }

    protected InputSource getInputSource(String url) {
        URL ourl;
        InputSource inputSource = null;
        HttpURLConnection conn = null;
        try {
            ourl = new URL(url);
            conn = (HttpURLConnection) (ourl.openConnection());
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("User-Agent", "360dmp");
            conn.setRequestProperty("Charset", "UTF-8");
            InputStream is = conn.getInputStream();
            inputSource = new InputSource(is);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        return inputSource;
    }

    public void update() {
        setChanged();
        notifyObservers(standardProductStructStorage);
    }

    public void clearXmlDir() throws IOException {
        String xmlPath = XMLPATH + flag + "/";
        File xmlPathDir = new File(xmlPath);
        if (!xmlPathDir.exists()) {
            xmlPathDir.mkdir();
        } else {
            System.out.println("clear : " + xmlPathDir);
            FileUtils.cleanDirectory(xmlPathDir);
        }
    }

    private class ShutdownHook extends Thread {
        private String flag;
        private String xmlPath;
        private String ftpPath;

        public ShutdownHook(String flag) {
            this.flag = flag;
            xmlPath = XMLPATH + flag + "/";
            ftpPath = FTPPATH + flag + "/";
        }

        @Override
        public void run() {
            System.out.println("ShutdownHook");
            update();
            sitemap(flag);
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
    }

}
