package com.dingpw.hornbook.studio;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-07-28 23:04.
 */
@Repository
public interface PaintingDao extends JpaRepository<PaintingEntity, Long> {

    Page<PaintingEntity> findByUserId(Long userId, Pageable pageable);

}
