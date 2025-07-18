package com.heima.ai.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.heima.ai.mapper.ChatHistoryMapper;
import com.heima.ai.pojo.deserializer.MessageParser;
import com.heima.ai.pojo.vo.ContentVo;
import com.heima.ai.pojo.vo.MessageVo;
import com.heima.ai.service.ChatHistoryService;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.messages.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;

import static com.heima.ai.controller.ChatController.gson;

/**
 * @author
 * @version JDK 17
 * @description
 * @updateRemark
 * @updateUser
 * @createDate 2025/7/10 11:43
 * @updateDate 2025/7/10 11:43
 **/
@RestController
@RequestMapping("/ai/history")
public class ChatHistoryController {
    @Autowired
    private ChatHistoryService chatHistoryService;

    @Autowired
    private ChatMemory chatMemory;
    @Autowired
    private ChatHistoryMapper chatHistoryMapper;


    @GetMapping("/{type}")
    public List<String> getCharIds(@PathVariable("type") String type) {
       return chatHistoryService.getChatIds(type);
    }

    @GetMapping ("/{type}/{chatId}")
    public List<ContentVo> getChatHistory(@PathVariable("type") String type, @PathVariable("chatId") String chatId) {
        String content= chatHistoryMapper.getChatHistoryByid(chatId);
        MessageParser parser = new MessageParser();

        if (content == null || content.isBlank()) {
            return List.of();
        }
        List<MessageVo> messages = parser.parseMessages(content);



        return messages.stream().map(ContentVo::new).toList();
    }


}
