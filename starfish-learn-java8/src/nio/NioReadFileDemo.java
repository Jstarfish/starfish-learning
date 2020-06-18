package nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * @description:
 * @author: starfish
 * @create: 2020-05-21 10:32
 **/
public class NioReadFileDemo {


    public static void main(String[] args) throws FileNotFoundException {


//        FileInputStream fileIn = new FileInputStream("H:\\data\\taobao\\00000000.txt");
//        FileChannel fileChannel = fileIn.getChannel();
//        ByteBuffer buffer = ByteBuffer.allocate(1024);//初始化缓冲区大小

        //File file = new File("H:\\data\\taobao\\000624_0");//读取的文件
        File file = new File("H:\\data\\test\\1.txt");
        RandomAccessFile accessFile = new RandomAccessFile(file,"rw");
        try{
            // 文件编码是utf8,需要用utf8解码
            Charset charset = Charset.forName("utf-8");
            CharsetDecoder decoder = charset.newDecoder();

            String enterStr = "\n";

            FileChannel fileChannel = accessFile.getChannel();
            ByteBuffer buf = ByteBuffer.allocate(1024);
            CharBuffer cBuf = CharBuffer.allocate(1024);

            int bytesRead = fileChannel.read(buf);
            System.out.println(bytesRead);

            byte[] bs = new byte[1024];
            while(bytesRead != -1)
            {

                int rSize = buf.position();
                buf.rewind();
                buf.get(bs);

                buf.flip();
                decoder.decode(buf, cBuf, true); // 以utf8编码转换ByteBuffer到CharBuffer
                cBuf.flip();
                while(cBuf.hasRemaining())
                {
                    System.out.print(cBuf.get());
                }

                buf.clear();
                cBuf.clear();
                bytesRead = fileChannel.read(buf);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            try{
                accessFile.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }



    }

}
