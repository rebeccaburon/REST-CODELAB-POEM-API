package dat;

import dat.config.HibernateConfig;
import dat.controllers.PoemController;
import jakarta.persistence.EntityManagerFactory;
import io.javalin.Javalin;


public class Main {
    public static void main(String[] args) {


        Javalin app = Javalin.create((config) ->{
            config.router.contextPath = "/api/poem"; // base path for all routes
            config.bundledPlugins.enableRouteOverview("path/routes"); // enables route overview at /routes
        });








        app.start(7000);
    }
}