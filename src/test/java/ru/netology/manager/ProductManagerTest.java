package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

public class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);

    private Product product1 = new Product(1, "Product 1", 1000);
    private Product book1 = new Book(2, "Anatomy", 2000, "Gayvoronskii");
    private Book book2 = new Book(3, "Histology", 3000, "Baskakov");
    private Product smartphone1 = new Smartphone(4, "Iphone", 4000, "Apple");
    private Smartphone smartphone2 = new Smartphone(5, "Xperia", 5000, "Sony");

    @BeforeEach
    public void setUp(){
        manager.add(product1);
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);
    }

    @Test
    public void shouldSearchIfTextEmpty() {
        String text = "";

        Product[] expected = {};
        Product[] actual = ProductManager.searchBy(text);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByBookName() {
        String text = "Anatomy";

        Product[] expected = {book1};
        Product[] actual = ProductManager.searchBy(text);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByBookAuthor() {
        String text = "Baskakov";

        Product[] expected = {book2};
        Product[] actual = ProductManager.searchBy(text);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBySmartphoneName() {
        String text = "Iphone";

        Product[] expected = {smartphone1};
        Product[] actual = ProductManager.searchBy(text);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBySmartphoneManufacturer() {
        String text = "Sony";

        Product[] expected = {smartphone2};
        Product[] actual = ProductManager.searchBy(text);

        assertArrayEquals(expected, actual);
    }

}
