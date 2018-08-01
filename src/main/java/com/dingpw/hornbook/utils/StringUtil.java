package com.dingpw.hornbook.utils;

import java.util.Date;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-08-01 15:28.
 */
public class StringUtil {
    public StringUtil() {
    }

    public static String null2Str(String source) {
        return source == null?"":source.trim();
    }

    public static int toInt(String str, int defaultValue) {
        if(str == null) {
            return defaultValue;
        } else {
            try {
                return Integer.parseInt(str);
            } catch (Exception var3) {
                return defaultValue;
            }
        }
    }

    public static Long toLong(String str, Long defaultValue) {
        if(str != null && !"".equals(str)) {
            try {
                return Long.valueOf(Long.parseLong(str));
            } catch (Exception var3) {
                return defaultValue;
            }
        } else {
            return defaultValue;
        }
    }

    public static String object2Str(Class<?> type, Object value) {
        if(type != null && value != null) {
            String str = null;
            if(type.isPrimitive()) {
                str = String.valueOf(value);
            } else if(type == Date.class) {
                str = DateUtil.date2Str((Date)value);
            } else if(type == String.class) {
                str = (String)value;
            } else {
                str = value.toString();
            }

            return str;
        } else {
            return "";
        }
    }
}
