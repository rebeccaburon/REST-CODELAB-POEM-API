package dat;

import dat.config.HibernateConfig;
import dat.daos.PersonDAO;
import dat.entities.Person;
import jakarta.persistence.EntityManagerFactory;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory("persons");
    }
}