package com.heima.ai.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author
 * @version JDK 17
 * @description
 * @updateRemark
 * @updateUser
 * @createDate 2025/7/10 17:12
 * @updateDate 2025/7/10 17:12
 **/

@Data
@NoArgsConstructor

public class ChatHistory {

    private String type;
    private String chatId;
    private String content;

    public ChatHistory(String type,String chatId,String content) {
        this.type = type;
        this.chatId = chatId;
        this.content = content;
    }

    public String getChatId() {
        return chatId;
    }

    public String getContent() {
        return content;
    }

    public String getType() {
        return type;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setType(String type) {
        this.type = type;
    }
}
