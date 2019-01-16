package priv.starfish.schedule.TimerTask;/*
package com.qihoo.product.schedule.TimerTask;

import com.qihoo.dmp.product.lib.bo.ProductPackage;
import com.qihoo.dmp.product.lib.util.Constants;
import com.qihoo.dmp.product.lib.util.EsJsonUtil;
import com.qihoo.product.schedule.service.ProductPackageForTaskService;
import com.qihoo.product.schedule.service.impl.RedissonDistributedLock;
import com.qihoo.product.schedule.utils.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.*;


*/
/*
 * @author: jiahaixin
 * @date: 2018/12/28 17:32
 * *//*



@EnableScheduling
@Component
public class RefreshMacroTaskBak {

    private final static Logger trace = LoggerFactory.getLogger("trace");
    private final static Logger logger = LoggerFactory.getLogger("product");

    @Autowired
    private RedissonDistributedLock redissonLock;

    @Autowired
    private ProductPackageForTaskService productPackageForTaskService;


    */
/**
     * @description: 整点前5分钟刷新ES-query中的时间戳
     * @param: []
     * @return: void
     * @date: 2018/12/20 17:43
     *//*


    //@Scheduled(cron = "* 55 0/1 * * ? ")
    @Scheduled(cron = "0 0/1 * * * ? ")
    //@Scheduled( fixedRate = 1000 * 60)
    public void macroFieldRefreshTask() {

        ExecutorService executorService = Executors.newFixedThreadPool(20);

        //查出包含日期宏字段的商品包
        List<ProductPackage> productPackageList = productPackageForTaskService.findProductPackageByDateMacro();
        trace.info("The total of pack that contain the macro field is:" + productPackageList.size());

        try {

            //for (int i = 0; i < productPackageList.size(); i++) {
            Callable<List<ProductPackage>> callable = new MyTask(productPackageList);
            Future<List<ProductPackage>> task = executorService.submit(callable);
            List<ProductPackage> list = task.get();
            trace.info("成功刷新商品包：" + list.size());

            // }

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }


    }


    private class MyTask implements Callable<List<ProductPackage>> {


        private List<ProductPackage> packages;

        private MyTask(List<ProductPackage> packages) {
            this.packages = packages;
        }

        @Override
        public List<ProductPackage> call() throws Exception {

            trace.info("刷新ES-query定时任务启动......");

            String lockKey = "es-query-task-lock";
            boolean getLock = false;
            long start = System.currentTimeMillis();
            try {

                if (getLock = redissonLock.tryLock(lockKey, TimeUnit.SECONDS, 100, 8)) {
                    trace.info("host：" + CommonUtils.getHost() + "  got lock " + lockKey + "  at " + CommonUtils.getCurrentDate());
                    for (ProductPackage productPackage : packages) {
                        String elasticsearch_query = EsJsonUtil.builder2String(EsJsonUtil.trans2esJson(productPackage.qid, productPackage.selection_type, productPackage.selection));

                        //判断该商品包是否还存在日期宏
                        ProductPackage pack = productPackageForTaskService.getProductPackageById(productPackage.product_pack_id);
                        if (pack.hasDateMacro == Constants.PRODUCT_PACK_SELECTION_HAS_MACRO) {
                            //{{date}}  不需要更新
                       */
/* if(pack.selection.characteristic != null && pack.selection.characteristic.size() > 0){
                            for (Map<String,Object> map:pack.selection.characteristic){
                                String fieldsValue = String.valueOf(map.get("fields_value"));
                                if(fieldsValue.equals("{{date}}")){
                                }
                            }
                            }
                        }*//*

                            productPackageForTaskService.updateESQueryById(productPackage.product_pack_id, elasticsearch_query);
                            trace.info("update es_query success,product_pack_id : " + productPackage.product_pack_id);
                        } else {
                            trace.info("product pack's hasDateMacro had been modified while update es_query : " + productPackage.product_pack_id);
                        }
                    }

                    // Thread.sleep(5000);
                } else {
                    trace.info("host：" + CommonUtils.getHost() + "  got lock fail at " + CommonUtils.getCurrentDate());
                }
            } catch (Exception e) {
                trace.error("Redisson get lock error", e);
            } finally {
                if (!getLock) {
                    return null;
                }
                redissonLock.unlock(lockKey);
                trace.info("host：" + CommonUtils.getHost() + " unlocked " + lockKey + " at " + CommonUtils.getCurrentDate());
                long end = System.currentTimeMillis();
                trace.info("refresh es_query time:" + (end - start));
            }
            return packages;
        }
    }


}
*/
