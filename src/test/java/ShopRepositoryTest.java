import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    @Test
    public void testRemoveWhenProductExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(3, "смартфон", 20_000);
        Product product2 = new Product(5, "журнал", 150);
        Product product3 = new Product(7, "автомобиль", 1000_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(5);
        Product[] actual = repo.findAll();
        Product[] expected = {product1, product3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveWhenProductNoExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(3, "смартфон", 20_000);
        Product product2 = new Product(5, "журнал", 150);
        Product product3 = new Product(7, "автомобиль", 1000_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        Assertions.assertThrows(NotFoundException.class,
                () -> repo.remove(4)
                );
    }

}
