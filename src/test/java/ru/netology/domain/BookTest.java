package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    private Book book = new Book(2, "Fathers and children", 2000, "I.S. Turgenev");
    @Test
    void matches() {
        String match="I.S. Turgenev";
        assertTrue(book.matches(match));
    }
    @Test
    void matchesByTitle() {
        String match="Fathers and children";
        assertTrue(book.matches(match));
    }
    @Test
    void matchesByFalse() {
        String match="Hobbits";
        assertFalse(book.matches(match));
    }

}