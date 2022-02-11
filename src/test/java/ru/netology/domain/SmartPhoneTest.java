package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartPhoneTest {
     SmartPhone phone= new SmartPhone(1, "Huawey", 20000, "Sony");
    @Test
    void matches() {
       String match ="Sony";
       assertTrue(phone.matches(match));
    }
    @Test
    void matchesByName() {
        String match ="Huawey";
        assertTrue(phone.matches(match));
    }
    @Test
    void matchesFalse() {
        String match ="SonyErikson";
        assertFalse(phone.matches(match));
    }
}