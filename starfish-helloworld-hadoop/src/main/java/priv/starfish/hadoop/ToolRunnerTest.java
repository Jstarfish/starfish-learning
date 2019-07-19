package priv.starfish.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

/**
 * @author: jiahaixin
 * @date: 2019/1/31 11:15
 * @description:
 */
public class ToolRunnerTest  extends Configured implements Tool {


    @Override
    public int run(String[] strings) throws Exception {
        //调用基类Configured的getConf获取环境变量实例
        Configuration conf=getConf();
        //获取属性值
        System.out.println("flower is" + conf.get("flower"));
        return 0;
    }


    public static void main(String[] args) throws Exception {
        //获取当前环境变量
        Configuration conf=new Configuration();
        //使用ToolRunner的run方法对自定义的类型进行处理
        ToolRunner.run(conf, new ToolRunnerTest(), args);

    }
}
