package edu.unbosque.JPATutorial.services;


import edu.unbosque.JPATutorial.jpa.entities.Book;
import edu.unbosque.JPATutorial.jpa.entities.Customer;
import edu.unbosque.JPATutorial.jpa.repositories.*;
import edu.unbosque.JPATutorial.servlets.pojos.BookPOJO;
import edu.unbosque.JPATutorial.servlets.pojos.CustomerPOJO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerService {

    CustomerRepository customerRepository;


    public void saveCustomer(String email, String firts_name, String last_name, String gender, Integer age) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        customerRepository = new CustomerRepositoryImpl(entityManager);


        Optional<Customer> customer = customerRepository.findByEmail(email);
        customer.ifPresent(c -> {
            c.addCustomer(new Customer(email, firts_name, last_name, gender, age));
            customerRepository.save(c);
        });

        entityManager.close();
        entityManagerFactory.close();

        return;

    }

    public void deleteCustomer(String email) {


            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            customerRepository = new CustomerRepositoryImpl(entityManager);
            customerRepository.deleteByEmail(email);

            entityManager.close();
            entityManagerFactory.close();

    }

    public List<CustomerPOJO> listCustomer() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        customerRepository = new CustomerRepositoryImpl(entityManager);
        List<Customer> customers = customerRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        List<CustomerPOJO> customerPOJO = new ArrayList<>();
        for (Customer customer : customers) {
            customerPOJO.add(new CustomerPOJO(
                    customer.getFirts_name(),
                    customer.getLast_name(),
                    customer.getGender(),
                    customer.getAge()

            ));
        }

        return customerPOJO;
    }
}
