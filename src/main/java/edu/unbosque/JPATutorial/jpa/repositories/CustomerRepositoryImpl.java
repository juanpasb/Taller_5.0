package edu.unbosque.JPATutorial.jpa.repositories;

import edu.unbosque.JPATutorial.jpa.entities.Customer;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class CustomerRepositoryImpl implements CustomerRepository {

    private EntityManager entityManager;

    public CustomerRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Optional<Customer> findById(Integer id) {
        Customer customer = entityManager.find(Customer.class, id);
        return customer != null ? Optional.of(customer) : Optional.empty();
    }

    public Optional<Customer> findByFisrt_name(String fisrt_name) {
        Customer customer = entityManager.createQuery("SELECT c FROM Customer c WHERE c.last_name = : fisrt_name", Customer.class)
                .setParameter("fisrt_name", fisrt_name)
                .getSingleResult();
        return customer != null ? Optional.of(customer) : Optional.empty();
    }

    public Optional<Customer> findByLast_name(String last_name) {
        Customer customer = entityManager.createQuery("SELECT c FROM Customer c WHERE c.last_name = : last_name", Customer.class)
                .setParameter("last_name", last_name)
                .getSingleResult();
        return customer != null ? Optional.of(customer) : Optional.empty();
    }


    @Override
    public Optional<Customer> findByEmail(String email) {
        return Optional.empty();
    }

    public List<Customer> findAll() {
        return entityManager.createQuery("from Customer").getResultList();
    }

    public Optional<Customer> save(Customer customer) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(customer);
            entityManager.getTransaction().commit();
            return Optional.of(customer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void deleteByEmail(String email) {

    }
}
