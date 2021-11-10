

package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

public class ManagerTest {
    Product one = new Book(111, "Book111", 100, "Tolkien");
    Product two = new Book(222, "Book222", 100, "Marks");
    Product three = new Smartphone(333, "Phone333", 5000, "Apple");
    Product four = new Smartphone(444, "Phone444", 5000, "Nokia");

    ProductRepository repo = new ProductRepository();
//    Manager manager = new Manager(repository);

    @BeforeEach
    public void setUp() {
        repo.save(one);
        repo.save(two);
        repo.save(three);
        repo.save(four);
    }

    @Test
    public void shouldRemoveById() {

        Product[] actual = repo.removeById(111);
        Product[] expected = new Product[]{two, three, four};
        assertArrayEquals(actual, expected);

    }

    @Test
    public void shouldCompareThrowsWrongId() {
        assertThrows(NotFoundException.class, () -> {
            repo.removeById(22);
        });
    }

}


//    @Test
//    public void shouldSearchByBrand() {
//
//        Product[] actual = manager.searchBy("Apple");
//        Product[] expected = new Product[]{three};
//        assertArrayEquals(actual, expected);
//    }
//
//    @Test
//    public void shouldSearchByAuthor() {
//
//        Product[] actual = manager.searchBy("Marks");
//        Product[] expected = new Product[]{two};
//        assertArrayEquals(actual, expected);
//    }
//
//    @Test
//    public void shouldSearchByAuthorNoResult() {
//
//        Product[] actual = manager.searchBy("5");
//        Product[] expected = new Product[]{};
//        assertArrayEquals(actual, expected);
//    }
//
//    @Test
//    public void shouldSearchByName() {
//
//        Product[] actual = manager.searchBy("Book");
//        Product[] expected = new Product[]{one, two};
//        assertArrayEquals(actual, expected);



