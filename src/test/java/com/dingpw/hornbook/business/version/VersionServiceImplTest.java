package com.dingpw.hornbook.business.version;

import com.dingpw.hornbook.business.ObjectListEntity;
import com.dingpw.hornbook.dao.version.VersionEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-08-08 19:04.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class VersionServiceImplTest {


    @Autowired
    private VersionServiceImpl versionService;
    private static VersionEntity versionEntity = new VersionEntity();

    static {
        versionEntity.setCode(1);
        versionEntity.setName("字体");
        versionEntity.setVersion("1.0.0");
        versionEntity.setPlatform("Android");
        versionEntity.setSummary("初始化版本");
        versionEntity.setIcon("http://xxx.xxx.com/xxx.png");
        versionEntity.setUrls("[http://xxx.xxx.com/xxx.png,http://xxx.xxx.com/xxx.png]");
        versionEntity.setThumbs("[http://xxx.xxx.com/xxx.png,http://xxx.xxx.com/xxx.png]");
        versionEntity.setStatus(1);
        versionEntity.setCreateTime(System.currentTimeMillis());
        versionEntity.setUpdateTime(System.currentTimeMillis());
    }

    @Test
    public void save() throws Exception {
        versionService.save(versionEntity);
    }

    @Test
    public void update() throws Exception {
    }

    @Test
    public void getById() throws Exception {
    }

    @Test
    public void listByPlatform() throws Exception {
        ObjectListEntity<VersionEntity> android = versionService.listByPlatform("Android", 0, 10);
        System.out.println(android);
    }


    @Test
    public void checkNew() throws Exception {
        VersionEntity android = versionService.checkNew(0, "Android");
        System.out.println(android);
    }

}