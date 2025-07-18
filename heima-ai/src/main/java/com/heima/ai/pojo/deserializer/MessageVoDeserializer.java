package com.heima.ai.pojo.deserializer;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.heima.ai.pojo.vo.MessageVo;

import java.lang.reflect.Type;
import com.google.gson.*;


/**
 * @author
 * @version JDK 17
 * @description
 * @updateRemark
 * @updateUser
 * @createDate 2025/7/11 11:38
 * @updateDate 2025/7/11 11:38
 **/
public class MessageVoDeserializer implements JsonDeserializer<MessageVo> {
    @Override
    public MessageVo deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {

        if (json.isJsonObject()) {
            return new MessageVo(json.getAsJsonObject());
        }
        throw new JsonParseException("Expected JSON object for MessageVo");
    }
}
