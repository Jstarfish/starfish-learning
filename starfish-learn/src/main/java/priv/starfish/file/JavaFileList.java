package priv.starfish.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JavaFileList {

    public static void main(String[] args) {
        //指定目录
        File dir = new File("e:/jdID.DOCX");

        //定义一个List集合，用于存储.java文件的File对象
        List<File> list = new ArrayList<File>();

        //调用获取文件路径方法
        fileToList(dir, list);

        //指定写入文件
        File file = new File(dir, "jdId.txt");
        //调用写入文件方法
        writeToFile(list, file);

    }

    //获取指定文件夹内的所有java文件的绝对路径，并存入集合中
    public static void fileToList(File dir, List<File> list) {
        File[] files = dir.listFiles();//列出dir路径下的所以文件和目录，
        //遍历
        for (File file : files) {
            //如果是目录，则继续获取
            if (file.isDirectory()) {
                list.add(file.getAbsoluteFile());//把父目录路径也存入
                fileToList(file, list);
            }
            //将是.java文件的绝对路径存入
            else if (file.getName().endsWith(".java"))
                list.add(file);
        }
    }

    //将集合中元素写入到一个文本文件中
    public static void writeToFile(List<File> list, File file) {

        BufferedWriter bw = null;

        try {   //使用字符流缓冲区对象关联写入的文件
            bw = new BufferedWriter(new FileWriter(file));
            for (File file0 : list) {
                bw.write(file0.getAbsolutePath());//写入
                bw.newLine();//换行
                bw.flush();//刷新
            }
        } catch (IOException e) {
            throw new RuntimeException("写入文件失败");
        } finally {
            try {
                if (bw != null)
                    bw.close();//关流
            } catch (IOException e) {
                throw new RuntimeException("流资源关闭失败");
            }
        }
    }
}
