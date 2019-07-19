package com.qihoo.dmp.southernAirlines.observable;

import com.qihoo.dmp.southernAirlines.bo.StandardProductStruct;
import com.qihoo.dmp.southernAirlines.utils.Constants;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * @author: jiahaixin
 * @date: 2019/1/16 15:54
 * @description:
 */
public class XmlGenerator {


    private String xmlPath;

    public XmlGenerator(String flag) {
        this.xmlPath = Constants.XMLPATH + flag + "/";
        File xmlDir = new File(xmlPath);
        if (!xmlDir.exists()) {
            xmlDir.mkdir();
        }
    }

    public void buildXml(List<StandardProductStruct> list) {
        Document document = buildDocument(list);
        File file = rndFile();
        writeXml(document, file);
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

    private Document buildDocument(List<StandardProductStruct> list) {
        Document document = DocumentHelper.createDocument();
        Element root = document.addElement("urlset");
        for (StandardProductStruct standardProductStruct : list) {
            Element url = root.addElement("url");
            Element clickUrl = url.addElement("clickUrl");
            clickUrl.addCDATA(standardProductStruct.getClickUrl());
            Element data = url.addElement("data");

            Element pid = data.addElement("pid");
            pid.addCDATA(standardProductStruct.getPid());
            Element pName = data.addElement("pName");
            pName.addCDATA(standardProductStruct.getPName());
            Element imgUrl = data.addElement("imgUrl");
            imgUrl.addCDATA(standardProductStruct.getImgUrl());
            Element price = data.addElement("price");
            price.addCDATA(standardProductStruct.getPrice());
            Element priceUnit = data.addElement("priceUnit");
            priceUnit.addCDATA(standardProductStruct.getPriceUnit());
            Element origin = data.addElement("origin");
            origin.addCDATA(standardProductStruct.getOrigin());
            Element destination = data.addElement("destination");
            destination.addCDATA(standardProductStruct.getDestination());
            Element depDate = data.addElement("depDate");
            depDate.addCDATA(standardProductStruct.getDepDate());
            Element returnDate = data.addElement("returnDate");
            returnDate.addCDATA(standardProductStruct.getReturnDate());

            Element airliftMode = data.addElement("airliftMode");
            airliftMode.addCDATA(standardProductStruct.getAirliftMode());
            Element category = data.addElement("category");
            category.addCDATA(standardProductStruct.getCategory());
            Element subCategory = data.addElement("subCategory");
            subCategory.addCDATA(standardProductStruct.getSubCategory());




            if (StringUtils.isNotBlank(standardProductStruct.getTitle())) {
                Element title = data.addElement("title");
                title.addCDATA(standardProductStruct.getTitle());
            }
            if (StringUtils.isNotBlank(standardProductStruct.getMClickUrl())) {
                Element mClickUrl = data.addElement("mClickUrl");
                mClickUrl.addCDATA(standardProductStruct.getMClickUrl());
            }
            if (StringUtils.isNotBlank(standardProductStruct.getAvailability())) {
                Element availability = data.addElement("availability");
                availability.addCDATA(standardProductStruct.getAvailability());
            }
            if (StringUtils.isNotBlank(standardProductStruct.getInventoryNum())) {
                Element inventoryNum = data.addElement("inventoryNum");
                inventoryNum.addCDATA(standardProductStruct.getInventoryNum());
            }
            if (StringUtils.isNotBlank(standardProductStruct.getLproperty())) {
                Element lproperty = data.addElement("lproperty");
                lproperty.addCDATA(standardProductStruct.getLproperty());
            }
            if (StringUtils.isNotBlank(standardProductStruct.getBName())) {
                Element bName = data.addElement("bName");
                bName.addCDATA(standardProductStruct.getBName());
            }
            if (StringUtils.isNotBlank(standardProductStruct.getSellerSiteUrl())) {
                Element sellerSiteUrl = data.addElement("sellerSiteUrl");
                sellerSiteUrl.addCDATA(standardProductStruct.getSellerSiteUrl());
            }
            if (StringUtils.isNotBlank(standardProductStruct.getLabel())) {
                Element sellerSiteUrl = data.addElement("label");
                sellerSiteUrl.addCDATA(standardProductStruct.getLabel());
            }
            if (StringUtils.isNotBlank(standardProductStruct.getImgUrl1())) {
                Element sellerSiteUrl = data.addElement("imgUrl1");
                sellerSiteUrl.addCDATA(standardProductStruct.getImgUrl1());
            }
            if (StringUtils.isNotBlank(standardProductStruct.getImgUrl2())) {
                Element sellerSiteUrl = data.addElement("imgUrl2");
                sellerSiteUrl.addCDATA(standardProductStruct.getImgUrl2());
            }
            if (StringUtils.isNotBlank(standardProductStruct.getImgUrl3())) {
                Element sellerSiteUrl = data.addElement("imgUrl3");
                sellerSiteUrl.addCDATA(standardProductStruct.getImgUrl3());
            }
        }
        return document;
    }

    private File rndFile() {
        String fileName = RandomStringUtils.randomAlphabetic(10).toLowerCase() + ".xml";

        File parent = new File(xmlPath, Constants.SUB);
        if (!parent.exists()) {
            parent.mkdir();
        }
        File file = new File(parent, fileName);
        if (file.exists()) {
            file.delete();
        } else {
            try {
                file.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return file;
    }
}
