package com.haoyan.bookstore.controller;

import cn.hutool.core.util.StrUtil;
import com.haoyan.bookstore.utils.XfXhWebSocketListener;
import com.haoyan.bookstore.pojo.config.XfXhConfig;
import com.haoyan.bookstore.pojo.dto.MsgDTO;
import com.haoyan.bookstore.utils.XfXhStreamClient;
import jakarta.annotation.Resource;
import okhttp3.WebSocket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;


import java.nio.charset.Charset;
import java.util.Collections;
import java.util.UUID;

@RestController
@RequestMapping("/ai")
public class AiController {
    static Charset CHARSET = Charset.forName("utf-8");
    private final Logger logger = LoggerFactory.getLogger(AiController.class);
    @Resource
    private XfXhStreamClient xfXhStreamClient;
    @Resource
    private XfXhConfig xfXhConfig;
    @PostMapping("/question")
    public String sendQuestion(@RequestParam("question") String question) {
        // 如果是无效字符串，则不对大模型进行请求
        if (StrUtil.isBlank(question)) {
            return "无效问题，请重新输入";
        }
        // 获取连接令牌
        if (!xfXhStreamClient.operateToken(XfXhStreamClient.GET_TOKEN_STATUS)) {
            return "当前大模型连接数过多，请稍后再试";
        }

        // 创建消息对象
        MsgDTO msgDTO = MsgDTO.createUserMsg(question);
        // 创建监听器
        XfXhWebSocketListener listener = new XfXhWebSocketListener();
        // 发送问题给大模型，生成 websocket 连接
        WebSocket webSocket = xfXhStreamClient.sendMsg(UUID.randomUUID().toString().substring(0, 10), Collections.singletonList(msgDTO), listener);
        if (webSocket == null) {
            // 归还令牌
            xfXhStreamClient.operateToken(XfXhStreamClient.BACK_TOKEN_STATUS);
            return "系统内部错误，请联系管理员";
        }
        try {
            int count = 0;
            // 为了避免死循环，设置循环次数来定义超时时长
            int maxCount = xfXhConfig.getMaxResponseTime() * 5;
            while (count <= maxCount) {
                Thread.sleep(200);
                if (listener.isWsCloseFlag()) {
                    break;
                }
                count++;
            }
            if (count > maxCount) {
                return "大模型响应超时，请联系管理员";
            }
            // 响应大模型的答案
            return listener.getAnswer().toString();
        } catch (InterruptedException e) {
            logger.error("错误：" + e.getMessage());
            return "系统内部错误，请联系管理员";
        } finally {
            // 关闭 websocket 连接
            webSocket.close(1000, "");
            // 归还令牌
            xfXhStreamClient.operateToken(XfXhStreamClient.BACK_TOKEN_STATUS);
        }
    }
}
