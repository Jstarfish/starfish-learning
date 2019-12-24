package priv.starfish.log;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * JDK自带logging 测试 ,等级依次升高
 * all→finest→finer→fine→config→info→warning→server→off
 */
public class LoggingTest {

    public static Logger logger = Logger.getLogger(LoggingTest.class.toString());

    public static void main(String[] args) {
        logger.setLevel(Level.INFO);

        logger.getLevel();
        logger.finest("finest");
        logger.finer("finer");
        logger.fine("fine");
        logger.config("config");
        logger.info("info");
        logger.warning("warning");
        logger.severe("server");
    }


}
