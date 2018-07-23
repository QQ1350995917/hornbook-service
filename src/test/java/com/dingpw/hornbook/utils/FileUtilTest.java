package com.dingpw.hornbook.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-07-19 18:55.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FileUtilTest {

    @Test
    public void uploadByInputStream() throws Exception {
//        String file = "/Users/pwd/workspace/dingpw/hornbook-service/a.png";
//        InputStream inputStream = new FileInputStream(new File(file));
//        FileUtil.uploadByInputStream("test","test.png",inputStream,"jpg");
    }

    @Test
    public void getFileUrl() throws Exception {
//        String test = FileUtil.getFileUrl("test", "test.png");
//        System.out.println(test);
    }

}