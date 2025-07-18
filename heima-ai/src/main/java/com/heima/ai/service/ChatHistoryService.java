package com.heima.ai.service;

import java.util.List;

public interface ChatHistoryService {

    /**
     *
     * @param type  业务类型  如chat,pdf
     * @param chatId   会话id
     */
    void save(String type,String chatId,String content);

    /**
     *
     * @param type 业务类型  如chat,pdf
     * @return  会话列表
     */
    List<String> getChatIds(String type);
}
