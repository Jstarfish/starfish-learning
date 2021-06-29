package pipeline.handler;

import com.sun.deploy.util.StringUtils;
import lombok.val;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @description:
 * @author: starfish
 * @date: 2021/5/25 19:58
 */
public class ClientTest {

    public static void main(String[] args) {

        File file = new File("/Users/apple/Documents/hello.txt");

        val filters = new Pipeline<>(new FileProcessHandler())
                .addStage(new CharacterFilterHandler())
                .addStage(new CharacterReverseHandler());

        System.out.println(filters.execute(file)+"!!!");



        Function<File,String> readFile = input -> {
            System.out.println("===文件处理===");
            try{
                return FileUtils.readFileToString(input,"UTF-8");
            }catch (IOException e){
                e.printStackTrace();
            }
            return null;
        };

        Function<String, String> filterCharacter = input -> {
            System.out.println("===字符过滤===");
            List<String> hello = Stream.of(input).filter(s -> s.contains("hello")).collect(Collectors.toList());
            //return String.join("",hello);
            return null;
        };

        Function<String, String> reverseCharacter = input -> {
            System.out.println("===反转字符串===");
            return new StringBuilder(input).reverse().toString();
        };

        final Function<File,String> pipe = readFile
                .andThen(filterCharacter)
                .andThen(reverseCharacter);

        //System.out.println(pipe.apply(file));
    }
}
