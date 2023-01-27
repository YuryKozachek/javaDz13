package ru.netology.product;

public class ProductRepo {
    private Product[] productsArray = new Product[0];

    public Product[] getProductsArray() {
        return productsArray;
    }

    public void addNewProd(Product product) {
        Product[] newArray = new Product[productsArray.length + 1];
        for (int i = 0; i < productsArray.length; i++) {
            newArray[i] = productsArray[i];
        }
        newArray[newArray.length - 1] = product;
        productsArray = newArray;
    }

    public Product[] findAll() {
        return productsArray;
    }

    public void delById(int id) {
        Product[] delArray = new Product[productsArray.length - 1];
        int i = 0;
        for (Product prod : productsArray) {
            if (prod.getId() != id) {
                delArray[i] = prod;
                i++;
            }
        }
        productsArray = delArray;
    }
}
