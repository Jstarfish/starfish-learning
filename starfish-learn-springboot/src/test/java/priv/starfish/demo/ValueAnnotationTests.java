package priv.starfish.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;

import java.net.URL;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class ValueAnnotationTests {

    /**
     * 获取位于application.properties中配置的属性，也可以注入基本数据类型
     */
    @Value("${value.from.file}")
    private String valueFromFile;

    /**
     * 注入数组（自动根据","分割）
     */
    @Value("${listOfValues}")
    private String[] valuesArray;

    /**
     * 注入列表形式（自动根据","分割）
     */
    @Value("${listOfValues}")
    private List<String> valuesList;


    /**
     * 注入普通字符串，相当于直接给属性默认值
     */
    @Value("normal")
    private String normal;

    /**
     *  注入操作系统属性
     */
    @Value("#{systemProperties['os.name']}")
    private String systemPropertiesName;

    /**
     * 注入表达式结果
     */
    @Value("#{ T(java.lang.Math).random() * 100.0 }")
    private double randomNumber;

    /**
     * 注入其他Bean属性：注入movieRecommender对象的属性catalog，对象属性要有get set方法
     */
    @Value("#{movieRecommender.catalog}")
    private String fromAnotherBean;


    /**
     * 注入列表形式（自动根据"|"分割）
     */
    @Value("#{'${words}'.split('\\|')}")
    private List<String> numList;


    @Value("classpath:test.txt")
    private Resource resourceFile; // 注入文件资源

    /**
     * 注入URL资源，不可以通过配置文件注入，会：
     * Failed to convert value of type 'java.lang.String' to required type 'java.net.URL';
     */
    @Value("http://www.google.com")
    private URL testUrl; // 注入URL资源

    /**
     * 如果属性中未配置ip，则使用默认值
     */
    @Value("${ip:127.0.0.1}")
    private String ip;

    /**
     * 如果系统属性中未获取到port的值，则使用9090
     * 其中${}中直接使用“:”对未定义或为空的值进行默认值设置，
     * 而#{}则需要使用“?:”对未设置的属性进行默认值设置
     */
    @Value("#{systemProperties['port']?:'9090'}")
    private String port;

    @Test
    void contextLoads() {
        System.out.println(normal);
        System.out.println(valueFromFile);
        System.out.println(Arrays.asList(valuesArray));
        System.out.println(valuesList);
        System.out.println(numList);

        System.out.println(systemPropertiesName);
        System.out.println(randomNumber);
        System.out.println(fromAnotherBean);
        System.out.println(resourceFile.getDescription());
        System.out.println(testUrl);
        System.out.println(ip);
        System.out.println(port);
    }

}
