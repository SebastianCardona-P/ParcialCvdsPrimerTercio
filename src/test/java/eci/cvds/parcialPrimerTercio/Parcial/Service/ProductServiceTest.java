package eci.cvds.parcialPrimerTercio.Parcial.Service;

import eci.cvds.parcialPrimerTercio.Parcial.Model.ProductModel;
import eci.cvds.parcialPrimerTercio.Parcial.Service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ProductServiceTest {

    private ProductService productService;

    @BeforeEach
    public void setup(){
        productService = new ProductService();

    }

    @Test
    void getProductsThrowsExceptionWhenNoProductsExist() {
        ProductService productService = new ProductService();
        assertThrows(RuntimeException.class, productService::getProducts);
    }

    @Test
    void getProductsReturnsAllProducts() {
        ProductService productService = new ProductService();
        ProductModel product = new ProductModel("Product1", 10, 5, "Category1");
        productService.addProduct(product);
        assertEquals(1, productService.getProducts().size());
    }

    @Test
    void addProductThrowsExceptionWhenProductIsNull() {
        ProductService productService = new ProductService();
        assertThrows(RuntimeException.class, () -> productService.addProduct(null));
    }

    @Test
    void addProductThrowsExceptionWhenProductAlreadyExists() {
        ProductService productService = new ProductService();
        ProductModel product = new ProductModel("Product1", 10, 5, "Category1");
        productService.addProduct(product);
        assertThrows(RuntimeException.class, () -> productService.addProduct(product));
    }

    @Test
    void addProductSuccessfully() {
        ProductService productService = new ProductService();
        ProductModel product = new ProductModel("Product1", 10, 5, "Category1");
        assertTrue(productService.addProduct(product));
    }

    @Test
    void updateProductThrowsExceptionWhenProductDoesNotExist() {
        ProductService productService = new ProductService();
        assertThrows(RuntimeException.class, () -> productService.updateProduct("NonExistentProduct", 10));
    }

    @Test
    void updateProductThrowsExceptionWhenStockIsNegative() {
        ProductService productService = new ProductService();
        ProductModel product = new ProductModel("Product1", 10, 5, "Category1");
        productService.addProduct(product);
        assertThrows(RuntimeException.class, () -> productService.updateProduct("Product1", -5));
    }

    @Test
    void updateProductSuccessfully() {
        ProductService productService = new ProductService();
        ProductModel product = new ProductModel("Product1", 10, 5, "Category1");
        productService.addProduct(product);
        assertTrue(productService.updateProduct("Product1", 20));
    }

    @Test
    void deleteProductThrowsExceptionWhenProductDoesNotExist() {
        ProductService productService = new ProductService();
        assertThrows(RuntimeException.class, () -> productService.deleteProduct("NonExistentProduct"));
    }

    @Test
    void deleteProductSuccessfully() {
        ProductService productService = new ProductService();
        ProductModel product = new ProductModel("Product1", 10, 5, "Category1");
        productService.addProduct(product);
        assertTrue(productService.deleteProduct("Product1"));
    }

}
