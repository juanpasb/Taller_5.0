package edu.unbosque.JPATutorial.services;

import edu.unbosque.JPATutorial.jpa.entities.Edition;
import edu.unbosque.JPATutorial.jpa.entities.Book;
import edu.unbosque.JPATutorial.jpa.repositories.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Optional;

public class EditionService {

    EditionRepository editionRepository;
    BookRepository bookRepository;

    public void saveEdition(String description, String release_year, Integer bookId) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        editionRepository = new EditionRepositoryImpl(entityManager);
        bookRepository = new BookRepositoryImpl(entityManager);

        Optional<Edition> edition = editionRepository.findById(bookId);
        edition.ifPresent(e -> {
            e.addEdition(new Edition(description, release_year, bookId));
            editionRepository.save(e);
        });

        entityManager.close();
        entityManagerFactory.close();

        return;

    }

    public void deleteEdition(Integer editionId) {

            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            editionRepository = new EditionRepositoryImpl(entityManager);
            editionRepository.deleteById(editionId);

            entityManager.close();
            entityManagerFactory.close();

    }
}

