package edu.unbosque.JPATutorial.servlets.pojos;

import edu.unbosque.JPATutorial.jpa.entities.Author;

public class AuthorPOJO {

    private Integer authorId;

    private String name;

    private String country;

    private Integer numBooks;

    public AuthorPOJO() { }

    public AuthorPOJO(Integer authorId, String name, Integer numBooks, String country) {
        this.authorId = authorId;
        this.name = name;
        this.numBooks = numBooks;
        this.country = country;
    }

    public AuthorPOJO(String title, String isbn, Author author, String genre) {
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getNumBooks() {
        return numBooks;
    }

    public void setNumBooks(Integer numBooks) {
        this.numBooks = numBooks;
    }

}
