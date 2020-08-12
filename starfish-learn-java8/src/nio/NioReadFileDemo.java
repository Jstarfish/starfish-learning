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
        File file = new File("H:\\dtsData\\part-r-00000");
        RandomAccessFile accessFile = new RandomAccessFile(file, "rw");
        try {
            String enterStr = "\n";
            FileChannel fileChannel = accessFile.getChannel();
            ByteBuffer buf = ByteBuffer.allocate(1024);
            CharBuffer cBuf = CharBuffer.allocate(1024);

            int bytesRead = fileChannel.read(buf);
            System.out.println(bytesRead);

            byte[] bs = new byte[1024];
            while (bytesRead != -1) {

                int rSize = buf.position();
                buf.rewind();
                buf.get(bs);

                buf.flip();
                cBuf.flip();
                while (cBuf.hasRemaining()) {
                    System.out.print(cBuf.get());
                }

                buf.clear();
                cBuf.clear();
                bytesRead = fileChannel.read(buf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                accessFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}
