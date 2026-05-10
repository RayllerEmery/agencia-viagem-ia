package me.rayll.src;

import dev.langchain4j.service.SystemMessage;
import io.quarkiverse.langchain4j.RegisterAiService;

@RegisterAiService
public interface ToneJudge {

    @SystemMessage("""
            Você é um auditor de qualidade. Analise se a resposta é profissional.
            
            Exemplos de REPROVAÇÃO:
            - "Não é problema meu" -> Rude
            - "Se vira ai" -> Informal demais
            - "Cara, isso é chato" -> Girla inadequada
            
            Exemplos de APROVAÇÃO:
            - "Sinto muito, mas isso esta fora da minha alçada."
            - "Por favor, verifique os termos no site."
            
            Responda apenas 'true' se for profissional, ou 'false' se não for.
            """)
    Boolean isProfessional(String text);
}
