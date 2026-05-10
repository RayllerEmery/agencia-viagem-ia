package me.rayll.src;

import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.guardrail.OutputGuardrail;
import dev.langchain4j.guardrail.OutputGuardrailResult;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ToneGuardrail implements OutputGuardrail {

    @Inject
    ToneJudge toneJudge;

    @Override
    public OutputGuardrailResult validate(AiMessage aiMessage) {
        var tone = toneJudge.isProfessional(aiMessage.text());

        System.out.println("### ToneJudge result: " + tone);

        if (!toneJudge.isProfessional(aiMessage.text())) {
            return reprompt(aiMessage.text(), """
                    Sua resposta foi detectada como rude ou informal demais.
                    "Reescreva-a mantendo a polidez e formalidade de um agente de viagens sênior.
                    """);
        }
        return OutputGuardrailResult.success();
    }
}
