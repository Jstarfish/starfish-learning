package priv.starfish.demo;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.util.List;

/**
 * @description:
 * @author: starfish
 * @date: 2021/2/9 14:18
 */
public class Dom4jTest {

    @Test
    public void getXml() throws Exception {
        SAXReader reader = new SAXReader();
        String xmlFile = "/Users/apple/Downloads/电商行业模板 (2).xml";
        //String xmlFile = "/Users/apple/Downloads/student.xml";
        Document doc = reader.read(new FileInputStream(xmlFile));
        //Document doc = reader.read(xmlFile);
        Element e = doc.getRootElement();

        String name;
        String value;
        List<Element> listElement = e.elements();
        for (Element element : listElement) {
            List<Element> url = element.elements();
            for (Element element1 : url) {

                name = element1.getQName().getName();
                value = element1.getData().toString();

                if(name.equals("data")){
                    List<Element> data = element1.elements();
                    for (Element datum : data) {
                        name = datum.getName();
                        value = datum.getData().toString();
                    }
                }
            }
        }
    }

}
