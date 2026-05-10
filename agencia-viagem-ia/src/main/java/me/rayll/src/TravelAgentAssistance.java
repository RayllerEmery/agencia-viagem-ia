package me.rayll.src;

import io.quarkiverse.langchain4j.RegisterAiService;

//Essa anotação faz o Quarkus reconhecer essa interface como um serviço de IA, permitindo que seja injetada e utilizada em outras partes da aplicação.
@RegisterAiService
public interface TravelAgentAssistance {
    /**
     * O método 'chat' recebe a mensagem do usuário e retorna a resposta do llm
     * @param userMessage
     * @return resposta gerada pelo modelo
     */
    String chat(String userMessage);
}
