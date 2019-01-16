package priv.starfish.schedule.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import priv.starfish.schedule.service.impl.RedissonDistributedLock;

/**
 * @author: jiahaixin
 * @date: 2019/1/7 16:55
 * @description: 启动后刷新日期宏
 */

//@Component
public class StartRunner implements CommandLineRunner {

    private final static Logger trace = LoggerFactory.getLogger("trace");


    @Autowired
    private RedissonDistributedLock redissonLock;

    @Autowired


    @Override
    public void run(String... strings) throws Exception {
/*
        trace.info("刷新ES-query定时任务启动......");

        String lockKey = "es-query-task-lock";
        boolean getLock = false;
        long start = System.currentTimeMillis();
        try {

            if (getLock = redissonLock.tryLock(lockKey, TimeUnit.SECONDS, 100, 8)) {

                trace.info("host：" + CommonUtils.getHost() + "  got lock " + lockKey + "  at " + CommonUtils.getCurrentDate());

                //查出包含日期宏字段的商品包
                List<ProductPackage> productPackageList = productPackageForTaskService.findProductPackageByDateMacro();

                trace.info("The total of pack that contain the macro field is:" + productPackageList.size());

                for (ProductPackage productPackage : productPackageList) {
                    String elasticsearch_query = EsJsonUtil.builder2String(EsJsonUtil.trans2esJson(productPackage.qid, productPackage.selection_type, productPackage.selection));

                    //判断该商品包是否还存在日期宏
                    ProductPackage pack = productPackageForTaskService.getProductPackageById(productPackage.product_pack_id);
                    if (pack.hasDateMacro == Constants.PRODUCT_PACK_SELECTION_HAS_MACRO) {
                        //{{date}}  不需要更新
                       *//* if(pack.selection.characteristic != null && pack.selection.characteristic.size() > 0){
                            for (Map<String,Object> map:pack.selection.characteristic){
                                String fieldsValue = String.valueOf(map.get("fields_value"));
                                if(fieldsValue.equals("{{date}}")){
                                }
                            }
                            }
                        }*//*
                        //FIXME 多线程去更新
                        productPackageForTaskService.updateESQueryById(productPackage.product_pack_id, elasticsearch_query);
                        trace.info("update es_query success,product_pack_id : " + productPackage.product_pack_id);
                    } else {
                        trace.info("product pack's hasDateMacro had been modified while update es_query : " + productPackage.product_pack_id);
                    }
                }

                Thread.sleep(5000);
            } else {
                trace.info("host：" + CommonUtils.getHost() + "  got lock fail at " + CommonUtils.getCurrentDate());
            }
        } catch (Exception e) {
            trace.error("Redisson get lock error", e);
        } finally {
            if (!getLock) {
                return;
            }
            redissonLock.unlock(lockKey);
            trace.info("host：" + CommonUtils.getHost() + " unlocked " + lockKey + " at " + CommonUtils.getCurrentDate());
            long end = System.currentTimeMillis();
            trace.info("refresh es_query time:" + (end - start));
        }*/
    }

}
