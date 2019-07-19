package priv.starfish.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

/**
 * @author: jiahaixin
 * @date: 2019/1/31 15:25
 * @description:
 */
public class TestMapReduce extends Configured implements Tool {
    //Main 函数中的ToolRunner.run将调用此函数
    public int run(String[] args) throws Exception {
        if (args.length<2) {
            System.out.printf("Usage:%s <input> <output>\n",
                    this.getClass().getSimpleName());
            return -1;
        }
        Configuration conf=getConf();
        Job job=new Job(conf);
        //以下三种方法均可以job.setJarByClass
        //job.setJarByClass(this.getClass());
        job.setJarByClass(getClass());
        //job.setJarByClass(TestMapReduce.class);
        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        System.out.print("use the TestMapReduce.run\n");
        return job.waitForCompletion(true)?0:1;
    }
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        int exitCode=ToolRunner.run(conf, new TestMapReduce(), args);
        System.out.println("job is finished!");
        System.exit(exitCode);
        //查看输出结果
        //hadoop fs -text part-00000|head
        //文本输出可以用cat
    }
}
