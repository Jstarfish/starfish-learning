package priv.starfish.bloom;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: starfish
 * @date: 2021/3/18 10:52
 */
public class ApacheUtilsTest {

    public static void main(String[] args) {


       // String[] strs = StringUtils.split("50002:小孩惩罚\u000350003:thinkpad\u000350003:lenovo", "\u0003");
        String[] strs = StringUtils.split("50002", "\u0003");
        for (String str : strs) {
            System.out.println(StringUtils.substringBefore(str, ":"));
            System.out.println(StringUtils.substringAfter(str,":"));
           // System.out.println(str);
        }
        System.out.println(NumberUtils.isNumber("38.0"));

        ArrayList<String> arrayList = new ArrayList<String>(){{
            add("a");
            add("b");
        }};

        System.out.println(arrayList.stream().map(str->str.toString()).collect(Collectors.toList()));

        System.out.println(arrayList.toString());
    }


}
