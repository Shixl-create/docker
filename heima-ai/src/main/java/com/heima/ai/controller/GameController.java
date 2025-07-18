package com.heima.ai.controller;

import com.google.gson.Gson;
import com.heima.ai.constant.EnumType;
import com.heima.ai.service.ChatHistoryService;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.messages.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

/**
 * @author
 * @version JDK 17
 * @description
 * @updateRemark
 * @updateUser
 * @createDate 2025/7/14 10:31
 * @updateDate 2025/7/14 10:31
 **/
@RestController
@RequestMapping("/ai")
public class GameController {

    @Autowired
    private ChatClient gameChatClient;




    @RequestMapping(value = "/game",produces = "text/html;charset=utf-8")
    public Flux<String> chat(String prompt, String chatId ){

        return gameChatClient.prompt()
                .advisors(advisor -> advisor.param(ChatMemory.CONVERSATION_ID, chatId))
                .user(prompt)
                .stream()
                .content();
    }



}
