package fr.bordeaux.miage.s7.poo.td3;

import java.util.Objects;
import java.util.UUID;

public class Product {
    private String name;
    private double price;
    private UUID uuid;

    public Product(String name, double price){
        this.uuid = UUID.randomUUID();
        this.name = name;
        this.price = price;
    }

    public Product(UUID uuid, String name, double price){
        this.uuid = uuid;
        this.name = name;
        this.price = price;
    }

    public boolean isProductEquals(Product otherProduct){
        return otherProduct.getProductName().equals(this.getProductName()) && otherProduct.getProductPrice() == this.getProductPrice();
    }

    @Override 
    public boolean equals(Object obj){
        if (obj instanceof Product){
            Product otherProduct = (Product) obj;
            return isProductEquals(otherProduct);
        } else
            return false;
        }

    @Override
    public int hashCode(){
        return Objects.hash(this.getProductName(), this.getProductPrice());
    }

    public UUID getProductUuid(){
        return uuid;
    }

    public String getProductName(){
        return name;
    }
    
    public double getProductPrice(){
        return price;
    }
}
