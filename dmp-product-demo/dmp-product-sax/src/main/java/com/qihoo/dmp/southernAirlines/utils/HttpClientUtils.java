package com.qihoo.dmp.southernAirlines.utils;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;

/**
 * @author: jiahaixin
 * @date: 2019/1/16 14:51
 * @description:
 */
public class HttpClientUtils {


    private final static Logger logger = LoggerFactory.getLogger(HttpClientUtils.class);

    private static final String CONTENT_TYPE_JSON_URL = "application/json;charset=utf-8";
    private static final String CHARSET_UTF_8 = "utf-8";


    /**
     * @description: HttpClient Post请求封装方法
     * @param: [url, param, requestHead]
     * @return: java.lang.String
     * @auther: jiahaixin
     * @date: 2018/7/12 11:23
     */
    public static String httpPost(String url, String param, Map<String, String> requestHead) {
        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String resultString = "";
        try {
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);
            // 创建请求内容
            StringEntity entity = new StringEntity(param, ContentType.APPLICATION_JSON);
            entity.setContentType(CONTENT_TYPE_JSON_URL);
            httpPost.setEntity(entity);

            if (null != requestHead) {
                for (Map.Entry<String, String> entry : requestHead.entrySet()) {
                    /*String key = entry.getKey();
                    String value = entry.getValue();
                    httpPost.addHeader(key, value);*/
                    httpPost.setHeader(entry.getKey(),entry.getValue());
                }
            }
            // 执行http请求
            response = httpClient.execute(httpPost);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                logger.error("StatusCode[" + response.getStatusLine().getStatusCode() + "] response status code is error!");
                // EntityUtils.toString(response.getEntity(), CHARSET_UTF_8);
            }
            resultString = EntityUtils.toString(response.getEntity(), CHARSET_UTF_8);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return resultString;
    }



    /**
     * @description: http put请求，参数为字符串，一般是json
     * @param: [url, param, requestHead]
     * @return: java.lang.String
     * @auther: jiahaixin
     * @date: 2018/7/17 15:48
     */
    public static String httpPut(String url, String param, Map<String, String> requestHead) {
        // 创建Httpclient对象 HttpClients.createDefault()等价于 HttpClientBuilder.create().build();
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        CloseableHttpResponse response = null;
        String resultString = "";
        try {
            // 创建Http Put请求
            HttpPut httpPut = new HttpPut(url);

            // 创建请求内容
            StringEntity entity = new StringEntity(param, ContentType.APPLICATION_JSON);
            entity.setContentType(CONTENT_TYPE_JSON_URL);
            httpPut.setEntity(entity);

            //设置header
            if (null != requestHead) {
                for (Map.Entry<String, String> entry : requestHead.entrySet()) {
                    httpPut.setHeader(entry.getKey(),entry.getValue());
                }
            }
            // 执行http请求
            response = httpClient.execute(httpPut);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                logger.error("StatusCode[" + response.getStatusLine().getStatusCode() + "] response status code is error!");
                // EntityUtils.toString(response.getEntity(), CHARSET_UTF_8);
            }
            resultString = EntityUtils.toString(response.getEntity(), CHARSET_UTF_8);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return resultString;
    }
}
