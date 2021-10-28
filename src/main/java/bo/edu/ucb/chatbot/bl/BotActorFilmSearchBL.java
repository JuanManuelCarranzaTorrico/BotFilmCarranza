package bo.edu.ucb.chatbot.bl;


import bo.edu.ucb.chatbot.dto.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import bo.edu.ucb.chatbot.dao.ActorDao;
import bo.edu.ucb.chatbot.bl.ActorSearchBl;
import bo.edu.ucb.chatbot.dao.FilmDao;
import bo.edu.ucb.chatbot.bl.FilmSearchBl;
import java.util.ArrayList;
import java.util.List;



@Component
public class BotActorFilmSearchBL {

    private static ActorSearchBl actorSearchBl;
    private static FilmSearchBl filmSearchBl;

    @Autowired
    public BotActorFilmSearchBL(ActorSearchBl actorSearchBlSearchBl, FilmSearchBl filmSearchBl)
    {
        this.actorSearchBl = actorSearchBlSearchBl;
        this.filmSearchBl = filmSearchBl;
    }

    public static List<String> processMessage2(String title,String name, String surname) {
        List<String> result = new ArrayList<>();
        List<String> ac = new ArrayList<>();
        List<String> fi = new ArrayList<>();
        //saco los resultados
        List<Film> filmList =  actorSearchBl.findByName(name,surname);
        List<Film> filmList1 =  filmSearchBl.findByTitle(title);
        //codigo paja
        if (!filmList.isEmpty()) {
            for (Film film : filmList) {
                ac.add(film.toString());
            }
        }
        if (!filmList1.isEmpty()) {
            for (Film film : filmList1) {
                fi.add(film.toString());
            }
        }
        //comparar strings
        for(Film actor: filmList){
            boolean igual=false;
            for(Film peli: filmList1){
                if(actor.getTitle().equals(peli.getTitle())){
                    igual=true;
                }
            }
            if(igual){
                result.add(actor.toString());
            }

        }
        if(result.isEmpty()){
            result.add("no se encontraron coincidencias");
        }


        return result;
    }
}