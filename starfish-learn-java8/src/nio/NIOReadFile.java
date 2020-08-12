package nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * @description:
 * @author: starfish
 * @create: 2020-08-12 10:09
 */
public class NIOReadFile {

    /**
     * @param file
     */
    public static void read(String file) {
        FileInputStream fis = null;
        FileChannel channel = null;
        try {
            fis = new FileInputStream(file);
            // 1. 获取通道
            channel = fis.getChannel();
            // 2. 获取文件大小
            int fileLen = (int) channel.size();
            System.out.println("文件大小： " + fileLen);
            // 3. 指定缓冲区（分配正好文件大小）
            ByteBuffer buffer = ByteBuffer.allocate(fileLen);
            // 4. 读取到缓冲区
            channel.read(buffer);
            // 5. 反转缓冲区，准备读取数据
            Buffer bf = buffer.flip();
            // 6. 获取到数组
            byte[] bt = (byte[]) bf.array();
            System.out.println(new String(bt));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 7. 关闭
            try {
                channel.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @param file
     */
    public static void read2(String file) {
        FileInputStream fis = null;
        FileChannel channel = null;
        try {
            fis = new FileInputStream(file);
            // 1. 获取通道
            channel = fis.getChannel();
            // 2. 获取文件大小
            int fileLen = (int) channel.size();
            System.out.println("文件大小： " + fileLen);
            // 3. 指定缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(64);
            while (true) {
                // 5. 清空
                buffer.clear();
                // 6. 读取
                int r = channel.read(buffer);
                if (r == -1) {
                    break;
                }
                buffer.flip();
                byte[] bt = (byte[]) buffer.array();
                System.out.println(new String(bt));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 7. 关闭
            try {
                channel.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @param file
     */
    public static void read3(String file) {
        FileInputStream fis = null;
        FileChannel channel = null;
        try {
            fis = new FileInputStream(file);
            // 1. 获取通道
            channel = fis.getChannel();
            // 2. 获取文件大小
            int fileLen = (int) channel.size();
            System.out.println("文件大小： " + fileLen);
            // 3. 指定缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while (true) {
                buffer.clear();
                int r = channel.read(buffer);
                if (r == -1) {
                    break;
                }
                buffer.flip();
                CharBuffer charBuf = Charset.forName("GBK").decode(buffer);
                System.out.println(charBuf.toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 7. 关闭
            try {
                channel.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        read("H:/dtsData/part-r-00000");
        //read2("D:/what21.txt");
        //read3("D:/what21.txt");
    }

}
