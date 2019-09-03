package priv.starfish;

import com.google.common.collect.Maps;
import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.Map;

/**
 * @author: jiahaixin
 * @date: 2019/2/12 10:51
 * @description:
 */
public class BlackCheckMapper extends Mapper<LongWritable, Text, Text, NullWritable> {


    /*@Override
    protected void setup(Context context) throws IOException, InterruptedException {
        Configuration conf = context.getConfiguration();
        //Rule rule = mapper.readValue(str, Rule.class);
        String ruleFile = conf.get("dmp.product.pkg.rule");
        FileSystem hdfs = FileSystem.get(URI.create(ruleFile), conf);
        Path ruleFilePath = new Path(ruleFile);
        InputStream is = hdfs.open(ruleFilePath);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        for (String line = reader.readLine(); StringUtils.isNotBlank(line); line = reader
                .readLine()) {
        }
    }*/

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();

        ProductInfo info = parseProductInfo(line);

        //TODO 写入map
        if (info != null && info.uid.equals("160185657")) {

            System.out.println(info.toString());

            context.write(new Text(info.getUid()), NullWritable.get());
        }
    }


    public static final char SPLITER = '\001';
    public static final char COLLECTION_SPLITER = '\002';
    public static final char KV_SPLITER = '\003';
    public static final String DEFAULT_PRICE = "0";

    /**
     * 解析获取到的数据
     *
     * @param line
     * @return
     */
    public static ProductInfo parseProductInfo(String line) {
        ProductInfo productInfo = new ProductInfo();

        String[] outArray = StringUtils.splitPreserveAllTokens(line, SPLITER);
        long hashId;
        try {
            hashId = Long.parseLong(outArray[0]);
        } catch (NumberFormatException e) {
            return null;
        }

        long qihuUid = Long.parseLong(outArray[1]);
        productInfo.setUid(String.valueOf(qihuUid));
        productInfo.setHashId(String.valueOf(hashId));
        Map<String, String> map = Maps.newHashMap();

       /* map.put(SHOULD_AUDIT, String.valueOf(shouldAudit(outArray[3])));
        item.setData(map);
        String source = outArray[5];
        if (!StringUtils.isBlank(source)) {
            map.put(SOURCE, source);
        }
        int status = Integer.parseInt(outArray[6]);
        // status（商品状态：0-新增，1-更新，2-删除，3-黑名单）
        if (status > 1) {
            return null;
        }

        int timestamp = Integer.parseInt(outArray[7]);
        productInfo.setTimestamp(timestamp);
        String[] extensionArray = StringUtils.split(outArray[8], COLLECTION_SPLITER);
        for (String kv : extensionArray) {
            String[] kvArray = StringUtils.split(kv, KV_SPLITER);
            if (kvArray.length < 2) {
                continue;
            }
            if (FIELD_NAME_MAP.containsKey(kvArray[0]) && !StringUtils.isBlank(kvArray[1])) {
                map.put(FIELD_NAME_MAP.get(kvArray[0]), kvArray[1]);
            }
        }
        if (!map.containsKey(PRODUCT_PRICE)) {
            map.put(PRODUCT_PRICE, DEFAULT_PRICE);
        }*/
        return productInfo;
    }
}
