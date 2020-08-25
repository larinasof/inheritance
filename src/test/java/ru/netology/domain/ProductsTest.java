package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductsTest {
    private Product product = new Product(1, "Product 1", 1000);
    private Product book = new Book(2, "Anatomy", 2000, "Gayvoronskii");
    private Product smartphone = new Smartphone(3, "Iphone", 3000, "Apple");

    @Test
    void shouldProductNameMatch() {
        boolean actual = product.matches("Product 1");
        assertTrue(actual);
    }

    @Test
    void shouldProductNameNotMatch() {
        boolean actual = product.matches("Product 2");
        assertFalse(actual);
    }

    @Test
    void shouldBookNameMatch() {
        boolean actual = book.matches("Anatomy");
        assertTrue(actual);
    }

    @Test
    void shouldBookNameNotMatch() {
        boolean actual = book.matches("Histology");
        assertFalse(actual);
    }

    @Test
    void shouldBookAuthorMatch() {
        boolean actual = book.matches("Gayvoronskii");
        assertTrue(actual);
    }

    @Test
    void shouldBookAuthorNotMatch() {
        boolean actual = book.matches("Baskakov");
        assertFalse(actual);
    }

    @Test
    void shouldSmartphoneNameMatch() {
        boolean actual = smartphone.matches("Iphone");
        assertTrue(actual);
    }

    @Test
    void shouldSmartphoneNameNotMatch() {
        boolean actual = smartphone.matches("Xperia");
        assertFalse(actual);
    }

    @Test
    void shouldSmartphoneManufacturerMatch() {
        boolean actual = smartphone.matches("Apple");
        assertTrue(actual);
    }

    @Test
    void shouldSmartphoneManufacturerNotMatch() {
        boolean actual = smartphone.matches("Sony");
        assertFalse(actual);
    }

}
