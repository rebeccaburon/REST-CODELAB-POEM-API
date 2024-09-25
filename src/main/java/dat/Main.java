package dat;

import dat.config.HibernateConfig;
import dat.controllers.PoemController;
import jakarta.persistence.EntityManagerFactory;
import io.javalin.Javalin;


public class Main {
    public static void main(String[] args) {

        PoemController controller = new PoemController();

        Javalin app = Javalin.create().start(7000);




        app.get("/", ctx -> ctx.result("Hello World"));
        app.get("/poems", controller::getAllPoems);
        app.get("/poem/{poemId}", controller::getPoemById);
        app.post("/poems", controller::createPoems);
        app.post("/poem", controller::createPoem);
        app.put("/poem/{poemId}", controller::updatePoem);
        app.delete("/poem/{poemId}", controller::deletePoem);
    }
}