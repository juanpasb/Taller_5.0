package edu.unbosque.JPATutorial.servlets.pojos;

import edu.unbosque.JPATutorial.jpa.entities.Customer;
import edu.unbosque.JPATutorial.jpa.entities.Edition;

public class RentPOJO {

    private String email;

    private Integer edition_id;

    private String renting_date;

    public RentPOJO (){ }

    public RentPOJO(String email, Integer edition_id, String renting_date) {
        this.email = email;
        this.edition_id = edition_id;
        this.renting_date = renting_date;
    }

    public RentPOJO(String renting_date, Edition edition, Customer customer) {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getEdition_id() {
        return edition_id;
    }

    public void setEdition_id(Integer edition_id) {
        this.edition_id = edition_id;
    }

    public String getRenting_date() {
        return renting_date;
    }

    public void setRenting_date(String renting_date) {
        this.renting_date = renting_date;
    }
}
