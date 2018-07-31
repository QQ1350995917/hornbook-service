package com.dingpw.hornbook.api.studio;

import com.dingpw.hornbook.api.ApiController;
import com.dingpw.hornbook.api.Output;
import com.dingpw.hornbook.api.PagingInput;
import com.dingpw.hornbook.api.PagingOutput;
import com.dingpw.hornbook.common.ObjectListEntity;
import com.dingpw.hornbook.studio.PaintingEntity;
import com.dingpw.hornbook.studio.PaintingServiceImpl;
import io.swagger.annotations.Api;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-07-05 13:58.
 */
@Api(value = "/api/studio", description = "Studio")
@RestController
@RequestMapping("/api/studio")
public class StudioController extends ApiController {

    @Autowired
    private PaintingServiceImpl painterService;

    @RequestMapping(value = "/paint", method = RequestMethod.POST)
    public Output<PaintingOutput> paint(@RequestBody PaintingInput input,
        HttpServletRequest request) {
        PaintingEntity paintingEntityInput = new PaintingEntity();
        BeanUtils.copyProperties(input, paintingEntityInput);
        PaintingEntity paintingEntityOutput = this.painterService.paint(paintingEntityInput);
        PaintingOutput paintingOutput = new PaintingOutput();
        BeanUtils.copyProperties(paintingEntityOutput, paintingOutput);
        this.painterService.save(paintingEntityOutput);
        return Output.output(paintingOutput);
    }

    @RequestMapping(value = "/paint", method = RequestMethod.GET)
    public Output<PaintingListOutput> listByUserId(@RequestParam PaintingListInput input) {
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
        return Output.output(output);
    }


}
