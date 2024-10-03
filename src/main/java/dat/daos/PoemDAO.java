package dat.daos;

import dat.dtos.PoemDTO;
import dat.entities.Poem;
import dat.exceptions.JpaException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PoemDAO {
    EntityManagerFactory emf;

    public PoemDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }


    public PoemDTO create(PoemDTO poemDTO) {
        Poem poem = new Poem(poemDTO);
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(poem);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new JpaException("Error creating person: " + e.getMessage());
        }
        return new PoemDTO(poem);
    }

    public List<PoemDTO> createFromList(PoemDTO[] poemDTOS) {
        List<PoemDTO> poemDTOList = new ArrayList<>();
        for (PoemDTO poemDTO : poemDTOS) {
            PoemDTO newPoemDTO = create(poemDTO);  //
            poemDTOList.add(newPoemDTO);
        }
        return poemDTOList;
    }


    public PoemDTO update(Long id, PoemDTO poemDTO) {
        try (EntityManager em = emf.createEntityManager()) {
            Poem poem = em.find(Poem.class, id);
            if (poem != null) {
                em.getTransaction().begin();
                poem.setAuthor(poemDTO.getAuthor());
                poem.setPoem(poemDTO.getPoem());
                poem.setType(poemDTO.getType());
                em.getTransaction().commit();
            }
            ;
            return new PoemDTO(poem);
        }
    }


    public void delete(Long id) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            Poem poem = em.find(Poem.class, id);
            if (poem != null) {
                em.remove(poem);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            System.out.println("Poem with id " + id + " not found");
        }
    }

    public PoemDTO getById(Long id) {
        try (EntityManager em = emf.createEntityManager()) {
            Poem poem = em.find(Poem.class, id);
            if (poem != null) {
                return new PoemDTO(poem);
            }
        } catch (Exception e) {
            System.out.println("Poem with id " + id + " not found");
        }
        return null;
    }

    public List<PoemDTO> getAll() {
        try (EntityManager em = emf.createEntityManager()) {
            TypedQuery<Poem> query = em.createQuery("Select p from Poem p", Poem.class);
            return PoemDTO.toDTOList(query.getResultList());
        }
    }
}
