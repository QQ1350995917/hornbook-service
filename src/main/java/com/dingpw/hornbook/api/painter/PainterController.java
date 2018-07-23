package com.dingpw.hornbook.api.painter;

import com.dingpw.hornbook.api.ApiController;
import com.dingpw.hornbook.api.Output;
import com.dingpw.hornbook.client.dt.DTClient;
import com.dingpw.hornbook.client.dt.DTPainterInput;
import com.dingpw.hornbook.client.dt.DTPainterOutput;
import io.swagger.annotations.Api;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-07-05 13:58.
 */
@Api(value = "painter",description = "画家")
@Controller
@RequestMapping("/painter")
public class PainterController extends ApiController{

    @Autowired
    private DTClient dtClient;

    @RequestMapping(value = "/paint", method = RequestMethod.POST)
    public Output<PainterOutput> paint(@RequestBody PainterInput input, HttpServletRequest request) {
        DTPainterInput dtPainterInput = new DTPainterInput();
        dtPainterInput.setFontInfoId(input.getTtfId() + "");
        dtPainterInput.setContent(input.getText());
        DTPainterOutput paint = null;
        try {
            paint = dtClient.paint(dtPainterInput);
        } catch (Exception e) {
            e.printStackTrace();
        }

        PainterOutput painterOutput = new PainterOutput();
        painterOutput.setSrc(paint.getSrc());
        return Output.output(painterOutput);
    }
}
