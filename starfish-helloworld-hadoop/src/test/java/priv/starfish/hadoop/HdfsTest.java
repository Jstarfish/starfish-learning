package priv.starfish.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.util.Progressable;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

/**
 * @author: jiahaixin
 * @date: 2019/1/31 17:30
 * @description:
 */
public class HdfsTest {

    public static final String HDFS_PATH = "hdfs://39.105.124.247:9000";//hdfsURI路径
    FileSystem fileSystem = null;//hdfs文件系统API
    Configuration configuration = null;//配置

    @Before
    public void setUp() throws Exception{
        configuration = new Configuration();
        configuration.set("fs.defaultFS", HDFS_PATH);
        fileSystem = FileSystem.get(new URI(HDFS_PATH),configuration,"root");
        System.out.println("HDFSApp:setUp");
    }

    /**
     * 打印
     * */
    @Test
    public void cat() throws IOException {

        FSDataInputStream inputStream = fileSystem.open(new Path("/hdfs_api/test/a"));
        IOUtils.copyBytes(inputStream,System.out,1024);
        inputStream.close();

    }

    /**
     * 创建文件夹
     * */
    @Test
    public void mkdir() throws IOException {
        fileSystem.mkdirs(new Path("/hdfs_api/test"));
    }

    /**
     * 创建文件
     * */
    @Test
    public void create() throws IOException {
        FSDataOutputStream fsDataOutputStream = fileSystem.create(new Path("/hdfs_api/test/a"));
        fsDataOutputStream.write("aaaaa".getBytes());
        fsDataOutputStream.flush();
        fsDataOutputStream.close();
    }

    /**
     * 重命名
     * */
    @Test
    public void rename() throws IOException {
        Path oldPath = new Path("/hdfs_api/test/a");
        Path newPath = new Path("/hdfs_api/test/test1");
        fileSystem.rename(oldPath,newPath);
    }

    /**
     * 上传本地文件到hdfs
     * */
    @Test
    public void copyFromLocal() throws IOException {
        Path src = new Path("D:\\sampledb.sql");
        Path dest = new Path("/hdfs_api/test/");
        fileSystem.copyFromLocalFile(src,dest);
    }

    /**
     * 上传本地文件到hdfs,进度条
     * */
    @Test
    public void copyFromLocalWithProcess() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("D:\\Download\\ideaIU-2017.3.5.tar.gz");
        InputStream in = new BufferedInputStream(fileInputStream);

        FSDataOutputStream outputStream = fileSystem.create(
                new Path("/hdfs_api/test/idea.tar.gz"), new Progressable() {
                    public void progress() {
                        System.out.print(".");
                    }
                });
        IOUtils.copyBytes(in,outputStream,4096);

    }

    @Test
    public void copyToLocalFile() throws IOException {
        Path src = new Path("/hdfs_api/test/test1");
        Path dest = new Path("D:\\test1");
        fileSystem.copyToLocalFile(false,src,dest,true);
    }

    @Test
    public void listFile() throws IOException {
        FileStatus[] fileStatuses = fileSystem.listStatus(new Path("/hdfs_api/test/test1"));
        for(FileStatus fileStatus : fileStatuses){
            String directory = fileStatus.isDirectory() ? "DIR" : "FILE";
            short replication = fileStatus.getReplication();
            long len = fileStatus.getLen();
            String path = fileStatus.getPath().toString();
            System.out.println(directory + "\t" + replication + "\t" + len + "\t" + path);
        }

    }

    @After
    public void tearDown() throws Exception {
        configuration = null;
        fileSystem = null;
        System.out.println("HDFSApp:tearDown");
    }
}
