package com.haoyan.bookstore.service;

public interface ChatService {
    public String getAccessToken() throws Exception;
    public String createChatLink(String accessToken, String chatName, String[] chatMembers) throws Exception;

}
