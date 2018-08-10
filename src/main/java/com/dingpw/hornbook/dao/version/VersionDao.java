package com.dingpw.hornbook.dao.version;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-08-08 18:47.
 */
@Repository
public interface VersionDao extends JpaRepository<VersionEntity, Long> {

    VersionEntity findByPlatformAndCodeGreaterThanOrderByCodeDesc(String platform,int code);
}
