package dat.controllers;

import dat.config.HibernateConfig;
import dat.daos.PoemDAO;
import dat.dtos.PoemDTO;
import dat.entities.Poem;
import jakarta.persistence.EntityManagerFactory;
import io.javalin.http.Context;

public class PoemController {

    EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory("poems");
    PoemDAO poemDAO = new PoemDAO(emf);
    PoemDTO poemDTO = new PoemDTO();
    Poem p = new Poem();


    public void getAllPoems (Context ctx){

    }
    public void getPoemById(Context ctx){

    }
    public void createPoem(Context ctx){

    }
    public void updatePoem(Context ctx){

    }
    public void deletePoem(Context ctx){

    }
}
