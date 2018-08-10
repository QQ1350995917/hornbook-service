package com.dingpw.hornbook.business.font;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dingpw.hornbook.PathConfigure;
import com.dingpw.hornbook.dao.font.FontDao;
import com.dingpw.hornbook.dao.font.FontEntity;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-07-06 13:44.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FontDaoTest {
    @Autowired
    private FontDao fontDao;

    @Test
    public void saveAll() throws Exception {
        LinkedList<FontEntity> fontEntities = new LinkedList<>();
        File[] files = new File(PathConfigure.jsonDirRoot)
            .listFiles();
        for (File file : files) {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String json = bufferedReader.readLine();
            bufferedReader.close();

            JSONObject jsonObject = JSON.parseObject(json);
            String id = jsonObject.getString("id").toString();
            String title = jsonObject.getString("title").toString();
            String ttfName = jsonObject.getString("ttfName");

            FontEntity fontEntity = new FontEntity(Long.parseLong(id),Long.parseLong(id), Long.parseLong(id), title,
                ttfName, null,System.currentTimeMillis(),System.currentTimeMillis());
            fontEntities.add(fontEntity);
        }
         fontDao.saveAll(fontEntities);
    }

    @Test
    public void findAll() throws Exception {
        List<FontEntity> all = fontDao.findAll();
        System.out.println(all.size());
    }

    @Test
    public void deleteAll() throws Exception {
        fontDao.deleteAll();
    }

    @Test
    public void getOne() throws Exception {
        FontEntity one = fontDao.getOne(123L);
        System.out.println(one.getTitle());
    }





}