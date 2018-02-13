package be.chillworld.model;

/**
 *
 * @author chillworld
 */
public class Item {
    private double price;
    private String name, brand;
    private int quantity;

    public Item() {
    }

    public Item(double price, String name, String brand, int quantity) {
        this.price = price;
        this.name = name;
        this.brand = brand;
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
