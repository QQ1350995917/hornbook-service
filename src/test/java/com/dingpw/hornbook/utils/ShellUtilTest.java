package com.dingpw.hornbook.utils;

import com.dingpw.hornbook.ApplicationConfigure;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-07-25 14:26.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ShellUtilTest {

    @Test
    public void execute() throws Exception {
        ShellUtil.execute(ApplicationConfigure.getAutoDeployShell());
    }

}