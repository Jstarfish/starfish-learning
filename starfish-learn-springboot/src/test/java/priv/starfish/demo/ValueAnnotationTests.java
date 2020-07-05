package priv.starfish.demo;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import priv.starfish.annotation.PriorityProvider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootTest
class ValueAnnotationTests {

    /**
     * 注入普通字符串，相当于直接给属性默认值
     */
    @Value("normal")
    private String normal;

    /**
     * 默认获取位于application.properties中配置的属性，也可以注入基本数据类型
     * 如果系统属性中有该值，也会获取到
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
     * 注入文件资源
     */
    @Value("classpath:application.properties")
    private Resource resourceFile;

    /**
     * 注入URL资源，不可以通过配置文件注入，会：
     * Failed to convert value of type 'java.lang.String' to required type 'java.net.URL';
     */
    @Value("http://www.google.com")
    private URL testUrl; // 注入URL资源

    //------------------  SpEL  -------------------
    /**
     * 注入列表形式,可以根据分隔符截取
     */
    @Value("#{'${listOfValues}'.split(',')}")
    private List<String> values;

    /**
     * 注入操作系统属性，如果有自定义的系统属性，也可以通过该方式注入
     * 等同于 @Value("${os.name}")
     */
    @Value("#{systemProperties['os.name']}")
    private String systemPropertiesName;

    /**
     * 我们还可以使用@Value注释注入所有当前系统属性
     **/
    @Value("#{systemProperties}")
    private Map<String, String> systemPropertiesMap;

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

    //------------------  Map  -------------------

    /**
     * 注入Map, 需要注意的是map中的value 必须用单引号引起来
     */
    @Value("#{${valuesMap}}")
    private Map<String, Integer> valuesMap;

    /**
     * 获取 map 中的某个key值
     */
    @Value("#{${valuesMap}.key1}")
    private Integer valuesMapKey1;

    /**
     * 如果我们不确定Map是否包含某个键，则应选择一个更安全的表达式，该表达式不会引发异常，但在找不到该键时将其值设置为null：
     */
    @Value("#{${valuesMap}['key4']}")
    private Integer unknownMapKey;

    /**
     * 我们还可以为可能不存在的属性或键设置默认值：
     */
    @Value("#{${unknownMap : {key1: '1', key2: '2'}}}")
    private Map<String, Integer> unknownMap;

    @Value("#{${valuesMap}['unknownKey'] ?: 5}")
    private Integer unknownMapKeyWithDefaultValue;

    /**
     * map 也可以在注入前过滤。假设我们只需要获取值大于一的键值对
     **/
    @Value("#{${valuesMap}.?[value>'1']}")
    private Map<String, Integer> valuesMapFiltered;


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

    @Value("#{systemProperties['unknown'] ?: 'some default'}")
    private String spelSomeDefault;

    @Test
    void contextLoads() throws IOException {

        PriorityProvider provider = new PriorityProvider("null");
        System.out.println(provider.getPriority());

        System.out.println(normal);
        System.out.println(valueFromFile);
        System.out.println(Arrays.asList(valuesArray));
        System.out.println(valuesList);
        //System.out.println(numList);

        System.out.println(systemPropertiesName);
        System.out.println(randomNumber);
        System.out.println(fromAnotherBean);

        System.out.println(new BufferedReader(new InputStreamReader(resourceFile.getInputStream()))
                .lines().collect(Collectors.joining(System.lineSeparator())));
        System.out.println(testUrl);
        System.out.println(ip);
        System.out.println(port);
        System.out.println(valuesMap.toString());
        System.out.println(valuesMapKey1);
        System.out.println(unknownMapKey);
        System.out.println(unknownMap);
        System.out.println(unknownMapKeyWithDefaultValue);
        System.out.println(valuesMapFiltered);
        System.out.println(systemPropertiesMap);
    }

}
