package com.dingpw.hornbook.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-08-01 15:26.
 */
public class GzipUtil {
    public static final int BUFFER = 1024;

    public GzipUtil() {
    }

    public static byte[] compress(byte[] data) throws Exception {
        ByteArrayInputStream bais = new ByteArrayInputStream(data);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        compress(bais, baos);
        byte[] output = baos.toByteArray();
        baos.flush();
        baos.close();
        bais.close();
        return output;
    }

    public static void compress(InputStream is, OutputStream os) throws Exception {
        GZIPOutputStream gos = new GZIPOutputStream(os);
        byte[] data = new byte[1024];

        int count;
        while((count = is.read(data, 0, 1024)) != -1) {
            gos.write(data, 0, count);
        }

        gos.finish();
        gos.flush();
        gos.close();
    }

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < 90; ++i) {
            sb.append("" + i);
        }

        String sourceStr = sb.toString();
        System.out.println("source length:" + sourceStr.getBytes().length + ",source str length:" + sourceStr.length());

        try {
            byte[] out1 = compress(sourceStr.getBytes());
            System.out.println("after compress:" + out1.length);
        } catch (Exception var4) {
            var4.printStackTrace();
        }

        System.out.println("gzip,deflate,sdch".indexOf("gzip"));
    }
}
