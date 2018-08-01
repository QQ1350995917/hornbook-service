package com.dingpw.hornbook;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-08-01 15:52.
 */
public class ApplicationProperties {

    public static Map<String, ResourceBundle> apiBundles = new HashMap();
    public static Map<String, ResourceBundle> logBundles = new HashMap();

    public ApplicationProperties() {
    }

    static {
        apiBundles.put("zh_CN", ResourceBundle.getBundle("configures.lang.apiCode", Locale.CHINA));
        apiBundles.put("en", ResourceBundle.getBundle("configures.lang.apiCode", Locale.ENGLISH));
        logBundles.put("zh_CN", ResourceBundle.getBundle("configures.lang.logCode", Locale.CHINA));
        logBundles.put("en", ResourceBundle.getBundle("configures.lang.logCode", Locale.ENGLISH));
    }
}
