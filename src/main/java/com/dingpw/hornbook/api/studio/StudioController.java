package com.dingpw.hornbook.api.studio;

import com.dingpw.hornbook.api.ApiController;
import com.dingpw.hornbook.api.Output;
import com.dingpw.hornbook.studio.PainterEntity;
import com.dingpw.hornbook.studio.PainterServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.BeanUtils;
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
@Api(value = "studio", description = "画室接口：描述了绘制等工作")
@RestController
@RequestMapping("/studio")
public class StudioController extends ApiController {

    @Autowired
    private PainterServiceImpl painterService;

    @RequestMapping(value = "/paint", method = RequestMethod.POST)
    public Output<PainterOutput> paint(@ApiParam @RequestBody PainterInput input,
        HttpServletRequest request) {
        PainterEntity painterEntityInput = new PainterEntity();
        BeanUtils.copyProperties(input, painterEntityInput);
        PainterEntity paintEntityOutput = painterService.paint(painterEntityInput);
        PainterOutput painterOutput = new PainterOutput();
        BeanUtils.copyProperties(paintEntityOutput, painterOutput);
        return Output.output(painterOutput);
    }
}