package bo.edu.ucb.chatbot.bl;

import bo.edu.ucb.chatbot.dto.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import bo.edu.ucb.chatbot.dao.ActorDao;
import bo.edu.ucb.chatbot.bl.ActorSearchBl;
import java.util.ArrayList;
import java.util.List;

/**
 * Procesar la lógica de negocio de las conversaciones del bo.
 * Recibe los mensajes enviados por el usuario como String.
 * Y restorna una List<String> como respuesta a estos mensajes
 * Con el proposito de hacer High Cohesion esta clase no debería utilizar ningun API de Telegram
 */

@Component
public class BotActorSearchBl {

    private static ActorSearchBl actorSearchBl;

    @Autowired
    public BotActorSearchBl(ActorSearchBl actorSearchBlSearchBl)
    {
        this.actorSearchBl = actorSearchBlSearchBl;
    }

    public static List<String> processMessage1(String name, String surname) {
        List<String> result = new ArrayList<>();

        List<Film> filmList =  actorSearchBl.findByName(name,surname);

        if (!filmList.isEmpty()) {
            result.add("Encontré las siguientes películas:");
            for (Film film : filmList) {
                result.add(film.toString());
            }
        } else {
            result.add("No encontré ninguna película para: " + name+" "+surname);
        }

        return result;
    }
}