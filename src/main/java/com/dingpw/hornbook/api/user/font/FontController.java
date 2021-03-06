package com.dingpw.hornbook.api.user.font;

import com.dingpw.hornbook.ApplicationConfigure;
import com.dingpw.hornbook.api.Output;
import com.dingpw.hornbook.api.PagingInput;
import com.dingpw.hornbook.api.PagingOutput;
import com.dingpw.hornbook.api.user.UserController;
import com.dingpw.hornbook.business.ObjectListEntity;
import com.dingpw.hornbook.dao.font.FontEntity;
import com.dingpw.hornbook.business.font.IFontService;
import io.swagger.annotations.Api;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-07-19 09:16.
 */

@Api(value = "/api/user/font", description = "Template")
@RestController
@RequestMapping("/api/user/font")
public class FontController extends UserController {

    @Autowired
    private IFontService fontService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    private void add(HttpServletRequest request) {

    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    private void update(HttpServletRequest request) {

    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    private void delete() {

    }

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public Output<FontOutput> findById(FontFindInput input) {
        Long id = 123L;
        if (input.getFontId() != null) {
            id = input.getFontId();
        }
        FontEntity findById = this.fontService.findById(id);
        FontOutput fontOutput = new FontOutput();
        BeanUtils.copyProperties(findById, fontOutput);
        return Output.output(fontOutput);
    }

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public void queryByName(@RequestParam(value = "userName", required = true) String userName) {
        System.out.println("开始查询...");
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public void list(FontListInput input) {
        try {
            ObjectListEntity<FontEntity> fontEntities = this.fontService
                .list(input.getIndex(), input.getSize());
            List<FontOutput> fontOutputs = new ArrayList<>();
            FontListOutput fontListOutput = new FontListOutput();
            for (FontEntity fontEntity : fontEntities.getElements()) {
                FontOutput fontOutput = new FontOutput();
                BeanUtils.copyProperties(fontEntity, fontOutput);
                try {
                    fontOutput
                        .setThumb(
                            ApplicationConfigure.getFileDomain() + "hornbook-metadata/" + fontOutput
                                .getId() + ".png");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                fontOutputs.add(fontOutput);
            }
            fontListOutput.setFonts(fontOutputs);

            PagingInput pagingInput = input;

            PagingOutput pagingOutput = new PagingOutput(pagingInput);
            pagingOutput.setTotalSize(fontEntities.getTotal());
            pagingOutput.setTotalIndex(fontEntities.getPages());
            pagingOutput.setIndex(pagingInput.getIndex());
            fontListOutput.setPaging(pagingOutput);
            super.outputData(fontListOutput);
        } catch (Exception e) {
            super.outputExceptionToLog(this.getClass(), e, input);
            super.outputException(500);
        }

    }

}
