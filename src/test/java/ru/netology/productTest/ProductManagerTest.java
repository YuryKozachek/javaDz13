package ru.netology.productTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.product.*;

public class ProductManagerTest {

    ProductRepo repo = new ProductRepo();
    ProductManager manager = new ProductManager(repo);

    Product book1 = new Book(1, "Java1", 200, "Book1", "Netology1");
    Product book2 = new Book(2, "Java2", 300, "Book2", "netology2");
    Product book3 = new Book(3, "Java1", 400, "Book3", "Netology3");
    Product smart1 = new Smartphone(10, "N_3310", 1400, "smart1", "nokia1");
    Product smart2 = new Smartphone(15, "N_3310-10", 1800, "smart2", "nokia2");
    Product smart3 = new Smartphone(17, "Nok_3310-20", 1900, "smart3", "NOkia3");

    @Test
    public void searchByNameBook() {

        manager.add(book1);
        manager.add(book2);
        manager.add(smart1);
        manager.add(smart2);

        Product[] expected = {book2};
        Product[] actual = manager.searchBy("Java2");

        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void searchByNameSmart() {

        manager.add(book1);
        manager.add(book2);
        manager.add(smart1);
        manager.add(smart3);


        Product[] expected = {smart3};
        Product[] actual = manager.searchBy("Nok_");


        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByNameBookMoreOne() {

        manager.add(book1);
        manager.add(book2);
        manager.add(smart1);
        manager.add(smart2);
        manager.add(book3);


        Product[] expected = {book1, book3};
        Product[] actual = manager.searchBy("Java1");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void searchByNameSmartMoreOne() {

        manager.add(book1);
        manager.add(book2);
        manager.add(smart1);
        manager.add(smart3);
        manager.add(smart2);


        Product[] expected = {smart1, smart2};
        Product[] actual = manager.searchBy("N_");


        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByAuthor() {

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] expected = {book1, book3};
        Product[] actual = manager.searchBy("Net");

        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void searchByMaker() {


        manager.add(smart1);
        manager.add(smart3);
        manager.add(smart2);

        Product[] expected = {smart1, smart2};
        Product[] actual = manager.searchBy("nok");

        Assertions.assertArrayEquals(expected, actual);


    }

}
