package com.dingpw.hornbook;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-07-19 18:39.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationConfigureTest {

    @Test
    public void init() throws Exception {
        ApplicationConfigure.init();
    }

}