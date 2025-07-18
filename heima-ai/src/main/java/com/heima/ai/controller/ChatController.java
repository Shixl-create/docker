package com.heima.ai.controller;

import com.google.gson.Gson;
import com.heima.ai.constant.EnumType;
import com.heima.ai.service.ChatHistoryService;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.messages.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;


@RestController
@RequestMapping("/ai")
public class ChatController {

    @Autowired
    private  ChatClient chatClient;

    @Autowired
    private ChatHistoryService chatHistoryService;
    @Autowired
    private ChatMemory chatMemory;
    public static final Gson gson = new Gson();



    @RequestMapping(value = "/chat",produces = "text/html;charset=utf-8")
    public  Flux<String> chat(String prompt, String chatId ){



        Flux<String> message = chatClient.prompt()
                .advisors(advisor -> advisor.param(ChatMemory.CONVERSATION_ID, chatId))
                .user(prompt)
                .stream()
                .content();
        List<Message> content = chatMemory.get(chatId);

        chatHistoryService.save(EnumType.CHAT.getValue(),chatId,saveData(content));
        return message;
    }


    public String saveData(List<Message> content) {
        // 序列化为 JSON 字符串
        return gson.toJson(content);
    }


}
