package dat;

import dat.config.HibernateConfig;
import dat.controllers.PoemController;
import jakarta.persistence.EntityManagerFactory;
import io.javalin.Javalin;


public class Main {
    public static void main(String[] args) {
        PoemController poemController = new PoemController();

        Javalin app = Javalin.create((config) -> {
            config.router.contextPath = "/api/poem"; // base path for all routes
            config.bundledPlugins.enableRouteOverview("/routes"); // enables route overview at /routes
        });


        //Get all poems
        app.get("/", poemController::getAllPoems);

        //Get poem by ID
        app.get("/{id}", poemController::getPoemById);

        //Creating a Poam
        app.post("/poem", poemController::createPoem);

        app.post("/poems", poemController::creatListOfPoems);

        //Updating poem by ID
        app.put("/{id}", poemController::updatePoem);

        //Deleting poem by ID
        app.delete("/{id}", poemController::deletePoem);

        app.start(7000);
    }
}