package bo.edu.ucb.chatbot;


import bo.edu.ucb.chatbot.bl.ActorSearchBl;
import bo.edu.ucb.chatbot.dao.ActorDao;
import bo.edu.ucb.chatbot.dto.Film;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

/**
 * Testcase 1: Busqueda por titulo de forma exacta
 * Descripción:
 *   - Se debe buscar una pelicula por titulo que solo retorne una ocurrencía.
 * Precondiciones:
 *   - Se conoce de antemano que pelicuals en BBDD tienen solo una ocurrencia por titulo.
 * Valores de entrada:
 *   - maude
 *   - bang kwai
 * Resultado esperado:
 *   - Solo un elemento para cada valor de entrada
 *   - maude:
 *         [
 *           {
 *             "film_id": 566,
 *             "title": "MAUDE MOD",
 *             "description": "A Beautiful Documentary of a Forensic Psychologist And a Cat who must Reach a Astronaut in Nigeria",
 *             "release_year": 2006,
 *             "language": "English",
 *             "originalLanguage": null,
 *             "rental_duration": 6,
 *             "rental_rate": 0.99,
 *             "length": 72,
 *             "replacement_cost": 20.99,
 *             "rating": "R",
 *             "special_features": "Trailers,Behind the Scenes",
 *             "last_update": "2006-02-15 05:03:42"
 *           }
 *         ]
 *
 *
 */
/*@SpringBootTest
class FindByNameTests {

    @Autowired
    ActorSearchBl actorSearchBl;

    @Test
    void findExactlyOne() {
        // Buscamos la pelicula
        List<Film> films = actorSearchBl.findByName("ED","CHASE");
        // Probamos que el resultado sea el epserado
        assertNotNull(films, "La busqueda retorno una lista nula");
        assertEquals(1, films.size(), "La busqueda debería retornar exactamente un elemento");
        Film film = films.get(0);
        assertEquals("ALONE TRIP", film.getTitle(), "El titulo de la película no coincide");
        assertTrue( film.getDescription().startsWith("'A Fast-Paced Character Study of a Composer And a Dog who must Outgun a Boat in An Abandoned Fun House'"), "La descripcion de la película no coincide");
        assertEquals("1h 22m", film.getLength(), "La hora no coincide o esta en formato incorrecto");

    }

}
*/
