package bo.edu.ucb.chatbot.bl;

import bo.edu.ucb.chatbot.dao.ActorDao;
import bo.edu.ucb.chatbot.dao.FilmDao;
import bo.edu.ucb.chatbot.dto.Film;
import bo.edu.ucb.chatbot.exception.SakilaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ActorSearchBl {

    private final ActorDao actorDao;

    @Autowired
    public ActorSearchBl(ActorDao actorDao) {
        this.actorDao = actorDao;
    }

    public List<Film> findByName(String name, String surname) {
        if (name == null || name.trim().equals("")) {
            throw new SakilaException(403, "Bad request: The title parameter is mandatory and can't be null or empty");
        }
        return actorDao.findByName(name,surname);
    }
}