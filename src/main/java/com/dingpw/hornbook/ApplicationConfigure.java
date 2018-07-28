package com.dingpw.hornbook;

import com.alibaba.fastjson.JSON;
import java.io.File;
import java.io.FileInputStream;
import java.util.Map;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-07-19 18:12.
 */
public class ApplicationConfigure {

    private static final String CONFIGURE_FILE_PATH = "/Users/pwd/applications/hornbook/config";
    private static String DT_DOMAIN_FOR_PAINTER = "";
    private static String DT_URL_FONT_LIST = "";
    private static String DT_URL_FONT_DOWN = "";


    private static String FILE_DOMAIN = "";
    private static String FILE_ACCESS_KEY = "";
    private static String FILE_SECRET_KEY = "";

    private static String FONT_TTF_DIR = "";

    private static String AUTO_DEPLOY_SHELL = "";

    public static void init() throws Exception {
        FileInputStream fileInputStream = new FileInputStream(new File(CONFIGURE_FILE_PATH));
        Map<String, String> kvs = JSON.parseObject(fileInputStream, Map.class, null);
        DT_DOMAIN_FOR_PAINTER = kvs.get("DT_DOMAIN_FOR_PAINTER");
        DT_URL_FONT_LIST = kvs.get("DT_URL_FONT_LIST");
        DT_URL_FONT_DOWN = kvs.get("DT_URL_FONT_DOWN");
        FILE_DOMAIN = kvs.get("FILE_DOMAIN");
        FILE_ACCESS_KEY = kvs.get("FILE_ACCESS_KEY");
        FILE_SECRET_KEY = kvs.get("FILE_SECRET_KEY");
        FONT_TTF_DIR = kvs.get("FONT_TTF_DIR");
        AUTO_DEPLOY_SHELL = kvs.get("AUTO_DEPLOY_SHELL");
        fileInputStream.close();
    }

    public static String getDtDomainForPainter() {
        return DT_DOMAIN_FOR_PAINTER;
    }

    public static String getDtUrlFontList() {
        return DT_URL_FONT_LIST;
    }

    public static String getDtUrlFontDown() {
        return DT_URL_FONT_DOWN;
    }

    public static String getFileDomain() {
        return FILE_DOMAIN;
    }

    public static String getFileAccessKey() {
        return FILE_ACCESS_KEY;
    }

    public static String getFileSecretKey() {
        return FILE_SECRET_KEY;
    }

    public static String getFontTtfDir() {
//        return FONT_TTF_DIR;
        return "/Users/pwd/workspace/dingpw/hornbook-service/xresources/fontsNew/";
    }

    public static String getAutoDeployShell() {
        return AUTO_DEPLOY_SHELL;
    }
}
