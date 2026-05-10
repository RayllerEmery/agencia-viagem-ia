package me.rayll.src;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/travel")
public class TravelAgentResource {

    @Inject
    PackageExpertWithTemplate packageExpert;

    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public String ask(String question, @HeaderParam("X-User-Name") String user) {
        if (user != null && !user.isEmpty()) {
            return packageExpert.chat(user, question, user); //Agora utilizo o user como memoryId
        } else {
            return "Usuário não identificado. Por favor, forneça um nome de usuário no cabeçalho 'X-User-Name'.";
        }
    }
}
