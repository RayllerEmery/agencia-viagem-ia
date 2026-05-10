package me.rayll.src;

import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.store.memory.chat.InMemoryChatMemoryStore;
import jakarta.enterprise.inject.Produces;


public class ChatMemoryConfig {

    @Produces
    public ChatMemory getChatMemory() {
        return MessageWindowChatMemory.builder()
                .maxMessages(20)
                .chatMemoryStore(new InMemoryChatMemoryStore())
                .build();
    }
}
