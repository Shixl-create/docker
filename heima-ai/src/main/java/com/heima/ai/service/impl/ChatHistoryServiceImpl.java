package com.heima.ai.service.impl;

import com.heima.ai.mapper.ChatHistoryMapper;
import com.heima.ai.pojo.entity.ChatHistory;
import com.heima.ai.service.ChatHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author
 * @version JDK 17
 * @description
 * @updateRemark
 * @updateUser
 * @createDate 2025/7/10 10:58
 * @updateDate 2025/7/10 10:58
 **/

@Service
public class ChatHistoryServiceImpl implements ChatHistoryService {

    @Autowired
    private ChatHistoryMapper chatHistoryMapper;

    @Override
    public void save(String type, String chatId,String content) {
            chatHistoryMapper.deleteByChatId(type,chatId);
            ChatHistory record = new ChatHistory(type, chatId,content);
            chatHistoryMapper.insert(record);

    }

    @Override
    public List<String> getChatIds(String type) {
        List<String> chatIds=chatHistoryMapper.getChatIds(type);
        return chatIds==null?new ArrayList<>():chatIds;
    }
}
