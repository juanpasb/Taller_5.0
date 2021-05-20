package edu.unbosque.JPATutorial.jpa.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Rent") // Optional
@NamedQueries({
        @NamedQuery(name = "Rent.findByEmail",
                query = "SELECT r FROM Rent r WHERE r.renting_date = :renting_date"),
        @NamedQuery(name = "Rent.findAll",
                query = "SELECT r FROM Rent r")
})

public class Rent {

    @Id
    @GeneratedValue
    @Column(name = "rent_id")
    private Integer rentId;

    @ManyToOne
    @JoinColumn(name = "email")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "edition_id")
    private Edition edition;

    @Column(name = "renting_date")
    private String renting_date;

    @OneToOne(mappedBy = "rent")
    private Edition edition_2;

    public Rent(String email, Integer edition_id, String renting_date){}

    public Rent(String renting_date) {
        this.renting_date = renting_date;
    }

    public Rent(String renting_date, Integer rentId) {
        this.renting_date = renting_date;
        this.rentId = rentId;
    }

    public Integer getRentId() {
        return rentId;
    }

    public void setRentId(Integer rentId) {
        this.rentId = rentId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Edition getEdition() {
        return edition;
    }

    public void setEdition(Edition edition) {
        this.edition = edition;
    }

    public String getRenting_date() {
        return renting_date;
    }

    public void setRenting_date(String renting_date) {
        this.renting_date = renting_date;
    }

    public Edition getEdition_2() {
        return edition_2;
    }

    public void setEdition_2(Edition edition_2) {
        this.edition_2 = edition_2;
    }

    public void addRent(Rent rent) {
    }
}
