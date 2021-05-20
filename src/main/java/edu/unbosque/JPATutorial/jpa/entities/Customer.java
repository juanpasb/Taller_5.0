package edu.unbosque.JPATutorial.jpa.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Customer") // Optional
@NamedQueries({
        @NamedQuery(name = "Customer.findByEmail",
                query = "SELECT c FROM Customer c WHERE c.last_name = : last_name")
})

public class Customer {
    @Id
    @GeneratedValue
    @Column(name = "email")
    private String email;

    @Column(nullable = false)
    private String firts_name;
    private String last_name;
    private String gender;
    private Integer age;

    @OneToMany(mappedBy = "email", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Rent> rent = new ArrayList<>();

    public Customer(){}

    public Customer(String firts_name, String last_name, String gender, Integer age) {
        this.firts_name = firts_name;
        this.last_name = last_name;
        this.gender = gender;
        this.age = age;
    }

    public Customer(String email, String firts_name, String last_name, String gender, Integer age) {
        this.email = email;
        this.firts_name = firts_name;
        this.last_name = last_name;
        this.gender = gender;
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirts_name() {
        return firts_name;
    }

    public void setFirts_name(String firts_name) {
        this.firts_name = firts_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Rent> getRent() {
        return rent;
    }

    public void setRent(List<Rent> rent) {
        this.rent = rent;
    }

    public void addCustomer(Customer customer) {
    }

    //public void addRent(Rent rent) {
      //  rent.add(rent);
        //rent.setCustomer(this);
    //}


}
