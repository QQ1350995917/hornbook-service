package com.dingpw.hornbook.client;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-07-05 17:21.
 */
public class Client {

    public static String get(String url, Map<String, String> headers) throws Exception {
        HttpGet httpGet = new HttpGet(url);
        return request(httpGet);
    }


    public static String post(String url, Map<String, String> headers, Map<String, String> body)
        throws Exception {
        List<NameValuePair> list = new ArrayList<>();
        Iterator iterator = body.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Object> elem = (Map.Entry<String, Object>) iterator.next();
            list.add(new BasicNameValuePair(elem.getKey(), elem.getValue().toString()));
        }

        HttpPost httpPost = new HttpPost(url);
        if (list.size() > 0) {
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, "utf-8");
            httpPost.setEntity(entity);
        }

        return request(httpPost);

    }

    private static String request(HttpRequestBase request)
        throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = httpClient.execute(request);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            HttpEntity entity = response.getEntity();
            //接收响应头
            String content = EntityUtils.toString(entity, "utf-8");
            httpClient.close();
            return content;
        } else {
            return null;
        }
    }


    public static void downLoadFileByGet(String url, String file) {
        downLoadFile(new HttpGet(url), url, file);
    }

    public static void downLoadFileByPost(String url, String file) {
        HttpPost httpPost = new HttpPost(url);
        downLoadFile(httpPost, url, file);
    }

    public static InputStream getFileInputStreamByUrl(String url) throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = httpClient.execute(new HttpGet(url));
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode == HttpStatus.SC_OK) {
            return response.getEntity().getContent();
        } else {
            return null;
        }
    }

    private static void downLoadFile(HttpRequestBase requestBase, String url, String file) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            CloseableHttpResponse response = httpClient.execute(requestBase);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_OK) {
                inputStream = response.getEntity().getContent();
                outputStream = new FileOutputStream(file);
                byte[] buffer = new byte[1024 * 1024 * 2];
                int length;
                while ((length = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, length);
                }
                outputStream.flush();
                outputStream.close();
                inputStream.close();
            } else {
                System.out.println("下载 " + url + " 失败");
            }
        } catch (IOException e) {
            System.out.println("下载 " + url + " 失败");
            e.printStackTrace();
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
