package pipeline.stage;

import org.apache.commons.io.FileUtils;
import pipeline.handler.Handler;

import java.io.File;

/**
 * @description: 文件处理
 * @author: starfish
 * @date: 2021/5/26 14:53
 */
public class FileProcessHandler implements StoppablePipeline.Stage<File, String>{

    @Override
    public String process(File file) {
        System.out.println("===文件处理===");
        try{
            return FileUtils.readFileToString(file,"UTF-8");
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
