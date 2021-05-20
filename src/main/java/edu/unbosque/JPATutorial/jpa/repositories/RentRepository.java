package edu.unbosque.JPATutorial.jpa.repositories;

import edu.unbosque.JPATutorial.jpa.entities.Rent;

import java.util.List;
import java.util.Optional;

public interface RentRepository {

    Optional<Rent> findByRentId(Integer rentId);

    Optional<Rent> save(Rent rent);

    void deleteByRentId(Integer rentId);

    List<Rent> findAll();
}
