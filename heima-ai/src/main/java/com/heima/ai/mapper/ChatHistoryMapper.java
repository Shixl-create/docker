package com.heima.ai.mapper;

import com.heima.ai.pojo.entity.ChatHistory;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author
 * @version JDK 17
 * @description
 * @updateRemark
 * @updateUser
 * @createDate 2025/7/10 16:48
 * @updateDate 2025/7/10 16:48
 **/
@Mapper
public interface ChatHistoryMapper {
    @Insert("INSERT IGNORE INTO chat_history (type, chat_id,content) VALUES (#{type}, #{chatId},#{content})")
    void insert(ChatHistory chatHistory);

    @Select("SELECT chat_id FROM chat_history WHERE type = #{type}")
    List<String> getChatIds(String type);

    @Delete("delete FROM chat_history WHERE type = #{type} AND chat_id = #{chatId}")
    void deleteByChatId(@Param("type") String type, @Param("chatId") String chatId);

    @Select("SELECT content FROM chat_history WHERE chat_id = #{chatId}")
    String getChatHistoryByid(@Param("chatId") String chatId);
}
