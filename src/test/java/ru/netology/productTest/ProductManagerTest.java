package ru.netology.productTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.product.*;

public class ProductManagerTest {

    ProductRepo repo = new ProductRepo();
    ProductManager manager = new ProductManager(repo);

    Product book1 = new Book(1, "Java1-ok", 200, "Book1", "Netology1");
    Product book2 = new Book(2, "Java2-ok", 300, "Book2", "netology2");
    Product book3 = new Book(3, "Java1", 400, "Book3", "Netology3");
    Product book4 = new Book(13, "Java33", 400, "Book3", "Shubkin");
    Product smart1 = new Smartphone(10, "N_3310", 1400, "smart1", "nokia1");
    Product smart2 = new Smartphone(15, "N_3310-10-ok", 1800, "smart2", "nokia2");
    Product smart3 = new Smartphone(173, "Nok_3310-20", 1900, "smart3", "NOkia3");
    Product smart4 = new Smartphone(147, "Sam8", 1900, "smart3", "Samsung");

    @Test
    public void searchByNullName() {

        manager.add(book1);
        manager.add(book2);
        manager.add(smart1);
        manager.add(smart2);

        Product[] expected = new Product[0];
        Product[] actual = manager.searchBy("Java23");

        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void searchByAllBook() {

        manager.add(book2);
        manager.add(book1);
        manager.add(book2);
        manager.add(smart1);
        manager.add(smart2);
        manager.add(book2);
        manager.add(book1);
        manager.add(book2);
        manager.add(smart1);
        manager.add(smart2);

        Product[] expected = {book2, book1, book2, book2, book1, book2};
        Product[] actual = manager.searchBy("Ja");

        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void searchByOneProd() {

        manager.add(smart3);

        Product[] expected = {smart3};
        Product[] actual = manager.searchBy("Nok");

        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void searchByNameInDifferentCategories() {

        manager.add(book1);
        manager.add(book2);
        manager.add(smart1);
        manager.add(smart2);


        Product[] expected = {book1, book2, smart2};
        Product[] actual = manager.searchBy("-ok");


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
    public void searchByAuthorMoreOne() {

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] expected = {book1, book3};
        Product[] actual = manager.searchBy("Net");

        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void searchByMakerMoreOne() {


        manager.add(smart1);
        manager.add(smart3);
        manager.add(smart2);

        Product[] expected = {smart1, smart2};
        Product[] actual = manager.searchBy("nok");

        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void searchByOneAuthor() {

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);

        Product[] expected = {book4};
        Product[] actual = manager.searchBy("Shubkin");

        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void searchByOneSmart() {

        manager.add(smart1);
        manager.add(smart2);
        manager.add(smart3);
        manager.add(smart4);

        Product[] expected = {smart4};
        Product[] actual = manager.searchBy("Sams");

        Assertions.assertArrayEquals(expected, actual);


    }

}
