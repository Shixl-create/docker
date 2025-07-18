package com.heima.ai;

import org.junit.jupiter.api.Test;
import org.springframework.ai.openai.OpenAiEmbeddingClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HeimaAiApplicationTests {
    @Autowired
    private OpenAiEmbeddingClient openAiEmbeddingClient;


    @Test
    void contextLoads() {
    }

}
