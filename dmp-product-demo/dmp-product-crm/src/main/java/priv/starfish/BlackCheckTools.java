package priv.starfish;


import com.google.common.base.Preconditions;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

/**
 * @author: jiahaixin
 * @date: 2019/2/11 15:51
 * @description:
 */
public class BlackCheckTools extends Configured implements Tool {

    private static CommandLine cmdLine;
    private static Configuration conf;

    @Override
    public int run(String[] strings) throws Exception {

        cmdLine = parseArguments(strings);
        String inputPath = (String) Preconditions.checkNotNull(
                cmdLine.getOptionValue("input"), "input");
        String outPutPath = (String) Preconditions.checkNotNull(
                cmdLine.getOptionValue("output"), "output");
       /* String lableRuleFileHdfs = (String) Preconditions.checkNotNull(
                cmdLine.getOptionValue("pkgtargetremote"), "pkgtargetremote");*/

        conf = getConf();

        // Configuration processed by ToolRunner

        // Create a JobConf using the processed conf
        Job job = new Job(conf, "jiahaixin-app");

        job.setJarByClass(BlackCheckTools.class);

        job.setOutputKeyClass(Text.class);
        //job.setNumReduceTasks(200);
        job.setOutputValueClass(NullWritable.class);

        job.setMapperClass(BlackCheckMapper.class);


        // Process custom command-line options
        TextInputFormat.addInputPath(job, new Path(inputPath));
       // FileInputFormat.setInputPaths(job, new Path(inputPath));
        FileOutputFormat.setOutputPath(job, new Path(outPutPath));


        boolean success = job.waitForCompletion(true);
        return success ? 0 : -1;

    }


    public static void main(String[] args) throws Exception {
        int res = ToolRunner.run(new BlackCheckTools(),args);
        System.exit(res);
    }


    /**
     * 输入参数解析
     * @param args
     * @return
     * @throws ParseException
     */
    private static CommandLine parseArguments(String[] args)
            throws ParseException {
        Options opts = new Options();
        opts.addOption("input", true, "Input ProductPkgMRTools files");
        opts.addOption("pkgtargetremote", true,
                "Input ImeiAppCrowdTools category files");
        opts.addOption("output", true,
                "File to ProductPkgMRTools into");
        return new PosixParser().parse(opts, args);
    }


    public static final char SPLITER = '\001';
    public static final char COLLECTION_SPLITER = '\002';
    public static final char KV_SPLITER = '\003';
    public static final String DEFAULT_PRICE = "0";


}
