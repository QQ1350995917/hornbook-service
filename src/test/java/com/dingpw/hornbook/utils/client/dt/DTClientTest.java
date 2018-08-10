package com.dingpw.hornbook.utils.client.dt;

import com.dingpw.hornbook.PathConfigure;
import com.dingpw.hornbook.utils.client.Client;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-07-08 09:25.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DTClientTest {

    private static boolean switcher = false;

    @Test
    public void main() throws Exception {
        if (switcher) {
            List<String> urls = DTClient.buildDTFontHtmlUrl();
            List<DTFontOutput> outputs = new LinkedList<>();
            for (String url : urls) {
                try {
                    System.out.println("正在解析 " + url);
                    String html = Client.get(url, null);
                    outputs.addAll(DTClient.parseDTFontList(html));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            DTClient.downloadJson(outputs,PathConfigure.jsonDirRoot);
            DTClient.downloadTTF(outputs,PathConfigure.ttfDirRoot);
            DTClient.downloadThumb(outputs,PathConfigure.thumbDirRoot);
        }
    }

    @Test
    public void parseTTFList() throws Exception {
        if (switcher) {
            BufferedReader reader = new BufferedReader(
                new FileReader(PathConfigure.dirRoot + "page.html"));
            String line;
            StringBuffer buffer = new StringBuffer();
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }

            List<DTFontOutput> dtFontOutputs = DTClient
                .parseDTFontList(buffer.toString());

            System.out.println(dtFontOutputs.size());
        }
    }

}