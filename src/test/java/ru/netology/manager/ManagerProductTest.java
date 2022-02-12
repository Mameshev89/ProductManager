package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.SmartPhone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ManagerProductTest {
    private ProductRepository repository = new ProductRepository();
    private ManagerProduct manager = new ManagerProduct(repository);
    private Book book = new Book(1, "Crime and punishment", 3000, "F.M.Dostoevsky");
    private Book book2 = new Book(2, "Fathers and children", 2000, "I.S. Turgenev");
    private SmartPhone iphone = new SmartPhone(3, "Iphone11", 50000, "Apple");
    private SmartPhone iphone2 = new SmartPhone(44, "Iphone", 100000, "Apple");
    private SmartPhone android = new SmartPhone(4, "Galaxy", 500, "Samsung");
    private SmartPhone android2 = new SmartPhone(9, "RedMi", 50000, "Samsung");
    private SmartPhone android3 = new SmartPhone(5, "RedMi", 5000, "Samsung");

    @BeforeEach
    void setUp() {
        manager.add(book);
        manager.add(book2);
        manager.add(iphone);
        manager.add(android);
        manager.add(iphone2);
        manager.add(android2);
        manager.add(android3);
    }

    @Test
    void shouldFindAuthor() {
        Product[] actual = manager.searchBy("F.M.Dostoevsky");
        Product[] expected = new Product[]{book};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindNameBook() {
        Product[] actual = manager.searchBy("Fathers and children");
        Product[] expected = new Product[]{book2};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindNamePhone() {
        Product[] actual = manager.searchBy("Iphone11");
        Product[] expected = new Product[]{iphone};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindPhoneAnotherPhone() {
        Product[] actual = manager.searchBy("Galaxy");
        Product[] expected = new Product[]{android};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindManufacturerAnotherPhone() {
        Product[] actual = manager.searchBy("Samsung");
        Product[] expected = new Product[]{android, android2, android3};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAuthorAnotherBook() {
        Product[] actual = manager.searchBy("I.S. Turgenev");
        Product[] expected = new Product[]{book2};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindInBothProduct() {
        Product[] actual = manager.searchBy("Apple");
        Product[] expected = new Product[]{iphone, iphone2};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindIn() {
        Product[] actual = manager.searchBy("Huawey");
        Product[] expected = new Product[]{};
        assertArrayEquals(expected, actual);
    }
}