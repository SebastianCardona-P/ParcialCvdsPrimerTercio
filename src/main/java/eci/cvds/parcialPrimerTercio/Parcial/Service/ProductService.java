package eci.cvds.parcialPrimerTercio.Parcial.Service;

import eci.cvds.parcialPrimerTercio.Parcial.Model.AgentAlert;
import eci.cvds.parcialPrimerTercio.Parcial.Model.AgenLog;
import eci.cvds.parcialPrimerTercio.Parcial.Model.ProductModel;
import eci.cvds.parcialPrimerTercio.Parcial.Model.Subscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ProductService {

    private HashMap<String, ProductModel> products;

    private List<Subscriber> subscribers = new ArrayList<>();

    /**
     * Constructor of the class
     */
    @Autowired
    public ProductService(AgenLog logAgent, AgentAlert alertAgent) {
        this.subscribers.add(logAgent);
        this.subscribers.add(alertAgent);
        products = new HashMap<>();
    }

    /**
     * Method that reurn all exsisitng products
     *
     * @return HashMap<String, ProductModel> with all products
     */
    public HashMap<String, ProductModel> getProducts() {
        if (products.isEmpty()) {
            throw new RuntimeException("No hay productos");
        }
        return products;
    }

    /**
     * Method that add a product to the list
     *
     * @param product ProductModel to add
     * @return boolean that indicates if the product was added
     */
    public boolean addProduct(ProductModel product) {
        if (product == null) {
            throw new RuntimeException("The product Don´t exists");
        }
        if (products.get(product.getName()) != null) {
            throw new RuntimeException("The product already exists");
        }

        products.put(product.getName(), product);
        return true;
    }

    /**
     * Method that update the stock of a product
     * @param nameProduct String with the name of the product
     * @param stock int with the new quantity
     * @return boolean that indicates if the stock was updated
     */
    public boolean updateProduct(String nameProduct, int stock){
        if(products.get(nameProduct) == null){
            throw new RuntimeException("The product Don´t exists");
        }else if(stock < 0){
            throw new RuntimeException("You can´t have a negative stock");
        }
        products.get(nameProduct).setStock(stock);
        for(Subscriber sub: subscribers){
            sub.notifyChange(products.get(nameProduct).getName(),stock);
        }
        return true;
    }

    /**
     * Method that delete a product from the list
     * @param name String with the name of the product
     * @return boolean that indicates if the product was deleted
     */
    public boolean deleteProduct(String name) {
        if (products.get(name) == null) {
            throw new RuntimeException("The product Don´t exists");
        }
        products.remove(name);
        return true;
    }

    public Subscriber[] getSubscribers() {
        return subscribers.toArray(new Subscriber[0]);
    }
}