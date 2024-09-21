package eci.cvds.parcialPrimerTercio.Parcial.Controller;
import eci.cvds.parcialPrimerTercio.Parcial.Model.ProductModel;
import eci.cvds.parcialPrimerTercio.Parcial.Service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PordurctControllerTest {

    private ProductService productService;
    private ProductModel product;
    private ProductController productController;

    @BeforeEach
    public void setup(){
        productService = new ProductService();
        product = new ProductModel("Product1", 10, 5, "Category1");
        productController = new ProductController();
    }


    @Test
    void addProductThrowsExceptionWhenProductIsNull() {
        assertThrows(RuntimeException.class, () -> productController.addProduct(null));
    }



    @Test
    void getAllProductsThrowsExceptionWhenNoProductsExist() {
        assertThrows(RuntimeException.class, productController::getAllProducts);
    }

}

