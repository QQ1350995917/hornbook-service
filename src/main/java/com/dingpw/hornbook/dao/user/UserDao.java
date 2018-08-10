package com.dingpw.hornbook.dao.user;

import org.apache.ibatis.annotations.Mapper;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-08-09 18:15.
 */
@Mapper
public interface UserDao {

    int create(UserEntity userEntity);

    int seal(UserEntity userEntity);

    int unseal(UserEntity userEntity);

    int delete(UserEntity userEntity);

}
