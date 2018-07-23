package com.dingpw.hornbook.api.font;

import com.dingpw.hornbook.api.Output;
import com.dingpw.hornbook.api.PagingInput;
import com.dingpw.hornbook.api.PagingOutput;
import com.dingpw.hornbook.font.FontEntity;
import com.dingpw.hornbook.font.IFontService;
import com.dingpw.hornbook.utils.FileUtil;
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

@Api(value = "/api/font", description = "字体主体服务")
@RestController
@RequestMapping("/api/font")
public class FontController {

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
    public void findById(@RequestParam(value = "userName", required = true) String userName) {
        System.out.println("开始查询...");

    }

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public void queryByName(@RequestParam(value = "userName", required = true) String userName) {
        System.out.println("开始查询...");
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Output<FontListOutput> list(FontListInput input) {
        List<FontEntity> fontEntities = this.fontService
            .list(input.getPaging().getIndex(), input.getPaging().getSize());
        int count = this.fontService.count();

        List<FontVO> fontVOS = new ArrayList<>();
        FontListOutput fontListOutput = new FontListOutput();
        for (FontEntity fontEntity : fontEntities) {
            FontVO fontVO = new FontVO();
            BeanUtils.copyProperties(fontEntity, fontVO);
            try {
                fontVO.setThumb("http://118.89.248.92:9000/hornbook-metadata/" + fontVO.getId() + ".png");
//                fontVO.setThumb(FileUtil.getFileUrlInMeta(fontVO.getId() + ".png"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            fontVOS.add(fontVO);
        }
        fontListOutput.setFonts(fontVOS);

        PagingInput pagingInput = input.getPaging();

        boolean flag = (count % pagingInput.getSize() == 0);
        int totalIndex;
        if (flag) {
            totalIndex = count / pagingInput.getSize();
        } else {
            totalIndex = count / pagingInput.getSize() + 1;
        }
        PagingOutput pagingOutput = new PagingOutput(pagingInput);
        pagingOutput.setTotalSize(count);
        pagingOutput.setTotalIndex(totalIndex);
        pagingOutput.setIndex(pagingInput.getIndex());
        fontListOutput.setPaging(pagingOutput);
        return Output.output(fontListOutput);

    }

}
