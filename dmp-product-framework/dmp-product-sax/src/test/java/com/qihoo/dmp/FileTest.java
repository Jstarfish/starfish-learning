package com.qihoo.dmp;

import java.io.File;
import java.io.IOException;

/**
 * @author: jiahaixin
 * @date: 2019/1/18 15:11
 * @description:
 */
public class FileTest {


    public static void main(String[] args) throws IOException {

       // File file = new File("E:/data/product/newxml/ee");
        File file = new File("/data/product/newxml/");
        if(!file.exists()){
            file.mkdir();
        }

    }
}
