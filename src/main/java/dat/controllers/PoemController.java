package dat.controllers;

import dat.config.HibernateConfig;
import dat.daos.PoemDAO;
import dat.dtos.PoemDTO;
import dat.entities.Poem;
import jakarta.persistence.EntityManagerFactory;
import io.javalin.http.Context;

import java.util.List;

public class PoemController {

    EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory("poems");
    PoemDAO poemDAO = new PoemDAO(emf);
    PoemDTO poemDTO = new PoemDTO();


    public void getPoemById(Context ctx) {

        long poemId = Long.parseLong(ctx.pathParam("poemId"));  // Correct path param name
        // System.out.println(poemId);

        // Fetch the poem from the database via the DAO
        poemDTO = poemDAO.getById(poemId);
        //System.out.println(poemDTO);

        if (poemDTO != null) {
            ctx.status(200);
            ctx.json(poemDTO);  // Return PoemDTO as JSON response
        }
        else {// If not found, return 404
            ctx.status(404);
            ctx.result("Poem not found");
        }
    }
    public void createPoem(Context ctx){
        poemDTO = ctx.bodyAsClass(PoemDTO.class);
        PoemDTO newPoemDTO = poemDAO.create(poemDTO);
        ctx.status(201);
        ctx.json(newPoemDTO);
    }

    public void createPoems(Context ctx){
        // Modtag og konverter en liste af digte (fra json til dto)
        PoemDTO[] poemDTOS = ctx.bodyAsClass(PoemDTO[].class);

        // Gem alle digtene i databasen (dao) og modtag en liste af de nye digte
        List<PoemDTO> newPoemDTOs = poemDAO.createFromList(poemDTOS);
        ctx.status(201);
        ctx.json(newPoemDTOs);

    }
    public void updatePoem(Context ctx){
        long poemId = Long.parseLong(ctx.pathParam("poemId"));  // Correct path param name
        poemDTO = ctx.bodyAsClass(PoemDTO.class);
        poemDTO = poemDAO.update(poemId, poemDTO);
        ctx.status(200);
        ctx.json(poemDTO);
    }
    public void deletePoem(Context ctx){
        long poemId = Long.parseLong(ctx.pathParam("poemId"));
        poemDAO.delete(poemId);
        ctx.status(204);
    }
}
