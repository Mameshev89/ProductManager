package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.Product;
import ru.netology.domain.SmartPhone;
import ru.netology.manager.ManagerProduct;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Book book = new Book(1, "Crime and punishment", 3000, "F.M.Dostoevsky");
    private Book book2 = new Book(2, "Fathers and children", 2000, "I.S. Turgenev");
    private SmartPhone iphone = new SmartPhone(3, "Iphone11", 50000, "Apple");

    @BeforeEach
    void setUp() {
        repository.save(book);
        repository.save(book2);
        repository.save(iphone);
    }

    @Test
    void removeById() {
        repository.removeId(2);
        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{book, iphone};
        assertArrayEquals(expected, actual);

    }

    @Test
    void removeByIdNull() {
        assertThrows(NotFoundException.class, () -> {
            repository.removeId(85);
        });

    }
}