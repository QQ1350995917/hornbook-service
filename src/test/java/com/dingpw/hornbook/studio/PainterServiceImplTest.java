package com.dingpw.hornbook.studio;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-07-24 18:37.
 */
@RunWith(SpringRunner.class)
@SpringBootTest

public class PainterServiceImplTest {
    private static String outPutPath = "/Users/pwd/workspace/dingpw/hornbook-service/xresources/painter/";
    private static String fontPutPath = "/Users/pwd/workspace/dingpw/hornbook-service/xresources/fonts/";

    @Autowired
    private PainterServiceImpl painterService;

    @Test
    public void paint() throws Exception {
        PainterEntity painterEntity = new PainterEntity();
        painterEntity.setFontId("123");
        painterEntity.setWidth(1440);
        painterEntity.setHeight(2393);
        painterEntity.setContent("你好");
        PainterEntity paint = painterService.paint(painterEntity,outPutPath + "test.png");
        System.out.println(paint.getImageUrl());
    }

}