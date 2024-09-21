package eci.cvds.parcialPrimerTercio.Parcial.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductModel {

    private String name;
    private double price;
    private int stock;

    private String category;


    /**
     * Constructor of the class
     * @param name
     * @param price
     * @param stock
     * @param category
     *
     */
    public ProductModel(String name, double price, int stock, String category) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.category = category;
    }

    /**
     * Get the name of the product
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Get the stock of the product
     * @param stock
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Get the stock of the product
     * @return
     */
    public int getStock() {
        return stock;
    }

    /**
     * Get the price of the product
     * @return
     */
    public double getPrice() {
        return price;
    }

    /**
     * Get the category of the product
     * @return
     */
    public String getCategory() {
        return category;
    }

    /**
     * Set the category of the product
     * @param category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Set the price of the product
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }
}
