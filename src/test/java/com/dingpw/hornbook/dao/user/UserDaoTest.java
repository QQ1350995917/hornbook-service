package com.dingpw.hornbook.dao.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-08-09 18:19.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void create() throws Exception {
        UserEntity userEntity = new UserEntity();
        userEntity.setStatus(1);
        int aInt = userDao.create(userEntity);
        System.out.println(aInt);
    }

    @Test
    public void seal() throws Exception {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1L);
        int aInt = userDao.seal(userEntity);
        System.out.println(aInt);
    }

    @Test
    public void unseal() throws Exception {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1L);
        int aInt = userDao.unseal(userEntity);
        System.out.println(aInt);
    }

    @Test
    public void delete() throws Exception {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1L);
        int aInt = userDao.delete(userEntity);
        System.out.println(aInt);
    }

}