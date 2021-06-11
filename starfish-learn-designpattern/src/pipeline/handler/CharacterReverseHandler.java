package pipeline.handler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: 字符翻转
 * @author: starfish
 * @date: 2021/5/26 15:30
 */
public class CharacterReverseHandler implements Handler<String,String>{

    @Override
    public String process(String input) {
        System.out.println("===反转字符串===");
        return new StringBuilder(input).reverse().toString();
    }
}
