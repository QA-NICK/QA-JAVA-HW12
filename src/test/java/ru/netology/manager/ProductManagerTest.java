package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

public class ProductManagerTest {
    Product one = new Book(1, "testBook", 50, "Petrov");
    Product two = new Smartphone(2, "TestPhone", 1000, "Nokia");
    Product three = new Smartphone(3, "TestPhone", 1000, "LG");
    Product four = new Book(4, "testBook", 50, "Petrov");
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);

    @BeforeEach
    public void setUp() {
        manager.add(one);
        manager.add(two);
        manager.add(three);
        manager.add(four);
    }


    @Test
    public void shouldSearchByName() {

        Product[] actual = manager.searchBy("testBook");
        Product[] expected = new Product[]{one, four};
        assertArrayEquals(actual, expected);

    }

    @Test
    public void shouldSearchByMaker() {

        Product[] actual = manager.searchBy("LG");
        Product[] expected = new Product[]{three};
        assertArrayEquals(actual, expected);
    }
    @Test
    public void shouldSearchByAuthor() {

        Product[] actual = manager.searchBy("Petrov");
        Product[] expected = new Product[]{one, four};
        assertArrayEquals(actual, expected);
    }
    @Test
    public void shouldSearchByAuthorFindNothing() {

        Product[] actual = manager.searchBy("Ivanov");
        Product[] expected = new Product[]{};
        assertArrayEquals(actual, expected);
    }
}