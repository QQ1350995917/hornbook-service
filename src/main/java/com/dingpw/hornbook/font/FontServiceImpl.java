package com.dingpw.hornbook.font;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public int count() {
        return Long.valueOf(fontDao.count()).intValue();
    }

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
    public List<FontEntity> list(int index, int size) {
        Page<FontEntity> all = fontDao.findAll(PageRequest.of(index,size));
        return all.getContent();
    }

    @Override
    public List<FontEntity> queryByTitleLike(String title, int index, int size) {
        return null;
    }
}
