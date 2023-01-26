package ru.netology.product;

public class ProductManager {
    private ProductRepo repo;

    public ProductManager(ProductRepo repo) {
        this.repo = repo;
    }

    public void add(Product product) {
        repo.addNewProd(product);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repo.findAll()) {
            if (matches(product, text)) {
                Product[] newArray = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    newArray[i] = result[i];
                }
                newArray[newArray.length - 1] = product;
                result = newArray;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {

        return (product.matches(search));

//        return product.getName().contains(search);
//        if (product.getName().contains(search)) {
//            return true;
//        } else {
//            return false;
//        }
    }
}
