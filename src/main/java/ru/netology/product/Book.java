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

    public boolean matches(String search) {
        if (super.matches(search)) {
            return true;
        }
        if (author.contains(search)) {

            return true;
        } else {
            return false;
        }

    }
}
