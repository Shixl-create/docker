package com.heima.ai.pojo.vo;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.ai.chat.messages.Message;

/**
 * @author
 * @version JDK 17
 * @description
 * @updateRemark
 * @updateUser
 * @createDate 2025/7/10 14:21
 * @updateDate 2025/7/10 14:21
 **/

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

public class MessageVo {
    private String role;
    private String content;

    // 用于存储原始消息类型的字段
    @SerializedName("messageType")
    private String messageType;

    // 用于存储文本内容的字段
    @SerializedName("textContent")
    private String textContent;

    // 用于存储元数据的字段
    private JsonObject metadata;

    // 无参构造函数（Gson 需要）
    public MessageVo() {}

    // 转换构造函数（从 JSON 对象转换）
    public MessageVo(JsonObject json) {
        this.messageType = json.has("messageType") ? json.get("messageType").getAsString() : "";
        this.textContent = json.has("textContent") ? json.get("textContent").getAsString() : "";

        // 设置角色
        switch (this.messageType) {
            case "USER" -> this.role = "user";
            case "ASSISTANT" -> this.role = "assistant";
            default -> this.role = "";
        }

        // 设置内容 - 优先使用 textContent
        this.content = this.textContent;

        // 处理元数据
        if (json.has("metadata")) {
            this.metadata = json.getAsJsonObject("metadata");
        }
    }

    // Getters and Setters
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    // 获取原始消息类型（如果需要）
    public String getMessageType() {
        return messageType;
    }

    // 获取元数据（如果需要）
    public JsonObject getMetadata() {
        return metadata;
    }

    // 辅助方法：从元数据中获取特定值
    public String getMetadataValue(String key) {
        if (metadata != null && metadata.has(key)) {
            return metadata.get(key).getAsString();
        }
        return null;
    }

    @Override
    public String toString() {
        return "MessageVo{" +
                "role='" + role + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
