package com.heima.ai.config;

import com.heima.ai.constant.SystemConstant;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.openai.OpenAiChatClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonConfiguration {
 @Autowired
 ChatMemory chatMemory;






    @Bean
    public ChatClient chatClient(OllamaChatModel model){

        return ChatClient
                .builder(model)
                .defaultSystem("你是一个智能数据分析师，叫小华华")
                .defaultAdvisors(MessageChatMemoryAdvisor.builder(chatMemory).build(),new SimpleLoggerAdvisor())
                .build();
    }

    @Bean
    public ChatClient gameChatClient(OpenAiChatClient openAiChatClient){

        return ChatClient
                .builder((ChatModel) openAiChatClient)
                .defaultSystem(SystemConstant.Game_Assistant_Prompt)
                .defaultAdvisors(MessageChatMemoryAdvisor.builder(chatMemory).build(),new SimpleLoggerAdvisor())
                .build();
    }




}
