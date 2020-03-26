package decorator;

import java.io.*;

/**
 * @description:
 * @author: starfish
 * @data: 2020-03-24 16:04
 **/
public class InputTest {

    public static void main(String[] args) throws IOException {
        int c;
        InputStream in = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream("/Users/starfish/Desktop/pid.txt")));

        while ((c = in.read()) >= 0){
            System.out.print((char) c);
        }
        in.close();
    }
}
