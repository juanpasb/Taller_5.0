package edu.unbosque.JPATutorial.services;

import edu.unbosque.JPATutorial.jpa.entities.Author;
import edu.unbosque.JPATutorial.jpa.entities.Book;
import edu.unbosque.JPATutorial.jpa.entities.Rent;
import edu.unbosque.JPATutorial.jpa.repositories.*;
import edu.unbosque.JPATutorial.servlets.pojos.BookPOJO;
import edu.unbosque.JPATutorial.servlets.pojos.RentPOJO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RentService {

    RentRepository rentRepository;
    CustomerRepository customerRepository;

    public void saveRent(String email, Integer edition_id, String Renting_date) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        rentRepository = new RentRepositoryImpl(entityManager);
        customerRepository = new CustomerRepositoryImpl(entityManager);

        Optional<Rent> rent = rentRepository.findByRentId(edition_id);
        rent.ifPresent(r -> {
            r.addRent(new Rent(email, edition_id, Renting_date));
            rentRepository.save(r);
        });

        entityManager.close();
        entityManagerFactory.close();

        return;

    }
    public void deleteRent(Integer rentId) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        rentRepository = new RentRepositoryImpl(entityManager);
        rentRepository.deleteByRentId(rentId);

        entityManager.close();
        entityManagerFactory.close();

    }

    public List<RentPOJO> listRent() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        rentRepository = new RentRepositoryImpl(entityManager);
        List<Rent> rent = rentRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        List<RentPOJO> rentPOJO = new ArrayList<>();
        for (Rent rents : rent) {
            rentPOJO.add(new RentPOJO(
                    rents.getRenting_date(), rents.getEdition(), rents.getCustomer()

            ));
        }

        return rentPOJO;
    }

}
