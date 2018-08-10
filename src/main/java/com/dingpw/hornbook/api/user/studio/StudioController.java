package com.dingpw.hornbook.api.user.studio;

import com.dingpw.hornbook.api.PagingInput;
import com.dingpw.hornbook.api.PagingOutput;
import com.dingpw.hornbook.api.user.UserController;
import com.dingpw.hornbook.business.ObjectListEntity;
import com.dingpw.hornbook.dao.studio.PaintingEntity;
import com.dingpw.hornbook.business.studio.PaintingServiceImpl;
import io.swagger.annotations.Api;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-07-05 13:58.
 */
@Api(value = "/api/user/studio", description = "Studio")
@RestController
@RequestMapping("/api/user/studio")
public class StudioController extends UserController {

    @Autowired
    private PaintingServiceImpl painterService;

    @RequestMapping(value = "/paint", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public void paint(@RequestBody PaintingInput input) {
        try {
            PaintingEntity paintingEntityInput = new PaintingEntity();
            BeanUtils.copyProperties(input, paintingEntityInput);
            PaintingEntity paintingEntityOutput = this.painterService.paint(paintingEntityInput);
            PaintingOutput paintingOutput = new PaintingOutput();
            BeanUtils.copyProperties(paintingEntityOutput, paintingOutput);
            this.painterService.save(paintingEntityOutput);
            super.outputData(paintingOutput);
        } catch (BeansException e) {
            super.outputExceptionToLog(this.getClass(), e, input);
            super.outputException(500);
        }
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public void listByUserId(PaintingListInput input) {
        try {
            ObjectListEntity<PaintingEntity> paintingListEntity = painterService
                .listByUserId(input.getUserId(), input.getPaging().getIndex(),
                    input.getPaging().getSize());
            PagingInput paging = input.getPaging();
            PagingOutput pagingOutput = new PagingOutput(paging);
            pagingOutput.setTotalIndex(paintingListEntity.getPages());
            pagingOutput.setTotalSize(paintingListEntity.getTotal());
            List<PaintingEntity> elements = paintingListEntity.getElements();
            List<PaintingOutput> outputElements = new ArrayList<>();
            for (PaintingEntity element : elements) {
                PaintingOutput paintingOutput = new PaintingOutput();
                BeanUtils.copyProperties(element, paintingOutput);
                outputElements.add(paintingOutput);
            }
            PaintingListOutput output = new PaintingListOutput();
            output.setPaintings(outputElements);
            output.setPaging(pagingOutput);
            super.outputData(output);
        } catch (Exception e) {
            super.outputExceptionToLog(this.getClass(), e, input);
            super.outputException(500);
        }
    }
}
