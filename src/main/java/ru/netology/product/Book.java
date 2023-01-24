package ru.netology.product;

public class Book extends Product {

    private String author;

    public String getAuthor() {
        return author;
    }


    public Book(int id, String name, int price, String title, String author) {
        super(id, name, price, title);
        this.author = author;
    }
}
