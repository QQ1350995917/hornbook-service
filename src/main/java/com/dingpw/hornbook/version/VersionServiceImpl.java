package com.dingpw.hornbook.version;

import com.dingpw.hornbook.common.ObjectListEntity;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-08-08 18:58.
 */
@Service
public class VersionServiceImpl implements IVersionService {

    @Autowired
    private VersionDao versionDao;

    @Override
    public VersionEntity save(VersionEntity versionEntity) {
        VersionEntity save = versionDao.save(versionEntity);
        return save;
    }

    @Override
    public VersionEntity update(VersionEntity versionEntity) {
        return null;
    }

    @Override
    public VersionEntity delete(Long id) {
        return null;
    }

    @Override
    public VersionEntity getById(Long id) {
        Optional<VersionEntity> byId = versionDao.findById(id);
        return byId.get();
    }

    @Override
    public ObjectListEntity<VersionEntity> listByPlatform(String platform, int index, int size) {
        Page<VersionEntity> all = versionDao.findAll(PageRequest.of(index, size));
        ObjectListEntity<VersionEntity> listEntity = new ObjectListEntity<>();
        listEntity.setElements(all.getContent());
        listEntity.setIndex(Long.parseLong(index + ""));
        listEntity.setPages(Long.parseLong(all.getTotalPages() + ""));
        listEntity.setSize(Long.parseLong(size + ""));
        listEntity.setTotal(all.getTotalElements());
        return listEntity;
    }

    @Override
    public VersionEntity checkNew(Integer code, String platform) {
        return versionDao.findByPlatformAndCodeGreaterThanOrderByCodeDesc(platform,code);
    }
}
