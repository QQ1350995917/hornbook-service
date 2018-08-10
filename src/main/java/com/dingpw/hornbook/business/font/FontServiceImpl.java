package com.dingpw.hornbook.business.font;

import com.dingpw.hornbook.business.ObjectListEntity;
import com.dingpw.hornbook.dao.font.FontDao;
import com.dingpw.hornbook.dao.font.FontEntity;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-07-05 22:05.
 */
@Service
public class FontServiceImpl implements IFontService {

    @Autowired
    private FontDao fontDao;

    @Override
    public int countByTitleLike(String title) {
        return 0;
    }

    @Override
    public FontEntity findById(Long id) {
        Optional<FontEntity> findById = fontDao.findById(id);
        return findById.get();
    }

    @Override
    public ObjectListEntity<FontEntity> list(int index, int size) {
        Page<FontEntity> all = fontDao.findAll(PageRequest.of(index, size));
        ObjectListEntity<FontEntity> fontEntities = new ObjectListEntity<>();
        fontEntities.setElements(all.getContent());
        fontEntities.setIndex(Long.parseLong(index + ""));
        fontEntities.setPages(Long.parseLong(all.getTotalPages() + ""));
        fontEntities.setSize(Long.parseLong(size + ""));
        fontEntities.setTotal(all.getTotalElements());
        return fontEntities;
    }

    @Override
    public ObjectListEntity<FontEntity> queryByTitleLike(String title, int index, int size) {
        return null;
    }
}
