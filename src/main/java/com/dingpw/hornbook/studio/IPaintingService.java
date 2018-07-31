package com.dingpw.hornbook.studio;

import com.dingpw.hornbook.common.ObjectListEntity;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-07-24 15:43.
 */
@Service
public interface IPaintingService {

    PaintingEntity paint(PaintingEntity paintingEntity);

    PaintingEntity save(PaintingEntity paintingEntity);

    ObjectListEntity<PaintingEntity> listByUserId(Long userId,int index,int size);
}
