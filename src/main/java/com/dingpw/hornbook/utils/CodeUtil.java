package com.dingpw.hornbook.utils;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-08-01 09:43.
 */
public class CodeUtil {

    public static Map<String, ResourceBundle> bundles = new HashMap();

    public CodeUtil() {
    }

    static {
        bundles.put("zh_CN", ResourceBundle.getBundle("configures.lang.serviceCode", Locale.CHINA));
        bundles.put("en", ResourceBundle.getBundle("configures.lang.serviceCode", Locale.ENGLISH));
    }
}
