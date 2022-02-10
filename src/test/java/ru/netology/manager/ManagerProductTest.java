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
    private SmartPhone iphone2 = new SmartPhone(3, "Iphone11", 100000, "Apple");
    private SmartPhone android= new SmartPhone(4,"Galaxy", 50000,"Samsung");

    @BeforeEach
    void setUp() {
        manager.add(book);
        manager.add(book2);
        manager.add(iphone);
        manager.add(android);
    }

    @Test
    void shouldFindAuthor() {
        Product[] actual=new Product[]{book};
        Product[] expected=manager.searchBy("F.M.Dostoevsky");
        assertArrayEquals(actual,expected);
    }
    @Test
    void shouldFindNameBook() {
        Product[] actual=new Product[]{book2};
        Product[] expected=manager.searchBy("Fathers and children");
        assertArrayEquals(actual,expected);
    }
    @Test
    void shouldFindNameSmartPhone() {
        Product[] actual=new Product[]{iphone};
        Product[] expected=manager.searchBy("Iphone11");
        assertArrayEquals(actual,expected);
    }
    @Test
    void shouldFindManufacturerPhone() {
        Product[] actual=new Product[]{android};
        Product[] expected=manager.searchBy("Galaxy");
        assertArrayEquals(actual,expected);
    }

    @Test
    void shouldFind() {
        Product[] actual=new Product[]{android};
        Product[] expected=manager.searchBy("Samsung");
        assertArrayEquals(actual,expected);
    }
    @Test
    void should() {
        Product[] actual=new Product[]{book2};
        Product[] expected=manager.searchBy("I.S. Turgenev");
        assertArrayEquals(actual,expected);
    }
    @Test
    void shouldNull() {
        Product[] expected=manager.searchBy("Iphone11");
        Product[] actual=new Product[]{iphone};

        assertArrayEquals(actual,expected);
    }
}