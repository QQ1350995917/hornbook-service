package com.dingpw.hornbook.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-08-01 15:29.
 */
public class DateUtil {
    private static final String solt = "0";

    public DateUtil() {
    }

    public static String date2Str(Date date) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return format.format(date);
    }

    public static Long genRandom() {
        StringBuffer time = new StringBuffer();
        time.append(System.currentTimeMillis());
        int random = (int)(Math.random() * 1000.0D);
        if(random < 100) {
            time.append("0");
        }

        if(random < 10) {
            time.append("0");
        }

        return Long.valueOf(Long.parseLong(time.append(random).toString()));
    }
}
