package ru.netology.productTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.product.*;

public class ProductRepoTest {

    ProductRepo repo = new ProductRepo();


    Product book1 = new Book(1, "Java1", 200, "Book1", "Netology1");
    Product book2 = new Book(2, "Java2", 300, "Book2", "Netology2");
    Product book3 = new Book(3, "Java3", 400, "Book3", "Netology3");
    Product smart1 = new Smartphone(10, "3310", 1400, "smart1", "Nokia1");
    Product smart2 = new Smartphone(15, "3310-10", 1800, "smart2", "Nokia2");
    Product smart3 = new Smartphone(17, "3310-20", 1900, "smart3", "Nokia3");

//    @Test
//    public void findById() {
//        repo.addNewProd(book1);
//        repo.addNewProd(book2);
//        repo.addNewProd(book3);
//
//
//        Product[] expected = {book2};
//        Product[] actual = new Product[]{repo.findById(2)};
//
//        Assertions.assertArrayEquals(expected, actual);
//    }


    @Test
    public void addProduct() {

        repo.addNewProd(book1);
        repo.addNewProd(smart1);
        repo.addNewProd(book2);
        repo.addNewProd(smart3);

        Product[] expected = {book1, smart1, book2, smart3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeExistingProductById() {


        repo.addNewProd(book1);
        repo.addNewProd(book2);
        repo.addNewProd(book3);

        repo.removeById(2);


        Product[] expected = {book1, book3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeNonExistingProductById() {


        repo.addNewProd(book1);
        repo.addNewProd(book2);
        repo.addNewProd(book3);

        Assertions.assertThrows(NotFoundException.class, () ->
                repo.removeById(-100));
    }


    @Test
    public void addProductSame() {

        repo.addNewProd(book1);
        repo.addNewProd(book1);
        repo.addNewProd(smart3);
        repo.addNewProd(smart3);

        Product[] expected = {book1, book1, smart3, smart3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }


}
