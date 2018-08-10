package com.dingpw.hornbook.business.studio;

import com.dingpw.hornbook.business.ObjectListEntity;
import com.dingpw.hornbook.dao.studio.PaintingEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-07-30 11:17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PaintingServiceImplTest {
    @Autowired
    private PaintingServiceImpl painterService;

    @Test
    public void paint() throws Exception {
    }

    @Test
    public void save() throws Exception {
        PaintingEntity paintingEntity = new PaintingEntity();
        paintingEntity.setFontId(123L);
        paintingEntity.setContent("你好");
        paintingEntity.setImageUrl("http://www.xxx.com/xxx.png");
        painterService.save(paintingEntity);
    }

    @Test
    public void listByUserId() throws Exception {
        ObjectListEntity<PaintingEntity> paintingListEntity = painterService.listByUserId(0L, 0, 16);
        System.out.println(paintingListEntity.getElements().size());

    }

}