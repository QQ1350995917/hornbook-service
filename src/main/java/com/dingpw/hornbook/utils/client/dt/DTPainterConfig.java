package com.dingpw.hornbook.utils.client.dt;

import com.dingpw.hornbook.ApplicationConfigure;
import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-07-07 09:36.
 */
public class DTPainterConfig {
    public static final String domain = ApplicationConfigure.getDtDomainForPainter();

    private static final Map<String,String> paths = new HashMap<>();
    public static String getPath(String key){
        return paths.get(key);
    }
    static {
        paths.put("90","shufa");
    }

}
