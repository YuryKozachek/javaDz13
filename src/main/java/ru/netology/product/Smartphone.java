package ru.netology.product;

public class Smartphone extends Product {

    private String maker;

    public String getMaker() {
        return maker;
    }

    public Smartphone(int id, String name, int price, String title, String maker) {
        super(id, name, price, title);
        this.maker = maker;
    }

    public boolean matches(String search) {
        if (super.matches(search)) {
            return true;
        }
        if (maker.contains(search)) {

            return true;
        } else {
            return false;
        }

    }
}
