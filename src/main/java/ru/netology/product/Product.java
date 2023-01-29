package ru.netology.product;

public class Product {
    protected int id;
    protected String name;
    protected int price;
    protected String title;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    public Product(int id, String name, int price, String title) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.title = title;
    }

    public boolean matches(String search) {

        return getName().contains(search);

    }

}
