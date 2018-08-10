package com.dingpw.hornbook.business.studio;

import java.io.File;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-07-24 18:37.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PainterTest {

    private static String outPutPath = "/Users/pwd/workspace/dingpw/hornbook-service/xresources/painter/";
    private static String fontPutPath = "/Users/pwd/workspace/dingpw/hornbook-service/xresources/fontsNew/";

    private static File fontTTF = new File(fontPutPath + "123.ttf");
    private static int width = 144;
    private static int height = 239;
    private static float fontSize = 32.0f;
    private static String backColor = "#FFFFFF";
    private static String foreColor = "#000000";
    private static String content = "你好啊\n你   嗯";

    @Test
    public void paintToLocal() throws Exception {
        String[] contents = content.split("\n");
        String paintToLocal = Painter
            .paintToLocal(width, height, backColor, foreColor, fontTTF, fontSize, contents,
                new File(outPutPath + "test.png"));
        System.out.println(paintToLocal);
    }

    @Test
    public void paintToCloud() throws Exception {
        String paintToCloud = Painter
            .paintToCloud(width, height, backColor, foreColor, fontTTF, fontSize, content);
        System.out.println(paintToCloud);
    }

}