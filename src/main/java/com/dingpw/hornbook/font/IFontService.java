package com.dingpw.hornbook.font;

import com.dingpw.hornbook.common.ObjectListEntity;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-07-19 10:14.
 */
@Service
public interface IFontService {

    int countByTitleLike(String title);

    FontEntity findById(Long id);

    ObjectListEntity<FontEntity> list(int index, int size);

    ObjectListEntity<FontEntity> queryByTitleLike(String title, int index, int size);
}
