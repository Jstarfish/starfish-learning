package decorator;

import java.io.*;

/**
 * @description: 验证 Stream 中的装饰模式
 * @author: starfish
 * @data: 2020-03-24 15:45
 **/
public class StreamDemo {

    public static void main(String[] args) throws IOException {
        DataInputStream  stream = new DataInputStream(new BufferedInputStream(new FileInputStream("/Users/starfish/Desktop/pid.txt")));
       while (stream.available()!=0){
           System.out.println((char)stream.readByte());
       }
    }
}
