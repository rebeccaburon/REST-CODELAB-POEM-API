package dat.controllers;

import dat.config.HibernateConfig;
import dat.daos.PoemDAO;
import dat.dtos.PoemDTO;
import dat.entities.Poem;
import jakarta.persistence.EntityManagerFactory;
import io.javalin.http.Context;

import java.util.ArrayList;
import java.util.List;

public class PoemController {

    EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory("poems");
    PoemDAO poemDAO = new PoemDAO(emf);
    PoemDTO poemDTO = new PoemDTO();


    public void getAllPoems(Context ctx) {
        List<PoemDTO> poemDTOList = poemDAO.getAll();
        if (poemDTOList.isEmpty()) {
            ctx.status(404);
            ctx.result("No Poems found");
        } else {
            ctx.status(200);
            ctx.json(poemDAO);
        }
    }

    public void getPoemById(Context ctx) {
        long poemId = Long.parseLong(ctx.pathParam("id"));

       poemDTO = poemDAO.getById(poemId);
       if (poemDTO != null) {
           ctx.status(200);
           ctx.json(poemDTO);
       } else{
           ctx.status(404);
           ctx.result("No Poem found");
       }
    }

    public void createPoem(Context ctx) {
            poemDTO = ctx.bodyAsClass(PoemDTO.class);
            PoemDTO newPoemDTO = poemDAO.create(poemDTO);
            ctx.status(201);
            ctx.json(newPoemDTO);
            ctx.result("Poem created");
    }

    public void creatListOfPoems(Context ctx) {
        PoemDTO[]listOfPoems = ctx.bodyAsClass(PoemDTO[].class);

        List<PoemDTO> newListOfPoems = poemDAO.createFromList(listOfPoems);
        ctx.status(201);
        ctx.json(newListOfPoems);

    }

    public void updatePoem(Context ctx) {
        long poemId = Long.parseLong(ctx.pathParam("id"));  // Correct path param name
        poemDTO = ctx.bodyAsClass(PoemDTO.class);
        poemDTO = poemDAO.update(poemId, poemDTO);
        ctx.status(200);
        ctx.json(poemDTO);
    }

    public void deletePoem(Context ctx) {
        long poemId = Long.parseLong(ctx.pathParam("id"));
        poemDAO.delete(poemId);
        ctx.status(204);
    }
}
