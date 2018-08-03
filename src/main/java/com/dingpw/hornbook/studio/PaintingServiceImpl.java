package com.dingpw.hornbook.studio;

import com.dingpw.hornbook.ApplicationConfigure;
import com.dingpw.hornbook.common.ObjectListEntity;
import java.io.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-07-24 15:37.
 */
@Service
public class PaintingServiceImpl implements IPaintingService {

    @Autowired
    private PaintingDao paintingDao;

    @Override
    public PaintingEntity paint(PaintingEntity painterEntity) {
        try {
            int imageWidth = painterEntity.getWidth();
            int imageHeight = painterEntity.getHeight();
            String text = painterEntity.getContent();
            String backColorString = painterEntity.getBackground();
            String foreColorString = painterEntity.getForeground();
            String fontId = painterEntity.getFontId() + "";
            float fontSize = painterEntity.getFontSize();
            String ttfPath = ApplicationConfigure.getFontTtfDir() + fontId + ".ttf";
            File fontTTF = new File(ttfPath);
            String backColor = backColorString;
            String foreColor = foreColorString;

            String[] contents = text.split("\n");
            String imageUrl = Painter
                .paintToCloud(imageWidth, imageHeight, backColor, foreColor, fontTTF, fontSize,
                    contents);
            painterEntity.setImageUrl(imageUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return painterEntity;
    }

    @Override
    public PaintingEntity save(PaintingEntity paintingEntity) {
        PaintingEntity save = paintingDao.save(paintingEntity);
        return save;
    }

    @Override
    public ObjectListEntity<PaintingEntity> listByUserId(Long userId, int index, int size) {
        Page<PaintingEntity> byUserId = paintingDao
            .findByUserId(userId, PageRequest.of(index, size));
        ObjectListEntity<PaintingEntity> paintingList = new ObjectListEntity<>();
        paintingList.setElements(byUserId.getContent());
        paintingList.setIndex((long) index);
        paintingList.setSize((long) size);
        paintingList.setPages((long) byUserId.getTotalPages());
        paintingList.setTotal(byUserId.getTotalElements());
        return paintingList;
    }
}
