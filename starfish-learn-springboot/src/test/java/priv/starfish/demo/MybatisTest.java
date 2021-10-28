package priv.starfish.demo;

import com.alibaba.fastjson.JSON;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import priv.starfish.mybatis.dto.FeedSchemaContentDto;
import priv.starfish.mybatis.dto.FeedSchemaDto;
import priv.starfish.mybatis.mapper.FeedSchemaMapper;
import priv.starfish.mybatis.model.IndustryFieldDO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: starfish
 * @date: 2021/2/9 14:17
 */
public class MybatisTest extends ApplicationTests {
    @Autowired
    private FeedSchemaMapper mapper;

    @Test
    public void generateField(){
        Map<Integer,String> map = new HashMap<>();
//        map.put(0,"/Users/apple/Downloads/电商行业模板.xml");
//        map.put(2070000,"/Users/apple/Downloads/汽车行业模板.xml");
//        map.put(1,"/Users/apple/Downloads/资讯行业模板.xml");
//        map.put(2050000,"/Users/apple/Downloads/房产行业模板.xml");

        //手动上传
        map.put(3040000,"教育行业");
        map.put(3060000,"招商行业");
        map.put(3170000,"医美行业");

        map.forEach((k,v) -> {
            try {
                System.out.println(k);
                test(k,v);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (DocumentException e) {
                e.printStackTrace();
            }
        });
    }

    //@Test
    public void test(Integer datastandard,String filePath) throws IOException, DocumentException {
        //Integer datastandard = 0;
        FeedSchemaDto feedSchemaDto = mapper.getContentById(datastandard);
        System.out.println(feedSchemaDto.toString());

        //mapper.getName().stream().forEach(System.out::println);
        List<String> names = mapper.getName();
        List<FeedSchemaContentDto> contents = JSON.parseArray(feedSchemaDto.getContent(),FeedSchemaContentDto.class);
        //contents.stream().forEach(System.out::println);

        for (int i = 0; i < contents.size(); i++) {
            FeedSchemaContentDto dto = contents.get(i);
            System.out.println("==="+dto.getName());
            IndustryFieldDO fieldDO = new IndustryFieldDO();
            fieldDO.setIndustryId(datastandard);
            fieldDO.setFieldKey(dto.getHeader());
            fieldDO.setFieldKeyCn(dto.getName());
            fieldDO.setRequired(dto.getRequired().equals(true)?1:0);
            fieldDO.setSeq(i+1);
            if(dto.getValidaterule() != null){
                fieldDO.setValidateRule(JSON.toJSONString(dto.getValidaterule()));
            }
            if(names.contains(dto.getHeader())){
                fieldDO.setPick(1);
            }else {
                fieldDO.setPick(0);
            }

            switch (dto.getDatatype()){
                case "Bit":
                    fieldDO.setFieldType(5);
                    break;
                case "Url":
                    fieldDO.setFieldType(4);
                    fieldDO.setFieldLen(1024);
                    break;
                case "Number":
                    fieldDO.setFieldType(2);
                    break;
                case "Date":
                    fieldDO.setFieldType(3);
                    break;
                default:
                    fieldDO.setFieldType(1);
                    fieldDO.setFieldLen(50);
            }

//            String demo = parseXml(dto.getHeader(),filePath);
//            fieldDO.setDemo(demo);

            mapper.insertIndustryField(fieldDO);

        }


    }

    public String parseXml(String source,String xmlFile) throws FileNotFoundException, DocumentException {
        SAXReader reader = new SAXReader();
        Document doc = reader.read(new FileInputStream(xmlFile));
        Element e = doc.getRootElement();

        List<Element> listElement = e.elements();
        for (Element element : listElement) {
            List<Element> url = element.elements();
            for (Element element1 : url) {
                String name = element1.getQName().getName();
                if(name.equals(source)){
                    return element1.getData().toString();
                }

                if(name.equals("data")){
                    List<Element> data = element1.elements();
                    for (Element datum : data) {
                        name = datum.getName();
                        if(name.equals(source)){
                            return datum.getData().toString();
                        }
                    }
                }
            }
        }
        return null;
    }
}
