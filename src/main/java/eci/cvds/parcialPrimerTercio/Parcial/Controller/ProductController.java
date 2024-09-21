package eci.cvds.parcialPrimerTercio.Parcial.Controller;

import eci.cvds.parcialPrimerTercio.Parcial.Model.ProductModel;
import eci.cvds.parcialPrimerTercio.Parcial.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;


    /**
     * Method that return all existing products
     * @return
     */
    @GetMapping("/getAll")
    public HashMap<String, ProductModel> getAllProducts(){
        try {
            return productService.getProducts();
        } catch (Exception e) {
            throw new RuntimeException("No hay productos");
        }
    }

    /**
     * method that return a product by its name
     * @param product
     * @return
     */
    @PostMapping("/add")
    public ResponseEntity<?> saveProduct(@RequestBody ProductModel product){
        return ResponseEntity.status(HttpStatus.OK).body(productService.addProduct(product));
    }

    /**
     * Method that update the stock of a product
     * @param name
     * @param stock
     * @return
     */
    @PutMapping("/update/{name}/{stock}")
    public ResponseEntity<?> updateProduct(@PathVariable String name, @PathVariable int stock){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(productService.updateProduct(name,stock));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
        }
    }

    /**
     * Method that delete a product by its name
     * @param name
     * @return
     */
    @DeleteMapping("/delete/{name}")
    public ResponseEntity<?> deleteProduct(@PathVariable String name){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(productService.deleteProduct(name));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
        }
    }
}
