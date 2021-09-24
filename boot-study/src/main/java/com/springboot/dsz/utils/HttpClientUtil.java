package com.springboot.dsz.utils;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: ShouZhi@Duan
 * @Description: Http调用工具
 */
@Data
@Slf4j
public class HttpClientUtil {

    /**
     * POST 表单请求
     * https://www.jianshu.com/p/e4c0a61ef2d9
     * HttpClientUtil
     *    .postForm(LOGIN_URL,new FormBody.Builder()
     *    .add("username", LOGIN_NAME)
     *    .add("password", LOGIN_PWD)
     *    .build());
     */
    public static String postForm(String url, final FormBody formBody){
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(url).post(formBody).build();
        try {
            Response response = okHttpClient.newCall(request).execute();
            if(response.code() != 200){
                response.close();
                throw new RuntimeException(url + "响应异常");
            }
            String respBody = response.body().string();
            response.close();
            return respBody;
        } catch (Exception e) {
        }
        return null;
    }


    /**
     * Post
     *   Headers
     *   application/json
     */
    public static String postJSONBody(String url, HashMap<String,String> mapHeader, String jsonBody) throws IOException {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(120, TimeUnit.SECONDS)
                .writeTimeout(120,TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();
        RequestBody body = RequestBody.create(MediaType.parse("application/json"), jsonBody);
        Request request = null;
        Headers headers = null;
        if(mapHeader != null){//设置header
            Headers.Builder builder_header = new Headers.Builder();
            for (String key : mapHeader.keySet()) {
                builder_header.add(key, mapHeader.get(key));
            }
             headers = builder_header.build();
             request = new Request.Builder().url(url).headers(headers).post(body).build();
        }else {//不设置header
            request = new Request.Builder().url(url).post(body).build();
        }
        Call call = client.newCall(request);
        Response response = call.execute();
        String msg;
        if(response.code()== HttpsURLConnection.HTTP_OK){
            ResponseBody content = response.body();
            msg = (content == null) ? null : content.string();
            response.close();
        } else {
            response.close();
            throw new RuntimeException(url + "响应异常");
        }
        return msg;
    }

    /**
     * GET请求
     *   Headers
     */
    public static String sendGetByHeaders2(String url, HashMap<String,String> mapHeader) throws IOException {
        OkHttpClient httpClient = new OkHttpClient();
        Request request = new Request
                .Builder().url(url)
                .addHeader("Authorization",mapHeader.get("Authorization"))
                .build();
        Response response = httpClient.newCall(request).execute();
        return response.body().string();
    }


    public static String sendGetByHeaders(String url,HashMap<String,String> mapHeader) throws IOException {
         CloseableHttpClient client = null;
         CloseableHttpResponse response = null;
         try {
             client = HttpClients.createDefault();
             URIBuilder uriBuilder = new URIBuilder(url);
             HttpGet httpGet = new HttpGet(uriBuilder.build());
             httpGet.setHeader(new BasicHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8"));
             httpGet.setHeader(new BasicHeader("Accept", "application/json"));
             httpGet.setHeader(new BasicHeader("Authorization", mapHeader.get("Authorization")));
             response = client.execute(httpGet);
             int statusCode = response.getStatusLine().getStatusCode();
             if (statusCode==200){
                 HttpEntity entity = response.getEntity();
                 String result = EntityUtils.toString(entity,"UTF-8");
                 return result;
             }
         }catch (Exception e){
             log.info("======GET请求异常======");
         }finally {
             response.close();
         }
         return null;
    }
}
