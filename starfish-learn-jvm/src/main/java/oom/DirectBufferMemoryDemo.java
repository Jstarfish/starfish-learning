package oom;

import java.nio.ByteBuffer;

/**
 *  VM Options：-Xms10m,-Xmx10m,-XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
 **/
public class DirectBufferMemoryDemo {

    public static void main(String[] args) {
        System.out.println("maxDirectMemory is:"+sun.misc.VM.maxDirectMemory() / 1024 / 1024 + "MB");

        //ByteBuffer buffer = ByteBuffer.allocate(6*1024*1024);
        ByteBuffer buffer = ByteBuffer.allocateDirect(6*1024*1024);

    }
}
