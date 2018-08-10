package com.dingpw.hornbook.utils.client.dt;

import com.alibaba.fastjson.JSON;
import com.dingpw.hornbook.ApplicationConfigure;
import com.dingpw.hornbook.utils.client.Client;
import com.dingpw.hornbook.utils.FileUtil;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.util.UriEncoder;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-07-05 17:11.
 */
@Service
public class DTClient {

    public static List<String> buildDTFontHtmlUrl() {
        List<String> urls = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            String url = ApplicationConfigure.getDtUrlFontList() + i;
            urls.add(url);
        }
        return urls;
    }

    public static List<DTFontOutput> parseDTFontList(String html) {
        List<DTFontOutput> outputs = new LinkedList<>();
        Document parse = Jsoup.parse(html);
        Elements thumbnails = parse.getElementsByClass("thumbnail");
        for (Element thumbnail : thumbnails) {
            String title = thumbnail.attr("title");
            String href = thumbnail.attr("href");
            String id = href.substring(href.lastIndexOf("/") + 1, href.length());
            String thumb = thumbnail.child(0).attr("src");
            DTFontOutput dtFontOutput = new DTFontOutput(id, href, title, null, thumb);
            outputs.add(dtFontOutput);
        }
        return outputs;
    }

    public static void downloadThumb(List<DTFontOutput> outputs, String dir) throws Exception {
        int index = 0;
        int length = outputs.size();
        for (DTFontOutput output : outputs) {
            System.out.println("正在下载缩略图 " + (++index) + "/" + length + " " + output.getTitle());
            Client.downLoadFileByGet(UriEncoder.encode(output.getThumb()), dir + ".png");
            Thread.sleep(1000);
        }
    }

    public static void downloadTTF(List<DTFontOutput> outputs, String dir) {
        int index = 0;
        int length = outputs.size();
        for (DTFontOutput output : outputs) {
            System.out.println("正在下载TTF " + (index++) + "/" + length + output.getTitle());
            Client.downLoadFileByPost(ApplicationConfigure.getDtUrlFontDown() + output.getId(),
                dir + output.getTitle() + ".ttf");
            output.setTtfName(output.getTitle() + ".ttf");
        }
    }

    public static void downloadJson(List<DTFontOutput> outputs, String dir) throws Exception {
        DTClient.writerJson(dir + "All.json", JSON.toJSONString(outputs));
        for (DTFontOutput output : outputs) {
            DTClient.writerJson(dir + output.getTitle() + ".json", JSON.toJSONString(output));
        }
    }

    public DTPainterOutput paint(DTPainterInput input) throws Exception {
        Map<String, String> map = JSON.parseObject(JSON.toJSONString(input), Map.class);
        String result = Client
            .post(DTPainterConfig.domain + DTPainterConfig.getPath(input.getFontInfoId()), null,
                map);
        Document parse = Jsoup.parse(result);
        String imgResult = parse.select("#imgResult").attr("src");
        return new DTPainterOutput(imgResult);
    }

    private static void writerJson(String jsonFile, String content) throws Exception {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(jsonFile));
        bufferedWriter.write(content);
        bufferedWriter.close();
    }

    public static void uploadThumb(String imageUrl, String fileName) throws Exception {
        InputStream fileInputStream = Client.getFileInputStreamByUrl(imageUrl);
        FileUtil.uploadByInputStream("hornbook-metadata", fileName, fileInputStream, null);
        fileInputStream.close();
    }
}
