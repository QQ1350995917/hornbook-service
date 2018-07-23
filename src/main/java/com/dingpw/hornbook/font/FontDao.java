package com.dingpw.hornbook.font;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-07-05 22:02.
 */
@Repository
public interface FontDao extends JpaRepository<FontEntity,Long> {

}
