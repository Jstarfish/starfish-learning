package priv.starfish.log;

import com.mysql.cj.core.util.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

public class LoggingDemo {

    private static final Logger logger = LoggerFactory.getLogger(LoggingDemo.class);

    public static void main(String[] args) {

        logger.info("记录日志");

        String k = null;

        try{
            Assert.notNull(k, "任务参数键不存在");
        }catch (Exception e){
            //throw e;
        }
    }


}
