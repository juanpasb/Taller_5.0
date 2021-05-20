package edu.unbosque.JPATutorial.servlets.pojos;

import edu.unbosque.JPATutorial.jpa.entities.Author;

public class BookPOJO {

    private String title;

    private Integer isbn_number;

    private String author_id;

    private String genre;

    public BookPOJO(String title, String isbn, Author author, String genre){}

    public BookPOJO(String title, Integer isbn_number, String author_id, String genre) {
        this.title = title;
        this.isbn_number = isbn_number;
        this.author_id = author_id;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getIsbn_number() {
        return isbn_number;
    }

    public void setIsbn_number(Integer isbn_number) {
        this.isbn_number = isbn_number;
    }

    public String getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(String author_id) {
        this.author_id = author_id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
