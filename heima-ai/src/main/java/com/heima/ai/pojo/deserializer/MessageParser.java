package com.heima.ai.pojo.deserializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.heima.ai.pojo.vo.MessageVo;

import java.lang.reflect.Type;
import java.util.List;

import static com.heima.ai.controller.ChatController.gson;

/**
 * @author
 * @version JDK 17
 * @description
 * @updateRemark
 * @updateUser
 * @createDate 2025/7/11 11:41
 * @updateDate 2025/7/11 11:41
 **/
public class MessageParser {
    private final Gson gson;

    public MessageParser() {
        this.gson = new GsonBuilder()
                .registerTypeAdapter(MessageVo.class, new MessageVoDeserializer())
                .create();
    }
    public List<MessageVo> parseMessages(String json) {
        Type listType = new TypeToken<List<MessageVo>>(){}.getType();
        return gson.fromJson(json, listType);
    }
}
