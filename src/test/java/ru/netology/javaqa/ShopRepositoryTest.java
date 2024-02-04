package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    Product product1 = new Product(97, "Убить пересмешника", 399);
    Product product2 = new Product(15, "Полный курс корейского языка", 1900);
    Product product3 = new Product(153, "Атлант расправил плечи", 1455);
    Product product4 = new Product(71, "Стикеры", 100);
    Product product5 = new Product(84, "Изучаем Java", 1976);

    ShopRepository shops = new ShopRepository();

    @BeforeEach
    public void setUp() {

        shops.add(product1);
        shops.add(product2);
        shops.add(product3);
        shops.add(product4);
        shops.add(product5);
    }

    @Test
    public void shouldAddProducts() {

        Product[] expected = {product1, product2, product3, product4, product5};
        Product[] actual = shops.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveTheExistingID() {
        shops.remove(71);

        Product[] expected = {product1, product2, product3, product5};
        Product[] actual = shops.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldThrowsExceptionIfRemoveIDNotFound() {

        Assertions.assertThrows(NotFoundException.class, () ->
        {
            shops.remove(11);
        });
    }

}
