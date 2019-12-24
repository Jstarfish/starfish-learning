package priv.starfish.other;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import java.time.format.DateTimeFormatter;

/**
 * @author: jiahaixin
 * @date: 2019/10/11 16:46
 * @description:
 */
public class DateVerify {




        public static void main(String[] args) {
        String line = "2019/09-31";
//        if (StringUtils.isNotBlank(line)) {
//            String parttenStr = "yyyy-MM-dd||yyyyMMdd||yyyyMMdd HH:mm:ss||yyyy/MM/dd||yyyy/MM/dd HH:mm:ss";
//            String[] parttens = StringUtils.splitByWholeSeparator(parttenStr, "||");
//            DateTime dt = null;
//            for (int i = 0; i < parttens.length; i++) {
//                DateTimeFormatter dtf = DateTimeFormat.forPattern(parttens[i]);
//                try {
//                    dt = dtf.parseDateTime(line);
//                } catch (IllegalArgumentException ire) {
//                    continue;
//                }
//            }
//            if (dt == null) {
//                System.out.println("错误的日期");
//            } else {
//                System.out.println(dt);
//            }
//        }
    }
}
