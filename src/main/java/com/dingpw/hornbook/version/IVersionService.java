package com.dingpw.hornbook.version;

import com.dingpw.hornbook.common.ObjectListEntity;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-08-08 18:48.
 */
@Service
public interface IVersionService {

    VersionEntity save(VersionEntity versionEntity);

    VersionEntity update(VersionEntity versionEntity);

    VersionEntity delete(Long id);

    VersionEntity getById(Long id);

    ObjectListEntity<VersionEntity> listByPlatform(String platform, int index, int size);

    VersionEntity checkNew(Integer code, String platform);
}
