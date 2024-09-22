package com.haoyan.bookstore.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.haoyan.bookstore.service.ChatService;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import static com.haoyan.bookstore.pojo.Constants.APP_SECRET;
import static com.haoyan.bookstore.pojo.Constants.CHAT_URL;
import static com.haoyan.bookstore.pojo.Constants.CORP_ID;
import static com.haoyan.bookstore.pojo.Constants.WECHAT_TOKEN_URL;


public class ChatServiceImpl implements ChatService {
    @Override
    public String getAccessToken() throws Exception {
        String url = WECHAT_TOKEN_URL;
        Map<String, String> params = new HashMap<>();
        params.put("corpid", CORP_ID);
        params.put("corpsecret", APP_SECRET);
        String response = sendGetRequest(url, params);
        JSONObject jsonObject = JSON.parseObject(response);
        return jsonObject.getString("access_token");
    }

    @Override
    public String createChatLink(String accessToken, String chatName, String[] chatMembers) throws Exception {
        String url = CHAT_URL;
        Map<String, Object> data = new HashMap<>();
        data.put("chat_name", chatName);
        data.put("chat_members", chatMembers);
        String response = sendPostRequest(url, accessToken, data);
        JSONObject jsonObject = JSON.parseObject(response);
        return jsonObject.getString("chat_link");
    }

    // 发送 GET 请求
    private static String sendGetRequest(String url, Map<String, String> params) throws Exception {
        StringBuilder sb = new StringBuilder(url);
        if (!params.isEmpty()) {
            sb.append("?");
            for (Map.Entry<String, String> entry : params.entrySet()) {
                sb.append(entry.getKey()).append("=").append(URLEncoder.encode(entry.getValue(), "UTF-8")).append("&");
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        URL obj = new URL(sb.toString());
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }

    private static String sendPostRequest(String url, String accessToken, Map<String, Object> data) throws Exception {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        con.setRequestProperty("Authorization", "Bearer " + accessToken);
        con.setDoOutput(true);
        con.getOutputStream().write(JSON.toJSONString(data).getBytes("UTF-8"));
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }
}
