package dat.daos;

import dat.entities.Poem;
import dat.exceptions.JpaException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.Set;
import java.util.stream.Collectors;

public class PoemDAO implements IDAO<Poem> {
    EntityManagerFactory emf;

    public PoemDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public Poem create(Poem poem) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(poem);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new JpaException("Error creating person: " + e.getMessage());
        }
        return poem;
    }


    @Override
    public Poem update(Poem poem) {
        return null;
    }

    @Override
    public void delete(Poem poem) {

    }

    public Poem getById(Long id) {
        try(EntityManager em = emf.createEntityManager()){
            return em.find(Poem.class, id);
        }
        catch (Exception e){
            System.out.println("Poem with id " + id + " not found");
        }
        return null;
    }

    public Set<Poem> getAll() {
        try (EntityManager em = emf.createEntityManager()) {
            TypedQuery<Poem> query = em.createQuery("Select p from Poem p", Poem.class);
            Set<Poem> poemList = query.getResultStream().collect(Collectors.toSet());
            return poemList;
        }
    }
}
