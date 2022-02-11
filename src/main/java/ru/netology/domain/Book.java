package ru.netology.domain;

import java.util.Objects;

public class Book extends Product {
    public String author;

    public Book(int id, String name, int price, String author) {
        super(id, name, price);
        this.author = author;
    }
    public Book(){
        super();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}
