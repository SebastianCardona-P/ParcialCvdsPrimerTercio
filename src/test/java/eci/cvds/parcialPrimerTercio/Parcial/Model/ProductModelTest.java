package eci.cvds.parcialPrimerTercio.Parcial.Model;

import eci.cvds.parcialPrimerTercio.Parcial.Service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ProductModelTest {

    private ProductModel product;


    @BeforeEach
    public void setup(){
        product = new ProductModel("Camiseta manga larga",5000,7,"Camisetas");
    }

    @Test
    void shouldGetNameOfProduct() {
        assertEquals("Camiseta manga larga", product.getName());
    }

    @Test
    void shouldGetCorrectNameOfProduct() {
        assertNotEquals("Camiseta manga corta", product.getName());
    }

    @Test
    void shouldGetPriceOfProduct() {
        assertEquals(5000, product.getPrice());
    }

    @Test
    void shouldGetCorrectPriceOfProduct() {
        assertNotEquals(6000, product.getPrice());
    }

    @Test
    void shouldGetStockOfProduct() {
        assertEquals(7, product.getStock());
    }

    @Test
    void shouldGetCorrectStockOfProduct() {
        assertNotEquals(6000, product.getStock());
    }

    @Test
    void shouldGetCategoryOfProduct() {
        assertEquals("Camisetas", product.getCategory());
    }

    @Test
    void shouldGetCorrectCategoryOfProduct() {
        assertNotEquals("Camiseta manga corta", product.getCategory());
    }

    @Test
    void shouldSetNameOfProduct() {
        product.setName("Camiseta manga corta");
        assertEquals("Camiseta manga corta", product.getName());
    }

    @Test
    void shouldSetPriceOfProduct() {
        product.setPrice(10000);
        assertEquals(10000, product.getPrice());
    }

    @Test
    void shouldSetStockOfProduct() {
        product.setStock(10);
        assertEquals(10, product.getStock());
    }

    @Test
    void shouldSetCategoryOfProduct() {
        product.setCategory("Pantalones");
        assertEquals("Pantalones", product.getCategory());
    }

}
