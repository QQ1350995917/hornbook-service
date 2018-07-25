package com.dingpw.hornbook.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-07-25 14:18.
 */
public class ShellUtil {

    public static void execute(String file) throws Exception {
        Runtime run = Runtime.getRuntime();
        try {
            Process process = run.exec(new String[]{"/bin/sh", "-c", "sh " + file});
            process.waitFor();
            InputStream in = process.getInputStream();
            BufferedReader bs = new BufferedReader(new InputStreamReader(in));
            List<String> list = new ArrayList<>();
            String result;
            while ((result = bs.readLine()) != null) {
                System.out.println("job result [" + result + "]");
                list.add(result);
            }
            in.close();
            bs.close();
            process.destroy();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
